/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProduct3204SpecificOutput {

    private String bankingAppLabel;

    /**
     * The name given by the bank (the publisher of the mobile application) to identify the mobile account where the User will confirm the payment
     */
    public String getBankingAppLabel() {
        return bankingAppLabel;
    }

    /**
     * The name given by the bank (the publisher of the mobile application) to identify the mobile account where the User will confirm the payment
     */
    public void setBankingAppLabel(String value) {
        this.bankingAppLabel = value;
    }

    /**
     * The name given by the bank (the publisher of the mobile application) to identify the mobile account where the User will confirm the payment
     */
    public PaymentProduct3204SpecificOutput withBankingAppLabel(String value) {
        this.bankingAppLabel = value;
        return this;
    }
}
