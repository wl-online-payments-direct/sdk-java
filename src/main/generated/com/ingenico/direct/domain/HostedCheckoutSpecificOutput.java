/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Hosted Checkout specific information. Populated if the payment was created on the platform through a Hosted Checkout.
 */
public class HostedCheckoutSpecificOutput {

	private String hostedCheckoutId = null;

	private String variant = null;

	/**
	 * The ID of the Hosted Checkout Session in which the payment was made.
	 */
	public String getHostedCheckoutId() {
		return hostedCheckoutId;
	}

	/**
	 * The ID of the Hosted Checkout Session in which the payment was made.
	 */
	public void setHostedCheckoutId(String value) {
		this.hostedCheckoutId = value;
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
