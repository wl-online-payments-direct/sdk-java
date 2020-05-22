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

public class IdempotenceTest extends ItTest {

	/**
	 * Smoke test for idempotence.
	 */
	@Test
	public void test() throws URISyntaxException, IOException {

		CreatePaymentRequest body = new CreatePaymentRequest();

		Order order = new Order();

		AmountOfMoney amountOfMoney = new AmountOfMoney();
		amountOfMoney.setCurrencyCode("EUR");
		amountOfMoney.setAmount(100L);
		order.setAmountOfMoney(amountOfMoney);

		Customer customer = new Customer();
		customer.setLocale("en");

		Address billingAddress = new Address();
		billingAddress.setCountryCode("NL");
		customer.setBillingAddress(billingAddress);

		order.setCustomer(customer);
		body.setOrder(order);

		RedirectionData redirectionData = new RedirectionData();
		redirectionData.setReturnUrl("http://example.com/");

		CardPaymentMethodSpecificInput paymentMethodSpecificInput = new CardPaymentMethodSpecificInput();
		paymentMethodSpecificInput.setPaymentProductId(1);
		paymentMethodSpecificInput.setIsRecurring(false);
		paymentMethodSpecificInput.setAuthorizationMode("FINAL_AUTHORIZATION");
		paymentMethodSpecificInput.setSkipAuthentication(true);

		Card card = new Card();
		card.setCardNumber("4330264936344675");
		card.setCvv("123");
		card.setExpiryDate("1230");
		card.setCardholderName("Wile E. Coyote");
		paymentMethodSpecificInput.setCard(card);

		body.setCardPaymentMethodSpecificInput(paymentMethodSpecificInput);

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
