/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

public class RefundRedirectMethodSpecificOutput {

	private Long totalAmountPaid = null;

	private Long totalAmountRefunded = null;

	public Long getTotalAmountPaid() {
		return totalAmountPaid;
	}

	public void setTotalAmountPaid(Long value) {
		this.totalAmountPaid = value;
	}

	public RefundRedirectMethodSpecificOutput withTotalAmountPaid(Long value) {
		this.totalAmountPaid = value;
		return this;
	}

	public Long getTotalAmountRefunded() {
		return totalAmountRefunded;
	}

	public void setTotalAmountRefunded(Long value) {
		this.totalAmountRefunded = value;
	}

	public RefundRedirectMethodSpecificOutput withTotalAmountRefunded(Long value) {
		this.totalAmountRefunded = value;
		return this;
	}
}
