/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.merchant.productgroups;

import java.util.LinkedList;
import java.util.List;

import com.ingenico.direct.ParamRequest;
import com.ingenico.direct.RequestParam;

/**
 * Query parameters for
 * <a href="https://support.direct.ingenico.com/documentation/api/reference#operation/GetProductGroup">Get product group</a>
 */
public class GetProductGroupParams implements ParamRequest {

	private String countryCode;

	private String currencyCode;

	private String locale;

	private Long amount;

	private Boolean isRecurring;

	private List<String> hide;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String value) {
		this.countryCode = value;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String value) {
		this.currencyCode = value;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String value) {
		this.locale = value;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long value) {
		this.amount = value;
	}

	public Boolean getIsRecurring() {
		return isRecurring;
	}

	public void setIsRecurring(Boolean value) {
		this.isRecurring = value;
	}

	public List<String> getHide() {
		return hide;
	}

	public void setHide(List<String> value) {
		this.hide = value;
	}

	public void addHide(String value) {
		if (this.hide == null) {
			this.hide = new LinkedList<String>();
		}
		this.hide.add(value);
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
		if (locale != null) {
			result.add(new RequestParam("locale", locale));
		}
		if (amount != null) {
			result.add(new RequestParam("amount", amount.toString()));
		}
		if (isRecurring != null) {
			result.add(new RequestParam("isRecurring", isRecurring.toString()));
		}
		if (hide != null) {
			for (String hideElement : hide) {
				if (hideElement != null) {
					result.add(new RequestParam("hide", hideElement));
				}
			}
		}
		return result;
	}
}
