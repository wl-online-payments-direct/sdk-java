/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.time.ZonedDateTime;
import java.util.List;

public class PaymentLinkResponse {

    private ZonedDateTime expirationDate;

    private Boolean isReusableLink;

    private String paymentId;

    private List<PaymentLinkEvent> paymentLinkEvents;

    private String paymentLinkId;

    private PaymentLinkOrderOutput paymentLinkOrder;

    private String qrCodeBase64;

    private String recipientName;

    private String redirectionUrl;

    private String status;

    /**
     * The date after which the payment link will not be usable to complete the payment. The date will contain the UTC offset.
     */
    public ZonedDateTime getExpirationDate() {
        return expirationDate;
    }

    /**
     * The date after which the payment link will not be usable to complete the payment. The date will contain the UTC offset.
     */
    public void setExpirationDate(ZonedDateTime value) {
        this.expirationDate = value;
    }

    /**
     * The date after which the payment link will not be usable to complete the payment. The date will contain the UTC offset.
     */
    public PaymentLinkResponse withExpirationDate(ZonedDateTime value) {
        this.expirationDate = value;
        return this;
    }

    /**
     * Indicates if the payment link can be used multiple times. The default value for this property is false
     */
    public Boolean getIsReusableLink() {
        return isReusableLink;
    }

    /**
     * Indicates if the payment link can be used multiple times. The default value for this property is false
     */
    public void setIsReusableLink(Boolean value) {
        this.isReusableLink = value;
    }

    /**
     * Indicates if the payment link can be used multiple times. The default value for this property is false
     */
    public PaymentLinkResponse withIsReusableLink(Boolean value) {
        this.isReusableLink = value;
        return this;
    }

    /**
     * The unique payment transaction identifier. This id is only set when a payment was processed with this payment link.
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * The unique payment transaction identifier. This id is only set when a payment was processed with this payment link.
     */
    public void setPaymentId(String value) {
        this.paymentId = value;
    }

    /**
     * The unique payment transaction identifier. This id is only set when a payment was processed with this payment link.
     */
    public PaymentLinkResponse withPaymentId(String value) {
        this.paymentId = value;
        return this;
    }

    public List<PaymentLinkEvent> getPaymentLinkEvents() {
        return paymentLinkEvents;
    }

    public void setPaymentLinkEvents(List<PaymentLinkEvent> value) {
        this.paymentLinkEvents = value;
    }

    public PaymentLinkResponse withPaymentLinkEvents(List<PaymentLinkEvent> value) {
        this.paymentLinkEvents = value;
        return this;
    }

    /**
     * The unique link identifier.
     */
    public String getPaymentLinkId() {
        return paymentLinkId;
    }

    /**
     * The unique link identifier.
     */
    public void setPaymentLinkId(String value) {
        this.paymentLinkId = value;
    }

    /**
     * The unique link identifier.
     */
    public PaymentLinkResponse withPaymentLinkId(String value) {
        this.paymentLinkId = value;
        return this;
    }

    /**
     * An object containing the details of the related payment output.
     */
    public PaymentLinkOrderOutput getPaymentLinkOrder() {
        return paymentLinkOrder;
    }

    /**
     * An object containing the details of the related payment output.
     */
    public void setPaymentLinkOrder(PaymentLinkOrderOutput value) {
        this.paymentLinkOrder = value;
    }

    /**
     * An object containing the details of the related payment output.
     */
    public PaymentLinkResponse withPaymentLinkOrder(PaymentLinkOrderOutput value) {
        this.paymentLinkOrder = value;
        return this;
    }

    /**
     * Base64 encoded QR code image containing the payment link URL. This field is only included in the response when displayQRCode is set to true in the request.
     */
    public String getQrCodeBase64() {
        return qrCodeBase64;
    }

    /**
     * Base64 encoded QR code image containing the payment link URL. This field is only included in the response when displayQRCode is set to true in the request.
     */
    public void setQrCodeBase64(String value) {
        this.qrCodeBase64 = value;
    }

    /**
     * Base64 encoded QR code image containing the payment link URL. This field is only included in the response when displayQRCode is set to true in the request.
     */
    public PaymentLinkResponse withQrCodeBase64(String value) {
        this.qrCodeBase64 = value;
        return this;
    }

    /**
     * The payment link recipient name.
     */
    public String getRecipientName() {
        return recipientName;
    }

    /**
     * The payment link recipient name.
     */
    public void setRecipientName(String value) {
        this.recipientName = value;
    }

    /**
     * The payment link recipient name.
     */
    public PaymentLinkResponse withRecipientName(String value) {
        this.recipientName = value;
        return this;
    }

    /**
     * The URL that will redirect the customer to the Hosted Checkout page to process the payment.
     */
    public String getRedirectionUrl() {
        return redirectionUrl;
    }

    /**
     * The URL that will redirect the customer to the Hosted Checkout page to process the payment.
     */
    public void setRedirectionUrl(String value) {
        this.redirectionUrl = value;
    }

    /**
     * The URL that will redirect the customer to the Hosted Checkout page to process the payment.
     */
    public PaymentLinkResponse withRedirectionUrl(String value) {
        this.redirectionUrl = value;
        return this;
    }

    /**
     * The state of the payment link:
     * <ul>
     *   <li>ACTIVE: The payment link is ready to be used.</li>
     *   <li>PAID: The payment has been completed.</li>
     *   <li>CANCELLED: The payment link has been manually cancelled.</li>
     *   <li>EXPIRED: The payment link is not usable anymore.</li>
     * </ul>
     */
    public String getStatus() {
        return status;
    }

    /**
     * The state of the payment link:
     * <ul>
     *   <li>ACTIVE: The payment link is ready to be used.</li>
     *   <li>PAID: The payment has been completed.</li>
     *   <li>CANCELLED: The payment link has been manually cancelled.</li>
     *   <li>EXPIRED: The payment link is not usable anymore.</li>
     * </ul>
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * The state of the payment link:
     * <ul>
     *   <li>ACTIVE: The payment link is ready to be used.</li>
     *   <li>PAID: The payment has been completed.</li>
     *   <li>CANCELLED: The payment link has been manually cancelled.</li>
     *   <li>EXPIRED: The payment link is not usable anymore.</li>
     * </ul>
     */
    public PaymentLinkResponse withStatus(String value) {
        this.status = value;
        return this;
    }
}
