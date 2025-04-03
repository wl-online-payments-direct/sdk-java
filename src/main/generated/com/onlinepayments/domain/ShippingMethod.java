/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class ShippingMethod {

    private String details;

    private String name;

    private Integer speed;

    private String type;

    /**
     * Details about the shipping method
     */
    public String getDetails() {
        return details;
    }

    /**
     * Details about the shipping method
     */
    public void setDetails(String value) {
        this.details = value;
    }

    /**
     * Details about the shipping method
     */
    public ShippingMethod withDetails(String value) {
        this.details = value;
        return this;
    }

    /**
     * Name of the shipping method
     */
    public String getName() {
        return name;
    }

    /**
     * Name of the shipping method
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Name of the shipping method
     */
    public ShippingMethod withName(String value) {
        this.name = value;
        return this;
    }

    /**
     * Number of hours to delivery
     */
    public Integer getSpeed() {
        return speed;
    }

    /**
     * Number of hours to delivery
     */
    public void setSpeed(Integer value) {
        this.speed = value;
    }

    /**
     * Number of hours to delivery
     */
    public ShippingMethod withSpeed(Integer value) {
        this.speed = value;
        return this;
    }

    /**
     * Shipping method type
     */
    public String getType() {
        return type;
    }

    /**
     * Shipping method type
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Shipping method type
     */
    public ShippingMethod withType(String value) {
        this.type = value;
        return this;
    }
}
