package examples;

import com.onlinepayments.CallContext;
import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.Card;
import com.onlinepayments.domain.CardPaymentMethodSpecificInput;
import com.onlinepayments.domain.CreatePaymentRequest;
import com.onlinepayments.domain.CreatePaymentResponse;
import com.onlinepayments.domain.Customer;
import com.onlinepayments.domain.CustomerDevice;
import com.onlinepayments.domain.Order;
import com.onlinepayments.domain.OrderReferences;
import com.onlinepayments.domain.RedirectionData;
import com.onlinepayments.domain.ThreeDSecure;
import com.onlinepayments.merchant.MerchantClientInterface;

public class ServerToServerExample {

    private final MerchantClientInterface merchantClient;
    private final OrderStore orders;

    public ServerToServerExample(MerchantClientInterface merchantClient, OrderStore orders) {
        this.merchantClient = merchantClient;
        this.orders = orders;
    }

    // [START server-to-server-create]
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
    // [END server-to-server-create]
}
