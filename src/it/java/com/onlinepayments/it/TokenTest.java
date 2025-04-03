package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

import com.onlinepayments.ClientInterface;
import com.onlinepayments.domain.Card;
import com.onlinepayments.domain.CreateTokenRequest;
import com.onlinepayments.domain.CreatedTokenResponse;
import com.onlinepayments.domain.TokenCardSpecificInput;
import com.onlinepayments.domain.TokenData;
import com.onlinepayments.merchant.tokens.TokensClientInterface;

public class TokenTest extends ItTest {
    /**
     * Smoke test for token calls.
     */
    @Test
    public void test() throws URISyntaxException, IOException {

        Card card = new Card()
                .withCardholderName("Jan")
                .withCvv("123")
                .withCardNumber("4567350000427977")
                .withExpiryDate("1230");

        TokenData data = new TokenData()
                .withCard(card);

        TokenCardSpecificInput cardToken = new TokenCardSpecificInput()
                .withData(data);

        CreateTokenRequest createTokenRequest = new CreateTokenRequest()
                .withPaymentProductId(1)
                .withCard(cardToken);

        try (ClientInterface client = getClient()) {
            TokensClientInterface tokensClient = client.merchant(getMerchantId()).tokens();
            CreatedTokenResponse createTokenResponse = tokensClient.createToken(createTokenRequest);
            assertNotNull(createTokenResponse.getToken());
            tokensClient.deleteToken(createTokenResponse.getToken());
        }
    }
}
