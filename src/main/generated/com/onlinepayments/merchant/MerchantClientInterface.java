/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant;

import com.onlinepayments.merchant.captures.CapturesClientInterface;
import com.onlinepayments.merchant.complete.CompleteClientInterface;
import com.onlinepayments.merchant.hostedcheckout.HostedCheckoutClientInterface;
import com.onlinepayments.merchant.hostedtokenization.HostedTokenizationClientInterface;
import com.onlinepayments.merchant.mandates.MandatesClientInterface;
import com.onlinepayments.merchant.paymentlinks.PaymentLinksClientInterface;
import com.onlinepayments.merchant.payments.PaymentsClientInterface;
import com.onlinepayments.merchant.payouts.PayoutsClientInterface;
import com.onlinepayments.merchant.privacypolicy.PrivacyPolicyClientInterface;
import com.onlinepayments.merchant.productgroups.ProductGroupsClientInterface;
import com.onlinepayments.merchant.products.ProductsClientInterface;
import com.onlinepayments.merchant.refunds.RefundsClientInterface;
import com.onlinepayments.merchant.services.ServicesClientInterface;
import com.onlinepayments.merchant.sessions.SessionsClientInterface;
import com.onlinepayments.merchant.subsequent.SubsequentClientInterface;
import com.onlinepayments.merchant.tokens.TokensClientInterface;
import com.onlinepayments.merchant.webhooks.WebhooksClientInterface;

/**
 * Merchant client. Thread-safe.
 */
public interface MerchantClientInterface {

    /**
     * Resource /v2/{merchantId}/hostedcheckouts
     *
     * @return HostedCheckoutClientInterface
     */
    HostedCheckoutClientInterface hostedCheckout();

    /**
     * Resource /v2/{merchantId}/hostedtokenizations
     *
     * @return HostedTokenizationClientInterface
     */
    HostedTokenizationClientInterface hostedTokenization();

    /**
     * Resource /v2/{merchantId}/payments
     *
     * @return PaymentsClientInterface
     */
    PaymentsClientInterface payments();

    /**
     * Resource /v2/{merchantId}/payments/{paymentId}/captures
     *
     * @return CapturesClientInterface
     */
    CapturesClientInterface captures();

    /**
     * Resource /v2/{merchantId}/payments/{paymentId}/refunds
     *
     * @return RefundsClientInterface
     */
    RefundsClientInterface refunds();

    /**
     * Resource /v2/{merchantId}/payments/{paymentId}/complete
     *
     * @return CompleteClientInterface
     */
    CompleteClientInterface complete();

    /**
     * Resource /v2/{merchantId}/payments/{paymentId}/subsequent
     *
     * @return SubsequentClientInterface
     */
    SubsequentClientInterface subsequent();

    /**
     * Resource /v2/{merchantId}/productgroups
     *
     * @return ProductGroupsClientInterface
     */
    ProductGroupsClientInterface productGroups();

    /**
     * Resource /v2/{merchantId}/products
     *
     * @return ProductsClientInterface
     */
    ProductsClientInterface products();

    /**
     * Resource /v2/{merchantId}/services/testconnection
     *
     * @return ServicesClientInterface
     */
    ServicesClientInterface services();

    /**
     * Resource /v2/{merchantId}/webhooks/validateCredentials
     *
     * @return WebhooksClientInterface
     */
    WebhooksClientInterface webhooks();

    /**
     * Resource /v2/{merchantId}/sessions
     *
     * @return SessionsClientInterface
     */
    SessionsClientInterface sessions();

    /**
     * Resource /v2/{merchantId}/tokens
     *
     * @return TokensClientInterface
     */
    TokensClientInterface tokens();

    /**
     * Resource /v2/{merchantId}/payouts
     *
     * @return PayoutsClientInterface
     */
    PayoutsClientInterface payouts();

    /**
     * Resource /v2/{merchantId}/mandates
     *
     * @return MandatesClientInterface
     */
    MandatesClientInterface mandates();

    /**
     * Resource /v2/{merchantId}/services/privacypolicy
     *
     * @return PrivacyPolicyClientInterface
     */
    PrivacyPolicyClientInterface privacyPolicy();

    /**
     * Resource /v2/{merchantId}/paymentlinks
     *
     * @return PaymentLinksClientInterface
     */
    PaymentLinksClientInterface paymentLinks();
}
