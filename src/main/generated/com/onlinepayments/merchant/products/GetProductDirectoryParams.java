/*
 * This class was auto-generated.
 */
package com.onlinepayments.merchant.products;

import java.util.LinkedList;
import java.util.List;

import com.onlinepayments.ParamRequest;
import com.onlinepayments.RequestParam;

/**
 * Query parameters for 'Get payment product directory'.
 */
public class GetProductDirectoryParams implements ParamRequest {

	private String countryCode;

	private String currencyCode;

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
	 * ISO 3166-1 alpha-2 country code
	 */
	public GetProductDirectoryParams withCountryCode(String value) {
		this.countryCode = value;
		return this;
	}

	/**
	 * Three-letter ISO currency code representing the currency of the transaction
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * Three-letter ISO currency code representing the currency of the transaction
	 */
	public void setCurrencyCode(String value) {
		this.currencyCode = value;
	}

	/**
	 * Three-letter ISO currency code representing the currency of the transaction
	 */
	public GetProductDirectoryParams withCurrencyCode(String value) {
		this.currencyCode = value;
		return this;
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
		return result;
	}
}
