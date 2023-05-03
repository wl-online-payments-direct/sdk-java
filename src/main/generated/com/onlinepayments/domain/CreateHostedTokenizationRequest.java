/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class CreateHostedTokenizationRequest {

	private Boolean askConsumerConsent = null;

	private String locale = null;

	private String tokens = null;

	private String variant = null;

	/**
	 * Indicate if the tokenization form should contain a prompt asking the user to give consent for storing their information for future payments.
	 * If this parameter is false, you should ask the user yourself and provide the answer when submitting the Tokenizer in your javascript code.
	 */
	public Boolean getAskConsumerConsent() {
		return askConsumerConsent;
	}

	/**
	 * Indicate if the tokenization form should contain a prompt asking the user to give consent for storing their information for future payments.
	 * If this parameter is false, you should ask the user yourself and provide the answer when submitting the Tokenizer in your javascript code.
	 */
	public void setAskConsumerConsent(Boolean value) {
		this.askConsumerConsent = value;
	}

	/**
	 * Indicate if the tokenization form should contain a prompt asking the user to give consent for storing their information for future payments.
	 * If this parameter is false, you should ask the user yourself and provide the answer when submitting the Tokenizer in your javascript code.
	 */
	public CreateHostedTokenizationRequest withAskConsumerConsent(Boolean value) {
		this.askConsumerConsent = value;
		return this;
	}

	/**
	 * Locale used in the GUI towards the consumer. 
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * Locale used in the GUI towards the consumer. 
	 */
	public void setLocale(String value) {
		this.locale = value;
	}

	/**
	 * Locale used in the GUI towards the consumer. 
	 */
	public CreateHostedTokenizationRequest withLocale(String value) {
		this.locale = value;
		return this;
	}

	/**
	 * String containing comma separated tokens (no spaces) associated with the customer of this hosted session. Valid tokens will be used to present the customer the option to re-use previously used payment details. This means the customer for instance does not have to re-enter their card details again, which a big plus when the customer is using their mobile phone to complete the operation.
	 */
	public String getTokens() {
		return tokens;
	}

	/**
	 * String containing comma separated tokens (no spaces) associated with the customer of this hosted session. Valid tokens will be used to present the customer the option to re-use previously used payment details. This means the customer for instance does not have to re-enter their card details again, which a big plus when the customer is using their mobile phone to complete the operation.
	 */
	public void setTokens(String value) {
		this.tokens = value;
	}

	/**
	 * String containing comma separated tokens (no spaces) associated with the customer of this hosted session. Valid tokens will be used to present the customer the option to re-use previously used payment details. This means the customer for instance does not have to re-enter their card details again, which a big plus when the customer is using their mobile phone to complete the operation.
	 */
	public CreateHostedTokenizationRequest withTokens(String value) {
		this.tokens = value;
		return this;
	}

	/**
	 * Using the Back-Office it is possible to upload multiple templates of your HostedCheckout payment pages, including customized templates from Merchant Portal. You can force the use of another template by specifying it in the variant field. This allows you to test out the effect of certain changes to your hostedcheckout pages in a controlled manner. Please note that you need to specify the filename of the template or customization.
	 */
	public String getVariant() {
		return variant;
	}

	/**
	 * Using the Back-Office it is possible to upload multiple templates of your HostedCheckout payment pages, including customized templates from Merchant Portal. You can force the use of another template by specifying it in the variant field. This allows you to test out the effect of certain changes to your hostedcheckout pages in a controlled manner. Please note that you need to specify the filename of the template or customization.
	 */
	public void setVariant(String value) {
		this.variant = value;
	}

	/**
	 * Using the Back-Office it is possible to upload multiple templates of your HostedCheckout payment pages, including customized templates from Merchant Portal. You can force the use of another template by specifying it in the variant field. This allows you to test out the effect of certain changes to your hostedcheckout pages in a controlled manner. Please note that you need to specify the filename of the template or customization.
	 */
	public CreateHostedTokenizationRequest withVariant(String value) {
		this.variant = value;
		return this;
	}
}
