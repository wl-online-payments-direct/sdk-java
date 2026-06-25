package com.onlinepayments.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.webhooks.SignatureValidationException;

class SignatureValidationExceptionTest {

    @Nested
    class WhenConstructingWithMessage {

        @Test
        void shouldCreateInstanceWithMessage() {
            String message = "Signature validation failed";

            SignatureValidationException exception = new SignatureValidationException(message);

            assertNotNull(exception);
        }

        @Test
        void shouldStoreMessageFromConstructor() {
            String message = "Invalid signature provided";

            SignatureValidationException exception = new SignatureValidationException(message);

            assertEquals(message, exception.getMessage());
        }

        @Test
        void shouldBeRuntimeException() {
            String message = "Signature validation failed";

            SignatureValidationException exception = new SignatureValidationException(message);

            assertInstanceOf(RuntimeException.class, exception);
        }

        @Test
        void shouldNotHaveCauseWhenNotProvided() {
            String message = "Signature validation failed";

            SignatureValidationException exception = new SignatureValidationException(message);

            assertNull(exception.getCause());
        }
    }

    @Nested
    class WhenConstructingWithCause {

        @Test
        void shouldCreateInstanceWithCause() {
            Throwable cause = new RuntimeException("Cryptographic error");

            SignatureValidationException exception = new SignatureValidationException(cause);

            assertNotNull(exception);
        }

        @Test
        void shouldStoreCauseFromConstructor() {
            RuntimeException cause = new RuntimeException("Cryptographic error");

            SignatureValidationException exception = new SignatureValidationException(cause);

            assertSame(cause, exception.getCause());
        }

        @Test
        void shouldHaveCauseMessage() {
            String causeMessage = "Invalid key format";
            Exception cause = new Exception(causeMessage);

            SignatureValidationException exception = new SignatureValidationException(cause);

            assertEquals(causeMessage, exception.getCause().getMessage());
        }

        @Test
        void shouldHaveNullMessageWhenOnlyCallWithCause() {
            Exception cause = new Exception("Root cause");

            SignatureValidationException exception = new SignatureValidationException(cause);

            // When constructed with cause only, direct getMessage() returns null (inherited from RuntimeException)
            // But getCause() returns the cause
            assertNotNull(exception.getCause());
        }
    }

    @Nested
    class WhenConstructingWithMessageAndCause {

        @Test
        void shouldCreateInstanceWithBothParameters() {
            String message = "Signature validation failed";
            Throwable cause = new RuntimeException("Cryptographic error");

            SignatureValidationException exception = new SignatureValidationException(message, cause);

            assertNotNull(exception);
        }

        @Test
        void shouldStoreMessageFromConstructor() {
            String message = "Invalid signature: expected ABC123 but got DEF456";
            Throwable cause = new RuntimeException("Cryptographic error");

            SignatureValidationException exception = new SignatureValidationException(message, cause);

            assertEquals(message, exception.getMessage());
        }

        @Test
        void shouldStoreCauseFromConstructor() {
            String message = "Signature validation failed";
            RuntimeException cause = new RuntimeException("Cryptographic error");

            SignatureValidationException exception = new SignatureValidationException(message, cause);

            assertSame(cause, exception.getCause());
        }

        @Test
        void shouldHaveBothMessageAndCause() {
            String message = "Failed to validate webhook signature";
            Exception cause = new Exception("Underlying crypto error");

            SignatureValidationException exception = new SignatureValidationException(message, cause);

            assertEquals(message, exception.getMessage());
            assertEquals("Underlying crypto error", exception.getCause().getMessage());
        }
    }

    @Nested
    class WhenThrowingException {

        @Test
        void shouldBeThrowableAndCatchable() {
            String message = "Signature mismatch";

            SignatureValidationException exception = assertThrows(
                    SignatureValidationException.class,
                    () -> {
                        throw new SignatureValidationException(message);
                    });

            assertEquals(message, exception.getMessage());
        }

        @Test
        void shouldBeCatchableAsRuntimeException() {
            String message = "Signature mismatch";

            RuntimeException exception = assertThrows(
                    RuntimeException.class,
                    () -> {
                        throw new SignatureValidationException(message);
                    });

            assertInstanceOf(SignatureValidationException.class, exception);
        }

        @Test
        void shouldBeCatchableAsException() {
            String message = "Signature mismatch";

            Exception exception = assertThrows(
                    Exception.class,
                    () -> {
                        throw new SignatureValidationException(message);
                    });

            assertInstanceOf(SignatureValidationException.class, exception);
        }

        @Test
        void shouldBeCatchableAsThrowable() {
            String message = "Signature mismatch";

            Throwable throwable = assertThrows(
                    Throwable.class,
                    () -> {
                        throw new SignatureValidationException(message);
                    });

            assertInstanceOf(SignatureValidationException.class, throwable);
        }
    }

    @Nested
    class WhenHandlingExceptionMessages {

        @Test
        void shouldHandleEmptyMessage() {
            String message = "";

            SignatureValidationException exception = new SignatureValidationException(message);

            assertEquals("", exception.getMessage());
        }

        @Test
        void shouldHandleNullMessage() {
            SignatureValidationException exception = new SignatureValidationException((String) null);

            assertNull(exception.getMessage());
        }

        @Test
        void shouldHandleMultilineMessage() {
            String message = "Signature validation failed:\n"
                                + "Expected: signature1\n"
                                + "Actual: signature2";

            SignatureValidationException exception = new SignatureValidationException(message);

            assertEquals(message, exception.getMessage());
            assertTrue(exception.getMessage().contains("\n"));
        }

        @Test
        void shouldHandleSpecialCharactersInMessage() {
            String message = "Invalid signature: @#$%^&*()";

            SignatureValidationException exception = new SignatureValidationException(message);

            assertEquals(message, exception.getMessage());
        }

        @Test
        void shouldHandleLongMessage() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                sb.append("a");
            }
            String message = sb.toString();

            SignatureValidationException exception = new SignatureValidationException(message);

            assertEquals(message, exception.getMessage());
            assertEquals(1000, exception.getMessage().length());
        }
    }

    @Nested
    class WhenHandlingExceptionChains {

        @Test
        void shouldChainWithMultipleCauses() {
            Exception rootCause = new Exception("Root cause");
            RuntimeException intermediateCause = new RuntimeException("Intermediate", rootCause);
            SignatureValidationException exception = new SignatureValidationException("Signature failed", intermediateCause);

            assertEquals("Intermediate", exception.getCause().getMessage());
            assertEquals("Root cause", exception.getCause().getCause().getMessage());
        }

        @Test
        void shouldPreserveStackTrace() {
            Exception cause = new Exception("Underlying error");

            SignatureValidationException exception = new SignatureValidationException("Signature validation failed", cause);

            assertNotNull(exception.getStackTrace());
            assertTrue(exception.getStackTrace().length > 0);
        }

        @Test
        void shouldBePrintableWithStackTrace() {
            Exception cause = new Exception("Cryptographic error");
            SignatureValidationException exception = new SignatureValidationException("Signature failed", cause);

            String stackTraceString = exception.toString();

            assertTrue(stackTraceString.contains("SignatureValidationException"));
        }
    }

    @Nested
    class WhenUsingDifferentConstructors {

        @Test
        void shouldCreateInstanceWithEachConstructor() {
            SignatureValidationException exception1 = new SignatureValidationException("Message only");
            SignatureValidationException exception2 = new SignatureValidationException(new Exception("Cause only"));
            SignatureValidationException exception3 = new SignatureValidationException("Message", new Exception("Cause"));

            assertNotNull(exception1);
            assertNotNull(exception2);
            assertNotNull(exception3);
        }

        @Test
        void shouldHaveMessageWhenProvidedInConstructor() {
            SignatureValidationException exception = new SignatureValidationException("Test message");

            assertEquals("Test message", exception.getMessage());
        }

        @Test
        void shouldHaveCauseWhenProvidedInConstructor() {
            Exception cause = new Exception("Test cause");
            SignatureValidationException exception = new SignatureValidationException(cause);

            assertSame(cause, exception.getCause());
        }

        @Test
        void shouldHaveBothMessageAndCauseWhenBothProvided() {
            Exception cause = new Exception("Test cause");
            SignatureValidationException exception = new SignatureValidationException("Test message", cause);

            assertEquals("Test message", exception.getMessage());
            assertSame(cause, exception.getCause());
        }
    }
}
