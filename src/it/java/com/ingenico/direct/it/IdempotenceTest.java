package com.ingenico.direct.it;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.ingenico.direct.CallContext;
import com.ingenico.direct.Client;
import com.ingenico.direct.domain.Address;
import com.ingenico.direct.domain.AmountOfMoney;
import com.ingenico.direct.domain.Card;
import com.ingenico.direct.domain.CardPaymentMethodSpecificInput;
import com.ingenico.direct.domain.CreatePaymentRequest;
import com.ingenico.direct.domain.CreatePaymentResponse;
import com.ingenico.direct.domain.Customer;
import com.ingenico.direct.domain.Order;
import com.ingenico.direct.domain.RedirectionData;
import com.ingenico.direct.domain.ThreeDSecure;

public class IdempotenceTest extends ItTest {

	/**
	 * Smoke test for idempotence.
	 */
	@Test
	public void test() throws URISyntaxException, IOException {

		AmountOfMoney amountOfMoney = new AmountOfMoney()
				.withCurrencyCode("EUR")
				.withAmount(100L);

		Address billingAddress = new Address()
				.withCountryCode("NL");

        Customer customer = new Customer()
                .withLocale("en")
                .withBillingAddress(billingAddress);

		RedirectionData redirectionData = new RedirectionData()
				.withReturnUrl("http://example.com/");

        ThreeDSecure threeDSecure = new ThreeDSecure()
                .withRedirectionData(redirectionData);

        Card card = new Card()
                .withCardNumber("4330264936344675")
                .withCvv("123")
                .withExpiryDate("1230")
                .withCardholderName("Wile E. Coyote");

        CardPaymentMethodSpecificInput paymentMethodSpecificInput = new CardPaymentMethodSpecificInput()
                .withPaymentProductId(1)
                .withIsRecurring(false)
                .withAuthorizationMode("FINAL_AUTHORIZATION")
                .withSkipAuthentication(true)
                .withCard(card)
                .withThreeDSecure(threeDSecure);

        Order order = new Order()
                .withAmountOfMoney(amountOfMoney)
                .withCustomer(customer);

        CreatePaymentRequest body = new CreatePaymentRequest()
                .withOrder(order)
                .withCardPaymentMethodSpecificInput(paymentMethodSpecificInput);

		String idempotenceKey = UUID.randomUUID().toString();
		CallContext context = new CallContext().withIdempotenceKey(idempotenceKey);

		Client client = getClient();
		try {
			CreatePaymentResponse response = client.merchant(MERCHANT_ID).payments().createPayment(body, context);
			String paymentId = response.getPayment().getId();

			Assert.assertEquals(idempotenceKey, context.getIdempotenceKey());
			Assert.assertNull(context.getIdempotenceRequestTimestamp());

			response = client.merchant(MERCHANT_ID).payments().createPayment(body, context);

			Assert.assertEquals(paymentId, response.getPayment().getId());

			Assert.assertEquals(idempotenceKey, context.getIdempotenceKey());
			Assert.assertNotNull(context.getIdempotenceRequestTimestamp());

		} finally {
			client.close();
		}
	}
}
