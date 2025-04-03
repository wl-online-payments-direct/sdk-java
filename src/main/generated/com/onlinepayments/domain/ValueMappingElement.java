/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class ValueMappingElement {

    private List<PaymentProductFieldDisplayElement> displayElements;

    private String value;

    public List<PaymentProductFieldDisplayElement> getDisplayElements() {
        return displayElements;
    }

    public void setDisplayElements(List<PaymentProductFieldDisplayElement> value) {
        this.displayElements = value;
    }

    public ValueMappingElement withDisplayElements(List<PaymentProductFieldDisplayElement> value) {
        this.displayElements = value;
        return this;
    }

    /**
     * Value corresponding to the key
     */
    public String getValue() {
        return value;
    }

    /**
     * Value corresponding to the key
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Value corresponding to the key
     */
    public ValueMappingElement withValue(String value) {
        this.value = value;
        return this;
    }
}
