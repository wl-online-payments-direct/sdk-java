/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class LodgingData {

    private String checkInDate;

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
