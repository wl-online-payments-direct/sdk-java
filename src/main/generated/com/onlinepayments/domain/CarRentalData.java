/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import com.google.gson.annotations.SerializedName;

public class CarRentalData {

    private String agreementNumber;

    private Boolean cardholderNotified;

    private Long chargesAmount;

    private String chargesCategory;

    private Integer distanceMeasure;

    private String distanceUnit;

    private String driverIdentificationNumber;

    private String driverTaxNumber;

    private CarRentalPickupReturnData pickup;

    private Long rentalRateAmount;

    private String rentalRateType;

    private String renterName;

    @SerializedName("return")
    private CarRentalPickupReturnData returnValue;

    private Boolean taxExemptIndicator;

    private String tollFreeNumber;

    private CarRentalVehicleData vehicle;

    /**
     * This field contains the Auto Rental Agreement/Invoice Number (a.k.a., contract number) that corresponds to the rental agreement issued by the auto rental agency and signed by the cardholder. Amex =&lt; an1-20 characters MasterCard =&lt; an1-9 characters Visa =&lt; an25 characters
     */
    public String getAgreementNumber() {
        return agreementNumber;
    }

    /**
     * This field contains the Auto Rental Agreement/Invoice Number (a.k.a., contract number) that corresponds to the rental agreement issued by the auto rental agency and signed by the cardholder. Amex =&lt; an1-20 characters MasterCard =&lt; an1-9 characters Visa =&lt; an25 characters
     */
    public void setAgreementNumber(String value) {
        this.agreementNumber = value;
    }

    /**
     * This field contains the Auto Rental Agreement/Invoice Number (a.k.a., contract number) that corresponds to the rental agreement issued by the auto rental agency and signed by the cardholder. Amex =&lt; an1-20 characters MasterCard =&lt; an1-9 characters Visa =&lt; an25 characters
     */
    public CarRentalData withAgreementNumber(String value) {
        this.agreementNumber = value;
        return this;
    }

    /**
     * Cardholder has been notified of charge?
     */
    public Boolean getCardholderNotified() {
        return cardholderNotified;
    }

    /**
     * Cardholder has been notified of charge?
     */
    public void setCardholderNotified(Boolean value) {
        this.cardholderNotified = value;
    }

    /**
     * Cardholder has been notified of charge?
     */
    public CarRentalData withCardholderNotified(Boolean value) {
        this.cardholderNotified = value;
        return this;
    }

    /**
     * Fare amount (must be using currency of the transaction)
     */
    public Long getChargesAmount() {
        return chargesAmount;
    }

    /**
     * Fare amount (must be using currency of the transaction)
     */
    public void setChargesAmount(Long value) {
        this.chargesAmount = value;
    }

    /**
     * Fare amount (must be using currency of the transaction)
     */
    public CarRentalData withChargesAmount(Long value) {
        this.chargesAmount = value;
        return this;
    }

    /**
     * Indicates type of additional charges added to an cardholder’s bill after return.
     */
    public String getChargesCategory() {
        return chargesCategory;
    }

    /**
     * Indicates type of additional charges added to an cardholder’s bill after return.
     */
    public void setChargesCategory(String value) {
        this.chargesCategory = value;
    }

    /**
     * Indicates type of additional charges added to an cardholder’s bill after return.
     */
    public CarRentalData withChargesCategory(String value) {
        this.chargesCategory = value;
        return this;
    }

    /**
     * This field contains a value that corresponds to the distance traveled during the rental period. Amex =&lt; n1-5 MasterCard =&lt; n1-4 Visa =&lt; n1-5
     */
    public Integer getDistanceMeasure() {
        return distanceMeasure;
    }

    /**
     * This field contains a value that corresponds to the distance traveled during the rental period. Amex =&lt; n1-5 MasterCard =&lt; n1-4 Visa =&lt; n1-5
     */
    public void setDistanceMeasure(Integer value) {
        this.distanceMeasure = value;
    }

    /**
     * This field contains a value that corresponds to the distance traveled during the rental period. Amex =&lt; n1-5 MasterCard =&lt; n1-4 Visa =&lt; n1-5
     */
    public CarRentalData withDistanceMeasure(Integer value) {
        this.distanceMeasure = value;
        return this;
    }

    /**
     * This field contains a code that corresponds to the unit of measure applicable to the distance traveled.
     */
    public String getDistanceUnit() {
        return distanceUnit;
    }

    /**
     * This field contains a code that corresponds to the unit of measure applicable to the distance traveled.
     */
    public void setDistanceUnit(String value) {
        this.distanceUnit = value;
    }

    /**
     * This field contains a code that corresponds to the unit of measure applicable to the distance traveled.
     */
    public CarRentalData withDistanceUnit(String value) {
        this.distanceUnit = value;
        return this;
    }

    /**
     * Unique identifier of the driver
     */
    public String getDriverIdentificationNumber() {
        return driverIdentificationNumber;
    }

    /**
     * Unique identifier of the driver
     */
    public void setDriverIdentificationNumber(String value) {
        this.driverIdentificationNumber = value;
    }

    /**
     * Unique identifier of the driver
     */
    public CarRentalData withDriverIdentificationNumber(String value) {
        this.driverIdentificationNumber = value;
        return this;
    }

    /**
     * This field contains the driver's Tax Identification Number (Tax ID). Amex =&lt; an1-20 Visa =&lt; an1-20
     */
    public String getDriverTaxNumber() {
        return driverTaxNumber;
    }

    /**
     * This field contains the driver's Tax Identification Number (Tax ID). Amex =&lt; an1-20 Visa =&lt; an1-20
     */
    public void setDriverTaxNumber(String value) {
        this.driverTaxNumber = value;
    }

    /**
     * This field contains the driver's Tax Identification Number (Tax ID). Amex =&lt; an1-20 Visa =&lt; an1-20
     */
    public CarRentalData withDriverTaxNumber(String value) {
        this.driverTaxNumber = value;
        return this;
    }

    /**
     * Object containing specific data regarding the pickup or return of a rental car
     */
    public CarRentalPickupReturnData getPickup() {
        return pickup;
    }

    /**
     * Object containing specific data regarding the pickup or return of a rental car
     */
    public void setPickup(CarRentalPickupReturnData value) {
        this.pickup = value;
    }

    /**
     * Object containing specific data regarding the pickup or return of a rental car
     */
    public CarRentalData withPickup(CarRentalPickupReturnData value) {
        this.pickup = value;
        return this;
    }

    /**
     * Fare amount.
     */
    public Long getRentalRateAmount() {
        return rentalRateAmount;
    }

    /**
     * Fare amount.
     */
    public void setRentalRateAmount(Long value) {
        this.rentalRateAmount = value;
    }

    /**
     * Fare amount.
     */
    public CarRentalData withRentalRateAmount(Long value) {
        this.rentalRateAmount = value;
        return this;
    }

    /**
     * Indicates daily, weekly or monthly rental rate
     */
    public String getRentalRateType() {
        return rentalRateType;
    }

    /**
     * Indicates daily, weekly or monthly rental rate
     */
    public void setRentalRateType(String value) {
        this.rentalRateType = value;
    }

    /**
     * Indicates daily, weekly or monthly rental rate
     */
    public CarRentalData withRentalRateType(String value) {
        this.rentalRateType = value;
        return this;
    }

    /**
     * This field contains the name of the person or business entity charged for the reservation or vehicle rental.
     */
    public String getRenterName() {
        return renterName;
    }

    /**
     * This field contains the name of the person or business entity charged for the reservation or vehicle rental.
     */
    public void setRenterName(String value) {
        this.renterName = value;
    }

    /**
     * This field contains the name of the person or business entity charged for the reservation or vehicle rental.
     */
    public CarRentalData withRenterName(String value) {
        this.renterName = value;
        return this;
    }

    /**
     * Object containing specific data regarding the pickup or return of a rental car
     */
    public CarRentalPickupReturnData getReturnValue() {
        return returnValue;
    }

    /**
     * Object containing specific data regarding the pickup or return of a rental car
     */
    public void setReturnValue(CarRentalPickupReturnData value) {
        this.returnValue = value;
    }

    /**
     * Object containing specific data regarding the pickup or return of a rental car
     */
    public CarRentalData withReturnValue(CarRentalPickupReturnData value) {
        this.returnValue = value;
        return this;
    }

    /**
     * This field indicate the taxable status (taxable/tax exempt).
     */
    public Boolean getTaxExemptIndicator() {
        return taxExemptIndicator;
    }

    /**
     * This field indicate the taxable status (taxable/tax exempt).
     */
    public void setTaxExemptIndicator(Boolean value) {
        this.taxExemptIndicator = value;
    }

    /**
     * This field indicate the taxable status (taxable/tax exempt).
     */
    public CarRentalData withTaxExemptIndicator(Boolean value) {
        this.taxExemptIndicator = value;
        return this;
    }

    /**
     * Customer service toll free number.
     */
    public String getTollFreeNumber() {
        return tollFreeNumber;
    }

    /**
     * Customer service toll free number.
     */
    public void setTollFreeNumber(String value) {
        this.tollFreeNumber = value;
    }

    /**
     * Customer service toll free number.
     */
    public CarRentalData withTollFreeNumber(String value) {
        this.tollFreeNumber = value;
        return this;
    }

    /**
     * Object containing specific data regarding the vehicle
     */
    public CarRentalVehicleData getVehicle() {
        return vehicle;
    }

    /**
     * Object containing specific data regarding the vehicle
     */
    public void setVehicle(CarRentalVehicleData value) {
        this.vehicle = value;
    }

    /**
     * Object containing specific data regarding the vehicle
     */
    public CarRentalData withVehicle(CarRentalVehicleData value) {
        this.vehicle = value;
        return this;
    }
}
