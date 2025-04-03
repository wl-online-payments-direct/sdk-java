/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class ProtectionEligibility {

    private String eligibility;

    private String type;

    /**
     * <ul>
     *   <li>Eligible - Merchant is protected by PayPal's Seller Protection Policy for Unauthorized Payment and Item Not Received</li>
     *   <li>PartiallyEligible - Merchant is protected by PayPal's Seller Protection Policy for Item Not Received</li>
     *   <li>Ineligible â€” Merchant is not protected under the Seller Protection Policy</li>
     * </ul>
     */
    public String getEligibility() {
        return eligibility;
    }

    /**
     * <ul>
     *   <li>Eligible - Merchant is protected by PayPal's Seller Protection Policy for Unauthorized Payment and Item Not Received</li>
     *   <li>PartiallyEligible - Merchant is protected by PayPal's Seller Protection Policy for Item Not Received</li>
     *   <li>Ineligible â€” Merchant is not protected under the Seller Protection Policy</li>
     * </ul>
     */
    public void setEligibility(String value) {
        this.eligibility = value;
    }

    /**
     * <ul>
     *   <li>Eligible - Merchant is protected by PayPal's Seller Protection Policy for Unauthorized Payment and Item Not Received</li>
     *   <li>PartiallyEligible - Merchant is protected by PayPal's Seller Protection Policy for Item Not Received</li>
     *   <li>Ineligible â€” Merchant is not protected under the Seller Protection Policy</li>
     * </ul>
     */
    public ProtectionEligibility withEligibility(String value) {
        this.eligibility = value;
        return this;
    }

    /**
     * <ul>
     *   <li>ItemNotReceivedEligible - Merchant is protected by PayPal's Seller Protection Policy for Item Not Received</li>
     *   <li>UnauthorizedPaymentEligible - Merchant is protected by PayPal's Seller Protection Policy for Unauthorized Payment</li>
     *   <li>Ineligible - Merchant is not protected under the Seller Protection Policy</li>
     * </ul>
     */
    public String getType() {
        return type;
    }

    /**
     * <ul>
     *   <li>ItemNotReceivedEligible - Merchant is protected by PayPal's Seller Protection Policy for Item Not Received</li>
     *   <li>UnauthorizedPaymentEligible - Merchant is protected by PayPal's Seller Protection Policy for Unauthorized Payment</li>
     *   <li>Ineligible - Merchant is not protected under the Seller Protection Policy</li>
     * </ul>
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * <ul>
     *   <li>ItemNotReceivedEligible - Merchant is protected by PayPal's Seller Protection Policy for Item Not Received</li>
     *   <li>UnauthorizedPaymentEligible - Merchant is protected by PayPal's Seller Protection Policy for Unauthorized Payment</li>
     *   <li>Ineligible - Merchant is not protected under the Seller Protection Policy</li>
     * </ul>
     */
    public ProtectionEligibility withType(String value) {
        this.type = value;
        return this;
    }
}
