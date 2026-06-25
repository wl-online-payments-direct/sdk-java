package com.onlinepayments.communication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ResponseHeaderTest {

    @Nested
    @DisplayName("Constructor with Invalid Name")
    class WhenConstructedWithNullName {

        @Test
        void shouldThrowExceptionWhenNameIsNull() {
            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> new ResponseHeader(null, "value")
            );
            assertEquals("name is required", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Constructor with Valid Name")
    class WhenConstructedWithValidName {

        @Test
        void shouldCreateHeaderWithValidNameAndValue() {
            ResponseHeader header = new ResponseHeader("Content-Type", "application/json");

            assertEquals("Content-Type", header.getName());
            assertEquals("application/json", header.getValue());
        }

        @Test
        void shouldCreateHeaderWithValidNameAndNullValue() {
            ResponseHeader header = new ResponseHeader("X-Custom-Header", null);

            assertEquals("X-Custom-Header", header.getName());
            assertNull(header.getValue());
        }
    }

    @Nested
    @DisplayName("Getting Name")
    class WhenGettingName {

        @Test
        void shouldReturnConfiguredName() {
            ResponseHeader header = new ResponseHeader("Authorization", "Bearer token");

            assertEquals("Authorization", header.getName());
        }
    }

    @Nested
    @DisplayName("Getting Value")
    class WhenGettingValue {

        @Test
        void shouldReturnConfiguredValue() {
            ResponseHeader header = new ResponseHeader("Content-Type", "application/json");

            assertEquals("application/json", header.getValue());
        }

        @Test
        void shouldReturnNullValue() {
            ResponseHeader header = new ResponseHeader("X-Custom-Header", null);

            assertNull(header.getValue());
        }
    }

    @Nested
    @DisplayName("Converting to String")
    class WhenConvertingToString {

        @Test
        void shouldReturnFormattedNameAndValue() {
            ResponseHeader header = new ResponseHeader("Content-Type", "application/json");

            assertEquals("Content-Type:application/json", header.toString());
        }

        @Test
        void shouldReturnFormattedStringWithNullValue() {
            ResponseHeader header = new ResponseHeader("X-Custom-Header", null);

            assertEquals("X-Custom-Header:null", header.toString());
        }
    }

    @Nested
    @DisplayName("Getting Header from List")
    class WhenGettingHeaderFromList {

        @Test
        void shouldReturnHeaderWithExactCaseMatch() {
            java.util.List<ResponseHeader> headers = Arrays.asList(
                new ResponseHeader("Content-Type", "application/json"),
                new ResponseHeader("Authorization", "Bearer token"),
                new ResponseHeader("X-Custom-Header", "custom-value")
            );

            ResponseHeader result = ResponseHeader.getHeader(headers, "Content-Type");

            assertEquals("Content-Type", result.getName());
            assertEquals("application/json", result.getValue());
        }

        @Test
        void shouldReturnHeaderWithCaseInsensitiveMatch() {
            java.util.List<ResponseHeader> headers = Arrays.asList(
                new ResponseHeader("Content-Type", "application/json"),
                new ResponseHeader("Authorization", "Bearer token")
            );

            ResponseHeader resultLower = ResponseHeader.getHeader(headers, "content-type");
            ResponseHeader resultUpper = ResponseHeader.getHeader(headers, "CONTENT-TYPE");
            ResponseHeader resultMixed = ResponseHeader.getHeader(headers, "CoNtEnT-tYpE");

            assertEquals("Content-Type", resultLower.getName());
            assertEquals("Content-Type", resultUpper.getName());
            assertEquals("Content-Type", resultMixed.getName());
        }

        @Test
        void shouldReturnNullWhenHeaderNotFound() {
            java.util.List<ResponseHeader> headers = Arrays.asList(
                new ResponseHeader("Content-Type", "application/json"),
                new ResponseHeader("Authorization", "Bearer token")
            );

            ResponseHeader result = ResponseHeader.getHeader(headers, "X-Non-Existent");

            assertNull(result);
        }

        @Test
        void shouldReturnFirstMatchWhenMultipleHeadersSameName() {
            java.util.List<ResponseHeader> headers = Arrays.asList(
                new ResponseHeader("Set-Cookie", "cookie1=value1"),
                new ResponseHeader("Set-Cookie", "cookie2=value2")
            );

            ResponseHeader result = ResponseHeader.getHeader(headers, "Set-Cookie");

            assertEquals("Set-Cookie", result.getName());
            assertEquals("cookie1=value1", result.getValue());
        }
    }

    @Nested
    @DisplayName("Getting Header Value from List")
    class WhenGettingHeaderValueFromList {

        @Test
        void shouldReturnValueForExistingHeader() {
            java.util.List<ResponseHeader> headers = Arrays.asList(
                new ResponseHeader("Content-Type", "application/json"),
                new ResponseHeader("Authorization", "Bearer token"),
                new ResponseHeader("X-Custom-Header", "custom-value")
            );

            String result = ResponseHeader.getHeaderValue(headers, "Authorization");

            assertEquals("Bearer token", result);
        }

        @Test
        void shouldReturnValueWithCaseInsensitiveMatch() {
            java.util.List<ResponseHeader> headers = Arrays.asList(
                new ResponseHeader("Content-Type", "application/json"),
                new ResponseHeader("Authorization", "Bearer token")
            );

            String resultLower = ResponseHeader.getHeaderValue(headers, "authorization");
            String resultUpper = ResponseHeader.getHeaderValue(headers, "AUTHORIZATION");

            assertEquals("Bearer token", resultLower);
            assertEquals("Bearer token", resultUpper);
        }

        @Test
        void shouldReturnNullWhenHeaderNotFound() {
            java.util.List<ResponseHeader> headers = Arrays.asList(
                new ResponseHeader("Content-Type", "application/json"),
                new ResponseHeader("Authorization", "Bearer token")
            );

            String result = ResponseHeader.getHeaderValue(headers, "X-Non-Existent");

            assertNull(result);
        }

        @Test
        void shouldReturnNullValueWhenHeaderValueIsNull() {
            java.util.List<ResponseHeader> headers = Arrays.asList(
                new ResponseHeader("Content-Type", null),
                new ResponseHeader("Authorization", "Bearer token")
            );

            String result = ResponseHeader.getHeaderValue(headers, "Content-Type");

            assertNull(result);
        }
    }

    @Nested
    class WhenGettingDispositionFilenameFromVariousContentDispositionValues {

        @Test
        void shouldReturnExpectedFilename() {
            Map<String, String> testData = new LinkedHashMap<>();
            testData.put("attachment; filename=testfile", "testfile");
            testData.put("attachment; filename=\"testfile\"", "testfile");
            testData.put("attachment; filename=\"testfile", "\"testfile");
            testData.put("attachment; filename=testfile\"", "testfile\"");
            testData.put("attachment; filename='testfile'", "testfile");
            testData.put("attachment; filename='testfile", "'testfile");
            testData.put("attachment; filename=testfile'", "testfile'");

            testData.put("filename=testfile", "testfile");
            testData.put("filename=\"testfile\"", "testfile");
            testData.put("filename=\"testfile", "\"testfile");
            testData.put("filename=testfile\"", "testfile\"");
            testData.put("filename='testfile'", "testfile");
            testData.put("filename='testfile", "'testfile");
            testData.put("filename=testfile'", "testfile'");

            testData.put("attachment; filename=testfile; x=y", "testfile");
            testData.put("attachment; filename=\"testfile\"; x=y", "testfile");
            testData.put("attachment; filename=\"testfile; x=y", "\"testfile");
            testData.put("attachment; filename=testfile\"; x=y", "testfile\"");
            testData.put("attachment; filename='testfile'; x=y", "testfile");
            testData.put("attachment; filename='testfile; x=y", "'testfile");
            testData.put("attachment; filename=testfile'; x=y", "testfile'");

            testData.put("attachment", null);

            testData.put("filename=\"", "\"");
            testData.put("filename='", "'");

            for (Map.Entry<String, String> entry : testData.entrySet()) {
                ResponseHeader header = new ResponseHeader("Content-Disposition", entry.getKey());

                assertEquals(
                        entry.getValue(),
                        ResponseHeader.getDispositionFilename(Collections.singletonList(header))
                );
            }
        }
    }
}
