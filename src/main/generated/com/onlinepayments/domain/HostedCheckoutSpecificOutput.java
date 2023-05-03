/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

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
	 * The ID of the Hosted Checkout Session in which the payment was made.
	 */
	public HostedCheckoutSpecificOutput withHostedCheckoutId(String value) {
		this.hostedCheckoutId = value;
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
	public HostedCheckoutSpecificOutput withVariant(String value) {
		this.variant = value;
		return this;
	}
}
