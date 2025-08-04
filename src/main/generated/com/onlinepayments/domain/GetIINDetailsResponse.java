/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.time.LocalDate;
import java.util.List;

public class GetIINDetailsResponse {

    private Boolean cardCorporateIndicator;

    private LocalDate cardEffectiveDate;

    private Boolean cardEffectiveDateIndicator;

    private String cardPanType;

    private String cardProductCode;

    private String cardProductUsageLabel;

    private String cardScheme;

    private String cardType;

    private List<IINDetail> coBrands;

    private String countryCode;

    private Boolean isAllowedInContext;

    private String issuerCode;

    private String issuerName;

    private String issuingCountryCode;

    private Integer panLengthMax;

    private Integer panLengthMin;

    private Boolean panLuhnCheck;

    private Integer paymentProductId;

    /**
     * Indicates whether the card is an Enterprise / Commercial card or not
     */
    public Boolean getCardCorporateIndicator() {
        return cardCorporateIndicator;
    }

    /**
     * Indicates whether the card is an Enterprise / Commercial card or not
     */
    public void setCardCorporateIndicator(Boolean value) {
        this.cardCorporateIndicator = value;
    }

    /**
     * Indicates whether the card is an Enterprise / Commercial card or not
     */
    public GetIINDetailsResponse withCardCorporateIndicator(Boolean value) {
        this.cardCorporateIndicator = value;
        return this;
    }

    /**
     * The card effective date (YYYY-MM-DD)
     */
    public LocalDate getCardEffectiveDate() {
        return cardEffectiveDate;
    }

    /**
     * The card effective date (YYYY-MM-DD)
     */
    public void setCardEffectiveDate(LocalDate value) {
        this.cardEffectiveDate = value;
    }

    /**
     * The card effective date (YYYY-MM-DD)
     */
    public GetIINDetailsResponse withCardEffectiveDate(LocalDate value) {
        this.cardEffectiveDate = value;
        return this;
    }

    /**
     * Indicator of existence of a card effective date
     */
    public Boolean getCardEffectiveDateIndicator() {
        return cardEffectiveDateIndicator;
    }

    /**
     * Indicator of existence of a card effective date
     */
    public void setCardEffectiveDateIndicator(Boolean value) {
        this.cardEffectiveDateIndicator = value;
    }

    /**
     * Indicator of existence of a card effective date
     */
    public GetIINDetailsResponse withCardEffectiveDateIndicator(Boolean value) {
        this.cardEffectiveDateIndicator = value;
        return this;
    }

    /**
     * PAN type sent
     * <ul>
     *   <li>{@code dpan} Digital PAN</li>
     *   <li>{@code pan} Real PAN</li>
     * </ul>
     */
    public String getCardPanType() {
        return cardPanType;
    }

    /**
     * PAN type sent
     * <ul>
     *   <li>{@code dpan} Digital PAN</li>
     *   <li>{@code pan} Real PAN</li>
     * </ul>
     */
    public void setCardPanType(String value) {
        this.cardPanType = value;
    }

    /**
     * PAN type sent
     * <ul>
     *   <li>{@code dpan} Digital PAN</li>
     *   <li>{@code pan} Real PAN</li>
     * </ul>
     */
    public GetIINDetailsResponse withCardPanType(String value) {
        this.cardPanType = value;
        return this;
    }

    /**
     * Product code of the card
     */
    public String getCardProductCode() {
        return cardProductCode;
    }

    /**
     * Product code of the card
     */
    public void setCardProductCode(String value) {
        this.cardProductCode = value;
    }

    /**
     * Product code of the card
     */
    public GetIINDetailsResponse withCardProductCode(String value) {
        this.cardProductCode = value;
        return this;
    }

    /**
     * Profile name of the card which is displayed on payment electronic ticket in accordance with MPADS requirements
     * <ul>
     *   <li>{@code commercial} Business card</li>
     *   <li>{@code credit} Credit card</li>
     *   <li>{@code debit} Debit card</li>
     *   <li>{@code prepaid} Prepaid card</li>
     * </ul>
     */
    public String getCardProductUsageLabel() {
        return cardProductUsageLabel;
    }

    /**
     * Profile name of the card which is displayed on payment electronic ticket in accordance with MPADS requirements
     * <ul>
     *   <li>{@code commercial} Business card</li>
     *   <li>{@code credit} Credit card</li>
     *   <li>{@code debit} Debit card</li>
     *   <li>{@code prepaid} Prepaid card</li>
     * </ul>
     */
    public void setCardProductUsageLabel(String value) {
        this.cardProductUsageLabel = value;
    }

    /**
     * Profile name of the card which is displayed on payment electronic ticket in accordance with MPADS requirements
     * <ul>
     *   <li>{@code commercial} Business card</li>
     *   <li>{@code credit} Credit card</li>
     *   <li>{@code debit} Debit card</li>
     *   <li>{@code prepaid} Prepaid card</li>
     * </ul>
     */
    public GetIINDetailsResponse withCardProductUsageLabel(String value) {
        this.cardProductUsageLabel = value;
        return this;
    }

    /**
     * Network name associated with the card that is informational only and not to be coded against
     * <ul>
     *   <li>{@code AmericanExpress} American Express scheme</li>
     *   <li>{@code Bancontact} Bancontact scheme</li>
     *   <li>{@code Cb} Cartes Bancaires scheme</li>
     *   <li>{@code Cup} China UnionPay scheme</li>
     *   <li>{@code Dankort} Dankort scheme</li>
     *   <li>{@code DinersDiscover} Diners Discover scheme</li>
     *   <li>{@code Eftpos} eftpos scheme</li>
     *   <li>{@code Jcb} Japan Credit Bureau scheme</li>
     *   <li>{@code Mastercard} Mastercard scheme</li>
     *   <li>{@code Oney} Oney scheme</li>
     *   <li>{@code Uatp} Universal Air Travel Plan scheme</li>
     *   <li>{@code Visa} Visa scheme</li>
     * </ul>
     */
    public String getCardScheme() {
        return cardScheme;
    }

    /**
     * Network name associated with the card that is informational only and not to be coded against
     * <ul>
     *   <li>{@code AmericanExpress} American Express scheme</li>
     *   <li>{@code Bancontact} Bancontact scheme</li>
     *   <li>{@code Cb} Cartes Bancaires scheme</li>
     *   <li>{@code Cup} China UnionPay scheme</li>
     *   <li>{@code Dankort} Dankort scheme</li>
     *   <li>{@code DinersDiscover} Diners Discover scheme</li>
     *   <li>{@code Eftpos} eftpos scheme</li>
     *   <li>{@code Jcb} Japan Credit Bureau scheme</li>
     *   <li>{@code Mastercard} Mastercard scheme</li>
     *   <li>{@code Oney} Oney scheme</li>
     *   <li>{@code Uatp} Universal Air Travel Plan scheme</li>
     *   <li>{@code Visa} Visa scheme</li>
     * </ul>
     */
    public void setCardScheme(String value) {
        this.cardScheme = value;
    }

    /**
     * Network name associated with the card that is informational only and not to be coded against
     * <ul>
     *   <li>{@code AmericanExpress} American Express scheme</li>
     *   <li>{@code Bancontact} Bancontact scheme</li>
     *   <li>{@code Cb} Cartes Bancaires scheme</li>
     *   <li>{@code Cup} China UnionPay scheme</li>
     *   <li>{@code Dankort} Dankort scheme</li>
     *   <li>{@code DinersDiscover} Diners Discover scheme</li>
     *   <li>{@code Eftpos} eftpos scheme</li>
     *   <li>{@code Jcb} Japan Credit Bureau scheme</li>
     *   <li>{@code Mastercard} Mastercard scheme</li>
     *   <li>{@code Oney} Oney scheme</li>
     *   <li>{@code Uatp} Universal Air Travel Plan scheme</li>
     *   <li>{@code Visa} Visa scheme</li>
     * </ul>
     */
    public GetIINDetailsResponse withCardScheme(String value) {
        this.cardScheme = value;
        return this;
    }

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
     * Issuer code of the card
     */
    public String getIssuerCode() {
        return issuerCode;
    }

    /**
     * Issuer code of the card
     */
    public void setIssuerCode(String value) {
        this.issuerCode = value;
    }

    /**
     * Issuer code of the card
     */
    public GetIINDetailsResponse withIssuerCode(String value) {
        this.issuerCode = value;
        return this;
    }

    /**
     * Issuer name of the card
     */
    public String getIssuerName() {
        return issuerName;
    }

    /**
     * Issuer name of the card
     */
    public void setIssuerName(String value) {
        this.issuerName = value;
    }

    /**
     * Issuer name of the card
     */
    public GetIINDetailsResponse withIssuerName(String value) {
        this.issuerName = value;
        return this;
    }

    /**
     * ISO 3166-1 alpha-2 country code in which the card has been issued
     */
    public String getIssuingCountryCode() {
        return issuingCountryCode;
    }

    /**
     * ISO 3166-1 alpha-2 country code in which the card has been issued
     */
    public void setIssuingCountryCode(String value) {
        this.issuingCountryCode = value;
    }

    /**
     * ISO 3166-1 alpha-2 country code in which the card has been issued
     */
    public GetIINDetailsResponse withIssuingCountryCode(String value) {
        this.issuingCountryCode = value;
        return this;
    }

    /**
     * Maximum length of the PAN
     */
    public Integer getPanLengthMax() {
        return panLengthMax;
    }

    /**
     * Maximum length of the PAN
     */
    public void setPanLengthMax(Integer value) {
        this.panLengthMax = value;
    }

    /**
     * Maximum length of the PAN
     */
    public GetIINDetailsResponse withPanLengthMax(Integer value) {
        this.panLengthMax = value;
        return this;
    }

    /**
     * Minimal length of the PAN
     */
    public Integer getPanLengthMin() {
        return panLengthMin;
    }

    /**
     * Minimal length of the PAN
     */
    public void setPanLengthMin(Integer value) {
        this.panLengthMin = value;
    }

    /**
     * Minimal length of the PAN
     */
    public GetIINDetailsResponse withPanLengthMin(Integer value) {
        this.panLengthMin = value;
        return this;
    }

    /**
     * Indicates whether the PAN is controlled with Lühn Key algorithm
     */
    public Boolean getPanLuhnCheck() {
        return panLuhnCheck;
    }

    /**
     * Indicates whether the PAN is controlled with Lühn Key algorithm
     */
    public void setPanLuhnCheck(Boolean value) {
        this.panLuhnCheck = value;
    }

    /**
     * Indicates whether the PAN is controlled with Lühn Key algorithm
     */
    public GetIINDetailsResponse withPanLuhnCheck(Boolean value) {
        this.panLuhnCheck = value;
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
