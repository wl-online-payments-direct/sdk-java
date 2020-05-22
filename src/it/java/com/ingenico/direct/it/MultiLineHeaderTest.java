package com.ingenico.direct.it;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;

import com.ingenico.direct.ClientInterface;
import com.ingenico.direct.Communicator;
import com.ingenico.direct.CommunicatorConfiguration;
import com.ingenico.direct.Factory;
import com.ingenico.direct.MetaDataProvider;
import com.ingenico.direct.MetaDataProviderBuilder;
import com.ingenico.direct.RequestHeader;
import com.ingenico.direct.domain.GetPaymentProductsResponse;
import com.ingenico.direct.merchant.products.GetPaymentProductsParams;

public class MultiLineHeaderTest extends ItTest {

	/**
	 * Smoke test for products service.
	 */
	@Test
	public void test() throws URISyntaxException, IOException {

		CommunicatorConfiguration configuration = getCommunicatorConfiguration();

		String multiLineHeader = " some value  \r\n \n with  some \r\n  spaces ";
		MetaDataProvider metaDataProvider = new MetaDataProviderBuilder("Ingenico")
				.withAdditionalRequestHeader(new RequestHeader("X-GCS-MultiLineHeader", multiLineHeader))
				.build();

		GetPaymentProductsParams params = new GetPaymentProductsParams();
		params.setCountryCode("NL");
		params.setCurrencyCode("EUR");

		Communicator communicator = Factory.createCommunicatorBuilder(configuration)
		                                   .withMetaDataProvider(metaDataProvider)
		                                   .build();
		ClientInterface client = Factory.createClient(communicator);
		try {
			GetPaymentProductsResponse response = client.merchant(MERCHANT_ID).products().getPaymentProducts(params);

			Assert.assertTrue(response.getPaymentProducts().size() > 0);

		} finally {
			client.close();
		}
	}
}
