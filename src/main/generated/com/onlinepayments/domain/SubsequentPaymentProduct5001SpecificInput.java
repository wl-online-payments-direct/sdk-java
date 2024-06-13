/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * specific data required for Bizum subsequent payment
 */
public class SubsequentPaymentProduct5001SpecificInput {

	private String subsequentType = null;

	/**
	 * Determines the type of the subsequent that will be used. Allowed values: 
	 *   * recurring - Transactions processed at fixed, regular intervals not to exceed one year between Transactions, representing an agreement between a consumer and a merchant to purchase goods or services provided over a period of time. Note that a recurring MIT transaction is initiated by the merchant (payee) not the customer (payer) and so is out of scope of PSD2. Recurring transactions that are in scope of PSD2 (and therefore may benefit from the recurring transaction exemption) are those that are customer (payer) initiates, e.g. standing orders set up from a bank account. 
	 *   * installment - Installment payments describe a single purchase of goods or services billed to a consumer in multiple transactions over a period of time agreed by the consumer and merchant. 
	 *   * other - other cases
	 */
	public String getSubsequentType() {
		return subsequentType;
	}

	/**
	 * Determines the type of the subsequent that will be used. Allowed values: 
	 *   * recurring - Transactions processed at fixed, regular intervals not to exceed one year between Transactions, representing an agreement between a consumer and a merchant to purchase goods or services provided over a period of time. Note that a recurring MIT transaction is initiated by the merchant (payee) not the customer (payer) and so is out of scope of PSD2. Recurring transactions that are in scope of PSD2 (and therefore may benefit from the recurring transaction exemption) are those that are customer (payer) initiates, e.g. standing orders set up from a bank account. 
	 *   * installment - Installment payments describe a single purchase of goods or services billed to a consumer in multiple transactions over a period of time agreed by the consumer and merchant. 
	 *   * other - other cases
	 */
	public void setSubsequentType(String value) {
		this.subsequentType = value;
	}

	/**
	 * Determines the type of the subsequent that will be used. Allowed values: 
	 *   * recurring - Transactions processed at fixed, regular intervals not to exceed one year between Transactions, representing an agreement between a consumer and a merchant to purchase goods or services provided over a period of time. Note that a recurring MIT transaction is initiated by the merchant (payee) not the customer (payer) and so is out of scope of PSD2. Recurring transactions that are in scope of PSD2 (and therefore may benefit from the recurring transaction exemption) are those that are customer (payer) initiates, e.g. standing orders set up from a bank account. 
	 *   * installment - Installment payments describe a single purchase of goods or services billed to a consumer in multiple transactions over a period of time agreed by the consumer and merchant. 
	 *   * other - other cases
	 */
	public SubsequentPaymentProduct5001SpecificInput withSubsequentType(String value) {
		this.subsequentType = value;
		return this;
	}
}
