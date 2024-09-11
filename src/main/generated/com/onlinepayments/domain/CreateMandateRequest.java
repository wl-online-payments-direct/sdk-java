/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing information to create a SEPA Direct Debit mandate.
 */
public class CreateMandateRequest {

	private String alias = null;

	private MandateCustomer customer = null;

	private String customerReference = null;

	private String language = null;

	private String recurrenceType = null;

	private String returnUrl = null;

	private String signatureType = null;

	private String uniqueMandateReference = null;

	/**
	 * An alias for the mandate. This can be used to visually represent the mandate. Do not include any unmasked sensitive data in the alias. If this field is not provided the masked IBAN of the customer is used.
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * An alias for the mandate. This can be used to visually represent the mandate. Do not include any unmasked sensitive data in the alias. If this field is not provided the masked IBAN of the customer is used.
	 */
	public void setAlias(String value) {
		this.alias = value;
	}

	/**
	 * An alias for the mandate. This can be used to visually represent the mandate. Do not include any unmasked sensitive data in the alias. If this field is not provided the masked IBAN of the customer is used.
	 */
	public CreateMandateRequest withAlias(String value) {
		this.alias = value;
		return this;
	}

	/**
	 * Customer object containing customer specific inputs.
	 * Required for Create mandate and Create payment calls.
	 */
	public MandateCustomer getCustomer() {
		return customer;
	}

	/**
	 * Customer object containing customer specific inputs.
	 * Required for Create mandate and Create payment calls.
	 */
	public void setCustomer(MandateCustomer value) {
		this.customer = value;
	}

	/**
	 * Customer object containing customer specific inputs.
	 * Required for Create mandate and Create payment calls.
	 */
	public CreateMandateRequest withCustomer(MandateCustomer value) {
		this.customer = value;
		return this;
	}

	/**
	 * The unique identifier of a customer
	 */
	public String getCustomerReference() {
		return customerReference;
	}

	/**
	 * The unique identifier of a customer
	 */
	public void setCustomerReference(String value) {
		this.customerReference = value;
	}

	/**
	 * The unique identifier of a customer
	 */
	public CreateMandateRequest withCustomerReference(String value) {
		this.customerReference = value;
		return this;
	}

	/**
	 * The language code of the customer. ISO 639-1, possible values are:
	 * * de
	 * * en
	 * * es
	 * * fr
	 * * it
	 * * nl
	 * * si
	 * * sk
	 * * sv
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * The language code of the customer. ISO 639-1, possible values are:
	 * * de
	 * * en
	 * * es
	 * * fr
	 * * it
	 * * nl
	 * * si
	 * * sk
	 * * sv
	 */
	public void setLanguage(String value) {
		this.language = value;
	}

	/**
	 * The language code of the customer. ISO 639-1, possible values are:
	 * * de
	 * * en
	 * * es
	 * * fr
	 * * it
	 * * nl
	 * * si
	 * * sk
	 * * sv
	 */
	public CreateMandateRequest withLanguage(String value) {
		this.language = value;
		return this;
	}

	/**
	 * Specifies whether the mandate is for one-off or recurring payments. Possible values are:
	 * * UNIQUE
	 * * RECURRING
	 */
	public String getRecurrenceType() {
		return recurrenceType;
	}

	/**
	 * Specifies whether the mandate is for one-off or recurring payments. Possible values are:
	 * * UNIQUE
	 * * RECURRING
	 */
	public void setRecurrenceType(String value) {
		this.recurrenceType = value;
	}

	/**
	 * Specifies whether the mandate is for one-off or recurring payments. Possible values are:
	 * * UNIQUE
	 * * RECURRING
	 */
	public CreateMandateRequest withRecurrenceType(String value) {
		this.recurrenceType = value;
		return this;
	}

	/**
	 * Return URL to use if the mandate signing requires redirection. Required for S2S Create Payment if and only if the signatureType is "SMS".
	 */
	public String getReturnUrl() {
		return returnUrl;
	}

	/**
	 * Return URL to use if the mandate signing requires redirection. Required for S2S Create Payment if and only if the signatureType is "SMS".
	 */
	public void setReturnUrl(String value) {
		this.returnUrl = value;
	}

	/**
	 * Return URL to use if the mandate signing requires redirection. Required for S2S Create Payment if and only if the signatureType is "SMS".
	 */
	public CreateMandateRequest withReturnUrl(String value) {
		this.returnUrl = value;
		return this;
	}

	/**
	 * Specifies whether the mandate is tick box, unsigned or signed by SMS. Possible values are:
	 * * UNSIGNED
	 * * SMS
	 * * TICK_BOX - This option is only available for Equens Worldline
	 */
	public String getSignatureType() {
		return signatureType;
	}

	/**
	 * Specifies whether the mandate is tick box, unsigned or signed by SMS. Possible values are:
	 * * UNSIGNED
	 * * SMS
	 * * TICK_BOX - This option is only available for Equens Worldline
	 */
	public void setSignatureType(String value) {
		this.signatureType = value;
	}

	/**
	 * Specifies whether the mandate is tick box, unsigned or signed by SMS. Possible values are:
	 * * UNSIGNED
	 * * SMS
	 * * TICK_BOX - This option is only available for Equens Worldline
	 */
	public CreateMandateRequest withSignatureType(String value) {
		this.signatureType = value;
		return this;
	}

	/**
	 * The unique identifier of the mandate
	 */
	public String getUniqueMandateReference() {
		return uniqueMandateReference;
	}

	/**
	 * The unique identifier of the mandate
	 */
	public void setUniqueMandateReference(String value) {
		this.uniqueMandateReference = value;
	}

	/**
	 * The unique identifier of the mandate
	 */
	public CreateMandateRequest withUniqueMandateReference(String value) {
		this.uniqueMandateReference = value;
		return this;
	}
}
