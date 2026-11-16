package examples;

import com.onlinepayments.CallContext;
import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.CardPaymentMethodSpecificInput;
import com.onlinepayments.domain.CreateHostedTokenizationRequest;
import com.onlinepayments.domain.CreateHostedTokenizationResponse;
import com.onlinepayments.domain.CreatePaymentRequest;
import com.onlinepayments.domain.CreatePaymentResponse;
import com.onlinepayments.domain.Customer;
import com.onlinepayments.domain.CustomerDevice;
import com.onlinepayments.domain.Order;
import com.onlinepayments.domain.OrderReferences;
import com.onlinepayments.domain.RedirectionData;
import com.onlinepayments.domain.ThreeDSecure;
import com.onlinepayments.merchant.MerchantClientInterface;

public class HostedTokenizationExample {

    private final MerchantClientInterface merchantClient;
    private final OrderStore orders;

    public HostedTokenizationExample(MerchantClientInterface merchantClient, OrderStore orders) {
        this.merchantClient = merchantClient;
        this.orders = orders;
    }

    // [START hosted-tokenization-create]
    // Creates the session for the card form iframe on your checkout page.
    public CreateHostedTokenizationResponse createSession() {
        CreateHostedTokenizationRequest request = new CreateHostedTokenizationRequest()
                .withLocale("en-GB");
        // Optional: .withVariant("MyTemplate.html"), the file name of a custom template.

        CreateHostedTokenizationResponse response = merchantClient.hostedTokenization().createHostedTokenization(request);

        // Send response.getHostedTokenizationUrl() (iframe URL) and response.getSri() (script integrity) to the page.
        return response;
    }
    // [END hosted-tokenization-create]

    // [START hosted-tokenization-payment]
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
    // [END hosted-tokenization-payment]
}
