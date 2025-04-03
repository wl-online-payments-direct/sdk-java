/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class LabelTemplateElement {

    private String attributeKey;

    private String mask;

    /**
     * Name of the attribute that is shown to the customer on selection pages or screens
     */
    public String getAttributeKey() {
        return attributeKey;
    }

    /**
     * Name of the attribute that is shown to the customer on selection pages or screens
     */
    public void setAttributeKey(String value) {
        this.attributeKey = value;
    }

    /**
     * Name of the attribute that is shown to the customer on selection pages or screens
     */
    public LabelTemplateElement withAttributeKey(String value) {
        this.attributeKey = value;
        return this;
    }

    /**
     * Regular mask for the attributeKey
     * Note: The mask is optional as not every field has a mask
     */
    public String getMask() {
        return mask;
    }

    /**
     * Regular mask for the attributeKey
     * Note: The mask is optional as not every field has a mask
     */
    public void setMask(String value) {
        this.mask = value;
    }

    /**
     * Regular mask for the attributeKey
     * Note: The mask is optional as not every field has a mask
     */
    public LabelTemplateElement withMask(String value) {
        this.mask = value;
        return this;
    }
}
