/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing the created mandate.
 */
public class MandateResponse {

	private String alias = null;

	private MandateCustomer customer = null;

	private String customerReference = null;

	private String recurrenceType = null;

	private String status = null;

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
	public MandateResponse withAlias(String value) {
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
	public MandateResponse withCustomer(MandateCustomer value) {
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
	public MandateResponse withCustomerReference(String value) {
		this.customerReference = value;
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
	public MandateResponse withRecurrenceType(String value) {
		this.recurrenceType = value;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String value) {
		this.status = value;
	}

	public MandateResponse withStatus(String value) {
		this.status = value;
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
	public MandateResponse withUniqueMandateReference(String value) {
		this.uniqueMandateReference = value;
		return this;
	}
}
