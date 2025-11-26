/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class NetworkTokenEssentials {

    private String bin;

    private String countryCode;

    private String networkToken;

    private String networkTokenState;

    private Boolean networkTokenUsed;

    private String tokenExpiryDate;

    /**
     * The first digits of the network token number from left to right with a minimum of 6 digits.
     */
    public String getBin() {
        return bin;
    }

    /**
     * The first digits of the network token number from left to right with a minimum of 6 digits.
     */
    public void setBin(String value) {
        this.bin = value;
    }

    /**
     * The first digits of the network token number from left to right with a minimum of 6 digits.
     */
    public NetworkTokenEssentials withBin(String value) {
        this.bin = value;
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
    public NetworkTokenEssentials withCountryCode(String value) {
        this.countryCode = value;
        return this;
    }

    /**
     * The masked Payment Token associated with the Card used for the purchase.
     * Note: This is called Payment Token in the EMVCo documentation.
     */
    public String getNetworkToken() {
        return networkToken;
    }

    /**
     * The masked Payment Token associated with the Card used for the purchase.
     * Note: This is called Payment Token in the EMVCo documentation.
     */
    public void setNetworkToken(String value) {
        this.networkToken = value;
    }

    /**
     * The masked Payment Token associated with the Card used for the purchase.
     * Note: This is called Payment Token in the EMVCo documentation.
     */
    public NetworkTokenEssentials withNetworkToken(String value) {
        this.networkToken = value;
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
    public String getNetworkTokenState() {
        return networkTokenState;
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
    public void setNetworkTokenState(String value) {
        this.networkTokenState = value;
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
    public NetworkTokenEssentials withNetworkTokenState(String value) {
        this.networkTokenState = value;
        return this;
    }

    /**
     * Whether or not a network token was used in the transaction
     */
    public Boolean getNetworkTokenUsed() {
        return networkTokenUsed;
    }

    /**
     * Whether or not a network token was used in the transaction
     */
    public void setNetworkTokenUsed(Boolean value) {
        this.networkTokenUsed = value;
    }

    /**
     * Whether or not a network token was used in the transaction
     */
    public NetworkTokenEssentials withNetworkTokenUsed(Boolean value) {
        this.networkTokenUsed = value;
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
    public NetworkTokenEssentials withTokenExpiryDate(String value) {
        this.tokenExpiryDate = value;
        return this;
    }
}
