/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Contains the third party data for payment product 5407 (Twint)
 */
public class PaymentProduct5407 {

	private String pairingToken = null;

	private String qrCode = null;

	/**
	 * A numeric token, which the user has to copy or type into the TWINT app in order to pair it with the merchant for the payment process.
	 */
	public String getPairingToken() {
		return pairingToken;
	}

	/**
	 * A numeric token, which the user has to copy or type into the TWINT app in order to pair it with the merchant for the payment process.
	 */
	public void setPairingToken(String value) {
		this.pairingToken = value;
	}

	/**
	 * A numeric token, which the user has to copy or type into the TWINT app in order to pair it with the merchant for the payment process.
	 */
	public PaymentProduct5407 withPairingToken(String value) {
		this.pairingToken = value;
		return this;
	}

	/**
	 * Contains a base64 encoded PNG image. By prepending data:image/png;base64, this value can be used as the source of an HTML inline image on a desktop or tablet (intended to be scanned by a device with the Twint app)
	 */
	public String getQrCode() {
		return qrCode;
	}

	/**
	 * Contains a base64 encoded PNG image. By prepending data:image/png;base64, this value can be used as the source of an HTML inline image on a desktop or tablet (intended to be scanned by a device with the Twint app)
	 */
	public void setQrCode(String value) {
		this.qrCode = value;
	}

	/**
	 * Contains a base64 encoded PNG image. By prepending data:image/png;base64, this value can be used as the source of an HTML inline image on a desktop or tablet (intended to be scanned by a device with the Twint app)
	 */
	public PaymentProduct5407 withQrCode(String value) {
		this.qrCode = value;
		return this;
	}
}
