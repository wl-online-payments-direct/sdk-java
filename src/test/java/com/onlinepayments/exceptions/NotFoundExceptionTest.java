package com.onlinepayments.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.communication.NotFoundException;

class NotFoundExceptionTest {

    @Nested
    @DisplayName("Constructor with Exception")
    class WhenCreatingWithException {

        @Test
        void shouldInitializeExceptionWithCause() {
            Exception cause = new IllegalArgumentException("Invalid path parameter");

            NotFoundException exception = new NotFoundException(cause);

            assertNotNull(exception);
            assertEquals(cause, exception.getCause());
        }

        @Test
        void shouldPropagateCauseAsMessage() {
            Exception cause = new IllegalArgumentException("Invalid path parameter");

            NotFoundException exception = new NotFoundException(cause);

            assertEquals(cause.toString(), exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Constructor with Message and Exception")
    class WhenCreatingWithMessageAndException {

        @Test
        void shouldInitializeExceptionWithMessageAndCause() {
            String message = "Resource not found";
            Exception cause = new IllegalArgumentException("Invalid path parameter");

            NotFoundException exception = new NotFoundException(message, cause);

            assertNotNull(exception);
            assertEquals(message, exception.getMessage());
            assertEquals(cause, exception.getCause());
        }
    }
}
