/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CrmToken {

    private String uniqueAccountIdentifier;

    private String uniqueCardIdentifier;

    /**
     * A unique identifier that remains constant across different formats of the same card (whether used via wallets such as Apple Pay, Google Pay, etc., or the physical card), even if the tokenID may differ. The unique account identifier cannot be used to trigger a payment.
     */
    public String getUniqueAccountIdentifier() {
        return uniqueAccountIdentifier;
    }

    /**
     * A unique identifier that remains constant across different formats of the same card (whether used via wallets such as Apple Pay, Google Pay, etc., or the physical card), even if the tokenID may differ. The unique account identifier cannot be used to trigger a payment.
     */
    public void setUniqueAccountIdentifier(String value) {
        this.uniqueAccountIdentifier = value;
    }

    /**
     * A unique identifier that remains constant across different formats of the same card (whether used via wallets such as Apple Pay, Google Pay, etc., or the physical card), even if the tokenID may differ. The unique account identifier cannot be used to trigger a payment.
     */
    public CrmToken withUniqueAccountIdentifier(String value) {
        this.uniqueAccountIdentifier = value;
        return this;
    }

    /**
     * A unique identifier for the card that was tokenized. This identifier remains the same for a given card, even if the tokenID may differ. The unique card identifier cannot be used to trigger a payment.
     */
    public String getUniqueCardIdentifier() {
        return uniqueCardIdentifier;
    }

    /**
     * A unique identifier for the card that was tokenized. This identifier remains the same for a given card, even if the tokenID may differ. The unique card identifier cannot be used to trigger a payment.
     */
    public void setUniqueCardIdentifier(String value) {
        this.uniqueCardIdentifier = value;
    }

    /**
     * A unique identifier for the card that was tokenized. This identifier remains the same for a given card, even if the tokenID may differ. The unique card identifier cannot be used to trigger a payment.
     */
    public CrmToken withUniqueCardIdentifier(String value) {
        this.uniqueCardIdentifier = value;
        return this;
    }
}
