package com.onlinepayments.domain;

public class WebhooksEvent {

    private String apiVersion;

    private String id;

    private String created;

    private String merchantId;

    private String type;

    private PaymentLinkResponse paymentlink;

    private PaymentResponse payment;

    private PayoutResponse payout;

    private RefundResponse refund;

    private TokenResponse token;

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PaymentLinkResponse getPaymentlink() {
        return paymentlink;
    }

    public void setPaymentlink(PaymentLinkResponse paymentlink) {
        this.paymentlink = paymentlink;
    }

    public PaymentResponse getPayment() {
        return payment;
    }

    public void setPayment(PaymentResponse payment) {
        this.payment = payment;
    }

    public PayoutResponse getPayout() {
        return payout;
    }

    public void setPayout(PayoutResponse payout) {
        this.payout = payout;
    }

    public RefundResponse getRefund() {
        return refund;
    }

    public void setRefund(RefundResponse refund) {
        this.refund = refund;
    }

    public TokenResponse getToken() {
        return token;
    }

    public void setToken(TokenResponse token) {
        this.token = token;
    }
}
