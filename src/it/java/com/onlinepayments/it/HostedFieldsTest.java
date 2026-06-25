package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.ApiException;
import com.onlinepayments.CallContext;
import com.onlinepayments.ClientInterface;
import com.onlinepayments.ProblemDetailsException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.CreateHostedFieldsSessionRequest;
import com.onlinepayments.domain.CreateHostedFieldsSessionResponse;
import com.onlinepayments.domain.GetHostedFieldsSessionResponse;
import com.onlinepayments.it.util.SdkTestHelper;
import com.onlinepayments.it.util.hostedFields.CreateHostedFieldsSessionRequestBuilder;
import com.onlinepayments.merchant.hostedfields.HostedFieldsClientInterface;

public class HostedFieldsTest extends ItTest {

    private static final String INVALID_LOCALE = "invalid-locale";

    private ClientInterface client;
    private HostedFieldsClientInterface hostedFieldsClient;
    private SdkTestHelper sdkTestHelper;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        hostedFieldsClient = client.merchant(getMerchantId()).hostedFields();
        sdkTestHelper = getSdkTestHelper(client);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenCreatingHostedFieldsSession {

        @Nested
        class WithValidInput {

            @Test
            void shouldReturnSessionDataWithSessionId() {
                CreateHostedFieldsSessionRequest request = new CreateHostedFieldsSessionRequestBuilder().build();

                CreateHostedFieldsSessionResponse response = hostedFieldsClient.createHostedFieldsSession(request);

                assertNotNull(response);
                assertNotNull(response.getSessionData());
                assertNotNull(response.getSessionData().getHostedFieldsSessionId());
                assertNotNull(response.getSdkUrl());
                assertNotNull(response.getSdkSri());
            }

            @Test
            void shouldReturnSessionDataWithSessionIdAndCallContext() {
                CreateHostedFieldsSessionRequest request = new CreateHostedFieldsSessionRequestBuilder().build();
                CallContext context = new CallContext().withIdempotenceKey("test-hosted-fields-" + UUID.randomUUID());

                CreateHostedFieldsSessionResponse response = hostedFieldsClient.createHostedFieldsSession(request, context);

                assertNotNull(response);
                assertNotNull(response.getSessionData());
                assertNotNull(response.getSessionData().getHostedFieldsSessionId());
                assertNotNull(response.getSdkUrl());
                assertNotNull(response.getSdkSri());
            }
        }

        @Nested
        class WithMissingLocale {

            @Test
            void shouldThrowValidationException() {
                CreateHostedFieldsSessionRequest request = new CreateHostedFieldsSessionRequestBuilder()
                        .withLocale(null)
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> hostedFieldsClient.createHostedFieldsSession(request));
            }
        }

        @Nested
        class WithEmptyLocale {

            @Test
            void shouldThrowValidationException() {
                CreateHostedFieldsSessionRequest request = new CreateHostedFieldsSessionRequestBuilder()
                        .withLocale("")
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> hostedFieldsClient.createHostedFieldsSession(request));
            }
        }

        @Nested
        class WithInvalidLocaleFormat {

            @Test
            void shouldThrowApiException() {
                CreateHostedFieldsSessionRequest request = new CreateHostedFieldsSessionRequestBuilder()
                        .withLocale(INVALID_LOCALE)
                        .build();

                ApiException exception = assertThrows(
                        ApiException.class,
                        () -> hostedFieldsClient.createHostedFieldsSession(request));

                assertEquals(422, exception.getStatusCode());
            }
        }

        @Nested
        class WithTokens {

            @Test
            void shouldReturnSessionDataWithTokens() {
                String tokenId = sdkTestHelper.createTokenAndGetId();
                CreateHostedFieldsSessionRequest request = new CreateHostedFieldsSessionRequestBuilder()
                        .withTokens(Collections.singletonList(tokenId))
                        .build();

                CreateHostedFieldsSessionResponse response = hostedFieldsClient.createHostedFieldsSession(request);

                assertNotNull(response);
                assertNotNull(response.getSessionData());
                assertNotNull(response.getSessionData().getHostedFieldsSessionId());
            }
        }
    }

    @Nested
    class WhenGettingHostedFieldsSession {

        @Nested
        class WithValidSessionId {

            @Test
            void shouldReturnSessionWithSessionId() {
                CreateHostedFieldsSessionRequest request = new CreateHostedFieldsSessionRequestBuilder().build();
                CreateHostedFieldsSessionResponse createResponse = hostedFieldsClient.createHostedFieldsSession(request);
                String sessionId = createResponse.getSessionData().getHostedFieldsSessionId();

                GetHostedFieldsSessionResponse response = hostedFieldsClient.getHostedFieldsSession(sessionId);

                assertNotNull(response);
                assertEquals(sessionId, response.getSessionId());
            }
        }

        @Nested
            class WithInvalidSessionId {

            @Test
            void shouldThrowProblemDetailsException() {
                ProblemDetailsException exception = assertThrows(
                        ProblemDetailsException.class,
                        () -> hostedFieldsClient.getHostedFieldsSession("invalid-session-id"));

                assertNotNull(exception);
            }
        }
    }
}
