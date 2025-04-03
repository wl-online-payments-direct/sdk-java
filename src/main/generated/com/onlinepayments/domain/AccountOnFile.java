/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class AccountOnFile {

    private List<AccountOnFileAttribute> attributes;

    private AccountOnFileDisplayHints displayHints;

    private Integer id;

    private Integer paymentProductId;

    public List<AccountOnFileAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AccountOnFileAttribute> value) {
        this.attributes = value;
    }

    public AccountOnFile withAttributes(List<AccountOnFileAttribute> value) {
        this.attributes = value;
        return this;
    }

    /**
     * Object containing information for the client on how best to display this field
     */
    public AccountOnFileDisplayHints getDisplayHints() {
        return displayHints;
    }

    /**
     * Object containing information for the client on how best to display this field
     */
    public void setDisplayHints(AccountOnFileDisplayHints value) {
        this.displayHints = value;
    }

    /**
     * Object containing information for the client on how best to display this field
     */
    public AccountOnFile withDisplayHints(AccountOnFileDisplayHints value) {
        this.displayHints = value;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    public AccountOnFile withId(Integer value) {
        this.id = value;
        return this;
    }

    /**
     * Payment product identifier - Please see Products documentation for a full overview of possible values.
     */
    public Integer getPaymentProductId() {
        return paymentProductId;
    }

    /**
     * Payment product identifier - Please see Products documentation for a full overview of possible values.
     */
    public void setPaymentProductId(Integer value) {
        this.paymentProductId = value;
    }

    /**
     * Payment product identifier - Please see Products documentation for a full overview of possible values.
     */
    public AccountOnFile withPaymentProductId(Integer value) {
        this.paymentProductId = value;
        return this;
    }
}
