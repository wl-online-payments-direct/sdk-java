package examples;

import com.onlinepayments.CallContext;
import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.CardPaymentMethodSpecificInput;
import com.onlinepayments.domain.CreatePaymentRequest;
import com.onlinepayments.domain.CreatePaymentResponse;
import com.onlinepayments.domain.Customer;
import com.onlinepayments.domain.CustomerDevice;
import com.onlinepayments.domain.Order;
import com.onlinepayments.domain.OrderReferences;
import com.onlinepayments.domain.RedirectionData;
import com.onlinepayments.domain.SessionRequest;
import com.onlinepayments.domain.SessionResponse;
import com.onlinepayments.domain.ThreeDSecure;
import com.onlinepayments.merchant.MerchantClientInterface;

public class ClientIntegrationExample {

    private final MerchantClientInterface merchantClient;
    private final OrderStore orders;

    public ClientIntegrationExample(MerchantClientInterface merchantClient, OrderStore orders) {
        this.merchantClient = merchantClient;
        this.orders = orders;
    }

    // [START client-session-create]
    // Creates the session that a Client SDK (JavaScript, iOS, Android, Flutter...) needs to encrypt card data.
    public SessionResponse createClientSession() {
        SessionResponse session = merchantClient.sessions().createSession(new SessionRequest());

        // Send getClientSessionId(), getCustomerId(), getClientApiUrl() and getAssetUrl() to the app.
        // Never send your API key.
        return session;
    }
    // [END client-session-create]

    // [START client-encrypted-payment]
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
    // [END client-encrypted-payment]
}
