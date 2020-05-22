package com.ingenico.direct.it;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;

import com.ingenico.direct.Client;
import com.ingenico.direct.domain.PaymentProductGroup;
import com.ingenico.direct.merchant.productgroups.GetProductGroupParams;

public class PaymentProductGroupsTest extends ItTest {

	/**
	 * Smoke test for product groups service.
	 */
	@Test
	public void test() throws URISyntaxException, IOException {

		GetProductGroupParams params = new GetProductGroupParams();
		params.setCountryCode("NL");
		params.setCurrencyCode("EUR");

		Client client = getClient();
		try {
			PaymentProductGroup response = client.merchant(MERCHANT_ID).productGroups().getProductGroup("cards" , params);

			Assert.assertEquals("cards", response.getId());

		} finally {
			client.close();
		}
	}
}
