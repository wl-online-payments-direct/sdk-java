/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProductFieldTooltip {

    private String image;

    private String label;

    /**
     * Deprecated: This field is not used by any payment product
     * Relative URL that can be used to retrieve an image for the tooltip image.
     *
     * @deprecated This field is not used by any payment product Relative URL that can be used to retrieve an image for the tooltip image.
     */
    @Deprecated
    public String getImage() {
        return image;
    }

    /**
     * Deprecated: This field is not used by any payment product
     * Relative URL that can be used to retrieve an image for the tooltip image.
     *
     * @deprecated This field is not used by any payment product Relative URL that can be used to retrieve an image for the tooltip image.
     */
    @Deprecated
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * Deprecated: This field is not used by any payment product
     * Relative URL that can be used to retrieve an image for the tooltip image.
     *
     * @deprecated This field is not used by any payment product Relative URL that can be used to retrieve an image for the tooltip image.
     */
    @Deprecated
    public PaymentProductFieldTooltip withImage(String value) {
        this.image = value;
        return this;
    }

    /**
     * A text explaining the field in more detail. This is meant to be used for displaying to the customer.
     */
    public String getLabel() {
        return label;
    }

    /**
     * A text explaining the field in more detail. This is meant to be used for displaying to the customer.
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * A text explaining the field in more detail. This is meant to be used for displaying to the customer.
     */
    public PaymentProductFieldTooltip withLabel(String value) {
        this.label = value;
        return this;
    }
}
