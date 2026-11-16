package examples;

import java.time.ZonedDateTime;

import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.CreatePaymentLinkRequest;
import com.onlinepayments.domain.Order;
import com.onlinepayments.domain.OrderReferences;
import com.onlinepayments.domain.PaymentLinkResponse;
import com.onlinepayments.domain.PaymentLinkSpecificInput;
import com.onlinepayments.merchant.MerchantClientInterface;

public class PaymentLinksExample {

    private final MerchantClientInterface merchantClient;

    public PaymentLinksExample(MerchantClientInterface merchantClient) {
        this.merchantClient = merchantClient;
    }

    // [START payment-link-create]
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
    // [END payment-link-create]
}
