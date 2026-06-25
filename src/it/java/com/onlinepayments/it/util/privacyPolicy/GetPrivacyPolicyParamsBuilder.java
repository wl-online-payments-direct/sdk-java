package com.onlinepayments.it.util.privacyPolicy;

import com.onlinepayments.merchant.privacypolicy.GetPrivacyPolicyParams;

public class GetPrivacyPolicyParamsBuilder {

    private String locale = "en_US";
    private Integer paymentProductId;

    public GetPrivacyPolicyParamsBuilder withLocale(String locale) {
        this.locale = locale;
        return this;
    }

    public GetPrivacyPolicyParamsBuilder withPaymentProductId(Integer paymentProductId) {
        this.paymentProductId = paymentProductId;
        return this;
    }

    public GetPrivacyPolicyParamsBuilder withEnglishLocale() {
        this.locale = "en_US";
        return this;
    }

    public GetPrivacyPolicyParamsBuilder withDutchLocale() {
        this.locale = "nl_NL";
        return this;
    }

    public GetPrivacyPolicyParamsBuilder withFrenchLocale() {
        this.locale = "fr_FR";
        return this;
    }

    public GetPrivacyPolicyParamsBuilder withGermanLocale() {
        this.locale = "de_DE";
        return this;
    }

    public GetPrivacyPolicyParamsBuilder withVisaProduct() {
        this.paymentProductId = 1;
        return this;
    }

    public GetPrivacyPolicyParamsBuilder withAmericanExpressProduct() {
        this.paymentProductId = 2;
        return this;
    }

    public GetPrivacyPolicyParamsBuilder withMasterCardProduct() {
        this.paymentProductId = 3;
        return this;
    }

    public GetPrivacyPolicyParams build() {
        GetPrivacyPolicyParams params = new GetPrivacyPolicyParams();
        params.withLocale(locale);

        if (paymentProductId != null) {
            params.withPaymentProductId(paymentProductId);
        }

        return params;
    }
}
