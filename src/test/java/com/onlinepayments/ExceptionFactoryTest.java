package com.onlinepayments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.domain.APIError;
import com.onlinepayments.domain.CreatePaymentResponse;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.PaymentErrorResponse;
import com.onlinepayments.domain.PayoutErrorResponse;
import com.onlinepayments.domain.PayoutResult;
import com.onlinepayments.domain.RefundErrorResponse;
import com.onlinepayments.domain.RefundResponse;

class ExceptionFactoryTest {

    private ExceptionFactory factory;

    @BeforeEach
    void setUp() {
        factory = new ExceptionFactory();
    }

    @Nested
    class WhenCreatingExceptionFromPaymentErrorResponse {

        @Test
        void shouldReturnDeclinedPaymentExceptionWhenPaymentResultIsPresent() {
            ExceptionFactory factory = new ExceptionFactory();

            CreatePaymentResponse createPaymentResponse = new CreatePaymentResponse();

            PaymentErrorResponse errorResponse = new PaymentErrorResponse()
                    .withErrorId("payment-error-id")
                    .withErrors(Collections.emptyList())
                    .withPaymentResult(createPaymentResponse);

            RuntimeException exception = factory.createException(
                    402,
                    "{\"error\":\"declined\"}",
                    errorResponse,
                    null
            );

            assertInstanceOf(DeclinedPaymentException.class, exception);
            assertEquals(402, ((DeclinedPaymentException) exception).getStatusCode());
            assertEquals("{\"error\":\"declined\"}", ((DeclinedPaymentException) exception).getResponseBody());
            assertSame(createPaymentResponse, ((DeclinedPaymentException) exception).getCreatePaymentResponse());
        }

        @Test
        void shouldReturnValidationExceptionWhenPaymentResultIsAbsentAndStatusCodeIs400() {
            ExceptionFactory factory = new ExceptionFactory();

            List<APIError> errors = Collections.emptyList();

            PaymentErrorResponse errorResponse = new PaymentErrorResponse()
                    .withErrorId("payment-error-id")
                    .withErrors(errors)
                    .withPaymentResult(null);

            RuntimeException exception = factory.createException(
                    400,
                    "{\"error\":\"bad request\"}",
                    errorResponse,
                    null
            );

            assertInstanceOf(ValidationException.class, exception);
            assertEquals(400, ((ValidationException) exception).getStatusCode());
            assertEquals("{\"error\":\"bad request\"}", ((ValidationException) exception).getResponseBody());
            assertEquals("payment-error-id", ((ValidationException) exception).getErrorId());
            assertSame(errors, ((ValidationException) exception).getErrors());
        }
    }

    @Nested
    class WhenCreatingExceptionFromPayoutErrorResponse {

        @Test
        void shouldReturnDeclinedPayoutExceptionWhenPayoutResultIsPresent() {
            PayoutResult payoutResult = new PayoutResult()
                    .withId("payout-id")
                    .withStatus("REJECTED");

            PayoutErrorResponse errorResponse = new PayoutErrorResponse()
                    .withErrorId("payout-error-id")
                    .withErrors(Collections.emptyList())
                    .withPayoutResult(payoutResult);

            RuntimeException exception = factory.createException(
                    402,
                    "{\"error\":\"declined\"}",
                    errorResponse,
                    null
            );

            assertInstanceOf(DeclinedPayoutException.class, exception);
            assertEquals(402, ((DeclinedPayoutException) exception).getStatusCode());
            assertEquals("{\"error\":\"declined\"}", ((DeclinedPayoutException) exception).getResponseBody());
            assertSame(payoutResult, ((DeclinedPayoutException) exception).getPayoutResult());
        }

        @Test
        void shouldReturnValidationExceptionWhenPayoutResultIsAbsentAndStatusCodeIs400() {
            List<APIError> errors = Collections.emptyList();

            PayoutErrorResponse errorResponse = new PayoutErrorResponse()
                    .withErrorId("payout-error-id")
                    .withErrors(errors);

            RuntimeException exception = factory.createException(
                    400,
                    "{\"error\":\"bad request\"}",
                    errorResponse,
                    null
            );

            assertInstanceOf(ValidationException.class, exception);
            assertEquals(400, ((ValidationException) exception).getStatusCode());
            assertEquals("{\"error\":\"bad request\"}", ((ValidationException) exception).getResponseBody());
            assertEquals("payout-error-id", ((ValidationException) exception).getErrorId());
            assertSame(errors, ((ValidationException) exception).getErrors());
        }
    }

    @Nested
    class WhenCreatingExceptionFromRefundErrorResponse {

        @Test
        void shouldReturnDeclinedRefundExceptionWhenRefundResultIsPresent() {
            RefundResponse refundResponse = new RefundResponse()
                    .withId("refund-id")
                    .withStatus("REJECTED");

            RefundErrorResponse errorResponse = new RefundErrorResponse()
                    .withErrorId("refund-error-id")
                    .withErrors(Collections.emptyList())
                    .withRefundResult(refundResponse);

            RuntimeException exception = factory.createException(
                    402,
                    "{\"error\":\"declined\"}",
                    errorResponse,
                    null
            );

            assertInstanceOf(DeclinedRefundException.class, exception);
            assertEquals(402, ((DeclinedRefundException) exception).getStatusCode());
            assertEquals("{\"error\":\"declined\"}", ((DeclinedRefundException) exception).getResponseBody());
            assertSame(refundResponse, ((DeclinedRefundException) exception).getRefundResponse());
        }

        @Test
        void shouldReturnValidationExceptionWhenRefundResultIsAbsentAndStatusCodeIs400() {
            List<APIError> errors = Collections.emptyList();

            RefundErrorResponse errorResponse = new RefundErrorResponse()
                    .withErrorId("refund-error-id")
                    .withErrors(errors);

            RuntimeException exception = factory.createException(
                    400,
                    "{\"error\":\"bad request\"}",
                    errorResponse,
                    null
            );

            assertInstanceOf(ValidationException.class, exception);
            assertEquals(400, ((ValidationException) exception).getStatusCode());
            assertEquals("{\"error\":\"bad request\"}", ((ValidationException) exception).getResponseBody());
            assertEquals("refund-error-id", ((ValidationException) exception).getErrorId());
            assertSame(errors, ((ValidationException) exception).getErrors());
        }
    }

    @Nested
    class WhenCreatingExceptionFromGenericErrorResponse {

        @Test
        void shouldReturnValidationExceptionFor400() {
            RuntimeException exception = factory.createException(
                    400,
                    "{\"error\":\"bad request\"}",
                    createErrorResponse("error-id", Collections.emptyList()),
                    null
            );

            assertInstanceOf(ValidationException.class, exception);
        }

        @Test
        void shouldReturnAuthorizationExceptionFor403() {
            RuntimeException exception = factory.createException(
                    403,
                    "{\"error\":\"forbidden\"}",
                    createErrorResponse("error-id", Collections.emptyList()),
                    null
            );

            assertInstanceOf(AuthorizationException.class, exception);
        }

        @Test
        void shouldReturnReferenceExceptionFor404() {
            RuntimeException exception = factory.createException(
                    404,
                    "{\"error\":\"not found\"}",
                    createErrorResponse("error-id", Collections.emptyList()),
                    null
            );

            assertInstanceOf(ReferenceException.class, exception);
        }

        @Test
        void shouldReturnReferenceExceptionFor409WhenIdempotenceConditionsAreNotMet() {
            RuntimeException exception = factory.createException(
                    409,
                    "{\"error\":\"conflict\"}",
                    createErrorResponse("error-id", Collections.emptyList()),
                    null
            );

            assertInstanceOf(ReferenceException.class, exception);
        }

        @Test
        void shouldReturnIdempotenceExceptionFor409WhenIdempotenceConditionsAreMet() {
            APIError apiError = new APIError();
            apiError.setErrorCode("1409");

            List<APIError> errors = Collections.singletonList(apiError);

            CallContext context = new CallContext();
            context.withIdempotenceKey("idempotence-key");
            context.setIdempotenceRequestTimestamp(123456789L);

            RuntimeException exception = factory.createException(
                    409,
                    "{\"error\":\"duplicate\"}",
                    createErrorResponse("error-id", errors),
                    context
            );

            assertInstanceOf(IdempotenceException.class, exception);
            assertEquals("idempotence-key", ((IdempotenceException) exception).getIdempotenceKey());
            assertEquals(Long.valueOf(123456789L), ((IdempotenceException) exception).getIdempotenceRequestTimestamp());
        }

        @Test
        void shouldReturnReferenceExceptionFor410() {
            RuntimeException exception = factory.createException(
                    410,
                    "{\"error\":\"gone\"}",
                    createErrorResponse("error-id", Collections.emptyList()),
                    null
            );

            assertInstanceOf(ReferenceException.class, exception);
        }

        @Test
        void shouldReturnPlatformExceptionFor500() {
            RuntimeException exception = factory.createException(
                    500,
                    "{\"error\":\"platform\"}",
                    createErrorResponse("error-id", Collections.emptyList()),
                    null
            );

            assertInstanceOf(PlatformException.class, exception);
        }

        @Test
        void shouldReturnPlatformExceptionFor502() {
            RuntimeException exception = factory.createException(
                    502,
                    "{\"error\":\"platform\"}",
                    createErrorResponse("error-id", Collections.emptyList()),
                    null
            );

            assertInstanceOf(PlatformException.class, exception);
        }

        @Test
        void shouldReturnPlatformExceptionFor503() {
            RuntimeException exception = factory.createException(
                    503,
                    "{\"error\":\"platform\"}",
                    createErrorResponse("error-id", Collections.emptyList()),
                    null
            );

            assertInstanceOf(PlatformException.class, exception);
        }

        @Test
        void shouldReturnApiExceptionForUnexpectedStatusCode() {
            RuntimeException exception = factory.createException(
                    418,
                    "{\"error\":\"teapot\"}",
                    createErrorResponse("error-id", Collections.emptyList()),
                    null
            );

            assertInstanceOf(ApiException.class, exception);
        }
    }

    @Nested
    class WhenCreatingExceptionFromNullErrorObject {

        @Test
        void shouldReturnApiExceptionForUnexpectedStatusCode() {
            RuntimeException exception = factory.createException(
                    418,
                    "{\"error\":\"unknown\"}",
                    null,
                    null
            );

            assertInstanceOf(ApiException.class, exception);
            assertEquals(418, ((ApiException) exception).getStatusCode());
            assertEquals("{\"error\":\"unknown\"}", ((ApiException) exception).getResponseBody());
            assertNull(((ApiException) exception).getErrorId());
            assertNotNull(((ApiException) exception).getErrors());
            assertTrue(((ApiException) exception).getErrors().isEmpty());
        }
    }

    @Nested
    class WhenCreatingExceptionFromUnsupportedErrorObject {

        @Test
        void shouldThrowIllegalArgumentException() {
            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> factory.createException(400, "{\"error\":\"unsupported\"}", new Object(), null)
            );

            assertTrue(exception.getMessage().contains("unsupported error object type"));
        }
    }

    private ErrorResponse createErrorResponse(String errorId, List<APIError> errors) {
        return new ErrorResponse()
            .withErrorId(errorId)
            .withErrors(errors);
    }
}
