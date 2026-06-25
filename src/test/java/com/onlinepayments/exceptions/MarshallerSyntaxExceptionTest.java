package com.onlinepayments.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.json.MarshallerSyntaxException;

class MarshallerSyntaxExceptionTest {

    @Nested
    class WhenCreatedWithDefaultConstructor {

        @Test
        void shouldHaveNoMessageOrCause() {
            MarshallerSyntaxException exception = new MarshallerSyntaxException();

            assertInstanceOf(RuntimeException.class, exception);
            assertNull(exception.getMessage());
            assertNull(exception.getCause());
        }
    }

    @Nested
    class WhenCreatedWithCauseConstructor {

        @Test
        void shouldStoreCause() {
            Throwable cause = new IllegalArgumentException("Invalid JSON");

            MarshallerSyntaxException exception = new MarshallerSyntaxException(cause);

            assertInstanceOf(RuntimeException.class, exception);
            assertSame(cause, exception.getCause());
        }

        @Test
        void shouldPropagateCauseAsMessage() {
            Throwable cause = new IllegalArgumentException("Invalid JSON");

            MarshallerSyntaxException exception = new MarshallerSyntaxException(cause);

            assertEquals(cause.toString(), exception.getMessage());
        }
    }
}
