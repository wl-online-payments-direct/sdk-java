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
	 * Smoke test for products service.
	 */
	@Test
	public void test() throws URISyntaxException, IOException {

		Card card = new Card();
		card.setCardNumber("4567350000427977");
		card.setCardholderName("Wile E. Coyote");
		card.setCvv("123");
		card.setExpiryDate("1220");

		RedirectionData redirectionData = new RedirectionData();
		redirectionData.setReturnUrl("https://hostname.myownwebsite.url");

		ThreeDSecure threeDSecure = new ThreeDSecure();
		threeDSecure.setChallengeCanvasSize("600x400");
		threeDSecure.setChallengeIndicator("challenge-requested");
		threeDSecure.setRedirectionData(redirectionData);
		threeDSecure.setSkipAuthentication(false);

		CardPaymentMethodSpecificInput cardPaymentMethodSpecificInput = new CardPaymentMethodSpecificInput();
		cardPaymentMethodSpecificInput.setCard(card);
		cardPaymentMethodSpecificInput.setIsRecurring(false);
		cardPaymentMethodSpecificInput.setPaymentProductId(1);
		cardPaymentMethodSpecificInput.setThreeDSecure(threeDSecure);
		cardPaymentMethodSpecificInput.setTransactionChannel("ECOMMERCE");

		AmountOfMoney amountOfMoney = new AmountOfMoney();
		amountOfMoney.setAmount(2980L);
		amountOfMoney.setCurrencyCode("EUR");

		Address billingAddress = new Address();
		billingAddress.setCountryCode("US");

		Customer customer = new Customer();
		customer.setBillingAddress(billingAddress);
		customer.setLocale("en_US");

		OrderReferences references = new OrderReferences();
		references.setDescriptor("Fast and Furry-ous");
		references.setMerchantReference("AcmeOrder0001");

		Order order = new Order();
		order.setAmountOfMoney(amountOfMoney);
		order.setCustomer(customer);
		order.setReferences(references);

		CreatePaymentRequest body = new CreatePaymentRequest();
		body.setCardPaymentMethodSpecificInput(cardPaymentMethodSpecificInput);
		body.setOrder(order);

		Client client = getClient();
		try {
			CreatePaymentResponse response = client.merchant(MERCHANT_ID).payments().createPayment(body);

			Assert.assertNotNull(response.getPayment());

		} finally {
			client.close();
		}
	}
}
