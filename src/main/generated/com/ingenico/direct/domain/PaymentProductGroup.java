/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

public class PaymentProductGroup {

	private AccountOnFile accountOnFile = null;

	private PaymentProductDisplayHints displayHints = null;

	private String id = null;

	public AccountOnFile getAccountOnFile() {
		return accountOnFile;
	}

	public void setAccountOnFile(AccountOnFile value) {
		this.accountOnFile = value;
	}

	public PaymentProductGroup withAccountOnFile(AccountOnFile value) {
		this.accountOnFile = value;
		return this;
	}

	/**
	 * Object containing display hints like the order of the product when shown in a list, the name of the product and the logo
	 */
	public PaymentProductDisplayHints getDisplayHints() {
		return displayHints;
	}

	/**
	 * Object containing display hints like the order of the product when shown in a list, the name of the product and the logo
	 */
	public void setDisplayHints(PaymentProductDisplayHints value) {
		this.displayHints = value;
	}

	/**
	 * Object containing display hints like the order of the product when shown in a list, the name of the product and the logo
	 */
	public PaymentProductGroup withDisplayHints(PaymentProductDisplayHints value) {
		this.displayHints = value;
		return this;
	}

	/**
	 * The ID of the payment product group in our system
	 */
	public String getId() {
		return id;
	}

	/**
	 * The ID of the payment product group in our system
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * The ID of the payment product group in our system
	 */
	public PaymentProductGroup withId(String value) {
		this.id = value;
		return this;
	}
}
