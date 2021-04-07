/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * Object containing specific data regarding 3-D Secure
 */
public class PaymentProduct130SpecificThreeDSecure {

	private Boolean acquirerExemption = null;

	private String merchantScore = null;

	private Integer numberOfItems = null;

	private String usecase = null;

	/**
	 * Indicates the Acquirer TRA exemption
	 */
	public Boolean getAcquirerExemption() {
		return acquirerExemption;
	}

	/**
	 * Indicates the Acquirer TRA exemption
	 */
	public void setAcquirerExemption(Boolean value) {
		this.acquirerExemption = value;
	}

	/**
	 * Score calculated by the 3DS Requestor and provided to CB Scoring service only.
	 */
	public String getMerchantScore() {
		return merchantScore;
	}

	/**
	 * Score calculated by the 3DS Requestor and provided to CB Scoring service only.
	 */
	public void setMerchantScore(String value) {
		this.merchantScore = value;
	}

	/**
	 * Number of purchased items or services. 99 if more than 99 items
	 */
	public Integer getNumberOfItems() {
		return numberOfItems;
	}

	/**
	 * Number of purchased items or services. 99 if more than 99 items
	 */
	public void setNumberOfItems(Integer value) {
		this.numberOfItems = value;
	}

	/**
	 * Indicates the type of payment for which an authentication is requested
	 */
	public String getUsecase() {
		return usecase;
	}

	/**
	 * Indicates the type of payment for which an authentication is requested
	 */
	public void setUsecase(String value) {
		this.usecase = value;
	}
}
