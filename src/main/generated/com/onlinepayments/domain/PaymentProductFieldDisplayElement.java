/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProductFieldDisplayElement {

    private String id;

    private String label;

    private String type;

    private String value;

    /**
     * The ID of the display element.
     */
    public String getId() {
        return id;
    }

    /**
     * The ID of the display element.
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * The ID of the display element.
     */
    public PaymentProductFieldDisplayElement withId(String value) {
        this.id = value;
        return this;
    }

    /**
     * The label of the display element.
     */
    public String getLabel() {
        return label;
    }

    /**
     * The label of the display element.
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * The label of the display element.
     */
    public PaymentProductFieldDisplayElement withLabel(String value) {
        this.label = value;
        return this;
    }

    /**
     * The type of the display element. Indicates how the value should be presented. Possible values are:
     * <ul>
     *   <li>STRING - as plain text</li>
     *   <li>CURRENCY - as an amount in cents displayed with a decimal separator and the currency of the payment</li>
     *   <li>PERCENTAGE - as a number with a percentage sign</li>
     *   <li>INTEGER - as an integer</li>
     *   <li>URI - as a link</li>
     * </ul>
     */
    public String getType() {
        return type;
    }

    /**
     * The type of the display element. Indicates how the value should be presented. Possible values are:
     * <ul>
     *   <li>STRING - as plain text</li>
     *   <li>CURRENCY - as an amount in cents displayed with a decimal separator and the currency of the payment</li>
     *   <li>PERCENTAGE - as a number with a percentage sign</li>
     *   <li>INTEGER - as an integer</li>
     *   <li>URI - as a link</li>
     * </ul>
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * The type of the display element. Indicates how the value should be presented. Possible values are:
     * <ul>
     *   <li>STRING - as plain text</li>
     *   <li>CURRENCY - as an amount in cents displayed with a decimal separator and the currency of the payment</li>
     *   <li>PERCENTAGE - as a number with a percentage sign</li>
     *   <li>INTEGER - as an integer</li>
     *   <li>URI - as a link</li>
     * </ul>
     */
    public PaymentProductFieldDisplayElement withType(String value) {
        this.type = value;
        return this;
    }

    /**
     * the value of the display element.
     */
    public String getValue() {
        return value;
    }

    /**
     * the value of the display element.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * the value of the display element.
     */
    public PaymentProductFieldDisplayElement withValue(String value) {
        this.value = value;
        return this;
    }
}
