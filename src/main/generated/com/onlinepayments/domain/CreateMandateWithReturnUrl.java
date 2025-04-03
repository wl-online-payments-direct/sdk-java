/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CreateMandateWithReturnUrl {

    private String alias;

    private MandateCustomer customer;

    private String customerReference;

    private String language;

    private String recurrenceType;

    private String returnUrl;

    private String signatureType;

    private String uniqueMandateReference;

    /**
     * An alias for the mandate. This can be used to visually represent the mandate. Do not include any unmasked sensitive data in the alias. If this field is not provided the masked IBAN of the customer is used.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * An alias for the mandate. This can be used to visually represent the mandate. Do not include any unmasked sensitive data in the alias. If this field is not provided the masked IBAN of the customer is used.
     */
    public void setAlias(String value) {
        this.alias = value;
    }

    /**
     * An alias for the mandate. This can be used to visually represent the mandate. Do not include any unmasked sensitive data in the alias. If this field is not provided the masked IBAN of the customer is used.
     */
    public CreateMandateWithReturnUrl withAlias(String value) {
        this.alias = value;
        return this;
    }

    /**
     * Customer object containing customer specific inputs.
     * Required for Create mandate and Create payment calls.
     */
    public MandateCustomer getCustomer() {
        return customer;
    }

    /**
     * Customer object containing customer specific inputs.
     * Required for Create mandate and Create payment calls.
     */
    public void setCustomer(MandateCustomer value) {
        this.customer = value;
    }

    /**
     * Customer object containing customer specific inputs.
     * Required for Create mandate and Create payment calls.
     */
    public CreateMandateWithReturnUrl withCustomer(MandateCustomer value) {
        this.customer = value;
        return this;
    }

    /**
     * The unique identifier of a customer
     */
    public String getCustomerReference() {
        return customerReference;
    }

    /**
     * The unique identifier of a customer
     */
    public void setCustomerReference(String value) {
        this.customerReference = value;
    }

    /**
     * The unique identifier of a customer
     */
    public CreateMandateWithReturnUrl withCustomerReference(String value) {
        this.customerReference = value;
        return this;
    }

    /**
     * The language code of the customer. ISO 639-1, possible values are:
     * <ul>
     *   <li>de</li>
     *   <li>en</li>
     *   <li>es</li>
     *   <li>fr</li>
     *   <li>it</li>
     *   <li>nl</li>
     *   <li>si</li>
     *   <li>sk</li>
     *   <li>sv</li>
     * </ul>
     */
    public String getLanguage() {
        return language;
    }

    /**
     * The language code of the customer. ISO 639-1, possible values are:
     * <ul>
     *   <li>de</li>
     *   <li>en</li>
     *   <li>es</li>
     *   <li>fr</li>
     *   <li>it</li>
     *   <li>nl</li>
     *   <li>si</li>
     *   <li>sk</li>
     *   <li>sv</li>
     * </ul>
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * The language code of the customer. ISO 639-1, possible values are:
     * <ul>
     *   <li>de</li>
     *   <li>en</li>
     *   <li>es</li>
     *   <li>fr</li>
     *   <li>it</li>
     *   <li>nl</li>
     *   <li>si</li>
     *   <li>sk</li>
     *   <li>sv</li>
     * </ul>
     */
    public CreateMandateWithReturnUrl withLanguage(String value) {
        this.language = value;
        return this;
    }

    /**
     * Specifies whether the mandate is for one-off or recurring payments. Possible values are:
     * <ul>
     *   <li>UNIQUE</li>
     *   <li>RECURRING</li>
     * </ul>
     */
    public String getRecurrenceType() {
        return recurrenceType;
    }

    /**
     * Specifies whether the mandate is for one-off or recurring payments. Possible values are:
     * <ul>
     *   <li>UNIQUE</li>
     *   <li>RECURRING</li>
     * </ul>
     */
    public void setRecurrenceType(String value) {
        this.recurrenceType = value;
    }

    /**
     * Specifies whether the mandate is for one-off or recurring payments. Possible values are:
     * <ul>
     *   <li>UNIQUE</li>
     *   <li>RECURRING</li>
     * </ul>
     */
    public CreateMandateWithReturnUrl withRecurrenceType(String value) {
        this.recurrenceType = value;
        return this;
    }

    /**
     * Return URL to use if the mandate signing requires redirection. Required for S2S Create Payment if and only if the signatureType is &quot;SMS&quot;.
     */
    public String getReturnUrl() {
        return returnUrl;
    }

    /**
     * Return URL to use if the mandate signing requires redirection. Required for S2S Create Payment if and only if the signatureType is &quot;SMS&quot;.
     */
    public void setReturnUrl(String value) {
        this.returnUrl = value;
    }

    /**
     * Return URL to use if the mandate signing requires redirection. Required for S2S Create Payment if and only if the signatureType is &quot;SMS&quot;.
     */
    public CreateMandateWithReturnUrl withReturnUrl(String value) {
        this.returnUrl = value;
        return this;
    }

    /**
     * Specifies whether the mandate is tick box, unsigned or signed by SMS. Possible values are:
     * <ul>
     *   <li>UNSIGNED</li>
     *   <li>SMS</li>
     *   <li>TICK_BOX - This option is only available for Equens Worldline</li>
     * </ul>
     */
    public String getSignatureType() {
        return signatureType;
    }

    /**
     * Specifies whether the mandate is tick box, unsigned or signed by SMS. Possible values are:
     * <ul>
     *   <li>UNSIGNED</li>
     *   <li>SMS</li>
     *   <li>TICK_BOX - This option is only available for Equens Worldline</li>
     * </ul>
     */
    public void setSignatureType(String value) {
        this.signatureType = value;
    }

    /**
     * Specifies whether the mandate is tick box, unsigned or signed by SMS. Possible values are:
     * <ul>
     *   <li>UNSIGNED</li>
     *   <li>SMS</li>
     *   <li>TICK_BOX - This option is only available for Equens Worldline</li>
     * </ul>
     */
    public CreateMandateWithReturnUrl withSignatureType(String value) {
        this.signatureType = value;
        return this;
    }

    /**
     * The unique identifier of the mandate
     */
    public String getUniqueMandateReference() {
        return uniqueMandateReference;
    }

    /**
     * The unique identifier of the mandate
     */
    public void setUniqueMandateReference(String value) {
        this.uniqueMandateReference = value;
    }

    /**
     * The unique identifier of the mandate
     */
    public CreateMandateWithReturnUrl withUniqueMandateReference(String value) {
        this.uniqueMandateReference = value;
        return this;
    }
}
