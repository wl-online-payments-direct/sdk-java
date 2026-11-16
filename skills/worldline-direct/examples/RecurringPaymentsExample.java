package examples;

import com.onlinepayments.CallContext;
import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.CreateHostedCheckoutRequest;
import com.onlinepayments.domain.CreateHostedCheckoutResponse;
import com.onlinepayments.domain.HostedCheckoutSpecificInput;
import com.onlinepayments.domain.Order;
import com.onlinepayments.domain.OrderReferences;
import com.onlinepayments.domain.SubsequentCardPaymentMethodSpecificInput;
import com.onlinepayments.domain.SubsequentPaymentRequest;
import com.onlinepayments.domain.SubsequentPaymentResponse;
import com.onlinepayments.merchant.MerchantClientInterface;

public class RecurringPaymentsExample {

    private final MerchantClientInterface merchantClient;
    private final OrderStore orders;
    private final HostedCheckoutExample hostedCheckout;

    public RecurringPaymentsExample(MerchantClientInterface merchantClient, OrderStore orders,
                                    HostedCheckoutExample hostedCheckout) {
        this.merchantClient = merchantClient;
        this.orders = orders;
        this.hostedCheckout = hostedCheckout;
    }

    // [START recurring-first]
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
    // [END recurring-first]

    // [START recurring-subsequent]
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
    // [END recurring-subsequent]
}
