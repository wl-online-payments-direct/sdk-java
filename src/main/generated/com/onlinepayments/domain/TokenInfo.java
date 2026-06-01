/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class TokenInfo {

    private String expiryDate;

    private Boolean isTemporary;

    private String maskedPan;

    private String tokenId;

    /**
     * The expiry date of the network token.
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * The expiry date of the network token.
     */
    public void setExpiryDate(String value) {
        this.expiryDate = value;
    }

    /**
     * The expiry date of the network token.
     */
    public TokenInfo withExpiryDate(String value) {
        this.expiryDate = value;
        return this;
    }

    /**
     * Temporary tokens have a lifespan of two hours and can only be used once.
     */
    public Boolean getIsTemporary() {
        return isTemporary;
    }

    /**
     * Temporary tokens have a lifespan of two hours and can only be used once.
     */
    public void setIsTemporary(Boolean value) {
        this.isTemporary = value;
    }

    /**
     * Temporary tokens have a lifespan of two hours and can only be used once.
     */
    public TokenInfo withIsTemporary(Boolean value) {
        this.isTemporary = value;
        return this;
    }

    /**
     * The masked Primary Account Number (PAN).
     */
    public String getMaskedPan() {
        return maskedPan;
    }

    /**
     * The masked Primary Account Number (PAN).
     */
    public void setMaskedPan(String value) {
        this.maskedPan = value;
    }

    /**
     * The masked Primary Account Number (PAN).
     */
    public TokenInfo withMaskedPan(String value) {
        this.maskedPan = value;
        return this;
    }

    /**
     * ID of the token
     */
    public String getTokenId() {
        return tokenId;
    }

    /**
     * ID of the token
     */
    public void setTokenId(String value) {
        this.tokenId = value;
    }

    /**
     * ID of the token
     */
    public TokenInfo withTokenId(String value) {
        this.tokenId = value;
        return this;
    }
}
