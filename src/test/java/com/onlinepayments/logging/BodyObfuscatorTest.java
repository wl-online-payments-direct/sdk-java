package com.onlinepayments.logging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BodyObfuscatorTest {

    @Nested
    class WhenObfuscatingBody {

        @Nested
        class WithNullBody {

            @Test
            void shouldReturnNull() {
                String body = null;

                String obfuscatedBody = BodyObfuscator.defaultObfuscator().obfuscateBody(body);

                assertNull(obfuscatedBody);
            }
        }

        @Nested
        class WithEmptyBody {

            @Test
            void shouldReturnOriginalBody() {
                String body = "";

                String obfuscatedBody = BodyObfuscator.defaultObfuscator().obfuscateBody(body);

                assertEquals(body, obfuscatedBody);
            }
        }

        @Nested
        class WithBodyContainingCard {

            @Test
            void shouldReturnObfuscatedBody() throws IOException {
                assertObfuscationMatches("bodyWithCardOriginal.json", "bodyWithCardObfuscated.json");
            }

            @Test
            void shouldReturnBodyObfuscatedWithCustomRule() throws IOException {
                ObfuscationRule obfuscationRule = value -> {
                    char[] chars = value.toCharArray();
                    for (int i = 6; i < chars.length - 4; i++) {
                        chars[i] = '*';
                    }
                    return new String(chars);
                };

                BodyObfuscator bodyObfuscator = BodyObfuscator.custom()
                        .obfuscateCustom("cardNumber", obfuscationRule)
                        .build();

                assertObfuscationMatches(
                        bodyObfuscator,
                        "bodyWithCardOriginal.json",
                        "bodyWithCardCustomObfuscated.json"
                );
            }
        }

        @Nested
        class WithBodyContainingIban {

            @Test
            void shouldReturnObfuscatedBody() throws IOException {
                assertObfuscationMatches("bodyWithIbanOriginal.json", "bodyWithIbanObfuscated.json");
            }
        }

        @Nested
        class WithBodyContainingBin {

            @Test
            void shouldReturnObfuscatedBody() throws IOException {
                assertObfuscationMatches("bodyWithBinOriginal.json", "bodyWithBinObfuscated.json");
            }
        }

        @Nested
        class WithoutMatchingFields {

            @Test
            void shouldReturnOriginalBody() throws IOException {
                assertNoObfuscation("bodyNoObfuscation.json");
            }
        }

        @Nested
        class WithBodyContainingNestedObject {

            @Test
            void shouldReturnObfuscatedBody() throws IOException {
                assertObfuscationMatches("bodyWithObjectOriginal.json", "bodyWithObjectObfuscated.json");
            }
        }

        @Nested
        class WithReaderInput {

            @Test
            void shouldReturnObfuscatedBody() throws IOException {
                BodyObfuscator bodyObfuscator = BodyObfuscator.defaultObfuscator();
                String body = readResource("bodyWithCardOriginal.json");
                String expected = readResource("bodyWithCardObfuscated.json");

                String obfuscatedBody = bodyObfuscator.obfuscateBody(new StringReader(body));

                assertEquals(expected, obfuscatedBody);
            }

            @Test
            void shouldReturnEmptyStringWhenReaderIsEmpty() throws IOException {
                BodyObfuscator bodyObfuscator = BodyObfuscator.defaultObfuscator();

                String obfuscatedBody = bodyObfuscator.obfuscateBody(new StringReader(""));

                assertEquals("", obfuscatedBody);
            }
        }

        @Nested
        class WithInputStreamAndCharset {

            @Test
            void shouldReturnObfuscatedBody() throws IOException {
                BodyObfuscator bodyObfuscator = BodyObfuscator.defaultObfuscator();
                String expected = readResource("bodyWithCardObfuscated.json");

                try (InputStream bodyStream = getClass().getResourceAsStream("bodyWithCardOriginal.json")) {
                    String obfuscatedBody = bodyObfuscator.obfuscateBody(bodyStream, StandardCharsets.UTF_8);

                    assertEquals(expected, obfuscatedBody);
                }
            }

            @Test
            void shouldThrowNullPointerExceptionWhenCharsetIsNull() throws IOException {
                BodyObfuscator bodyObfuscator = BodyObfuscator.defaultObfuscator();

                try (InputStream bodyStream = getClass().getResourceAsStream("bodyWithCardOriginal.json")) {
                    assertThrows(
                            NullPointerException.class,
                            () -> bodyObfuscator.obfuscateBody(bodyStream, null)
                    );
                }
            }
        }

        private void assertObfuscationMatches(String originalResource, String obfuscatedResource) throws IOException {
            assertObfuscationMatches(BodyObfuscator.defaultObfuscator(), originalResource, obfuscatedResource);
        }

        private void assertObfuscationMatches(
                BodyObfuscator bodyObfuscator,
                String originalResource,
                String obfuscatedResource
        ) throws IOException {
            String body = readResource(originalResource);
            String expected = readResource(obfuscatedResource);

            String obfuscatedBody = bodyObfuscator.obfuscateBody(body);

            assertEquals(expected, obfuscatedBody);
        }

        private void assertNoObfuscation(String resource) throws IOException {
            String body = readResource(resource);

            String obfuscatedBody = BodyObfuscator.defaultObfuscator().obfuscateBody(body);

            assertEquals(body, obfuscatedBody);
        }

        @Nested
        class WithCustomObfuscatorWithNoRules {

            @Test
            void shouldObfuscateCardNumberUsingDefaultRules() throws IOException {
                BodyObfuscator bodyObfuscator = BodyObfuscator.custom().build();

                assertObfuscationMatches(
                        bodyObfuscator,
                        "bodyWithCardOriginal.json",
                        "bodyWithCardObfuscated.json"
                );
            }

            @Test
            void shouldObfuscateIbanUsingDefaultRules() throws IOException {
                BodyObfuscator bodyObfuscator = BodyObfuscator.custom().build();

                assertObfuscationMatches(
                        bodyObfuscator,
                        "bodyWithIbanOriginal.json",
                        "bodyWithIbanObfuscated.json"
                );
            }

            @Test
            void shouldObfuscateBinUsingDefaultRules() throws IOException {
                BodyObfuscator bodyObfuscator = BodyObfuscator.custom().build();

                assertObfuscationMatches(
                        bodyObfuscator,
                        "bodyWithBinOriginal.json",
                        "bodyWithBinObfuscated.json"
                );
            }
        }
    }

    private String readResource(String resource) throws IOException {
        StringWriter writer = new StringWriter();

        try (Reader reader = new InputStreamReader(getClass().getResourceAsStream(resource), StandardCharsets.UTF_8)) {
            char[] buffer = new char[8192];
            int len;
            while ((len = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, len);
            }
        }

        return writer.toString();
    }
}
