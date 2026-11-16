package examples;

import com.onlinepayments.CallContext;
import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.CardPaymentMethodSpecificInput;
import com.onlinepayments.domain.CreateHostedFieldsSessionRequest;
import com.onlinepayments.domain.CreateHostedFieldsSessionResponse;
import com.onlinepayments.domain.CreatePaymentRequest;
import com.onlinepayments.domain.CreatePaymentResponse;
import com.onlinepayments.domain.Customer;
import com.onlinepayments.domain.CustomerDevice;
import com.onlinepayments.domain.Order;
import com.onlinepayments.domain.OrderReferences;
import com.onlinepayments.domain.RedirectionData;
import com.onlinepayments.domain.ThreeDSecure;
import com.onlinepayments.merchant.MerchantClientInterface;

public class HostedFieldsExample {

    private final MerchantClientInterface merchantClient;
    private final OrderStore orders;

    public HostedFieldsExample(MerchantClientInterface merchantClient, OrderStore orders) {
        this.merchantClient = merchantClient;
        this.orders = orders;
    }

    // [START hosted-fields-create]
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
    // [END hosted-fields-create]

    // [START hosted-fields-payment]
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
    // [END hosted-fields-payment]
}
