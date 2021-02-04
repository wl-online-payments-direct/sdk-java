/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * Object containing the details of the validations on the field
 */
public class PaymentProductFieldValidators {

	private EmptyValidator emailAddress = null;

	private EmptyValidator expirationDate = null;

	private FixedListValidator fixedList = null;

	private EmptyValidator iban = null;

	private LengthValidator length = null;

	private EmptyValidator luhn = null;

	private RangeValidator range = null;

	private RegularExpressionValidator regularExpression = null;

	private EmptyValidator termsAndConditions = null;

	public EmptyValidator getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(EmptyValidator value) {
		this.emailAddress = value;
	}

	public EmptyValidator getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(EmptyValidator value) {
		this.expirationDate = value;
	}

	public FixedListValidator getFixedList() {
		return fixedList;
	}

	public void setFixedList(FixedListValidator value) {
		this.fixedList = value;
	}

	public EmptyValidator getIban() {
		return iban;
	}

	public void setIban(EmptyValidator value) {
		this.iban = value;
	}

	public LengthValidator getLength() {
		return length;
	}

	public void setLength(LengthValidator value) {
		this.length = value;
	}

	public EmptyValidator getLuhn() {
		return luhn;
	}

	public void setLuhn(EmptyValidator value) {
		this.luhn = value;
	}

	public RangeValidator getRange() {
		return range;
	}

	public void setRange(RangeValidator value) {
		this.range = value;
	}

	public RegularExpressionValidator getRegularExpression() {
		return regularExpression;
	}

	public void setRegularExpression(RegularExpressionValidator value) {
		this.regularExpression = value;
	}

	public EmptyValidator getTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(EmptyValidator value) {
		this.termsAndConditions = value;
	}
}
