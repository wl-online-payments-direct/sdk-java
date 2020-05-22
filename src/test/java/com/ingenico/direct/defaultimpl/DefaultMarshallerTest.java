package com.ingenico.direct.defaultimpl;

import org.junit.Assert;
import org.junit.Test;

import com.ingenico.direct.domain.Address;
import com.ingenico.direct.domain.TokenCard;
import com.ingenico.direct.domain.TokenCardData;
import com.ingenico.direct.domain.TokenResponse;

public class DefaultMarshallerTest {

	@Test
	public void testUnmarshalWithExtraFields() {
		TokenResponseWithExtraField original = new TokenResponseWithExtraField();

		Address billingAddress = new Address();
		billingAddress.setCountryCode("NL");

		TokenCardData data = new TokenCardData();

		TokenCard card = new TokenCard();
		card.setData(data);
		original.setCard(card);

		original.extraField = "extra-field-value";

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
	}
}
