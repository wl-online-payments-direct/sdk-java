/*
 * This class was auto-generated.
 */
package com.onlinepayments.merchant.services;

import java.util.LinkedList;
import java.util.List;

import com.onlinepayments.ParamRequest;
import com.onlinepayments.RequestParam;

/**
 * Query parameters for 'Get Privacy Policy'.
 */
public class GetPrivacyPolicyParams implements ParamRequest {

	private String locale;

	private Integer paymentProductId;

	/**
	 * Locale in which the privacy policy will be returned.
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * Locale in which the privacy policy will be returned.
	 */
	public void setLocale(String value) {
		this.locale = value;
	}

	/**
	 * Locale in which the privacy policy will be returned.
	 */
	public GetPrivacyPolicyParams withLocale(String value) {
		this.locale = value;
		return this;
	}

	/**
	 * ID of the specific payment product for which you wish to retrieve the privacy policy. When none is provided you will receive a complete policy for all the payment methods available for the specified merchantId.
	 */
	public Integer getPaymentProductId() {
		return paymentProductId;
	}

	/**
	 * ID of the specific payment product for which you wish to retrieve the privacy policy. When none is provided you will receive a complete policy for all the payment methods available for the specified merchantId.
	 */
	public void setPaymentProductId(Integer value) {
		this.paymentProductId = value;
	}

	/**
	 * ID of the specific payment product for which you wish to retrieve the privacy policy. When none is provided you will receive a complete policy for all the payment methods available for the specified merchantId.
	 */
	public GetPrivacyPolicyParams withPaymentProductId(Integer value) {
		this.paymentProductId = value;
		return this;
	}

	@Override
	public List<RequestParam> toRequestParameters() {
		List<RequestParam> result = new LinkedList<RequestParam>();
		if (locale != null) {
			result.add(new RequestParam("locale", locale));
		}
		if (paymentProductId != null) {
			result.add(new RequestParam("paymentProductId", paymentProductId.toString()));
		}
		return result;
	}
}
