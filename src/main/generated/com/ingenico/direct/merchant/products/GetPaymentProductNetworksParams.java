/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.merchant.products;

import java.util.LinkedList;
import java.util.List;

import com.ingenico.direct.ParamRequest;
import com.ingenico.direct.RequestParam;

/**
 * Query parameters for
 * <a href="https://support.direct.ingenico.com/documentation/api/reference#operation/GetPaymentProductNetworks">Get payment product networks</a>
 */
public class GetPaymentProductNetworksParams implements ParamRequest {

	private String countryCode;

	private String currencyCode;

	private Long amount;

	private Boolean isRecurring;

	/**
	 * ISO 3166-1 alpha-2 country code
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * ISO 3166-1 alpha-2 country code
	 */
	public void setCountryCode(String value) {
		this.countryCode = value;
	}

	/**
	 * Three-letter ISO currency code representing the currency for the amount
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * Three-letter ISO currency code representing the currency for the amount
	 */
	public void setCurrencyCode(String value) {
		this.currencyCode = value;
	}

	/**
	 * Amount in cents and always having 2 decimals
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * Amount in cents and always having 2 decimals
	 */
	public void setAmount(Long value) {
		this.amount = value;
	}

	/**
	 * This allows you to filter networks based on their support for recurring or not
	 * * true
	 * * false
	 */
	public Boolean getIsRecurring() {
		return isRecurring;
	}

	/**
	 * This allows you to filter networks based on their support for recurring or not
	 * * true
	 * * false
	 */
	public void setIsRecurring(Boolean value) {
		this.isRecurring = value;
	}

	@Override
	public List<RequestParam> toRequestParameters() {
		List<RequestParam> result = new LinkedList<RequestParam>();
		if (countryCode != null) {
			result.add(new RequestParam("countryCode", countryCode));
		}
		if (currencyCode != null) {
			result.add(new RequestParam("currencyCode", currencyCode));
		}
		if (amount != null) {
			result.add(new RequestParam("amount", amount.toString()));
		}
		if (isRecurring != null) {
			result.add(new RequestParam("isRecurring", isRecurring.toString()));
		}
		return result;
	}
}
