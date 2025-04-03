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
     * Descriptive text that is used towards to customer, either during an online checkout at a third party and/or on the statement of the customer. For card transactions this is usually referred to as a Soft Descriptor. The maximum allowed length varies per card acquirer:
     * <ul>
     *   <li>AIB - 22 characters</li>
     *   <li>American Express - 25 characters</li>
     *   <li>Atos Origin BNP - 15 characters</li>
     *   <li>Barclays - 25 characters</li>
     *   <li>Catella - 22 characters</li>
     *   <li>CBA - 20 characters</li>
     *   <li>Elavon - 25 characters</li>
     *   <li>First Data - 25 characters</li>
     *   <li>INICIS (INIPAY) - 22-30 characters</li>
     *   <li>JCB - 25 characters</li>
     *   <li>Merchant Solutions - 22-25 characters</li>
     *   <li>Payvision (EU &amp; HK) - 25 characters</li>
     *   <li>SEB Euroline - 22 characters</li>
     *   <li>Sub1 Argentina - 15 characters</li>
     *   <li>Wells Fargo - 25 characters
     * Note that we advise you to use 22 characters as the max length as beyond this our experience is that issuers will start to truncate. We currently also only allow per API call overrides for AIB and Barclays
     * For alternative payment products the maximum allowed length varies per payment product:</li>
     *   <li>402 e-Przelewy - 30 characters</li>
     *   <li>404 INICIS - 80 characters</li>
     *   <li>802 Nordea ePayment Finland - 234 characters</li>
     *   <li>809 iDeal - 32 characters</li>
     *   <li>836 SOFORT - 42 characters</li>
     *   <li>840 PayPal - 127 characters</li>
     *   <li>841 WebMoney - 175 characters</li>
     *   <li>849 Yandex - 64 characters</li>
     *   <li>861 Alipay - 256 characters</li>
     *   <li>863 WeChat Pay - 32 characters</li>
     *   <li>880 BOKU - 20 characters</li>
     *   <li>8580 Qiwi - 255 characters</li>
     *   <li>1504 Konbini - 80 characters
     * All other payment products do not support a descriptor.</li>
     * </ul>
     */
    public String getDescriptor() {
        return descriptor;
    }

    /**
     * Descriptive text that is used towards to customer, either during an online checkout at a third party and/or on the statement of the customer. For card transactions this is usually referred to as a Soft Descriptor. The maximum allowed length varies per card acquirer:
     * <ul>
     *   <li>AIB - 22 characters</li>
     *   <li>American Express - 25 characters</li>
     *   <li>Atos Origin BNP - 15 characters</li>
     *   <li>Barclays - 25 characters</li>
     *   <li>Catella - 22 characters</li>
     *   <li>CBA - 20 characters</li>
     *   <li>Elavon - 25 characters</li>
     *   <li>First Data - 25 characters</li>
     *   <li>INICIS (INIPAY) - 22-30 characters</li>
     *   <li>JCB - 25 characters</li>
     *   <li>Merchant Solutions - 22-25 characters</li>
     *   <li>Payvision (EU &amp; HK) - 25 characters</li>
     *   <li>SEB Euroline - 22 characters</li>
     *   <li>Sub1 Argentina - 15 characters</li>
     *   <li>Wells Fargo - 25 characters
     * Note that we advise you to use 22 characters as the max length as beyond this our experience is that issuers will start to truncate. We currently also only allow per API call overrides for AIB and Barclays
     * For alternative payment products the maximum allowed length varies per payment product:</li>
     *   <li>402 e-Przelewy - 30 characters</li>
     *   <li>404 INICIS - 80 characters</li>
     *   <li>802 Nordea ePayment Finland - 234 characters</li>
     *   <li>809 iDeal - 32 characters</li>
     *   <li>836 SOFORT - 42 characters</li>
     *   <li>840 PayPal - 127 characters</li>
     *   <li>841 WebMoney - 175 characters</li>
     *   <li>849 Yandex - 64 characters</li>
     *   <li>861 Alipay - 256 characters</li>
     *   <li>863 WeChat Pay - 32 characters</li>
     *   <li>880 BOKU - 20 characters</li>
     *   <li>8580 Qiwi - 255 characters</li>
     *   <li>1504 Konbini - 80 characters
     * All other payment products do not support a descriptor.</li>
     * </ul>
     */
    public void setDescriptor(String value) {
        this.descriptor = value;
    }

    /**
     * Descriptive text that is used towards to customer, either during an online checkout at a third party and/or on the statement of the customer. For card transactions this is usually referred to as a Soft Descriptor. The maximum allowed length varies per card acquirer:
     * <ul>
     *   <li>AIB - 22 characters</li>
     *   <li>American Express - 25 characters</li>
     *   <li>Atos Origin BNP - 15 characters</li>
     *   <li>Barclays - 25 characters</li>
     *   <li>Catella - 22 characters</li>
     *   <li>CBA - 20 characters</li>
     *   <li>Elavon - 25 characters</li>
     *   <li>First Data - 25 characters</li>
     *   <li>INICIS (INIPAY) - 22-30 characters</li>
     *   <li>JCB - 25 characters</li>
     *   <li>Merchant Solutions - 22-25 characters</li>
     *   <li>Payvision (EU &amp; HK) - 25 characters</li>
     *   <li>SEB Euroline - 22 characters</li>
     *   <li>Sub1 Argentina - 15 characters</li>
     *   <li>Wells Fargo - 25 characters
     * Note that we advise you to use 22 characters as the max length as beyond this our experience is that issuers will start to truncate. We currently also only allow per API call overrides for AIB and Barclays
     * For alternative payment products the maximum allowed length varies per payment product:</li>
     *   <li>402 e-Przelewy - 30 characters</li>
     *   <li>404 INICIS - 80 characters</li>
     *   <li>802 Nordea ePayment Finland - 234 characters</li>
     *   <li>809 iDeal - 32 characters</li>
     *   <li>836 SOFORT - 42 characters</li>
     *   <li>840 PayPal - 127 characters</li>
     *   <li>841 WebMoney - 175 characters</li>
     *   <li>849 Yandex - 64 characters</li>
     *   <li>861 Alipay - 256 characters</li>
     *   <li>863 WeChat Pay - 32 characters</li>
     *   <li>880 BOKU - 20 characters</li>
     *   <li>8580 Qiwi - 255 characters</li>
     *   <li>1504 Konbini - 80 characters
     * All other payment products do not support a descriptor.</li>
     * </ul>
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
     * Object containing the additional payout details for a Omnichannel merchants
     */
    public OmnichannelPayoutSpecificInput getOmnichannelPayoutSpecificInput() {
        return omnichannelPayoutSpecificInput;
    }

    /**
     * Object containing the additional payout details for a Omnichannel merchants
     */
    public void setOmnichannelPayoutSpecificInput(OmnichannelPayoutSpecificInput value) {
        this.omnichannelPayoutSpecificInput = value;
    }

    /**
     * Object containing the additional payout details for a Omnichannel merchants
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
