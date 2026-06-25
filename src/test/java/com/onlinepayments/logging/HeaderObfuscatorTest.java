package com.onlinepayments.logging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HeaderObfuscatorTest {

    @Nested
    @DisplayName("Getting Default Obfuscator")
    class WhenGettingDefaultObfuscator {

        @Test
        void shouldReturnNonNullInstance() {
            HeaderObfuscator obfuscator = HeaderObfuscator.defaultObfuscator();

            assertNotNull(obfuscator);
        }

        @Test
        void shouldReturnSingletonInstance() {
            HeaderObfuscator obfuscator1 = HeaderObfuscator.defaultObfuscator();
            HeaderObfuscator obfuscator2 = HeaderObfuscator.defaultObfuscator();

            assertEquals(obfuscator1, obfuscator2);
        }

        @Test
        void shouldObfuscateAuthorizationHeader() {
            HeaderObfuscator obfuscator = HeaderObfuscator.defaultObfuscator();

            String result = obfuscator.obfuscateHeader("Authorization", "Bearer secret-token");

            assertEquals("********", result);
        }
    }

    @Nested
    @DisplayName("Creating Custom Builder")
    class WhenCreatingCustomBuilder {

        @Test
        void shouldReturnNonNullBuilder() {
            HeaderObfuscator.Builder builder = HeaderObfuscator.custom();

            assertNotNull(builder);
        }

        @Test
        void shouldBuildHeaderObfuscator() {
            HeaderObfuscator obfuscator = HeaderObfuscator.custom().build();

            assertNotNull(obfuscator);
        }

        @Test
        void shouldHavePreDefinedObfuscationRules() {
            HeaderObfuscator obfuscator = HeaderObfuscator.custom().build();

            // Authorization is one of the pre-defined rules
            String result = obfuscator.obfuscateHeader("Authorization", "Bearer token");

            assertEquals("********", result);
        }
    }

    @Nested
    @DisplayName("Building with ObfuscateAll")
    class WhenBuildingWithObfuscateAll {

        @Test
        void shouldReplaceAllCharactersWithAsterisks() {
            HeaderObfuscator obfuscator = HeaderObfuscator.custom()
                    .obfuscateAll("Content-Type")
                    .build();

            String result = obfuscator.obfuscateHeader("Content-Type", "application/json");

            assertEquals("****************", result);
        }

        @Test
        void shouldHandleNullValue() {
            HeaderObfuscator obfuscator = HeaderObfuscator.custom()
                    .obfuscateAll("X-Custom-Header")
                    .build();

            String result = obfuscator.obfuscateHeader("X-Custom-Header", null);

            assertNull(result);
        }

        @Test
        void shouldHandleEmptyValue() {
            HeaderObfuscator obfuscator = HeaderObfuscator.custom()
                    .obfuscateAll("X-Custom-Header")
                    .build();

            String result = obfuscator.obfuscateHeader("X-Custom-Header", "");

            assertEquals("", result);
        }

        @Test
        void shouldBeCaseInsensitive() {
            HeaderObfuscator obfuscator = HeaderObfuscator.custom()
                    .obfuscateAll("Content-Type")
                    .build();

            String resultLower = obfuscator.obfuscateHeader("content-type", "application/json");
            String resultUpper = obfuscator.obfuscateHeader("CONTENT-TYPE", "application/json");

            assertEquals("****************", resultLower);
            assertEquals("****************", resultUpper);
        }
    }

    @Nested
    @DisplayName("Building with ObfuscateWithFixedLength")
    class WhenBuildingWithObfuscateWithFixedLength {

        @Test
        void shouldCreateFixedLengthMask() {
            HeaderObfuscator obfuscator = HeaderObfuscator.custom()
                    .obfuscateWithFixedLength(4, "X-Custom-Header")
                    .build();

            String result = obfuscator.obfuscateHeader("X-Custom-Header", "very-long-value");

            assertEquals("****", result);
        }

        @Test
        void shouldRespectDifferentLengths() {
            HeaderObfuscator obfuscator4 = HeaderObfuscator.custom()
                    .obfuscateWithFixedLength(4, "Header1")
                    .build();
            HeaderObfuscator obfuscator8 = HeaderObfuscator.custom()
                    .obfuscateWithFixedLength(8, "Header2")
                    .build();
            HeaderObfuscator obfuscator16 = HeaderObfuscator.custom()
                    .obfuscateWithFixedLength(16, "Header3")
                    .build();

            assertEquals("****", obfuscator4.obfuscateHeader("Header1", "value"));
            assertEquals("********", obfuscator8.obfuscateHeader("Header2", "value"));
            assertEquals("****************", obfuscator16.obfuscateHeader("Header3", "value"));
        }

        @Test
        void shouldHandleNullValue() {
            HeaderObfuscator obfuscator = HeaderObfuscator.custom()
                    .obfuscateWithFixedLength(8, "X-Token")
                    .build();

            String result = obfuscator.obfuscateHeader("X-Token", null);

            assertNull(result);
        }

        @Test
        void shouldHandleEmptyValue() {
            HeaderObfuscator obfuscator = HeaderObfuscator.custom()
                    .obfuscateWithFixedLength(8, "X-Token")
                    .build();

            String result = obfuscator.obfuscateHeader("X-Token", "");

            assertEquals("", result);
        }
    }

    @Nested
    @DisplayName("Building with ObfuscateAllButFirst")
    class WhenBuildingWithObfuscateAllButFirst {

        @Test
        void shouldKeepFirstCharacterAndObfuscateRest() {
            HeaderObfuscator obfuscator = HeaderObfuscator.custom()
                    .obfuscateAllButFirst(1, "X-Token")
                    .build();

            String result = obfuscator.obfuscateHeader("X-Token", "secret123");

            assertEquals("s********", result);
        }

        @Test
        void shouldKeepSpecifiedNumberOfCharacters() {
            HeaderObfuscator obfuscator1 = HeaderObfuscator.custom()
                    .obfuscateAllButFirst(1, "Header1")
                    .build();
            HeaderObfuscator obfuscator3 = HeaderObfuscator.custom()
                    .obfuscateAllButFirst(3, "Header2")
                    .build();
            HeaderObfuscator obfuscator5 = HeaderObfuscator.custom()
                    .obfuscateAllButFirst(5, "Header3")
                    .build();

            assertEquals("s********", obfuscator1.obfuscateHeader("Header1", "secret123"));
            assertEquals("sec******", obfuscator3.obfuscateHeader("Header2", "secret123"));
            assertEquals("secre****", obfuscator5.obfuscateHeader("Header3", "secret123"));
        }

        @Test
        void shouldHandleNullValue() {
            HeaderObfuscator obfuscator = HeaderObfuscator.custom()
                    .obfuscateAllButFirst(3, "X-Token")
                    .build();

            String result = obfuscator.obfuscateHeader("X-Token", null);

            assertNull(result);
        }

        @Test
        void shouldHandleEmptyValue() {
            HeaderObfuscator obfuscator = HeaderObfuscator.custom()
                    .obfuscateAllButFirst(3, "X-Token")
                    .build();

            String result = obfuscator.obfuscateHeader("X-Token", "");

            assertEquals("", result);
        }
    }

    @Nested
    @DisplayName("Building with ObfuscateAllButLast")
    class WhenBuildingWithObfuscateAllButLast {

        @Test
        void shouldKeepLastCharacterAndObfuscateRest() {
            HeaderObfuscator obfuscator = HeaderObfuscator.custom()
                    .obfuscateAllButLast(1, "X-Token")
                    .build();

            String result = obfuscator.obfuscateHeader("X-Token", "secret123");

            assertEquals("********3", result);
        }

        @Test
        void shouldKeepSpecifiedNumberOfCharacters() {
            HeaderObfuscator obfuscator1 = HeaderObfuscator.custom()
                    .obfuscateAllButLast(1, "Header1")
                    .build();
            HeaderObfuscator obfuscator3 = HeaderObfuscator.custom()
                    .obfuscateAllButLast(3, "Header2")
                    .build();
            HeaderObfuscator obfuscator5 = HeaderObfuscator.custom()
                    .obfuscateAllButLast(5, "Header3")
                    .build();

            assertEquals("********3", obfuscator1.obfuscateHeader("Header1", "secret123"));
            assertEquals("******123", obfuscator3.obfuscateHeader("Header2", "secret123"));
            assertEquals("****et123", obfuscator5.obfuscateHeader("Header3", "secret123"));
        }

        @Test
        void shouldHandleNullValue() {
            HeaderObfuscator obfuscator = HeaderObfuscator.custom()
                    .obfuscateAllButLast(3, "X-Token")
                    .build();

            String result = obfuscator.obfuscateHeader("X-Token", null);

            assertNull(result);
        }

        @Test
        void shouldHandleEmptyValue() {
            HeaderObfuscator obfuscator = HeaderObfuscator.custom()
                    .obfuscateAllButLast(3, "X-Token")
                    .build();

            String result = obfuscator.obfuscateHeader("X-Token", "");

            assertEquals("", result);
        }
    }

    @Nested
    @DisplayName("Building with Custom Obfuscation Rule")
    class WhenBuildingWithCustomObfuscationRule {

        @Test
        void shouldThrowExceptionWhenRuleIsNull() {
            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> HeaderObfuscator.custom()
                            .obfuscateCustom("X-Custom", null)
                            .build()
            );
            assertEquals("obfuscationRule is required", exception.getMessage());
        }

        @Test
        void shouldApplyCustomRule() {
            ObfuscationRule customRule = value -> value != null ? "CUSTOM_" + value.length() : null;

            HeaderObfuscator obfuscator = HeaderObfuscator.custom()
                    .obfuscateCustom("X-Custom", customRule)
                    .build();

            String result = obfuscator.obfuscateHeader("X-Custom", "test-value");

            assertEquals("CUSTOM_10", result);
        }

        @Test
        void shouldAllowMultipleCustomRules() {
            ObfuscationRule rule1 = value -> value != null ? "RULE1_" + value : null;
            ObfuscationRule rule2 = value -> value != null ? "RULE2_" + value : null;

            HeaderObfuscator obfuscator = HeaderObfuscator.custom()
                    .obfuscateCustom("X-Header1", rule1)
                    .obfuscateCustom("X-Header2", rule2)
                    .build();

            assertEquals("RULE1_test1", obfuscator.obfuscateHeader("X-Header1", "test1"));
            assertEquals("RULE2_test2", obfuscator.obfuscateHeader("X-Header2", "test2"));
        }
    }

    @Nested
    @TestInstance(Lifecycle.PER_CLASS)
    class WhenObfuscatingHeader {

        @ParameterizedTest
        @MethodSource("obfuscateHeaderArgs")
        void shouldReturnExpectedValueWithDefaultObfuscator(
                String headerName,
                String originalValue,
                String expectedObfuscatedValue
        ) {
            String obfuscatedValue = HeaderObfuscator.defaultObfuscator()
                    .obfuscateHeader(headerName, originalValue);

            assertEquals(expectedObfuscatedValue, obfuscatedValue);
        }

        Arguments[] obfuscateHeaderArgs() {
            return new Arguments[] {
                arguments("Authorization", "Basic QWxhZGRpbjpPcGVuU2VzYW1l", "********"),
                arguments("authorization", "Basic QWxhZGRpbjpPcGVuU2VzYW1l", "********"),
                arguments("AUTHORIZATION", "Basic QWxhZGRpbjpPcGVuU2VzYW1l", "********"),

                arguments("Authorization", null, null),
                arguments("Authorization", "", ""),

                arguments("Content-Type", "application/json", "application/json"),
                arguments("content-type", "application/json", "application/json"),
                arguments("CONTENT-TYPE", "application/json", "application/json"),
            };
        }

        @ParameterizedTest
        @MethodSource("obfuscateCustomHeaderArgs")
        void shouldReturnExpectedValueWithCustomObfuscator(
                HeaderObfuscator headerObfuscator,
                String headerName,
                String originalValue,
                String expectedObfuscatedValue
        ) {
            String obfuscatedValue = headerObfuscator.obfuscateHeader(headerName, originalValue);

            assertEquals(expectedObfuscatedValue, obfuscatedValue);
        }

        Arguments[] obfuscateCustomHeaderArgs() {
            HeaderObfuscator headerObfuscator = HeaderObfuscator.custom()
                    .obfuscateAll("content-type")
                    .build();

            return new Arguments[] {
                arguments(headerObfuscator, "Authorization", "Basic QWxhZGRpbjpPcGVuU2VzYW1l", "********"),
                arguments(headerObfuscator, "authorization", "Basic QWxhZGRpbjpPcGVuU2VzYW1l", "********"),
                arguments(headerObfuscator, "AUTHORIZATION", "Basic QWxhZGRpbjpPcGVuU2VzYW1l", "********"),

                arguments(headerObfuscator, "Content-Type", "application/json", "****************"),
                arguments(headerObfuscator, "content-type", "application/json", "****************"),
                arguments(headerObfuscator, "CONTENT-TYPE", "application/json", "****************"),
            };
        }
    }
}

