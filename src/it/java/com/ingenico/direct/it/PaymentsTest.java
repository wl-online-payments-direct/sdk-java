package com.ingenico.direct.it;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;

import com.ingenico.direct.Client;
import com.ingenico.direct.domain.Address;
import com.ingenico.direct.domain.AmountOfMoney;
import com.ingenico.direct.domain.Card;
import com.ingenico.direct.domain.CardPaymentMethodSpecificInput;
import com.ingenico.direct.domain.CreatePaymentRequest;
import com.ingenico.direct.domain.CreatePaymentResponse;
import com.ingenico.direct.domain.Customer;
import com.ingenico.direct.domain.Order;
import com.ingenico.direct.domain.OrderReferences;
import com.ingenico.direct.domain.RedirectionData;
import com.ingenico.direct.domain.ThreeDSecure;

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

		Client client = getClient();
		try {
			CreatePaymentResponse response = client.merchant(MERCHANT_ID).payments().createPayment(body);

			Assert.assertNotNull(response.getPayment());

		} finally {
			client.close();
		}
	}
}
