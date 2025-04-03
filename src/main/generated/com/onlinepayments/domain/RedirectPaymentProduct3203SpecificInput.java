/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RedirectPaymentProduct3203SpecificInput {

    private String checkoutType;

    /**
     * Determines the type of the checkout that will be used for PostFinancePay. Allowed values:
     * <ul>
     *   <li>default - The user will be redirected to the PostFinancePay application to complete the payment.</li>
     *   <li>expressCheckout -  In order to accelerate the payment process, the shipping and billing addresses are requested
     * from the payer's PostFinancePay account. These will be returned in the API response in
     * paymentProduct3203SpecificOutput. Note that the payer must accept to provide his
     * billing and shipping address during checkout in the PostFinancePay application.
     * If not, the payment will be declined.</li>
     * </ul>
     */
    public String getCheckoutType() {
        return checkoutType;
    }

    /**
     * Determines the type of the checkout that will be used for PostFinancePay. Allowed values:
     * <ul>
     *   <li>default - The user will be redirected to the PostFinancePay application to complete the payment.</li>
     *   <li>expressCheckout -  In order to accelerate the payment process, the shipping and billing addresses are requested
     * from the payer's PostFinancePay account. These will be returned in the API response in
     * paymentProduct3203SpecificOutput. Note that the payer must accept to provide his
     * billing and shipping address during checkout in the PostFinancePay application.
     * If not, the payment will be declined.</li>
     * </ul>
     */
    public void setCheckoutType(String value) {
        this.checkoutType = value;
    }

    /**
     * Determines the type of the checkout that will be used for PostFinancePay. Allowed values:
     * <ul>
     *   <li>default - The user will be redirected to the PostFinancePay application to complete the payment.</li>
     *   <li>expressCheckout -  In order to accelerate the payment process, the shipping and billing addresses are requested
     * from the payer's PostFinancePay account. These will be returned in the API response in
     * paymentProduct3203SpecificOutput. Note that the payer must accept to provide his
     * billing and shipping address during checkout in the PostFinancePay application.
     * If not, the payment will be declined.</li>
     * </ul>
     */
    public RedirectPaymentProduct3203SpecificInput withCheckoutType(String value) {
        this.checkoutType = value;
        return this;
    }
}
