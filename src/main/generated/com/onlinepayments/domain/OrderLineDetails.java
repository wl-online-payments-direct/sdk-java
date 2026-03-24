/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class OrderLineDetails {

    private Long discountAmount;

    private String productBrand;

    private String productCode;

    private String productName;

    private Long productPrice;

    private String productType;

    private Long quantity;

    private Long taxAmount;

    private String unit;

    /**
     * Amount in the smallest currency unit, i.e.:
     * <ul>
     *   <li>EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34</li>
     *   <li>KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234</li>
     *   <li>JPY is a zero-decimal currency, the value 1234 will result in JPY 1234</li>
     * </ul>
     */
    public Long getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Amount in the smallest currency unit, i.e.:
     * <ul>
     *   <li>EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34</li>
     *   <li>KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234</li>
     *   <li>JPY is a zero-decimal currency, the value 1234 will result in JPY 1234</li>
     * </ul>
     */
    public void setDiscountAmount(Long value) {
        this.discountAmount = value;
    }

    /**
     * Amount in the smallest currency unit, i.e.:
     * <ul>
     *   <li>EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34</li>
     *   <li>KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234</li>
     *   <li>JPY is a zero-decimal currency, the value 1234 will result in JPY 1234</li>
     * </ul>
     */
    public OrderLineDetails withDiscountAmount(Long value) {
        this.discountAmount = value;
        return this;
    }

    /**
     * The brand of the product.
     */
    public String getProductBrand() {
        return productBrand;
    }

    /**
     * The brand of the product.
     */
    public void setProductBrand(String value) {
        this.productBrand = value;
    }

    /**
     * The brand of the product.
     */
    public OrderLineDetails withProductBrand(String value) {
        this.productBrand = value;
        return this;
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
     * Product or UPC Code
     */
    public OrderLineDetails withProductCode(String value) {
        this.productCode = value;
        return this;
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
     * The name of the product.
     */
    public OrderLineDetails withProductName(String value) {
        this.productName = value;
        return this;
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
     * The price of one unit of the product, the value should be zero or greater
     */
    public OrderLineDetails withProductPrice(Long value) {
        this.productPrice = value;
        return this;
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
     * Code used to classify items that are purchased
     */
    public OrderLineDetails withProductType(String value) {
        this.productType = value;
        return this;
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
     * Quantity of the units being purchased, should be greater than zero
     * Note: Must not be all spaces or all zeros
     */
    public OrderLineDetails withQuantity(Long value) {
        this.quantity = value;
        return this;
    }

    /**
     * Amount in the smallest currency unit, i.e.:
     * <ul>
     *   <li>EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34</li>
     *   <li>KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234</li>
     *   <li>JPY is a zero-decimal currency, the value 1234 will result in JPY 1234</li>
     * </ul>
     */
    public Long getTaxAmount() {
        return taxAmount;
    }

    /**
     * Amount in the smallest currency unit, i.e.:
     * <ul>
     *   <li>EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34</li>
     *   <li>KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234</li>
     *   <li>JPY is a zero-decimal currency, the value 1234 will result in JPY 1234</li>
     * </ul>
     */
    public void setTaxAmount(Long value) {
        this.taxAmount = value;
    }

    /**
     * Amount in the smallest currency unit, i.e.:
     * <ul>
     *   <li>EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34</li>
     *   <li>KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234</li>
     *   <li>JPY is a zero-decimal currency, the value 1234 will result in JPY 1234</li>
     * </ul>
     */
    public OrderLineDetails withTaxAmount(Long value) {
        this.taxAmount = value;
        return this;
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

    /**
     * Indicates the line item unit of measure; for example: each, kit, pair, gallon, month, etc.
     */
    public OrderLineDetails withUnit(String value) {
        this.unit = value;
        return this;
    }
}
