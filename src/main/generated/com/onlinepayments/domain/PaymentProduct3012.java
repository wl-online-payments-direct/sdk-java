/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProduct3012 {

    private String qrCode;

    private String urlIntent;

    /**
     * Contains a value which can be used to build a QR code (intended to be scanned by a device with the Bancontact app)
     */
    public String getQrCode() {
        return qrCode;
    }

    /**
     * Contains a value which can be used to build a QR code (intended to be scanned by a device with the Bancontact app)
     */
    public void setQrCode(String value) {
        this.qrCode = value;
    }

    /**
     * Contains a value which can be used to build a QR code (intended to be scanned by a device with the Bancontact app)
     */
    public PaymentProduct3012 withQrCode(String value) {
        this.qrCode = value;
        return this;
    }

    /**
     * Contains URL intent that can be used as the link of an &quot;open the app&quot; button on a device
     */
    public String getUrlIntent() {
        return urlIntent;
    }

    /**
     * Contains URL intent that can be used as the link of an &quot;open the app&quot; button on a device
     */
    public void setUrlIntent(String value) {
        this.urlIntent = value;
    }

    /**
     * Contains URL intent that can be used as the link of an &quot;open the app&quot; button on a device
     */
    public PaymentProduct3012 withUrlIntent(String value) {
        this.urlIntent = value;
        return this;
    }
}
