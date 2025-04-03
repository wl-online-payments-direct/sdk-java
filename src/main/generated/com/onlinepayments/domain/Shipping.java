/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class Shipping {

    private AddressPersonal address;

    private String addressIndicator;

    private String emailAddress;

    private String firstUsageDate;

    private Boolean isFirstUsage;

    private ShippingMethod method;

    private Long shippingCost;

    private Long shippingCostTax;

    private String type;

    /**
     * Object containing address information
     */
    public AddressPersonal getAddress() {
        return address;
    }

    /**
     * Object containing address information
     */
    public void setAddress(AddressPersonal value) {
        this.address = value;
    }

    /**
     * Object containing address information
     */
    public Shipping withAddress(AddressPersonal value) {
        this.address = value;
        return this;
    }

    /**
     * Indicates shipping method chosen for the transaction. Possible values:
     * <ul>
     *   <li>same-as-billing = the shipping address is the same as the billing address</li>
     *   <li>another-verified-address-on-file-with-merchant = the address used for shipping is another verified address of the customer that is on file with you</li>
     *   <li>different-than-billing = shipping address is different from the billing address</li>
     *   <li>ship-to-store = goods are shipped to a store (shipping address = store address)</li>
     *   <li>digital-goods = electronic delivery of digital goods</li>
     *   <li>travel-and-event-tickets-not-shipped = travel and/or event tickets that are not shipped</li>
     *   <li>other = other means of delivery</li>
     * </ul>
     */
    public String getAddressIndicator() {
        return addressIndicator;
    }

    /**
     * Indicates shipping method chosen for the transaction. Possible values:
     * <ul>
     *   <li>same-as-billing = the shipping address is the same as the billing address</li>
     *   <li>another-verified-address-on-file-with-merchant = the address used for shipping is another verified address of the customer that is on file with you</li>
     *   <li>different-than-billing = shipping address is different from the billing address</li>
     *   <li>ship-to-store = goods are shipped to a store (shipping address = store address)</li>
     *   <li>digital-goods = electronic delivery of digital goods</li>
     *   <li>travel-and-event-tickets-not-shipped = travel and/or event tickets that are not shipped</li>
     *   <li>other = other means of delivery</li>
     * </ul>
     */
    public void setAddressIndicator(String value) {
        this.addressIndicator = value;
    }

    /**
     * Indicates shipping method chosen for the transaction. Possible values:
     * <ul>
     *   <li>same-as-billing = the shipping address is the same as the billing address</li>
     *   <li>another-verified-address-on-file-with-merchant = the address used for shipping is another verified address of the customer that is on file with you</li>
     *   <li>different-than-billing = shipping address is different from the billing address</li>
     *   <li>ship-to-store = goods are shipped to a store (shipping address = store address)</li>
     *   <li>digital-goods = electronic delivery of digital goods</li>
     *   <li>travel-and-event-tickets-not-shipped = travel and/or event tickets that are not shipped</li>
     *   <li>other = other means of delivery</li>
     * </ul>
     */
    public Shipping withAddressIndicator(String value) {
        this.addressIndicator = value;
        return this;
    }

    /**
     * Email address linked to the shipping
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Email address linked to the shipping
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Email address linked to the shipping
     */
    public Shipping withEmailAddress(String value) {
        this.emailAddress = value;
        return this;
    }

    /**
     * Date (YYYYMMDD) when the shipping details for this transaction were first used.
     */
    public String getFirstUsageDate() {
        return firstUsageDate;
    }

    /**
     * Date (YYYYMMDD) when the shipping details for this transaction were first used.
     */
    public void setFirstUsageDate(String value) {
        this.firstUsageDate = value;
    }

    /**
     * Date (YYYYMMDD) when the shipping details for this transaction were first used.
     */
    public Shipping withFirstUsageDate(String value) {
        this.firstUsageDate = value;
        return this;
    }

    /**
     * Indicator if this shipping address is used for the first time to ship an order
     * <p>
     * true = the shipping details are used for the first time with this transaction
     * <p>
     * false = the shipping details have been used for other transactions in the past
     */
    public Boolean getIsFirstUsage() {
        return isFirstUsage;
    }

    /**
     * Indicator if this shipping address is used for the first time to ship an order
     * <p>
     * true = the shipping details are used for the first time with this transaction
     * <p>
     * false = the shipping details have been used for other transactions in the past
     */
    public void setIsFirstUsage(Boolean value) {
        this.isFirstUsage = value;
    }

    /**
     * Indicator if this shipping address is used for the first time to ship an order
     * <p>
     * true = the shipping details are used for the first time with this transaction
     * <p>
     * false = the shipping details have been used for other transactions in the past
     */
    public Shipping withIsFirstUsage(Boolean value) {
        this.isFirstUsage = value;
        return this;
    }

    /**
     * Object containing information regarding shipping method
     */
    public ShippingMethod getMethod() {
        return method;
    }

    /**
     * Object containing information regarding shipping method
     */
    public void setMethod(ShippingMethod value) {
        this.method = value;
    }

    /**
     * Object containing information regarding shipping method
     */
    public Shipping withMethod(ShippingMethod value) {
        this.method = value;
        return this;
    }

    /**
     * Cost associated with the shipping of the order.
     */
    public Long getShippingCost() {
        return shippingCost;
    }

    /**
     * Cost associated with the shipping of the order.
     */
    public void setShippingCost(Long value) {
        this.shippingCost = value;
    }

    /**
     * Cost associated with the shipping of the order.
     */
    public Shipping withShippingCost(Long value) {
        this.shippingCost = value;
        return this;
    }

    /**
     * Tax amount of the shipping cost.
     */
    public Long getShippingCostTax() {
        return shippingCostTax;
    }

    /**
     * Tax amount of the shipping cost.
     */
    public void setShippingCostTax(Long value) {
        this.shippingCostTax = value;
    }

    /**
     * Tax amount of the shipping cost.
     */
    public Shipping withShippingCostTax(Long value) {
        this.shippingCostTax = value;
        return this;
    }

    /**
     * Indicates the merchandise delivery timeframe. Possible values:
     * <ul>
     *   <li>electronic = For electronic delivery (services or digital goods)</li>
     *   <li>same-day = For same day deliveries</li>
     *   <li>overnight = For overnight deliveries</li>
     *   <li>2-day-or-more = For two day or more delivery time</li>
     * </ul>
     */
    public String getType() {
        return type;
    }

    /**
     * Indicates the merchandise delivery timeframe. Possible values:
     * <ul>
     *   <li>electronic = For electronic delivery (services or digital goods)</li>
     *   <li>same-day = For same day deliveries</li>
     *   <li>overnight = For overnight deliveries</li>
     *   <li>2-day-or-more = For two day or more delivery time</li>
     * </ul>
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Indicates the merchandise delivery timeframe. Possible values:
     * <ul>
     *   <li>electronic = For electronic delivery (services or digital goods)</li>
     *   <li>same-day = For same day deliveries</li>
     *   <li>overnight = For overnight deliveries</li>
     *   <li>2-day-or-more = For two day or more delivery time</li>
     * </ul>
     */
    public Shipping withType(String value) {
        this.type = value;
        return this;
    }
}
