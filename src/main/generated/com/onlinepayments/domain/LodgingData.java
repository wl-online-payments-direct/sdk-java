/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object that holds lodging specific data
 */
public class LodgingData {

	private String checkInDate = null;

	/**
	 * The date the guest checks into (or plans to check in to) the facility.
	 * Format YYYYMMDD
	 */
	public String getCheckInDate() {
		return checkInDate;
	}

	/**
	 * The date the guest checks into (or plans to check in to) the facility.
	 * Format YYYYMMDD
	 */
	public void setCheckInDate(String value) {
		this.checkInDate = value;
	}

	/**
	 * The date the guest checks into (or plans to check in to) the facility.
	 * Format YYYYMMDD
	 */
	public LodgingData withCheckInDate(String value) {
		this.checkInDate = value;
		return this;
	}
}
