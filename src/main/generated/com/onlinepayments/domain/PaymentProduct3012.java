/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Contains the third party data for payment product 3012 (Bancontact)
 */
public class PaymentProduct3012 {

	private String qrCode = null;

	private String urlIntent = null;

	/**
	 * Contains a base64 encoded PNG image. By prepending data:image/png;base64, this value can be used as the source of an HTML inline image on a desktop or tablet (intended to be scanned by a device with the Bancontact app)
	 */
	public String getQrCode() {
		return qrCode;
	}

	/**
	 * Contains a base64 encoded PNG image. By prepending data:image/png;base64, this value can be used as the source of an HTML inline image on a desktop or tablet (intended to be scanned by a device with the Bancontact app)
	 */
	public void setQrCode(String value) {
		this.qrCode = value;
	}

	/**
	 * Contains a base64 encoded PNG image. By prepending data:image/png;base64, this value can be used as the source of an HTML inline image on a desktop or tablet (intended to be scanned by a device with the Bancontact app)
	 */
	public PaymentProduct3012 withQrCode(String value) {
		this.qrCode = value;
		return this;
	}

	/**
	 * Contains URL intent that can be used as the link of an "open the app" button on a device
	 */
	public String getUrlIntent() {
		return urlIntent;
	}

	/**
	 * Contains URL intent that can be used as the link of an "open the app" button on a device
	 */
	public void setUrlIntent(String value) {
		this.urlIntent = value;
	}

	/**
	 * Contains URL intent that can be used as the link of an "open the app" button on a device
	 */
	public PaymentProduct3012 withUrlIntent(String value) {
		this.urlIntent = value;
		return this;
	}
}
