/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProduct350 {

    private String appSwitchLink;

    private String paymentRequestToken;

    /**
     * Contains an application switch URL for opening the Swish application on a mobile device (intended to be used by a device with the Swish app installed)
     */
    public String getAppSwitchLink() {
        return appSwitchLink;
    }

    /**
     * Contains an application switch URL for opening the Swish application on a mobile device (intended to be used by a device with the Swish app installed)
     */
    public void setAppSwitchLink(String value) {
        this.appSwitchLink = value;
    }

    /**
     * Contains an application switch URL for opening the Swish application on a mobile device (intended to be used by a device with the Swish app installed)
     */
    public PaymentProduct350 withAppSwitchLink(String value) {
        this.appSwitchLink = value;
        return this;
    }

    /**
     * Contains the token that identifies the payment on the Swish side. This can be used to generate a QR code (either manually or by calling the public QR Code API of Swish) to be scanned by the Swish app.
     */
    public String getPaymentRequestToken() {
        return paymentRequestToken;
    }

    /**
     * Contains the token that identifies the payment on the Swish side. This can be used to generate a QR code (either manually or by calling the public QR Code API of Swish) to be scanned by the Swish app.
     */
    public void setPaymentRequestToken(String value) {
        this.paymentRequestToken = value;
    }

    /**
     * Contains the token that identifies the payment on the Swish side. This can be used to generate a QR code (either manually or by calling the public QR Code API of Swish) to be scanned by the Swish app.
     */
    public PaymentProduct350 withPaymentRequestToken(String value) {
        this.paymentRequestToken = value;
        return this;
    }
}
