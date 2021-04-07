/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * Object containing hosted checkout specific data
 */
public class HostedCheckoutSpecificInput {

	private CardPaymentMethodSpecificInputForHostedCheckout cardPaymentMethodSpecificInput = null;

	private Boolean isRecurring = null;

	private String locale = null;

	private PaymentProductFiltersHostedCheckout paymentProductFilters = null;

	private String returnUrl = null;

	private Boolean showResultPage = null;

	private String tokens = null;

	private String variant = null;

	/**
	 * Object containing card payment specific data for hosted checkout
	 */
	public CardPaymentMethodSpecificInputForHostedCheckout getCardPaymentMethodSpecificInput() {
		return cardPaymentMethodSpecificInput;
	}

	/**
	 * Object containing card payment specific data for hosted checkout
	 */
	public void setCardPaymentMethodSpecificInput(CardPaymentMethodSpecificInputForHostedCheckout value) {
		this.cardPaymentMethodSpecificInput = value;
	}

	/**
	 * * true - Only payment products that support recurring payments will be shown. Any transactions created will also be tagged as being a first of a recurring sequence.
	 * * false - Only payment products that support one-off payments will be shown.
	 * The default value for this property is false.
	 */
	public Boolean getIsRecurring() {
		return isRecurring;
	}

	/**
	 * * true - Only payment products that support recurring payments will be shown. Any transactions created will also be tagged as being a first of a recurring sequence.
	 * * false - Only payment products that support one-off payments will be shown.
	 * The default value for this property is false.
	 */
	public void setIsRecurring(Boolean value) {
		this.isRecurring = value;
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
	 * Contains the payment product ids and payment product groups that will be used for manipulating the payment products available for the payment to the customer.
	 */
	public PaymentProductFiltersHostedCheckout getPaymentProductFilters() {
		return paymentProductFilters;
	}

	/**
	 * Contains the payment product ids and payment product groups that will be used for manipulating the payment products available for the payment to the customer.
	 */
	public void setPaymentProductFilters(PaymentProductFiltersHostedCheckout value) {
		this.paymentProductFilters = value;
	}

	/**
	 * The URL that the customer is redirect to after the payment flow has finished. You can add any number of key value pairs in the query string that, for instance help you to identify the customer when they return to your site. Please note that we will also append some additional key value pairs that will also help you with this identification process.
	 * Note: The provided URL should be absolute and contain the protocol to use, e.g. http:// or https://. For use on mobile devices a custom protocol can be used in the form of protocol://. This protocol must be registered on the device first.
	 * URLs without a protocol will be rejected.
	 */
	public String getReturnUrl() {
		return returnUrl;
	}

	/**
	 * The URL that the customer is redirect to after the payment flow has finished. You can add any number of key value pairs in the query string that, for instance help you to identify the customer when they return to your site. Please note that we will also append some additional key value pairs that will also help you with this identification process.
	 * Note: The provided URL should be absolute and contain the protocol to use, e.g. http:// or https://. For use on mobile devices a custom protocol can be used in the form of protocol://. This protocol must be registered on the device first.
	 * URLs without a protocol will be rejected.
	 */
	public void setReturnUrl(String value) {
		this.returnUrl = value;
	}

	/**
	 * * true - Default - Hosted Checkout will show a result page to the customer when applicable.
	 * * false - Hosted Checkout will redirect the customer back to the provided returnUrl when this is possible.
	 */
	public Boolean getShowResultPage() {
		return showResultPage;
	}

	/**
	 * * true - Default - Hosted Checkout will show a result page to the customer when applicable.
	 * * false - Hosted Checkout will redirect the customer back to the provided returnUrl when this is possible.
	 */
	public void setShowResultPage(Boolean value) {
		this.showResultPage = value;
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
