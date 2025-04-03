/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProductFieldDisplayHints {

    private Boolean alwaysShow;

    private Integer displayOrder;

    private PaymentProductFieldFormElement formElement;

    private String label;

    private String link;

    private String mask;

    private Boolean obfuscate;

    private String placeholderLabel;

    private String preferredInputType;

    private PaymentProductFieldTooltip tooltip;

    /**
     * <ul>
     *   <li>true - Indicates that this field is advised to be captured to increase the success rates even-though it isn't marked as required. Please note that making the field required could hurt the success rates negatively. This boolean only indicates our advise to always show this field to the customer.</li>
     *   <li>false - Indicates that this field is not to be shown unless it is a required field.</li>
     * </ul>
     */
    public Boolean getAlwaysShow() {
        return alwaysShow;
    }

    /**
     * <ul>
     *   <li>true - Indicates that this field is advised to be captured to increase the success rates even-though it isn't marked as required. Please note that making the field required could hurt the success rates negatively. This boolean only indicates our advise to always show this field to the customer.</li>
     *   <li>false - Indicates that this field is not to be shown unless it is a required field.</li>
     * </ul>
     */
    public void setAlwaysShow(Boolean value) {
        this.alwaysShow = value;
    }

    /**
     * <ul>
     *   <li>true - Indicates that this field is advised to be captured to increase the success rates even-though it isn't marked as required. Please note that making the field required could hurt the success rates negatively. This boolean only indicates our advise to always show this field to the customer.</li>
     *   <li>false - Indicates that this field is not to be shown unless it is a required field.</li>
     * </ul>
     */
    public PaymentProductFieldDisplayHints withAlwaysShow(Boolean value) {
        this.alwaysShow = value;
        return this;
    }

    /**
     * The order in which the fields should be shown (ascending)
     */
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     * The order in which the fields should be shown (ascending)
     */
    public void setDisplayOrder(Integer value) {
        this.displayOrder = value;
    }

    /**
     * The order in which the fields should be shown (ascending)
     */
    public PaymentProductFieldDisplayHints withDisplayOrder(Integer value) {
        this.displayOrder = value;
        return this;
    }

    /**
     * Object detailing the type of form element that should be used to present the field
     */
    public PaymentProductFieldFormElement getFormElement() {
        return formElement;
    }

    /**
     * Object detailing the type of form element that should be used to present the field
     */
    public void setFormElement(PaymentProductFieldFormElement value) {
        this.formElement = value;
    }

    /**
     * Object detailing the type of form element that should be used to present the field
     */
    public PaymentProductFieldDisplayHints withFormElement(PaymentProductFieldFormElement value) {
        this.formElement = value;
        return this;
    }

    /**
     * Label/Name of the field to be used in the user interface
     */
    public String getLabel() {
        return label;
    }

    /**
     * Label/Name of the field to be used in the user interface
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Label/Name of the field to be used in the user interface
     */
    public PaymentProductFieldDisplayHints withLabel(String value) {
        this.label = value;
        return this;
    }

    /**
     * Deprecated: This field is not used by any payment product
     * Link that should be used to replace the '{link}' variable in the label.
     *
     * @deprecated Deprecated
     */
    @Deprecated
    public String getLink() {
        return link;
    }

    /**
     * Deprecated: This field is not used by any payment product
     * Link that should be used to replace the '{link}' variable in the label.
     *
     * @deprecated Deprecated
     */
    @Deprecated
    public void setLink(String value) {
        this.link = value;
    }

    /**
     * Deprecated: This field is not used by any payment product
     * Link that should be used to replace the '{link}' variable in the label.
     *
     * @deprecated Deprecated
     */
    @Deprecated
    public PaymentProductFieldDisplayHints withLink(String value) {
        this.link = value;
        return this;
    }

    /**
     * A mask that can be used in the input field. You can use it to inject additional characters to provide a better user experience and to restrict the accepted character set (illegal characters will be ignored during typing).
     * <ul>
     *   <li>is used for wildcards (and also chars)
     * 9 is used for numbers
     * Everything outside {{ and }} is used as-is.</li>
     * </ul>
     */
    public String getMask() {
        return mask;
    }

    /**
     * A mask that can be used in the input field. You can use it to inject additional characters to provide a better user experience and to restrict the accepted character set (illegal characters will be ignored during typing).
     * <ul>
     *   <li>is used for wildcards (and also chars)
     * 9 is used for numbers
     * Everything outside {{ and }} is used as-is.</li>
     * </ul>
     */
    public void setMask(String value) {
        this.mask = value;
    }

    /**
     * A mask that can be used in the input field. You can use it to inject additional characters to provide a better user experience and to restrict the accepted character set (illegal characters will be ignored during typing).
     * <ul>
     *   <li>is used for wildcards (and also chars)
     * 9 is used for numbers
     * Everything outside {{ and }} is used as-is.</li>
     * </ul>
     */
    public PaymentProductFieldDisplayHints withMask(String value) {
        this.mask = value;
        return this;
    }

    /**
     * <ul>
     *   <li>true - The data in this field should be obfuscated as it is entered, just like a password field</li>
     *   <li>false - The data in this field does not need to be obfuscated</li>
     * </ul>
     */
    public Boolean getObfuscate() {
        return obfuscate;
    }

    /**
     * <ul>
     *   <li>true - The data in this field should be obfuscated as it is entered, just like a password field</li>
     *   <li>false - The data in this field does not need to be obfuscated</li>
     * </ul>
     */
    public void setObfuscate(Boolean value) {
        this.obfuscate = value;
    }

    /**
     * <ul>
     *   <li>true - The data in this field should be obfuscated as it is entered, just like a password field</li>
     *   <li>false - The data in this field does not need to be obfuscated</li>
     * </ul>
     */
    public PaymentProductFieldDisplayHints withObfuscate(Boolean value) {
        this.obfuscate = value;
        return this;
    }

    /**
     * A placeholder value for the form element
     */
    public String getPlaceholderLabel() {
        return placeholderLabel;
    }

    /**
     * A placeholder value for the form element
     */
    public void setPlaceholderLabel(String value) {
        this.placeholderLabel = value;
    }

    /**
     * A placeholder value for the form element
     */
    public PaymentProductFieldDisplayHints withPlaceholderLabel(String value) {
        this.placeholderLabel = value;
        return this;
    }

    /**
     * The type of keyboard that can best be used to fill out the value of this field. Possible values are:
     * <ul>
     *   <li>PhoneNumberKeyboard - Keyboard that is normally used to enter phone numbers</li>
     *   <li>StringKeyboard - Keyboard that is used to enter strings</li>
     *   <li>IntegerKeyboard - Keyboard that is used to enter only numerical values</li>
     *   <li>EmailAddressKeyboard - Keyboard that allows easier entry of email addresses</li>
     * </ul>
     */
    public String getPreferredInputType() {
        return preferredInputType;
    }

    /**
     * The type of keyboard that can best be used to fill out the value of this field. Possible values are:
     * <ul>
     *   <li>PhoneNumberKeyboard - Keyboard that is normally used to enter phone numbers</li>
     *   <li>StringKeyboard - Keyboard that is used to enter strings</li>
     *   <li>IntegerKeyboard - Keyboard that is used to enter only numerical values</li>
     *   <li>EmailAddressKeyboard - Keyboard that allows easier entry of email addresses</li>
     * </ul>
     */
    public void setPreferredInputType(String value) {
        this.preferredInputType = value;
    }

    /**
     * The type of keyboard that can best be used to fill out the value of this field. Possible values are:
     * <ul>
     *   <li>PhoneNumberKeyboard - Keyboard that is normally used to enter phone numbers</li>
     *   <li>StringKeyboard - Keyboard that is used to enter strings</li>
     *   <li>IntegerKeyboard - Keyboard that is used to enter only numerical values</li>
     *   <li>EmailAddressKeyboard - Keyboard that allows easier entry of email addresses</li>
     * </ul>
     */
    public PaymentProductFieldDisplayHints withPreferredInputType(String value) {
        this.preferredInputType = value;
        return this;
    }

    /**
     * Object that contains an optional tooltip to assist the customer
     */
    public PaymentProductFieldTooltip getTooltip() {
        return tooltip;
    }

    /**
     * Object that contains an optional tooltip to assist the customer
     */
    public void setTooltip(PaymentProductFieldTooltip value) {
        this.tooltip = value;
    }

    /**
     * Object that contains an optional tooltip to assist the customer
     */
    public PaymentProductFieldDisplayHints withTooltip(PaymentProductFieldTooltip value) {
        this.tooltip = value;
        return this;
    }
}
