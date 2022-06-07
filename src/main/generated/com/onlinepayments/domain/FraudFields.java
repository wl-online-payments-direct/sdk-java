/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing additional data that will be used to assess the risk of fraud
 */
public class FraudFields {

	private String blackListData = null;

	private String customerIpAddress = null;

	/**
	 * Additional black list input
	 */
	public String getBlackListData() {
		return blackListData;
	}

	/**
	 * Additional black list input
	 */
	public void setBlackListData(String value) {
		this.blackListData = value;
	}

	/**
	 * Additional black list input
	 */
	public FraudFields withBlackListData(String value) {
		this.blackListData = value;
		return this;
	}

	/**
	 * Deprecated: Use order.customer.device.ipAddress instead.
	 * 
	 * The IP Address of the customer that is making the payment
	 */
	public String getCustomerIpAddress() {
		return customerIpAddress;
	}

	/**
	 * Deprecated: Use order.customer.device.ipAddress instead.
	 * 
	 * The IP Address of the customer that is making the payment
	 */
	public void setCustomerIpAddress(String value) {
		this.customerIpAddress = value;
	}

	/**
	 * Deprecated: Use order.customer.device.ipAddress instead.
	 * 
	 * The IP Address of the customer that is making the payment
	 */
	public FraudFields withCustomerIpAddress(String value) {
		this.customerIpAddress = value;
		return this;
	}
}
