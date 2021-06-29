package com.ingenico.direct;

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

import com.ingenico.direct.MetaDataProvider.ServerMetaInfo;
import com.ingenico.direct.defaultimpl.DefaultMarshaller;
import com.ingenico.direct.domain.ShoppingCartExtension;
import com.ingenico.direct.util.RequestHeaderMatcher;
import com.ingenico.direct.util.ShoppingCartExtensionMatcher;

public class MetaDataProviderTest {

	@Test
	public void testGetServerMetaDataHeadersFull() {

		ShoppingCartExtension shoppingCartExtension = new ShoppingCartExtension("Ingenico.Creator", "Extension", "1.0", "ExtensionId");

		MetaDataProvider metaDataProvider = new MetaDataProviderBuilder("Ingenico.Integrator")
				.withShoppingCartExtension(shoppingCartExtension)
				.build();

		Collection<RequestHeader> requestHeaders = metaDataProvider.getServerMetaDataHeaders();
		Assert.assertEquals(1, requestHeaders.size());

		RequestHeader requestHeader = requestHeaders.iterator().next();
		assertServerMetaInfo("Ingenico.Integrator", shoppingCartExtension, requestHeader);
	}

	@Test
	public void testGetServerMetaDataHeadersFullNoShoppingCartExtensionId() {

		ShoppingCartExtension shoppingCartExtension = new ShoppingCartExtension("Ingenico.Creator", "Extension", "1.0");

		MetaDataProvider metaDataProvider = new MetaDataProviderBuilder("Ingenico.Integrator")
				.withShoppingCartExtension(shoppingCartExtension)
				.build();

		Collection<RequestHeader> requestHeaders = metaDataProvider.getServerMetaDataHeaders();
		Assert.assertEquals(1, requestHeaders.size());

		RequestHeader requestHeader = requestHeaders.iterator().next();
		assertServerMetaInfo("Ingenico.Integrator", shoppingCartExtension, requestHeader);
	}

	@Test
	public void testGetServerMetaDataHeadersNoAdditionalHeaders() {

		MetaDataProvider metaDataProvider = new MetaDataProvider("Ingenico");

		Collection<RequestHeader> requestHeaders = metaDataProvider.getServerMetaDataHeaders();
		Assert.assertEquals(1, requestHeaders.size());

		RequestHeader requestHeader = requestHeaders.iterator().next();
		assertServerMetaInfo("Ingenico", null, requestHeader);
	}

	@Test
	public void testGetServerMetaDataHeadersWithAdditionalHeaders() {

		final List<RequestHeader> additionalHeaders = Arrays.asList(
				new RequestHeader("Header1", "Value1"),
				new RequestHeader("Header2", "Value2"),
				new RequestHeader("Header3", "Value3")
		);

		MetaDataProviderBuilder builder = new MetaDataProviderBuilder("Ingenico");
		// add directly, to bypass the checks - this test is also for validation in MetaDataProvider
		builder.additionalRequestHeaders.addAll(additionalHeaders);

		MetaDataProvider metaDataProvider = new MetaDataProvider(builder);

		Collection<RequestHeader> requestHeaders = metaDataProvider.getServerMetaDataHeaders();
		Assert.assertEquals(4, requestHeaders.size());

		Iterator<RequestHeader> requestHeaderIterator = requestHeaders.iterator();

		RequestHeader requestHeader = requestHeaderIterator.next();
		assertServerMetaInfo("Ingenico", null, requestHeader);

		for (RequestHeader additionalHeader : additionalHeaders) {
			Assert.assertTrue(requestHeaderIterator.hasNext());
			requestHeader = requestHeaderIterator.next();
			MatcherAssert.assertThat(requestHeader, new RequestHeaderMatcher(additionalHeader));
		}
	}

	@Test
	public void testConstructorWithProhibitedHeaders() {

		for (final String name : MetaDataProvider.PROHIBITED_HEADERS) {

			MetaDataProviderBuilder builder = new MetaDataProviderBuilder("Ingenico");
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

		ServerMetaInfo serverMetaInfo = DefaultMarshaller.INSTANCE.unmarshal(serverMetaInfoJson, ServerMetaInfo.class);
		Assert.assertEquals(MetaDataProvider.PLATFORM_IDENTIFIER, serverMetaInfo.platformIdentifier);
		Assert.assertEquals(MetaDataProvider.SDK_IDENTIFIER, serverMetaInfo.sdkIdentifier);
		Assert.assertEquals("Ingenico", serverMetaInfo.sdkCreator);
		Assert.assertEquals(integrator, serverMetaInfo.integrator);
		if (shoppingCartExtension == null) {
			Assert.assertNull(serverMetaInfo.shoppingCartExtension);
		} else {
			MatcherAssert.assertThat(serverMetaInfo.shoppingCartExtension, new ShoppingCartExtensionMatcher(shoppingCartExtension));
		}
	}
}
