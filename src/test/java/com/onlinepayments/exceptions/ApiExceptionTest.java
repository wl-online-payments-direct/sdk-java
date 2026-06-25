package com.onlinepayments.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.ApiException;
import com.onlinepayments.domain.APIError;

class ApiExceptionTest {

    private static APIError createError(String message) {
        APIError error = new APIError();
        error.setMessage(message);
        return error;
    }

    @Nested
    class WhenConstructingWith4Parameters {

        @Test
        void shouldThrowExceptionWhenStatusCodeIsNegative() {
            int statusCode = -1;
            String responseBody = "error";
            String errorId = "ERR_001";
            List<APIError> errors = new ArrayList<>();

            ApiException exception = new ApiException(statusCode, responseBody, errorId, errors);

            assertEquals(statusCode, exception.getStatusCode());
        }

        @Test
        void shouldCreateInstanceWithValidParameters() {
            int statusCode = 400;
            String responseBody = "Bad Request";
            String errorId = "ERR_400";
            List<APIError> errors = new ArrayList<>();
            errors.add(createError("Invalid input"));

            ApiException exception = new ApiException(statusCode, responseBody, errorId, errors);

            assertNotNull(exception);
            assertEquals(statusCode, exception.getStatusCode());
            assertEquals(responseBody, exception.getResponseBody());
            assertEquals(errorId, exception.getErrorId());
            assertEquals(1, exception.getErrors().size());
        }

        @Test
        void shouldConvertNullErrorsListToEmptyList() {
            ApiException exception = new ApiException(400, "error", "ERR_001", null);

            assertNotNull(exception.getErrors());
            assertEquals(0, exception.getErrors().size());
        }

        @Test
        void shouldStoreNullResponseBody() {
            ApiException exception = new ApiException(400, null, "ERR_001", new ArrayList<>());

            assertNull(exception.getResponseBody());
        }

        @Test
        void shouldStoreNullErrorId() {
            ApiException exception = new ApiException(400, "error", null, new ArrayList<>());

            assertNull(exception.getErrorId());
        }

        @Test
        void shouldSetDefaultMessage() {
            ApiException exception = new ApiException(400, "error", "ERR_001", new ArrayList<>());

            assertEquals("the payment platform returned an error response", exception.getMessage());
        }

        @Test
        void shouldStoreZeroStatusCode() {
            ApiException exception = new ApiException(0, "error", "ERR_001", new ArrayList<>());

            assertEquals(0, exception.getStatusCode());
        }

        @Test
        void shouldStoreEmptyStringResponseBody() {
            ApiException exception = new ApiException(400, "", "ERR_001", new ArrayList<>());

            assertEquals("", exception.getResponseBody());
        }

        @Test
        void shouldStoreEmptyStringErrorId() {
            ApiException exception = new ApiException(400, "error", "", new ArrayList<>());

            assertEquals("", exception.getErrorId());
        }

    }

    @Nested
    class WhenConstructingWith5Parameters {

        @Test
        void shouldCreateInstanceWithCustomMessage() {
            String customMessage = "Custom error message";
            ApiException exception = new ApiException(customMessage, 500, "Internal Server Error", "ERR_500", new ArrayList<>());

            assertEquals(customMessage, exception.getMessage());
        }

        @Test
        void shouldStoreAllParametersCorrectly() {
            String message = "Error occurred";
            int statusCode = 404;
            String responseBody = "Not Found";
            String errorId = "ERR_404";
            List<APIError> errors = new ArrayList<>();
            errors.add(createError("Resource not found"));

            ApiException exception = new ApiException(message, statusCode, responseBody, errorId, errors);

            assertEquals(message, exception.getMessage());
            assertEquals(statusCode, exception.getStatusCode());
            assertEquals(responseBody, exception.getResponseBody());
            assertEquals(errorId, exception.getErrorId());
            assertEquals(1, exception.getErrors().size());
        }

        @Test
        void shouldConvertNullErrorsListToEmptyList() {
            ApiException exception = new ApiException("Error", 400, "error", "ERR_001", null);

            assertNotNull(exception.getErrors());
            assertEquals(0, exception.getErrors().size());
        }

        @Test
        void shouldStoreNullResponseBody() {
            ApiException exception = new ApiException("Error", 400, null, "ERR_001", new ArrayList<>());

            assertNull(exception.getResponseBody());
        }

        @Test
        void shouldStoreNullErrorId() {
            ApiException exception = new ApiException("Error", 400, "error", null, new ArrayList<>());

            assertNull(exception.getErrorId());
        }

        @Test
        void shouldStoreZeroStatusCode() {
            ApiException exception = new ApiException("Error", 0, "error", "ERR_001", new ArrayList<>());

            assertEquals(0, exception.getStatusCode());
        }

        @Test
        void shouldStoreEmptyStringMessage() {
            ApiException exception = new ApiException("", 400, "error", "ERR_001", new ArrayList<>());

            assertEquals("", exception.getMessage());
        }

        @Test
        void shouldStoreNullMessage() {
            ApiException exception = new ApiException(null, 400, "error", "ERR_001", new ArrayList<>());

            assertNull(exception.getMessage());
        }

    }

    @Nested
    class WhenGettingStatusCode {

        @Test
        void shouldReturnPositiveStatusCode() {
            ApiException exception = new ApiException(201, "Created", "ERR_201", new ArrayList<>());

            assertEquals(201, exception.getStatusCode());
        }

        @Test
        void shouldReturnZeroStatusCode() {
            ApiException exception = new ApiException(0, "error", "ERR_001", new ArrayList<>());

            assertEquals(0, exception.getStatusCode());
        }

        @Test
        void shouldReturnNegativeStatusCode() {
            ApiException exception = new ApiException(-1, "error", "ERR_001", new ArrayList<>());

            assertEquals(-1, exception.getStatusCode());
        }

        @Test
        void shouldReturnStatusCodeFromSecondConstructor() {
            ApiException exception = new ApiException("Message", 503, "Service Unavailable", "ERR_503", new ArrayList<>());

            assertEquals(503, exception.getStatusCode());
        }

    }

    @Nested
    class WhenGettingResponseBody {

        @Test
        void shouldReturnResponseBody() {
            String responseBody = "Invalid request format";
            ApiException exception = new ApiException(400, responseBody, "ERR_400", new ArrayList<>());

            assertEquals(responseBody, exception.getResponseBody());
        }

        @Test
        void shouldReturnNullResponseBody() {
            ApiException exception = new ApiException(400, null, "ERR_400", new ArrayList<>());

            assertNull(exception.getResponseBody());
        }

        @Test
        void shouldReturnEmptyResponseBody() {
            ApiException exception = new ApiException(400, "", "ERR_400", new ArrayList<>());

            assertEquals("", exception.getResponseBody());
        }

    }

    @Nested
    class WhenGettingErrorId {

        @Test
        void shouldReturnErrorId() {
            String errorId = "ERR_PAYMENT_FAILED";
            ApiException exception = new ApiException(402, "Payment required", errorId, new ArrayList<>());

            assertEquals(errorId, exception.getErrorId());
        }

        @Test
        void shouldReturnNullErrorId() {
            ApiException exception = new ApiException(400, "error", null, new ArrayList<>());

            assertNull(exception.getErrorId());
        }

        @Test
        void shouldReturnEmptyErrorId() {
            ApiException exception = new ApiException(400, "error", "", new ArrayList<>());

            assertEquals("", exception.getErrorId());
        }

    }

    @Nested
    class WhenGettingErrors {

        @Test
        void shouldReturnErrorsList() {
            List<APIError> errors = new ArrayList<>();
            errors.add(createError("Error 1"));
            errors.add(createError("Error 2"));
            ApiException exception = new ApiException(400, "error", "ERR_400", errors);

            assertEquals(2, exception.getErrors().size());
            assertEquals("Error 1", exception.getErrors().get(0).getMessage());
            assertEquals("Error 2", exception.getErrors().get(1).getMessage());
        }

        @Test
        void shouldConvertNullListToEmptyList() {
            ApiException exception = new ApiException(400, "error", "ERR_400", null);

            assertNotNull(exception.getErrors());
            assertEquals(0, exception.getErrors().size());
        }

        @Test
        void shouldReturnEmptyListWhenNoErrors() {
            ApiException exception = new ApiException(400, "error", "ERR_400", new ArrayList<>());

            assertNotNull(exception.getErrors());
            assertEquals(0, exception.getErrors().size());
        }

        @Test
        void shouldReturnSingleError() {
            List<APIError> errors = new ArrayList<>();
            errors.add(createError("Single error"));
            ApiException exception = new ApiException(400, "error", "ERR_400", errors);

            assertEquals(1, exception.getErrors().size());
            assertEquals("Single error", exception.getErrors().get(0).getMessage());
        }

    }

    @Nested
    class WhenConvertingToString {

        @Test
        void shouldIncludeStatusCodeWhenPositive() {
            ApiException exception = new ApiException(400, "Bad Request", "ERR_400", new ArrayList<>());
            String result = exception.toString();

            assertTrue(result.contains("statusCode=400"));
        }

        @Test
        void shouldExcludeStatusCodeWhenZero() {
            ApiException exception = new ApiException(0, "response", "ERR_001", new ArrayList<>());
            String result = exception.toString();

            assertFalse(result.contains("statusCode="));
        }

        @Test
        void shouldExcludeStatusCodeWhenNegative() {
            ApiException exception = new ApiException(-1, "response", "ERR_001", new ArrayList<>());
            String result = exception.toString();

            assertFalse(result.contains("statusCode="));
        }

        @Test
        void shouldIncludeResponseBodyWhenNonEmpty() {
            ApiException exception = new ApiException(400, "Invalid input data", "ERR_400", new ArrayList<>());
            String result = exception.toString();

            assertTrue(result.contains("responseBody='Invalid input data'"));
        }

        @Test
        void shouldExcludeResponseBodyWhenNull() {
            ApiException exception = new ApiException(400, null, "ERR_400", new ArrayList<>());
            String result = exception.toString();

            assertFalse(result.contains("responseBody="));
        }

        @Test
        void shouldExcludeResponseBodyWhenEmpty() {
            ApiException exception = new ApiException(400, "", "ERR_400", new ArrayList<>());
            String result = exception.toString();

            assertFalse(result.contains("responseBody="));
        }

        @Test
        void shouldIncludeMessageFromConstructor() {
            String customMessage = "Custom error message";
            ApiException exception = new ApiException(customMessage, 500, "Internal Error", "ERR_500", new ArrayList<>());
            String result = exception.toString();

            assertTrue(result.contains(customMessage));
        }

        @Test
        void shouldIncludeDefaultMessageFromFirstConstructor() {
            ApiException exception = new ApiException(400, "error", "ERR_400", new ArrayList<>());
            String result = exception.toString();

            assertTrue(result.contains("the payment platform returned an error response"));
        }

        @Test
        void shouldFormatWithStatusCodeAndResponseBody() {
            ApiException exception = new ApiException(401, "Unauthorized", "ERR_401", new ArrayList<>());
            String result = exception.toString();

            assertTrue(result.contains("statusCode=401"));
            assertTrue(result.contains("responseBody='Unauthorized'"));
        }

        @Test
        void shouldFormatWithStatusCodeOnlyWhenResponseBodyEmpty() {
            ApiException exception = new ApiException(403, "", "ERR_403", new ArrayList<>());
            String result = exception.toString();

            assertTrue(result.contains("statusCode=403"));
            assertFalse(result.contains("responseBody="));
        }

    }

    @Nested
    class WhenExtendingRuntimeException {

        @Test
        void shouldBeInstanceOfRuntimeException() {
            ApiException exception = new ApiException(500, "error", "ERR_500", new ArrayList<>());

            assertInstanceOf(RuntimeException.class, exception);
        }

        @Test
        void shouldBeThrowable() {
            ApiException exception = new ApiException(500, "error", "ERR_500", new ArrayList<>());

            assertInstanceOf(Throwable.class, exception);
        }

        @Test
        void shouldBeCatchableAsRuntimeException() {
            ApiException exception = new ApiException(500, "error", "ERR_500", new ArrayList<>());

            try {
                throw exception;
            } catch (RuntimeException e) {
                assertEquals("the payment platform returned an error response", e.getMessage());
            }
        }

    }
}
