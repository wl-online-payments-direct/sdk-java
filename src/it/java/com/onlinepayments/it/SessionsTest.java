package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.CallContext;
import com.onlinepayments.ClientInterface;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.SessionRequest;
import com.onlinepayments.domain.SessionResponse;
import com.onlinepayments.it.util.SdkTestHelper;
import com.onlinepayments.it.util.sessions.SessionRequestBuilder;
import com.onlinepayments.merchant.sessions.SessionsClientInterface;

public class SessionsTest extends ItTest {

    private ClientInterface client;
    private SessionsClientInterface sessionsClient;

    private SdkTestHelper sdkTestHelper;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        sessionsClient = client.merchant(getMerchantId()).sessions();

        sdkTestHelper = getSdkTestHelper(client);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenCreatingSession {

        @Nested
        class WithValidInput {

            @Test
            void shouldReturnClientSessionId() {
                SessionRequest request = new SessionRequestBuilder().build();

                SessionResponse response = sessionsClient.createSession(request);

                assertNotNull(response);
                assertNotNull(response.getClientSessionId());
                assertNotNull(response.getAssetUrl());
                assertNotNull(response.getClientApiUrl());
            }

            @Test
            void shouldReturnClientSessionIdWithCallContext() {
                SessionRequest request = new SessionRequestBuilder().build();
                CallContext context = new CallContext().withIdempotenceKey("test-session-" + UUID.randomUUID());

                SessionResponse response = sessionsClient.createSession(request, context);

                assertNotNull(response);
                assertNotNull(response.getClientSessionId());
                assertNotNull(response.getAssetUrl());
                assertNotNull(response.getClientApiUrl());
            }
        }

        @Nested
        class WithValidTokens {

            @Test
            void shouldReturnSessionWithValidToken() {
                String tokenId = sdkTestHelper.createTokenAndGetId();
                SessionRequest request = new SessionRequestBuilder()
                        .withToken(tokenId)
                        .build();

                SessionResponse response = sessionsClient.createSession(request);

                assertNotNull(response);
                assertNotNull(response.getClientSessionId());
                assertTrue(response.getInvalidTokens() == null || !response.getInvalidTokens().contains(tokenId));
            }
        }

        @Nested
        class WithTooManyTokens {

            @Test
            void shouldThrowValidationException() {
                SessionRequest request = new SessionRequestBuilder()
                        .withTokens(
                                "firstToken", "secondToken", "thirdToken", "fourthToken", "fifthToken",
                                "sixthToken", "seventhToken", "eighthToken", "ninthToken", "tenthToken", "eleventhToken")
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> sessionsClient.createSession(request));
            }
        }

        @Nested
        class WithInvalidTokenValues {

            @Test
            void shouldReturnSessionWithInvalidTokens() {
                SessionRequest request = new SessionRequestBuilder()
                        .withTokens("65468465464646", "654646464", "easgudasdas")
                        .build();

                SessionResponse response = sessionsClient.createSession(request);

                assertNotNull(response);
                assertNotNull(response.getClientSessionId());
                assertNotNull(response.getInvalidTokens());
                assertFalse(response.getInvalidTokens().isEmpty());
            }
        }
    }
}
