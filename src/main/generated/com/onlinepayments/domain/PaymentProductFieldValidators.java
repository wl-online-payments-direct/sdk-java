/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

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

	public PaymentProductFieldValidators withEmailAddress(EmptyValidator value) {
		this.emailAddress = value;
		return this;
	}

	public EmptyValidator getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(EmptyValidator value) {
		this.expirationDate = value;
	}

	public PaymentProductFieldValidators withExpirationDate(EmptyValidator value) {
		this.expirationDate = value;
		return this;
	}

	public FixedListValidator getFixedList() {
		return fixedList;
	}

	public void setFixedList(FixedListValidator value) {
		this.fixedList = value;
	}

	public PaymentProductFieldValidators withFixedList(FixedListValidator value) {
		this.fixedList = value;
		return this;
	}

	public EmptyValidator getIban() {
		return iban;
	}

	public void setIban(EmptyValidator value) {
		this.iban = value;
	}

	public PaymentProductFieldValidators withIban(EmptyValidator value) {
		this.iban = value;
		return this;
	}

	public LengthValidator getLength() {
		return length;
	}

	public void setLength(LengthValidator value) {
		this.length = value;
	}

	public PaymentProductFieldValidators withLength(LengthValidator value) {
		this.length = value;
		return this;
	}

	public EmptyValidator getLuhn() {
		return luhn;
	}

	public void setLuhn(EmptyValidator value) {
		this.luhn = value;
	}

	public PaymentProductFieldValidators withLuhn(EmptyValidator value) {
		this.luhn = value;
		return this;
	}

	public RangeValidator getRange() {
		return range;
	}

	public void setRange(RangeValidator value) {
		this.range = value;
	}

	public PaymentProductFieldValidators withRange(RangeValidator value) {
		this.range = value;
		return this;
	}

	public RegularExpressionValidator getRegularExpression() {
		return regularExpression;
	}

	public void setRegularExpression(RegularExpressionValidator value) {
		this.regularExpression = value;
	}

	public PaymentProductFieldValidators withRegularExpression(RegularExpressionValidator value) {
		this.regularExpression = value;
		return this;
	}

	public EmptyValidator getTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(EmptyValidator value) {
		this.termsAndConditions = value;
	}

	public PaymentProductFieldValidators withTermsAndConditions(EmptyValidator value) {
		this.termsAndConditions = value;
		return this;
	}
}
