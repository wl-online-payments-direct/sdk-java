/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing display hints for this field, like the order, mask, preferred keyboard
 */
public class PaymentProductFieldDisplayHints {

	private Boolean alwaysShow = null;

	private Integer displayOrder = null;

	private PaymentProductFieldFormElement formElement = null;

	private String label = null;

	private String link = null;

	private String mask = null;

	private Boolean obfuscate = null;

	private String placeholderLabel = null;

	private String preferredInputType = null;

	private PaymentProductFieldTooltip tooltip = null;

	/**
	 * * true - Indicates that this field is advised to be captured to increase the success rates even-though it isn't marked as required. Please note that making the field required could hurt the success rates negatively. This boolean only indicates our advise to always show this field to the customer.
	 * * false - Indicates that this field is not to be shown unless it is a required field.
	 */
	public Boolean getAlwaysShow() {
		return alwaysShow;
	}

	/**
	 * * true - Indicates that this field is advised to be captured to increase the success rates even-though it isn't marked as required. Please note that making the field required could hurt the success rates negatively. This boolean only indicates our advise to always show this field to the customer.
	 * * false - Indicates that this field is not to be shown unless it is a required field.
	 */
	public void setAlwaysShow(Boolean value) {
		this.alwaysShow = value;
	}

	/**
	 * * true - Indicates that this field is advised to be captured to increase the success rates even-though it isn't marked as required. Please note that making the field required could hurt the success rates negatively. This boolean only indicates our advise to always show this field to the customer.
	 * * false - Indicates that this field is not to be shown unless it is a required field.
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
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Link that should be used to replace the '{link}' variable in the label.
	 */
	public void setLink(String value) {
		this.link = value;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Link that should be used to replace the '{link}' variable in the label.
	 */
	public PaymentProductFieldDisplayHints withLink(String value) {
		this.link = value;
		return this;
	}

	/**
	 * A mask that can be used in the input field. You can use it to inject additional characters to provide a better user experience and to restrict the accepted character set (illegal characters will be ignored during typing).
	 * <br>* is used for wildcards (and also chars)
	 * <br>9 is used for numbers
	 * <br>Everything outside {{ and }} is used as-is.
	 */
	public String getMask() {
		return mask;
	}

	/**
	 * A mask that can be used in the input field. You can use it to inject additional characters to provide a better user experience and to restrict the accepted character set (illegal characters will be ignored during typing).
	 * <br>* is used for wildcards (and also chars)
	 * <br>9 is used for numbers
	 * <br>Everything outside {{ and }} is used as-is.
	 */
	public void setMask(String value) {
		this.mask = value;
	}

	/**
	 * A mask that can be used in the input field. You can use it to inject additional characters to provide a better user experience and to restrict the accepted character set (illegal characters will be ignored during typing).
	 * <br>* is used for wildcards (and also chars)
	 * <br>9 is used for numbers
	 * <br>Everything outside {{ and }} is used as-is.
	 */
	public PaymentProductFieldDisplayHints withMask(String value) {
		this.mask = value;
		return this;
	}

	/**
	 * * true - The data in this field should be obfuscated as it is entered, just like a password field
	 * * false - The data in this field does not need to be obfuscated
	 */
	public Boolean getObfuscate() {
		return obfuscate;
	}

	/**
	 * * true - The data in this field should be obfuscated as it is entered, just like a password field
	 * * false - The data in this field does not need to be obfuscated
	 */
	public void setObfuscate(Boolean value) {
		this.obfuscate = value;
	}

	/**
	 * * true - The data in this field should be obfuscated as it is entered, just like a password field
	 * * false - The data in this field does not need to be obfuscated
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
	 * * PhoneNumberKeyboard - Keyboard that is normally used to enter phone numbers
	 * * StringKeyboard - Keyboard that is used to enter strings
	 * * IntegerKeyboard - Keyboard that is used to enter only numerical values
	 * * EmailAddressKeyboard - Keyboard that allows easier entry of email addresses
	 */
	public String getPreferredInputType() {
		return preferredInputType;
	}

	/**
	 * The type of keyboard that can best be used to fill out the value of this field. Possible values are:
	 * * PhoneNumberKeyboard - Keyboard that is normally used to enter phone numbers
	 * * StringKeyboard - Keyboard that is used to enter strings
	 * * IntegerKeyboard - Keyboard that is used to enter only numerical values
	 * * EmailAddressKeyboard - Keyboard that allows easier entry of email addresses
	 */
	public void setPreferredInputType(String value) {
		this.preferredInputType = value;
	}

	/**
	 * The type of keyboard that can best be used to fill out the value of this field. Possible values are:
	 * * PhoneNumberKeyboard - Keyboard that is normally used to enter phone numbers
	 * * StringKeyboard - Keyboard that is used to enter strings
	 * * IntegerKeyboard - Keyboard that is used to enter only numerical values
	 * * EmailAddressKeyboard - Keyboard that allows easier entry of email addresses
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
