package com.ingenico.direct.defaultimpl;

import org.junit.Assert;
import org.junit.Test;

import com.ingenico.direct.domain.TokenCard;
import com.ingenico.direct.domain.TokenCardData;
import com.ingenico.direct.domain.TokenResponse;

public class DefaultMarshallerTest {

	@Test
	public void testUnmarshalWithExtraFields() {

		TokenCardData data = new TokenCardData();

		TokenCard card = new TokenCard()
                .withData(data);

        TokenResponse original = new TokenResponseWithExtraField()
                .withExtraField("extra-field-value")
                .withCard(card);

		String json = DefaultMarshaller.INSTANCE.marshal(original);

		TokenResponse unmarshalled = DefaultMarshaller.INSTANCE.unmarshal(json, TokenResponse.class);

		Assert.assertNotNull(unmarshalled.getCard());
		Assert.assertNotNull(unmarshalled.getCard().getData());
	}

	static final class TokenResponseWithExtraField extends TokenResponse {

		private String extraField;

		public String getExtraField() {
			return extraField;
		}
		public void setExtraField(String extraField) {
			this.extraField = extraField;
		}
		public TokenResponseWithExtraField withExtraField(String extraField) {
			this.extraField = extraField;
			return this;
		}
	}
}
