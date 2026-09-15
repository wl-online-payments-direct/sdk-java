/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class UpdateAuthorizationAdditionalDataRequest {

    private CarRentalData carRentalData;

    /**
     * Object that holds car rental specific data
     */
    public CarRentalData getCarRentalData() {
        return carRentalData;
    }

    /**
     * Object that holds car rental specific data
     */
    public void setCarRentalData(CarRentalData value) {
        this.carRentalData = value;
    }

    /**
     * Object that holds car rental specific data
     */
    public UpdateAuthorizationAdditionalDataRequest withCarRentalData(CarRentalData value) {
        this.carRentalData = value;
        return this;
    }
}
