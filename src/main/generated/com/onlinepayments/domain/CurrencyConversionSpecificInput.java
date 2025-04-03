/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CurrencyConversionSpecificInput {

    private Boolean dccEnabled;

    /**
     * Indicates if this transaction is Dynamic Currency Conversion (DCC) enabled.
     * <ul>
     *   <li>true - Dynamic Currency Conversion (DCC) is enabled in this transaction.</li>
     *   <li>false - Dynamic Currency Conversion (DCC) is disabled in this transaction. The default value for this property is false.</li>
     * </ul>
     */
    public Boolean getDccEnabled() {
        return dccEnabled;
    }

    /**
     * Indicates if this transaction is Dynamic Currency Conversion (DCC) enabled.
     * <ul>
     *   <li>true - Dynamic Currency Conversion (DCC) is enabled in this transaction.</li>
     *   <li>false - Dynamic Currency Conversion (DCC) is disabled in this transaction. The default value for this property is false.</li>
     * </ul>
     */
    public void setDccEnabled(Boolean value) {
        this.dccEnabled = value;
    }

    /**
     * Indicates if this transaction is Dynamic Currency Conversion (DCC) enabled.
     * <ul>
     *   <li>true - Dynamic Currency Conversion (DCC) is enabled in this transaction.</li>
     *   <li>false - Dynamic Currency Conversion (DCC) is disabled in this transaction. The default value for this property is false.</li>
     * </ul>
     */
    public CurrencyConversionSpecificInput withDccEnabled(Boolean value) {
        this.dccEnabled = value;
        return this;
    }
}
