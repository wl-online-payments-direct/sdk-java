package com.onlinepayments.it.util.mandates;

import com.onlinepayments.domain.BankAccountIban;
import com.onlinepayments.domain.CreateMandateRequest;
import com.onlinepayments.domain.MandateAddress;
import com.onlinepayments.domain.MandateContactDetails;
import com.onlinepayments.domain.MandateCustomer;
import com.onlinepayments.domain.MandatePersonalInformation;
import com.onlinepayments.domain.MandatePersonalName;

public class CreateMandateRequestBuilder {

    private String alias = "Test Mandate";
    private String customerIban = "BE45000253450589";
    private String companyName = "BEL Labs";
    private String emailAddress = "wile.e.coyote@acmelabs.com";
    private String city = "Brussels";
    private String countryCode = "BE";
    private String houseNumber = "3";
    private String street = "Da Vincilaan";
    private String zip = "1930";
    private String firstName = "Jane";
    private String surname = "Doe";
    private String title = "Mrs";
    private String customerReference = "CUST123";
    private String recurrenceType = "UNIQUE";
    private String signatureType = "UNSIGNED";
    private String returnUrl = "https://example-mandate-signing-url.com";
    private String uniqueMandateReference = "MANDATE123";

    public CreateMandateRequestBuilder withAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public CreateMandateRequestBuilder withCustomerIban(String customerIban) {
        this.customerIban = customerIban;
        return this;
    }

    public CreateMandateRequestBuilder withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public CreateMandateRequestBuilder withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public CreateMandateRequestBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public CreateMandateRequestBuilder withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public CreateMandateRequestBuilder withHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public CreateMandateRequestBuilder withStreet(String street) {
        this.street = street;
        return this;
    }

    public CreateMandateRequestBuilder withZip(String zip) {
        this.zip = zip;
        return this;
    }

    public CreateMandateRequestBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateMandateRequestBuilder withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public CreateMandateRequestBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public CreateMandateRequestBuilder withCustomerReference(String customerReference) {
        this.customerReference = customerReference;
        return this;
    }

    public CreateMandateRequestBuilder withRecurrenceType(String recurrenceType) {
        this.recurrenceType = recurrenceType;
        return this;
    }

    public CreateMandateRequestBuilder withSignatureType(String signatureType) {
        this.signatureType = signatureType;
        return this;
    }

    public CreateMandateRequestBuilder withReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }

    public CreateMandateRequestBuilder withUniqueMandateReference(String uniqueMandateReference) {
        this.uniqueMandateReference = uniqueMandateReference;
        return this;
    }

    public CreateMandateRequest build() {
        BankAccountIban bankAccount = new BankAccountIban()
                .withIban(customerIban);

        MandateContactDetails contactDetails = new MandateContactDetails()
                .withEmailAddress(emailAddress);

        MandateAddress mandateAddress = new MandateAddress()
                .withCity(city)
                .withCountryCode(countryCode)
                .withHouseNumber(houseNumber)
                .withStreet(street)
                .withZip(zip);

        MandatePersonalName personalName = new MandatePersonalName()
                .withFirstName(firstName)
                .withSurname(surname);

        MandatePersonalInformation personalInformation = new MandatePersonalInformation()
                .withName(personalName)
                .withTitle(title);

        MandateCustomer customer = new MandateCustomer()
                .withBankAccountIban(bankAccount)
                .withCompanyName(companyName)
                .withContactDetails(contactDetails)
                .withMandateAddress(mandateAddress)
                .withPersonalInformation(personalInformation);

        return new CreateMandateRequest()
                .withAlias(alias)
                .withCustomer(customer)
                .withCustomerReference(customerReference)
                .withRecurrenceType(recurrenceType)
                .withSignatureType(signatureType)
                .withReturnUrl(returnUrl)
                .withUniqueMandateReference(uniqueMandateReference);
    }
}
