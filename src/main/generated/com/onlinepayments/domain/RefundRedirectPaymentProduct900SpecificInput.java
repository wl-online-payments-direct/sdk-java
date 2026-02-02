/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RefundRedirectPaymentProduct900SpecificInput {

    private String refundReason;

    /**
     * The reason for the refund, required for Wero payments. This value is sent to the consumer’s bank as part of the Wero refund request and will be shown to the consumer in their banking application. If not provided, the value defaults to &quot;Other&quot;.
     */
    public String getRefundReason() {
        return refundReason;
    }

    /**
     * The reason for the refund, required for Wero payments. This value is sent to the consumer’s bank as part of the Wero refund request and will be shown to the consumer in their banking application. If not provided, the value defaults to &quot;Other&quot;.
     */
    public void setRefundReason(String value) {
        this.refundReason = value;
    }

    /**
     * The reason for the refund, required for Wero payments. This value is sent to the consumer’s bank as part of the Wero refund request and will be shown to the consumer in their banking application. If not provided, the value defaults to &quot;Other&quot;.
     */
    public RefundRedirectPaymentProduct900SpecificInput withRefundReason(String value) {
        this.refundReason = value;
        return this;
    }
}
