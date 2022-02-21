/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class PaymentProductField {

	private PaymentProductFieldDataRestrictions dataRestrictions = null;

	private PaymentProductFieldDisplayHints displayHints = null;

	private String id = null;

	private String type = null;

	/**
	 * Object containing data restrictions that apply to this field, like minimum and/or maximum length
	 */
	public PaymentProductFieldDataRestrictions getDataRestrictions() {
		return dataRestrictions;
	}

	/**
	 * Object containing data restrictions that apply to this field, like minimum and/or maximum length
	 */
	public void setDataRestrictions(PaymentProductFieldDataRestrictions value) {
		this.dataRestrictions = value;
	}

	/**
	 * Object containing data restrictions that apply to this field, like minimum and/or maximum length
	 */
	public PaymentProductField withDataRestrictions(PaymentProductFieldDataRestrictions value) {
		this.dataRestrictions = value;
		return this;
	}

	/**
	 * Object containing display hints for this field, like the order, mask, preferred keyboard
	 */
	public PaymentProductFieldDisplayHints getDisplayHints() {
		return displayHints;
	}

	/**
	 * Object containing display hints for this field, like the order, mask, preferred keyboard
	 */
	public void setDisplayHints(PaymentProductFieldDisplayHints value) {
		this.displayHints = value;
	}

	/**
	 * Object containing display hints for this field, like the order, mask, preferred keyboard
	 */
	public PaymentProductField withDisplayHints(PaymentProductFieldDisplayHints value) {
		this.displayHints = value;
		return this;
	}

	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

	public PaymentProductField withId(String value) {
		this.id = value;
		return this;
	}

	public String getType() {
		return type;
	}

	public void setType(String value) {
		this.type = value;
	}

	public PaymentProductField withType(String value) {
		this.type = value;
		return this;
	}
}
