package com.onlinepayments.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.communication.ResponseHeader;

class ResponseExceptionTest {

    @Nested
    class WhenResponseExceptionIsCreatedWithoutHeaders {

        @Test
        void shouldReturnEmptyHeadersAndNullHeaderValues() {
            ResponseException exception = new ResponseException(400, null, null);

            assertEquals(400, exception.getStatusCode());
            assertNull(exception.getBody());
            assertNotNull(exception.getHeaders());
            assertTrue(exception.getHeaders().isEmpty());
            assertNull(exception.getHeader("Content-Type"));
            assertNull(exception.getHeaderValue("Content-Type"));
        }
    }

    @Nested
    class WhenResponseExceptionIsConvertedToString {

        @Test
        void shouldContainStatusCodeAndResponseBody() {
            List<ResponseHeader> headers = Collections.singletonList(
                new ResponseHeader("Content-Type", "application/json")
            );

            ResponseException exception = new ResponseException(
                    404,
                    "{\"error\":\"not found\"}",
                    headers
            );

            String value = exception.toString();

            assertTrue(value.contains(ResponseException.class.getName()));
            assertTrue(value.contains("statusCode=404"));
            assertTrue(value.contains("responseBody='{\"error\":\"not found\"}'"));
        }
    }

    @Nested
    class WhenResponseExceptionIsCreatedWithHeaders {

        @Test
        void shouldReturnExpectedHeadersAndHeaderValues() {
            List<ResponseHeader> headers = Arrays.asList(
                new ResponseHeader("Content-Type", "application/json"),
                new ResponseHeader("X-Request-Id", "request-id")
            );

            ResponseException exception = new ResponseException(
                    400,
                    "{\"error\":\"bad request\"}",
                    headers
            );

            assertEquals(400, exception.getStatusCode());
            assertEquals("{\"error\":\"bad request\"}", exception.getBody());
            assertEquals(headers, exception.getHeaders());
            assertNotNull(exception.getHeader("Content-Type"));
            assertEquals("application/json", exception.getHeaderValue("Content-Type"));
            assertNotNull(exception.getHeader("X-Request-Id"));
            assertEquals("request-id", exception.getHeaderValue("X-Request-Id"));
        }
    }
}
