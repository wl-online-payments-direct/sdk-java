package com.onlinepayments.logging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BodyObfuscatorTest {

    @Nested
    class ObfuscateBody {

        @Test
        void testWithNullBody() {
            String body = null;

            String obfuscatedBody = BodyObfuscator.defaultObfuscator().obfuscateBody(body);

            assertNull(obfuscatedBody);
        }

        @Test
        void testWithEmptyBody() {
            String body = "";

            String obfuscatedBody = BodyObfuscator.defaultObfuscator().obfuscateBody(body);

            assertEquals(body, obfuscatedBody);
        }

        @Test
        void testWithCard() throws IOException {
            testWithMatches("bodyWithCardOriginal.json", "bodyWithCardObfuscated.json");
        }

        @Test
        void testWithCustomCardRule() throws IOException {
            ObfuscationRule obfuscationRule = value -> {
                char[] chars = value.toCharArray();
                for (int i = 6;  i < chars.length - 4; i++) {
                    chars[i] = '*';
                }
                return new String(chars);
            };

            BodyObfuscator bodyObfuscator = BodyObfuscator.custom()
                    .obfuscateCustom("cardNumber", obfuscationRule)
                    .build();

            testWithMatches(bodyObfuscator, "bodyWithCardOriginal.json", "bodyWithCardCustomObfuscated.json");
        }

        @Test
        void testWithIban() throws IOException {
            testWithMatches("bodyWithIbanOriginal.json", "bodyWithIbanObfuscated.json");
        }

        @Test
        void testWithBin() throws IOException {
            testWithMatches("bodyWithBinOriginal.json", "bodyWithBinObfuscated.json");
        }

        @Test
        void testWithNoMatches() throws IOException {
            testWithNoMatches("bodyNoObfuscation.json");
        }

        @Test
        void testWithObject() throws IOException {
            testWithMatches("bodyWithObjectOriginal.json", "bodyWithObjectObfuscated.json");
        }

        private void testWithMatches(String originalResource, String obfuscatedResource) throws IOException {
            testWithMatches(BodyObfuscator.defaultObfuscator(), originalResource, obfuscatedResource);
        }

        private void testWithMatches(BodyObfuscator bodyObfuscator, String originalResource, String obfuscatedResource) throws IOException {
            String body = readResource(originalResource);
            String expected = readResource(obfuscatedResource);

            String obfuscatedBody = bodyObfuscator.obfuscateBody(body);

            assertEquals(expected, obfuscatedBody);
        }

        private void testWithNoMatches(String resource) throws IOException {
            String body = readResource(resource);

            String obfuscatedBody = BodyObfuscator.defaultObfuscator().obfuscateBody(body);

            assertEquals(body, obfuscatedBody);
        }
    }

    private String readResource(String resource) throws IOException {
        StringWriter writer = new StringWriter();

        try (Reader reader = new InputStreamReader(getClass().getResourceAsStream(resource))) {
            char[] buffer = new char[8192];
            int len;
            while ((len = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, len);
            }
        }

        return writer.toString();
    }
}
