package com.onlinepayments.logging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LogMessageBuilderTest {

    @Nested
    class WhenEmptyingIfNull {

        @Test
        void shouldReturnEmptyStringForNull() {
            RequestLogMessageBuilder builder = new RequestLogMessageBuilder(
                    "test-id",
                    "GET",
                    "/api/endpoint",
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            String result = builder.emptyIfNull(null);

            assertEquals("", result);
        }

        @Test
        void shouldReturnValueForNonNull() {
            RequestLogMessageBuilder builder = new RequestLogMessageBuilder(
                    "test-id",
                    "GET",
                    "/api/endpoint",
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            String result = builder.emptyIfNull("test-value");

            assertEquals("test-value", result);
        }
    }

    @Nested
    class WhenSettingBinaryContent {

        @Test
        void shouldAcceptValidBinaryContentType() {
            RequestLogMessageBuilder builder = new RequestLogMessageBuilder(
                    "test-id",
                    "GET",
                    "/api/endpoint",
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.setBinaryContentBody("application/octet-stream");

            assertEquals("<binary content>", builder.body());
            assertEquals("application/octet-stream", builder.contentType());
        }

        @Test
        void shouldAcceptOtherBinaryContentTypes() {
            RequestLogMessageBuilder builder = new RequestLogMessageBuilder(
                    "test-id",
                    "GET",
                    "/api/endpoint",
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.setBinaryContentBody("image/png");

            assertEquals("<binary content>", builder.body());
            assertEquals("image/png", builder.contentType());
        }

        @Test
        void shouldRejectTextContentType() {
            RequestLogMessageBuilder builder = new RequestLogMessageBuilder(
                    "test-id",
                    "GET",
                    "/api/endpoint",
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            assertThrows(IllegalArgumentException.class, () -> builder.setBinaryContentBody("text/plain"));
        }

        @Test
        void shouldRejectJsonContentType() {
            RequestLogMessageBuilder builder = new RequestLogMessageBuilder(
                    "test-id",
                    "GET",
                    "/api/endpoint",
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            assertThrows(IllegalArgumentException.class, () -> builder.setBinaryContentBody("application/json"));
        }

        @Test
        void shouldRejectXmlContentType() {
            RequestLogMessageBuilder builder = new RequestLogMessageBuilder(
                    "test-id",
                    "GET",
                    "/api/endpoint",
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            assertThrows(IllegalArgumentException.class, () -> builder.setBinaryContentBody("application/xml"));
        }
    }

    @Nested
    class WhenConstructing {

        @Test
        void shouldThrowExceptionWhenRequestIdIsNull() {
            assertThrows(IllegalArgumentException.class, () -> new RequestLogMessageBuilder(
                    null,
                    "GET",
                    "/api/endpoint",
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator()));
        }

        @Test
        void shouldThrowExceptionWhenRequestIdIsEmpty() {
            assertThrows(IllegalArgumentException.class, () -> new RequestLogMessageBuilder(
                    "",
                    "GET",
                    "/api/endpoint",
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator()));
        }

        @Test
        void shouldThrowExceptionWhenBodyObfuscatorIsNull() {
            assertThrows(IllegalArgumentException.class, () -> new RequestLogMessageBuilder(
                    "test-id",
                    "GET",
                    "/api/endpoint",
                    null,
                    HeaderObfuscator.defaultObfuscator()));
        }

        @Test
        void shouldThrowExceptionWhenHeaderObfuscatorIsNull() {
            assertThrows(IllegalArgumentException.class, () -> new RequestLogMessageBuilder(
                    "test-id",
                    "GET",
                    "/api/endpoint",
                    BodyObfuscator.defaultObfuscator(),
                    null));
        }

        @Test
        void shouldCreateInstanceWithValidParameters() {
            RequestLogMessageBuilder builder = new RequestLogMessageBuilder(
                    "test-id",
                    "GET",
                    "/api/endpoint",
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            assertNotNull(builder);
            assertEquals("test-id", builder.requestId());
        }
    }

    @Nested
    class WhenAddingHeaders {

        @Test
        void shouldAddMultipleHeaders() {
            RequestLogMessageBuilder builder = new RequestLogMessageBuilder(
                    "test-id",
                    "GET",
                    "/api/endpoint",
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.addHeader("Content-Type", "application/json");
            builder.addHeader("Authorization", "Bearer token");

            String headers = builder.headers();
            assertTrue(headers.contains("Content-Type"));
            assertTrue(headers.contains("Authorization"));
            assertTrue(headers.contains(", "));
        }

        @Test
        void shouldHandleNullHeaderValue() {
            RequestLogMessageBuilder builder = new RequestLogMessageBuilder(
                    "test-id",
                    "GET",
                    "/api/endpoint",
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.addHeader("X-Custom", null);

            String headers = builder.headers();
            assertTrue(headers.contains("X-Custom"));
        }
    }

    @Nested
    class WhenSettingBody {

        @Test
        void shouldSetBodyWithString() {
            RequestLogMessageBuilder builder = new RequestLogMessageBuilder(
                    "test-id",
                    "GET",
                    "/api/endpoint",
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            builder.setBody("test body", "text/plain");

            assertEquals("test body", builder.body());
            assertEquals("text/plain", builder.contentType());
        }

        @Test
        void shouldSetBodyWithInputStream() throws IOException {
            RequestLogMessageBuilder builder = new RequestLogMessageBuilder(
                    "test-id",
                    "GET",
                    "/api/endpoint",
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            String testContent = "test input stream body";
            byte[] bytes = testContent.getBytes(StandardCharsets.UTF_8);
            java.io.InputStream stream = new java.io.ByteArrayInputStream(bytes);

            builder.setBody(stream, StandardCharsets.UTF_8, "text/plain");

            assertEquals("test input stream body", builder.body());
            assertEquals("text/plain", builder.contentType());
        }

        @Test
        void shouldSetBinaryBodyWithInputStream() throws IOException {
            RequestLogMessageBuilder builder = new RequestLogMessageBuilder(
                    "test-id",
                    "GET",
                    "/api/endpoint",
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            byte[] bytes = new byte[] { 1, 2, 3, 4, 5 };
            java.io.InputStream stream = new java.io.ByteArrayInputStream(bytes);

            builder.setBody(stream, StandardCharsets.UTF_8, "application/octet-stream");

            assertEquals("<binary content>", builder.body());
            assertEquals("application/octet-stream", builder.contentType());
        }

        @Test
        void shouldSetBodyWithReader() throws IOException {
            RequestLogMessageBuilder builder = new RequestLogMessageBuilder(
                    "test-id",
                    "GET",
                    "/api/endpoint",
                    BodyObfuscator.defaultObfuscator(),
                    HeaderObfuscator.defaultObfuscator());

            StringReader reader = new StringReader("test reader body");

            builder.setBody(reader, "text/plain");

            assertEquals("test reader body", builder.body());
            assertEquals("text/plain", builder.contentType());
        }
    }
}
