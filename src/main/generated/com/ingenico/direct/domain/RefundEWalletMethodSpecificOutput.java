/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

public class RefundEWalletMethodSpecificOutput {

	private RefundPaymentProduct840SpecificOutput paymentProduct840SpecificOutput = null;

	private Long totalAmountPaid = null;

	private Long totalAmountRefunded = null;

	public RefundPaymentProduct840SpecificOutput getPaymentProduct840SpecificOutput() {
		return paymentProduct840SpecificOutput;
	}

	public void setPaymentProduct840SpecificOutput(RefundPaymentProduct840SpecificOutput value) {
		this.paymentProduct840SpecificOutput = value;
	}

	public Long getTotalAmountPaid() {
		return totalAmountPaid;
	}

	public void setTotalAmountPaid(Long value) {
		this.totalAmountPaid = value;
	}

	public Long getTotalAmountRefunded() {
		return totalAmountRefunded;
	}

	public void setTotalAmountRefunded(Long value) {
		this.totalAmountRefunded = value;
	}
}
