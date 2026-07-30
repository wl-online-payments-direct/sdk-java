/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CreatePayoutRequest {

    private AmountOfMoney amountOfMoney;

    private CardPayoutMethodSpecificInput cardPayoutMethodSpecificInput;

    private String descriptor;

    private Feedbacks feedbacks;

    private OmnichannelPayoutSpecificInput omnichannelPayoutSpecificInput;

    private PaymentReferences references;

    /**
     * Object containing amount and ISO currency code attributes
     */
    public AmountOfMoney getAmountOfMoney() {
        return amountOfMoney;
    }

    /**
     * Object containing amount and ISO currency code attributes
     */
    public void setAmountOfMoney(AmountOfMoney value) {
        this.amountOfMoney = value;
    }

    /**
     * Object containing amount and ISO currency code attributes
     */
    public CreatePayoutRequest withAmountOfMoney(AmountOfMoney value) {
        this.amountOfMoney = value;
        return this;
    }

    /**
     * Object containing the payout details for a card
     */
    public CardPayoutMethodSpecificInput getCardPayoutMethodSpecificInput() {
        return cardPayoutMethodSpecificInput;
    }

    /**
     * Object containing the payout details for a card
     */
    public void setCardPayoutMethodSpecificInput(CardPayoutMethodSpecificInput value) {
        this.cardPayoutMethodSpecificInput = value;
    }

    /**
     * Object containing the payout details for a card
     */
    public CreatePayoutRequest withCardPayoutMethodSpecificInput(CardPayoutMethodSpecificInput value) {
        this.cardPayoutMethodSpecificInput = value;
        return this;
    }

    /**
     * <b>Deprecated</b>: It is recommended to use the new merchantReconciliationReference for the same usage, and the new softDescriptor on top only in case you start needing another specific value to be pushed to the cardholder statement.
     */
    public String getDescriptor() {
        return descriptor;
    }

    /**
     * <b>Deprecated</b>: It is recommended to use the new merchantReconciliationReference for the same usage, and the new softDescriptor on top only in case you start needing another specific value to be pushed to the cardholder statement.
     */
    public void setDescriptor(String value) {
        this.descriptor = value;
    }

    /**
     * <b>Deprecated</b>: It is recommended to use the new merchantReconciliationReference for the same usage, and the new softDescriptor on top only in case you start needing another specific value to be pushed to the cardholder statement.
     */
    public CreatePayoutRequest withDescriptor(String value) {
        this.descriptor = value;
        return this;
    }

    /**
     * This section will contain feedback Urls to provide feedback on the payment.
     */
    public Feedbacks getFeedbacks() {
        return feedbacks;
    }

    /**
     * This section will contain feedback Urls to provide feedback on the payment.
     */
    public void setFeedbacks(Feedbacks value) {
        this.feedbacks = value;
    }

    /**
     * This section will contain feedback Urls to provide feedback on the payment.
     */
    public CreatePayoutRequest withFeedbacks(Feedbacks value) {
        this.feedbacks = value;
        return this;
    }

    /**
     * Object containing the additional payout details for an Omnichannel merchant
     */
    public OmnichannelPayoutSpecificInput getOmnichannelPayoutSpecificInput() {
        return omnichannelPayoutSpecificInput;
    }

    /**
     * Object containing the additional payout details for an Omnichannel merchant
     */
    public void setOmnichannelPayoutSpecificInput(OmnichannelPayoutSpecificInput value) {
        this.omnichannelPayoutSpecificInput = value;
    }

    /**
     * Object containing the additional payout details for an Omnichannel merchant
     */
    public CreatePayoutRequest withOmnichannelPayoutSpecificInput(OmnichannelPayoutSpecificInput value) {
        this.omnichannelPayoutSpecificInput = value;
        return this;
    }

    /**
     * Object that holds all reference properties that are linked to this transaction. <b>Deprecated for capture/refund</b>: Use operationReferences instead.
     */
    public PaymentReferences getReferences() {
        return references;
    }

    /**
     * Object that holds all reference properties that are linked to this transaction. <b>Deprecated for capture/refund</b>: Use operationReferences instead.
     */
    public void setReferences(PaymentReferences value) {
        this.references = value;
    }

    /**
     * Object that holds all reference properties that are linked to this transaction. <b>Deprecated for capture/refund</b>: Use operationReferences instead.
     */
    public CreatePayoutRequest withReferences(PaymentReferences value) {
        this.references = value;
        return this;
    }
}
