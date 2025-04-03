/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class IINDetail {

    private String cardType;

    private Boolean isAllowedInContext;

    private Integer paymentProductId;

    /**
     * The card's type as categorised by the payment method. Possible values are:
     * <ul>
     *   <li>Credit</li>
     *   <li>Debit</li>
     *   <li>Prepaid</li>
     * </ul>
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * The card's type as categorised by the payment method. Possible values are:
     * <ul>
     *   <li>Credit</li>
     *   <li>Debit</li>
     *   <li>Prepaid</li>
     * </ul>
     */
    public void setCardType(String value) {
        this.cardType = value;
    }

    /**
     * The card's type as categorised by the payment method. Possible values are:
     * <ul>
     *   <li>Credit</li>
     *   <li>Debit</li>
     *   <li>Prepaid</li>
     * </ul>
     */
    public IINDetail withCardType(String value) {
        this.cardType = value;
        return this;
    }

    /**
     * Populated only if you submitted a payment context.
     * <ul>
     *   <li>true - The payment product is allowed in the submitted context.</li>
     *   <li>false - The payment product is not allowed in the submitted context. Note that in this case, none of the brands of the card will be allowed in the submitted context.</li>
     * </ul>
     */
    public Boolean getIsAllowedInContext() {
        return isAllowedInContext;
    }

    /**
     * Populated only if you submitted a payment context.
     * <ul>
     *   <li>true - The payment product is allowed in the submitted context.</li>
     *   <li>false - The payment product is not allowed in the submitted context. Note that in this case, none of the brands of the card will be allowed in the submitted context.</li>
     * </ul>
     */
    public void setIsAllowedInContext(Boolean value) {
        this.isAllowedInContext = value;
    }

    /**
     * Populated only if you submitted a payment context.
     * <ul>
     *   <li>true - The payment product is allowed in the submitted context.</li>
     *   <li>false - The payment product is not allowed in the submitted context. Note that in this case, none of the brands of the card will be allowed in the submitted context.</li>
     * </ul>
     */
    public IINDetail withIsAllowedInContext(Boolean value) {
        this.isAllowedInContext = value;
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
    public IINDetail withPaymentProductId(Integer value) {
        this.paymentProductId = value;
        return this;
    }
}
