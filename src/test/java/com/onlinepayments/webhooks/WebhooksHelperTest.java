package com.onlinepayments.webhooks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
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
import com.onlinepayments.domain.WebhooksEvent;
import com.onlinepayments.json.DefaultMarshaller;
import com.onlinepayments.json.Marshaller;

class WebhooksHelperTest {

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    private static final String SIGNATURE_HEADER = "X-GCS-Signature";
    private static final String SIGNATURE = "2S7doBj/GnJnacIjSJzr5fxGM5xmfQyFAwxv1I53ZEk=";

    private static final String KEY_ID_HEADER = "X-GCS-KeyId";
    private static final String KEY_ID = "dummy-key-id";

    private static final String SECRET_KEY = "hello+world";

    @BeforeEach
    @AfterEach
    void clearPublicKeyCache() {
        InMemorySecretKeyStore.INSTANCE.clear();
    }

    @Nested
    class Unmarshal {

        @Test
        void testApiVersionMismatch() throws IOException {
            Marshaller marshaller = mock(Marshaller.class);

            when(marshaller.unmarshal(anyString(), any())).thenAnswer(i -> {
                String responseJson = i.getArgument(0, String.class);
                Class<?> type = i.getArgument(1, Class.class);
                WebhooksEvent event = (WebhooksEvent) DefaultMarshaller.INSTANCE.unmarshal(responseJson, type);
                event.setApiVersion("v0");
                return event;
            });

            WebhooksHelper helper = createHelper(marshaller);

            InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

            String body = new String(readResource("helper-valid-body"), CHARSET);
            List<RequestHeader> requestHeaders = Arrays.asList(
                new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                new RequestHeader(KEY_ID_HEADER, KEY_ID)
            );

            ApiVersionMismatchException exception = assertThrows(ApiVersionMismatchException.class, () -> helper.unmarshal(body, requestHeaders));
            assertEquals("v0", exception.getEventApiVersion());
            assertEquals("v1", exception.getSdkApiVersion());
        }

        @Test
        void testNoSecretKeyAvailable() throws IOException {
            WebhooksHelper helper = createHelper();

            String body = new String(readResource("helper-valid-body"), CHARSET);
            List<RequestHeader> requestHeaders = Arrays.asList(
                new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                new RequestHeader(KEY_ID_HEADER, KEY_ID)
            );

            SecretKeyNotAvailableException exception = assertThrows(SecretKeyNotAvailableException.class, () -> helper.unmarshal(body, requestHeaders));
            assertEquals(KEY_ID, exception.getKeyId());
        }

        @Test
        void testMissingHeaders() throws IOException {
            WebhooksHelper helper = createHelper();

            InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

            String body = new String(readResource("helper-valid-body"), CHARSET);
            List<RequestHeader> requestHeaders = Collections.emptyList();

            assertThrows(SignatureValidationException.class, () -> helper.unmarshal(body, requestHeaders));
        }

        @Test
        void testDuplicateHeaders() throws IOException {
            WebhooksHelper helper = createHelper();

            InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

            String body = new String(readResource("helper-valid-body"), CHARSET);
            List<RequestHeader> requestHeaders = Arrays.asList(
                new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                new RequestHeader(KEY_ID_HEADER, KEY_ID),
                new RequestHeader(SIGNATURE_HEADER, SIGNATURE + "1")
            );

            assertThrows(SignatureValidationException.class, () -> helper.unmarshal(body, requestHeaders));
        }

        @Nested
        class FromBytes {

            @Test
            void testSuccess() throws IOException {
                WebhooksHelper helper = createHelper();

                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                ByteArrayInputStream bodyStream = new ByteArrayInputStream(readResource("helper-valid-body"));
                List<RequestHeader> requestHeaders = Arrays.asList(
                    new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                    new RequestHeader(KEY_ID_HEADER, KEY_ID)
                );

                WebhooksEvent event = helper.unmarshal(bodyStream, requestHeaders);

                assertEquals("v1", event.getApiVersion());
                assertEquals("8ee793f6-4553-4749-85dc-f2ef095c5ab0", event.getId());
                assertEquals("2017-02-02T11:24:14.040+0100", event.getCreated());
                assertEquals("20000", event.getMerchantId());
                assertEquals("payment.paid", event.getType());

                // TODO: custom assertions
            }

            @Test
            void testInvalidBody() throws IOException {
                WebhooksHelper helper = createHelper();

                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                ByteArrayInputStream bodyStream = new ByteArrayInputStream(readResource("helper-invalid-body"));
                List<RequestHeader> requestHeaders = Arrays.asList(
                    new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                    new RequestHeader(KEY_ID_HEADER, KEY_ID)
                );

                assertThrows(SignatureValidationException.class, () -> helper.unmarshal(bodyStream, requestHeaders));
            }

            @Test
            void testInvalidSecretKey() throws IOException {
                WebhooksHelper helper = createHelper();

                String invalidSecretKey = "1" + SECRET_KEY;
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, invalidSecretKey);

                ByteArrayInputStream bodyStream = new ByteArrayInputStream(readResource("helper-valid-body"));
                List<RequestHeader> requestHeaders = Arrays.asList(
                    new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                    new RequestHeader(KEY_ID_HEADER, KEY_ID)
                );

                assertThrows(SignatureValidationException.class, () -> helper.unmarshal(bodyStream, requestHeaders));
            }

            @Test
            void testInvalidSignature() throws IOException {
                WebhooksHelper helper = createHelper();

                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                ByteArrayInputStream bodyStream = new ByteArrayInputStream(readResource("helper-valid-body"));
                List<RequestHeader> requestHeaders = Arrays.asList(
                    new RequestHeader(SIGNATURE_HEADER, "1" + SIGNATURE),
                    new RequestHeader(KEY_ID_HEADER, KEY_ID)
                );

                assertThrows(SignatureValidationException.class, () -> helper.unmarshal(bodyStream, requestHeaders));
            }
        }

        @Nested
        class FromString {

            @Test
            void testSuccess() throws IOException {
                WebhooksHelper helper = createHelper();

                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                String body = new String(readResource("helper-valid-body"), CHARSET);
                List<RequestHeader> requestHeaders = Arrays.asList(
                    new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                    new RequestHeader(KEY_ID_HEADER, KEY_ID)
                );

                WebhooksEvent event = helper.unmarshal(body, requestHeaders);

                assertEquals("v1", event.getApiVersion());
                assertEquals("8ee793f6-4553-4749-85dc-f2ef095c5ab0", event.getId());
                assertEquals("2017-02-02T11:24:14.040+0100", event.getCreated());
                assertEquals("20000", event.getMerchantId());
                assertEquals("payment.paid", event.getType());

                // TODO: custom assertions
            }

            @Test
            void testInvalidBody() throws IOException {
                WebhooksHelper helper = createHelper();

                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                String body = new String(readResource("helper-invalid-body"), CHARSET);
                List<RequestHeader> requestHeaders = Arrays.asList(
                    new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                    new RequestHeader(KEY_ID_HEADER, KEY_ID)
                );

                assertThrows(SignatureValidationException.class, () -> helper.unmarshal(body, requestHeaders));
            }

            @Test
            void testInvalidSecretKey() throws IOException {
                WebhooksHelper helper = createHelper();

                String invalidSecretKey = "1" + SECRET_KEY;
                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, invalidSecretKey);

                String body = new String(readResource("helper-valid-body"), CHARSET);
                List<RequestHeader> requestHeaders = Arrays.asList(
                    new RequestHeader(SIGNATURE_HEADER, SIGNATURE),
                    new RequestHeader(KEY_ID_HEADER, KEY_ID)
                );

                assertThrows(SignatureValidationException.class, () -> helper.unmarshal(body, requestHeaders));
            }

            @Test
            void testInvalidSignature() throws IOException {
                WebhooksHelper helper = createHelper();

                InMemorySecretKeyStore.INSTANCE.storeSecretKey(KEY_ID, SECRET_KEY);

                String body = new String(readResource("helper-valid-body"), CHARSET);
                List<RequestHeader> requestHeaders = Arrays.asList(
                    new RequestHeader(SIGNATURE_HEADER, "1" + SIGNATURE),
                    new RequestHeader(KEY_ID_HEADER, KEY_ID)
                );

                assertThrows(SignatureValidationException.class, () -> helper.unmarshal(body, requestHeaders));
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

    private WebhooksHelper createHelper() {
        return createHelper(DefaultMarshaller.INSTANCE);
    }

    private WebhooksHelper createHelper(Marshaller marshaller) {
        return new WebhooksHelper(marshaller, InMemorySecretKeyStore.INSTANCE);
    }
}
