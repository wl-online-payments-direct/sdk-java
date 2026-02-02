/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CardPayoutMethodSpecificInput {

    private Card card;

    private Integer paymentProductId;

    private String payoutReason;

    private String token;

    /**
     * Object containing card details
     */
    public Card getCard() {
        return card;
    }

    /**
     * Object containing card details
     */
    public void setCard(Card value) {
        this.card = value;
    }

    /**
     * Object containing card details
     */
    public CardPayoutMethodSpecificInput withCard(Card value) {
        this.card = value;
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
    public CardPayoutMethodSpecificInput withPaymentProductId(Integer value) {
        this.paymentProductId = value;
        return this;
    }

    /**
     * Allows you to additionally specify the reason for initiating the payout for authorization purposes. If this field is not specified, authorization of the payment will be made according to your merchant profile. Possible values are:
     * <ul>
     *   <li>Gambling</li>
     *   <li>Refund</li>
     *   <li>Loyalty</li>
     * </ul>
     */
    public String getPayoutReason() {
        return payoutReason;
    }

    /**
     * Allows you to additionally specify the reason for initiating the payout for authorization purposes. If this field is not specified, authorization of the payment will be made according to your merchant profile. Possible values are:
     * <ul>
     *   <li>Gambling</li>
     *   <li>Refund</li>
     *   <li>Loyalty</li>
     * </ul>
     */
    public void setPayoutReason(String value) {
        this.payoutReason = value;
    }

    /**
     * Allows you to additionally specify the reason for initiating the payout for authorization purposes. If this field is not specified, authorization of the payment will be made according to your merchant profile. Possible values are:
     * <ul>
     *   <li>Gambling</li>
     *   <li>Refund</li>
     *   <li>Loyalty</li>
     * </ul>
     */
    public CardPayoutMethodSpecificInput withPayoutReason(String value) {
        this.payoutReason = value;
        return this;
    }

    /**
     * ID of the token
     */
    public String getToken() {
        return token;
    }

    /**
     * ID of the token
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * ID of the token
     */
    public CardPayoutMethodSpecificInput withToken(String value) {
        this.token = value;
        return this;
    }
}
