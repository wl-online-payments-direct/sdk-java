package com.ingenico.direct.it;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;

import com.ingenico.direct.Client;
import com.ingenico.direct.domain.Card;
import com.ingenico.direct.domain.CreateTokenRequest;
import com.ingenico.direct.domain.CreatedTokenResponse;
import com.ingenico.direct.domain.TokenCardSpecificInput;
import com.ingenico.direct.domain.TokenData;
import com.ingenico.direct.merchant.tokens.TokensClient;

public class TokenTest extends ItTest {

	/**
	 * Smoke test for token calls.
	 */
	@Test
	public void test() throws URISyntaxException, IOException {

		CreateTokenRequest createTokenRequest = new CreateTokenRequest();
		createTokenRequest.setPaymentProductId(1);

		TokenCardSpecificInput cardToken = new TokenCardSpecificInput();
		createTokenRequest.setCard(cardToken);

		TokenData data = new TokenData();
		cardToken.setData(data);

		Card card = new Card();
        data.setCard(card);
		card.setCardholderName("Jan");
		card.setCvv("123");
		card.setCardNumber("4567350000427977");
		card.setExpiryDate("1230");

		Client client = getClient();
		try {
            TokensClient tokensClient = client.merchant(MERCHANT_ID).tokens();
            CreatedTokenResponse createTokenResponse = tokensClient.createToken(createTokenRequest);
			Assert.assertNotNull(createTokenResponse.getToken());
			tokensClient.deleteToken(createTokenResponse.getToken());
		} finally {
			client.close();
		}
	}
}
