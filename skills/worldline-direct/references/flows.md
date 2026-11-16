# Integration flows

Steps and code for each integration method of Worldline Direct, for the Java SDK.
The client setup is in `java.md`. In the code, the order store stands for your own database code; replace
it.

Contents:

- Decision guide
- Hosted Checkout
- Payment attempt and idempotence key (server-to-server, Hosted Tokenization, Hosted Fields, client integration)
- Handling a CreatePayment response (server-to-server, Hosted Tokenization, Hosted Fields, client integration)
- Server-to-server
- Hosted Tokenization
- Hosted Fields
- Client integration
- Payment Links
- After-payment operations: capture, refund, cancel
- Recurring payments
- Payment status

## Decision guide

1. Does the user want the least work and no card data on their servers? Use **Hosted Checkout**.
2. Must the card form be part of their own checkout page? Use **Hosted Tokenization** (one iframe) or
   **Hosted Fields** (one field per iframe, more styling control).
3. Is it a native mobile app, or must the form be fully their own? Use **Client integration**.
4. Is the payer not on a checkout page at all (invoice, email, call centre)? Use **Payment Links**.
5. Do they already hold card data under PCI DSS SAQ D, or charge a stored token? Use **Server-to-server**.
6. Subscriptions and other charges without the customer: first payment with one of the methods above, later charges
   as in **Recurring payments**.

Card payments created from your server (all methods except Hosted Checkout and Payment Links) need 3-D Secure data:
the customer's browser details and a return URL.

## Hosted Checkout

The customer pays on a page hosted by the platform. Your server creates a session, redirects the customer, and reads
the result when the customer comes back.

1. Create the session with the amount, your order reference and a return URL that contains your own order reference.
   Build the return URL from configuration: an absolute public base URL of your shop, checked at startup. Never
   build it from the request's `Host` header, which the sender controls. Escape the order reference in the query
   string. The platform rejects a `returnUrl` without a protocol but does not check that it points to your shop, so
   check your base URL yourself. The order reference (`merchantReference`) is at most 40 characters; a longer one is
   rejected with a 400.
2. Store `HostedCheckoutId` and `RETURNMAC` with the order after the call (mandatory rule 2).
3. Redirect the customer to `redirectUrl` exactly as returned (mandatory rule 3). Do not open it in an iframe.
   It is valid for the session timeout: 3 hours by default (`sessionTimeout`, 1 to 1440 minutes).

```java
// Returns the URL to redirect the customer to.
public String startCheckout(String orderId, long amountInCents, String currencyCode) throws InterruptedException {
    CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequest()
            .withOrder(new Order()
                    .withAmountOfMoney(new AmountOfMoney().withAmount(amountInCents).withCurrencyCode(currencyCode))
                    .withReferences(new OrderReferences().withMerchantReference(orderId)))
            .withHostedCheckoutSpecificInput(new HostedCheckoutSpecificInput()
                    .withReturnUrl(buildReturnUrl(orderId))
                    .withLocale("en-GB"));

    CreateHostedCheckoutResponse response = createHostedCheckoutWithRetry(request);

    // Store both values with the order before the customer leaves your site.
    orders.saveHostedCheckout(orderId, response.getHostedCheckoutId(), response.getRETURNMAC());

    // Redirect to this URL exactly as returned. Do not build it from getPartialRedirectUrl().
    return response.getRedirectUrl();
}

// The base URL comes from your configuration, never from the Host header of the request, which the sender
// controls. "/return" is the path of your return handler. Escape the order reference for the query string.
String buildReturnUrl(String orderId) {
    String base = publicBaseUrl.endsWith("/") ? publicBaseUrl.substring(0, publicBaseUrl.length() - 1) : publicBaseUrl;
    try {
        return base + "/return?orderId=" + URLEncoder.encode(orderId, "UTF-8");
    } catch (UnsupportedEncodingException e) {
        throw new IllegalStateException(e); // UTF-8 is always supported
    }
}
```

If the create call got no answer, or failed with an error marked `retriable`, send it again.
`CreateHostedCheckout` does not support idempotent requests (mandatory rule 1), so send no idempotence key: every
resend creates a new session. That is harmless until the customer pays in it; the unused session expires. The
waiting happens inside the customer's request, so the browser waits too: keep the attempts few and the delays
short.

```java
// CreateHostedCheckout does not support idempotent requests: the platform ignores an idempotence key, so every
// resend creates a new session. That is harmless until the customer pays in it; the unused session expires.
// Send it again after no answer or after an error marked retriable. The waiting happens inside the customer's
// request, so the browser waits too: keep the attempts few and the delays short, or move the call to a
// background job.
CreateHostedCheckoutResponse createHostedCheckoutWithRetry(CreateHostedCheckoutRequest request)
        throws InterruptedException {
    for (int attempt = 1; ; attempt++) {
        try {
            return merchantClient.hostedCheckout().createHostedCheckout(request);
        } catch (CommunicationException e) {
            // No answer (timeout, connection error).
            if (attempt >= 3) {
                throw e;
            }
            Thread.sleep(1000L * attempt);
        } catch (ApiException e) {
            // The error of a Hosted Checkout call is a plain error response (error ID and errors), so logging
            // it is fine here; log at least the error ID, status and error codes.
            LOGGER.warning("createHostedCheckout failed, errorId " + e.getErrorId() + ", status " + e.getStatusCode()
                    + ": " + e.getErrors().stream()
                    .map(error -> error.getErrorCode() + " " + error.getPropertyName())
                    .collect(Collectors.joining("; ")));
            boolean retriable = e.getErrors().stream().anyMatch(error -> Boolean.TRUE.equals(error.getRetriable()));
            if (attempt >= 3 || !retriable) {
                throw e; // other errors reach the caller
            }
            // Marked retriable: the request was not processed. Send it again.
            Thread.sleep(1000L * attempt);
        }
    }
}
```

4. When the customer comes back, the platform appends `RETURNMAC` and `hostedCheckoutId` to the query string of your
   return URL, e.g. `https://shop.example/return?orderId=123&RETURNMAC=37159fa4-...&hostedCheckoutId=4501638561`. Load the
   stored values for the order and compare them in constant time: if `RETURNMAC` is missing or differs from the
   stored value, the request does not belong to this checkout; reject it and do not change the order.
5. Then call `GetHostedCheckout` to read the result. `status` is `PAYMENT_CREATED`, `IN_PROGRESS` or
   `CANCELLED_BY_CONSUMER`. When a payment was created, use its status as described in "Payment status". The created
   payment output also carries a payment status category (`paymentStatusCategory`: `SUCCESSFUL`, `REJECTED` or
   `STATUS_UNKNOWN`); decide on the payment's `statusOutput`, as everywhere else. `CANCELLED_BY_CONSUMER` means the
   customer cancelled or the session expired. For an expired session the created payment output holds a cancelled
   payment with the error id `CANCELLED_BY_EXPIRATION`; the order is cancelled. A session can hold several payment
   attempts (`<id>_0`, `<id>_1`, ...) that belong to one payment; `GetHostedCheckout` returns the latest attempt
   (see "Process" in `webhooks.md`).
6. Customers can close the browser before returning. The webhooks (see `webhooks.md`) cover that case.
   `GetHostedCheckout` can also fail with a not-found error (the API reference documents a 404 for this call). Then
   read the payment with `GetPaymentDetails` and the payment ID that your webhook handler stored. If no payment ID
   is stored yet, keep the order pending and let the webhook or your reconciliation job settle it; do not mark it
   failed. Handle only the not-found error this way; let other errors reach the caller. An expired session is not an
   error: `GetHostedCheckout` answers it with `CANCELLED_BY_CONSUMER` (step 5).

```java
// Called when the customer comes back on your return URL.
public OrderPaymentState handleReturn(String orderId, String returnMacFromQuery) {
    OrderStore.StoredHostedCheckout stored = orders.getHostedCheckout(orderId);

    // The platform appends RETURNMAC to the return URL. It identifies the returning customer:
    // a missing or different value means the request does not belong to this checkout.
    if (!returnMacMatches(returnMacFromQuery, stored.getReturnMac())) {
        throw new IllegalStateException("RETURNMAC does not match the stored value for order " + orderId);
    }

    // Never trust the redirect alone: read the result from the platform.
    GetHostedCheckoutResponse hostedCheckout;
    try {
        hostedCheckout = merchantClient.hostedCheckout().getHostedCheckout(stored.getHostedCheckoutId());
    } catch (ReferenceException e) {
        // The API reference documents a 404 for this call. If it fails with not found, read the payment
        // instead, with the payment ID that your webhook handler stored. Other errors reach the caller,
        // including the 409 and 410 that the SDK also raises as ReferenceException.
        if (e.getStatusCode() != 404) {
            throw e;
        }
        LOGGER.warning("getHostedCheckout failed, errorId " + e.getErrorId() + ", status " + e.getStatusCode());
        if (orders.getPaymentId(orderId) == null) {
            // No payment ID yet: do not mark the order failed. The webhook or your reconciliation job settles it.
            return OrderPaymentState.PENDING;
        }
        return paymentStatus.refreshPaymentState(orderId);
    }

    if ("PAYMENT_CREATED".equals(hostedCheckout.getStatus())) {
        PaymentResponse payment = hostedCheckout.getCreatedPaymentOutput().getPayment();
        orders.savePaymentId(orderId, payment.getId());
        OrderPaymentState state = PaymentStatusExample.toOrderState(payment.getStatus(), payment.getStatusOutput());
        orders.saveState(orderId, state);
        return state;
    }
    if ("CANCELLED_BY_CONSUMER".equals(hostedCheckout.getStatus())) {
        // The customer cancelled, or the session expired (the created payment is then cancelled with the
        // error id CANCELLED_BY_EXPIRATION).
        orders.saveState(orderId, OrderPaymentState.CANCELLED);
        return OrderPaymentState.CANCELLED;
    }
    // IN_PROGRESS: the customer has not finished. A webhook will report the result.
    return OrderPaymentState.PENDING;
}

// Constant-time comparison (MessageDigest.isEqual), so the time taken does not reveal how much matched.
private static boolean returnMacMatches(String fromQuery, String stored) {
    if (fromQuery == null || fromQuery.isEmpty() || stored == null || stored.isEmpty()) {
        return false;
    }
    return MessageDigest.isEqual(fromQuery.getBytes(StandardCharsets.UTF_8), stored.getBytes(StandardCharsets.UTF_8));
}
```

## Payment attempt and idempotence key

Server-to-server, Hosted Tokenization, Hosted Fields and client integration all create the payment with a
`CreatePayment` call, which needs an idempotence key (mandatory rule 1). For `CreatePayment` one operation is one
payment attempt:

- Start an attempt when the customer begins to pay, for example when you show the payment form. Create the key and
  store it with the order before the first `CreatePayment` call.
- The request that creates the payment reads the stored key. A double submit, a retry after a timeout and a restart
  then send the same key, so the platform does not create a second payment: it returns the first result, or 409
  while the first request is still running (see `errors.md`).
- Start a new attempt before the customer tries again after a decline or a rejected request. With the old key the
  platform returns the old answer, even when the request is different.

```java
// One idempotence key per payment attempt, stored with the order.
public final class PaymentAttempt {

    private PaymentAttempt() {
    }

    // Call start when the customer begins to pay, for example when you show the payment form, and again
    // before a new attempt after a decline or a rejected request. It stores the key before any
    // createPayment call.
    public static String start(String orderId, OrderStore orders) {
        String key = UUID.randomUUID().toString();
        orders.saveIdempotenceKey(orderId, key);
        return key;
    }

    // The request that creates the payment reads the stored key. A double submit, a retry after a timeout
    // and a restart then send the same key, so the platform does not create a second payment.
    public static String keyFor(String orderId, OrderStore orders) {
        String key = orders.getIdempotenceKey(orderId);
        if (key == null) {
            throw new IllegalStateException("No payment attempt was started for order " + orderId);
        }
        return key;
    }
}
```

## Handling a CreatePayment response

Server-to-server, Hosted Tokenization, Hosted Fields and client integration all end with a `CreatePayment` call.
Handle the response the same way:

- Store the payment ID with the order.
- If `merchantAction.actionType` is `REDIRECT`, redirect the customer to `merchantAction.redirectData.redirectURL`
  (3-D Secure challenge or a third-party page). When the customer comes back on your return URL, read the status with
  `GetPaymentDetails` (see "Payment status").
- Otherwise the result is already in `payment.statusOutput`.
- The other action types are not covered by the examples; the API reference describes their data:
  - `SHOW_FORM`: show the customer a form (data in `merchantAction.showFormData`); the customer's input goes back to
    the platform in a `CompletePayment` request.
  - `SHOW_INSTRUCTIONS`: show the customer the payment instructions (`merchantAction.showInstructionsData.showData`).
  - `SHOW_TRANSACTION_RESULTS`: show the customer the transaction result.
  - `MOBILE_THREEDS_CHALLENGE`: the customer completes a 3-D Secure challenge inside your mobile app; pass
    `merchantAction.mobileThreeDSecureChallengeParameters` to the EMVCo-certified Mobile SDK.
  - `CALL_THIRD_PARTY`: your server calls a third party with the data from the response.

```java
// Use for every createPayment response: server-to-server, Hosted Tokenization, Hosted Fields
// and client integration.
public static PaymentStep handle(CreatePaymentResponse response, String orderId, OrderStore orders) {
    orders.savePaymentId(orderId, response.getPayment().getId());

    if (response.getMerchantAction() != null && "REDIRECT".equals(response.getMerchantAction().getActionType())) {
        // 3-D Secure challenge or a third-party page. Redirect to the URL exactly as returned.
        // The customer comes back on your return URL; then read the status with getPaymentDetails.
        return PaymentStep.redirect(response.getMerchantAction().getRedirectData().getRedirectURL());
    }

    // No customer action needed: the result is already known.
    OrderPaymentState state = PaymentStatusExample.toOrderState(
            response.getPayment().getStatus(), response.getPayment().getStatusOutput());
    orders.saveState(orderId, state);
    return PaymentStep.done(state);
}
```

3-D Secure needs the customer's browser details in `order.customer.device`:

```java
// 3-D Secure needs details about the customer's browser. Collect the browser values with
// JavaScript on the checkout page and read the rest from the HTTP request.
public static CustomerDevice build(String acceptHeader, String userAgent, String ipAddress, BrowserInfo browser) {
    return new CustomerDevice()
            .withAcceptHeader(acceptHeader)
            .withUserAgent(userAgent)
            .withIpAddress(ipAddress)
            .withLocale(browser.getLocale())
            .withTimezoneOffsetUtcMinutes(String.valueOf(browser.getTimezoneOffsetUtcMinutes()))
            .withBrowserData(new BrowserData()
                    .withColorDepth(browser.getColorDepth())
                    .withJavaEnabled(browser.isJavaEnabled())
                    .withJavaScriptEnabled(true)
                    .withScreenHeight(String.valueOf(browser.getScreenHeight()))
                    .withScreenWidth(String.valueOf(browser.getScreenWidth())));
}
```

## Server-to-server

Your server sends the card data in `CreatePayment`. Only for merchants certified for PCI DSS SAQ D. Never log the
request (mandatory rule 6). `paymentProductId` is required with card data: without it the platform answers 400
`UNKNOWN_PRODUCT_ID`. The idempotence key is the stored key of the payment attempt (see "Payment attempt and idempotence
key").

```java
// Card data on your server puts you in scope of PCI DSS SAQ D.
// Use Hosted Tokenization or Hosted Fields unless you are certified for it.
public PaymentStep payWithCard(String orderId, long amountInCents, String currencyCode, int paymentProductId,
                               CardInput card, CustomerDevice device, String returnUrl) {
    CreatePaymentRequest request = new CreatePaymentRequest()
            .withOrder(new Order()
                    .withAmountOfMoney(new AmountOfMoney().withAmount(amountInCents).withCurrencyCode(currencyCode))
                    .withReferences(new OrderReferences().withMerchantReference(orderId))
                    .withCustomer(new Customer().withDevice(device)))
            .withCardPaymentMethodSpecificInput(new CardPaymentMethodSpecificInput()
                    // e.g. 1 = Visa, 3 = Mastercard.
                    .withPaymentProductId(paymentProductId)
                    .withCard(new Card()
                            .withCardNumber(card.getNumber())
                            .withCardholderName(card.getHolderName())
                            .withExpiryDate(card.getExpiryDate())
                            .withCvv(card.getCvv()))
                    // SALE: authorised and captured at once. Acquirers that do not support it ignore it.
                    // FINAL_AUTHORIZATION: capture the full amount within 7 days.
                    // PRE_AUTHORIZATION: can be reversed; capture the authorised amount or less within 30 days.
                    .withAuthorizationMode("SALE")
                    .withThreeDSecure(new ThreeDSecure()
                            .withRedirectionData(new RedirectionData().withReturnUrl(returnUrl))));

    CallContext context = new CallContext().withIdempotenceKey(PaymentAttempt.keyFor(orderId, orders));
    CreatePaymentResponse response = merchantClient.payments().createPayment(request, context);
    return CreatePaymentResponseHandler.handle(response, orderId, orders);
}
```

If the payment is declined, the SDK reports a declined-payment error that holds the created payment; see `errors.md`.

## Hosted Tokenization

The card form is an iframe from the platform on your checkout page. Your server never sees the card data.

1. Server: create a session and send `hostedTokenizationUrl` and `sri` to the page.

```java
// Creates the session for the card form iframe on your checkout page.
public CreateHostedTokenizationResponse createSession() {
    CreateHostedTokenizationRequest request = new CreateHostedTokenizationRequest()
            .withLocale("en-GB");
    // Optional: .withVariant("MyTemplate.html"), the file name of a custom template.

    CreateHostedTokenizationResponse response = merchantClient.hostedTokenization().createHostedTokenization(request);

    // Send response.getHostedTokenizationUrl() (iframe URL) and response.getSri() (script integrity) to the page.
    return response;
}
```

2. Page: load `tokenizer.min.js` from the platform (not from your own server) with the `sri` value as `integrity`,
   create a `Tokenizer` with the `hostedTokenizationUrl` and the ID of the `div` for the iframe, and call
   `initialize()`. When the customer pays, call `submitTokenization()` and post `result.hostedTokenizationId` to your
   server, together with the browser details for 3-D Secure.
3. Server: create the payment with the `hostedTokenizationId` and handle the response as described above. If
   `submitTokenization()` has not completed, the platform answers 400 with the error id
   `HOSTED_TOKENIZATION_SESSION_NOT_SUBMITTED`; an unknown id gives `HOSTED_TOKENIZATION_SESSION_NOT_FOUND`. The
   idempotence key is the stored key of the payment attempt (see "Payment attempt and idempotence key").

```java
// The page calls tokenizer.submitTokenization() and posts result.hostedTokenizationId to your server.
public PaymentStep pay(String orderId, String hostedTokenizationId, long amountInCents, String currencyCode,
                       CustomerDevice device, String returnUrl) {
    CreatePaymentRequest request = new CreatePaymentRequest()
            .withHostedTokenizationId(hostedTokenizationId)
            .withOrder(new Order()
                    .withAmountOfMoney(new AmountOfMoney().withAmount(amountInCents).withCurrencyCode(currencyCode))
                    .withReferences(new OrderReferences().withMerchantReference(orderId))
                    .withCustomer(new Customer().withDevice(device)))
            .withCardPaymentMethodSpecificInput(new CardPaymentMethodSpecificInput()
                    .withAuthorizationMode("SALE")
                    .withThreeDSecure(new ThreeDSecure()
                            .withRedirectionData(new RedirectionData().withReturnUrl(returnUrl))));

    CallContext context = new CallContext().withIdempotenceKey(PaymentAttempt.keyFor(orderId, orders));
    CreatePaymentResponse response = merchantClient.payments().createPayment(request, context);
    return CreatePaymentResponseHandler.handle(response, orderId, orders);
}
```

## Hosted Fields

Each card field (card number, cardholder name, card brands, expiry date, CVV) is a separate iframe that you place in
your page and customise with CSS.

1. Server: create a session (`locale` is required) and send `sdkUrl`, `sdkSri` and `sessionData` to the page. Pass
   `sessionData` on unchanged.

```java
// Creates the session that the Hosted Fields script on your checkout page needs.
public CreateHostedFieldsSessionResponse createSession(String checkoutPageOrigin) {
    CreateHostedFieldsSessionRequest request = new CreateHostedFieldsSessionRequest()
            .withLocale("en-GB")
            // The origin of your checkout page, e.g. https://shop.example
            .withOrigin(checkoutPageOrigin);

    CreateHostedFieldsSessionResponse response = merchantClient.hostedFields().createHostedFieldsSession(request);

    // Send getSdkUrl(), getSdkSri() and getSessionData() to the page. Pass the session data on unchanged.
    return response;
}
```

2. Page: load the script from `sdkUrl` with `sdkSri` as `integrity` and `crossorigin="anonymous"`. Create the Hosted
   Fields instance with `sessionData` and the IDs of your field containers. On submit call `tokenize(storeToken)`;
   `true` stores the card for later use and needs the customer's consent. Then tell your server to pay.
3. Server: create the payment with the `hostedFieldsSessionId` and handle the response as described above. The
   session response has the ID at its top level and, with the same value, inside `sessionData`. If `tokenize()` has not
   completed, the platform answers 400 with the error id `HOSTED_FIELDS_SESSION_NOT_SUBMITTED` (property
   `hostedFieldsSessionId`). The idempotence key is the stored key of the payment attempt (see "Payment attempt and
   idempotence key").

```java
// The page calls tokenize() and tells your server the card is ready.
// hostedFieldsSessionId is getHostedFieldsSessionId() of the createSession response; getSessionData().getHostedFieldsSessionId() holds the same value.
public PaymentStep pay(String orderId, String hostedFieldsSessionId, long amountInCents, String currencyCode,
                       CustomerDevice device, String returnUrl) {
    CreatePaymentRequest request = new CreatePaymentRequest()
            .withHostedFieldsSessionId(hostedFieldsSessionId)
            .withOrder(new Order()
                    .withAmountOfMoney(new AmountOfMoney().withAmount(amountInCents).withCurrencyCode(currencyCode))
                    .withReferences(new OrderReferences().withMerchantReference(orderId))
                    .withCustomer(new Customer().withDevice(device)))
            .withCardPaymentMethodSpecificInput(new CardPaymentMethodSpecificInput()
                    .withAuthorizationMode("SALE")
                    .withThreeDSecure(new ThreeDSecure()
                            .withRedirectionData(new RedirectionData().withReturnUrl(returnUrl))));

    CallContext context = new CallContext().withIdempotenceKey(PaymentAttempt.keyFor(orderId, orders));
    CreatePaymentResponse response = merchantClient.payments().createPayment(request, context);
    return CreatePaymentResponseHandler.handle(response, orderId, orders);
}
```

## Client integration

A Client SDK (JavaScript, iOS, Android, Flutter, ...) encrypts the card data on the customer's device. Your server
creates the session and the payment.

1. Server: create a client session and send its values to the app. The API key never leaves your server.

```java
// Creates the session that a Client SDK (JavaScript, iOS, Android, Flutter...) needs to encrypt card data.
public SessionResponse createClientSession() {
    SessionResponse session = merchantClient.sessions().createSession(new SessionRequest());

    // Send getClientSessionId(), getCustomerId(), getClientApiUrl() and getAssetUrl() to the app.
    // Never send your API key.
    return session;
}
```

2. App: initialise the Client SDK with the session, collect the card data, and create the encrypted customer input.
   Post that string to your server. Client SDK documentation:
   https://docs.direct.worldline-solutions.com/en/integration/how-to-integrate/client-sdks/javascript
3. Server: create the payment with `encryptedCustomerInput` and handle the response as described above. The string
   holds encrypted card data and can be submitted only once: do not store it. It is at most 5000 characters. A string
   the platform cannot read is a 400 with the error id `INVALID_CONSUMER_INPUT_ENCRYPTION`. The idempotence key is the
   stored key of the payment attempt (see "Payment attempt and idempotence key").

```java
// The Client SDK returns an encrypted string; the app posts it to your server.
public PaymentStep pay(String orderId, String encryptedCustomerInput, long amountInCents, String currencyCode,
                       CustomerDevice device, String returnUrl) {
    CreatePaymentRequest request = new CreatePaymentRequest()
            .withEncryptedCustomerInput(encryptedCustomerInput)
            .withOrder(new Order()
                    .withAmountOfMoney(new AmountOfMoney().withAmount(amountInCents).withCurrencyCode(currencyCode))
                    .withReferences(new OrderReferences().withMerchantReference(orderId))
                    .withCustomer(new Customer().withDevice(device)))
            .withCardPaymentMethodSpecificInput(new CardPaymentMethodSpecificInput()
                    .withAuthorizationMode("SALE")
                    .withThreeDSecure(new ThreeDSecure()
                            .withRedirectionData(new RedirectionData().withReturnUrl(returnUrl))));

    CallContext context = new CallContext().withIdempotenceKey(PaymentAttempt.keyFor(orderId, orders));
    CreatePaymentResponse response = merchantClient.payments().createPayment(request, context);
    return CreatePaymentResponseHandler.handle(response, orderId, orders);
}
```

## Payment Links

The platform hosts the payment page behind a link that you send to the customer.

1. Create the link with the amount, your order reference and an expiry date. The expiry date is required, at most
   6 months ahead, in ISO 8601 with a UTC offset (or `Z`). A missing, past or too distant date is a 400 error.
2. Store `paymentLinkId` with the order and send `redirectionUrl` as returned.
3. The `paymentlink.paid` webhook tells you that a payment was processed with the link. You can also read the link
   with `GetPaymentLinkById` (status `ACTIVE`, `PAID`, `CANCELLED` or `EXPIRED`). Once paid it holds the payment ID.
   That ID has no attempt suffix: call `GetPaymentDetails` with the ID plus `_0`, then read the payment's status
   before you decide anything (mandatory rule 5).

```java
// Returns the link to send to the customer (email, chat, invoice).
public PaymentLinkResponse createLink(String orderId, long amountInCents, String currencyCode, String description) {
    CreatePaymentLinkRequest request = new CreatePaymentLinkRequest()
            .withOrder(new Order()
                    .withAmountOfMoney(new AmountOfMoney().withAmount(amountInCents).withCurrencyCode(currencyCode))
                    .withReferences(new OrderReferences().withMerchantReference(orderId)))
            .withPaymentLinkSpecificInput(new PaymentLinkSpecificInput()
                    .withDescription(description)
                    // Required. At most 6 months in the future.
                    .withExpirationDate(ZonedDateTime.now().plusDays(7)));

    // CreatePaymentLink does not support idempotent requests, so no idempotence key is sent.
    PaymentLinkResponse link = merchantClient.paymentLinks().createPaymentLink(request);

    // Store link.getPaymentLinkId() with the order. Send link.getRedirectionUrl() exactly as returned.
    // The paymentlink.paid webhook (or getPaymentLinkById) tells you when it is paid.
    // Once paid, the link's getPaymentId() has no attempt suffix: use it with "_0" appended in
    // GetPaymentDetails, and read the payment's status.
    return link;
}
```

## After-payment operations

Pass an idempotence key to every capture, refund and cancel. Create it once per operation; retry rules are in `errors.md`.
Sending the same request again with the same key returns the first result and does not run the operation twice.

**Capture.** Only for payments that are authorized and not captured: status `PENDING_CAPTURE`, status category
`PENDING_MERCHANT`. A payment with authorization mode `FINAL_AUTHORIZATION` must be captured for the full amount within
7 days. One with `PRE_AUTHORIZATION` can be captured within 30 days, also for less than the authorized amount. Without
an amount, the full amount is captured and the capture is final; `isFinal` true also makes a capture final. After a
final capture no further capture is accepted, and an amount above the authorized amount is rejected. A capture that is
not final leaves the payment in `PENDING_CAPTURE`. The capture response has status `CAPTURE_REQUESTED`. The capture is
done when its operation (for a final capture, the payment) reads `CAPTURED`, which does not happen immediately: check
again later.

```java
// Captures an authorized payment (status PENDING_CAPTURE). Without an amount, the full amount is captured.
public CaptureResponse capture(String paymentId, long amountInCents, boolean isFinal, String idempotenceKey) {
    PaymentDetailsResponse details = merchantClient.payments().getPaymentDetails(paymentId);
    if (!"PENDING_CAPTURE".equals(details.getStatus())) {
        throw new IllegalStateException("Payment " + paymentId + " cannot be captured in status " + details.getStatus());
    }

    CapturePaymentRequest request = new CapturePaymentRequest()
            .withAmount(amountInCents)
            // true: this capture is final, no further capture is accepted.
            .withIsFinal(isFinal);
    CallContext context = new CallContext().withIdempotenceKey(idempotenceKey);
    return merchantClient.payments().capturePayment(paymentId, request, context);
}
```

**Refund.** Only when `statusOutput.isRefundable` is true (the payment is captured; the flag is false while the status
is `CAPTURE_REQUESTED`). Several refunds, partial or full, are allowed on one payment as long as their total does not
exceed the amount paid; a refund above the remaining amount is rejected. A refund is `REFUND_REQUESTED` while the
platform waits for the result and then becomes `REFUNDED` or `REJECTED`. Check the refund `status`; only `REFUNDED` is
done. The payment becomes `REFUNDED` only when the full amount is refunded. A partly refunded payment stays
`COMPLETED`; its operations list the refunds.

```java
// Refunds a captured payment, fully or partly.
public RefundResponse refund(String paymentId, long amountInCents, String currencyCode, String idempotenceKey) {
    PaymentDetailsResponse details = merchantClient.payments().getPaymentDetails(paymentId);
    if (details.getStatusOutput() == null || !Boolean.TRUE.equals(details.getStatusOutput().getIsRefundable())) {
        throw new IllegalStateException("Payment " + paymentId + " is not refundable in status " + details.getStatus());
    }

    RefundRequest request = new RefundRequest()
            .withAmountOfMoney(new AmountOfMoney().withAmount(amountInCents).withCurrencyCode(currencyCode));
    CallContext context = new CallContext().withIdempotenceKey(idempotenceKey);
    RefundResponse refund = merchantClient.payments().refundPayment(paymentId, request, context);

    // REFUND_REQUESTED: the platform is processing the refund and waiting for the result. The status then
    // becomes REFUNDED or REJECTED; treat the refund as done only when it is REFUNDED.
    return refund;
}
```

**Cancel.** Cancels an authorization that is not captured. Only when `statusOutput.isCancellable` is true. Without an
amount, the full amount is cancelled. The acquirer decides the result, so the payment in the response is in one of
three states:

- Status `CANCELLED`, category `UNSUCCESSFUL`, status code 6: the authorization is cancelled. This is final.
- Status `CANCELLED`, category `PENDING_MERCHANT`, status code 61 or 62: the platform is waiting for the acquirer's
  answer. This is not final; the payment moves to one of the other two states.
- Status `CANCELLATION_REJECTED`, category `UNSUCCESSFUL`, status code 63: the acquirer refused the cancel. The payment
  stays authorized: do not treat it as failed. You can try the cancel again; an authorization that is not captured
  expires.

```java
// Cancels (voids) an authorization that is not captured yet. No amount cancels the full amount.
public CancelPaymentResponse cancel(String paymentId, String idempotenceKey) {
    PaymentDetailsResponse details = merchantClient.payments().getPaymentDetails(paymentId);
    if (details.getStatusOutput() == null || !Boolean.TRUE.equals(details.getStatusOutput().getIsCancellable())) {
        throw new IllegalStateException("Payment " + paymentId + " is not cancellable in status " + details.getStatus());
    }

    CallContext context = new CallContext().withIdempotenceKey(idempotenceKey);
    return merchantClient.payments().cancelPayment(paymentId, new CancelPaymentRequest(), context);
}
```

An operation that the payment's current state does not allow (a capture after the final capture or after a cancel, a
refund before the capture or above the remaining amount, a second cancel) is answered with HTTP 400 and the error id
`ACTION_NOT_ALLOWED_ON_TRANSACTION`, without a property name. Read the payment with `GetPaymentDetails`; do not retry.

## Recurring payments

A subscription has one payment made by the customer and later charges that you start without the customer.

1. First payment: mark it as the first of a recurring series. With Hosted Checkout set
   `hostedCheckoutSpecificInput.isRecurring` to `true`; that marks the payment as the first of the series. The example
   uses Hosted Checkout and the same helpers as the Hosted Checkout flow: the return URL is built from your configured
   public base URL, and the create call uses the same retry helper. With `CreatePayment` set
   `cardPaymentMethodSpecificInput.isRecurring` to `true` and
   `cardPaymentMethodSpecificInput.recurring.recurringPaymentSequenceIndicator` to `first`.
2. When the first payment is authorised or captured (Hosted Checkout return or webhook), store its payment ID with
   the customer. The stored ID keeps working for later charges after a capture. A rejected first payment cannot be
   charged again: the subsequent payment fails with a 400 error (`ACTION_NOT_ALLOWED_ON_TRANSACTION`).

```java
// First payment of a subscription, made by the customer on the Hosted Checkout Page.
// The recurring flag marks it as the first payment of the series.
// It follows the Hosted Checkout flow: the return URL is built from your configuration and the call goes
// through the same retry helper. Handle the return as there.
public String startSubscription(String orderId, long amountInCents, String currencyCode) throws InterruptedException {
    CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequest()
            .withOrder(new Order()
                    .withAmountOfMoney(new AmountOfMoney().withAmount(amountInCents).withCurrencyCode(currencyCode))
                    .withReferences(new OrderReferences().withMerchantReference(orderId)))
            .withHostedCheckoutSpecificInput(new HostedCheckoutSpecificInput()
                    .withReturnUrl(hostedCheckout.buildReturnUrl(orderId))
                    .withIsRecurring(true));

    CreateHostedCheckoutResponse response = hostedCheckout.createHostedCheckoutWithRetry(request);
    orders.saveHostedCheckout(orderId, response.getHostedCheckoutId(), response.getRETURNMAC());
    return response.getRedirectUrl();
}

// When the first payment is authorised or captured, keep its payment ID: later charges refer to it.
public void onFirstPaymentSucceeded(String customerId, String firstPaymentId) {
    orders.saveRecurringPaymentId(customerId, firstPaymentId);
}
```

3. Later charges: call the subsequent payment operation on the first payment's ID with `subsequentType`
   `Recurring` (fixed amount, regular intervals of at most one year, started by you). The allowed values are
   `Recurring`, `Unscheduled`, `Installment`, `NoShow`, `DelayedCharge`, `PartialShipment`, `Resubmission`,
   `RecurringVariable` and `UnscheduledFixed`; any other value is a 400 error on `subsequentType`. The new payment is
   in the response (`payment`). A declined charge is reported like a declined `CreatePayment` (see `errors.md`).
   Create one idempotence key per charge and store it with the charge before the first call; retry rules are in
   `errors.md`.

```java
// Later charge started by you, without the customer (merchant-initiated).
// The caller creates ONE idempotence key per charge and stores it with the charge
// (orders.saveIdempotenceKey(orderId, key)) before the first call. Retries reuse that key as described in errors.md.
public OrderPaymentState chargeRenewal(String customerId, String orderId, long amountInCents, String currencyCode,
                                       String idempotenceKey) {
    String firstPaymentId = orders.getRecurringPaymentId(customerId);

    SubsequentPaymentRequest request = new SubsequentPaymentRequest()
            .withOrder(new Order()
                    .withAmountOfMoney(new AmountOfMoney().withAmount(amountInCents).withCurrencyCode(currencyCode))
                    .withReferences(new OrderReferences().withMerchantReference(orderId)))
            .withSubsequentcardPaymentMethodSpecificInput(new SubsequentCardPaymentMethodSpecificInput()
                    // Recurring = fixed amount, regular intervals (at most one year), started by you.
                    // Other allowed values: Unscheduled, Installment, NoShow, DelayedCharge, PartialShipment,
                    // Resubmission, RecurringVariable, UnscheduledFixed.
                    .withSubsequentType("Recurring")
                    // SALE: authorised and captured at once. Acquirers that do not support it ignore it.
                    .withAuthorizationMode("SALE"));

    CallContext context = new CallContext().withIdempotenceKey(idempotenceKey);
    SubsequentPaymentResponse response = merchantClient.subsequent().subsequentPayment(firstPaymentId, request, context);

    orders.savePaymentId(orderId, response.getPayment().getId());
    OrderPaymentState state = PaymentStatusExample.toOrderState(
            response.getPayment().getStatus(), response.getPayment().getStatusOutput());
    orders.saveState(orderId, state);
    return state;
}
```

For one-click payments with a stored card (the customer is present), see the card-on-file guide:
https://docs.direct.worldline-solutions.com/en/payment-methods-and-features/advanced-features/card-on-file/api-endpoints-and-jsons-samples

## Payment status

Read the status with `GetPaymentDetails` after a redirect back to your site, after a webhook, after a
declined-payment error, after a capture or a refund, and whenever you are unsure. `GetHostedCheckout` keeps showing
the payment as captured after a refund.

`statusOutput.statusCategory` decides the order state:

| statusCategory | Meaning | What to do |
|---|---|---|
| `COMPLETED` | Paid (captured or sale). A partly refunded payment stays `COMPLETED`. | Fulfil the order. |
| `PENDING_MERCHANT` | Authorized and waiting for a capture (status `PENDING_CAPTURE`), or a cancelled payment waiting for its final result (status `CANCELLED`). | `PENDING_CAPTURE`: capture or cancel. `CANCELLED`: wait for a webhook or check again later. |
| `PENDING_PAYMENT`, `PENDING_CONNECT_OR_3RD_PARTY`, `CREATED` | Not final: waiting for the result of 3-D Secure, an authorization, a capture (`CAPTURE_REQUESTED`) or a refund (`REFUND_REQUESTED`). | Wait for a webhook or check again later. |
| `UNSUCCESSFUL` | Declined, cancelled or failed (`status` tells which). | Do not fulfil. |
| `REFUNDED` | Fully refunded. | Update the order. |
| `REVERSED` | Reversed. | Do not treat as paid; check the payment's operations and follow up. |

`status` (`CREATED`, `CANCELLED`, `REJECTED`, `REJECTED_CAPTURE`, `REDIRECTED`, `PENDING_PAYMENT`, `PENDING_COMPLETION`,
`PENDING_CAPTURE`, `AUTHORIZATION_REQUESTED`, `CAPTURE_REQUESTED`, `CAPTURED`, `REVERSED`, `REFUND_REQUESTED`,
`REFUNDED`) and `statusCode` give more detail. `isCancellable` and `isRefundable` say whether a cancel or a refund is
possible; `isAuthorized` says that the transaction was authorized.
`statusOutput` can be missing in a response. Treat a missing `statusOutput` or `statusCategory` as not final
(pending), never as paid.
Status reference: https://docs.direct.worldline-solutions.com/en/integration/api-developer-guide/statuses

```java
public OrderPaymentState refreshPaymentState(String orderId) {
    String paymentId = orders.getPaymentId(orderId);
    PaymentDetailsResponse details = merchantClient.payments().getPaymentDetails(paymentId);

    OrderPaymentState state = toOrderState(details.getStatus(), details.getStatusOutput());
    orders.saveState(orderId, state);
    return state;
}

// Decide on statusOutput.getStatusCategory(). getStatus() and statusOutput.getStatusCode() give more detail.
public static OrderPaymentState toOrderState(String status, PaymentStatusOutput statusOutput) {
    // A response can lack statusOutput or its statusCategory. Unknown is not paid: treat it as not final.
    String category = statusOutput != null ? statusOutput.getStatusCategory() : null;
    if (category == null) {
        return OrderPaymentState.PENDING;
    }
    if ("COMPLETED".equals(category)) {
        return OrderPaymentState.PAID;
    }
    if ("PENDING_MERCHANT".equals(category)) {
        // PENDING_CAPTURE: authorized but not captured yet, capture or cancel it.
        // Any other status (CANCELLED, waiting for its final result) is not final.
        return "PENDING_CAPTURE".equals(status) ? OrderPaymentState.AUTHORIZED : OrderPaymentState.PENDING;
    }
    if ("REFUNDED".equals(category)) {
        return OrderPaymentState.REFUNDED;
    }
    if ("REVERSED".equals(category)) {
        // Not paid: do not treat the order as paid.
        return OrderPaymentState.REVERSED;
    }
    if ("UNSUCCESSFUL".equals(category)) {
        return "CANCELLED".equals(status) ? OrderPaymentState.CANCELLED : OrderPaymentState.FAILED;
    }
    // CREATED, PENDING_PAYMENT, PENDING_CONNECT_OR_3RD_PARTY: not final.
    // Wait for a webhook or check again later.
    return OrderPaymentState.PENDING;
}
```
