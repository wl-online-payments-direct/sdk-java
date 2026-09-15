/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class PaymentProductGroup {

    private AccountOnFile accountOnFile;

    private PaymentProductDisplayHints displayHints;

    private List<PaymentProductDisplayHints> displayHintsList;

    private String id;

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
     * Deprecated: field is replaced by displayHintsList
     */
    public PaymentProductDisplayHints getDisplayHints() {
        return displayHints;
    }

    /**
     * Deprecated: field is replaced by displayHintsList
     */
    public void setDisplayHints(PaymentProductDisplayHints value) {
        this.displayHints = value;
    }

    /**
     * Deprecated: field is replaced by displayHintsList
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
