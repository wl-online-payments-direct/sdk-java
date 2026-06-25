package com.onlinepayments.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.ApiException;
import com.onlinepayments.DeclinedTransactionException;
import com.onlinepayments.domain.APIError;

class DeclinedTransactionExceptionTest {

    /**
     * Concrete implementation of DeclinedTransactionException for testing
     */
    private static class TestDeclinedTransactionException extends DeclinedTransactionException {
        TestDeclinedTransactionException(int statusCode, String responseBody, String errorId, List<APIError> errors) {
            super(statusCode, responseBody, errorId, errors);
        }

        TestDeclinedTransactionException(String message, int statusCode, String responseBody, String errorId, List<APIError> errors) {
            super(message, statusCode, responseBody, errorId, errors);
        }
    }

    @Nested
    class WhenConstructingWithoutMessage {

        @Test
        void shouldStoreStatusCode() {
            DeclinedTransactionException exception = new TestDeclinedTransactionException(
                    402,
                    "{\"error\":\"declined\"}",
                    null,
                    null
            );

            assertEquals(402, exception.getStatusCode());
        }

        @Test
        void shouldStoreResponseBody() {
            DeclinedTransactionException exception = new TestDeclinedTransactionException(
                    402,
                    "{\"error\":\"declined\"}",
                    null,
                    null
            );

            assertEquals("{\"error\":\"declined\"}", exception.getResponseBody());
        }

        @Test
        void shouldStoreNullErrorId() {
            DeclinedTransactionException exception = new TestDeclinedTransactionException(
                    402,
                    "{\"error\":\"declined\"}",
                    null,
                    null
            );

            assertNull(exception.getErrorId());
        }

        @Test
        void shouldStoreNullErrors() {
            DeclinedTransactionException exception = new TestDeclinedTransactionException(
                    402,
                    "{\"error\":\"declined\"}",
                    null,
                    null
            );

            // ApiException converts null errors to empty list
            assertEquals(0, exception.getErrors().size());
        }

        @Test
        void shouldExtendApiException() {
            DeclinedTransactionException exception = new TestDeclinedTransactionException(
                    402,
                    "{\"error\":\"declined\"}",
                    null,
                    null
            );

            assertInstanceOf(ApiException.class, exception);
        }

        @Test
        void shouldAllowNullResponseBody() {
            DeclinedTransactionException exception = new TestDeclinedTransactionException(
                    402,
                    null,
                    null,
                    null
            );

            assertNull(exception.getResponseBody());
        }

        @Test
        void shouldAllowVariousStatusCodes() {
            DeclinedTransactionException exception400 = new TestDeclinedTransactionException(400, "{}", null, null);
            DeclinedTransactionException exception402 = new TestDeclinedTransactionException(402, "{}", null, null);
            DeclinedTransactionException exception500 = new TestDeclinedTransactionException(500, "{}", null, null);

            assertEquals(400, exception400.getStatusCode());
            assertEquals(402, exception402.getStatusCode());
            assertEquals(500, exception500.getStatusCode());
        }

        @Test
        void shouldStoreErrorIdWhenProvided() {
            DeclinedTransactionException exception = new TestDeclinedTransactionException(
                    402,
                    "{\"error\":\"declined\"}",
                    "error-id-123",
                    null
            );

            assertEquals("error-id-123", exception.getErrorId());
        }

        @Test
        void shouldStoreErrorsWhenProvided() {
            List<APIError> errors = new ArrayList<>();
            APIError error = new APIError();
            errors.add(error);

            DeclinedTransactionException exception = new TestDeclinedTransactionException(
                    402,
                    "{\"error\":\"declined\"}",
                    "error-id",
                    errors
            );

            assertEquals(1, exception.getErrors().size());
            assertSame(error, exception.getErrors().get(0));
        }
    }

    @Nested
    class WhenConstructingWithMessage {

        @Test
        void shouldStoreCustomMessage() {
            List<APIError> errors = new ArrayList<>();
            APIError error = new APIError();
            errors.add(error);

            DeclinedTransactionException exception = new TestDeclinedTransactionException(
                    "Custom error message",
                    402,
                    "{\"error\":\"declined\"}",
                    "error-id-123",
                    errors
            );

            assertEquals("Custom error message", exception.getMessage());
        }

        @Test
        void shouldStoreErrorId() {
            List<APIError> errors = new ArrayList<>();
            DeclinedTransactionException exception = new TestDeclinedTransactionException(
                    "Custom error message",
                    402,
                    "{\"error\":\"declined\"}",
                    "error-id-456",
                    errors
            );

            assertEquals("error-id-456", exception.getErrorId());
        }

        @Test
        void shouldStoreErrors() {
            List<APIError> errors = new ArrayList<>();
            APIError error1 = new APIError();
            APIError error2 = new APIError();
            errors.add(error1);
            errors.add(error2);

            DeclinedTransactionException exception = new TestDeclinedTransactionException(
                    "Custom error message",
                    402,
                    "{\"error\":\"declined\"}",
                    "error-id-789",
                    errors
            );

            assertEquals(2, exception.getErrors().size());
            assertSame(error1, exception.getErrors().get(0));
            assertSame(error2, exception.getErrors().get(1));
        }

        @Test
        void shouldStoreStatusCodeWithMessage() {
            DeclinedTransactionException exception = new TestDeclinedTransactionException(
                    "Custom error message",
                    403,
                    "{\"error\":\"forbidden\"}",
                    "error-id",
                    null
            );

            assertEquals(403, exception.getStatusCode());
        }

        @Test
        void shouldStoreResponseBodyWithMessage() {
            DeclinedTransactionException exception = new TestDeclinedTransactionException(
                    "Custom error message",
                    402,
                    "{\"error\":\"declined\",\"details\":\"payment rejected\"}",
                    "error-id",
                    null
            );

            assertEquals("{\"error\":\"declined\",\"details\":\"payment rejected\"}", exception.getResponseBody());
        }

        @Test
        void shouldAllowNullMessage() {
            DeclinedTransactionException exception = new TestDeclinedTransactionException(
                    null,
                    402,
                    "{\"error\":\"declined\"}",
                    "error-id",
                    null
            );

            assertNull(exception.getMessage());
        }

        @Test
        void shouldAllowNullErrorId() {
            DeclinedTransactionException exception = new TestDeclinedTransactionException(
                    "Custom error message",
                    402,
                    "{\"error\":\"declined\"}",
                    null,
                    null
            );

            assertNull(exception.getErrorId());
        }

        @Test
        void shouldAllowNullErrors() {
            DeclinedTransactionException exception = new TestDeclinedTransactionException(
                    "Custom error message",
                    402,
                    "{\"error\":\"declined\"}",
                    "error-id",
                    null
            );

            // ApiException converts null errors to empty list
            assertEquals(0, exception.getErrors().size());
        }

        @Test
        void shouldAllowEmptyErrorsList() {
            List<APIError> errors = new ArrayList<>();
            DeclinedTransactionException exception = new TestDeclinedTransactionException(
                    "Custom error message",
                    402,
                    "{\"error\":\"declined\"}",
                    "error-id",
                    errors
            );

            assertEquals(0, exception.getErrors().size());
        }

        @Test
        void shouldExtendApiExceptionWhenConstructedWithMessage() {
            DeclinedTransactionException exception = new TestDeclinedTransactionException(
                    "Custom error message",
                    402,
                    "{\"error\":\"declined\"}",
                    "error-id",
                    null
            );

            assertInstanceOf(ApiException.class, exception);
        }
    }

    @Nested
    class WhenComparingDifferentInstances {

        @Test
        void shouldHaveDifferentStatusCodes() {
            DeclinedTransactionException exception1 = new TestDeclinedTransactionException(
                    "Message 1",
                    402,
                    "{}",
                    "error-1",
                    null
            );

            DeclinedTransactionException exception2 = new TestDeclinedTransactionException(
                    "Message 2",
                    403,
                    "{}",
                    "error-2",
                    null
            );

            assertEquals(402, exception1.getStatusCode());
            assertEquals(403, exception2.getStatusCode());
        }

        @Test
        void shouldHaveDifferentErrorIds() {
            DeclinedTransactionException exception1 = new TestDeclinedTransactionException(
                    "Message 1",
                    402,
                    "{}",
                    "error-id-1",
                    null
            );

            DeclinedTransactionException exception2 = new TestDeclinedTransactionException(
                    "Message 2",
                    402,
                    "{}",
                    "error-id-2",
                    null
            );

            assertEquals("error-id-1", exception1.getErrorId());
            assertEquals("error-id-2", exception2.getErrorId());
        }

        @Test
        void shouldHaveDifferentMessages() {
            DeclinedTransactionException exception1 = new TestDeclinedTransactionException(
                    "First message",
                    402,
                    "{}",
                    "error-id",
                    null
            );

            DeclinedTransactionException exception2 = new TestDeclinedTransactionException(
                    "Second message",
                    402,
                    "{}",
                    "error-id",
                    null
            );

            assertEquals("First message", exception1.getMessage());
            assertEquals("Second message", exception2.getMessage());
        }
    }
}

