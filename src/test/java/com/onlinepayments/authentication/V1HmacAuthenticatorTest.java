package com.onlinepayments.authentication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.CommunicatorConfiguration;
import com.onlinepayments.communication.RequestHeader;

class V1HmacAuthenticatorTest {

    private V1HmacAuthenticator authenticator;

    @BeforeEach
    void setUp() {
        authenticator = new V1HmacAuthenticator("apiKeyId", "secretApiKey");
    }

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Nested
        @DisplayName("With three parameters")
        class WithThreeParameters {

            @Test
            void shouldThrowIllegalArgumentExceptionWhenSecretApiKeyIsNull() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new V1HmacAuthenticator("apiKeyId", null, AuthorizationType.V1HMAC)
                );
                assertEquals("secretApiKey is required", exception.getMessage());
            }

            @Test
            void shouldThrowIllegalArgumentExceptionWhenSecretApiKeyIsEmpty() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new V1HmacAuthenticator("apiKeyId", "", AuthorizationType.V1HMAC)
                );
                assertEquals("secretApiKey is required", exception.getMessage());
            }

            @Test
            void shouldThrowIllegalArgumentExceptionWhenSecretApiKeyIsWhitespace() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new V1HmacAuthenticator("apiKeyId", "   ", AuthorizationType.V1HMAC)
                );
                assertEquals("secretApiKey is required", exception.getMessage());
            }

            @Test
            void shouldThrowIllegalArgumentExceptionWhenApiKeyIdIsNull() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new V1HmacAuthenticator(null, "secretApiKey", AuthorizationType.V1HMAC)
                );
                assertEquals("apiKeyId is required", exception.getMessage());
            }

            @Test
            void shouldThrowIllegalArgumentExceptionWhenApiKeyIdIsEmpty() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new V1HmacAuthenticator("", "secretApiKey", AuthorizationType.V1HMAC)
                );
                assertEquals("apiKeyId is required", exception.getMessage());
            }

            @Test
            void shouldThrowIllegalArgumentExceptionWhenApiKeyIdIsWhitespace() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new V1HmacAuthenticator("   ", "secretApiKey", AuthorizationType.V1HMAC)
                );
                assertEquals("apiKeyId is required", exception.getMessage());
            }

            @Test
            void shouldDefaultToV1HmacWhenAuthorizationTypeIsNull() {
                V1HmacAuthenticator authenticator = new V1HmacAuthenticator("apiKeyId", "secretApiKey", null);
                assertNotNull(authenticator);
            }

            @Test
            void shouldSucceedWithValidParameters() {
                V1HmacAuthenticator authenticator = new V1HmacAuthenticator("apiKeyId", "secretApiKey", AuthorizationType.V1HMAC);
                assertNotNull(authenticator);
            }
        }

        @Nested
        @DisplayName("With two parameters")
        class WithTwoParameters {

            @Test
            void shouldThrowIllegalArgumentExceptionWhenSecretApiKeyIsNull() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new V1HmacAuthenticator("apiKeyId", null)
                );
                assertEquals("secretApiKey is required", exception.getMessage());
            }

            @Test
            void shouldThrowIllegalArgumentExceptionWhenApiKeyIdIsNull() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new V1HmacAuthenticator(null, "secretApiKey")
                );
                assertEquals("apiKeyId is required", exception.getMessage());
            }

            @Test
            void shouldSucceedWithValidParameters() {
                V1HmacAuthenticator authenticator = new V1HmacAuthenticator("apiKeyId", "secretApiKey");
                assertNotNull(authenticator);
            }
        }

        @Nested
        @DisplayName("With CommunicatorConfiguration")
        class WithCommunicatorConfiguration {

            @Test
            void shouldCreateAuthenticatorFromConfiguration() {
                CommunicatorConfiguration config = new CommunicatorConfiguration()
                        .withApiKeyId("configApiKeyId")
                        .withSecretApiKey("configSecretKey")
                        .withAuthorizationType(AuthorizationType.V1HMAC);

                V1HmacAuthenticator authenticator = new V1HmacAuthenticator(config);
                assertNotNull(authenticator);
            }
        }
    }

    @Nested
    class WhenGettingAuthorization {

        @BeforeEach
        void setUp() {
            authenticator = new V1HmacAuthenticator("apiKeyId", "secretApiKey");
        }

        @Nested
        class WithValidInput {

            @Nested
            class WithDefaultConfiguration {

                @Test
                void shouldContainV1HmacAuthorizationType() {
                    String authorization = authenticator.getAuthorization(
                            "POST",
                            URI.create("http://localhost:8080/v2/1/services%20bla/testconnection?aap=noot&mies=geen%20noot"),
                            new ArrayList<>()
                    );

                    assertTrue(authorization.contains(AuthorizationType.V1HMAC.getSignatureString()));
                }
            }

            @Nested
            class ForMinimalExample {

                @Test
                void shouldReturnExpectedAuthorizationHeader() {
                    V1HmacAuthenticator authenticator = new V1HmacAuthenticator(
                            "EC36A74A98D21",
                            "6Kj5HT0MQKC6D8eb7W3lTg71kVKVDSt1"
                    );

                    List<RequestHeader> httpHeaders = new ArrayList<>();
                    httpHeaders.add(new RequestHeader("Date", "Fri, 06 Jun 2014 13:39:43 GMT"));

                    String authorization = authenticator.getAuthorization(
                            "GET",
                            URI.create("http://localhost:8080/v2/1/tokens/2"),
                            httpHeaders
                    );

                    assertEquals(
                            "GCS v1HMAC:EC36A74A98D21:vCos01y77soPNJOW6kDCm4Bu5b2darAZ09PP7Wa+jRA=",
                            authorization
                    );
                }
            }

            @Nested
            class ForFullExample {

                @Test
                void shouldReturnExpectedAuthorizationHeader() {
                    List<RequestHeader> httpHeaders = new ArrayList<>();
                    httpHeaders.add(new RequestHeader("X-GCS-ServerMetaInfo", "processed header value"));
                    httpHeaders.add(new RequestHeader("Content-Type", "application/json"));
                    httpHeaders.add(new RequestHeader("X-GCS-ClientMetaInfo", "processed header value"));
                    httpHeaders.add(new RequestHeader("X-GCS-CustomerHeader", "processed header value"));
                    httpHeaders.add(new RequestHeader("Date", "Fri, 06 Jun 2014 13:39:43 GMT"));

                    String authorization = authenticator.getAuthorization(
                            "DELETE",
                            URI.create("http://localhost:8080/v2/1/tokens/2"),
                            httpHeaders
                    );

                    assertEquals(
                            "GCS v1HMAC:apiKeyId:jXG/ESTtRWawO4OOyxOrtWcQA8XkrZKeoHeGGIj4jws=",
                            authorization
                    );
                }
            }
        }

        @Nested
        class WithInvalidInput {

            @Test
            void shouldThrowIllegalArgumentExceptionWhenHttpMethodIsNull() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> authenticator.getAuthorization(
                            null,
                            URI.create("http://localhost:8080/v2/1/tokens/2"),
                            new ArrayList<>()
                        )
                );
                assertEquals("httpMethod is required", exception.getMessage());
            }

            @Test
            void shouldThrowIllegalArgumentExceptionWhenHttpMethodIsEmpty() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> authenticator.getAuthorization(
                            "",
                            URI.create("http://localhost:8080/v2/1/tokens/2"),
                            new ArrayList<>()
                        )
                );
                assertEquals("httpMethod is required", exception.getMessage());
            }

            @Test
            void shouldThrowIllegalArgumentExceptionWhenHttpMethodIsWhitespace() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> authenticator.getAuthorization(
                            "   ",
                            URI.create("http://localhost:8080/v2/1/tokens/2"),
                            new ArrayList<>()
                        )
                );
                assertEquals("httpMethod is required", exception.getMessage());
            }

            @Test
            void shouldThrowIllegalArgumentExceptionWhenResourceUriIsNull() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> authenticator.getAuthorization(
                            "GET",
                            null,
                            new ArrayList<>()
                        )
                );
                assertEquals("resourceUri is required", exception.getMessage());
            }

            @Test
            void shouldThrowIllegalArgumentExceptionWhenResourceUriIsNullWithNullHeaders() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> authenticator.getAuthorization(
                            "POST",
                            null,
                            null
                        )
                );
                assertEquals("resourceUri is required", exception.getMessage());
            }
        }
    }

    @Nested
    class WhenCanonicalizingHeaderValue {

        @BeforeEach
        void setUp() {
            authenticator = new V1HmacAuthenticator("apiKeyId", "secretApiKey");
        }

        @Nested
        class WithWhitespaceAndNewLines {

            @Test
            void shouldReturnNormalizedValue() {
                assertEquals("aap noot", authenticator.toCanonicalizeHeaderValue("aap\nnoot  "));
                assertEquals("aap noot", authenticator.toCanonicalizeHeaderValue(" aap\r\n  noot"));
            }
        }

        @Nested
        class WithNullAndEmptyValues {

            @Test
            void shouldReturnEmptyStringForNullValue() {
                assertEquals("", authenticator.toCanonicalizeHeaderValue(null));
            }

            @Test
            void shouldReturnEmptyStringForEmptyValue() {
                assertEquals("", authenticator.toCanonicalizeHeaderValue(""));
            }

            @Test
            void shouldReturnTrimmedValueForWhitespaceOnly() {
                assertEquals("", authenticator.toCanonicalizeHeaderValue("   "));
            }

            @Test
            void shouldReturnNormalizedValueWithCarriageReturn() {
                assertEquals("a b c", authenticator.toCanonicalizeHeaderValue("a\r\nb\r\nc"));
            }
        }
    }

    @Nested
    class WhenCanonicalizingHeaderNamesThroughDataToSign {

        @BeforeEach
        void setUp() {
            authenticator = new V1HmacAuthenticator("apiKeyId", "secretApiKey");
        }

        @Test
        void shouldCanonicalizeXGcsHeaderNamesToLowercase() {
            List<RequestHeader> httpHeaders = new ArrayList<>();
            httpHeaders.add(new RequestHeader("X-GCS-ServerMetaInfo", "server-value"));
            httpHeaders.add(new RequestHeader("X-GCS-CLIENTMETAINFO", "client-value"));
            httpHeaders.add(new RequestHeader("X-GCS-CustomerHeader", "customer-value"));
            httpHeaders.add(new RequestHeader("Date", "Mon, 07 Jul 2014 12:12:40 GMT"));

            String dataToSign = authenticator.toDataToSign(
                    "GET",
                    URI.create("http://localhost:8080/v2/1/tokens/2"),
                    httpHeaders
            );

            assertTrue(dataToSign.contains("x-gcs-clientmetainfo:client-value\n"));
            assertTrue(dataToSign.contains("x-gcs-customerheader:customer-value\n"));
            assertTrue(dataToSign.contains("x-gcs-servermetainfo:server-value\n"));
        }

        @Test
        void shouldSortCanonicalizedXGcsHeaderNamesAlphabetically() {
            List<RequestHeader> httpHeaders = new ArrayList<>();
            httpHeaders.add(new RequestHeader("X-GCS-ServerMetaInfo", "server-value"));
            httpHeaders.add(new RequestHeader("X-GCS-CustomerHeader", "customer-value"));
            httpHeaders.add(new RequestHeader("X-GCS-ClientMetaInfo", "client-value"));
            httpHeaders.add(new RequestHeader("Date", "Mon, 07 Jul 2014 12:12:40 GMT"));

            String dataToSign = authenticator.toDataToSign(
                    "GET",
                    URI.create("http://localhost:8080/v2/1/tokens/2"),
                    httpHeaders
            );

            int clientIndex = dataToSign.indexOf("x-gcs-clientmetainfo:client-value\n");
            int customerIndex = dataToSign.indexOf("x-gcs-customerheader:customer-value\n");
            int serverIndex = dataToSign.indexOf("x-gcs-servermetainfo:server-value\n");

            assertTrue(clientIndex < customerIndex);
            assertTrue(customerIndex < serverIndex);
        }

        @Test
        void shouldIgnoreNonXGcsHeadersWhenCreatingCanonicalHeaderBlock() {
            List<RequestHeader> httpHeaders = new ArrayList<>();
            httpHeaders.add(new RequestHeader("User-Agent", "test-agent"));
            httpHeaders.add(new RequestHeader("Accept", "application/json"));
            httpHeaders.add(new RequestHeader("Date", "Mon, 07 Jul 2014 12:12:40 GMT"));

            String dataToSign = authenticator.toDataToSign(
                    "GET",
                    URI.create("http://localhost:8080/v2/1/tokens/2"),
                    httpHeaders
            );

            assertFalse(dataToSign.contains("user-agent"));
            assertFalse(dataToSign.contains("accept:application/json"));
        }
    }

    @Nested
    class WhenCreatingDataToSign {

        @BeforeEach
        void setUp() {
            authenticator = new V1HmacAuthenticator("apiKeyId", "secretApiKey");
        }

        @Nested
        class WithValidHeaders {

            @Test
            void shouldReturnExpectedCanonicalString() {
                List<RequestHeader> httpHeaders = new ArrayList<>();
                httpHeaders.add(new RequestHeader(
                        "X-GCS-ServerMetaInfo",
                        "{\"platformIdentifier\":\"Windows 7/6.1 Java/1.7 (Oracle Corporation; Java HotSpot(TM) 64-Bit Server VM; 1.7.0_45)\",\"sdkIdentifier\":\"1.0\"}"
                ));
                httpHeaders.add(new RequestHeader("Content-Type", "application/json"));
                httpHeaders.add(new RequestHeader("X-GCS-ClientMetaInfo", "{\"aap\",\"noot\"}"));
                httpHeaders.add(new RequestHeader("User-Agent", "Apache-HttpClient/4.3.4 (java 1.5)"));
                httpHeaders.add(new RequestHeader("Date", "Mon, 07 Jul 2014 12:12:40 GMT"));

                String dataToSign = authenticator.toDataToSign(
                        "POST",
                        URI.create("http://localhost:8080/v2/services%20bla/testconnection?aap=noot&mies=geen%20noot"),
                        httpHeaders
                );

                String expectedStart =
                        "POST\n"
                            + "application/json\n";

                String expectedEnd =
                        "x-gcs-clientmetainfo:{\"aap\",\"noot\"}\n"
                            + "x-gcs-servermetainfo:{\"platformIdentifier\":\"Windows 7/6.1 Java/1.7 (Oracle Corporation; Java HotSpot(TM) 64-Bit Server VM; 1.7.0_45)\",\"sdkIdentifier\":\"1.0\"}\n"
                            + "/v2/services bla/testconnection?aap=noot&mies=geen noot\n";

                String actualStart = dataToSign.substring(0, 22);
                String actualEnd = dataToSign.substring(52, 301);

                assertEquals(expectedStart, actualStart);
                assertEquals(expectedEnd, actualEnd);
            }
        }

        @Nested
        class WithSpecialCharactersInMerchantId {

            @Test
            void shouldReturnCorrectCanonicalPath() {
                List<RequestHeader> httpHeaders = new ArrayList<>();
                httpHeaders.add(new RequestHeader(
                        "X-GCS-ServerMetaInfo",
                        "{\"platformIdentifier\":\"Windows 7/6.1 Java/1.7 (Oracle Corporation; Java HotSpot(TM) 64-Bit Server VM; 1.7.0_45)\",\"sdkIdentifier\":\"1.0\"}"
                ));
                httpHeaders.add(new RequestHeader("Content-Type", "application/json"));
                httpHeaders.add(new RequestHeader("X-GCS-ClientMetaInfo", "{\"aap\",\"noot\"}"));
                httpHeaders.add(new RequestHeader("User-Agent", "Apache-HttpClient/4.3.4 (java 1.5)"));
                httpHeaders.add(new RequestHeader("Date", "Mon, 07 Jul 2014 12:12:40 GMT"));

                String dataToSign = authenticator.toDataToSign(
                        "POST",
                        URI.create("http://localhost:8080/v2/spécificCharacterMerchant/testconnection?aap=noot&mies=geen%20noot"),
                        httpHeaders
                );

                String expectedStart =
                        "POST\n"
                            + "application/json\n";

                String expectedEnd =
                        "x-gcs-clientmetainfo:{\"aap\",\"noot\"}\n"
                            + "x-gcs-servermetainfo:{\"platformIdentifier\":\"Windows 7/6.1 Java/1.7 (Oracle Corporation; Java HotSpot(TM) 64-Bit Server VM; 1.7.0_45)\",\"sdkIdentifier\":\"1.0\"}\n"
                            + "/v2/spécificCharacterMerchant/testconnection?aap=noot&mies=geen noot\n";

                String actualStart = dataToSign.substring(0, 22);
                String actualEnd = dataToSign.substring(52, 314);

                assertEquals(expectedStart, actualStart);
                assertEquals(expectedEnd, actualEnd);
            }
        }

        @Nested
        class WithNullHeaders {

            @Test
            void shouldHandleNullHeadersList() {
                String dataToSign = authenticator.toDataToSign(
                        "GET",
                        URI.create("http://localhost:8080/v2/1/tokens/2"),
                        null
                );

                assertTrue(dataToSign.contains("GET\n"));
                assertTrue(dataToSign.contains("/v2/1/tokens/2\n"));
            }
        }

        @Nested
        class WithNoXgcsHeaders {

            @Test
            void shouldExcludeNonXgcsHeaders() {
                List<RequestHeader> httpHeaders = new ArrayList<>();
                httpHeaders.add(new RequestHeader("Content-Type", "application/json"));
                httpHeaders.add(new RequestHeader("User-Agent", "test-agent"));
                httpHeaders.add(new RequestHeader("Date", "Mon, 07 Jul 2014 12:12:40 GMT"));

                String dataToSign = authenticator.toDataToSign(
                        "GET",
                        URI.create("http://localhost:8080/v2/1/tokens/2"),
                        httpHeaders
                );

                assertTrue(dataToSign.contains("GET\n"));
                assertTrue(dataToSign.contains("application/json\n"));
                assertTrue(dataToSign.contains("Mon, 07 Jul 2014 12:12:40 GMT\n"));
                assertTrue(dataToSign.contains("/v2/1/tokens/2\n"));
            }
        }

        @Nested
        class WithoutContentTypeHeader {

            @Test
            void shouldAppendEmptyLineForMissingContentType() {
                List<RequestHeader> httpHeaders = new ArrayList<>();
                httpHeaders.add(new RequestHeader("Date", "Mon, 07 Jul 2014 12:12:40 GMT"));

                String dataToSign = authenticator.toDataToSign(
                        "DELETE",
                        URI.create("http://localhost:8080/v2/1/tokens/2"),
                        httpHeaders
                );

                assertTrue(dataToSign.startsWith("DELETE\n\n"));
            }
        }

        @Nested
        class WithoutDateHeader {

            @Test
            void shouldAppendNullForMissingDate() {
                List<RequestHeader> httpHeaders = new ArrayList<>();
                httpHeaders.add(new RequestHeader("Content-Type", "application/json"));

                String dataToSign = authenticator.toDataToSign(
                        "PUT",
                        URI.create("http://localhost:8080/v2/1/tokens/2"),
                        httpHeaders
                );

                assertTrue(dataToSign.contains("application/json\nnull\n"));
            }
        }

        @Nested
        class WithUriWithoutQuery {

            @Test
            void shouldNotIncludeQueryParamSeparator() {
                List<RequestHeader> httpHeaders = new ArrayList<>();
                httpHeaders.add(new RequestHeader("Date", "Mon, 07 Jul 2014 12:12:40 GMT"));

                String dataToSign = authenticator.toDataToSign(
                        "GET",
                        URI.create("http://localhost:8080/v2/1/tokens/2"),
                        httpHeaders
                );

                assertTrue(dataToSign.endsWith("/v2/1/tokens/2\n"));
            }
        }
    }

    @Nested
    class WhenCreatingAuthenticationSignature {

        @BeforeEach
        void setUp() {
            authenticator = new V1HmacAuthenticator("apiKeyId", "secretApiKey");
        }

        @Nested
        class ForDeleteRequest {

            @Test
            void shouldReturnExpectedSignature() {
                String dataToSign =
                        "DELETE\n"
                            + "application/json\n"
                            + "Fri, 06 Jun 2014 13:39:43 GMT\n"
                            + "x-gcs-clientmetainfo:processed header value\n"
                            + "x-gcs-customerheader:processed header value\n"
                            + "x-gcs-servermetainfo:processed header value\n"
                            + "/v2/1/tokens/2\n";

                String authenticationSignature = authenticator.createAuthenticationSignature(dataToSign);

                assertEquals("jXG/ESTtRWawO4OOyxOrtWcQA8XkrZKeoHeGGIj4jws=", authenticationSignature);
            }
        }

        @Nested
        class ForGetRequest {

            @Test
            void shouldReturnExpectedSignature() {
                V1HmacAuthenticator authenticator = new V1HmacAuthenticator(
                        "EC36A74A98D21",
                        "6Kj5HT0MQKC6D8eb7W3lTg71kVKVDSt1"
                );

                String dataToSign =
                        "GET\n"
                            + "\n"
                            + "Fri, 06 Jun 2014 13:39:43 GMT\n"
                            + "/v2/1/tokens/2\n";

                String authenticationSignature = authenticator.createAuthenticationSignature(dataToSign);

                assertEquals("vCos01y77soPNJOW6kDCm4Bu5b2darAZ09PP7Wa+jRA=", authenticationSignature);
            }
        }
    }

    @Nested
    class WhenWorkingWithAuthorizationType {

        @Nested
        class WhenGettingSignatureString {

            @Test
            void shouldReturnV1HmacSignatureString() {
                assertEquals("v1HMAC", AuthorizationType.V1HMAC.getSignatureString());
            }
        }

        @Nested
        class WhenConvertingFromString {

            @Test
            void shouldReturnV1HmacForExactMatch() {
                assertEquals(AuthorizationType.V1HMAC, AuthorizationType.fromString("v1HMAC"));
            }

            @Test
            void shouldReturnV1HmacForUppercaseMatch() {
                assertEquals(AuthorizationType.V1HMAC, AuthorizationType.fromString("V1HMAC"));
            }

            @Test
            void shouldReturnV1HmacForMixedCaseMatch() {
                assertEquals(AuthorizationType.V1HMAC, AuthorizationType.fromString("v1hmac"));
            }

            @Test
            void shouldReturnV1HmacForLowercaseMatch() {
                assertEquals(AuthorizationType.V1HMAC, AuthorizationType.fromString("v1hmac"));
            }

            @Test
            void shouldThrowNullPointerExceptionForNullInput() {
                NullPointerException exception = assertThrows(
                        NullPointerException.class,
                        () -> AuthorizationType.fromString(null)
                );
                assertEquals("AuthorizationType is null", exception.getMessage());
            }

            @Test
            void shouldThrowIllegalArgumentExceptionForInvalidInput() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> AuthorizationType.fromString("invalid")
                );
                assertTrue(exception.getMessage().contains("No enum constant"));
                assertTrue(exception.getMessage().contains("invalid"));
            }

            @Test
            void shouldThrowIllegalArgumentExceptionForEmptyString() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> AuthorizationType.fromString("")
                );
                assertTrue(exception.getMessage().contains("No enum constant"));
            }

            @Test
            void shouldThrowIllegalArgumentExceptionForUnknownType() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> AuthorizationType.fromString("V2HMAC")
                );
                assertTrue(exception.getMessage().contains("No enum constant"));
                assertTrue(exception.getMessage().contains("V2HMAC"));
            }
        }
    }

    @Test
    public void testWithSpecificCharactersMerchant() {
        V1HmacAuthenticator authenticator = new V1HmacAuthenticator("apiKeyId", "secretApiKey");
        List<RequestHeader> httpHeaders = new ArrayList<RequestHeader>();
        httpHeaders.add(new RequestHeader("X-GCS-ServerMetaInfo", "{\"platformIdentifier\":\"Windows 7/6.1 Java/1.7 (Oracle Corporation; Java HotSpot(TM) 64-Bit Server VM; 1.7.0_45)\",\"sdkIdentifier\":\"1.0\"}"));
        httpHeaders.add(new RequestHeader("Content-Type",           "application/json"));
        httpHeaders.add(new RequestHeader("X-GCS-ClientMetaInfo", "{\"aap\",\"noot\"}"));
        httpHeaders.add(new RequestHeader("User-Agent",           "Apache-HttpClient/4.3.4 (java 1.5)"));
        httpHeaders.add(new RequestHeader("Date",                   "Mon, 07 Jul 2014 12:12:40 GMT"));
        String dataToSign = authenticator.toDataToSign("POST", URI.create("http://localhost:8080/v2/spécificCharacterMerchant/testconnection?aap=noot&mies=geen%20noot"), httpHeaders);

        String expectedStart = "POST\n" + "application/json\n";
        String expectedEnd = "x-gcs-clientmetainfo:{\"aap\",\"noot\"}\n" + "x-gcs-servermetainfo:{\"platformIdentifier\":\"Windows 7/6.1 Java/1.7 (Oracle Corporation; Java HotSpot(TM) 64-Bit Server VM; 1.7.0_45)\",\"sdkIdentifier\":\"1.0\"}\n" + "/v2/spécificCharacterMerchant/testconnection?aap=noot&mies=geen noot\n";

        String actualStart = dataToSign.substring(0, 22);
        String actualEnd = dataToSign.substring(52, 314);

        assertEquals(expectedStart, actualStart);
        assertEquals(expectedEnd, actualEnd);
    }
}
