/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PersonalInformation {

    private String dateOfBirth;

    private String gender;

    private PersonalName name;

    /**
     * The date of birth of the customer of the recipient of the loan.
     * Format YYYYMMDD
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * The date of birth of the customer of the recipient of the loan.
     * Format YYYYMMDD
     */
    public void setDateOfBirth(String value) {
        this.dateOfBirth = value;
    }

    /**
     * The date of birth of the customer of the recipient of the loan.
     * Format YYYYMMDD
     */
    public PersonalInformation withDateOfBirth(String value) {
        this.dateOfBirth = value;
        return this;
    }

    /**
     * The gender of the customer. All values are possible as long as it does not exceed the maximum length of 50 characters.
     */
    public String getGender() {
        return gender;
    }

    /**
     * The gender of the customer. All values are possible as long as it does not exceed the maximum length of 50 characters.
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * The gender of the customer. All values are possible as long as it does not exceed the maximum length of 50 characters.
     */
    public PersonalInformation withGender(String value) {
        this.gender = value;
        return this;
    }

    /**
     * Object containing the name details of the customer
     */
    public PersonalName getName() {
        return name;
    }

    /**
     * Object containing the name details of the customer
     */
    public void setName(PersonalName value) {
        this.name = value;
    }

    /**
     * Object containing the name details of the customer
     */
    public PersonalInformation withName(PersonalName value) {
        this.name = value;
        return this;
    }
}
