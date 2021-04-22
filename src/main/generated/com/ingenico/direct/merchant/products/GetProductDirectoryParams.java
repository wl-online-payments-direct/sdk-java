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
 * <a href="https://support.direct.ingenico.com/documentation/api/reference#operation/GetProductDirectoryApi">Get payment product directory</a>
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
