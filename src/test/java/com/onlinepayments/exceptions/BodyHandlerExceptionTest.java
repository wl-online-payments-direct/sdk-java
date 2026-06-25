package com.onlinepayments.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.io.IOException;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.BodyHandlerException;

class BodyHandlerExceptionTest {

    @Nested
    class WhenCreatedWithDefaultConstructor {

        @Test
        void shouldHaveNoMessageOrCause() {
            BodyHandlerException exception = new BodyHandlerException();

            assertInstanceOf(RuntimeException.class, exception);
            assertNull(exception.getMessage());
            assertNull(exception.getCause());
        }
    }

    @Nested
    class WhenCreatedWithMessageConstructor {

        @Test
        void shouldStoreMessage() {
            BodyHandlerException exception = new BodyHandlerException("body handler failed");

            assertInstanceOf(RuntimeException.class, exception);
            assertEquals("body handler failed", exception.getMessage());
            assertNull(exception.getCause());
        }
    }

    @Nested
    class WhenCreatedWithCauseConstructor {

        @Test
        void shouldStoreCause() {
            Throwable cause = new IOException("read failed");

            BodyHandlerException exception = new BodyHandlerException(cause);

            assertInstanceOf(RuntimeException.class, exception);
            assertSame(cause, exception.getCause());
        }
    }

    @Nested
    class WhenCreatedWithMessageAndCauseConstructor {

        @Test
        void shouldStoreMessageAndCause() {
            Throwable cause = new IOException("read failed");

            BodyHandlerException exception = new BodyHandlerException("body handler failed", cause);

            assertInstanceOf(RuntimeException.class, exception);
            assertEquals("body handler failed", exception.getMessage());
            assertSame(cause, exception.getCause());
        }
    }
}
