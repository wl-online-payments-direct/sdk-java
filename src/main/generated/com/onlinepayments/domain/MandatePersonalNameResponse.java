/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class MandatePersonalNameResponse {

    private String firstName;

    private String surname;

    /**
     * Given name(s) or first name(s) of the customer.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Given name(s) or first name(s) of the customer.
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Given name(s) or first name(s) of the customer.
     */
    public MandatePersonalNameResponse withFirstName(String value) {
        this.firstName = value;
        return this;
    }

    /**
     * Surname(s) or last name(s) of the customer.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Surname(s) or last name(s) of the customer.
     */
    public void setSurname(String value) {
        this.surname = value;
    }

    /**
     * Surname(s) or last name(s) of the customer.
     */
    public MandatePersonalNameResponse withSurname(String value) {
        this.surname = value;
        return this;
    }
}
