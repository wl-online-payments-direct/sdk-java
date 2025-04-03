/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class Address {

    private String additionalInfo;

    private String city;

    private String countryCode;

    private String houseNumber;

    private String state;

    private String street;

    private String zip;

    /**
     * Second line of street or additional address information
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Second line of street or additional address information
     */
    public void setAdditionalInfo(String value) {
        this.additionalInfo = value;
    }

    /**
     * Second line of street or additional address information
     */
    public Address withAdditionalInfo(String value) {
        this.additionalInfo = value;
        return this;
    }

    /**
     * City
     */
    public String getCity() {
        return city;
    }

    /**
     * City
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * City
     */
    public Address withCity(String value) {
        this.city = value;
        return this;
    }

    /**
     * ISO 3166-1 alpha-2 country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * ISO 3166-1 alpha-2 country code
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * ISO 3166-1 alpha-2 country code
     */
    public Address withCountryCode(String value) {
        this.countryCode = value;
        return this;
    }

    /**
     * House number
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * House number
     */
    public void setHouseNumber(String value) {
        this.houseNumber = value;
    }

    /**
     * House number
     */
    public Address withHouseNumber(String value) {
        this.houseNumber = value;
        return this;
    }

    /**
     * ISO 3166-2 country subdivision code
     */
    public String getState() {
        return state;
    }

    /**
     * ISO 3166-2 country subdivision code
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * ISO 3166-2 country subdivision code
     */
    public Address withState(String value) {
        this.state = value;
        return this;
    }

    /**
     * Street name
     */
    public String getStreet() {
        return street;
    }

    /**
     * Street name
     */
    public void setStreet(String value) {
        this.street = value;
    }

    /**
     * Street name
     */
    public Address withStreet(String value) {
        this.street = value;
        return this;
    }

    /**
     * Zip code
     */
    public String getZip() {
        return zip;
    }

    /**
     * Zip code
     */
    public void setZip(String value) {
        this.zip = value;
    }

    /**
     * Zip code
     */
    public Address withZip(String value) {
        this.zip = value;
        return this;
    }
}
