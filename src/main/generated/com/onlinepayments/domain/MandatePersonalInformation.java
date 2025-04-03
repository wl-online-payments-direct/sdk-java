/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class MandatePersonalInformation {

    private MandatePersonalName name;

    private String title;

    /**
     * Object containing the name details of the customer.
     * Required for Create mandate and Create payment calls.
     */
    public MandatePersonalName getName() {
        return name;
    }

    /**
     * Object containing the name details of the customer.
     * Required for Create mandate and Create payment calls.
     */
    public void setName(MandatePersonalName value) {
        this.name = value;
    }

    /**
     * Object containing the name details of the customer.
     * Required for Create mandate and Create payment calls.
     */
    public MandatePersonalInformation withName(MandatePersonalName value) {
        this.name = value;
        return this;
    }

    /**
     * Object containing the title of the customer (Mr, Miss or Mrs)
     */
    public String getTitle() {
        return title;
    }

    /**
     * Object containing the title of the customer (Mr, Miss or Mrs)
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Object containing the title of the customer (Mr, Miss or Mrs)
     */
    public MandatePersonalInformation withTitle(String value) {
        this.title = value;
        return this;
    }
}
