/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Object containing additional information that when supplied can have a beneficial effect on the discountrates
 */
public class OrderLineDetails {

	private Long discountAmount = null;

	private String productCode = null;

	private String productName = null;

	private Long productPrice = null;

	private String productType = null;

	private Long quantity = null;

	private Long taxAmount = null;

	private String unit = null;

	/**
	 * Discount on the line item, with the last two digits implied as decimal places
	 */
	public Long getDiscountAmount() {
		return discountAmount;
	}

	/**
	 * Discount on the line item, with the last two digits implied as decimal places
	 */
	public void setDiscountAmount(Long value) {
		this.discountAmount = value;
	}

	/**
	 * Product or UPC Code
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * Product or UPC Code
	 */
	public void setProductCode(String value) {
		this.productCode = value;
	}

	/**
	 * The name of the product.
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * The name of the product.
	 */
	public void setProductName(String value) {
		this.productName = value;
	}

	/**
	 * The price of one unit of the product, the value should be zero or greater
	 */
	public Long getProductPrice() {
		return productPrice;
	}

	/**
	 * The price of one unit of the product, the value should be zero or greater
	 */
	public void setProductPrice(Long value) {
		this.productPrice = value;
	}

	/**
	 * Code used to classify items that are purchased
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * Code used to classify items that are purchased
	 */
	public void setProductType(String value) {
		this.productType = value;
	}

	/**
	 * Quantity of the units being purchased, should be greater than zero
	 * Note: Must not be all spaces or all zeros
	 */
	public Long getQuantity() {
		return quantity;
	}

	/**
	 * Quantity of the units being purchased, should be greater than zero
	 * Note: Must not be all spaces or all zeros
	 */
	public void setQuantity(Long value) {
		this.quantity = value;
	}

	/**
	 * Tax on the line item, with the last two digits implied as decimal places
	 */
	public Long getTaxAmount() {
		return taxAmount;
	}

	/**
	 * Tax on the line item, with the last two digits implied as decimal places
	 */
	public void setTaxAmount(Long value) {
		this.taxAmount = value;
	}

	/**
	 * Indicates the line item unit of measure; for example: each, kit, pair, gallon, month, etc.
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * Indicates the line item unit of measure; for example: each, kit, pair, gallon, month, etc.
	 */
	public void setUnit(String value) {
		this.unit = value;
	}
}
