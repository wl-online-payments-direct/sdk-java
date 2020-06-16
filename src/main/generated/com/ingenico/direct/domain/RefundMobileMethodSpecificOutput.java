/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

public class RefundMobileMethodSpecificOutput {

	private String network = null;

	private Long totalAmountPaid = null;

	private Long totalAmountRefunded = null;

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String value) {
		this.network = value;
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