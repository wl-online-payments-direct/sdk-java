/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CarRentalPickupReturnData {

    private String address;

    private String city;

    private Integer country;

    private String date;

    private String location;

    private String postcode;

    private String state;

    /**
     * Address of the pickup/return location
     */
    public String getAddress() {
        return address;
    }

    /**
     * Address of the pickup/return location
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Address of the pickup/return location
     */
    public CarRentalPickupReturnData withAddress(String value) {
        this.address = value;
        return this;
    }

    /**
     * City of the pickup/return location
     */
    public String getCity() {
        return city;
    }

    /**
     * City of the pickup/return location
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * City of the pickup/return location
     */
    public CarRentalPickupReturnData withCity(String value) {
        this.city = value;
        return this;
    }

    /**
     * Country of the pickup/return location ISO 3166-1 numeric
     */
    public Integer getCountry() {
        return country;
    }

    /**
     * Country of the pickup/return location ISO 3166-1 numeric
     */
    public void setCountry(Integer value) {
        this.country = value;
    }

    /**
     * Country of the pickup/return location ISO 3166-1 numeric
     */
    public CarRentalPickupReturnData withCountry(Integer value) {
        this.country = value;
        return this;
    }

    /**
     * UTC Time at which the vehicle was rented/picked up or returned.
     */
    public String getDate() {
        return date;
    }

    /**
     * UTC Time at which the vehicle was rented/picked up or returned.
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * UTC Time at which the vehicle was rented/picked up or returned.
     */
    public CarRentalPickupReturnData withDate(String value) {
        this.date = value;
        return this;
    }

    /**
     * This field contains data that uniquely identifies the location where the car was picked up or returned (e.g., DBA name, hotel, airport, etc.).
     */
    public String getLocation() {
        return location;
    }

    /**
     * This field contains data that uniquely identifies the location where the car was picked up or returned (e.g., DBA name, hotel, airport, etc.).
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * This field contains data that uniquely identifies the location where the car was picked up or returned (e.g., DBA name, hotel, airport, etc.).
     */
    public CarRentalPickupReturnData withLocation(String value) {
        this.location = value;
        return this;
    }

    /**
     * Postal code of the pickup/return location
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Postal code of the pickup/return location
     */
    public void setPostcode(String value) {
        this.postcode = value;
    }

    /**
     * Postal code of the pickup/return location
     */
    public CarRentalPickupReturnData withPostcode(String value) {
        this.postcode = value;
        return this;
    }

    /**
     * State/region of the pickup/return location
     */
    public String getState() {
        return state;
    }

    /**
     * State/region of the pickup/return location
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * State/region of the pickup/return location
     */
    public CarRentalPickupReturnData withState(String value) {
        this.state = value;
        return this;
    }
}
