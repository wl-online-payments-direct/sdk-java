/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class GetIINDetailsResponse {

    private String cardType;

    private List<IINDetail> coBrands;

    private String countryCode;

    private Boolean isAllowedInContext;

    private Integer paymentProductId;

    /**
     * The card's type as categorised by the payment method. Possible values are:
     * <ul>
     *   <li>Credit</li>
     *   <li>Debit</li>
     *   <li>Prepaid</li>
     * </ul>
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * The card's type as categorised by the payment method. Possible values are:
     * <ul>
     *   <li>Credit</li>
     *   <li>Debit</li>
     *   <li>Prepaid</li>
     * </ul>
     */
    public void setCardType(String value) {
        this.cardType = value;
    }

    /**
     * The card's type as categorised by the payment method. Possible values are:
     * <ul>
     *   <li>Credit</li>
     *   <li>Debit</li>
     *   <li>Prepaid</li>
     * </ul>
     */
    public GetIINDetailsResponse withCardType(String value) {
        this.cardType = value;
        return this;
    }

    /**
     * List of IIN details
     */
    public List<IINDetail> getCoBrands() {
        return coBrands;
    }

    /**
     * List of IIN details
     */
    public void setCoBrands(List<IINDetail> value) {
        this.coBrands = value;
    }

    /**
     * List of IIN details
     */
    public GetIINDetailsResponse withCoBrands(List<IINDetail> value) {
        this.coBrands = value;
        return this;
    }

    /**
     * The ISO 3166-1 alpha-2 country code of the country where the card was issued. If we do not know where the card was issued, then the countryCode will return the value '99'.
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * The ISO 3166-1 alpha-2 country code of the country where the card was issued. If we do not know where the card was issued, then the countryCode will return the value '99'.
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * The ISO 3166-1 alpha-2 country code of the country where the card was issued. If we do not know where the card was issued, then the countryCode will return the value '99'.
     */
    public GetIINDetailsResponse withCountryCode(String value) {
        this.countryCode = value;
        return this;
    }

    /**
     * Populated only if you submitted a payment context.
     * <ul>
     *   <li>true - The payment product is allowed in the submitted context.</li>
     *   <li>false - The payment product is not allowed in the submitted context. Note that in this case, none of the brands of the card will be allowed in the submitted context.</li>
     * </ul>
     */
    public Boolean getIsAllowedInContext() {
        return isAllowedInContext;
    }

    /**
     * Populated only if you submitted a payment context.
     * <ul>
     *   <li>true - The payment product is allowed in the submitted context.</li>
     *   <li>false - The payment product is not allowed in the submitted context. Note that in this case, none of the brands of the card will be allowed in the submitted context.</li>
     * </ul>
     */
    public void setIsAllowedInContext(Boolean value) {
        this.isAllowedInContext = value;
    }

    /**
     * Populated only if you submitted a payment context.
     * <ul>
     *   <li>true - The payment product is allowed in the submitted context.</li>
     *   <li>false - The payment product is not allowed in the submitted context. Note that in this case, none of the brands of the card will be allowed in the submitted context.</li>
     * </ul>
     */
    public GetIINDetailsResponse withIsAllowedInContext(Boolean value) {
        this.isAllowedInContext = value;
        return this;
    }

    /**
     * Payment product identifier - Please see Products documentation for a full overview of possible values.
     */
    public Integer getPaymentProductId() {
        return paymentProductId;
    }

    /**
     * Payment product identifier - Please see Products documentation for a full overview of possible values.
     */
    public void setPaymentProductId(Integer value) {
        this.paymentProductId = value;
    }

    /**
     * Payment product identifier - Please see Products documentation for a full overview of possible values.
     */
    public GetIINDetailsResponse withPaymentProductId(Integer value) {
        this.paymentProductId = value;
        return this;
    }
}
