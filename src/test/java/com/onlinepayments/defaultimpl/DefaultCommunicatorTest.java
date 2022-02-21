package com.onlinepayments.defaultimpl;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.onlinepayments.Authenticator;
import com.onlinepayments.Connection;
import com.onlinepayments.MetaDataProvider;
import com.onlinepayments.RequestParam;

@RunWith(MockitoJUnitRunner.class)
public class DefaultCommunicatorTest {

	private static final String TEST_ENDPOINT_URI = "https://payment.preprod.online-payments.com";
	private static final URI BASE_URI = URI.create(TEST_ENDPOINT_URI);

	@Mock private Connection connection;
	@Mock private Authenticator authenticator;
	@Mock private MetaDataProvider metaDataProvider;

	@Test
	public void testToURIWithoutRequestParams() {

		DefaultCommunicator communicator = new DefaultCommunicator(BASE_URI, connection, authenticator, metaDataProvider, DefaultMarshaller.INSTANCE);

		URI uri = communicator.toAbsoluteURI("v2/merchant/1/services/testconnection", Collections.<RequestParam>emptyList());
		Assert.assertEquals(URI.create(TEST_ENDPOINT_URI + "/v2/merchant/1/services/testconnection"), uri);

		uri = communicator.toAbsoluteURI("/v2/merchant/1/services/testconnection", Collections.<RequestParam>emptyList());
		Assert.assertEquals(URI.create(TEST_ENDPOINT_URI + "/v2/merchant/1/services/testconnection"), uri);
	}

	@Test
	public void testToURIWithRequestParams() {

		List<RequestParam> requestParams = Arrays.asList(
				new RequestParam("amount", "123"),
				new RequestParam("currency", "USD"),
				new RequestParam("dummy", "é&%=")
		);

		DefaultCommunicator communicator = new DefaultCommunicator(BASE_URI, connection, authenticator, metaDataProvider, DefaultMarshaller.INSTANCE);

		URI uri = communicator.toAbsoluteURI("v2/merchant/1/products", requestParams);
		Assert.assertEquals(URI.create(TEST_ENDPOINT_URI + "/v2/merchant/1/products?amount=123&currency=USD&dummy=%C3%A9%26%25%3D"), uri);

		uri = communicator.toAbsoluteURI("/v2/merchant/1/products", requestParams);
		Assert.assertEquals(URI.create(TEST_ENDPOINT_URI + "/v2/merchant/1/products?amount=123&currency=USD&dummy=%C3%A9%26%25%3D"), uri);
	}
}
