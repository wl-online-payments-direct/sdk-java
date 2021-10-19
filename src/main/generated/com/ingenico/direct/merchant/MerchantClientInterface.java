/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.merchant;

import com.ingenico.direct.merchant.hostedcheckout.HostedCheckoutClientInterface;
import com.ingenico.direct.merchant.hostedtokenization.HostedTokenizationClientInterface;
import com.ingenico.direct.merchant.payments.PaymentsClientInterface;
import com.ingenico.direct.merchant.payouts.PayoutsClientInterface;
import com.ingenico.direct.merchant.productgroups.ProductGroupsClientInterface;
import com.ingenico.direct.merchant.products.ProductsClientInterface;
import com.ingenico.direct.merchant.services.ServicesClientInterface;
import com.ingenico.direct.merchant.sessions.SessionsClientInterface;
import com.ingenico.direct.merchant.tokens.TokensClientInterface;

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
