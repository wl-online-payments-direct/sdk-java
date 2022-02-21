package com.onlinepayments;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import com.onlinepayments.defaultimpl.DefaultMarshaller;
import com.onlinepayments.domain.ShoppingCartExtension;
import com.onlinepayments.util.RequestHeaderMatcher;
import com.onlinepayments.util.ShoppingCartExtensionMatcher;

public class MetaDataProviderTest {

	@Test
	public void testGetServerMetaDataHeadersFull() {

		ShoppingCartExtension shoppingCartExtension = new ShoppingCartExtension("OnlinePayments.Creator", "Extension", "1.0", "ExtensionId");

		MetaDataProvider metaDataProvider = new MetaDataProviderBuilder("OnlinePayments.Integrator")
				.withShoppingCartExtension(shoppingCartExtension)
				.build();

		Collection<RequestHeader> requestHeaders = metaDataProvider.getServerMetaDataHeaders();
		Assert.assertEquals(1, requestHeaders.size());

		RequestHeader requestHeader = requestHeaders.iterator().next();
		assertServerMetaInfo("OnlinePayments.Integrator", shoppingCartExtension, requestHeader);
	}

	@Test
	public void testGetServerMetaDataHeadersFullNoShoppingCartExtensionId() {

		ShoppingCartExtension shoppingCartExtension = new ShoppingCartExtension("OnlinePayments.Creator", "Extension", "1.0");

		MetaDataProvider metaDataProvider = new MetaDataProviderBuilder("OnlinePayments.Integrator")
				.withShoppingCartExtension(shoppingCartExtension)
				.build();

		Collection<RequestHeader> requestHeaders = metaDataProvider.getServerMetaDataHeaders();
		Assert.assertEquals(1, requestHeaders.size());

		RequestHeader requestHeader = requestHeaders.iterator().next();
		assertServerMetaInfo("OnlinePayments.Integrator", shoppingCartExtension, requestHeader);
	}

	@Test
	public void testGetServerMetaDataHeadersNoAdditionalHeaders() {

		MetaDataProvider metaDataProvider = new MetaDataProvider("OnlinePayments");

		Collection<RequestHeader> requestHeaders = metaDataProvider.getServerMetaDataHeaders();
		Assert.assertEquals(1, requestHeaders.size());

		RequestHeader requestHeader = requestHeaders.iterator().next();
		assertServerMetaInfo("OnlinePayments", null, requestHeader);
	}

	@Test
	public void testGetServerMetaDataHeadersWithAdditionalHeaders() {

		final List<RequestHeader> additionalHeaders = Arrays.asList(
				new RequestHeader("Header1", "Value1"),
				new RequestHeader("Header2", "Value2"),
				new RequestHeader("Header3", "Value3")
		);

		MetaDataProviderBuilder builder = new MetaDataProviderBuilder("OnlinePayments");
		// add directly, to bypass the checks - this test is also for validation in MetaDataProvider
		builder.additionalRequestHeaders.addAll(additionalHeaders);

		MetaDataProvider metaDataProvider = new MetaDataProvider(builder);

		Collection<RequestHeader> requestHeaders = metaDataProvider.getServerMetaDataHeaders();
		Assert.assertEquals(4, requestHeaders.size());

		Iterator<RequestHeader> requestHeaderIterator = requestHeaders.iterator();

		RequestHeader requestHeader = requestHeaderIterator.next();
		assertServerMetaInfo("OnlinePayments", null, requestHeader);

		for (RequestHeader additionalHeader : additionalHeaders) {
			Assert.assertTrue(requestHeaderIterator.hasNext());
			requestHeader = requestHeaderIterator.next();
			MatcherAssert.assertThat(requestHeader, new RequestHeaderMatcher(additionalHeader));
		}
	}

	@Test
	public void testConstructorWithProhibitedHeaders() {

		for (final String name : MetaDataProvider.PROHIBITED_HEADERS) {

			MetaDataProviderBuilder builder = new MetaDataProviderBuilder("OnlinePayments");
			// add directly, to bypass the checks - this test is also for validation in MetaDataProvider
			builder.additionalRequestHeaders.add(new RequestHeader("Header1", "Value1"));
			builder.additionalRequestHeaders.add(new RequestHeader(name, name));
			builder.additionalRequestHeaders.add(new RequestHeader("Header2", "Value2"));

			try {
				new MetaDataProvider(builder);
				Assert.fail("expected an IllegalArgumentException");
			} catch (IllegalArgumentException e) {
				MatcherAssert.assertThat(e.getMessage(), Matchers.containsString(name));
			}
		}
	}

	private void assertServerMetaInfo(String integrator,
			ShoppingCartExtension shoppingCartExtension,
			RequestHeader requestHeader) {

		Assert.assertEquals("X-GCS-ServerMetaInfo", requestHeader.getName());
		Assert.assertNotNull(requestHeader.getValue());

		String serverMetaInfoJson = new String(Base64.decodeBase64(requestHeader.getValue()), Charset.forName("UTF-8"));

		MetaDataProvider.ServerMetaInfo serverMetaInfo = DefaultMarshaller.INSTANCE.unmarshal(serverMetaInfoJson, MetaDataProvider.ServerMetaInfo.class);
		Assert.assertEquals(MetaDataProvider.PLATFORM_IDENTIFIER, serverMetaInfo.platformIdentifier);
		Assert.assertEquals(MetaDataProvider.SDK_IDENTIFIER, serverMetaInfo.sdkIdentifier);
		Assert.assertEquals("OnlinePayments", serverMetaInfo.sdkCreator);
		Assert.assertEquals(integrator, serverMetaInfo.integrator);
		if (shoppingCartExtension == null) {
			Assert.assertNull(serverMetaInfo.shoppingCartExtension);
		} else {
			MatcherAssert.assertThat(serverMetaInfo.shoppingCartExtension, new ShoppingCartExtensionMatcher(shoppingCartExtension));
		}
	}
}
