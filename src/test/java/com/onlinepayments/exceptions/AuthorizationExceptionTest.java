package com.onlinepayments.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.ApiException;
import com.onlinepayments.AuthorizationException;
import com.onlinepayments.domain.APIError;

class AuthorizationExceptionTest {

    @Nested
    class WhenCreatedWithDefaultMessage {

        @Test
        void shouldSetDefaultMessageAndProperties() {
            List<APIError> errors = Collections.emptyList();

            AuthorizationException exception = new AuthorizationException(
                    403,
                    "{\"error\":\"forbidden\"}",
                    "error-id",
                    errors
            );

            assertInstanceOf(ApiException.class, exception);
            assertEquals(403, exception.getStatusCode());
            assertEquals("{\"error\":\"forbidden\"}", exception.getResponseBody());
            assertEquals("error-id", exception.getErrorId());
            assertSame(errors, exception.getErrors());

            assertEquals(
                    "the payment platform returned an authorization error response",
                    exception.getMessage()
            );
        }
    }

    @Nested
    class WhenCreatedWithCustomMessage {

        @Test
        void shouldSetCustomMessageAndProperties() {
            List<APIError> errors = Collections.emptyList();

            AuthorizationException exception = new AuthorizationException(
                    "custom message",
                    403,
                    "{\"error\":\"forbidden\"}",
                    "error-id",
                    errors
            );

            assertInstanceOf(ApiException.class, exception);
            assertEquals(403, exception.getStatusCode());
            assertEquals("{\"error\":\"forbidden\"}", exception.getResponseBody());
            assertEquals("error-id", exception.getErrorId());
            assertSame(errors, exception.getErrors());

            assertEquals("custom message", exception.getMessage());
        }
    }
}
