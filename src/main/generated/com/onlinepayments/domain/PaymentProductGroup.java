/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

import java.util.List;

public class PaymentProductGroup {

	private AccountOnFile accountOnFile = null;

	private PaymentProductDisplayHints displayHints = null;

	private List<PaymentProductDisplayHints> displayHintsList = null;

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
	 * List of display hints
	 */
	public List<PaymentProductDisplayHints> getDisplayHintsList() {
		return displayHintsList;
	}

	/**
	 * List of display hints
	 */
	public void setDisplayHintsList(List<PaymentProductDisplayHints> value) {
		this.displayHintsList = value;
	}

	/**
	 * List of display hints
	 */
	public PaymentProductGroup withDisplayHintsList(List<PaymentProductDisplayHints> value) {
		this.displayHintsList = value;
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
