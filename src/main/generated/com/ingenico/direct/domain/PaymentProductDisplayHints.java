/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Object containing display hints like the order of the product when shown in a list, the name of the product and the logo
 */
public class PaymentProductDisplayHints {

	private Integer displayOrder = null;

	private String label = null;

	private String logo = null;

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer value) {
		this.displayOrder = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String value) {
		this.label = value;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String value) {
		this.logo = value;
	}
}
