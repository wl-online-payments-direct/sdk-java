package com.onlinepayments.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.ApiException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.APIError;

class ValidationExceptionTest {

    @Nested
    class WhenCreatedWithDefaultMessage {

        @Test
        void shouldSetDefaultMessageAndProperties() {
            List<APIError> errors = Collections.emptyList();

            ValidationException exception = new ValidationException(
                    400,
                    "{\"error\":\"bad request\"}",
                    "error-id",
                    errors
            );

            assertInstanceOf(ApiException.class, exception);
            assertEquals(400, exception.getStatusCode());
            assertEquals("{\"error\":\"bad request\"}", exception.getResponseBody());
            assertEquals("error-id", exception.getErrorId());
            assertSame(errors, exception.getErrors());
            assertEquals(
                    "the payment platform returned an incorrect request error response",
                    exception.getMessage()
            );
        }
    }

    @Nested
    class WhenCreatedWithCustomMessage {

        @Test
        void shouldSetCustomMessageAndProperties() {
            List<APIError> errors = Collections.emptyList();

            ValidationException exception = new ValidationException(
                    "custom message",
                    400,
                    "{\"error\":\"bad request\"}",
                    "error-id",
                    errors
            );

            assertInstanceOf(ApiException.class, exception);
            assertEquals(400, exception.getStatusCode());
            assertEquals("{\"error\":\"bad request\"}", exception.getResponseBody());
            assertEquals("error-id", exception.getErrorId());
            assertSame(errors, exception.getErrors());
            assertEquals("custom message", exception.getMessage());
        }
    }
}
