package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

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

public class PaymentsTest extends ItTest {

    /**
     * Smoke test for payments service.
     */
    @Test
    public void test() throws URISyntaxException, IOException {

        Card card = new Card()
                .withCardNumber("4567350000427977")
                .withCardholderName("Wile E. Coyote")
                .withCvv("123")
                .withExpiryDate("1230");

        RedirectionData redirectionData = new RedirectionData()
                .withReturnUrl("https://hostname.myownwebsite.url");

        ThreeDSecure threeDSecure = new ThreeDSecure()
                .withChallengeCanvasSize("600x400")
                .withChallengeIndicator("challenge-requested")
                .withRedirectionData(redirectionData)
                .withSkipAuthentication(false);

        CardPaymentMethodSpecificInput cardPaymentMethodSpecificInput = new CardPaymentMethodSpecificInput()
                .withCard(card)
                .withIsRecurring(false)
                .withPaymentProductId(1)
                .withThreeDSecure(threeDSecure)
                .withTransactionChannel("ECOMMERCE");

        AmountOfMoney amountOfMoney = new AmountOfMoney()
                .withAmount(2980L)
                .withCurrencyCode("EUR");

        Address billingAddress = new Address()
                .withCountryCode("US");

        Customer customer = new Customer()
                .withBillingAddress(billingAddress)
                .withLocale("en_US");

        OrderReferences references = new OrderReferences()
                .withDescriptor("Fast and Furry-ous")
                .withMerchantReference("AcmeOrder0001");

        Order order = new Order()
                .withAmountOfMoney(amountOfMoney)
                .withCustomer(customer)
                .withReferences(references);

        CreatePaymentRequest body = new CreatePaymentRequest()
                .withCardPaymentMethodSpecificInput(cardPaymentMethodSpecificInput)
                .withOrder(order);

        try (ClientInterface client = getClient()) {
            CreatePaymentResponse response = client.merchant(getMerchantId()).payments().createPayment(body);
            assertNotNull(response.getPayment());
        }
    }
}
