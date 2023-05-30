/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing specific input required for Dynamic Currency Conversion.
 */
public class CurrencyConversionSpecificInput {

	private Boolean dccEnabled = null;

	/**
	 * Indicates if this transaction is Dynamic Currency Conversion (DCC) enabled.
	 * * true - Dynamic Currency Conversion (DCC) is enabled in this transaction.
	 * * false - Dynamic Currency Conversion (DCC) is disabled in this transaction. The default value for this property is false.
	 */
	public Boolean getDccEnabled() {
		return dccEnabled;
	}

	/**
	 * Indicates if this transaction is Dynamic Currency Conversion (DCC) enabled.
	 * * true - Dynamic Currency Conversion (DCC) is enabled in this transaction.
	 * * false - Dynamic Currency Conversion (DCC) is disabled in this transaction. The default value for this property is false.
	 */
	public void setDccEnabled(Boolean value) {
		this.dccEnabled = value;
	}

	/**
	 * Indicates if this transaction is Dynamic Currency Conversion (DCC) enabled.
	 * * true - Dynamic Currency Conversion (DCC) is enabled in this transaction.
	 * * false - Dynamic Currency Conversion (DCC) is disabled in this transaction. The default value for this property is false.
	 */
	public CurrencyConversionSpecificInput withDccEnabled(Boolean value) {
		this.dccEnabled = value;
		return this;
	}
}
