/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class MandateAddressResponse {

    private String city;

    private String countryCode;

    private String houseNumber;

    private String street;

    private String zip;

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
    public MandateAddressResponse withCity(String value) {
        this.city = value;
        return this;
    }

    /**
     * ISO 3166-1 alpha-2 country code.
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * ISO 3166-1 alpha-2 country code.
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * ISO 3166-1 alpha-2 country code.
     */
    public MandateAddressResponse withCountryCode(String value) {
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
    public MandateAddressResponse withHouseNumber(String value) {
        this.houseNumber = value;
        return this;
    }

    /**
     * Streetname
     */
    public String getStreet() {
        return street;
    }

    /**
     * Streetname
     */
    public void setStreet(String value) {
        this.street = value;
    }

    /**
     * Streetname
     */
    public MandateAddressResponse withStreet(String value) {
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
    public MandateAddressResponse withZip(String value) {
        this.zip = value;
        return this;
    }
}
