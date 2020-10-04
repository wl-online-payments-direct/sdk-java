/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

public class CreateHostedTokenizationRequest {

	private String locale = null;

	private String tokens = null;

	private String variant = null;

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
	 * Using the Back-Office it is possible to upload multiple templates of your HostedCheckout payment pages. You can force the use of another template by specifying it in the variant field. This allows you to test out the effect of certain changes to your hostedcheckout pages in a controlled manner. Please note that you need to specify the filename of the template.
	 */
	public String getVariant() {
		return variant;
	}

	/**
	 * Using the Back-Office it is possible to upload multiple templates of your HostedCheckout payment pages. You can force the use of another template by specifying it in the variant field. This allows you to test out the effect of certain changes to your hostedcheckout pages in a controlled manner. Please note that you need to specify the filename of the template.
	 */
	public void setVariant(String value) {
		this.variant = value;
	}
}
