/*
 * This class was auto-generated.
 */
package com.onlinepayments.merchant;

import java.util.Map;

import com.onlinepayments.ApiResource;
import com.onlinepayments.merchant.hostedcheckout.HostedCheckoutClient;
import com.onlinepayments.merchant.hostedtokenization.HostedTokenizationClient;
import com.onlinepayments.merchant.mandates.MandatesClient;
import com.onlinepayments.merchant.payments.PaymentsClient;
import com.onlinepayments.merchant.payouts.PayoutsClient;
import com.onlinepayments.merchant.productgroups.ProductGroupsClient;
import com.onlinepayments.merchant.products.ProductsClient;
import com.onlinepayments.merchant.services.ServicesClient;
import com.onlinepayments.merchant.sessions.SessionsClient;
import com.onlinepayments.merchant.tokens.TokensClient;

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
	public HostedCheckoutClient hostedCheckout() {
		return new HostedCheckoutClient(this, null);
	}

	/**
	 * {@inheritDoc}
	 */
	public HostedTokenizationClient hostedTokenization() {
		return new HostedTokenizationClient(this, null);
	}

	/**
	 * {@inheritDoc}
	 */
	public MandatesClient mandates() {
		return new MandatesClient(this, null);
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
	public PayoutsClient payouts() {
		return new PayoutsClient(this, null);
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
	public ProductsClient products() {
		return new ProductsClient(this, null);
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
	public SessionsClient sessions() {
		return new SessionsClient(this, null);
	}

	/**
	 * {@inheritDoc}
	 */
	public TokensClient tokens() {
		return new TokensClient(this, null);
	}
}
