/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CarRentalVehicleData {

    private String classId;

    private String identificationNumber;

    /**
     * This field contains a code that corresponds to the classification of the rental vehicle.
     */
    public String getClassId() {
        return classId;
    }

    /**
     * This field contains a code that corresponds to the classification of the rental vehicle.
     */
    public void setClassId(String value) {
        this.classId = value;
    }

    /**
     * This field contains a code that corresponds to the classification of the rental vehicle.
     */
    public CarRentalVehicleData withClassId(String value) {
        this.classId = value;
        return this;
    }

    /**
     * This field contains a unique identifier assigned by the taxi company to the vehicle.
     */
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * This field contains a unique identifier assigned by the taxi company to the vehicle.
     */
    public void setIdentificationNumber(String value) {
        this.identificationNumber = value;
    }

    /**
     * This field contains a unique identifier assigned by the taxi company to the vehicle.
     */
    public CarRentalVehicleData withIdentificationNumber(String value) {
        this.identificationNumber = value;
        return this;
    }
}
