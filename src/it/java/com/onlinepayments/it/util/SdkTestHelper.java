package com.onlinepayments.it.util;

import java.util.ArrayList;
import java.util.UUID;

import com.onlinepayments.domain.CreatePaymentRequest;
import com.onlinepayments.it.util.common.CreatePaymentRequestBuilder;
import com.onlinepayments.it.util.common.CreateTokenRequestBuilder;
import com.onlinepayments.it.util.hostedTokenization.CreateHostedTokenizationRequestBuilder;
import com.onlinepayments.it.util.mandates.CreateMandateRequestBuilder;
import com.onlinepayments.it.util.merchantBatch.SubmitBatchRequestBodyBuilder;
import com.onlinepayments.it.util.paymentLink.CreatePaymentLinkRequestBuilder;
import com.onlinepayments.it.util.payout.CreatePayoutRequestBuilder;
import com.onlinepayments.merchant.MerchantClientInterface;

public final class SdkTestHelper {

    private final MerchantClientInterface merchantClient;

    public SdkTestHelper(MerchantClientInterface merchantClient) {
        this.merchantClient = merchantClient;
    }

    public String createPaymentAndGetId() {
        return createPaymentAndGetId(new CreatePaymentRequestBuilder());
    }

    public String createPaymentAndGetId(long amount, String currency) {
        return createPaymentAndGetId(
            new CreatePaymentRequestBuilder().withAmount(amount).withCurrency(currency));
    }

    public String createPayPalPaymentAndGetId() {

        return merchantClient
                .payments()
                .createPayment(new CreatePaymentRequestBuilder().withPayPalRedirectPaymentMethod().build())
                .getPayment()
                .getId();
    }

    public String createTokenAndGetId() {
        return merchantClient
                .tokens()
                .createToken(new CreateTokenRequestBuilder().build())
                .getToken();
    }

    public String createHostedTokenizationAndGetId() {
        return merchantClient
                .hostedTokenization()
                .createHostedTokenization(new CreateHostedTokenizationRequestBuilder().build())
                .getHostedTokenizationId();
    }

    public String createMandateAndGetReference() {
        return merchantClient
                .mandates()
                .createMandate(new CreateMandateRequestBuilder()
                    .withUniqueMandateReference(UUID.randomUUID().toString().substring(0, 35))
                    .build())
                .getMandate()
                .getUniqueMandateReference();
    }

    public String submitBatchAndGetReference(
            ArrayList<CreatePaymentRequest> requests,
            String operationType,
            int itemCount) {
        return submitBatchAndGetReference(new SubmitBatchRequestBodyBuilder()
                .withCreatePaymentRequests(requests)
                .withOperationType(operationType)
                .withItemCount(itemCount));
    }

    public String createPaymentLinkAndGetId() {
        return createPaymentLinkAndGetId(new CreatePaymentLinkRequestBuilder());
    }

    public String createPayoutAndGetId() {
        return createPayoutAndGetId(new CreatePayoutRequestBuilder());
    }

    public String createValidTokenAndGetId() {
        return merchantClient
                .tokens()
                .createToken(new CreateTokenRequestBuilder().build())
                .getToken();
    }

    private String createPaymentAndGetId(CreatePaymentRequestBuilder requestBuilder) {
        return merchantClient
                .payments()
                .createPayment(requestBuilder.build())
                .getPayment()
                .getId();
    }

    private String submitBatchAndGetReference(SubmitBatchRequestBodyBuilder requestBuilder) {
        return merchantClient
                .merchantBatch()
                .submitBatch(requestBuilder.build())
                .getMerchantBatchReference();
    }

    private String createPaymentLinkAndGetId(CreatePaymentLinkRequestBuilder requestBuilder) {
        return merchantClient
                .paymentLinks()
                .createPaymentLink(requestBuilder.build())
                .getPaymentLinkId();
    }

    private String createPayoutAndGetId(CreatePayoutRequestBuilder requestBuilder) {
        return merchantClient
                .payouts()
                .createPayout(requestBuilder.build())
                .getId();
    }
}
