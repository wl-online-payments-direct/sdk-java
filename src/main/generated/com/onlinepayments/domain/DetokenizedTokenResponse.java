/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class DetokenizedTokenResponse {

    private String cardBrand;

    private String cardExpiryDate;

    private String cardHolderName;

    private String encryptedCardNumber;

    private String paymentId;

    private String schemeReferenceData;

    private String token;

    /**
     * The brand of the card (e.g., VISA, MasterCard).
     */
    public String getCardBrand() {
        return cardBrand;
    }

    /**
     * The brand of the card (e.g., VISA, MasterCard).
     */
    public void setCardBrand(String value) {
        this.cardBrand = value;
    }

    /**
     * The brand of the card (e.g., VISA, MasterCard).
     */
    public DetokenizedTokenResponse withCardBrand(String value) {
        this.cardBrand = value;
        return this;
    }

    /**
     * The expiration date of the card in MMYY format, where MM represents the two-digit month and YY represents the two-digit year. For example, a value of 0529 indicates that the card expires in May 2029.
     */
    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    /**
     * The expiration date of the card in MMYY format, where MM represents the two-digit month and YY represents the two-digit year. For example, a value of 0529 indicates that the card expires in May 2029.
     */
    public void setCardExpiryDate(String value) {
        this.cardExpiryDate = value;
    }

    /**
     * The expiration date of the card in MMYY format, where MM represents the two-digit month and YY represents the two-digit year. For example, a value of 0529 indicates that the card expires in May 2029.
     */
    public DetokenizedTokenResponse withCardExpiryDate(String value) {
        this.cardExpiryDate = value;
        return this;
    }

    /**
     * The full name of the cardholder as it appears on the card.
     */
    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
     * The full name of the cardholder as it appears on the card.
     */
    public void setCardHolderName(String value) {
        this.cardHolderName = value;
    }

    /**
     * The full name of the cardholder as it appears on the card.
     */
    public DetokenizedTokenResponse withCardHolderName(String value) {
        this.cardHolderName = value;
        return this;
    }

    /**
     * The card number, encrypted and Base64 encoded for secure transport.
     */
    public String getEncryptedCardNumber() {
        return encryptedCardNumber;
    }

    /**
     * The card number, encrypted and Base64 encoded for secure transport.
     */
    public void setEncryptedCardNumber(String value) {
        this.encryptedCardNumber = value;
    }

    /**
     * The card number, encrypted and Base64 encoded for secure transport.
     */
    public DetokenizedTokenResponse withEncryptedCardNumber(String value) {
        this.encryptedCardNumber = value;
        return this;
    }

    /**
     * The unique identifier for the payment associated with the token is necessary for tracking.
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * The unique identifier for the payment associated with the token is necessary for tracking.
     */
    public void setPaymentId(String value) {
        this.paymentId = value;
    }

    /**
     * The unique identifier for the payment associated with the token is necessary for tracking.
     */
    public DetokenizedTokenResponse withPaymentId(String value) {
        this.paymentId = value;
        return this;
    }

    /**
     * Reference data associated with the payment scheme for the credentials on file.
     */
    public String getSchemeReferenceData() {
        return schemeReferenceData;
    }

    /**
     * Reference data associated with the payment scheme for the credentials on file.
     */
    public void setSchemeReferenceData(String value) {
        this.schemeReferenceData = value;
    }

    /**
     * Reference data associated with the payment scheme for the credentials on file.
     */
    public DetokenizedTokenResponse withSchemeReferenceData(String value) {
        this.schemeReferenceData = value;
        return this;
    }

    /**
     * The unique identifier for the token is required for processing.
     */
    public String getToken() {
        return token;
    }

    /**
     * The unique identifier for the token is required for processing.
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * The unique identifier for the token is required for processing.
     */
    public DetokenizedTokenResponse withToken(String value) {
        this.token = value;
        return this;
    }
}
