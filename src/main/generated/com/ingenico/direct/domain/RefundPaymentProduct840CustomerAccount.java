/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

public class RefundPaymentProduct840CustomerAccount {

	private String customerAccountStatus = null;

	private String customerAddressStatus = null;

	private String payerId = null;

	public String getCustomerAccountStatus() {
		return customerAccountStatus;
	}

	public void setCustomerAccountStatus(String value) {
		this.customerAccountStatus = value;
	}

	public String getCustomerAddressStatus() {
		return customerAddressStatus;
	}

	public void setCustomerAddressStatus(String value) {
		this.customerAddressStatus = value;
	}

	/**
	 * The unique identifier of a PayPal account and will never change in the life cycle of a PayPal account
	 */
	public String getPayerId() {
		return payerId;
	}

	/**
	 * The unique identifier of a PayPal account and will never change in the life cycle of a PayPal account
	 */
	public void setPayerId(String value) {
		this.payerId = value;
	}
}
