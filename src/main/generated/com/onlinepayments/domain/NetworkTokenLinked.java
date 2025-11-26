/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class NetworkTokenLinked {

    private String expiryDate;

    private String maskedToken;

    private String tokenState;

    /**
     * The expiry date of the network token.
     * Format: MMYY
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * The expiry date of the network token.
     * Format: MMYY
     */
    public void setExpiryDate(String value) {
        this.expiryDate = value;
    }

    /**
     * The expiry date of the network token.
     * Format: MMYY
     */
    public NetworkTokenLinked withExpiryDate(String value) {
        this.expiryDate = value;
        return this;
    }

    /**
     * The masked Payment Token associated with the Card used for the purchase.
     * Note: This is called Payment Token in the EMVCo documentation.
     */
    public String getMaskedToken() {
        return maskedToken;
    }

    /**
     * The masked Payment Token associated with the Card used for the purchase.
     * Note: This is called Payment Token in the EMVCo documentation.
     */
    public void setMaskedToken(String value) {
        this.maskedToken = value;
    }

    /**
     * The masked Payment Token associated with the Card used for the purchase.
     * Note: This is called Payment Token in the EMVCo documentation.
     */
    public NetworkTokenLinked withMaskedToken(String value) {
        this.maskedToken = value;
        return this;
    }

    /**
     * Describes the state of the linked network token:
     * <ul>
     *   <li>requested - A Network Token has been requested from the scheme.</li>
     *   <li>denied - A Network Token request has been denied from the scheme.</li>
     *   <li>active - The linked Network Token is active and can be used for the subsequent payment in the payment series.</li>
     *   <li>suspended - The linked Network Token is suspended and can not be used for the subsequent payment in the payment series. Instead PAN details would be used for the subsequent payment in the payment series.</li>
     *   <li>deleted - The linked Network Token is deleted and can not be used for the subsequent payment in the payment series. Instead PAN details would be used for the subsequent payment in the payment series.</li>
     *   <li>failed - An attempt was made to request a Network Token, but it was not successful.</li>
     * </ul>
     */
    public String getTokenState() {
        return tokenState;
    }

    /**
     * Describes the state of the linked network token:
     * <ul>
     *   <li>requested - A Network Token has been requested from the scheme.</li>
     *   <li>denied - A Network Token request has been denied from the scheme.</li>
     *   <li>active - The linked Network Token is active and can be used for the subsequent payment in the payment series.</li>
     *   <li>suspended - The linked Network Token is suspended and can not be used for the subsequent payment in the payment series. Instead PAN details would be used for the subsequent payment in the payment series.</li>
     *   <li>deleted - The linked Network Token is deleted and can not be used for the subsequent payment in the payment series. Instead PAN details would be used for the subsequent payment in the payment series.</li>
     *   <li>failed - An attempt was made to request a Network Token, but it was not successful.</li>
     * </ul>
     */
    public void setTokenState(String value) {
        this.tokenState = value;
    }

    /**
     * Describes the state of the linked network token:
     * <ul>
     *   <li>requested - A Network Token has been requested from the scheme.</li>
     *   <li>denied - A Network Token request has been denied from the scheme.</li>
     *   <li>active - The linked Network Token is active and can be used for the subsequent payment in the payment series.</li>
     *   <li>suspended - The linked Network Token is suspended and can not be used for the subsequent payment in the payment series. Instead PAN details would be used for the subsequent payment in the payment series.</li>
     *   <li>deleted - The linked Network Token is deleted and can not be used for the subsequent payment in the payment series. Instead PAN details would be used for the subsequent payment in the payment series.</li>
     *   <li>failed - An attempt was made to request a Network Token, but it was not successful.</li>
     * </ul>
     */
    public NetworkTokenLinked withTokenState(String value) {
        this.tokenState = value;
        return this;
    }
}
