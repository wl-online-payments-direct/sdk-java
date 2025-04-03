package com.onlinepayments.webhooks;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.communication.RequestHeader;

class SignatureValidatorTest {

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    private static final String SIGNATURE_HEADER = "X-GCS-Signature";
    private static final String SIGNATURE = "6sFZob2yfSpd25MiutFRgBdx8dfbgxs+ZFp5kza1QR8=";

    private static final String KEY_ID_HEADER = "X-GCS-KeyId";
    private static final String KEY_ID = "dummy-key-id";

    private static final String SECRET_KEY = "hello+world";

    private final SignatureValidator signatureValidator = new SignatureValidator(InMemorySecretKeyStore.INSTANCE);

    @BeforeEach
    @AfterEach
    void clearPublicKeyCache() {
        InMemorySecretKeyStore.INSTANCE.clear();
    }

    @Nested
    class Validate {

        @Test
        void testNoSecretKeyAvailable() throws IOException {
            String body = new String(readResource("valid-body"), CHARSET);
            List<RequestHeader> requestHeaders = Arrays.asList(
                    new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                    new RequestHeader(KEY_ID_HEADER, KEY_ID)
            );

            SecretKeyNotAvailableException exception = assertThrows(SecretKeyNotAvailableException.class, () -> signatureValidator.validate(body, requestHeaders));
            assertEquals(KEY_ID, exception.getKeyId());
        }

        @Test
        void testMissingHeaders() throws IOException {
            InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

            String body = new String(readResource("valid-body"), CHARSET);
            List<RequestHeader> requestHeaders = Collections.emptyList();

            assertThrows(SignatureValidationException.class, () -> signatureValidator.validate(body, requestHeaders));
        }

        @Test
        void testDuplicateHeaders() throws IOException {
            InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

            String body = new String(readResource("valid-body"), CHARSET);
            List<RequestHeader> requestHeaders = Arrays.asList(
                    new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                    new RequestHeader(KEY_ID_HEADER, KEY_ID),
                    new RequestHeader(SIGNATURE_HEADER, SIGNATURE + "1")
            );

            assertThrows(SignatureValidationException.class, () -> signatureValidator.validate(body, requestHeaders));
        }

        @Nested
        class FromBytes {

            @Test
            void testSuccess() throws IOException {
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                byte[] body = readResource("valid-body");
                List<RequestHeader> requestHeaders = Arrays.asList(
                        new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                        new RequestHeader(KEY_ID_HEADER, KEY_ID)
                );

                assertDoesNotThrow(() -> signatureValidator.validate(body, requestHeaders));
            }

            @Test
            void testInvalidBody() throws IOException {
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                byte[] body = readResource("invalid-body");
                List<RequestHeader> requestHeaders = Arrays.asList(
                        new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                        new RequestHeader(KEY_ID_HEADER, KEY_ID)
                );

                assertThrows(SignatureValidationException.class, () -> signatureValidator.validate(body, requestHeaders));
            }

            @Test
            void testInvalidSecretKey() throws IOException {
                String invalidSecretKey = "1" + SECRET_KEY;
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, invalidSecretKey);

                byte[] body = readResource("valid-body");
                List<RequestHeader> requestHeaders = Arrays.asList(
                        new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                        new RequestHeader(KEY_ID_HEADER, KEY_ID)
                );

                assertThrows(SignatureValidationException.class, () -> signatureValidator.validate(body, requestHeaders));
            }

            @Test
            void testInvalidSignature() throws IOException {
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                byte[] body = readResource("valid-body");
                List<RequestHeader> requestHeaders = Arrays.asList(
                        new RequestHeader(SIGNATURE_HEADER, "1" + SIGNATURE),
                        new RequestHeader(KEY_ID_HEADER, KEY_ID)
                );

                assertThrows(SignatureValidationException.class, () -> signatureValidator.validate(body, requestHeaders));
            }
        }

        @Nested
        class FromString {

            @Test
            void testSuccess() throws IOException {
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                String body = new String(readResource("valid-body"), CHARSET);
                List<RequestHeader> requestHeaders = Arrays.asList(
                        new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                        new RequestHeader(KEY_ID_HEADER, KEY_ID)
                );

                assertDoesNotThrow(() -> signatureValidator.validate(body, requestHeaders));
            }

            @Test
            void testInvalidBody() throws IOException {
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                String body = new String(readResource("invalid-body"), CHARSET);
                List<RequestHeader> requestHeaders = Arrays.asList(
                        new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                        new RequestHeader(KEY_ID_HEADER, KEY_ID)
                );

                assertThrows(SignatureValidationException.class, () -> signatureValidator.validate(body, requestHeaders));
            }

            @Test
            void testInvalidSecretKey() throws IOException {
                String invalidSecretKey = "1" + SECRET_KEY;
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, invalidSecretKey);

                String body = new String(readResource("valid-body"), CHARSET);
                List<RequestHeader> requestHeaders = Arrays.asList(
                        new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                        new RequestHeader(KEY_ID_HEADER, KEY_ID)
                );

                assertThrows(SignatureValidationException.class, () -> signatureValidator.validate(body, requestHeaders));
            }

            @Test
            void testInvalidSignature() throws IOException {
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                String body = new String(readResource("valid-body"), CHARSET);
                List<RequestHeader> requestHeaders = Arrays.asList(
                        new RequestHeader(SIGNATURE_HEADER, "1" + SIGNATURE),
                        new RequestHeader(KEY_ID_HEADER, KEY_ID)
                );

                assertThrows(SignatureValidationException.class, () -> signatureValidator.validate(body, requestHeaders));
            }
        }
    }

    private byte[] readResource(String resource) throws IOException {
        /*
         * The resources may contain \r on Windows machines, but the body from which the signature was created does not.
         * Strip those out while reading.
         *
         * Note that this should not be done when creating webhooks endpoints. Signatures are created for bodies as they
         * are sent. If such bodies contain \r then stripping out any \r will lead to a signature mismatch. Instead,
         * it's best to read the body in chunks. For instance:
         *
         *     byte[] buffer = new byte[1024];
         *     int len;
         *     while ((len = input.read(buffer)) != -1) {
         *         output.write(buffer, 0, len);
         *     }
         */

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (InputStream input = new BufferedInputStream(getClass().getResourceAsStream(resource))) {
            int b;
            while ((b = input.read()) != -1) {
                if (b != '\r') {
                    output.write(b);
                }
            }
            return output.toByteArray();
        }
    }
}
