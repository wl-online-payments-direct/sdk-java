/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class CreditCardSpecificInputHostedTokenization {

    private CreditCardValidationRulesHostedTokenization ValidationRules;

    private List<Integer> paymentProductPreferredOrder;

    public CreditCardValidationRulesHostedTokenization getValidationRules() {
        return ValidationRules;
    }

    public void setValidationRules(CreditCardValidationRulesHostedTokenization value) {
        this.ValidationRules = value;
    }

    public CreditCardSpecificInputHostedTokenization withValidationRules(CreditCardValidationRulesHostedTokenization value) {
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
