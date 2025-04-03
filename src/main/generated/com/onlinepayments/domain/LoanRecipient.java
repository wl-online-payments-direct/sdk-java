/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class LoanRecipient {

    private String accountNumber;

    private String dateOfBirth;

    private String partialPan;

    private String surname;

    private String zip;

    /**
     * Should be filled with the last 10 digits of the bank account number of the recipient of the loan.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Should be filled with the last 10 digits of the bank account number of the recipient of the loan.
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Should be filled with the last 10 digits of the bank account number of the recipient of the loan.
     */
    public LoanRecipient withAccountNumber(String value) {
        this.accountNumber = value;
        return this;
    }

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
    public LoanRecipient withDateOfBirth(String value) {
        this.dateOfBirth = value;
        return this;
    }

    /**
     * Should be filled with the first 6 and last 4 digits of the PAN number of the recipient of the loan.
     */
    public String getPartialPan() {
        return partialPan;
    }

    /**
     * Should be filled with the first 6 and last 4 digits of the PAN number of the recipient of the loan.
     */
    public void setPartialPan(String value) {
        this.partialPan = value;
    }

    /**
     * Should be filled with the first 6 and last 4 digits of the PAN number of the recipient of the loan.
     */
    public LoanRecipient withPartialPan(String value) {
        this.partialPan = value;
        return this;
    }

    /**
     * Surname of the recipient of the loan.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Surname of the recipient of the loan.
     */
    public void setSurname(String value) {
        this.surname = value;
    }

    /**
     * Surname of the recipient of the loan.
     */
    public LoanRecipient withSurname(String value) {
        this.surname = value;
        return this;
    }

    /**
     * Zip code of the recipient of the loan
     */
    public String getZip() {
        return zip;
    }

    /**
     * Zip code of the recipient of the loan
     */
    public void setZip(String value) {
        this.zip = value;
    }

    /**
     * Zip code of the recipient of the loan
     */
    public LoanRecipient withZip(String value) {
        this.zip = value;
        return this;
    }
}
