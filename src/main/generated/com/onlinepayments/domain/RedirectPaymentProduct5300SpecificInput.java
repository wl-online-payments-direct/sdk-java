/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RedirectPaymentProduct5300SpecificInput {

    private String birthCity;

    private String birthCountry;

    private String birthZipCode;

    private String channel;

    private String loyaltyCardNumber;

    private String secondInstallmentPaymentDate;

    private Integer sessionDuration;

    private String title;

    /**
     * The city of the address where the customer was born
     */
    public String getBirthCity() {
        return birthCity;
    }

    /**
     * The city of the address where the customer was born
     */
    public void setBirthCity(String value) {
        this.birthCity = value;
    }

    /**
     * The city of the address where the customer was born
     */
    public RedirectPaymentProduct5300SpecificInput withBirthCity(String value) {
        this.birthCity = value;
        return this;
    }

    /**
     * ISO 3166-1 alpha-2 country code of the address where the customer was born
     */
    public String getBirthCountry() {
        return birthCountry;
    }

    /**
     * ISO 3166-1 alpha-2 country code of the address where the customer was born
     */
    public void setBirthCountry(String value) {
        this.birthCountry = value;
    }

    /**
     * ISO 3166-1 alpha-2 country code of the address where the customer was born
     */
    public RedirectPaymentProduct5300SpecificInput withBirthCountry(String value) {
        this.birthCountry = value;
        return this;
    }

    /**
     * The zip code of the address where the customer was born
     */
    public String getBirthZipCode() {
        return birthZipCode;
    }

    /**
     * The zip code of the address where the customer was born
     */
    public void setBirthZipCode(String value) {
        this.birthZipCode = value;
    }

    /**
     * The zip code of the address where the customer was born
     */
    public RedirectPaymentProduct5300SpecificInput withBirthZipCode(String value) {
        this.birthZipCode = value;
        return this;
    }

    /**
     * The channel used by the customer
     */
    public String getChannel() {
        return channel;
    }

    /**
     * The channel used by the customer
     */
    public void setChannel(String value) {
        this.channel = value;
    }

    /**
     * The channel used by the customer
     */
    public RedirectPaymentProduct5300SpecificInput withChannel(String value) {
        this.channel = value;
        return this;
    }

    /**
     * The number of customer's loyalty card or program
     */
    public String getLoyaltyCardNumber() {
        return loyaltyCardNumber;
    }

    /**
     * The number of customer's loyalty card or program
     */
    public void setLoyaltyCardNumber(String value) {
        this.loyaltyCardNumber = value;
    }

    /**
     * The number of customer's loyalty card or program
     */
    public RedirectPaymentProduct5300SpecificInput withLoyaltyCardNumber(String value) {
        this.loyaltyCardNumber = value;
        return this;
    }

    /**
     * The date of the second installment (YYYYMMDD)
     */
    public String getSecondInstallmentPaymentDate() {
        return secondInstallmentPaymentDate;
    }

    /**
     * The date of the second installment (YYYYMMDD)
     */
    public void setSecondInstallmentPaymentDate(String value) {
        this.secondInstallmentPaymentDate = value;
    }

    /**
     * The date of the second installment (YYYYMMDD)
     */
    public RedirectPaymentProduct5300SpecificInput withSecondInstallmentPaymentDate(String value) {
        this.secondInstallmentPaymentDate = value;
        return this;
    }

    /**
     * The duration of the session in seconds
     */
    public Integer getSessionDuration() {
        return sessionDuration;
    }

    /**
     * The duration of the session in seconds
     */
    public void setSessionDuration(Integer value) {
        this.sessionDuration = value;
    }

    /**
     * The duration of the session in seconds
     */
    public RedirectPaymentProduct5300SpecificInput withSessionDuration(Integer value) {
        this.sessionDuration = value;
        return this;
    }

    /**
     * Descriptive text that is used towards the customer, either during an online checkout at a third party or on the customer's statement.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Descriptive text that is used towards the customer, either during an online checkout at a third party or on the customer's statement.
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Descriptive text that is used towards the customer, either during an online checkout at a third party or on the customer's statement.
     */
    public RedirectPaymentProduct5300SpecificInput withTitle(String value) {
        this.title = value;
        return this;
    }
}
