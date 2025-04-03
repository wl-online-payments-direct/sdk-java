/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProductFieldDataRestrictions {

    private Boolean isRequired;

    private PaymentProductFieldValidators validators;

    /**
     * <ul>
     *   <li>true - Indicates that this field is required</li>
     *   <li>false - Indicates that this field is optional</li>
     * </ul>
     */
    public Boolean getIsRequired() {
        return isRequired;
    }

    /**
     * <ul>
     *   <li>true - Indicates that this field is required</li>
     *   <li>false - Indicates that this field is optional</li>
     * </ul>
     */
    public void setIsRequired(Boolean value) {
        this.isRequired = value;
    }

    /**
     * <ul>
     *   <li>true - Indicates that this field is required</li>
     *   <li>false - Indicates that this field is optional</li>
     * </ul>
     */
    public PaymentProductFieldDataRestrictions withIsRequired(Boolean value) {
        this.isRequired = value;
        return this;
    }

    /**
     * Object containing the details of the validations on the field
     */
    public PaymentProductFieldValidators getValidators() {
        return validators;
    }

    /**
     * Object containing the details of the validations on the field
     */
    public void setValidators(PaymentProductFieldValidators value) {
        this.validators = value;
    }

    /**
     * Object containing the details of the validations on the field
     */
    public PaymentProductFieldDataRestrictions withValidators(PaymentProductFieldValidators value) {
        this.validators = value;
        return this;
    }
}
