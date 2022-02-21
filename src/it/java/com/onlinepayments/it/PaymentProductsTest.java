package com.onlinepayments.it;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;

import com.onlinepayments.Client;
import com.onlinepayments.domain.GetPaymentProductsResponse;
import com.onlinepayments.merchant.products.GetPaymentProductsParams;

public class PaymentProductsTest extends ItTest {

	/**
	 * Smoke test for products service.
	 */
	@Test
	public void test() throws URISyntaxException, IOException {

		GetPaymentProductsParams params = new GetPaymentProductsParams()
				.withCountryCode("NL")
				.withCurrencyCode("EUR");

		Client client = getClient();
		try {
			GetPaymentProductsResponse response = client.merchant(MERCHANT_ID).products().getPaymentProducts(params);

			Assert.assertTrue(response.getPaymentProducts().size() > 0);

		} finally {
			client.close();
		}
	}
}
