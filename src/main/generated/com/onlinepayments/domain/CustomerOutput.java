/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CustomerOutput {

    private CustomerDeviceOutput device;

    /**
     * Object containing information on the device and browser of the customer
     */
    public CustomerDeviceOutput getDevice() {
        return device;
    }

    /**
     * Object containing information on the device and browser of the customer
     */
    public void setDevice(CustomerDeviceOutput value) {
        this.device = value;
    }

    /**
     * Object containing information on the device and browser of the customer
     */
    public CustomerOutput withDevice(CustomerDeviceOutput value) {
        this.device = value;
        return this;
    }
}
