/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class CreditCardSpecificInputHostedTokenization {

    private CreditCardValidationRules ValidationRules;

    private List<Integer> paymentProductPreferredOrder;

    /**
     * Object containing specific validation rules for creditCard.
     */
    public CreditCardValidationRules getValidationRules() {
        return ValidationRules;
    }

    /**
     * Object containing specific validation rules for creditCard.
     */
    public void setValidationRules(CreditCardValidationRules value) {
        this.ValidationRules = value;
    }

    /**
     * Object containing specific validation rules for creditCard.
     */
    public CreditCardSpecificInputHostedTokenization withValidationRules(CreditCardValidationRules value) {
        this.ValidationRules = value;
        return this;
    }

    /**
     * This array contains the payment product identifiers representing the brands. For co-badged cards, this displays their available brands in the order defined by this array.
     */
    public List<Integer> getPaymentProductPreferredOrder() {
        return paymentProductPreferredOrder;
    }

    /**
     * This array contains the payment product identifiers representing the brands. For co-badged cards, this displays their available brands in the order defined by this array.
     */
    public void setPaymentProductPreferredOrder(List<Integer> value) {
        this.paymentProductPreferredOrder = value;
    }

    /**
     * This array contains the payment product identifiers representing the brands. For co-badged cards, this displays their available brands in the order defined by this array.
     */
    public CreditCardSpecificInputHostedTokenization withPaymentProductPreferredOrder(List<Integer> value) {
        this.paymentProductPreferredOrder = value;
        return this;
    }
}
