/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class DecryptedPaymentData {

    private String cardholderName;

    private String cryptogram;

    private String dpan;

    private Integer eci;

    private String expiryDate;

    /**
     * Card holder's name on the card.
     * <ul>
     *   <li>For Apple Pay, maps to the cardholderName property in the encrypted payment data.</li>
     * </ul>
     */
    public String getCardholderName() {
        return cardholderName;
    }

    /**
     * Card holder's name on the card.
     * <ul>
     *   <li>For Apple Pay, maps to the cardholderName property in the encrypted payment data.</li>
     * </ul>
     */
    public void setCardholderName(String value) {
        this.cardholderName = value;
    }

    /**
     * Card holder's name on the card.
     * <ul>
     *   <li>For Apple Pay, maps to the cardholderName property in the encrypted payment data.</li>
     * </ul>
     */
    public DecryptedPaymentData withCardholderName(String value) {
        this.cardholderName = value;
        return this;
    }

    /**
     * The 3D secure online payment cryptogram.
     * <ul>
     *   <li>For Apple Pay, maps to the paymentData.onlinePaymentCryptogram property in the encrypted payment data.</li>
     *   <li>For Google Pay, maps to the paymentMethodDetails.3dsCryptogram property in the encrypted payment data.
     * Not allowed for Google Pay if the paymentMethod is CARD.</li>
     * </ul>
     */
    public String getCryptogram() {
        return cryptogram;
    }

    /**
     * The 3D secure online payment cryptogram.
     * <ul>
     *   <li>For Apple Pay, maps to the paymentData.onlinePaymentCryptogram property in the encrypted payment data.</li>
     *   <li>For Google Pay, maps to the paymentMethodDetails.3dsCryptogram property in the encrypted payment data.
     * Not allowed for Google Pay if the paymentMethod is CARD.</li>
     * </ul>
     */
    public void setCryptogram(String value) {
        this.cryptogram = value;
    }

    /**
     * The 3D secure online payment cryptogram.
     * <ul>
     *   <li>For Apple Pay, maps to the paymentData.onlinePaymentCryptogram property in the encrypted payment data.</li>
     *   <li>For Google Pay, maps to the paymentMethodDetails.3dsCryptogram property in the encrypted payment data.
     * Not allowed for Google Pay if the paymentMethod is CARD.</li>
     * </ul>
     */
    public DecryptedPaymentData withCryptogram(String value) {
        this.cryptogram = value;
        return this;
    }

    /**
     * The device specific PAN.
     * <ul>
     *   <li>For Apple Pay, maps to the applicationPrimaryAccountNumber property in the encrypted payment.</li>
     * </ul>
     */
    public String getDpan() {
        return dpan;
    }

    /**
     * The device specific PAN.
     * <ul>
     *   <li>For Apple Pay, maps to the applicationPrimaryAccountNumber property in the encrypted payment.</li>
     * </ul>
     */
    public void setDpan(String value) {
        this.dpan = value;
    }

    /**
     * The device specific PAN.
     * <ul>
     *   <li>For Apple Pay, maps to the applicationPrimaryAccountNumber property in the encrypted payment.</li>
     * </ul>
     */
    public DecryptedPaymentData withDpan(String value) {
        this.dpan = value;
        return this;
    }

    /**
     * Electronic Commerce Indicator.
     * <ul>
     *   <li>For Apple Pay, maps to the paymentData.eciIndicator property in the encrypted payment data.</li>
     * </ul>
     */
    public Integer getEci() {
        return eci;
    }

    /**
     * Electronic Commerce Indicator.
     * <ul>
     *   <li>For Apple Pay, maps to the paymentData.eciIndicator property in the encrypted payment data.</li>
     * </ul>
     */
    public void setEci(Integer value) {
        this.eci = value;
    }

    /**
     * Electronic Commerce Indicator.
     * <ul>
     *   <li>For Apple Pay, maps to the paymentData.eciIndicator property in the encrypted payment data.</li>
     * </ul>
     */
    public DecryptedPaymentData withEci(Integer value) {
        this.eci = value;
        return this;
    }

    /**
     * Expiry date of the card Format: MMYY.
     * <ul>
     *   <li>For Apple Pay, maps to the applicationExpirationDate property in the encrypted payment data. This property is formatted as YYMMDD, so this needs to be converted to get a correctly formatted expiry date</li>
     * </ul>
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Expiry date of the card Format: MMYY.
     * <ul>
     *   <li>For Apple Pay, maps to the applicationExpirationDate property in the encrypted payment data. This property is formatted as YYMMDD, so this needs to be converted to get a correctly formatted expiry date</li>
     * </ul>
     */
    public void setExpiryDate(String value) {
        this.expiryDate = value;
    }

    /**
     * Expiry date of the card Format: MMYY.
     * <ul>
     *   <li>For Apple Pay, maps to the applicationExpirationDate property in the encrypted payment data. This property is formatted as YYMMDD, so this needs to be converted to get a correctly formatted expiry date</li>
     * </ul>
     */
    public DecryptedPaymentData withExpiryDate(String value) {
        this.expiryDate = value;
        return this;
    }
}
