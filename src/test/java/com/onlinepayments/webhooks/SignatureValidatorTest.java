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
    void clearSecretKeyStore() {
        InMemorySecretKeyStore.INSTANCE.clear();
    }

    @Nested
    class WhenValidatingSignature {
        @Nested
        class FromByteArray {

            @Test
            void shouldNotThrowWhenRequestIsValid() throws IOException {
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                byte[] body = readValidBodyAsBytes();
                List<RequestHeader> requestHeaders = createValidRequestHeaders();

                assertDoesNotThrow(() -> signatureValidator.validate(body, requestHeaders));
            }

            @Test
            void shouldThrowSecretKeyNotAvailableExceptionWhenSecretKeyIsMissing() throws IOException {
                byte[] body = readValidBodyAsBytes();
                List<RequestHeader> requestHeaders = createValidRequestHeaders();

                SecretKeyNotAvailableException exception = assertThrows(
                        SecretKeyNotAvailableException.class,
                        () -> signatureValidator.validate(body, requestHeaders)
                );

                assertEquals(KEY_ID, exception.getKeyId());
            }

            @Test
            void shouldThrowSignatureValidationExceptionWhenHeadersAreMissing() throws IOException {
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                byte[] body = readValidBodyAsBytes();
                List<RequestHeader> requestHeaders = Collections.emptyList();

                assertThrows(SignatureValidationException.class, () -> signatureValidator.validate(body, requestHeaders));
            }

            @Test
            void shouldThrowSignatureValidationExceptionWhenHeadersAreDuplicated() throws IOException {
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                byte[] body = readValidBodyAsBytes();
                List<RequestHeader> requestHeaders = Arrays.asList(
                    new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                    new RequestHeader(KEY_ID_HEADER, KEY_ID),
                    new RequestHeader(SIGNATURE_HEADER, SIGNATURE + "1")
                );

                assertThrows(SignatureValidationException.class, () -> signatureValidator.validate(body, requestHeaders));
            }

            @Test
            void shouldThrowSignatureValidationExceptionWhenBodyIsInvalid() throws IOException {
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                byte[] body = readInvalidBodyAsBytes();
                List<RequestHeader> requestHeaders = createValidRequestHeaders();

                assertThrows(SignatureValidationException.class, () -> signatureValidator.validate(body, requestHeaders));
            }

            @Test
            void shouldThrowSignatureValidationExceptionWhenSecretKeyIsInvalid() throws IOException {
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, "1" + SECRET_KEY);

                byte[] body = readValidBodyAsBytes();
                List<RequestHeader> requestHeaders = createValidRequestHeaders();

                assertThrows(SignatureValidationException.class, () -> signatureValidator.validate(body, requestHeaders));
            }

            @Test
            void shouldThrowSignatureValidationExceptionWhenSignatureIsInvalid() throws IOException {
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                byte[] body = readValidBodyAsBytes();
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
            void shouldNotThrowWhenRequestIsValid() throws IOException {
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                String body = readValidBodyAsString();
                List<RequestHeader> requestHeaders = createValidRequestHeaders();

                assertDoesNotThrow(() -> signatureValidator.validate(body, requestHeaders));
            }

            @Test
            void shouldThrowSecretKeyNotAvailableExceptionWhenSecretKeyIsMissing() throws IOException {
                String body = readValidBodyAsString();
                List<RequestHeader> requestHeaders = createValidRequestHeaders();

                SecretKeyNotAvailableException exception = assertThrows(
                        SecretKeyNotAvailableException.class,
                        () -> signatureValidator.validate(body, requestHeaders)
                );

                assertEquals(KEY_ID, exception.getKeyId());
            }

            @Test
            void shouldThrowSignatureValidationExceptionWhenHeadersAreMissing() throws IOException {
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                String body = readValidBodyAsString();
                List<RequestHeader> requestHeaders = Collections.emptyList();

                assertThrows(SignatureValidationException.class, () -> signatureValidator.validate(body, requestHeaders));
            }

            @Test
            void shouldThrowSignatureValidationExceptionWhenHeadersAreDuplicated() throws IOException {
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                String body = readValidBodyAsString();
                List<RequestHeader> requestHeaders = Arrays.asList(
                    new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                    new RequestHeader(KEY_ID_HEADER, KEY_ID),
                    new RequestHeader(SIGNATURE_HEADER, SIGNATURE + "1")
                );

                assertThrows(SignatureValidationException.class, () -> signatureValidator.validate(body, requestHeaders));
            }

            @Test
            void shouldThrowSignatureValidationExceptionWhenBodyIsInvalid() throws IOException {
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                String body = readInvalidBodyAsString();
                List<RequestHeader> requestHeaders = createValidRequestHeaders();

                assertThrows(SignatureValidationException.class, () -> signatureValidator.validate(body, requestHeaders));
            }

            @Test
            void shouldThrowSignatureValidationExceptionWhenSecretKeyIsInvalid() throws IOException {
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, "1" + SECRET_KEY);

                String body = readValidBodyAsString();
                List<RequestHeader> requestHeaders = createValidRequestHeaders();

                assertThrows(SignatureValidationException.class, () -> signatureValidator.validate(body, requestHeaders));
            }

            @Test
            void shouldThrowSignatureValidationExceptionWhenSignatureIsInvalid() throws IOException {
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                String body = readValidBodyAsString();
                List<RequestHeader> requestHeaders = Arrays.asList(
                    new RequestHeader(SIGNATURE_HEADER, "1" + SIGNATURE),
                    new RequestHeader(KEY_ID_HEADER, KEY_ID)
                );

                assertThrows(SignatureValidationException.class, () -> signatureValidator.validate(body, requestHeaders));
            }
        }
    }

    private List<RequestHeader> createValidRequestHeaders() {
        return Arrays.asList(
            new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
            new RequestHeader(KEY_ID_HEADER, KEY_ID)
        );
    }

    private String readValidBodyAsString() throws IOException {
        return new String(readResource("valid-body"), CHARSET);
    }

    private String readInvalidBodyAsString() throws IOException {
        return new String(readResource("invalid-body"), CHARSET);
    }

    private byte[] readValidBodyAsBytes() throws IOException {
        return readResource("valid-body");
    }

    private byte[] readInvalidBodyAsBytes() throws IOException {
        return readResource("invalid-body");
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
