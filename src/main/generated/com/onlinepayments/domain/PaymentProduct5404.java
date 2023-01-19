/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Contains the third party data for payment product 5404 (WeChat Pay)
 */
public class PaymentProduct5404 {

	private String appSwitchLink = null;

	private String qrCodeUrl = null;

	/**
	 * Contains a application switch url that should open WeChat Pay application in mobile device (intended to be used by a device with the WeChat Pay app)
	 */
	public String getAppSwitchLink() {
		return appSwitchLink;
	}

	/**
	 * Contains a application switch url that should open WeChat Pay application in mobile device (intended to be used by a device with the WeChat Pay app)
	 */
	public void setAppSwitchLink(String value) {
		this.appSwitchLink = value;
	}

	/**
	 * Contains a application switch url that should open WeChat Pay application in mobile device (intended to be used by a device with the WeChat Pay app)
	 */
	public PaymentProduct5404 withAppSwitchLink(String value) {
		this.appSwitchLink = value;
		return this;
	}

	/**
	 * Contains a QR code url that can be used to build a QR code (intended to be scanned by a device with the WeChat Pay app)
	 */
	public String getQrCodeUrl() {
		return qrCodeUrl;
	}

	/**
	 * Contains a QR code url that can be used to build a QR code (intended to be scanned by a device with the WeChat Pay app)
	 */
	public void setQrCodeUrl(String value) {
		this.qrCodeUrl = value;
	}

	/**
	 * Contains a QR code url that can be used to build a QR code (intended to be scanned by a device with the WeChat Pay app)
	 */
	public PaymentProduct5404 withQrCodeUrl(String value) {
		this.qrCodeUrl = value;
		return this;
	}
}
