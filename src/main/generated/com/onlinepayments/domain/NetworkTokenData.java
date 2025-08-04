/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class NetworkTokenData {

    private String cardholderName;

    private String cryptogram;

    private Integer eci;

    private String networkToken;

    private String schemeTokenRequestorId;

    private String tokenExpiryDate;

    /**
     * The card holder's name on the card associated with the Network Token.
     */
    public String getCardholderName() {
        return cardholderName;
    }

    /**
     * The card holder's name on the card associated with the Network Token.
     */
    public void setCardholderName(String value) {
        this.cardholderName = value;
    }

    /**
     * The card holder's name on the card associated with the Network Token.
     */
    public NetworkTokenData withCardholderName(String value) {
        this.cardholderName = value;
        return this;
    }

    /**
     * The Token Cryptogram is a dynamic one-time use value that is used to verify the authenticity of the transaction and the integrity of the data used in the generation of the Token Cryptogram. Visa calls this the Token Authentication Verification Value (TAVV) cryptogram.
     */
    public String getCryptogram() {
        return cryptogram;
    }

    /**
     * The Token Cryptogram is a dynamic one-time use value that is used to verify the authenticity of the transaction and the integrity of the data used in the generation of the Token Cryptogram. Visa calls this the Token Authentication Verification Value (TAVV) cryptogram.
     */
    public void setCryptogram(String value) {
        this.cryptogram = value;
    }

    /**
     * The Token Cryptogram is a dynamic one-time use value that is used to verify the authenticity of the transaction and the integrity of the data used in the generation of the Token Cryptogram. Visa calls this the Token Authentication Verification Value (TAVV) cryptogram.
     */
    public NetworkTokenData withCryptogram(String value) {
        this.cryptogram = value;
        return this;
    }

    /**
     * The Electronic Commerce Indicator you got with the Token Cryptogram.
     */
    public Integer getEci() {
        return eci;
    }

    /**
     * The Electronic Commerce Indicator you got with the Token Cryptogram.
     */
    public void setEci(Integer value) {
        this.eci = value;
    }

    /**
     * The Electronic Commerce Indicator you got with the Token Cryptogram.
     */
    public NetworkTokenData withEci(Integer value) {
        this.eci = value;
        return this;
    }

    /**
     * Payment Token associated with the Card used for the purchase.
     * Note: This is called Payment Token in the EMVCo documentation.
     */
    public String getNetworkToken() {
        return networkToken;
    }

    /**
     * Payment Token associated with the Card used for the purchase.
     * Note: This is called Payment Token in the EMVCo documentation.
     */
    public void setNetworkToken(String value) {
        this.networkToken = value;
    }

    /**
     * Payment Token associated with the Card used for the purchase.
     * Note: This is called Payment Token in the EMVCo documentation.
     */
    public NetworkTokenData withNetworkToken(String value) {
        this.networkToken = value;
        return this;
    }

    /**
     * Identifies the Token Requestor when calling the token service provider.
     */
    public String getSchemeTokenRequestorId() {
        return schemeTokenRequestorId;
    }

    /**
     * Identifies the Token Requestor when calling the token service provider.
     */
    public void setSchemeTokenRequestorId(String value) {
        this.schemeTokenRequestorId = value;
    }

    /**
     * Identifies the Token Requestor when calling the token service provider.
     */
    public NetworkTokenData withSchemeTokenRequestorId(String value) {
        this.schemeTokenRequestorId = value;
        return this;
    }

    /**
     * The expiry date of the network token.
     * Format: MMYY
     */
    public String getTokenExpiryDate() {
        return tokenExpiryDate;
    }

    /**
     * The expiry date of the network token.
     * Format: MMYY
     */
    public void setTokenExpiryDate(String value) {
        this.tokenExpiryDate = value;
    }

    /**
     * The expiry date of the network token.
     * Format: MMYY
     */
    public NetworkTokenData withTokenExpiryDate(String value) {
        this.tokenExpiryDate = value;
        return this;
    }
}
