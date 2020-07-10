/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.merchant;

import java.util.Map;

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
	 * {@inheritDoc}
	 */
	public ProductsClient products() {
		return new ProductsClient(this, null);
	}

	/**
	 * {@inheritDoc}
	 */
	public SessionsClient sessions() {
		return new SessionsClient(this, null);
	}

	/**
	 * {@inheritDoc}
	 */
	public PaymentsClient payments() {
		return new PaymentsClient(this, null);
	}

	/**
	 * {@inheritDoc}
	 */
	public ServicesClient services() {
		return new ServicesClient(this, null);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProductGroupsClient productGroups() {
		return new ProductGroupsClient(this, null);
	}

	/**
	 * {@inheritDoc}
	 */
	public TokensClient tokens() {
		return new TokensClient(this, null);
	}

	/**
	 * {@inheritDoc}
	 */
	public HostedCheckoutClient hostedCheckout() {
		return new HostedCheckoutClient(this, null);
	}
}
