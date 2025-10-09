/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant;

import java.util.Map;

import com.onlinepayments.ApiResource;
import com.onlinepayments.merchant.captures.CapturesClient;
import com.onlinepayments.merchant.complete.CompleteClient;
import com.onlinepayments.merchant.hostedcheckout.HostedCheckoutClient;
import com.onlinepayments.merchant.hostedtokenization.HostedTokenizationClient;
import com.onlinepayments.merchant.mandates.MandatesClient;
import com.onlinepayments.merchant.paymentlinks.PaymentLinksClient;
import com.onlinepayments.merchant.payments.PaymentsClient;
import com.onlinepayments.merchant.payouts.PayoutsClient;
import com.onlinepayments.merchant.privacypolicy.PrivacyPolicyClient;
import com.onlinepayments.merchant.productgroups.ProductGroupsClient;
import com.onlinepayments.merchant.products.ProductsClient;
import com.onlinepayments.merchant.refunds.RefundsClient;
import com.onlinepayments.merchant.services.ServicesClient;
import com.onlinepayments.merchant.sessions.SessionsClient;
import com.onlinepayments.merchant.subsequent.SubsequentClient;
import com.onlinepayments.merchant.tokens.TokensClient;
import com.onlinepayments.merchant.webhooks.WebhooksClient;

/**
 * Merchant client. Thread-safe.
 */
public class MerchantClient extends ApiResource implements MerchantClientInterface {

    public MerchantClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public HostedCheckoutClient hostedCheckout() {
        return new HostedCheckoutClient(this, null);
    }

    /** {@inheritDoc} */
    @Override
    public HostedTokenizationClient hostedTokenization() {
        return new HostedTokenizationClient(this, null);
    }

    /** {@inheritDoc} */
    @Override
    public PaymentsClient payments() {
        return new PaymentsClient(this, null);
    }

    /** {@inheritDoc} */
    @Override
    public CapturesClient captures() {
        return new CapturesClient(this, null);
    }

    /** {@inheritDoc} */
    @Override
    public RefundsClient refunds() {
        return new RefundsClient(this, null);
    }

    /** {@inheritDoc} */
    @Override
    public CompleteClient complete() {
        return new CompleteClient(this, null);
    }

    /** {@inheritDoc} */
    @Override
    public SubsequentClient subsequent() {
        return new SubsequentClient(this, null);
    }

    /** {@inheritDoc} */
    @Override
    public ProductGroupsClient productGroups() {
        return new ProductGroupsClient(this, null);
    }

    /** {@inheritDoc} */
    @Override
    public ProductsClient products() {
        return new ProductsClient(this, null);
    }

    /** {@inheritDoc} */
    @Override
    public ServicesClient services() {
        return new ServicesClient(this, null);
    }

    /** {@inheritDoc} */
    @Override
    public WebhooksClient webhooks() {
        return new WebhooksClient(this, null);
    }

    /** {@inheritDoc} */
    @Override
    public SessionsClient sessions() {
        return new SessionsClient(this, null);
    }

    /** {@inheritDoc} */
    @Override
    public TokensClient tokens() {
        return new TokensClient(this, null);
    }

    /** {@inheritDoc} */
    @Override
    public PayoutsClient payouts() {
        return new PayoutsClient(this, null);
    }

    /** {@inheritDoc} */
    @Override
    public MandatesClient mandates() {
        return new MandatesClient(this, null);
    }

    /** {@inheritDoc} */
    @Override
    public PrivacyPolicyClient privacyPolicy() {
        return new PrivacyPolicyClient(this, null);
    }

    /** {@inheritDoc} */
    @Override
    public PaymentLinksClient paymentLinks() {
        return new PaymentLinksClient(this, null);
    }
}
