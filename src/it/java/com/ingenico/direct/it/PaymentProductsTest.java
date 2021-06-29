package com.ingenico.direct.it;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;

import com.ingenico.direct.Client;
import com.ingenico.direct.domain.GetPaymentProductsResponse;
import com.ingenico.direct.merchant.products.GetPaymentProductsParams;

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
