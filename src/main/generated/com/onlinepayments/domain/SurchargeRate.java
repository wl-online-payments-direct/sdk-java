/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.math.BigDecimal;

public class SurchargeRate {

    private BigDecimal adValoremRate;

    private Integer specificRate;

    private String surchargeProductTypeId;

    private String surchargeProductTypeVersion;

    /**
     * A percentage rate defined on a merchant's configuration used in the calculation of a surcharge amount.
     */
    public BigDecimal getAdValoremRate() {
        return adValoremRate;
    }

    /**
     * A percentage rate defined on a merchant's configuration used in the calculation of a surcharge amount.
     */
    public void setAdValoremRate(BigDecimal value) {
        this.adValoremRate = value;
    }

    /**
     * A percentage rate defined on a merchant's configuration used in the calculation of a surcharge amount.
     */
    public SurchargeRate withAdValoremRate(BigDecimal value) {
        this.adValoremRate = value;
        return this;
    }

    /**
     * A specific, fixed rate in cents defined on a merchant's configuration that is used in the calculation of a surcharge amount.
     */
    public Integer getSpecificRate() {
        return specificRate;
    }

    /**
     * A specific, fixed rate in cents defined on a merchant's configuration that is used in the calculation of a surcharge amount.
     */
    public void setSpecificRate(Integer value) {
        this.specificRate = value;
    }

    /**
     * A specific, fixed rate in cents defined on a merchant's configuration that is used in the calculation of a surcharge amount.
     */
    public SurchargeRate withSpecificRate(Integer value) {
        this.specificRate = value;
        return this;
    }

    /**
     * The name of the applicable surcharge rates for the relevant payment product
     */
    public String getSurchargeProductTypeId() {
        return surchargeProductTypeId;
    }

    /**
     * The name of the applicable surcharge rates for the relevant payment product
     */
    public void setSurchargeProductTypeId(String value) {
        this.surchargeProductTypeId = value;
    }

    /**
     * The name of the applicable surcharge rates for the relevant payment product
     */
    public SurchargeRate withSurchargeProductTypeId(String value) {
        this.surchargeProductTypeId = value;
        return this;
    }

    /**
     * A specific version identifier of the surcharge rates as applied for this request
     */
    public String getSurchargeProductTypeVersion() {
        return surchargeProductTypeVersion;
    }

    /**
     * A specific version identifier of the surcharge rates as applied for this request
     */
    public void setSurchargeProductTypeVersion(String value) {
        this.surchargeProductTypeVersion = value;
    }

    /**
     * A specific version identifier of the surcharge rates as applied for this request
     */
    public SurchargeRate withSurchargeProductTypeVersion(String value) {
        this.surchargeProductTypeVersion = value;
        return this;
    }
}
