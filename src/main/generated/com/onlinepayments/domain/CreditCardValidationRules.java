/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CreditCardValidationRules {

    private Boolean cvvMandatoryForExistingToken;

    private Boolean cvvMandatoryForNewToken;

    /**
     * Determines whether the Card Verification Value must be provided for existing tokens. This option overrides the payment method configuration for the session.
     */
    public Boolean getCvvMandatoryForExistingToken() {
        return cvvMandatoryForExistingToken;
    }

    /**
     * Determines whether the Card Verification Value must be provided for existing tokens. This option overrides the payment method configuration for the session.
     */
    public void setCvvMandatoryForExistingToken(Boolean value) {
        this.cvvMandatoryForExistingToken = value;
    }

    /**
     * Determines whether the Card Verification Value must be provided for existing tokens. This option overrides the payment method configuration for the session.
     */
    public CreditCardValidationRules withCvvMandatoryForExistingToken(Boolean value) {
        this.cvvMandatoryForExistingToken = value;
        return this;
    }

    /**
     * Determines whether the Card Verification Value must be provided for new tokens. This option overrides the payment method configuration for the session.
     */
    public Boolean getCvvMandatoryForNewToken() {
        return cvvMandatoryForNewToken;
    }

    /**
     * Determines whether the Card Verification Value must be provided for new tokens. This option overrides the payment method configuration for the session.
     */
    public void setCvvMandatoryForNewToken(Boolean value) {
        this.cvvMandatoryForNewToken = value;
    }

    /**
     * Determines whether the Card Verification Value must be provided for new tokens. This option overrides the payment method configuration for the session.
     */
    public CreditCardValidationRules withCvvMandatoryForNewToken(Boolean value) {
        this.cvvMandatoryForNewToken = value;
        return this;
    }
}
