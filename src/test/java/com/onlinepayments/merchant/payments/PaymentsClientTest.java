package com.onlinepayments.merchant.payments;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.http.impl.io.EmptyInputStream;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.onlinepayments.ApiException;
import com.onlinepayments.CallContext;
import com.onlinepayments.ClientInterface;
import com.onlinepayments.CommunicationException;
import com.onlinepayments.Connection;
import com.onlinepayments.DeclinedPaymentException;
import com.onlinepayments.Factory;
import com.onlinepayments.IdempotenceException;
import com.onlinepayments.MetaDataProvider;
import com.onlinepayments.NotFoundException;
import com.onlinepayments.PaymentPlatformException;
import com.onlinepayments.ReferenceException;
import com.onlinepayments.RequestHeader;
import com.onlinepayments.ResponseException;
import com.onlinepayments.ResponseHandler;
import com.onlinepayments.ResponseHeader;
import com.onlinepayments.ValidationException;
import com.onlinepayments.defaultimpl.DefaultAuthenticator;
import com.onlinepayments.domain.Address;
import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.Card;
import com.onlinepayments.domain.CardPaymentMethodSpecificInput;
import com.onlinepayments.domain.CreatePaymentRequest;
import com.onlinepayments.domain.CreatePaymentResponse;
import com.onlinepayments.domain.Customer;
import com.onlinepayments.domain.Order;

@RunWith(MockitoJUnitRunner.class)
public class PaymentsClientTest {

	public static final URI API_ENDPOINT = URI.create("http://localhost");
	public static final DefaultAuthenticator AUTHENTICATOR = new DefaultAuthenticator("test" , "test");
	public static final MetaDataProvider META_DATA_PROVIDER = new MetaDataProvider("OnlinePayments");
	@Mock private Connection connection;

	/**
	 * Tests that a non-failure response will not throw an exception.
	 */
	@Test
	@SuppressWarnings("resource")
	public void testCreateSuccess() {

		ClientInterface client = getClient();
		String responseBody = getResource("pending_capture.json");
		mockPost(201, responseBody);

		CreatePaymentRequest body = createRequest();

		CreatePaymentResponse response = client.merchant("merchantId").payments().createPayment(body);
		Assert.assertEquals("1_0", response.getPayment().getId());
		Assert.assertEquals("PENDING_CAPTURE", response.getPayment().getStatus());
	}

	/**
	 * Tests that a failure response with a payment result will throw a {@link DeclinedPaymentException}.
	 */
	@Test
	@SuppressWarnings("resource")
	public void testCreateRejected() {

		ClientInterface client = getClient();
		String responseBody = getResource("rejected.json");
		mockPost(400, responseBody);

		CreatePaymentRequest body = createRequest();

		try {
			client.merchant("merchantId").payments().createPayment(body);
			Assert.fail("Expected DeclinedPaymentException");
		} catch (DeclinedPaymentException e) {
			Assert.assertTrue(e.toString().contains("payment '1_0'"));
			Assert.assertTrue(e.toString().contains("status 'REJECTED'"));
			Assert.assertTrue(e.toString().contains(responseBody));
			Assert.assertNotNull(e.getCreatePaymentResult());
			Assert.assertEquals("1_0", e.getCreatePaymentResult().getPayment().getId());
			Assert.assertEquals("REJECTED", e.getCreatePaymentResult().getPayment().getStatus());
		}
	}

	/**
	 * Tests that a 400 failure response without a payment result will throw a {@link ValidationException}.
	 */
	@Test
	@SuppressWarnings("resource")
	public void testCreateInvalidRequest() {

		ClientInterface client = getClient();
		String responseBody = getResource("invalid_request.json");
		mockPost(400, responseBody);

		CreatePaymentRequest body = createRequest();

		try {
			client.merchant("merchantId").payments().createPayment(body);
			Assert.fail("Expected ValidationException");
		} catch (ValidationException e) {
			Assert.assertTrue(e.toString().contains(responseBody));
		}
	}

	/**
	 * Tests that a 401 failure response without a payment result will throw a {@link ApiException}.
	 */
	@Test
	@SuppressWarnings("resource")
	public void testCreateInvalidAuthorization() {

		ClientInterface client = getClient();
		String responseBody = getResource("invalid_authorization.json");
		mockPost(401, responseBody);

		CreatePaymentRequest body = createRequest();

		try {
			client.merchant("merchantId").payments().createPayment(body);
			Assert.fail("Expected ApiException");
		} catch (ApiException e) {
			Assert.assertTrue(e.toString().contains(responseBody));
		}
	}

	/**
	 * Tests that a 409 failure response with a duplicate request code but without an idempotence key will throw a
	 * {@link ReferenceException}.
	 */
	@Test
	@SuppressWarnings("resource")
	public void testCreateReferenceError() {

		ClientInterface client = getClient();
		String responseBody = getResource("duplicate_request.json");
		mockPost(409, responseBody);

		CreatePaymentRequest body = createRequest();

		try {
			client.merchant("merchantId").payments().createPayment(body);
			Assert.fail("Expected ApiException");
		} catch (ReferenceException e) {
			Assert.assertTrue(e.toString().contains(responseBody));
		}
	}

	/**
	 * Tests that a 409 failure response with a duplicate request code and an idempotence key will throw an {@link IdempotenceException}.
	 */
	@Test
	@SuppressWarnings("resource")
	public void testCreateIdempotenceError() {

		ClientInterface client = getClient();
		String responseBody = getResource("duplicate_request.json");
		mockPost(409, responseBody);

		CreatePaymentRequest body = createRequest();

		CallContext context = new CallContext().withIdempotenceKey("key");

		try {
			client.merchant("merchantId").payments().createPayment(body, context);
			Assert.fail("Expected ApiException");
		} catch (IdempotenceException e) {
			Assert.assertTrue(e.toString().contains(responseBody));
			Assert.assertEquals(context.getIdempotenceKey(), e.getIdempotenceKey());
		}
	}

	/**
	 * Tests that a 404 response with a non-JSON response will throw a {@link NotFoundException}.
	 */
	@Test
	@SuppressWarnings("resource")
	public void testCreateNotFound() {

		ClientInterface client = getClient();
		String responseBody = getResource("not_found.html");
		mockPost(404, responseBody, new ResponseHeader("content-type", "text/html"));

		CreatePaymentRequest body = createRequest();

		try {
			client.merchant("merchantId").payments().createPayment(body);
			Assert.fail("Expected NotFoundException");
		} catch (NotFoundException e) {
			Assert.assertNotNull(e.getCause());
			Assert.assertEquals(ResponseException.class, e.getCause().getClass());
			Assert.assertTrue(e.getCause().toString().contains(responseBody));
		}
	}

	/**
	 * Tests that a 405 response with a non-JSON response will throw a {@link CommunicationException}.
	 */
	@Test
	@SuppressWarnings("resource")
	public void testCreateMethodNotAllowed() {

		ClientInterface client = getClient();
		String responseBody = getResource("method_not_allowed.html");
		mockPost(405, responseBody, new ResponseHeader("content-type", "text/html"));

		CreatePaymentRequest body = createRequest();

		try {
			client.merchant("merchantId").payments().createPayment(body);
			Assert.fail("Expected CommunicationException");
		} catch (CommunicationException e) {
			Assert.assertNotNull(e.getCause());
			Assert.assertEquals(ResponseException.class, e.getCause().getClass());
			Assert.assertTrue(e.getCause().toString().contains(responseBody));
		}
	}

	/**
	 * Tests that a 500 response with a JSON response with no body will throw a {@link PaymentPlatformException} and not a {@link NullPointerException}.
	 */
	@Test
	@SuppressWarnings("resource")
	public void testCreateInternalServerErrorWithoutBody() {

		ClientInterface client = getClient();
		String responseBody = null;
		mockPost(500, responseBody, new ResponseHeader("content-type", "text/html"));

		CreatePaymentRequest body = createRequest();

		try {
			client.merchant("merchantId").payments().createPayment(body);
			Assert.fail("Expected OnlinePaymentsException");
		} catch (PaymentPlatformException e) {
			Assert.assertEquals("", e.getResponseBody());
			Assert.assertNull(e.getErrorId());
			Assert.assertEquals(0, e.getErrors().size());
		}
	}

	private ClientInterface getClient() {
		return Factory.createClient(API_ENDPOINT, connection, AUTHENTICATOR, META_DATA_PROVIDER);
	}

	@SuppressWarnings({ "unchecked", "resource" })
	private <R> void mockPost(final int statusCode, final String responseBody, final ResponseHeader... headers) {
		when(connection.post(any(URI.class), anyListOf(RequestHeader.class), anyString(), any(ResponseHandler.class))).thenAnswer(new Answer<R>() {
			@Override
			public R answer(InvocationOnMock invocation) {
				ResponseHandler<R> responseHandler = invocation.getArgumentAt(3, ResponseHandler.class);
				InputStream bodyStream = responseBody != null ? toInputStream(responseBody) : EmptyInputStream.INSTANCE;
				return responseHandler.handleResponse(statusCode, bodyStream, Arrays.asList(headers));
			}
		});
	}

	private String getResource(String resource) {
		StringWriter sw = new StringWriter();
		try {
			Reader reader = new InputStreamReader(getClass().getResourceAsStream(resource), Charset.forName("UTF-8"));
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

	private InputStream toInputStream(String content) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		OutputStreamWriter output = new OutputStreamWriter(baos, Charset.forName("UTF-8"));
		try {
			output.write(content);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				output.close();
			} catch (@SuppressWarnings("unused") IOException e) {
				// ignore
			}
		}
		return new ByteArrayInputStream(baos.toByteArray());
	}

	private CreatePaymentRequest createRequest() {

		AmountOfMoney amountOfMoney = new AmountOfMoney()
                .withAmount(2345L)
                .withCurrencyCode("EUR");

		Address billingAddress = new Address()
                .withCountryCode("BE");

        Customer customer = new Customer()
                .withBillingAddress(billingAddress);

        Order order = new Order()
                .withAmountOfMoney(amountOfMoney)
                .withCustomer(customer);

		Card card = new Card()
                .withCvv("123")
                .withCardNumber("4567350000427977")
                .withExpiryDate("1230");

        CardPaymentMethodSpecificInput cardPaymentMethodSpecificInput = new CardPaymentMethodSpecificInput()
                .withPaymentProductId(1)
                .withCard(card);

        return new CreatePaymentRequest()
                .withOrder(order)
                .withCardPaymentMethodSpecificInput(cardPaymentMethodSpecificInput);
	}
}
