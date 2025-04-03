/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class PaymentProductFieldFormElement {

    private String type;

    private List<ValueMappingElement> valueMapping;

    /**
     * Type of form element to be used. The following types can be returned:
     * <ul>
     *   <li>text - A normal text input field</li>
     *   <li>list - A list of values that the customer needs to choose from, is detailed in the valueMapping array</li>
     *   <li>currency - Currency fields should be split into two fields, with the second one being specifically for the cents</li>
     *   <li>boolean - Boolean fields should offer the customer a choice, like accepting the terms and conditions of a product.</li>
     *   <li>date - let the customer pick a date.</li>
     * </ul>
     */
    public String getType() {
        return type;
    }

    /**
     * Type of form element to be used. The following types can be returned:
     * <ul>
     *   <li>text - A normal text input field</li>
     *   <li>list - A list of values that the customer needs to choose from, is detailed in the valueMapping array</li>
     *   <li>currency - Currency fields should be split into two fields, with the second one being specifically for the cents</li>
     *   <li>boolean - Boolean fields should offer the customer a choice, like accepting the terms and conditions of a product.</li>
     *   <li>date - let the customer pick a date.</li>
     * </ul>
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Type of form element to be used. The following types can be returned:
     * <ul>
     *   <li>text - A normal text input field</li>
     *   <li>list - A list of values that the customer needs to choose from, is detailed in the valueMapping array</li>
     *   <li>currency - Currency fields should be split into two fields, with the second one being specifically for the cents</li>
     *   <li>boolean - Boolean fields should offer the customer a choice, like accepting the terms and conditions of a product.</li>
     *   <li>date - let the customer pick a date.</li>
     * </ul>
     */
    public PaymentProductFieldFormElement withType(String value) {
        this.type = value;
        return this;
    }

    /**
     * Deprecated: This field is not used by any payment product
     *
     * @deprecated This field is not used by any payment product
     */
    @Deprecated
    public List<ValueMappingElement> getValueMapping() {
        return valueMapping;
    }

    /**
     * Deprecated: This field is not used by any payment product
     *
     * @deprecated This field is not used by any payment product
     */
    @Deprecated
    public void setValueMapping(List<ValueMappingElement> value) {
        this.valueMapping = value;
    }

    /**
     * Deprecated: This field is not used by any payment product
     *
     * @deprecated This field is not used by any payment product
     */
    @Deprecated
    public PaymentProductFieldFormElement withValueMapping(List<ValueMappingElement> value) {
        this.valueMapping = value;
        return this;
    }
}
