/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.time.LocalDate;

public class CardEssentials {

    private String bin;

    private Boolean cardCorporateIndicator;

    private LocalDate cardEffectiveDate;

    private Boolean cardEffectiveDateIndicator;

    private String cardNumber;

    private String cardPanType;

    private String cardProductCode;

    private String cardProductUsageLabel;

    private String cardScheme;

    private String cardType;

    private String countryCode;

    private String expiryDate;

    private String issuerCode;

    private String issuerName;

    private String issuingCountryCode;

    private Integer panLengthMax;

    private Integer panLengthMin;

    private Boolean panLuhnCheck;

    /**
     * The first digits of the credit card number from left to right with a minimum of 6 digits.
     */
    public String getBin() {
        return bin;
    }

    /**
     * The first digits of the credit card number from left to right with a minimum of 6 digits.
     */
    public void setBin(String value) {
        this.bin = value;
    }

    /**
     * The first digits of the credit card number from left to right with a minimum of 6 digits.
     */
    public CardEssentials withBin(String value) {
        this.bin = value;
        return this;
    }

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
    public CardEssentials withCardCorporateIndicator(Boolean value) {
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
    public CardEssentials withCardEffectiveDate(LocalDate value) {
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
    public CardEssentials withCardEffectiveDateIndicator(Boolean value) {
        this.cardEffectiveDateIndicator = value;
        return this;
    }

    /**
     * The masked credit/debit card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * The masked credit/debit card number
     */
    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    /**
     * The masked credit/debit card number
     */
    public CardEssentials withCardNumber(String value) {
        this.cardNumber = value;
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
    public CardEssentials withCardPanType(String value) {
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
    public CardEssentials withCardProductCode(String value) {
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
    public CardEssentials withCardProductUsageLabel(String value) {
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
    public CardEssentials withCardScheme(String value) {
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
    public CardEssentials withCardType(String value) {
        this.cardType = value;
        return this;
    }

    /**
     * ISO 3166-1 alpha-2 country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * ISO 3166-1 alpha-2 country code
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * ISO 3166-1 alpha-2 country code
     */
    public CardEssentials withCountryCode(String value) {
        this.countryCode = value;
        return this;
    }

    /**
     * Expiry date of the card
     * Format: MMYY
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Expiry date of the card
     * Format: MMYY
     */
    public void setExpiryDate(String value) {
        this.expiryDate = value;
    }

    /**
     * Expiry date of the card
     * Format: MMYY
     */
    public CardEssentials withExpiryDate(String value) {
        this.expiryDate = value;
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
    public CardEssentials withIssuerCode(String value) {
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
    public CardEssentials withIssuerName(String value) {
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
    public CardEssentials withIssuingCountryCode(String value) {
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
    public CardEssentials withPanLengthMax(Integer value) {
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
    public CardEssentials withPanLengthMin(Integer value) {
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
    public CardEssentials withPanLuhnCheck(Boolean value) {
        this.panLuhnCheck = value;
        return this;
    }
}
