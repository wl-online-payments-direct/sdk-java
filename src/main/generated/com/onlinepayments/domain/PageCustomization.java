/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class PageCustomization {

	private String template = null;

	/**
	 * Using the Back-Office it is possible to upload multiple templates of your HostedCheckout payment pages. You can force the use of a template by specifying it in the Template field. This allows you to customize the hostedcheckout pages or the redirection pages. Please note that you need to specify the filename of the template.
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * Using the Back-Office it is possible to upload multiple templates of your HostedCheckout payment pages. You can force the use of a template by specifying it in the Template field. This allows you to customize the hostedcheckout pages or the redirection pages. Please note that you need to specify the filename of the template.
	 */
	public void setTemplate(String value) {
		this.template = value;
	}

	/**
	 * Using the Back-Office it is possible to upload multiple templates of your HostedCheckout payment pages. You can force the use of a template by specifying it in the Template field. This allows you to customize the hostedcheckout pages or the redirection pages. Please note that you need to specify the filename of the template.
	 */
	public PageCustomization withTemplate(String value) {
		this.template = value;
		return this;
	}
}
