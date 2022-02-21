package com.onlinepayments.webhooks;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.onlinepayments.Marshaller;
import com.onlinepayments.RequestHeader;
import com.onlinepayments.defaultimpl.DefaultMarshaller;
import com.onlinepayments.domain.WebhooksEvent;

@RunWith(MockitoJUnitRunner.class)
public class WebhooksHelperTest {

	private static final Charset CHARSET = Charset.forName("UTF-8");

	private static final String SIGNATURE_HEADER = "X-GCS-Signature";
	private static final String SIGNATURE = "n0tLj/UViNRa8Eq9NVVgKkaGiav2Njnl9QJyMUKpBsU=";

	private static final String KEY_ID_HEADER = "X-GCS-KeyId";
	private static final String KEY_ID = "dummy-key-id";

	private static final String SECRET_KEY = "hello+world";

	@Before
	@After
	public void clearPublicKeyCache() {
		InMemorySecretKeyStore.INSTANCE.clear();
	}

	@Test(expected = ApiVersionMismatchException.class)
	public void testUnmarshalApiVersionMismatch() throws IOException {

		Marshaller marshaller = Mockito.mock(Marshaller.class);
		Mockito.when(marshaller.unmarshal(Matchers.anyString(), Matchers.<Class<?>>any())).thenAnswer(new Answer<Object>() {
			@Override
			public Object answer(InvocationOnMock invocation) {
				String responseJson = invocation.getArgumentAt(0, String.class);
				Class<?> type = invocation.getArgumentAt(1, Class.class);
				WebhooksEvent event = (WebhooksEvent) DefaultMarshaller.INSTANCE.unmarshal(responseJson, type);
				event.setApiVersion("v0");
				return event;
			}
		});

		WebhooksHelper helper = createHelper(marshaller);

		InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

		String body = new String(readResource("valid-body.json"), CHARSET);
		List<RequestHeader> requestHeaders = Arrays.asList(
				new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
				new RequestHeader(KEY_ID_HEADER, KEY_ID)
		);

		helper.unmarshal(body, requestHeaders);
	}

	@Test(expected = SecretKeyNotAvailableException.class)
	public void testUnmarshalNoSecretKeyAvailable() throws IOException {
		WebhooksHelper helper = createHelper();

		String body = new String(readResource("valid-body.json"), CHARSET);
		List<RequestHeader> requestHeaders = Arrays.asList(
				new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
				new RequestHeader(KEY_ID_HEADER, KEY_ID)
		);

		helper.unmarshal(body, requestHeaders);
	}

	@Test(expected = SignatureValidationException.class)
	public void testUnmarshalMissingHeaders() throws IOException {
		WebhooksHelper helper = createHelper();

		InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

		String body = new String(readResource("valid-body.json"), CHARSET);

		helper.unmarshal(body, Collections.<RequestHeader>emptyList());
	}

	@Test(expected = SignatureValidationException.class)
	public void testUnmarshalDuplicateHeaders() throws IOException {
		WebhooksHelper helper = createHelper();

		InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

		String body = new String(readResource("valid-body.json"), CHARSET);
		List<RequestHeader> requestHeaders = Arrays.asList(
				new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
				new RequestHeader(KEY_ID_HEADER, KEY_ID),
				new RequestHeader(SIGNATURE_HEADER, SIGNATURE + "1")
		);

		helper.unmarshal(body, requestHeaders);
	}

	@Test
	public void testUnmarshalBytesSuccess() throws IOException {
		WebhooksHelper helper = createHelper();

		InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

		ByteArrayInputStream bodyStream = new ByteArrayInputStream(readResource("valid-body.json"));
		List<RequestHeader> requestHeaders = Arrays.asList(
				new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
				new RequestHeader(KEY_ID_HEADER, KEY_ID)
		);

		WebhooksEvent event = helper.unmarshal(bodyStream, requestHeaders);

		Assert.assertEquals("v1", event.getApiVersion());
		Assert.assertEquals("8ee793f6-4553-4749-85dc-f2ef095c5ab0", event.getId());
		Assert.assertEquals("2020-01-01T12:30:30.000+0100", event.getCreated());
		Assert.assertEquals("1", event.getMerchantId());
		Assert.assertEquals("payment.captured", event.getType());

		Assert.assertNull(event.getRefund());
		Assert.assertNull(event.getPayout());
		Assert.assertNull(event.getToken());

		Assert.assertNotNull(event.getPayment());
		Assert.assertEquals("1_0", event.getPayment().getId());
		Assert.assertNotNull(event.getPayment().getPaymentOutput());
		Assert.assertNotNull(event.getPayment().getPaymentOutput().getAmountOfMoney());
		Assert.assertEquals((Long) 1000L, event.getPayment().getPaymentOutput().getAmountOfMoney().getAmount());
		Assert.assertEquals("EUR", event.getPayment().getPaymentOutput().getAmountOfMoney().getCurrencyCode());
		Assert.assertNotNull(event.getPayment().getPaymentOutput().getReferences());
		Assert.assertEquals("200001681810", event.getPayment().getPaymentOutput().getReferences().getMerchantReference());
		Assert.assertEquals("card", event.getPayment().getPaymentOutput().getPaymentMethod());

		Assert.assertNotNull(event.getPayment().getPaymentOutput().getCardPaymentMethodSpecificOutput());
		Assert.assertEquals((Integer) 1, event.getPayment().getPaymentOutput().getCardPaymentMethodSpecificOutput().getPaymentProductId());
		// TODO re-enable once direct-debit output is live.
//		Assert.assertNull(event.getPayment().getPaymentOutput().getDirectDebitPaymentMethodSpecificOutput());
		Assert.assertNull(event.getPayment().getPaymentOutput().getRedirectPaymentMethodSpecificOutput());
		Assert.assertNull(event.getPayment().getPaymentOutput().getSepaDirectDebitPaymentMethodSpecificOutput());

		Assert.assertEquals("CAPTURED", event.getPayment().getStatus());
		Assert.assertNotNull(event.getPayment().getStatusOutput());
		Assert.assertEquals(false, event.getPayment().getStatusOutput().getIsCancellable());
		Assert.assertEquals("COMPLETED", event.getPayment().getStatusOutput().getStatusCategory());
		Assert.assertEquals("20200101123030", event.getPayment().getStatusOutput().getStatusCodeChangeDateTime());
		Assert.assertEquals(true, event.getPayment().getStatusOutput().getIsAuthorized());
	}

	@Test(expected = SignatureValidationException.class)
	public void testUnmarshalBytesInvalidBody() throws IOException {
		WebhooksHelper helper = createHelper();

		InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

		ByteArrayInputStream bodyStream = new ByteArrayInputStream(readResource("mismatched-body.json"));
		List<RequestHeader> requestHeaders = Arrays.asList(
				new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
				new RequestHeader(KEY_ID_HEADER, KEY_ID)
		);

		helper.unmarshal(bodyStream, requestHeaders);
	}

	@Test(expected = SignatureValidationException.class)
	public void testUnmarshalBytesInvalidSecretKey() throws IOException {
		WebhooksHelper helper = createHelper();

		String invalidSecretKey = "1" + SECRET_KEY;
		InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, invalidSecretKey);

		ByteArrayInputStream bodyStream = new ByteArrayInputStream(readResource("valid-body.json"));
		List<RequestHeader> requestHeaders = Arrays.asList(
				new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
				new RequestHeader(KEY_ID_HEADER, KEY_ID)
		);

		helper.unmarshal(bodyStream, requestHeaders);
	}

	@Test(expected = SignatureValidationException.class)
	public void testUnmarshalBytesInvalidSignature() throws IOException {
		WebhooksHelper helper = createHelper();

		InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

		ByteArrayInputStream bodyStream = new ByteArrayInputStream(readResource("valid-body.json"));
		List<RequestHeader> requestHeaders = Arrays.asList(
				new RequestHeader(SIGNATURE_HEADER, "1" + SIGNATURE),
				new RequestHeader(KEY_ID_HEADER, KEY_ID)
		);

		helper.unmarshal(bodyStream, requestHeaders);
	}

	@Test
	public void testUnmarshalStringSuccess() throws IOException {
		WebhooksHelper helper = createHelper();

		InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

		String body = new String(readResource("valid-body.json"), CHARSET);
		List<RequestHeader> requestHeaders = Arrays.asList(
				new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
				new RequestHeader(KEY_ID_HEADER, KEY_ID)
		);

		WebhooksEvent event = helper.unmarshal(body, requestHeaders);

		Assert.assertEquals("v1", event.getApiVersion());
		Assert.assertEquals("8ee793f6-4553-4749-85dc-f2ef095c5ab0", event.getId());
		Assert.assertEquals("2020-01-01T12:30:30.000+0100", event.getCreated());
		Assert.assertEquals("1", event.getMerchantId());
		Assert.assertEquals("payment.captured", event.getType());

		Assert.assertNull(event.getRefund());
		Assert.assertNull(event.getPayout());
		Assert.assertNull(event.getToken());

		Assert.assertNotNull(event.getPayment());
		Assert.assertEquals("1_0", event.getPayment().getId());
		Assert.assertNotNull(event.getPayment().getPaymentOutput());
		Assert.assertNotNull(event.getPayment().getPaymentOutput().getAmountOfMoney());
		Assert.assertEquals((Long) 1000L, event.getPayment().getPaymentOutput().getAmountOfMoney().getAmount());
		Assert.assertEquals("EUR", event.getPayment().getPaymentOutput().getAmountOfMoney().getCurrencyCode());
		Assert.assertNotNull(event.getPayment().getPaymentOutput().getReferences());
		Assert.assertEquals("200001681810", event.getPayment().getPaymentOutput().getReferences().getMerchantReference());
		Assert.assertEquals("card", event.getPayment().getPaymentOutput().getPaymentMethod());

		Assert.assertNotNull(event.getPayment().getPaymentOutput().getCardPaymentMethodSpecificOutput());
		Assert.assertEquals((Integer) 1, event.getPayment().getPaymentOutput().getCardPaymentMethodSpecificOutput().getPaymentProductId());
		// TODO re-enable once direct-debit output is live.
//		Assert.assertNull(event.getPayment().getPaymentOutput().getDirectDebitPaymentMethodSpecificOutput());
		Assert.assertNull(event.getPayment().getPaymentOutput().getRedirectPaymentMethodSpecificOutput());
		Assert.assertNull(event.getPayment().getPaymentOutput().getSepaDirectDebitPaymentMethodSpecificOutput());

		Assert.assertEquals("CAPTURED", event.getPayment().getStatus());
		Assert.assertNotNull(event.getPayment().getStatusOutput());
		Assert.assertEquals(false, event.getPayment().getStatusOutput().getIsCancellable());
		Assert.assertEquals("COMPLETED", event.getPayment().getStatusOutput().getStatusCategory());
		Assert.assertEquals((Integer) 9, event.getPayment().getStatusOutput().getStatusCode());
		Assert.assertEquals("20200101123030", event.getPayment().getStatusOutput().getStatusCodeChangeDateTime());
		Assert.assertEquals(true, event.getPayment().getStatusOutput().getIsAuthorized());
	}

	@Test(expected = SignatureValidationException.class)
	public void testUnmarshalStringMismatchedBody() throws IOException {
		WebhooksHelper helper = createHelper();

		InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

		String body = new String(readResource("mismatched-body.json"), CHARSET);
		List<RequestHeader> requestHeaders = Arrays.asList(
				new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
				new RequestHeader(KEY_ID_HEADER, KEY_ID)
		);

		helper.unmarshal(body, requestHeaders);
	}

	@Test(expected = SignatureValidationException.class)
	public void testUnmarshalStringInvalidSecretKey() throws IOException {
		WebhooksHelper helper = createHelper();

		String invalidSecretKey = "1" + SECRET_KEY;
		InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, invalidSecretKey);

		String body = new String(readResource("valid-body.json"), CHARSET);
		List<RequestHeader> requestHeaders = Arrays.asList(
				new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
				new RequestHeader(KEY_ID_HEADER, KEY_ID)
		);

		helper.unmarshal(body, requestHeaders);
	}

	@Test(expected = SignatureValidationException.class)
	public void testUnmarshalStringInvalidSignature() throws IOException {
		WebhooksHelper helper = createHelper();

		InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

		String body = new String(readResource("valid-body.json"), CHARSET);
		List<RequestHeader> requestHeaders = Arrays.asList(
				new RequestHeader(SIGNATURE_HEADER, "1" + SIGNATURE),
				new RequestHeader(KEY_ID_HEADER, KEY_ID)
		);

		helper.unmarshal(body, requestHeaders);
	}

	private byte[] readResource(String resource) throws IOException {

		// the resources may contain \r but the body from which the signature was created doesn't
		// strip those out while reading

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		InputStream input = new BufferedInputStream(getClass().getResourceAsStream(resource));
		try {
			int b;
			while ((b = input.read()) != -1) {
				if (b != '\r') {
					output.write(b);
				}
			}
			return output.toByteArray();

		} finally {
			input.close();
		}
	}

	@Test
	public void testAreEqualSignaturesEqual() {

		final String signature = UUID.randomUUID().toString();
		final String large = repeat(signature, 100);

		Assert.assertTrue(WebhooksHelper.areEqualSignatures(signature, signature));
		Assert.assertTrue(WebhooksHelper.areEqualSignatures(large, large));
	}

	@Test
	public void testAreEqualSignaturesNotEqual() {

		final String signature = UUID.randomUUID().toString();
		final String large = repeat(signature, 100);

		Assert.assertFalse(WebhooksHelper.areEqualSignatures("abc", signature));
		Assert.assertFalse(WebhooksHelper.areEqualSignatures(signature, "abc"));
		Assert.assertFalse(WebhooksHelper.areEqualSignatures(signature + "1", signature));
		Assert.assertFalse(WebhooksHelper.areEqualSignatures(signature, signature + "1"));
		Assert.assertFalse(WebhooksHelper.areEqualSignatures(signature.toLowerCase(), signature.toUpperCase()));
		Assert.assertFalse(WebhooksHelper.areEqualSignatures(signature.toUpperCase(), signature.toLowerCase()));

		Assert.assertFalse(WebhooksHelper.areEqualSignatures("abc", large));
		Assert.assertFalse(WebhooksHelper.areEqualSignatures(large, "abc"));
		Assert.assertFalse(WebhooksHelper.areEqualSignatures(large + "1", large));
		Assert.assertFalse(WebhooksHelper.areEqualSignatures(large, large + "1"));
		Assert.assertFalse(WebhooksHelper.areEqualSignatures(large.toLowerCase(), large.toUpperCase()));
		Assert.assertFalse(WebhooksHelper.areEqualSignatures(large.toUpperCase(), large.toLowerCase()));

		Assert.assertFalse(WebhooksHelper.areEqualSignatures(signature, large));
		Assert.assertFalse(WebhooksHelper.areEqualSignatures(large, signature));
	}

	private String repeat(String s, int times) {
		StringBuilder sb = new StringBuilder(times * s.length());
		for (int i = 0; i < times; i++) {
			sb.append(s);
		}
		return sb.toString();
	}

	private WebhooksHelper createHelper() {
		return createHelper(DefaultMarshaller.INSTANCE);
	}

	private WebhooksHelper createHelper(Marshaller marshaller) {
		return new WebhooksHelper(marshaller, InMemorySecretKeyStore.INSTANCE);
	}
}
