package com.onlinepayments.logging;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ResponseLogMessageBuilderTest {

    @Nested
    class WhenConstructingWithoutDuration {

        @Test
        void shouldCreateInstanceWithFourParameters() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-request-id",
                    200,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            assertNotNull(builder);
        }

        @Test
        void shouldDelegateToFiveParameterConstructor() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-request-id",
                    404,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.setBody("Not found", "text/plain");
            String message = builder.getMessage();

            // getMessage() without explicit duration should not include "ms" in message
            assertFalse(message.contains("ms)"));
        }
    }

    @Nested
    class WhenConstructingWithDuration {

        @Test
        void shouldCreateInstanceWithFiveParametersAndZeroDuration() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-request-id",
                    200,
                    0,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            assertNotNull(builder);
        }

        @Test
        void shouldCreateInstanceWithFiveParametersAndPositiveDuration() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-request-id",
                    200,
                    150,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            assertNotNull(builder);
        }

        @Test
        void shouldCreateInstanceWithFiveParametersAndLargeDuration() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-request-id",
                    200,
                    5000,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            assertNotNull(builder);
        }
    }

    @Nested
    class WhenBuildingMessageWithoutDuration {

        @Test
        void shouldExcludeDurationWhenNegative() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-request-id",
                    200,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.setBody("Response body", "application/json");
            String message = builder.getMessage();

            assertTrue(message.contains("Incoming response (requestId='test-request-id')"));
            assertFalse(message.contains("ms)"));
        }

        @Test
        void shouldIncludeStatusCodeAndHeaders() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-id",
                    404,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.addHeader("Content-Type", "application/json");
            builder.setBody("Not found", "application/json");
            String message = builder.getMessage();

            assertTrue(message.contains("404"));
            assertTrue(message.contains("Content-Type"));
        }

        @Test
        void shouldHandleNullBodyAndContentType() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-request-id",
                    204,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            String message = builder.getMessage();

            assertTrue(message.contains("204"));
            assertTrue(message.contains("content-type:"));
            assertTrue(message.contains("body:"));
        }
    }

    @Nested
    class WhenBuildingMessageWithDuration {

        @Test
        void shouldIncludeDurationWhenPositive() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-request-id",
                    200,
                    100,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.setBody("Success", "text/plain");
            String message = builder.getMessage();

            assertTrue(message.contains("Incoming response (requestId='test-request-id', 100 ms)"));
        }

        @Test
        void shouldIncludeDurationWhenZero() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-request-id",
                    200,
                    0,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.setBody("Success", "text/plain");
            String message = builder.getMessage();

            assertTrue(message.contains("Incoming response (requestId='test-request-id', 0 ms)"));
        }

        @Test
        void shouldIncludeDurationWithLargeValues() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-request-id",
                    200,
                    5000,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.setBody("Success", "text/plain");
            String message = builder.getMessage();

            assertTrue(message.contains("5000 ms"));
        }

        @Test
        void shouldIncludeStatusCodeWithDuration() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-id",
                    500,
                    250,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.setBody("Server error", "text/plain");
            String message = builder.getMessage();

            assertTrue(message.contains("500"));
            assertTrue(message.contains("250 ms"));
        }
    }

    @Nested
    class WhenFormattingMessage {

        @Test
        void shouldIncludeAllHeadersInMessage() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-id",
                    200,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.addHeader("Content-Type", "application/json");
            builder.addHeader("X-Custom-Header", "custom-value");
            builder.addHeader("Cache-Control", "no-cache");
            builder.setBody("Response", "application/json");

            String message = builder.getMessage();

            assertTrue(message.contains("Content-Type"));
            assertTrue(message.contains("X-Custom-Header"));
            assertTrue(message.contains("Cache-Control"));
        }

        @Test
        void shouldObfuscateSensitiveHeaders() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-id",
                    200,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.addHeader("Authorization", "Bearer secret-token-12345");
            builder.setBody("Response", "application/json");

            String message = builder.getMessage();

            // Authorization header should be obfuscated (default: first 8 chars as asterisks)
            assertTrue(message.contains("Authorization"));
            assertTrue(message.contains("*"));
        }

        @Test
        void shouldIncludeContentTypeInMessage() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-id",
                    200,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.setBody("Response body", "application/xml");

            String message = builder.getMessage();

            assertTrue(message.contains("content-type: 'application/xml'"));
        }

        @Test
        void shouldIncludeBodyInMessage() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-id",
                    200,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.setBody("Response body content", "text/plain");

            String message = builder.getMessage();

            assertTrue(message.contains("Response body content"));
        }

        @Test
        void shouldFormatWithMultilineStructure() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-id",
                    200,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.addHeader("Content-Type", "application/json");
            builder.setBody("{ \"key\": \"value\" }", "application/json");

            String message = builder.getMessage();

            assertTrue(message.contains("\n"));
            assertTrue(message.contains("Incoming response"));
            assertTrue(message.contains("status-code"));
            assertTrue(message.contains("headers"));
            assertTrue(message.contains("content-type"));
            assertTrue(message.contains("body"));
        }
    }

    @Nested
    class WhenHandlingDifferentStatusCodes {

        @Test
        void shouldHandleSuccessStatusCode() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-id",
                    200,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.setBody("OK", "text/plain");
            String message = builder.getMessage();

            assertTrue(message.contains("200"));
        }

        @Test
        void shouldHandleRedirectStatusCode() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-id",
                    301,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.setBody("Moved", "text/plain");
            String message = builder.getMessage();

            assertTrue(message.contains("301"));
        }

        @Test
        void shouldHandleClientErrorStatusCode() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-id",
                    400,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.setBody("Bad request", "application/json");
            String message = builder.getMessage();

            assertTrue(message.contains("400"));
        }

        @Test
        void shouldHandleServerErrorStatusCode() {
            ResponseLogMessageBuilder builder = new ResponseLogMessageBuilder(
                    "test-id",
                    500,
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.setBody("Internal error", "text/plain");
            String message = builder.getMessage();

            assertTrue(message.contains("500"));
        }
    }
}
