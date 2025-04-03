package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.onlinepayments.CallContext;
import com.onlinepayments.ClientInterface;
import com.onlinepayments.domain.Address;
import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.Card;
import com.onlinepayments.domain.CardPaymentMethodSpecificInput;
import com.onlinepayments.domain.CreatePaymentRequest;
import com.onlinepayments.domain.CreatePaymentResponse;
import com.onlinepayments.domain.Customer;
import com.onlinepayments.domain.Order;
import com.onlinepayments.domain.OrderReferences;
import com.onlinepayments.domain.RedirectionData;
import com.onlinepayments.domain.ThreeDSecure;

public class IdempotenceTest extends ItTest {

    /**
     * Smoke test for idempotence.
     */
    @Test
    public void test() throws URISyntaxException, IOException {

        AmountOfMoney amountOfMoney = new AmountOfMoney()
                .withAmount(2980L)
                .withCurrencyCode("EUR");

        Address billingAddress = new Address()
                .withCountryCode("US");

        Customer customer = new Customer()
                .withLocale("en_US")
                .withBillingAddress(billingAddress);

        RedirectionData redirectionData = new RedirectionData()
                .withReturnUrl("https://hostname.myownwebsite.url");

        ThreeDSecure threeDSecure = new ThreeDSecure()
                .withChallengeCanvasSize("600x400")
                .withChallengeIndicator("challenge-requested")
                .withRedirectionData(redirectionData)
                .withSkipAuthentication(true);

        Card card = new Card()
                .withCardNumber("4330264936344675")
                .withCvv("123")
                .withExpiryDate("1230")
                .withCardholderName("Wile E. Coyote");

        CardPaymentMethodSpecificInput paymentMethodSpecificInput = new CardPaymentMethodSpecificInput()
                .withPaymentProductId(1)
                .withIsRecurring(false)
                .withAuthorizationMode("FINAL_AUTHORIZATION")
                .withThreeDSecure(threeDSecure)
                .withCard(card);

        OrderReferences references = new OrderReferences()
                .withDescriptor("Fast and Furry-ous")
                .withMerchantReference("AcmeOrder0001");

        Order order = new Order()
                .withAmountOfMoney(amountOfMoney)
                .withCustomer(customer)
                .withReferences(references);

        CreatePaymentRequest body = new CreatePaymentRequest()
                .withOrder(order)
                .withCardPaymentMethodSpecificInput(paymentMethodSpecificInput);

        String idempotenceKey = UUID.randomUUID().toString();
        CallContext context = new CallContext().withIdempotenceKey(idempotenceKey);

        try (ClientInterface client = getClient()) {
            CreatePaymentResponse response = client.merchant(getMerchantId()).payments().createPayment(body, context);
            String paymentId = response.getPayment().getId();

            assertEquals(idempotenceKey, context.getIdempotenceKey());
            assertNull(context.getIdempotenceRequestTimestamp());

            response = client.merchant(getMerchantId()).payments().createPayment(body, context);

            assertEquals(paymentId, response.getPayment().getId());

            assertEquals(idempotenceKey, context.getIdempotenceKey());
            assertNotNull(context.getIdempotenceRequestTimestamp());

        }
    }
}
