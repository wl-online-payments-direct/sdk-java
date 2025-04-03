/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class AddressPersonal {

    private String additionalInfo;

    private String city;

    private String companyName;

    private String countryCode;

    private String houseNumber;

    private PersonalName name;

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
    public AddressPersonal withAdditionalInfo(String value) {
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
    public AddressPersonal withCity(String value) {
        this.city = value;
        return this;
    }

    /**
     * Company Name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Company Name
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    /**
     * Company Name
     */
    public AddressPersonal withCompanyName(String value) {
        this.companyName = value;
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
    public AddressPersonal withCountryCode(String value) {
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
    public AddressPersonal withHouseNumber(String value) {
        this.houseNumber = value;
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
    public AddressPersonal withName(PersonalName value) {
        this.name = value;
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
    public AddressPersonal withState(String value) {
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
    public AddressPersonal withStreet(String value) {
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
    public AddressPersonal withZip(String value) {
        this.zip = value;
        return this;
    }
}
