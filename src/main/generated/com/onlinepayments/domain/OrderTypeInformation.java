/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object that holds the purchase and usage type indicators
 */
public class OrderTypeInformation {

	private String purchaseType = null;

	private String transactionType = null;

	/**
	 * Possible values are:
	 * * physical (tangible goods shipped to the customers)
	 * * digital (digital services like ebooks, streaming...)
	 */
	public String getPurchaseType() {
		return purchaseType;
	}

	/**
	 * Possible values are:
	 * * physical (tangible goods shipped to the customers)
	 * * digital (digital services like ebooks, streaming...)
	 */
	public void setPurchaseType(String value) {
		this.purchaseType = value;
	}

	/**
	 * Possible values are:
	 * * physical (tangible goods shipped to the customers)
	 * * digital (digital services like ebooks, streaming...)
	 */
	public OrderTypeInformation withPurchaseType(String value) {
		this.purchaseType = value;
		return this;
	}

	/**
	 * Identifies the type of transaction being authenticated. Possible values are:
	 * * purchase = The purpose of the transaction is to purchase goods or services (Default)
	 * * check-acceptance = The purpose of the transaction is to accept a 'check'/'cheque'
	 * * account-funding = The purpose of the transaction is to fund an account
	 * * quasi-cash = The purpose of the transaction is to buy a quasi cash type product that is representative of actual cash such as money orders, traveler's checks, foreign currency, lottery tickets or casino gaming chips
	 * * prepaid-activation-or-load = The purpose of the transaction is to activate or load a prepaid card
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * Identifies the type of transaction being authenticated. Possible values are:
	 * * purchase = The purpose of the transaction is to purchase goods or services (Default)
	 * * check-acceptance = The purpose of the transaction is to accept a 'check'/'cheque'
	 * * account-funding = The purpose of the transaction is to fund an account
	 * * quasi-cash = The purpose of the transaction is to buy a quasi cash type product that is representative of actual cash such as money orders, traveler's checks, foreign currency, lottery tickets or casino gaming chips
	 * * prepaid-activation-or-load = The purpose of the transaction is to activate or load a prepaid card
	 */
	public void setTransactionType(String value) {
		this.transactionType = value;
	}

	/**
	 * Identifies the type of transaction being authenticated. Possible values are:
	 * * purchase = The purpose of the transaction is to purchase goods or services (Default)
	 * * check-acceptance = The purpose of the transaction is to accept a 'check'/'cheque'
	 * * account-funding = The purpose of the transaction is to fund an account
	 * * quasi-cash = The purpose of the transaction is to buy a quasi cash type product that is representative of actual cash such as money orders, traveler's checks, foreign currency, lottery tickets or casino gaming chips
	 * * prepaid-activation-or-load = The purpose of the transaction is to activate or load a prepaid card
	 */
	public OrderTypeInformation withTransactionType(String value) {
		this.transactionType = value;
		return this;
	}
}
