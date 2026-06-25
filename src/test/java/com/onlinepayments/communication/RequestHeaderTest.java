package com.onlinepayments.communication;

import static com.onlinepayments.communication.RequestHeader.normalizeValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RequestHeaderTest {

    @Nested
    class WhenConstructedWithNullName {

        @Test
        void shouldThrowIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> new RequestHeader(null, "value"));
        }
    }

    @Nested
    class WhenConstructedWithEmptyName {

        @Test
        void shouldThrowIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> new RequestHeader("", "value"));
        }

        @Test
        void shouldThrowIllegalArgumentExceptionWhenNameContainsOnlyWhitespace() {
            assertThrows(IllegalArgumentException.class, () -> new RequestHeader("   ", "value"));
        }
    }

    @Nested
    class WhenGettingName {

        @Test
        void shouldReturnConfiguredName() {
            RequestHeader header = new RequestHeader("Content-Type", "application/json");

            assertEquals("Content-Type", header.getName());
        }
    }

    @Nested
    class WhenGettingValue {

        @Test
        void shouldReturnConfiguredValue() {
            RequestHeader header = new RequestHeader("Content-Type", "application/json");

            assertEquals("application/json", header.getValue());
        }

        @Test
        void shouldReturnNormalizedValue() {
            RequestHeader authorizationHeader = new RequestHeader("Authorization", "Bearer\ntoken  ");
            RequestHeader contentTypeHeader = new RequestHeader("Content-Type", " application/json;\r\n  charset=UTF-8");
            RequestHeader cookieHeader = new RequestHeader("Cookie", " sessionId=abc123  \r\n \n path=/;\r\n  Secure ");

            assertEquals("Bearer token", authorizationHeader.getValue());
            assertEquals("application/json; charset=UTF-8", contentTypeHeader.getValue());
            assertEquals("sessionId=abc123    path=/; Secure", cookieHeader.getValue());
        }
    }

    @Nested
    class WhenNormalizingValue {

        @Test
        void shouldReturnNormalizedValue() {
            assertEquals("Bearer token", normalizeValue("Bearer\ntoken  "));
            assertEquals("application/json; charset=UTF-8", normalizeValue(" application/json;\r\n  charset=UTF-8"));
            assertEquals(
                    "sessionId=abc123    path=/; Secure",
                    normalizeValue(" sessionId=abc123  \r\n \n path=/;\r\n  Secure ")
            );
        }

        @Test
        void shouldReturnNullWhenValueIsNull() {
            assertNull(normalizeValue(null));
        }

        @Test
        void shouldReturnEmptyStringWhenValueIsEmpty() {
            assertEquals("", normalizeValue(""));
        }
    }

    @Nested
    class WhenConstructedWithValidParameters {

        @Test
        void shouldCreateHeaderWithValidNameAndValue() {
            RequestHeader header = new RequestHeader("Authorization", "Bearer token123");

            assertEquals("Authorization", header.getName());
            assertEquals("Bearer token123", header.getValue());
        }

        @Test
        void shouldCreateHeaderWithValidNameAndNullValue() {
            RequestHeader header = new RequestHeader("X-Custom-Header", null);

            assertEquals("X-Custom-Header", header.getName());
            assertNull(header.getValue());
        }

        @Test
        void shouldCreateHeaderWithValidNameAndEmptyValue() {
            RequestHeader header = new RequestHeader("X-Custom-Header", "");

            assertEquals("X-Custom-Header", header.getName());
            assertEquals("", header.getValue());
        }
    }

    @Nested
    class WhenConvertingToString {

        @Test
        void shouldReturnFormattedNameAndValue() {
            RequestHeader header = new RequestHeader("Content-Type", "application/json");

            assertEquals("Content-Type:application/json", header.toString());
        }

        @Test
        void shouldReturnFormattedStringWithNullValue() {
            RequestHeader header = new RequestHeader("X-Custom-Header", null);

            assertEquals("X-Custom-Header:null", header.toString());
        }

        @Test
        void shouldReturnFormattedStringWithEmptyValue() {
            RequestHeader header = new RequestHeader("X-Custom-Header", "");

            assertEquals("X-Custom-Header:", header.toString());
        }
    }

    @Nested
    class WhenGettingHeaderFromList {

        @Test
        void shouldReturnHeaderWithExactCaseMatch() {
            List<RequestHeader> headers = Arrays.asList(
                new RequestHeader("Content-Type", "application/json"),
                new RequestHeader("Authorization", "Bearer token"),
                new RequestHeader("X-Custom-Header", "custom-value")
            );

            RequestHeader result = RequestHeader.getHeader(headers, "Content-Type");

            assertEquals("Content-Type", result.getName());
            assertEquals("application/json", result.getValue());
        }

        @Test
        void shouldReturnHeaderWithCaseInsensitiveMatch() {
            List<RequestHeader> headers = Arrays.asList(
                new RequestHeader("Content-Type", "application/json"),
                new RequestHeader("Authorization", "Bearer token"),
                new RequestHeader("X-Custom-Header", "custom-value")
            );

            RequestHeader resultLower = RequestHeader.getHeader(headers, "content-type");
            RequestHeader resultUpper = RequestHeader.getHeader(headers, "CONTENT-TYPE");
            RequestHeader resultMixed = RequestHeader.getHeader(headers, "CoNtEnT-tYpE");

            assertEquals("Content-Type", resultLower.getName());
            assertEquals("Content-Type", resultUpper.getName());
            assertEquals("Content-Type", resultMixed.getName());
        }

        @Test
        void shouldReturnNullWhenHeaderNotFound() {
            List<RequestHeader> headers = Arrays.asList(
                new RequestHeader("Content-Type", "application/json"),
                new RequestHeader("Authorization", "Bearer token")
            );

            RequestHeader result = RequestHeader.getHeader(headers, "X-Non-Existent");

            assertNull(result);
        }

        @Test
        void shouldReturnFirstMatchWhenMultipleHeadersSameName() {
            List<RequestHeader> headers = Arrays.asList(
                new RequestHeader("Set-Cookie", "cookie1=value1"),
                new RequestHeader("Set-Cookie", "cookie2=value2")
            );

            RequestHeader result = RequestHeader.getHeader(headers, "Set-Cookie");

            assertEquals("Set-Cookie", result.getName());
            assertEquals("cookie1=value1", result.getValue());
        }
    }

    @Nested
    class WhenGettingHeaderValueFromList {

        @Test
        void shouldReturnValueForExistingHeader() {
            List<RequestHeader> headers = Arrays.asList(
                new RequestHeader("Content-Type", "application/json"),
                new RequestHeader("Authorization", "Bearer token"),
                new RequestHeader("X-Custom-Header", "custom-value")
            );

            String result = RequestHeader.getHeaderValue(headers, "Authorization");

            assertEquals("Bearer token", result);
        }

        @Test
        void shouldReturnValueWithCaseInsensitiveMatch() {
            List<RequestHeader> headers = Arrays.asList(
                new RequestHeader("Content-Type", "application/json"),
                new RequestHeader("Authorization", "Bearer token")
            );

            String resultLower = RequestHeader.getHeaderValue(headers, "authorization");
            String resultUpper = RequestHeader.getHeaderValue(headers, "AUTHORIZATION");

            assertEquals("Bearer token", resultLower);
            assertEquals("Bearer token", resultUpper);
        }

        @Test
        void shouldReturnNullWhenHeaderNotFound() {
            List<RequestHeader> headers = Arrays.asList(
                new RequestHeader("Content-Type", "application/json"),
                new RequestHeader("Authorization", "Bearer token")
            );

            String result = RequestHeader.getHeaderValue(headers, "X-Non-Existent");

            assertNull(result);
        }

        @Test
        void shouldReturnNullValueWhenHeaderValueIsNull() {
            List<RequestHeader> headers = Arrays.asList(
                new RequestHeader("Content-Type", null),
                new RequestHeader("Authorization", "Bearer token")
            );

            String result = RequestHeader.getHeaderValue(headers, "Content-Type");

            assertNull(result);
        }

        @Test
        void shouldReturnEmptyStringWhenHeaderValueIsEmpty() {
            List<RequestHeader> headers = Arrays.asList(
                new RequestHeader("Content-Type", ""),
                new RequestHeader("Authorization", "Bearer token")
            );

            String result = RequestHeader.getHeaderValue(headers, "Content-Type");

            assertEquals("", result);
        }
    }
}
