package com.onlinepayments.it.util.preAuthorization;

import com.onlinepayments.domain.CarRentalData;
import com.onlinepayments.domain.CarRentalPickupReturnData;
import com.onlinepayments.domain.CarRentalVehicleData;
import com.onlinepayments.domain.UpdateAuthorizationAdditionalDataRequest;

public class UpdateAuthorizationAdditionalDataRequestBuilder {

    private String chargesCategory = "gas";
    private boolean minimal;

    public UpdateAuthorizationAdditionalDataRequestBuilder withChargesCategory(String chargesCategory) {
        this.chargesCategory = chargesCategory;
        return this;
    }

    public UpdateAuthorizationAdditionalDataRequestBuilder withMinimalCarRentalData() {
        this.minimal = true;
        return this;
    }

    public UpdateAuthorizationAdditionalDataRequest build() {
        return new UpdateAuthorizationAdditionalDataRequest()
            .withCarRentalData(minimal ? buildMinimalCarRentalData() : buildFullCarRentalData());
    }

    private CarRentalData buildMinimalCarRentalData() {
        return new CarRentalData()
            .withAgreementNumber("A1234567")
            .withChargesAmount(0L)
            .withChargesCategory(chargesCategory)
            .withPickupDetails(buildPickupDetails())
            .withReturnDetails(buildReturnDetails())
            .withRentalRateAmount(1000L)
            .withRentalRateType("daily")
            .withRenterName("Wile E. Coyote");
    }

    private CarRentalData buildFullCarRentalData() {
        return buildMinimalCarRentalData()
            .withCardholderNotified(true)
            .withDistanceMeasure(250)
            .withDistanceUnit("kilometers")
            .withDriverIdentificationNumber("DRV123456")
            .withDriverTaxNumber("BE0123456789")
            .withTaxExemptIndicator(false)
            .withTollFreeNumber("0800123456")
            .withVehicle(new CarRentalVehicleData()
                .withClassId("CDMR")
                .withIdentificationNumber("VIN123456"));
    }

    private CarRentalPickupReturnData buildPickupDetails() {
        return new CarRentalPickupReturnData()
            .withAddress("Da Vincilaan 3")
            .withCity("Brussels")
            .withCountry(56)
            .withDate("2026-09-28T090000.000Z")
            .withLocation("Brussels Airport")
            .withPostcode("1930")
            .withState("Flemish Brabant");
    }

    private CarRentalPickupReturnData buildReturnDetails() {
        return new CarRentalPickupReturnData()
            .withAddress("Da Vincilaan 3")
            .withCity("Brussels")
            .withCountry(56)
            .withDate("2026-09-30T090000.000Z")
            .withLocation("Brussels Airport")
            .withPostcode("1930")
            .withState("Flemish Brabant");
    }
}
