/*
 * This class was auto-generated.
 */
package com.onlinepayments.merchant;

import com.onlinepayments.merchant.hostedcheckout.HostedCheckoutClientInterface;
import com.onlinepayments.merchant.hostedtokenization.HostedTokenizationClientInterface;
import com.onlinepayments.merchant.mandates.MandatesClientInterface;
import com.onlinepayments.merchant.payments.PaymentsClientInterface;
import com.onlinepayments.merchant.payouts.PayoutsClientInterface;
import com.onlinepayments.merchant.productgroups.ProductGroupsClientInterface;
import com.onlinepayments.merchant.products.ProductsClientInterface;
import com.onlinepayments.merchant.services.ServicesClientInterface;
import com.onlinepayments.merchant.sessions.SessionsClientInterface;
import com.onlinepayments.merchant.tokens.TokensClientInterface;

/**
 * Merchant client. Thread-safe.
 */
public interface MerchantClientInterface {

	/**
	 * Resource /v2/{merchantId}/hostedcheckouts
	 *
	 * @return HostedCheckoutClient
	 */
	HostedCheckoutClientInterface hostedCheckout();

	/**
	 * Resource /v2/{merchantId}/hostedtokenizations
	 *
	 * @return HostedTokenizationClient
	 */
	HostedTokenizationClientInterface hostedTokenization();

	/**
	 * Resource /v2/{merchantId}/mandates
	 *
	 * @return MandatesClient
	 */
	MandatesClientInterface mandates();

	/**
	 * Resource /v2/{merchantId}/payments
	 *
	 * @return PaymentsClient
	 */
	PaymentsClientInterface payments();

	/**
	 * Resource /v2/{merchantId}/payouts
	 *
	 * @return PayoutsClient
	 */
	PayoutsClientInterface payouts();

	/**
	 * Resource /v2/{merchantId}/productgroups
	 *
	 * @return ProductGroupsClient
	 */
	ProductGroupsClientInterface productGroups();

	/**
	 * Resource /v2/{merchantId}/products
	 *
	 * @return ProductsClient
	 */
	ProductsClientInterface products();

	/**
	 * Resource /v2/{merchantId}/services
	 *
	 * @return ServicesClient
	 */
	ServicesClientInterface services();

	/**
	 * Resource /v2/{merchantId}/sessions
	 *
	 * @return SessionsClient
	 */
	SessionsClientInterface sessions();

	/**
	 * Resource /v2/{merchantId}/tokens
	 *
	 * @return TokensClient
	 */
	TokensClientInterface tokens();
}
