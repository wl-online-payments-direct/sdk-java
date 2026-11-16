# Java SDK reference

How to install and set up the Java SDK (`com.worldline-solutions:onlinepayments-sdk-java`), and the SDK calls for the API operations used in this
skill.
Source code and README: https://github.com/wl-online-payments-direct/sdk-java

## Install

Maven:

```xml
<dependency>
  <groupId>com.worldline-solutions</groupId>
  <artifactId>onlinepayments-sdk-java</artifactId>
  <version>x.y.z</version>
</dependency>
```

Gradle: `implementation "com.worldline-solutions:onlinepayments-sdk-java:x.y.z"`

The SDK runs on Java 8 and later.

## Packages

| Package | Contains |
|---|---|
| `com.onlinepayments` | `Factory`, `ClientInterface`, `CommunicatorConfiguration`, `CallContext`, the exceptions |
| `com.onlinepayments.merchant` | `MerchantClientInterface`; its sub-clients are in sub-packages such as `com.onlinepayments.merchant.payments` |
| `com.onlinepayments.domain` | All request and response classes (`CreatePaymentRequest`, `Order`, `AmountOfMoney`, ...) and `WebhooksEvent` |
| `com.onlinepayments.webhooks` | `WebhooksHelper`, `InMemorySecretKeyStore`, `SecretKeyStore`, `SignatureValidationException`, `ApiVersionMismatchException` |
| `com.onlinepayments.communication` | `RequestHeader`, `CommunicationException` |
| `com.onlinepayments.authentication` | `AuthorizationType` |
| `com.onlinepayments.json` | `DefaultMarshaller`, `MarshallerSyntaxException` |
| `com.onlinepayments.logging` | `CommunicatorLogger`, `JdkCommunicatorLogger`, `SysOutCommunicatorLogger` |

## Client setup

```java
// Read and validate every setting once at startup: a missing value then stops the application with a clear
// message instead of failing on the first payment. Take the values from your configuration or secret store.
// Environment variables are fine for local development when they are set outside the repository; never put
// the API secret in code or in a file that is committed.
//
// Create one client when the application starts (e.g. a Spring @Bean) and reuse it for every request.
// The client is thread-safe and holds the HTTP connection pool. Close it when the application stops.
public static ClientInterface createClient() {
    CommunicatorConfiguration configuration = new CommunicatorConfiguration()
            // Test or live endpoint, e.g. https://payment.direct.ecom.preprod.worldline-solutions.com
            .withApiEndpoint(URI.create(requireAbsoluteUrl("ONLINEPAYMENTS_API_ENDPOINT")))
            .withApiKeyId(requireEnv("ONLINEPAYMENTS_API_KEY_ID"))
            .withSecretApiKey(requireEnv("ONLINEPAYMENTS_API_SECRET"))
            // Required: without it Factory.createClient fails with "Unknown authorizationType".
            .withAuthorizationType(AuthorizationType.V1HMAC)
            // Timeouts in milliseconds; the defaults are 0, which means no timeout.
            .withConnectTimeout(5000)
            .withSocketTimeout(300000)
            // Your company or application name; it identifies your requests in the platform logs.
            // Mandatory: Factory.createClient throws IllegalArgumentException when it is null or blank.
            .withIntegrator(requireEnv("ONLINEPAYMENTS_INTEGRATOR"));
    return Factory.createClient(configuration);
}

// The merchant ID is your PSPID. Every API call goes through the merchant client.
public static MerchantClientInterface createMerchantClient(ClientInterface client) {
    return client.merchant(requireEnv("ONLINEPAYMENTS_MERCHANT_ID"));
}

// The absolute public base URL of your shop, e.g. https://shop.example. The return URL is built from it,
// never from the Host header of a request, which the sender controls.
public static String createPublicBaseUrl() {
    return requireAbsoluteUrl("SHOP_PUBLIC_BASE_URL");
}

static String requireEnv(String name) {
    String value = System.getenv(name);
    if (value == null || value.trim().isEmpty()) {
        throw new IllegalStateException("Missing setting " + name);
    }
    return value.trim();
}

static String requireAbsoluteUrl(String name) {
    String value = requireEnv(name);
    URI uri;
    try {
        uri = new URI(value);
    } catch (URISyntaxException e) {
        throw new IllegalStateException("Setting " + name + " is not a valid URL");
    }
    boolean httpUrl = "https".equals(uri.getScheme()) || "http".equals(uri.getScheme());
    if (!httpUrl || uri.getHost() == null) {
        throw new IllegalStateException("Setting " + name + " must be an absolute http(s) URL, e.g. https://shop.example");
    }
    return value;
}
```

- `withAuthorizationType(AuthorizationType.V1HMAC)` is required; `Factory.createClient` throws
  `IllegalStateException: Unknown authorizationType null` without it.
- The integrator is mandatory: `Factory.createClient` throws `IllegalArgumentException: integrator is required` when
  `withIntegrator(...)` is null or blank. Read it from configuration and validate it at startup.
- Set the connect and socket timeouts (the example sets both); the SDK's defaults are 0.
- In Spring, create the client in a `@Bean` method with `destroyMethod = "close"` and the merchant client in a second
  `@Bean`. `ClientInterface` and `MerchantClientInterface` are thread-safe.

## Conventions

- Calls are synchronous and return the response object. They throw unchecked exceptions (see below).
- Request and response classes use getters and setters with the API names (`order.amountOfMoney` is
  `getOrder().getAmountOfMoney()`). Each setter also has a fluent `with...` method:
  `new Order().withAmountOfMoney(new AmountOfMoney().withAmount(1000L).withCurrencyCode("EUR"))`.
- Numbers and flags are wrapper types (`Long`, `Integer`, `Boolean`) and can be `null`: compare with
  `Boolean.TRUE.equals(...)`.
- Every call has an overload with a `CallContext` as last parameter. Set the idempotence key with
  `new CallContext().withIdempotenceKey(key)`. After the call, `context.getIdempotenceRequestTimestamp()` is set if the
  platform returned the result of an earlier request with the same key.
  `createHostedCheckout` and `createPaymentLink` ignore the key: call them without a context.
- `getCreatedPaymentOutput()` of a `GetHostedCheckoutResponse` has `getPaymentStatusCategory()` next to
  `getPayment()`. Decide on `getPayment().getStatusOutput().getStatusCategory()`.
- Members marked `@Deprecated` are deprecated in the API. Use the replacement named in the Javadoc.

## API operations used in this skill

All calls start from the merchant client: `MerchantClientInterface merchant = client.merchant(merchantId)`.

| API operation | SDK call | Used in |
|---|---|---|
| CreateHostedCheckout | `merchant.hostedCheckout().createHostedCheckout(CreateHostedCheckoutRequest, context)` | Hosted Checkout, recurring payments |
| GetHostedCheckout | `merchant.hostedCheckout().getHostedCheckout(hostedCheckoutId)` | Hosted Checkout |
| CreateHostedTokenization | `merchant.hostedTokenization().createHostedTokenization(CreateHostedTokenizationRequest)` | Hosted Tokenization |
| CreateHostedFieldsSession | `merchant.hostedFields().createHostedFieldsSession(CreateHostedFieldsSessionRequest)` | Hosted Fields |
| CreateSession | `merchant.sessions().createSession(SessionRequest)` | Client integration |
| CreatePayment | `merchant.payments().createPayment(CreatePaymentRequest, context)` | Server-to-server, Hosted Tokenization, Hosted Fields, client integration |
| GetPaymentDetails | `merchant.payments().getPaymentDetails(paymentId)` | Payment status, webhooks, error handling |
| CapturePayment | `merchant.payments().capturePayment(paymentId, CapturePaymentRequest, context)` | After-payment operations |
| RefundPayment | `merchant.payments().refundPayment(paymentId, RefundRequest, context)` | After-payment operations |
| CancelPayment | `merchant.payments().cancelPayment(paymentId, CancelPaymentRequest, context)` | After-payment operations |
| SubsequentPayment | `merchant.subsequent().subsequentPayment(paymentId, SubsequentPaymentRequest, context)` | Recurring payments |
| CreatePaymentLink | `merchant.paymentLinks().createPaymentLink(CreatePaymentLinkRequest, context)` | Payment Links |
| GetPaymentLinkById | `merchant.paymentLinks().getPaymentLinkById(paymentLinkId)` | Payment Links |

For anything else, use the API reference; the SDK's sub-clients and method names match the operation names there.

## Exceptions

All are unchecked and in `com.onlinepayments` unless noted. Catch the specific ones before `ApiException`.

| Exception | When |
|---|---|
| `DeclinedPaymentException` | The error response carries a payment result: a declined payment (seen with 402 and 403), also for `subsequentPayment`. The body decides, not the status. `getCreatePaymentResponse()` holds the created payment (`.getPayment().getId()`). |
| `DeclinedRefundException` | The error response carries a refund result (the body decides, not the status). `getRefundResponse()` holds it. |
| `IdempotenceException` | 409 on a call with an idempotence key, with a single error with error code `30001002`: a request with the same idempotence key is still running. Has `getIdempotenceKey()`. |
| `ValidationException` | 400: invalid request, including an operation that the payment's state does not allow (error `id` `ACTION_NOT_ALLOWED_ON_TRANSACTION`). |
| `AuthorizationException` | 403: wrong API key ID, secret or merchant ID (error `id` `ACCESS_TO_MERCHANT_NOT_ALLOWED`), or an action that is not allowed. |
| `ReferenceException` | 404 (object not found), 410, and a 409 that is not the idempotence case above. |
| `PlatformException` | 500, 502, 503. Retry only if an error has `getRetriable()` true; for calls that support idempotence, with a new idempotence key. |
| `ApiException` | Base class of all the above; any other error status, including 401 and 402 without a payment result. Other `ApiException` subclasses, `ProblemDetailsException` and `DeclinedPayoutException`, are raised by operations this skill does not use. Has `getStatusCode()`, `getErrorId()`, `getErrors()`, `getResponseBody()`. |
| `com.onlinepayments.communication.CommunicationException` | No valid response: timeout, connection error, or an error response with a non-empty body and a content type that is not JSON (a 404 like that raises a `NotFoundException`). Not an `ApiException`. |
| `com.onlinepayments.webhooks.SignatureValidationException` | Webhook verification failed: missing, duplicate or wrong `X-GCS-Signature` or `X-GCS-KeyId`. Its subclass `SecretKeyNotAvailableException` means an unknown key ID. |
| `com.onlinepayments.webhooks.ApiVersionMismatchException` | Webhook signature valid, but the event's API version is not `v1`. Not a `SignatureValidationException`. |
| `com.onlinepayments.json.MarshallerSyntaxException` | Webhook signature valid, but the body is not valid JSON for an event. An API call raises it too when the response has a JSON content type but invalid JSON. Not a `SignatureValidationException`. |

`getErrors()` is a list of `APIError` with `getErrorCode()`, `getPropertyName()`, `getMessage()` and `getRetriable()`.
`ApiException.toString()` includes the status code and the response body (`; responseBody='...'`);
`getMessage()` does not hold the body (for the declined exceptions it holds the payment or refund ID and status). So `LOGGER.log(level, "...", e)` and `e.toString()` log the body, while
`getMessage()` does not. Logging the exception is fine for Hosted Checkout calls, whose error body is a plain error
response. For an error that carries a payment or refund (a declined payment), log only the error ID, the
status and the error codes.

## Webhooks

`new WebhooksHelper(DefaultMarshaller.INSTANCE, secretKeyStore)` and `helper.unmarshal(body, headers)`, where `body`
is the raw body (`byte[]`, `InputStream` or `String`) and `headers` is a `List<RequestHeader>`. It returns a
`WebhooksEvent` with `getId()`, `getType()`, `getCreated()`, `getMerchantId()` and one of `getPayment()`,
`getRefund()`, `getPaymentLink()`, `getPayout()`, `getToken()`. See `webhooks.md` for the full handler.

The helper takes one `RequestHeader(name, value)` per header value. It rejects a repeated `X-GCS-Signature` or
`X-GCS-KeyId` with `SignatureValidationException`, so do not join the values of a repeated header into one
`RequestHeader`. `unmarshal` throws only unchecked exceptions (`IOException` only for the `InputStream` overload):
`SignatureValidationException` (also unknown key ID), `ApiVersionMismatchException` and `MarshallerSyntaxException`;
the last two are not subclasses of the first. `InMemorySecretKeyStore.INSTANCE` is a singleton and `storeSecretKey`
overwrites an existing key ID.

## Logging

`client.enableLogging(new JdkCommunicatorLogger(logger, Level.INFO))` or `SysOutCommunicatorLogger.INSTANCE` logs
requests and responses with card data and secrets masked. Implement `CommunicatorLogger` to send the log to your own
logging framework. Do not log request or response objects yourself.
