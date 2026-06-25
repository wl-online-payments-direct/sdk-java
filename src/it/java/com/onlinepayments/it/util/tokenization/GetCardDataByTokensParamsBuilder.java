package com.onlinepayments.it.util.tokenization;

import java.util.ArrayList;
import java.util.List;

import com.onlinepayments.merchant.tokenization.GetCardDataByTokensParams;

public class GetCardDataByTokensParamsBuilder {
    List<String> tokens = new ArrayList<>();

    public GetCardDataByTokensParamsBuilder withTokens(List<String> tokens) {
        this.tokens = tokens;
        return this;
    }

    public GetCardDataByTokensParams build() {
        return new GetCardDataByTokensParams().withTokens(tokens);
    }
}
