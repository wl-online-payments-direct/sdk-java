/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class OtherDetails {

    private String metaData;

    private String travelData;

    /**
     * Information used by the following PaymentProducts [5300] to provide details on the item such as the color, size, etc. The field is in JSON format, with keys and values expected by the payment method at transaction creation. Please refer to the payment mean documentation.
     */
    public String getMetaData() {
        return metaData;
    }

    /**
     * Information used by the following PaymentProducts [5300] to provide details on the item such as the color, size, etc. The field is in JSON format, with keys and values expected by the payment method at transaction creation. Please refer to the payment mean documentation.
     */
    public void setMetaData(String value) {
        this.metaData = value;
    }

    /**
     * Information used by the following PaymentProducts [5300] to provide details on the item such as the color, size, etc. The field is in JSON format, with keys and values expected by the payment method at transaction creation. Please refer to the payment mean documentation.
     */
    public OtherDetails withMetaData(String value) {
        this.metaData = value;
        return this;
    }

    /**
     * Information used by the following PaymentProducts [5110,5111,5112,5125,3104,3107,3108,3109].
     */
    public String getTravelData() {
        return travelData;
    }

    /**
     * Information used by the following PaymentProducts [5110,5111,5112,5125,3104,3107,3108,3109].
     */
    public void setTravelData(String value) {
        this.travelData = value;
    }

    /**
     * Information used by the following PaymentProducts [5110,5111,5112,5125,3104,3107,3108,3109].
     */
    public OtherDetails withTravelData(String value) {
        this.travelData = value;
        return this;
    }
}
