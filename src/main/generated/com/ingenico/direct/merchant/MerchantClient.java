/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.merchant;

import java.util.Map;
import java.util.TreeMap;

import com.ingenico.direct.ApiResource;
import com.ingenico.direct.merchant.hostedcheckout.HostedCheckoutClient;
import com.ingenico.direct.merchant.payments.PaymentsClient;
import com.ingenico.direct.merchant.productgroups.ProductGroupsClient;
import com.ingenico.direct.merchant.products.ProductsClient;
import com.ingenico.direct.merchant.services.ServicesClient;
import com.ingenico.direct.merchant.sessions.SessionsClient;
import com.ingenico.direct.merchant.tokens.TokensClient;

/**
 * Merchant client. Thread-safe.
 */
public class MerchantClient extends ApiResource implements MerchantClientInterface {

	public MerchantClient(ApiResource parent, Map<String, String> pathContext) {
		super(parent, pathContext);
	}

	/**
	 * Resource /v2/{merchantId}/products
	 *
	 * @return ProductsClient
	 */
	public ProductsClient products() {
		return new ProductsClient(this, null);
	}

	/**
	 * Resource /v2/{merchantId}/tokens/{tokenId}
	 *
	 * @param tokenId String
	 * @return TokensClient
	 */
	public TokensClient tokens(String tokenId) {
		Map<String, String> subContext = new TreeMap<String, String>();
		subContext.put("tokenId", tokenId);
		return new TokensClient(this, subContext);
	}

	/**
	 * Resource /v2/{merchantId}/sessions
	 *
	 * @return SessionsClient
	 */
	public SessionsClient sessions() {
		return new SessionsClient(this, null);
	}

	/**
	 * Resource /v2/{merchantId}/payments
	 *
	 * @return PaymentsClient
	 */
	public PaymentsClient payments() {
		return new PaymentsClient(this, null);
	}

	/**
	 * Resource /v2/{merchantId}/services/testconnection
	 *
	 * @return ServicesClient
	 */
	public ServicesClient services() {
		return new ServicesClient(this, null);
	}

	/**
	 * Resource /v2/{merchantId}/productgroups
	 *
	 * @return ProductGroupsClient
	 */
	public ProductGroupsClient productGroups() {
		return new ProductGroupsClient(this, null);
	}

	/**
	 * Resource /v2/{merchantId}/hostedcheckouts
	 *
	 * @return HostedCheckoutClient
	 */
	public HostedCheckoutClient hostedCheckout() {
		return new HostedCheckoutClient(this, null);
	}
}
