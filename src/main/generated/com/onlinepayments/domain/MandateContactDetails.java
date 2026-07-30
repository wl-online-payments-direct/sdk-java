/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class MandateContactDetails {

    private String emailAddress;

    private String phoneNumber;

    /**
     * Email address of the customer
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Email address of the customer
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Email address of the customer
     */
    public MandateContactDetails withEmailAddress(String value) {
        this.emailAddress = value;
        return this;
    }

    /**
     * International version of the phone number of the customer including the leading + (i.e. +4917612345678)
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * International version of the phone number of the customer including the leading + (i.e. +4917612345678)
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * International version of the phone number of the customer including the leading + (i.e. +4917612345678)
     */
    public MandateContactDetails withPhoneNumber(String value) {
        this.phoneNumber = value;
        return this;
    }
}
