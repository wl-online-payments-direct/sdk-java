package com.onlinepayments.communication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RequestParamTest {

    @Nested
    @DisplayName("Constructor with Invalid Name")
    class WhenConstructedWithInvalidName {

        @Test
        void shouldThrowExceptionWhenNameIsNull() {
            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> new RequestParam(null, "value")
            );
            assertEquals("name is required", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenNameIsEmpty() {
            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> new RequestParam("", "value")
            );
            assertEquals("name is required", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenNameIsWhitespace() {
            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> new RequestParam("   ", "value")
            );
            assertEquals("name is required", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Constructor with Valid Parameters")
    class WhenConstructedWithValidParameters {

        @Test
        void shouldCreateParamWithValidNameAndValue() {
            RequestParam param = new RequestParam("userId", "12345");

            assertEquals("userId", param.getName());
            assertEquals("12345", param.getValue());
        }

        @Test
        void shouldCreateParamWithValidNameAndNullValue() {
            RequestParam param = new RequestParam("pageSize", null);

            assertEquals("pageSize", param.getName());
            assertNull(param.getValue());
        }

        @Test
        void shouldCreateParamWithValidNameAndEmptyValue() {
            RequestParam param = new RequestParam("filter", "");

            assertEquals("filter", param.getName());
            assertEquals("", param.getValue());
        }
    }

    @Nested
    @DisplayName("Getting Name")
    class WhenGettingName {

        @Test
        void shouldReturnConfiguredName() {
            RequestParam param = new RequestParam("sortOrder", "DESC");

            assertEquals("sortOrder", param.getName());
        }
    }

    @Nested
    @DisplayName("Getting Value")
    class WhenGettingValue {

        @Test
        void shouldReturnConfiguredValue() {
            RequestParam param = new RequestParam("limit", "100");

            assertEquals("100", param.getValue());
        }

        @Test
        void shouldReturnNullValue() {
            RequestParam param = new RequestParam("offset", null);

            assertNull(param.getValue());
        }

        @Test
        void shouldReturnEmptyValue() {
            RequestParam param = new RequestParam("search", "");

            assertEquals("", param.getValue());
        }
    }

    @Nested
    @DisplayName("Converting to String")
    class WhenConvertingToString {

        @Test
        void shouldReturnFormattedNameAndValue() {
            RequestParam param = new RequestParam("key", "value");

            assertEquals("key:value", param.toString());
        }

        @Test
        void shouldReturnFormattedStringWithNullValue() {
            RequestParam param = new RequestParam("param", null);

            assertEquals("param:null", param.toString());
        }

        @Test
        void shouldReturnFormattedStringWithEmptyValue() {
            RequestParam param = new RequestParam("param", "");

            assertEquals("param:", param.toString());
        }
    }
}
