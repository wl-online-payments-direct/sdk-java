/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RedirectPaymentProduct900SpecificInput {

    private String captureTrigger;

    /**
     * Display your customers in the Wero portal when you will capture the transaction. Mandatory only for requests in authorisation mode. Possible values:
     * <ul>
     *   <li>shipping - Upon shipping the order.</li>
     *   <li>delivery - Upon delivering the order.</li>
     *   <li>availability - As soon as the order is available.</li>
     *   <li>serviceFulfilment - Upon fulfilling the service.</li>
     *   <li>other - For any other use case.</li>
     * </ul>
     */
    public String getCaptureTrigger() {
        return captureTrigger;
    }

    /**
     * Display your customers in the Wero portal when you will capture the transaction. Mandatory only for requests in authorisation mode. Possible values:
     * <ul>
     *   <li>shipping - Upon shipping the order.</li>
     *   <li>delivery - Upon delivering the order.</li>
     *   <li>availability - As soon as the order is available.</li>
     *   <li>serviceFulfilment - Upon fulfilling the service.</li>
     *   <li>other - For any other use case.</li>
     * </ul>
     */
    public void setCaptureTrigger(String value) {
        this.captureTrigger = value;
    }

    /**
     * Display your customers in the Wero portal when you will capture the transaction. Mandatory only for requests in authorisation mode. Possible values:
     * <ul>
     *   <li>shipping - Upon shipping the order.</li>
     *   <li>delivery - Upon delivering the order.</li>
     *   <li>availability - As soon as the order is available.</li>
     *   <li>serviceFulfilment - Upon fulfilling the service.</li>
     *   <li>other - For any other use case.</li>
     * </ul>
     */
    public RedirectPaymentProduct900SpecificInput withCaptureTrigger(String value) {
        this.captureTrigger = value;
        return this;
    }
}
