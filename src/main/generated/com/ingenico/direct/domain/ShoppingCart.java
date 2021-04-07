/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

import java.util.List;

/**
 * Shopping cart data, including items and specific amounts.
 */
public class ShoppingCart {

	private List<AmountBreakdown> amountBreakdown = null;

	private GiftCardPurchase giftCardPurchase = null;

	private Boolean isPreOrder = null;

	private List<LineItem> items = null;

	private String preOrderItemAvailabilityDate = null;

	private Boolean reOrderIndicator = null;

	/**
	 * Deprecated: Use order.shipping.shippingCost for shipping cost. Other amounts are not used.
	 * Determines how the total amount is split into amount types
	 */
	public List<AmountBreakdown> getAmountBreakdown() {
		return amountBreakdown;
	}

	/**
	 * Deprecated: Use order.shipping.shippingCost for shipping cost. Other amounts are not used.
	 * Determines how the total amount is split into amount types
	 */
	public void setAmountBreakdown(List<AmountBreakdown> value) {
		this.amountBreakdown = value;
	}

	/**
	 * Object containing information on purchased gift card(s)
	 */
	public GiftCardPurchase getGiftCardPurchase() {
		return giftCardPurchase;
	}

	/**
	 * Object containing information on purchased gift card(s)
	 */
	public void setGiftCardPurchase(GiftCardPurchase value) {
		this.giftCardPurchase = value;
	}

	/**
	 * The customer is pre-ordering one or more items
	 */
	public Boolean getIsPreOrder() {
		return isPreOrder;
	}

	/**
	 * The customer is pre-ordering one or more items
	 */
	public void setIsPreOrder(Boolean value) {
		this.isPreOrder = value;
	}

	/**
	 * Shopping cart data
	 */
	public List<LineItem> getItems() {
		return items;
	}

	/**
	 * Shopping cart data
	 */
	public void setItems(List<LineItem> value) {
		this.items = value;
	}

	/**
	 * Date (YYYYMMDD) when the preordered item becomes available
	 */
	public String getPreOrderItemAvailabilityDate() {
		return preOrderItemAvailabilityDate;
	}

	/**
	 * Date (YYYYMMDD) when the preordered item becomes available
	 */
	public void setPreOrderItemAvailabilityDate(String value) {
		this.preOrderItemAvailabilityDate = value;
	}

	/**
	 * Indicates whether the cardholder is reordering previously purchased item(s)
	 * 
	 * true = the customer is re-ordering at least one of the items again
	 * 
	 * false = this is the first time the customer is ordering these items
	 */
	public Boolean getReOrderIndicator() {
		return reOrderIndicator;
	}

	/**
	 * Indicates whether the cardholder is reordering previously purchased item(s)
	 * 
	 * true = the customer is re-ordering at least one of the items again
	 * 
	 * false = this is the first time the customer is ordering these items
	 */
	public void setReOrderIndicator(Boolean value) {
		this.reOrderIndicator = value;
	}
}
