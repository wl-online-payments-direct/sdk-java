/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RedirectPaymentProduct3302SpecificInput {

    private String organizationEntityType;

    private String organizationRegistrationId;

    private String vatId;

    /**
     * This parameter defines the legal form of a business  and is mandatory in B2B transactions,  Accurate classification ensures compliance and optimized payment handling.
     */
    public String getOrganizationEntityType() {
        return organizationEntityType;
    }

    /**
     * This parameter defines the legal form of a business  and is mandatory in B2B transactions,  Accurate classification ensures compliance and optimized payment handling.
     */
    public void setOrganizationEntityType(String value) {
        this.organizationEntityType = value;
    }

    /**
     * This parameter defines the legal form of a business  and is mandatory in B2B transactions,  Accurate classification ensures compliance and optimized payment handling.
     */
    public RedirectPaymentProduct3302SpecificInput withOrganizationEntityType(String value) {
        this.organizationEntityType = value;
        return this;
    }

    /**
     * Unique identifier given by relevant authority verifying a business's legal registration. Mandatory in B2B transactions
     */
    public String getOrganizationRegistrationId() {
        return organizationRegistrationId;
    }

    /**
     * Unique identifier given by relevant authority verifying a business's legal registration. Mandatory in B2B transactions
     */
    public void setOrganizationRegistrationId(String value) {
        this.organizationRegistrationId = value;
    }

    /**
     * Unique identifier given by relevant authority verifying a business's legal registration. Mandatory in B2B transactions
     */
    public RedirectPaymentProduct3302SpecificInput withOrganizationRegistrationId(String value) {
        this.organizationRegistrationId = value;
        return this;
    }

    /**
     * Tax identification number used to validate a business's VAT compliance. Mandatory in B2B transactions
     */
    public String getVatId() {
        return vatId;
    }

    /**
     * Tax identification number used to validate a business's VAT compliance. Mandatory in B2B transactions
     */
    public void setVatId(String value) {
        this.vatId = value;
    }

    /**
     * Tax identification number used to validate a business's VAT compliance. Mandatory in B2B transactions
     */
    public RedirectPaymentProduct3302SpecificInput withVatId(String value) {
        this.vatId = value;
        return this;
    }
}
