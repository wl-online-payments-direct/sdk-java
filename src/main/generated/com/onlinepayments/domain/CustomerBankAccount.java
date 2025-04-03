/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CustomerBankAccount {

    private String accountHolderName;

    private String bic;

    private String iban;

    /**
     * Name of account holder
     */
    public String getAccountHolderName() {
        return accountHolderName;
    }

    /**
     * Name of account holder
     */
    public void setAccountHolderName(String value) {
        this.accountHolderName = value;
    }

    /**
     * Name of account holder
     */
    public CustomerBankAccount withAccountHolderName(String value) {
        this.accountHolderName = value;
        return this;
    }

    /**
     * Bank Identification Code
     */
    public String getBic() {
        return bic;
    }

    /**
     * Bank Identification Code
     */
    public void setBic(String value) {
        this.bic = value;
    }

    /**
     * Bank Identification Code
     */
    public CustomerBankAccount withBic(String value) {
        this.bic = value;
        return this;
    }

    /**
     * The IBAN is the International Bank Account Number. It is an internationally agreed format for the BBAN and includes the ISO country code and two check digits.
     */
    public String getIban() {
        return iban;
    }

    /**
     * The IBAN is the International Bank Account Number. It is an internationally agreed format for the BBAN and includes the ISO country code and two check digits.
     */
    public void setIban(String value) {
        this.iban = value;
    }

    /**
     * The IBAN is the International Bank Account Number. It is an internationally agreed format for the BBAN and includes the ISO country code and two check digits.
     */
    public CustomerBankAccount withIban(String value) {
        this.iban = value;
        return this;
    }
}
