/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing data restrictions that apply to this field, like minimum and/or maximum length
 */
public class PaymentProductFieldDataRestrictions {

	private Boolean isRequired = null;

	private PaymentProductFieldValidators validators = null;

	/**
	 * * true - Indicates that this field is required
	 * * false - Indicates that this field is optional
	 */
	public Boolean getIsRequired() {
		return isRequired;
	}

	/**
	 * * true - Indicates that this field is required
	 * * false - Indicates that this field is optional
	 */
	public void setIsRequired(Boolean value) {
		this.isRequired = value;
	}

	/**
	 * * true - Indicates that this field is required
	 * * false - Indicates that this field is optional
	 */
	public PaymentProductFieldDataRestrictions withIsRequired(Boolean value) {
		this.isRequired = value;
		return this;
	}

	/**
	 * Object containing the details of the validations on the field
	 */
	public PaymentProductFieldValidators getValidators() {
		return validators;
	}

	/**
	 * Object containing the details of the validations on the field
	 */
	public void setValidators(PaymentProductFieldValidators value) {
		this.validators = value;
	}

	/**
	 * Object containing the details of the validations on the field
	 */
	public PaymentProductFieldDataRestrictions withValidators(PaymentProductFieldValidators value) {
		this.validators = value;
		return this;
	}
}
