/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class BankAccountIban {

    private String iban;

    /**
     * The IBAN is the International Bank Account Number. It is an internationally agreed format for the BBAN and includes the ISO country code and two check digits.
     * Required for the creation of a Payout
     * Required for Create and Update token.
     * Required for Create mandate and Create payment with mandate calls.
     * It is optional when the mandate signature type is &quot;AIS&quot;; otherwise, it is mandatory.
     */
    public String getIban() {
        return iban;
    }

    /**
     * The IBAN is the International Bank Account Number. It is an internationally agreed format for the BBAN and includes the ISO country code and two check digits.
     * Required for the creation of a Payout
     * Required for Create and Update token.
     * Required for Create mandate and Create payment with mandate calls.
     * It is optional when the mandate signature type is &quot;AIS&quot;; otherwise, it is mandatory.
     */
    public void setIban(String value) {
        this.iban = value;
    }

    /**
     * The IBAN is the International Bank Account Number. It is an internationally agreed format for the BBAN and includes the ISO country code and two check digits.
     * Required for the creation of a Payout
     * Required for Create and Update token.
     * Required for Create mandate and Create payment with mandate calls.
     * It is optional when the mandate signature type is &quot;AIS&quot;; otherwise, it is mandatory.
     */
    public BankAccountIban withIban(String value) {
        this.iban = value;
        return this;
    }
}
