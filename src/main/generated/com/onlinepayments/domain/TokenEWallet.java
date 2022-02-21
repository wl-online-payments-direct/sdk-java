/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing eWallet details
 */
public class TokenEWallet {

	private String alias = null;

	private CustomerToken customer = null;

	/**
	 * Deprecated: This field is not used by any payment product
	 * An alias for the token. This can be used to visually represent the token.
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * An alias for the token. This can be used to visually represent the token.
	 */
	public void setAlias(String value) {
		this.alias = value;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * An alias for the token. This can be used to visually represent the token.
	 */
	public TokenEWallet withAlias(String value) {
		this.alias = value;
		return this;
	}

	public CustomerToken getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerToken value) {
		this.customer = value;
	}

	public TokenEWallet withCustomer(CustomerToken value) {
		this.customer = value;
		return this;
	}
}
