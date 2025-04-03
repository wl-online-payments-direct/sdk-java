/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RefundEWalletMethodSpecificOutput {

    private RefundPaymentProduct840SpecificOutput paymentProduct840SpecificOutput;

    private Long totalAmountPaid;

    private Long totalAmountRefunded;

    public RefundPaymentProduct840SpecificOutput getPaymentProduct840SpecificOutput() {
        return paymentProduct840SpecificOutput;
    }

    public void setPaymentProduct840SpecificOutput(RefundPaymentProduct840SpecificOutput value) {
        this.paymentProduct840SpecificOutput = value;
    }

    public RefundEWalletMethodSpecificOutput withPaymentProduct840SpecificOutput(RefundPaymentProduct840SpecificOutput value) {
        this.paymentProduct840SpecificOutput = value;
        return this;
    }

    public Long getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(Long value) {
        this.totalAmountPaid = value;
    }

    public RefundEWalletMethodSpecificOutput withTotalAmountPaid(Long value) {
        this.totalAmountPaid = value;
        return this;
    }

    public Long getTotalAmountRefunded() {
        return totalAmountRefunded;
    }

    public void setTotalAmountRefunded(Long value) {
        this.totalAmountRefunded = value;
    }

    public RefundEWalletMethodSpecificOutput withTotalAmountRefunded(Long value) {
        this.totalAmountRefunded = value;
        return this;
    }
}
