package com.ingenico.direct.defaultimpl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.localserver.LocalServerTestBase;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.ingenico.direct.Authenticator;
import com.ingenico.direct.CallContext;
import com.ingenico.direct.ClientInterface;
import com.ingenico.direct.Communicator;
import com.ingenico.direct.Connection;
import com.ingenico.direct.DeclinedPaymentException;
import com.ingenico.direct.Factory;
import com.ingenico.direct.IdempotenceException;
import com.ingenico.direct.MetaDataProvider;
import com.ingenico.direct.domain.Address;
import com.ingenico.direct.domain.AmountOfMoney;
import com.ingenico.direct.domain.Card;
import com.ingenico.direct.domain.CardPaymentMethodSpecificInput;
import com.ingenico.direct.domain.CreatePaymentRequest;
import com.ingenico.direct.domain.CreatePaymentResponse;
import com.ingenico.direct.domain.Customer;
import com.ingenico.direct.domain.Order;

@RunWith(MockitoJUnitRunner.class)
public class DefaultConnectionIdempotenceTest extends LocalServerTestBase {

	@Mock HttpRequestHandler requestHandler;

	@Test
	public void testIdempotenceFirstRequest() throws Exception {

		final String body = getResource("idempotence_success.json");
		final String idempotenceKey = UUID.randomUUID().toString();

		Map<String, String> responseHeaders = new HashMap<String, String>(1);
		responseHeaders.put("Location", "http://localhost/v2/1/payments/000000000100000000010000100001");

		Map<String, String> requestHeaders = new HashMap<String, String>();

		Mockito.doAnswer(setResponse(body, 201, responseHeaders, requestHeaders))
				.when(requestHandler).handle(Matchers.<HttpRequest>any(), Matchers.<HttpResponse>any(), Matchers.<HttpContext>any());

		serverBootstrap.registerHandler("/v2/1/payments", requestHandler);
		HttpHost host = start();

		CallContext context = new CallContext().withIdempotenceKey(idempotenceKey);

		ClientInterface client = createClient(host);
		try {

			CreatePaymentRequest request = createRequest();

			CreatePaymentResponse response = client.merchant("1").payments().createPayment(request, context);

			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getPayment());
			Assert.assertNotNull(response.getPayment().getId());

		} finally {
			client.close();
		}

		Assert.assertEquals(idempotenceKey, requestHeaders.get("X-GCS-Idempotence-Key"));

		Assert.assertEquals(idempotenceKey, context.getIdempotenceKey());
		Assert.assertNull(context.getIdempotenceRequestTimestamp());
	}

	@Test
	public void testIdempotenceSecondRequest() throws Exception {

		String body = getResource("idempotence_success.json");

		final Long idempotenceRequestTimestamp = System.currentTimeMillis();

		Map<String, String> responseHeaders = new HashMap<String, String>(2);
		responseHeaders.put("Location", "http://localhost/v2/1/payments/000000000100000000010000100001");
		responseHeaders.put("X-GCS-Idempotence-Request-Timestamp", idempotenceRequestTimestamp.toString());

		Map<String, String> requestHeaders = new HashMap<String, String>();

		Mockito.doAnswer(setResponse(body, 201, responseHeaders, requestHeaders))
				.when(requestHandler).handle(Matchers.<HttpRequest>any(), Matchers.<HttpResponse>any(), Matchers.<HttpContext>any());

		serverBootstrap.registerHandler("/v2/1/payments", requestHandler);
		HttpHost host = start();

		final String idempotenceKey = UUID.randomUUID().toString();
		CallContext context = new CallContext().withIdempotenceKey(idempotenceKey);

		ClientInterface client = createClient(host);
		try {

			CreatePaymentRequest request = createRequest();

			CreatePaymentResponse response = client.merchant("1").payments().createPayment(request, context);

			Assert.assertNotNull(response);
			Assert.assertNotNull(response.getPayment());
			Assert.assertNotNull(response.getPayment().getId());

		} finally {
			client.close();
		}

		Assert.assertEquals(idempotenceKey, requestHeaders.get("X-GCS-Idempotence-Key"));

		Assert.assertEquals(idempotenceKey, context.getIdempotenceKey());
		Assert.assertEquals(idempotenceRequestTimestamp, context.getIdempotenceRequestTimestamp());
	}

	@Test
	public void testIdempotenceFirstFailure() throws Exception {

		String body = getResource("idempotence_rejected.json");

		Map<String, String> responseHeaders = new HashMap<String, String>();

		Map<String, String> requestHeaders = new HashMap<String, String>();

		Mockito.doAnswer(setResponse(body, 402, responseHeaders, requestHeaders))
				.when(requestHandler).handle(Matchers.<HttpRequest>any(), Matchers.<HttpResponse>any(), Matchers.<HttpContext>any());

		serverBootstrap.registerHandler("/v2/1/payments", requestHandler);
		HttpHost host = start();

		final String idempotenceKey = UUID.randomUUID().toString();
		CallContext context = new CallContext().withIdempotenceKey(idempotenceKey);

		ClientInterface client = createClient(host);
		try {

			CreatePaymentRequest request = createRequest();

			client.merchant("1").payments().createPayment(request, context);

			Assert.fail("Expected DeclinedPaymentException");

		} catch (DeclinedPaymentException e) {

			Assert.assertEquals(402, e.getStatusCode());
			Assert.assertEquals(body, e.getResponseBody());

		} finally {
			client.close();
		}

		Assert.assertEquals(idempotenceKey, requestHeaders.get("X-GCS-Idempotence-Key"));

		Assert.assertEquals(idempotenceKey, context.getIdempotenceKey());
		Assert.assertNull(context.getIdempotenceRequestTimestamp());
	}

	@Test
	public void testIdempotenceSecondFailure() throws Exception {

		String body = getResource("idempotence_rejected.json");

		final Long idempotenceRequestTimestamp = System.currentTimeMillis();

		Map<String, String> responseHeaders = new HashMap<String, String>(2);
		responseHeaders.put("X-GCS-Idempotence-Request-Timestamp", idempotenceRequestTimestamp.toString());

		Map<String, String> requestHeaders = new HashMap<String, String>();

		Mockito.doAnswer(setResponse(body, 402, responseHeaders, requestHeaders))
				.when(requestHandler).handle(Matchers.<HttpRequest>any(), Matchers.<HttpResponse>any(), Matchers.<HttpContext>any());

		serverBootstrap.registerHandler("/v2/1/payments", requestHandler);
		HttpHost host = start();

		final String idempotenceKey = UUID.randomUUID().toString();
		CallContext context = new CallContext().withIdempotenceKey(idempotenceKey);

		ClientInterface client = createClient(host);
		try {

			CreatePaymentRequest request = createRequest();

			client.merchant("1").payments().createPayment(request, context);

			Assert.fail("Expected DeclinedPaymentException");

		} catch (DeclinedPaymentException e) {

			Assert.assertEquals(402, e.getStatusCode());
			Assert.assertEquals(body, e.getResponseBody());

		} finally {
			client.close();
		}

		Assert.assertEquals(idempotenceKey, requestHeaders.get("X-GCS-Idempotence-Key"));

		Assert.assertEquals(idempotenceKey, context.getIdempotenceKey());
		Assert.assertEquals(idempotenceRequestTimestamp, context.getIdempotenceRequestTimestamp());
	}

	@Test
	public void testIdempotenceDuplicateRequest() throws Exception {

		String body = getResource("idempotence_duplicate_failure.json");

		final Long idempotenceRequestTimestamp = System.currentTimeMillis();

		Map<String, String> responseHeaders = new HashMap<String, String>(2);
		responseHeaders.put("Location", "http://localhost/v2/1/payments/000000000100000000010000100001");
		responseHeaders.put("X-GCS-Idempotence-Request-Timestamp", idempotenceRequestTimestamp.toString());

		Map<String, String> requestHeaders = new HashMap<String, String>();

		Mockito.doAnswer(setResponse(body, 409, responseHeaders, requestHeaders))
				.when(requestHandler).handle(Matchers.<HttpRequest>any(), Matchers.<HttpResponse>any(), Matchers.<HttpContext>any());

		serverBootstrap.registerHandler("/v2/1/payments", requestHandler);
		HttpHost host = start();

		final String idempotenceKey = UUID.randomUUID().toString();
		CallContext context = new CallContext().withIdempotenceKey(idempotenceKey);

		ClientInterface client = createClient(host);
		try {

			CreatePaymentRequest request = createRequest();

			client.merchant("1").payments().createPayment(request, context);

			Assert.fail("Expected IdempotenceException");

		} catch (IdempotenceException e) {

			Assert.assertEquals(409, e.getStatusCode());
			Assert.assertEquals(body, e.getResponseBody());
			Assert.assertEquals(idempotenceKey, e.getIdempotenceKey());
			Assert.assertEquals(idempotenceRequestTimestamp, e.getIdempotenceRequestTimestamp());

		} finally {
			client.close();
		}

		Assert.assertEquals(idempotenceKey, requestHeaders.get("X-GCS-Idempotence-Key"));

		Assert.assertEquals(idempotenceKey, context.getIdempotenceKey());
		Assert.assertEquals(idempotenceRequestTimestamp, context.getIdempotenceRequestTimestamp());
	}

	private String getResource(String resource) {
		StringWriter sw = new StringWriter();
		try {
			Reader reader = new InputStreamReader(getClass().getResourceAsStream(resource));
			try {
				char[] buffer = new char[1024];
				int len;
				while ((len = reader.read(buffer)) != -1) {
					sw.write(buffer, 0, len);
				}
			} finally {
				reader.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return sw.toString();
	}

	private Answer<Void> setResponse(final String body, final int statusCode, final Map<String, String> responseHeaders,
			final Map<String, String> requestHeaders) {

		return new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) {
				HttpRequest request = invocation.getArgumentAt(0, HttpRequest.class);
				HttpResponse response = invocation.getArgumentAt(1, HttpResponse.class);

				if (requestHeaders != null) {
					for (Header header : request.getAllHeaders()) {
						requestHeaders.put(header.getName(), header.getValue());
					}
				}

				response.setStatusCode(statusCode);
				response.setHeader("Content-Type", "application/json");

				for (Map.Entry<String, String> entry : responseHeaders.entrySet()) {
					response.setHeader(entry.getKey(), entry.getValue());
				}

				response.setEntity(new StringEntity(body, ContentType.APPLICATION_JSON));

				return null;
			}
		};
	}

	@SuppressWarnings("resource")
	private ClientInterface createClient(HttpHost host) {

		Connection connection = new DefaultConnection(500, 500);
		Authenticator authenticator = new DefaultAuthenticator("apiKey", "secret");
		MetaDataProvider metaDataProvider = new MetaDataProvider("Ingenico");
		Communicator communicator = Factory.createCommunicator(URI.create(host.toURI()), connection, authenticator, metaDataProvider);
		return Factory.createClient(communicator);
	}

	private CreatePaymentRequest createRequest() {

		CreatePaymentRequest body = new CreatePaymentRequest();

		Order order = new Order();

		AmountOfMoney amountOfMoney = new AmountOfMoney();
		amountOfMoney.setAmount(2345L);
		amountOfMoney.setCurrencyCode("CAD");
		order.setAmountOfMoney(amountOfMoney);

		Customer customer = new Customer();

		Address billingAddress = new Address();
		billingAddress.setCountryCode("CA");
		customer.setBillingAddress(billingAddress);

		order.setCustomer(customer);

		CardPaymentMethodSpecificInput cardPaymentMethodSpecificInput = new CardPaymentMethodSpecificInput();
		cardPaymentMethodSpecificInput.setPaymentProductId(1);

		Card card = new Card();
		card.setCvv("123");
		card.setCardNumber("4567350000427977");
		card.setExpiryDate("1230");
		cardPaymentMethodSpecificInput.setCard(card);

		body.setCardPaymentMethodSpecificInput(cardPaymentMethodSpecificInput);

		return body;
	}
}
