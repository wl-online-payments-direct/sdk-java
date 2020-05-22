/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

import java.util.List;

public class AccountOnFile {

	private List<AccountOnFileAttribute> attributes = null;

	private AccountOnFileDisplayHints displayHints = null;

	private Integer id = null;

	private Integer paymentProductId = null;

	public List<AccountOnFileAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<AccountOnFileAttribute> value) {
		this.attributes = value;
	}

	public AccountOnFileDisplayHints getDisplayHints() {
		return displayHints;
	}

	public void setDisplayHints(AccountOnFileDisplayHints value) {
		this.displayHints = value;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer value) {
		this.id = value;
	}

	/**
	 * Payment product identifier - Please see [payment products](https://support.direct.ingenico.com/documentation/api/reference/index.html#tag/Products) for a full overview of possible values.
	 */
	public Integer getPaymentProductId() {
		return paymentProductId;
	}

	/**
	 * Payment product identifier - Please see [payment products](https://support.direct.ingenico.com/documentation/api/reference/index.html#tag/Products) for a full overview of possible values.
	 */
	public void setPaymentProductId(Integer value) {
		this.paymentProductId = value;
	}
}
