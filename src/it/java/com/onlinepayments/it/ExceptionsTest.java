package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.ApiException;
import com.onlinepayments.AuthorizationException;
import com.onlinepayments.CallContext;
import com.onlinepayments.ClientInterface;
import com.onlinepayments.CommunicatorConfiguration;
import com.onlinepayments.DeclinedPaymentException;
import com.onlinepayments.DeclinedPayoutException;
import com.onlinepayments.DeclinedRefundException;
import com.onlinepayments.DeclinedTransactionException;
import com.onlinepayments.Factory;
import com.onlinepayments.ReferenceException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.APIError;
import com.onlinepayments.domain.CreatePaymentRequest;
import com.onlinepayments.domain.CreatePaymentResponse;
import com.onlinepayments.domain.CreatePayoutRequest;
import com.onlinepayments.domain.PayoutResult;
import com.onlinepayments.domain.RefundResponse;
import com.onlinepayments.it.util.SdkTestHelper;
import com.onlinepayments.it.util.common.CreatePaymentRequestBuilder;
import com.onlinepayments.it.util.payments.CapturePaymentRequestBuilder;
import com.onlinepayments.it.util.payments.RefundRequestBuilder;
import com.onlinepayments.it.util.payout.CreatePayoutRequestBuilder;
import com.onlinepayments.merchant.payments.PaymentsClientInterface;
import com.onlinepayments.merchant.payouts.PayoutsClientInterface;

public class ExceptionsTest extends ItTest {

    private static final String NON_EXISTING_PAYMENT_ID = "9999999999_0";
    private static final String INVALID_MERCHANT_ID = "000000";
    private static final String CURRENCY_CODE = "EUR";
    private static final int OVERSHOOT_PAYOUT_AMOUNT = 999999999;
    private static final long DECLINED_REFUND_AMOUNT = 1500L;

    private ClientInterface client;
    private PaymentsClientInterface paymentsClient;
    private PayoutsClientInterface payoutsClient;

    private SdkTestHelper sdkTestHelper;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        paymentsClient = client.merchant(getMerchantId()).payments();
        payoutsClient = client.merchant(getMerchantId()).payouts();

        sdkTestHelper = getSdkTestHelper(client);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenTestingExceptionErrors {

        @Test
        void shouldThrowResponseExceptionWithErrorIdAndAPIError() {
            CreatePaymentRequest request = new CreatePaymentRequestBuilder()
                    .withCardNumber("123")
                    .build();

            ValidationException exception = assertThrows(
                    ValidationException.class,
                    () -> paymentsClient.createPayment(request));

            assertNotNull(exception);
            assertNotNull(exception.getErrorId());
            assertFalse(exception.getErrorId().isEmpty());
            assertNotNull(exception.getErrors());
            assertEquals(1, exception.getErrors().size());

            APIError error = exception.getErrors().get(0);
            assertNotNull(error);
            assertNotNull(error.getId());
            assertNotNull(error.getHttpStatusCode());
        }
    }

    @Nested
    class WhenTestingValidationException {

        @Test
        void shouldThrowValidationExceptionForInvalidCurrency() {
            CreatePayoutRequest request = new CreatePayoutRequestBuilder()
                    .withAmount(1000)
                    .withCurrency("INVALID")
                    .build();

            ValidationException exception = assertThrows(
                    ValidationException.class,
                    () -> payoutsClient.createPayout(request));

            assertNotNull(exception);
            assertEquals(400, exception.getStatusCode());
            assertNotNull(exception.getErrorId());
            assertNotNull(exception.getErrors());
            assertFalse(exception.getErrors().isEmpty());

            APIError error = exception.getErrors().get(0);
            assertEquals("INVALID_VALUE", error.getId());
            assertEquals(400, error.getHttpStatusCode());
        }

        @Test
        void shouldThrowValidationExceptionWithMultipleAPIErrors() {
            CreatePaymentRequest request = new CreatePaymentRequestBuilder()
                    .withCardNumber("123")
                    .withCvv("")
                    .withExpiryDate("invalid")
                    .build();

            ValidationException exception = assertThrows(
                    ValidationException.class,
                    () -> paymentsClient.createPayment(request));

            assertNotNull(exception);
            assertEquals(400, exception.getStatusCode());
            assertNotNull(exception.getErrors());
            assertFalse(exception.getErrors().isEmpty());

            for (APIError error : exception.getErrors()) {
                assertNotNull(error.getId());
                assertNotNull(error.getHttpStatusCode());
                assertEquals(400, error.getHttpStatusCode());
            }
        }
    }

    @Nested
    class WhenTestingAuthorizationException {

        @Test
        void shouldThrowAuthorizationExceptionForInvalidMerchantId() throws URISyntaxException, IOException {
            ClientInterface invalidClient = null;

            try {
                CommunicatorConfiguration config = getCommunicatorConfiguration();
                invalidClient = Factory.createClient(config);

                CreatePaymentRequest request = new CreatePaymentRequestBuilder().build();
                PaymentsClientInterface invalidPaymentsClient = invalidClient.merchant(INVALID_MERCHANT_ID).payments();

                AuthorizationException exception = assertThrows(
                        AuthorizationException.class,
                        () -> invalidPaymentsClient.createPayment(request));

                assertNotNull(exception);
                assertEquals(403, exception.getStatusCode());
                assertNotNull(exception.getResponseBody());
                assertNotNull(exception.getErrorId());
                assertNotNull(exception.getErrors());
                assertFalse(exception.getErrors().isEmpty());

                APIError error = exception.getErrors().get(0);
                assertNotNull(error.getId());
                assertEquals(403, error.getHttpStatusCode());
            } finally {
                if (invalidClient != null) {
                    invalidClient.close();
                }
            }
        }
    }

    @Nested
    class WhenTestingDeclinedPaymentException {

        @Test
        void shouldThrowDeclinedPaymentExceptionForPaymentCreate() {
            CreatePaymentRequest request = new CreatePaymentRequestBuilder()
                    .withCardNumber("4321456998744563")
                    .build();

            DeclinedPaymentException exception = assertThrows(
                    DeclinedPaymentException.class,
                    () -> paymentsClient.createPayment(request));

            assertNotNull(exception);
            assertTrue(exception.getStatusCode() >= 400);
            assertNotNull(exception.getResponseBody());

            CreatePaymentResponse paymentResponse = exception.getCreatePaymentResponse();
            assertNotNull(paymentResponse);
            assertNotNull(paymentResponse.getPayment());
            assertNotNull(paymentResponse.getPayment().getId());
            assertNotNull(paymentResponse.getPayment().getStatus());
            assertEquals("REJECTED", paymentResponse.getPayment().getStatus());
        }
    }

    @Nested
    class WhenTestingDeclinedPayoutException {

        @Test
        void shouldThrowDeclinedPayoutExceptionForInvalidPayout() {
            CreatePayoutRequest request = new CreatePayoutRequestBuilder()
                    .withCardNumber("4321456998744563")
                    .build();

            DeclinedPayoutException exception = assertThrows(
                    DeclinedPayoutException.class,
                    () -> payoutsClient.createPayout(request));

            assertNotNull(exception);
            assertTrue(exception.getStatusCode() >= 400);
            assertNotNull(exception.getResponseBody());

            PayoutResult payoutResult = exception.getPayoutResult();
            assertNotNull(payoutResult);
            assertNotNull(payoutResult.getId());
            assertNotNull(payoutResult.getStatus());
            assertEquals("REJECTED_CREDIT", payoutResult.getStatus());
        }
    }

    @Nested
    class WhenTestingApiException {

        @Test
        void shouldThrowApiExceptionForUnknownStatusCode() {
            CreatePaymentRequest request = new CreatePaymentRequestBuilder()
                    .withCardNumber("123")
                    .build();

            ApiException exception = assertThrows(
                    ApiException.class,
                    () -> paymentsClient.createPayment(request));

            assertNotNull(exception);
            assertTrue(exception.getStatusCode() >= 400);
            assertNotNull(exception.getResponseBody());
            assertNotNull(exception.getErrorId());
            assertNotNull(exception.getErrors());
        }
    }

    @Nested
    class WhenTestingDeclinedTransactionException {

        @Test
        void shouldThrowDeclinedTransactionExceptionAsParentType() {
            CreatePaymentRequest request = new CreatePaymentRequestBuilder()
                    .withCardNumber("4321456998744563")
                    .build();

            DeclinedTransactionException exception = assertThrows(
                    DeclinedTransactionException.class,
                    () -> paymentsClient.createPayment(request));

            assertNotNull(exception);
            assertInstanceOf(DeclinedPaymentException.class, exception);
            assertNotNull(exception.getResponseBody());
        }
    }

    @Nested
    class WhenTestingIdempotenceException {

        @Test
        void shouldThrowIdempotenceException() throws InterruptedException {
            String idempotenceKey = UUID.randomUUID().toString();
            CreatePaymentRequest request = new CreatePaymentRequestBuilder().build();

            CallContext firstContext = new CallContext().withIdempotenceKey(idempotenceKey);
            CallContext secondContext = new CallContext().withIdempotenceKey(idempotenceKey);

            CompletableFuture<CreatePaymentResponse> firstFuture = CompletableFuture.supplyAsync(
                    () -> paymentsClient.createPayment(request, firstContext));
            CompletableFuture<CreatePaymentResponse> secondFuture = CompletableFuture.supplyAsync(
                    () -> paymentsClient.createPayment(request, secondContext));

            Throwable firstException = null;
            Throwable secondException = null;

            try {
                firstFuture.get();
            } catch (ExecutionException e) {
                firstException = e.getCause();
            }

            try {
                secondFuture.get();
            } catch (ExecutionException e) {
                secondException = e.getCause();
            }

            if (firstException == null) {
                assertNotNull(secondException);
                assertInstanceOf(ReferenceException.class, secondException);
                assertNotNull(((ReferenceException) secondException).getErrors());
                assertNotNull(((ReferenceException) secondException).getErrors().get(0));
                assertEquals(409, ((ReferenceException) secondException).getErrors().get(0).getHttpStatusCode());
                assertEquals("DUPLICATE_REQUEST_IN_PROGRESS", ((ReferenceException) secondException).getErrors().get(0).getId());
            }

            if (secondException == null) {
                assertNotNull(firstException);
                assertInstanceOf(ReferenceException.class, firstException);
                assertNotNull(((ReferenceException) firstException).getErrors());
                assertNotNull(((ReferenceException) firstException).getErrors().get(0));
                assertEquals(409, ((ReferenceException) firstException).getErrors().get(0).getHttpStatusCode());
                assertEquals("DUPLICATE_REQUEST_IN_PROGRESS", ((ReferenceException) firstException).getErrors().get(0).getId());
            }
        }
    }

    @Disabled("Test is skipped because the action could not be triggered in the current merchant setup.")
    @Nested
    class WhenTestingDeclinedRefundException {

        @Test
        void shouldThrowDeclinedRefundException() {
            String paymentId = sdkTestHelper.createPaymentAndGetId(DECLINED_REFUND_AMOUNT, CURRENCY_CODE);
            paymentsClient.capturePayment(paymentId, new CapturePaymentRequestBuilder().build());

            DeclinedRefundException exception = assertThrows(
                    DeclinedRefundException.class,
                    () -> paymentsClient.refundPayment(paymentId, new RefundRequestBuilder()
                            .withAmount(DECLINED_REFUND_AMOUNT)
                            .withCurrency(CURRENCY_CODE)
                            .build()));

            assertNotNull(exception);
            assertTrue(exception.getStatusCode() >= 400);
            assertNotNull(exception.getResponseBody());

            RefundResponse refundResponse = exception.getRefundResponse();
            assertNotNull(refundResponse);
            assertNotNull(refundResponse.getId());
            assertNotNull(refundResponse.getStatus());
        }
    }

    @Nested
    class WhenTestingErrorIdInAllExceptions {

        @Test
        void shouldHaveErrorIdInValidationException() {
            CreatePaymentRequest request = new CreatePaymentRequestBuilder()
                    .withCardNumber("123")
                    .build();

            ValidationException exception = assertThrows(
                    ValidationException.class,
                    () -> paymentsClient.createPayment(request));

            assertNotNull(exception.getErrorId());
            assertFalse(exception.getErrorId().isEmpty());
        }

        @Test
        void shouldHaveErrorIdInReferenceException() {
            ReferenceException exception = assertThrows(
                    ReferenceException.class,
                    () -> paymentsClient.getPayment(NON_EXISTING_PAYMENT_ID));

            assertNotNull(exception.getErrorId());
            assertFalse(exception.getErrorId().isEmpty());
        }

        @Test
        void shouldHaveErrorIdInAuthorizationException() throws URISyntaxException, IOException {
            ClientInterface invalidClient = null;

            try {
                CommunicatorConfiguration config = getCommunicatorConfiguration();
                invalidClient = Factory.createClient(config);

                CreatePaymentRequest request = new CreatePaymentRequestBuilder().build();
                PaymentsClientInterface invalidPaymentsClient = invalidClient.merchant(INVALID_MERCHANT_ID).payments();

                AuthorizationException exception = assertThrows(
                        AuthorizationException.class,
                        () -> invalidPaymentsClient.createPayment(request));

                assertNotNull(exception.getErrorId());
                assertFalse(exception.getErrorId().isEmpty());
            } finally {
                if (invalidClient != null) {
                    invalidClient.close();
                }
            }
        }
    }
}
