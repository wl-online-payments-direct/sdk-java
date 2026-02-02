/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CardPaymentMethodSpecificInputBase {

    private Boolean allowDynamicLinking;

    private String authorizationMode;

    private CurrencyConversionSpecificInput currencyConversionSpecificInput;

    private String initialSchemeTransactionId;

    private MarketPlace marketPlace;

    private MultiplePaymentInformation multiplePaymentInformation;

    private PaymentProduct130SpecificInput paymentProduct130SpecificInput;

    private PaymentProduct3012SpecificInput paymentProduct3012SpecificInput;

    private PaymentProduct3013SpecificInput paymentProduct3013SpecificInput;

    private PaymentProduct3208SpecificInput paymentProduct3208SpecificInput;

    private PaymentProduct3209SpecificInput paymentProduct3209SpecificInput;

    private PaymentProduct5100SpecificInput paymentProduct5100SpecificInput;

    private Integer paymentProductId;

    private CardRecurrenceDetails recurring;

    private ThreeDSecureBase threeDSecure;

    private String token;

    private Boolean tokenize;

    private String transactionChannel;

    private String unscheduledCardOnFileRequestor;

    private String unscheduledCardOnFileSequenceIndicator;

    /**
     * <ul>
     *   <li>true - Default - Allows subsequent payments to use PSD2 dynamic linking from this payment (including Card On File).</li>
     *   <li>false - Indicates that the dynamic linking (including Card On File data) will be ignored.</li>
     * </ul>
     */
    public Boolean getAllowDynamicLinking() {
        return allowDynamicLinking;
    }

    /**
     * <ul>
     *   <li>true - Default - Allows subsequent payments to use PSD2 dynamic linking from this payment (including Card On File).</li>
     *   <li>false - Indicates that the dynamic linking (including Card On File data) will be ignored.</li>
     * </ul>
     */
    public void setAllowDynamicLinking(Boolean value) {
        this.allowDynamicLinking = value;
    }

    /**
     * <ul>
     *   <li>true - Default - Allows subsequent payments to use PSD2 dynamic linking from this payment (including Card On File).</li>
     *   <li>false - Indicates that the dynamic linking (including Card On File data) will be ignored.</li>
     * </ul>
     */
    public CardPaymentMethodSpecificInputBase withAllowDynamicLinking(Boolean value) {
        this.allowDynamicLinking = value;
        return this;
    }

    /**
     * Determines the type of the authorization that will be used. Allowed values:
     * <ul>
     *   <li>FINAL_AUTHORIZATION - The payment creation results in an authorization that is ready for capture. Final authorizations can't be reversed and need to be captured for the full amount within 7 days.</li>
     *   <li>PRE_AUTHORIZATION - The payment creation results in a pre-authorization that is ready for capture. Pre-authortizations can be reversed and can be captured within 30 days. The capture amount can be lower than the authorized amount.</li>
     *   <li>SALE - The payment creation results in an authorization that is already captured at the moment of approval.</li>
     * </ul>
     * <p>
     * Only used with some acquirers, ignored for acquirers that do not support this. In case the acquirer does not allow this to be specified the authorizationMode is 'unspecified', which behaves similar to a final authorization.
     */
    public String getAuthorizationMode() {
        return authorizationMode;
    }

    /**
     * Determines the type of the authorization that will be used. Allowed values:
     * <ul>
     *   <li>FINAL_AUTHORIZATION - The payment creation results in an authorization that is ready for capture. Final authorizations can't be reversed and need to be captured for the full amount within 7 days.</li>
     *   <li>PRE_AUTHORIZATION - The payment creation results in a pre-authorization that is ready for capture. Pre-authortizations can be reversed and can be captured within 30 days. The capture amount can be lower than the authorized amount.</li>
     *   <li>SALE - The payment creation results in an authorization that is already captured at the moment of approval.</li>
     * </ul>
     * <p>
     * Only used with some acquirers, ignored for acquirers that do not support this. In case the acquirer does not allow this to be specified the authorizationMode is 'unspecified', which behaves similar to a final authorization.
     */
    public void setAuthorizationMode(String value) {
        this.authorizationMode = value;
    }

    /**
     * Determines the type of the authorization that will be used. Allowed values:
     * <ul>
     *   <li>FINAL_AUTHORIZATION - The payment creation results in an authorization that is ready for capture. Final authorizations can't be reversed and need to be captured for the full amount within 7 days.</li>
     *   <li>PRE_AUTHORIZATION - The payment creation results in a pre-authorization that is ready for capture. Pre-authortizations can be reversed and can be captured within 30 days. The capture amount can be lower than the authorized amount.</li>
     *   <li>SALE - The payment creation results in an authorization that is already captured at the moment of approval.</li>
     * </ul>
     * <p>
     * Only used with some acquirers, ignored for acquirers that do not support this. In case the acquirer does not allow this to be specified the authorizationMode is 'unspecified', which behaves similar to a final authorization.
     */
    public CardPaymentMethodSpecificInputBase withAuthorizationMode(String value) {
        this.authorizationMode = value;
        return this;
    }

    /**
     * Object containing specific input required for Dynamic Currency Conversion.
     */
    public CurrencyConversionSpecificInput getCurrencyConversionSpecificInput() {
        return currencyConversionSpecificInput;
    }

    /**
     * Object containing specific input required for Dynamic Currency Conversion.
     */
    public void setCurrencyConversionSpecificInput(CurrencyConversionSpecificInput value) {
        this.currencyConversionSpecificInput = value;
    }

    /**
     * Object containing specific input required for Dynamic Currency Conversion.
     */
    public CardPaymentMethodSpecificInputBase withCurrencyConversionSpecificInput(CurrencyConversionSpecificInput value) {
        this.currencyConversionSpecificInput = value;
        return this;
    }

    /**
     * The unique scheme transactionId of the initial transaction that was performed with SCA. In case this is unknown a scheme transactionId of an earlier transaction part of the same sequence can be used as a fall-back. Strongly advised to be submitted for any MerchantInitiated or recurring transaction (a subsequent one).
     */
    public String getInitialSchemeTransactionId() {
        return initialSchemeTransactionId;
    }

    /**
     * The unique scheme transactionId of the initial transaction that was performed with SCA. In case this is unknown a scheme transactionId of an earlier transaction part of the same sequence can be used as a fall-back. Strongly advised to be submitted for any MerchantInitiated or recurring transaction (a subsequent one).
     */
    public void setInitialSchemeTransactionId(String value) {
        this.initialSchemeTransactionId = value;
    }

    /**
     * The unique scheme transactionId of the initial transaction that was performed with SCA. In case this is unknown a scheme transactionId of an earlier transaction part of the same sequence can be used as a fall-back. Strongly advised to be submitted for any MerchantInitiated or recurring transaction (a subsequent one).
     */
    public CardPaymentMethodSpecificInputBase withInitialSchemeTransactionId(String value) {
        this.initialSchemeTransactionId = value;
        return this;
    }

    /**
     * Object containing marketplace-related data for additional information on sub-merchants (retailers) transacting via the marketplace’s platform.
     * This object is required for platforms onboarding multiple sellers to ensure accurate identification and attribution of each transaction.
     * The platform must collect and submit the retailer’s country and regional information in accordance with card scheme requirements.
     * In some cases, Visa may treat specific regions—such as EU member states—as a single country entity for regulatory and reporting purposes.
     */
    public MarketPlace getMarketPlace() {
        return marketPlace;
    }

    /**
     * Object containing marketplace-related data for additional information on sub-merchants (retailers) transacting via the marketplace’s platform.
     * This object is required for platforms onboarding multiple sellers to ensure accurate identification and attribution of each transaction.
     * The platform must collect and submit the retailer’s country and regional information in accordance with card scheme requirements.
     * In some cases, Visa may treat specific regions—such as EU member states—as a single country entity for regulatory and reporting purposes.
     */
    public void setMarketPlace(MarketPlace value) {
        this.marketPlace = value;
    }

    /**
     * Object containing marketplace-related data for additional information on sub-merchants (retailers) transacting via the marketplace’s platform.
     * This object is required for platforms onboarding multiple sellers to ensure accurate identification and attribution of each transaction.
     * The platform must collect and submit the retailer’s country and regional information in accordance with card scheme requirements.
     * In some cases, Visa may treat specific regions—such as EU member states—as a single country entity for regulatory and reporting purposes.
     */
    public CardPaymentMethodSpecificInputBase withMarketPlace(MarketPlace value) {
        this.marketPlace = value;
        return this;
    }

    /**
     * Container announcing forecoming subsequent payments. Holds modalities of these subsequent payments.
     */
    public MultiplePaymentInformation getMultiplePaymentInformation() {
        return multiplePaymentInformation;
    }

    /**
     * Container announcing forecoming subsequent payments. Holds modalities of these subsequent payments.
     */
    public void setMultiplePaymentInformation(MultiplePaymentInformation value) {
        this.multiplePaymentInformation = value;
    }

    /**
     * Container announcing forecoming subsequent payments. Holds modalities of these subsequent payments.
     */
    public CardPaymentMethodSpecificInputBase withMultiplePaymentInformation(MultiplePaymentInformation value) {
        this.multiplePaymentInformation = value;
        return this;
    }

    /**
     * Object containing specific input required for CB payments
     */
    public PaymentProduct130SpecificInput getPaymentProduct130SpecificInput() {
        return paymentProduct130SpecificInput;
    }

    /**
     * Object containing specific input required for CB payments
     */
    public void setPaymentProduct130SpecificInput(PaymentProduct130SpecificInput value) {
        this.paymentProduct130SpecificInput = value;
    }

    /**
     * Object containing specific input required for CB payments
     */
    public CardPaymentMethodSpecificInputBase withPaymentProduct130SpecificInput(PaymentProduct130SpecificInput value) {
        this.paymentProduct130SpecificInput = value;
        return this;
    }

    /**
     * Object containing specific input required for bancontact.
     */
    public PaymentProduct3012SpecificInput getPaymentProduct3012SpecificInput() {
        return paymentProduct3012SpecificInput;
    }

    /**
     * Object containing specific input required for bancontact.
     */
    public void setPaymentProduct3012SpecificInput(PaymentProduct3012SpecificInput value) {
        this.paymentProduct3012SpecificInput = value;
    }

    /**
     * Object containing specific input required for bancontact.
     */
    public CardPaymentMethodSpecificInputBase withPaymentProduct3012SpecificInput(PaymentProduct3012SpecificInput value) {
        this.paymentProduct3012SpecificInput = value;
        return this;
    }

    /**
     * An object containing specific input required for VISA purchasing authorization.
     */
    public PaymentProduct3013SpecificInput getPaymentProduct3013SpecificInput() {
        return paymentProduct3013SpecificInput;
    }

    /**
     * An object containing specific input required for VISA purchasing authorization.
     */
    public void setPaymentProduct3013SpecificInput(PaymentProduct3013SpecificInput value) {
        this.paymentProduct3013SpecificInput = value;
    }

    /**
     * An object containing specific input required for VISA purchasing authorization.
     */
    public CardPaymentMethodSpecificInputBase withPaymentProduct3013SpecificInput(PaymentProduct3013SpecificInput value) {
        this.paymentProduct3013SpecificInput = value;
        return this;
    }

    /**
     * Object containing specific input required for OneyDuplo Leroy Merlin payments.
     */
    public PaymentProduct3208SpecificInput getPaymentProduct3208SpecificInput() {
        return paymentProduct3208SpecificInput;
    }

    /**
     * Object containing specific input required for OneyDuplo Leroy Merlin payments.
     */
    public void setPaymentProduct3208SpecificInput(PaymentProduct3208SpecificInput value) {
        this.paymentProduct3208SpecificInput = value;
    }

    /**
     * Object containing specific input required for OneyDuplo Leroy Merlin payments.
     */
    public CardPaymentMethodSpecificInputBase withPaymentProduct3208SpecificInput(PaymentProduct3208SpecificInput value) {
        this.paymentProduct3208SpecificInput = value;
        return this;
    }

    /**
     * Object containing specific input required for OneyDuplo Alcampo payments.
     */
    public PaymentProduct3209SpecificInput getPaymentProduct3209SpecificInput() {
        return paymentProduct3209SpecificInput;
    }

    /**
     * Object containing specific input required for OneyDuplo Alcampo payments.
     */
    public void setPaymentProduct3209SpecificInput(PaymentProduct3209SpecificInput value) {
        this.paymentProduct3209SpecificInput = value;
    }

    /**
     * Object containing specific input required for OneyDuplo Alcampo payments.
     */
    public CardPaymentMethodSpecificInputBase withPaymentProduct3209SpecificInput(PaymentProduct3209SpecificInput value) {
        this.paymentProduct3209SpecificInput = value;
        return this;
    }

    /**
     * Object containing specific input required for Cpay payments.
     */
    public PaymentProduct5100SpecificInput getPaymentProduct5100SpecificInput() {
        return paymentProduct5100SpecificInput;
    }

    /**
     * Object containing specific input required for Cpay payments.
     */
    public void setPaymentProduct5100SpecificInput(PaymentProduct5100SpecificInput value) {
        this.paymentProduct5100SpecificInput = value;
    }

    /**
     * Object containing specific input required for Cpay payments.
     */
    public CardPaymentMethodSpecificInputBase withPaymentProduct5100SpecificInput(PaymentProduct5100SpecificInput value) {
        this.paymentProduct5100SpecificInput = value;
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
    public CardPaymentMethodSpecificInputBase withPaymentProductId(Integer value) {
        this.paymentProductId = value;
        return this;
    }

    /**
     * Object containing data related to recurring
     */
    public CardRecurrenceDetails getRecurring() {
        return recurring;
    }

    /**
     * Object containing data related to recurring
     */
    public void setRecurring(CardRecurrenceDetails value) {
        this.recurring = value;
    }

    /**
     * Object containing data related to recurring
     */
    public CardPaymentMethodSpecificInputBase withRecurring(CardRecurrenceDetails value) {
        this.recurring = value;
        return this;
    }

    /**
     * Object containing specific data regarding 3-D Secure
     */
    public ThreeDSecureBase getThreeDSecure() {
        return threeDSecure;
    }

    /**
     * Object containing specific data regarding 3-D Secure
     */
    public void setThreeDSecure(ThreeDSecureBase value) {
        this.threeDSecure = value;
    }

    /**
     * Object containing specific data regarding 3-D Secure
     */
    public CardPaymentMethodSpecificInputBase withThreeDSecure(ThreeDSecureBase value) {
        this.threeDSecure = value;
        return this;
    }

    /**
     * ID of the token to use to create the payment.
     */
    public String getToken() {
        return token;
    }

    /**
     * ID of the token to use to create the payment.
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * ID of the token to use to create the payment.
     */
    public CardPaymentMethodSpecificInputBase withToken(String value) {
        this.token = value;
        return this;
    }

    /**
     * Indicates if this transaction should be tokenized * true - Tokenize the transaction. * false - Do not tokenize the transaction, unless it would be tokenized by other means such as auto-tokenization of recurring payments. Note: This property is deprecated for Hosted Checkout integrations. It has been deprecated by hostedCheckoutSpecificInput.cardPaymentMethodSpecificInput.tokenizationMode.
     */
    public Boolean getTokenize() {
        return tokenize;
    }

    /**
     * Indicates if this transaction should be tokenized * true - Tokenize the transaction. * false - Do not tokenize the transaction, unless it would be tokenized by other means such as auto-tokenization of recurring payments. Note: This property is deprecated for Hosted Checkout integrations. It has been deprecated by hostedCheckoutSpecificInput.cardPaymentMethodSpecificInput.tokenizationMode.
     */
    public void setTokenize(Boolean value) {
        this.tokenize = value;
    }

    /**
     * Indicates if this transaction should be tokenized * true - Tokenize the transaction. * false - Do not tokenize the transaction, unless it would be tokenized by other means such as auto-tokenization of recurring payments. Note: This property is deprecated for Hosted Checkout integrations. It has been deprecated by hostedCheckoutSpecificInput.cardPaymentMethodSpecificInput.tokenizationMode.
     */
    public CardPaymentMethodSpecificInputBase withTokenize(Boolean value) {
        this.tokenize = value;
        return this;
    }

    /**
     * Indicates the channel via which the payment is created. Allowed values:
     * <ul>
     *   <li>ECOMMERCE - The transaction is a regular E-Commerce transaction.</li>
     *   <li>MOTO - The transaction is a Mail Order/Telephone Order.</li>
     * </ul>
     * <p>
     * Defaults to ECOMMERCE.
     */
    public String getTransactionChannel() {
        return transactionChannel;
    }

    /**
     * Indicates the channel via which the payment is created. Allowed values:
     * <ul>
     *   <li>ECOMMERCE - The transaction is a regular E-Commerce transaction.</li>
     *   <li>MOTO - The transaction is a Mail Order/Telephone Order.</li>
     * </ul>
     * <p>
     * Defaults to ECOMMERCE.
     */
    public void setTransactionChannel(String value) {
        this.transactionChannel = value;
    }

    /**
     * Indicates the channel via which the payment is created. Allowed values:
     * <ul>
     *   <li>ECOMMERCE - The transaction is a regular E-Commerce transaction.</li>
     *   <li>MOTO - The transaction is a Mail Order/Telephone Order.</li>
     * </ul>
     * <p>
     * Defaults to ECOMMERCE.
     */
    public CardPaymentMethodSpecificInputBase withTransactionChannel(String value) {
        this.transactionChannel = value;
        return this;
    }

    /**
     * Indicates which party initiated the unscheduled recurring transaction. Allowed values:
     * <ul>
     *   <li>merchantInitiated - Merchant Initiated Transaction.</li>
     *   <li>cardholderInitiated - Cardholder Initiated Transaction.
     * Note:</li>
     *   <li>This property is not allowed if isRecurring is true.</li>
     *   <li>When a customer has chosen to use a token on a hosted checkout this property is set to &quot;cardholderInitiated&quot;.</li>
     * </ul>
     */
    public String getUnscheduledCardOnFileRequestor() {
        return unscheduledCardOnFileRequestor;
    }

    /**
     * Indicates which party initiated the unscheduled recurring transaction. Allowed values:
     * <ul>
     *   <li>merchantInitiated - Merchant Initiated Transaction.</li>
     *   <li>cardholderInitiated - Cardholder Initiated Transaction.
     * Note:</li>
     *   <li>This property is not allowed if isRecurring is true.</li>
     *   <li>When a customer has chosen to use a token on a hosted checkout this property is set to &quot;cardholderInitiated&quot;.</li>
     * </ul>
     */
    public void setUnscheduledCardOnFileRequestor(String value) {
        this.unscheduledCardOnFileRequestor = value;
    }

    /**
     * Indicates which party initiated the unscheduled recurring transaction. Allowed values:
     * <ul>
     *   <li>merchantInitiated - Merchant Initiated Transaction.</li>
     *   <li>cardholderInitiated - Cardholder Initiated Transaction.
     * Note:</li>
     *   <li>This property is not allowed if isRecurring is true.</li>
     *   <li>When a customer has chosen to use a token on a hosted checkout this property is set to &quot;cardholderInitiated&quot;.</li>
     * </ul>
     */
    public CardPaymentMethodSpecificInputBase withUnscheduledCardOnFileRequestor(String value) {
        this.unscheduledCardOnFileRequestor = value;
        return this;
    }

    /**
     * <ul>
     *   <li>first = This transaction is the first of a series of unscheduled recurring transactions</li>
     *   <li>subsequent = This transaction is a subsequent transaction in a series of unscheduled recurring transactions
     * Note: this property is not allowed if isRecurring is true.</li>
     * </ul>
     */
    public String getUnscheduledCardOnFileSequenceIndicator() {
        return unscheduledCardOnFileSequenceIndicator;
    }

    /**
     * <ul>
     *   <li>first = This transaction is the first of a series of unscheduled recurring transactions</li>
     *   <li>subsequent = This transaction is a subsequent transaction in a series of unscheduled recurring transactions
     * Note: this property is not allowed if isRecurring is true.</li>
     * </ul>
     */
    public void setUnscheduledCardOnFileSequenceIndicator(String value) {
        this.unscheduledCardOnFileSequenceIndicator = value;
    }

    /**
     * <ul>
     *   <li>first = This transaction is the first of a series of unscheduled recurring transactions</li>
     *   <li>subsequent = This transaction is a subsequent transaction in a series of unscheduled recurring transactions
     * Note: this property is not allowed if isRecurring is true.</li>
     * </ul>
     */
    public CardPaymentMethodSpecificInputBase withUnscheduledCardOnFileSequenceIndicator(String value) {
        this.unscheduledCardOnFileSequenceIndicator = value;
        return this;
    }
}
