/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RedirectPaymentMethodSpecificInput {

    private String paymentOption;

    private RedirectPaymentProduct3203SpecificInput paymentProduct3203SpecificInput;

    private RedirectPaymentProduct3204SpecificInput paymentProduct3204SpecificInput;

    private RedirectPaymentProduct3302SpecificInput paymentProduct3302SpecificInput;

    private RedirectPaymentProduct3306SpecificInput paymentProduct3306SpecificInput;

    private RedirectPaymentProduct5001SpecificInput paymentProduct5001SpecificInput;

    private RedirectPaymentProduct5300SpecificInput paymentProduct5300SpecificInput;

    private RedirectPaymentProduct5402SpecificInput paymentProduct5402SpecificInput;

    private RedirectPaymentProduct5403SpecificInput paymentProduct5403SpecificInput;

    private RedirectPaymentProduct5406SpecificInput paymentProduct5406SpecificInput;

    private RedirectPaymentProduct5408SpecificInput paymentProduct5408SpecificInput;

    private RedirectPaymentProduct5410SpecificInput paymentProduct5410SpecificInput;

    private RedirectPaymentProduct5412SpecificInput paymentProduct5412SpecificInput;

    @SuppressWarnings("deprecation")
    private RedirectPaymentProduct809SpecificInput paymentProduct809SpecificInput;

    private RedirectPaymentProduct840SpecificInput paymentProduct840SpecificInput;

    private Integer paymentProductId;

    private RedirectionData redirectionData;

    private Boolean requiresApproval;

    private String token;

    private Boolean tokenize;

    /**
     * The specific payment option for the payment. To be used as a complement of the more generic paymentProductId (oney, banquecasino, cofidis), which allows to define a variation of the selected paymentProductId (ex: facilypay3x, banquecasino4x, cofidis3x-sansfrais, ...). List of modalities included in the payment product page.
     */
    public String getPaymentOption() {
        return paymentOption;
    }

    /**
     * The specific payment option for the payment. To be used as a complement of the more generic paymentProductId (oney, banquecasino, cofidis), which allows to define a variation of the selected paymentProductId (ex: facilypay3x, banquecasino4x, cofidis3x-sansfrais, ...). List of modalities included in the payment product page.
     */
    public void setPaymentOption(String value) {
        this.paymentOption = value;
    }

    /**
     * The specific payment option for the payment. To be used as a complement of the more generic paymentProductId (oney, banquecasino, cofidis), which allows to define a variation of the selected paymentProductId (ex: facilypay3x, banquecasino4x, cofidis3x-sansfrais, ...). List of modalities included in the payment product page.
     */
    public RedirectPaymentMethodSpecificInput withPaymentOption(String value) {
        this.paymentOption = value;
        return this;
    }

    /**
     * Object containing specific input for PostFinancePay payments (Payment product ID 3203).
     */
    public RedirectPaymentProduct3203SpecificInput getPaymentProduct3203SpecificInput() {
        return paymentProduct3203SpecificInput;
    }

    /**
     * Object containing specific input for PostFinancePay payments (Payment product ID 3203).
     */
    public void setPaymentProduct3203SpecificInput(RedirectPaymentProduct3203SpecificInput value) {
        this.paymentProduct3203SpecificInput = value;
    }

    /**
     * Object containing specific input for PostFinancePay payments (Payment product ID 3203).
     */
    public RedirectPaymentMethodSpecificInput withPaymentProduct3203SpecificInput(RedirectPaymentProduct3203SpecificInput value) {
        this.paymentProduct3203SpecificInput = value;
        return this;
    }

    /**
     * BLIK (payment product 3204) specific details
     */
    public RedirectPaymentProduct3204SpecificInput getPaymentProduct3204SpecificInput() {
        return paymentProduct3204SpecificInput;
    }

    /**
     * BLIK (payment product 3204) specific details
     */
    public void setPaymentProduct3204SpecificInput(RedirectPaymentProduct3204SpecificInput value) {
        this.paymentProduct3204SpecificInput = value;
    }

    /**
     * BLIK (payment product 3204) specific details
     */
    public RedirectPaymentMethodSpecificInput withPaymentProduct3204SpecificInput(RedirectPaymentProduct3204SpecificInput value) {
        this.paymentProduct3204SpecificInput = value;
        return this;
    }

    /**
     * Object containing specific input required for Klarna PayLater payment (Payment product ID 3302)
     */
    public RedirectPaymentProduct3302SpecificInput getPaymentProduct3302SpecificInput() {
        return paymentProduct3302SpecificInput;
    }

    /**
     * Object containing specific input required for Klarna PayLater payment (Payment product ID 3302)
     */
    public void setPaymentProduct3302SpecificInput(RedirectPaymentProduct3302SpecificInput value) {
        this.paymentProduct3302SpecificInput = value;
    }

    /**
     * Object containing specific input required for Klarna PayLater payment (Payment product ID 3302)
     */
    public RedirectPaymentMethodSpecificInput withPaymentProduct3302SpecificInput(RedirectPaymentProduct3302SpecificInput value) {
        this.paymentProduct3302SpecificInput = value;
        return this;
    }

    /**
     * Object containing specific input required for Klarna payments (Payment product ID 3306)
     */
    public RedirectPaymentProduct3306SpecificInput getPaymentProduct3306SpecificInput() {
        return paymentProduct3306SpecificInput;
    }

    /**
     * Object containing specific input required for Klarna payments (Payment product ID 3306)
     */
    public void setPaymentProduct3306SpecificInput(RedirectPaymentProduct3306SpecificInput value) {
        this.paymentProduct3306SpecificInput = value;
    }

    /**
     * Object containing specific input required for Klarna payments (Payment product ID 3306)
     */
    public RedirectPaymentMethodSpecificInput withPaymentProduct3306SpecificInput(RedirectPaymentProduct3306SpecificInput value) {
        this.paymentProduct3306SpecificInput = value;
        return this;
    }

    /**
     * Object containing specific input required for Bizum payments
     */
    public RedirectPaymentProduct5001SpecificInput getPaymentProduct5001SpecificInput() {
        return paymentProduct5001SpecificInput;
    }

    /**
     * Object containing specific input required for Bizum payments
     */
    public void setPaymentProduct5001SpecificInput(RedirectPaymentProduct5001SpecificInput value) {
        this.paymentProduct5001SpecificInput = value;
    }

    /**
     * Object containing specific input required for Bizum payments
     */
    public RedirectPaymentMethodSpecificInput withPaymentProduct5001SpecificInput(RedirectPaymentProduct5001SpecificInput value) {
        this.paymentProduct5001SpecificInput = value;
        return this;
    }

    /**
     * Pledg (payment product 5300) specific details
     */
    public RedirectPaymentProduct5300SpecificInput getPaymentProduct5300SpecificInput() {
        return paymentProduct5300SpecificInput;
    }

    /**
     * Pledg (payment product 5300) specific details
     */
    public void setPaymentProduct5300SpecificInput(RedirectPaymentProduct5300SpecificInput value) {
        this.paymentProduct5300SpecificInput = value;
    }

    /**
     * Pledg (payment product 5300) specific details
     */
    public RedirectPaymentMethodSpecificInput withPaymentProduct5300SpecificInput(RedirectPaymentProduct5300SpecificInput value) {
        this.paymentProduct5300SpecificInput = value;
        return this;
    }

    /**
     * Object containing specific input required for E-Voucher payments (Payment product ID 5402)
     */
    public RedirectPaymentProduct5402SpecificInput getPaymentProduct5402SpecificInput() {
        return paymentProduct5402SpecificInput;
    }

    /**
     * Object containing specific input required for E-Voucher payments (Payment product ID 5402)
     */
    public void setPaymentProduct5402SpecificInput(RedirectPaymentProduct5402SpecificInput value) {
        this.paymentProduct5402SpecificInput = value;
    }

    /**
     * Object containing specific input required for E-Voucher payments (Payment product ID 5402)
     */
    public RedirectPaymentMethodSpecificInput withPaymentProduct5402SpecificInput(RedirectPaymentProduct5402SpecificInput value) {
        this.paymentProduct5402SpecificInput = value;
        return this;
    }

    /**
     * Object containing specific input required for Chèque-Vacances Connect payments via Limonetik (Payment product ID 5403)
     */
    public RedirectPaymentProduct5403SpecificInput getPaymentProduct5403SpecificInput() {
        return paymentProduct5403SpecificInput;
    }

    /**
     * Object containing specific input required for Chèque-Vacances Connect payments via Limonetik (Payment product ID 5403)
     */
    public void setPaymentProduct5403SpecificInput(RedirectPaymentProduct5403SpecificInput value) {
        this.paymentProduct5403SpecificInput = value;
    }

    /**
     * Object containing specific input required for Chèque-Vacances Connect payments via Limonetik (Payment product ID 5403)
     */
    public RedirectPaymentMethodSpecificInput withPaymentProduct5403SpecificInput(RedirectPaymentProduct5403SpecificInput value) {
        this.paymentProduct5403SpecificInput = value;
        return this;
    }

    /**
     * Object containing specific input for EPS payments (Payment product ID 5406)
     */
    public RedirectPaymentProduct5406SpecificInput getPaymentProduct5406SpecificInput() {
        return paymentProduct5406SpecificInput;
    }

    /**
     * Object containing specific input for EPS payments (Payment product ID 5406)
     */
    public void setPaymentProduct5406SpecificInput(RedirectPaymentProduct5406SpecificInput value) {
        this.paymentProduct5406SpecificInput = value;
    }

    /**
     * Object containing specific input for EPS payments (Payment product ID 5406)
     */
    public RedirectPaymentMethodSpecificInput withPaymentProduct5406SpecificInput(RedirectPaymentProduct5406SpecificInput value) {
        this.paymentProduct5406SpecificInput = value;
        return this;
    }

    /**
     * Object containing specific input for Account to Account payments (Payment product ID 5408)
     */
    public RedirectPaymentProduct5408SpecificInput getPaymentProduct5408SpecificInput() {
        return paymentProduct5408SpecificInput;
    }

    /**
     * Object containing specific input for Account to Account payments (Payment product ID 5408)
     */
    public void setPaymentProduct5408SpecificInput(RedirectPaymentProduct5408SpecificInput value) {
        this.paymentProduct5408SpecificInput = value;
    }

    /**
     * Object containing specific input for Account to Account payments (Payment product ID 5408)
     */
    public RedirectPaymentMethodSpecificInput withPaymentProduct5408SpecificInput(RedirectPaymentProduct5408SpecificInput value) {
        this.paymentProduct5408SpecificInput = value;
        return this;
    }

    /**
     * iDealin3 (payment product 5410) specific details
     */
    public RedirectPaymentProduct5410SpecificInput getPaymentProduct5410SpecificInput() {
        return paymentProduct5410SpecificInput;
    }

    /**
     * iDealin3 (payment product 5410) specific details
     */
    public void setPaymentProduct5410SpecificInput(RedirectPaymentProduct5410SpecificInput value) {
        this.paymentProduct5410SpecificInput = value;
    }

    /**
     * iDealin3 (payment product 5410) specific details
     */
    public RedirectPaymentMethodSpecificInput withPaymentProduct5410SpecificInput(RedirectPaymentProduct5410SpecificInput value) {
        this.paymentProduct5410SpecificInput = value;
        return this;
    }

    /**
     * Object containing specific input required for Chèque-Vacances Connect payments via ANCV (Payment product ID 5412)
     */
    public RedirectPaymentProduct5412SpecificInput getPaymentProduct5412SpecificInput() {
        return paymentProduct5412SpecificInput;
    }

    /**
     * Object containing specific input required for Chèque-Vacances Connect payments via ANCV (Payment product ID 5412)
     */
    public void setPaymentProduct5412SpecificInput(RedirectPaymentProduct5412SpecificInput value) {
        this.paymentProduct5412SpecificInput = value;
    }

    /**
     * Object containing specific input required for Chèque-Vacances Connect payments via ANCV (Payment product ID 5412)
     */
    public RedirectPaymentMethodSpecificInput withPaymentProduct5412SpecificInput(RedirectPaymentProduct5412SpecificInput value) {
        this.paymentProduct5412SpecificInput = value;
        return this;
    }

    /**
     * Deprecated, this is no longer used.
     */
    public RedirectPaymentProduct809SpecificInput getPaymentProduct809SpecificInput() {
        return paymentProduct809SpecificInput;
    }

    /**
     * Deprecated, this is no longer used.
     */
    public void setPaymentProduct809SpecificInput(RedirectPaymentProduct809SpecificInput value) {
        this.paymentProduct809SpecificInput = value;
    }

    /**
     * Deprecated, this is no longer used.
     */
    public RedirectPaymentMethodSpecificInput withPaymentProduct809SpecificInput(RedirectPaymentProduct809SpecificInput value) {
        this.paymentProduct809SpecificInput = value;
        return this;
    }

    /**
     * Object containing specific input required for PayPal payments (Payment product ID 840)
     */
    public RedirectPaymentProduct840SpecificInput getPaymentProduct840SpecificInput() {
        return paymentProduct840SpecificInput;
    }

    /**
     * Object containing specific input required for PayPal payments (Payment product ID 840)
     */
    public void setPaymentProduct840SpecificInput(RedirectPaymentProduct840SpecificInput value) {
        this.paymentProduct840SpecificInput = value;
    }

    /**
     * Object containing specific input required for PayPal payments (Payment product ID 840)
     */
    public RedirectPaymentMethodSpecificInput withPaymentProduct840SpecificInput(RedirectPaymentProduct840SpecificInput value) {
        this.paymentProduct840SpecificInput = value;
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
    public RedirectPaymentMethodSpecificInput withPaymentProductId(Integer value) {
        this.paymentProductId = value;
        return this;
    }

    /**
     * Object containing browser specific redirection related data
     */
    public RedirectionData getRedirectionData() {
        return redirectionData;
    }

    /**
     * Object containing browser specific redirection related data
     */
    public void setRedirectionData(RedirectionData value) {
        this.redirectionData = value;
    }

    /**
     * Object containing browser specific redirection related data
     */
    public RedirectPaymentMethodSpecificInput withRedirectionData(RedirectionData value) {
        this.redirectionData = value;
        return this;
    }

    /**
     * <ul>
     *   <li>true = the payment requires approval before the funds will be captured using the Approve payment or Capture payment API</li>
     *   <li>false = the payment does not require approval, and the funds will be captured automatically</li>
     * </ul>
     */
    public Boolean getRequiresApproval() {
        return requiresApproval;
    }

    /**
     * <ul>
     *   <li>true = the payment requires approval before the funds will be captured using the Approve payment or Capture payment API</li>
     *   <li>false = the payment does not require approval, and the funds will be captured automatically</li>
     * </ul>
     */
    public void setRequiresApproval(Boolean value) {
        this.requiresApproval = value;
    }

    /**
     * <ul>
     *   <li>true = the payment requires approval before the funds will be captured using the Approve payment or Capture payment API</li>
     *   <li>false = the payment does not require approval, and the funds will be captured automatically</li>
     * </ul>
     */
    public RedirectPaymentMethodSpecificInput withRequiresApproval(Boolean value) {
        this.requiresApproval = value;
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
    public RedirectPaymentMethodSpecificInput withToken(String value) {
        this.token = value;
        return this;
    }

    /**
     * Indicates if this transaction should be tokenized
     * <ul>
     *   <li>true - Tokenize the transaction.</li>
     *   <li>false - Do not tokenize the transaction, unless it would be tokenized by other means such as auto-tokenization of recurring payments.</li>
     * </ul>
     */
    public Boolean getTokenize() {
        return tokenize;
    }

    /**
     * Indicates if this transaction should be tokenized
     * <ul>
     *   <li>true - Tokenize the transaction.</li>
     *   <li>false - Do not tokenize the transaction, unless it would be tokenized by other means such as auto-tokenization of recurring payments.</li>
     * </ul>
     */
    public void setTokenize(Boolean value) {
        this.tokenize = value;
    }

    /**
     * Indicates if this transaction should be tokenized
     * <ul>
     *   <li>true - Tokenize the transaction.</li>
     *   <li>false - Do not tokenize the transaction, unless it would be tokenized by other means such as auto-tokenization of recurring payments.</li>
     * </ul>
     */
    public RedirectPaymentMethodSpecificInput withTokenize(Boolean value) {
        this.tokenize = value;
        return this;
    }
}
