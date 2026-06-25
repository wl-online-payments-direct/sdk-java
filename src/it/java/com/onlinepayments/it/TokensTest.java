package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
import com.onlinepayments.domain.CreateTokenRequest;
import com.onlinepayments.domain.CreatedTokenResponse;
import com.onlinepayments.domain.TokenResponse;
import com.onlinepayments.it.util.SdkTestHelper;
import com.onlinepayments.it.util.common.CreateTokenRequestBuilder;
import com.onlinepayments.merchant.tokens.TokensClientInterface;

public class TokensTest extends ItTest {

    private static final String INVALID_TOKEN_ID = "invalid_token_12345";
    private static final String EXPECTED_CARDHOLDER_NAME = "John Doe";
    private static final String EXPECTED_EXPIRY_DATE = "1230";

    private ClientInterface client;
    private TokensClientInterface tokensClient;

    private SdkTestHelper sdkTestHelper;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        tokensClient = client.merchant(getMerchantId()).tokens();

        sdkTestHelper = getSdkTestHelper(client);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenCreatingToken {

        @Nested
        class WithValidInput {

            @Test
            void shouldReturnValidResponse() {
                CreateTokenRequest request = new CreateTokenRequestBuilder().build();

                CreatedTokenResponse response = tokensClient.createToken(request);

                assertNotNull(response);
                assertNotNull(response.getToken());
                assertNotNull(response.getCard());
                assertEquals(EXPECTED_CARDHOLDER_NAME, response.getCard().getCardholderName());
                assertEquals(EXPECTED_EXPIRY_DATE, response.getCard().getExpiryDate());
                assertNotNull(response.getCard().getCardNumber());
            }

            @Test
            void shouldReturnValidResponseWithCallContext() {
                CreateTokenRequest request = new CreateTokenRequestBuilder().build();
                CallContext context = new CallContext().withIdempotenceKey("test-tokens-" + UUID.randomUUID());

                CreatedTokenResponse response = tokensClient.createToken(request, context);

                assertNotNull(response);
                assertNotNull(response.getToken());
                assertNotNull(response.getCard());
                assertEquals(EXPECTED_CARDHOLDER_NAME, response.getCard().getCardholderName());
                assertEquals(EXPECTED_EXPIRY_DATE, response.getCard().getExpiryDate());
                assertNotNull(response.getCard().getCardNumber());
            }
        }

        @Nested
        class WithInvalidCardNumber {

            @Test
            void shouldThrowValidationException() {
                CreateTokenRequest request = new CreateTokenRequestBuilder()
                        .withCardNumber("1234567890123456")
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> tokensClient.createToken(request));
            }
        }

        @Nested
        class WithInvalidExpiryDate {

            @Test
            void shouldThrowValidationException() {
                CreateTokenRequest request = new CreateTokenRequestBuilder()
                        .withExpiryDate("0000")
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> tokensClient.createToken(request));
            }
        }

        @Nested
        class WithInvalidCvv {

            @Test
            void shouldThrowValidationException() {
                CreateTokenRequest request = new CreateTokenRequestBuilder()
                        .withCvv("12345678")
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> tokensClient.createToken(request));
            }
        }
    }

    @Nested
    class WhenGettingToken {

        @Nested
        class WithValidTokenId {

            @Test
            void shouldReturnTokenDetails() {
                String tokenId = sdkTestHelper.createTokenAndGetId();

                TokenResponse response = tokensClient.getToken(tokenId);

                assertNotNull(response);
                assertNotNull(response.getId());
                assertEquals(tokenId, response.getId());
                assertNotNull(response.getPaymentProductId());

                assertNotNull(response.getCard());
                assertNotNull(response.getCard().getData());
                assertNotNull(response.getCard().getData().getCardWithoutCvv());
                assertNotNull(response.getCard().getData().getCardWithoutCvv().getCardNumber());
            }
        }

        @Nested
        class WithInvalidTokenId {

            @Test
            void shouldThrowReferenceException() {
                assertThrows(
                        ReferenceException.class,
                        () -> tokensClient.getToken(INVALID_TOKEN_ID));
            }
        }
    }

    @Nested
    class WhenDeletingToken {

        @Nested
        class WithValidTokenId {

            @Test
            void shouldDeleteToken() {
                String tokenId = sdkTestHelper.createTokenAndGetId();

                tokensClient.deleteToken(tokenId);

                assertThrows(
                        ReferenceException.class,
                        () -> tokensClient.getToken(tokenId));
            }
        }

        @Nested
        class WithInvalidTokenId {

            @Test
            void shouldThrowReferenceException() {
                assertThrows(
                        ReferenceException.class,
                        () -> tokensClient.deleteToken(INVALID_TOKEN_ID));
            }
        }
    }
}
