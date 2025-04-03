/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentLinkEvent {

    private String dateTime;

    private String details;

    private String type;

    /**
     * The date and time the change occurred. The date will contain the UTC offset.
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * The date and time the change occurred. The date will contain the UTC offset.
     */
    public void setDateTime(String value) {
        this.dateTime = value;
    }

    /**
     * The date and time the change occurred. The date will contain the UTC offset.
     */
    public PaymentLinkEvent withDateTime(String value) {
        this.dateTime = value;
        return this;
    }

    /**
     * Details of the events. Ex.: email address or phone number of the recipient.
     */
    public String getDetails() {
        return details;
    }

    /**
     * Details of the events. Ex.: email address or phone number of the recipient.
     */
    public void setDetails(String value) {
        this.details = value;
    }

    /**
     * Details of the events. Ex.: email address or phone number of the recipient.
     */
    public PaymentLinkEvent withDetails(String value) {
        this.details = value;
        return this;
    }

    /**
     * The type of event that occurred.
     */
    public String getType() {
        return type;
    }

    /**
     * The type of event that occurred.
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * The type of event that occurred.
     */
    public PaymentLinkEvent withType(String value) {
        this.type = value;
        return this;
    }
}
