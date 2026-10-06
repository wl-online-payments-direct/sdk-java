/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.time.ZonedDateTime;

public class PaymentLinkOverviewEntry {

    private AmountOfMoney amount;

    private String createdBy;

    private ZonedDateTime creationDate;

    private ZonedDateTime expirationDate;

    private Boolean isReusableLink;

    private String merchantId;

    private String merchantReference;

    private String paymentLinkId;

    private String redirectionUrl;

    private String status;

    /**
     * Object containing amount and ISO currency code attributes
     */
    public AmountOfMoney getAmount() {
        return amount;
    }

    /**
     * Object containing amount and ISO currency code attributes
     */
    public void setAmount(AmountOfMoney value) {
        this.amount = value;
    }

    /**
     * Object containing amount and ISO currency code attributes
     */
    public PaymentLinkOverviewEntry withAmount(AmountOfMoney value) {
        this.amount = value;
        return this;
    }

    /**
     * The identifier of the user or entity that created the payment link.
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * The identifier of the user or entity that created the payment link.
     */
    public void setCreatedBy(String value) {
        this.createdBy = value;
    }

    /**
     * The identifier of the user or entity that created the payment link.
     */
    public PaymentLinkOverviewEntry withCreatedBy(String value) {
        this.createdBy = value;
        return this;
    }

    /**
     * The date and time when the payment link was created. The date contains the UTC offset.
     */
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * The date and time when the payment link was created. The date contains the UTC offset.
     */
    public void setCreationDate(ZonedDateTime value) {
        this.creationDate = value;
    }

    /**
     * The date and time when the payment link was created. The date contains the UTC offset.
     */
    public PaymentLinkOverviewEntry withCreationDate(ZonedDateTime value) {
        this.creationDate = value;
        return this;
    }

    /**
     * The date after which the payment link will not be usable to complete the payment. The date sent cannot be more than 6 months in the future or a past date. It must also contain the UTC offset.
     */
    public ZonedDateTime getExpirationDate() {
        return expirationDate;
    }

    /**
     * The date after which the payment link will not be usable to complete the payment. The date sent cannot be more than 6 months in the future or a past date. It must also contain the UTC offset.
     */
    public void setExpirationDate(ZonedDateTime value) {
        this.expirationDate = value;
    }

    /**
     * The date after which the payment link will not be usable to complete the payment. The date sent cannot be more than 6 months in the future or a past date. It must also contain the UTC offset.
     */
    public PaymentLinkOverviewEntry withExpirationDate(ZonedDateTime value) {
        this.expirationDate = value;
        return this;
    }

    /**
     * Indicates if the payment link can be used multiple times.
     */
    public Boolean getIsReusableLink() {
        return isReusableLink;
    }

    /**
     * Indicates if the payment link can be used multiple times.
     */
    public void setIsReusableLink(Boolean value) {
        this.isReusableLink = value;
    }

    /**
     * Indicates if the payment link can be used multiple times.
     */
    public PaymentLinkOverviewEntry withIsReusableLink(Boolean value) {
        this.isReusableLink = value;
        return this;
    }

    /**
     * The unique Merchant Id of the merchant associated with the payment link.
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * The unique Merchant Id of the merchant associated with the payment link.
     */
    public void setMerchantId(String value) {
        this.merchantId = value;
    }

    /**
     * The unique Merchant Id of the merchant associated with the payment link.
     */
    public PaymentLinkOverviewEntry withMerchantId(String value) {
        this.merchantId = value;
        return this;
    }

    /**
     * Your unique reference of the transaction that is also returned in our report files. This is almost always used for your reconciliation of our report files.
     * It is highly recommended to provide a single MerchantReference per unique order on your side
     */
    public String getMerchantReference() {
        return merchantReference;
    }

    /**
     * Your unique reference of the transaction that is also returned in our report files. This is almost always used for your reconciliation of our report files.
     * It is highly recommended to provide a single MerchantReference per unique order on your side
     */
    public void setMerchantReference(String value) {
        this.merchantReference = value;
    }

    /**
     * Your unique reference of the transaction that is also returned in our report files. This is almost always used for your reconciliation of our report files.
     * It is highly recommended to provide a single MerchantReference per unique order on your side
     */
    public PaymentLinkOverviewEntry withMerchantReference(String value) {
        this.merchantReference = value;
        return this;
    }

    /**
     * The unique identifier of the payment link.
     */
    public String getPaymentLinkId() {
        return paymentLinkId;
    }

    /**
     * The unique identifier of the payment link.
     */
    public void setPaymentLinkId(String value) {
        this.paymentLinkId = value;
    }

    /**
     * The unique identifier of the payment link.
     */
    public PaymentLinkOverviewEntry withPaymentLinkId(String value) {
        this.paymentLinkId = value;
        return this;
    }

    /**
     * The URL that will redirect the customer to the payment page to process the payment.
     */
    public String getRedirectionUrl() {
        return redirectionUrl;
    }

    /**
     * The URL that will redirect the customer to the payment page to process the payment.
     */
    public void setRedirectionUrl(String value) {
        this.redirectionUrl = value;
    }

    /**
     * The URL that will redirect the customer to the payment page to process the payment.
     */
    public PaymentLinkOverviewEntry withRedirectionUrl(String value) {
        this.redirectionUrl = value;
        return this;
    }

    /**
     * The current status of a payment link in its lifecycle. A payment link transitions through these states from creation to completion or termination:
     * * ACTIVE - The payment link is active and ready to be used by the customer to complete a payment. This is the initial status when a link is created.
     * * PAID - The payment has been successfully completed by the customer. The link can no longer be used unless it was created as a reusable link (isReusableLink = true).
     * * CANCELLED - The payment link has been manually cancelled by the merchant and can no longer be used.
     * * EXPIRED - The payment link has passed its expiration date (expirationDate) and is no longer usable.
     */
    public String getStatus() {
        return status;
    }

    /**
     * The current status of a payment link in its lifecycle. A payment link transitions through these states from creation to completion or termination:
     * * ACTIVE - The payment link is active and ready to be used by the customer to complete a payment. This is the initial status when a link is created.
     * * PAID - The payment has been successfully completed by the customer. The link can no longer be used unless it was created as a reusable link (isReusableLink = true).
     * * CANCELLED - The payment link has been manually cancelled by the merchant and can no longer be used.
     * * EXPIRED - The payment link has passed its expiration date (expirationDate) and is no longer usable.
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * The current status of a payment link in its lifecycle. A payment link transitions through these states from creation to completion or termination:
     * * ACTIVE - The payment link is active and ready to be used by the customer to complete a payment. This is the initial status when a link is created.
     * * PAID - The payment has been successfully completed by the customer. The link can no longer be used unless it was created as a reusable link (isReusableLink = true).
     * * CANCELLED - The payment link has been manually cancelled by the merchant and can no longer be used.
     * * EXPIRED - The payment link has passed its expiration date (expirationDate) and is no longer usable.
     */
    public PaymentLinkOverviewEntry withStatus(String value) {
        this.status = value;
        return this;
    }
}
