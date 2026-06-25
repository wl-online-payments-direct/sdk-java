package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.onlinepayments.ReferenceException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.CreateHostedTokenizationRequest;
import com.onlinepayments.domain.CreateHostedTokenizationResponse;
import com.onlinepayments.domain.GetHostedTokenizationResponse;
import com.onlinepayments.it.util.SdkTestHelper;
import com.onlinepayments.it.util.hostedTokenization.CreateHostedTokenizationRequestBuilder;
import com.onlinepayments.merchant.hostedtokenization.HostedTokenizationClientInterface;

public class HostedTokenizationTest extends ItTest {

    private static final String INVALID_TOKENIZATION_ID = "invalid_id_12345";

    private ClientInterface client;
    private HostedTokenizationClientInterface hostedTokenizationClient;

    private SdkTestHelper sdkTestHelper;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        hostedTokenizationClient = client.merchant(getMerchantId()).hostedTokenization();

        sdkTestHelper = getSdkTestHelper(client);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenCreatingHostedTokenization {

        @Nested
        class WithValidInput {

            @Test
            void shouldReturnHostedTokenizationIdAndUrl() {
                CreateHostedTokenizationRequest request = new CreateHostedTokenizationRequestBuilder().build();

                CreateHostedTokenizationResponse response = hostedTokenizationClient.createHostedTokenization(request);

                assertNotNull(response);
                assertNotNull(response.getHostedTokenizationId());
                assertNotNull(response.getHostedTokenizationUrl());
            }

            @Test
            void shouldReturnHostedTokenizationIdAndUrlWithCallContext() {
                CreateHostedTokenizationRequest request = new CreateHostedTokenizationRequestBuilder().build();
                CallContext context = new CallContext().withIdempotenceKey("test-hosted-tokenization-" + UUID.randomUUID());

                CreateHostedTokenizationResponse response = hostedTokenizationClient.createHostedTokenization(request, context);

                assertNotNull(response);
                assertNotNull(response.getHostedTokenizationId());
                assertNotNull(response.getHostedTokenizationUrl());
            }
        }

        @Nested
        class WithInvalidLocale {

            @Test
            void shouldThrowValidationException() {
                CreateHostedTokenizationRequest request = new CreateHostedTokenizationRequestBuilder()
                        .withLocale("invalid_locale")
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> hostedTokenizationClient.createHostedTokenization(request));
            }
        }

        @Nested
        class WithTokens {

            @Nested
            class WithSingleInvalidToken {

                @Test
                void shouldReturnSessionWithSingleInvalidToken() {
                    CreateHostedTokenizationRequest request = new CreateHostedTokenizationRequestBuilder()
                            .withToken("firstInvalidToken")
                            .build();

                    CreateHostedTokenizationResponse response = hostedTokenizationClient.createHostedTokenization(request);

                    assertNotNull(response);
                    assertNotNull(response.getHostedTokenizationId());
                    assertNotNull(response.getHostedTokenizationUrl());
                    assertNotNull(response.getInvalidTokens());
                    assertEquals(1, response.getInvalidTokens().size());
                    assertTrue(response.getInvalidTokens().contains("firstInvalidToken"));
                }
            }

            @Nested
            class WithMultipleInvalidTokens {

                @Test
                void shouldReturnSessionWithMultipleInvalidTokens() {
                    CreateHostedTokenizationRequest request = new CreateHostedTokenizationRequestBuilder()
                            .withTokens("firstInvalidToken", "secondInvalidToken")
                            .build();

                    CreateHostedTokenizationResponse response = hostedTokenizationClient.createHostedTokenization(request);

                    assertNotNull(response);
                    assertNotNull(response.getHostedTokenizationId());
                    assertNotNull(response.getHostedTokenizationUrl());
                    assertNotNull(response.getInvalidTokens());
                    assertEquals(2, response.getInvalidTokens().size());
                    assertTrue(response.getInvalidTokens().contains("firstInvalidToken"));
                    assertTrue(response.getInvalidTokens().contains("secondInvalidToken"));
                }
            }

            @Nested
            class WithChainedTokens {

                @Test
                void shouldSupportChainedTokenAddition() {
                    CreateHostedTokenizationRequest request = new CreateHostedTokenizationRequestBuilder()
                            .withToken("firstChainedToken")
                            .withToken("secondChainedToken")
                            .withToken("thirdChainedToken")
                            .build();

                    CreateHostedTokenizationResponse response = hostedTokenizationClient.createHostedTokenization(request);

                    assertNotNull(response);
                    assertNotNull(response.getHostedTokenizationId());
                    assertNotNull(response.getHostedTokenizationUrl());
                    assertNotNull(response.getInvalidTokens());
                    assertEquals(3, response.getInvalidTokens().size());
                    assertTrue(response.getInvalidTokens().contains("firstChainedToken"));
                    assertTrue(response.getInvalidTokens().contains("secondChainedToken"));
                    assertTrue(response.getInvalidTokens().contains("thirdChainedToken"));
                }
            }

            @Nested
            class WithEmptyTokenList {

                @Test
                void shouldHandleEmptyTokenList() {
                    CreateHostedTokenizationRequest request = new CreateHostedTokenizationRequestBuilder()
                            .withTokens()
                            .build();

                    CreateHostedTokenizationResponse response = hostedTokenizationClient.createHostedTokenization(request);

                    assertNotNull(response);
                    assertNotNull(response.getHostedTokenizationId());
                    assertNotNull(response.getHostedTokenizationUrl());
                    assertEquals(0, response.getInvalidTokens().size());
                }
            }

            @Nested
            class WithTokensContainingSpecialCharacters {

                @Test
                void shouldHandleTokensWithSpecialCharacters() {
                    CreateHostedTokenizationRequest request = new CreateHostedTokenizationRequestBuilder()
                            .withTokens("token-with-dashes", "token_with_underscores", "token.with.dots")
                            .build();

                    CreateHostedTokenizationResponse response = hostedTokenizationClient.createHostedTokenization(request);

                    assertNotNull(response);
                    assertNotNull(response.getHostedTokenizationId());
                    assertNotNull(response.getHostedTokenizationUrl());
                    assertNotNull(response.getInvalidTokens());
                    assertEquals(3, response.getInvalidTokens().size());
                }
            }

            @Nested
            class WithLargeNumberOfTokens {

                @Test
                void shouldHandleTenInvalidTokens() {
                    CreateHostedTokenizationRequest request = new CreateHostedTokenizationRequestBuilder()
                            .withTokens(
                                    "firstToken", "secondToken", "thirdToken", "fourthToken", "fifthToken",
                                    "sixthToken", "seventhToken", "eighthToken", "ninthToken", "tenthToken")
                            .build();

                    CreateHostedTokenizationResponse response = hostedTokenizationClient.createHostedTokenization(request);

                    assertNotNull(response);
                    assertNotNull(response.getHostedTokenizationId());
                    assertNotNull(response.getHostedTokenizationUrl());
                    assertNotNull(response.getInvalidTokens());
                    assertEquals(10, response.getInvalidTokens().size());
                }
            }

            @Nested
            class WithDuplicateTokens {

                @Test
                void shouldHandleDuplicateTokens() {
                    CreateHostedTokenizationRequest request = new CreateHostedTokenizationRequestBuilder()
                            .withTokens("duplicateToken", "duplicateToken", "uniqueToken")
                            .build();

                    CreateHostedTokenizationResponse response = hostedTokenizationClient.createHostedTokenization(request);

                    assertNotNull(response);
                    assertNotNull(response.getHostedTokenizationId());
                    assertNotNull(response.getHostedTokenizationUrl());
                    assertNotNull(response.getInvalidTokens());
                    assertFalse(response.getInvalidTokens().isEmpty());
                }
            }
        }
    }

    @Nested
    class WhenGettingHostedTokenization {

        @Nested
        class WithValidHostedTokenizationId {

            @Test
            void shouldReturnHostedTokenizationDetails() {
                String hostedTokenizationId = sdkTestHelper.createHostedTokenizationAndGetId();

                GetHostedTokenizationResponse response = hostedTokenizationClient.getHostedTokenization(hostedTokenizationId);

                assertNotNull(response);
            }
        }

        @Nested
        class WithInvalidHostedTokenizationId {

            @Test
            void shouldThrowReferenceException() {
                assertThrows(
                        ReferenceException.class,
                        () -> hostedTokenizationClient.getHostedTokenization(INVALID_TOKENIZATION_ID));
            }
        }
    }
}
