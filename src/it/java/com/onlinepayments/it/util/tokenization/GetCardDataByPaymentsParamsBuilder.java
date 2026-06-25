package com.onlinepayments.it.util.tokenization;

import java.util.ArrayList;
import java.util.List;

import com.onlinepayments.merchant.tokenization.GetCardDataByPaymentsParams;

public class GetCardDataByPaymentsParamsBuilder {
    List<String> payments = new ArrayList<>();

    public GetCardDataByPaymentsParamsBuilder withPayments(List<String> payments) {
        this.payments = payments;
        return this;
    }

    public GetCardDataByPaymentsParams build() {
        return new GetCardDataByPaymentsParams().withPayments(payments);
    }
}
