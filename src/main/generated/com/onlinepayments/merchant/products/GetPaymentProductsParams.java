/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.products;

import java.util.ArrayList;
import java.util.List;

import com.onlinepayments.communication.ParamRequest;
import com.onlinepayments.communication.RequestParam;

/**
 * Query parameters for
 * Get payment products (/v2/{merchantId}/products)
 */
public class GetPaymentProductsParams implements ParamRequest {

    private String countryCode;

    private String currencyCode;

    private String locale;

    private Long amount;

    private Boolean isRecurring;

    private List<String> hide;

    /**
     * ISO 3166-1 alpha-2 country code of the transaction
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * ISO 3166-1 alpha-2 country code of the transaction
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * ISO 3166-1 alpha-2 country code of the transaction
     */
    public GetPaymentProductsParams withCountryCode(String value) {
        this.countryCode = value;
        return this;
    }

    /**
     * Three-letter ISO currency code representing the currency for the amount
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Three-letter ISO currency code representing the currency for the amount
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Three-letter ISO currency code representing the currency for the amount
     */
    public GetPaymentProductsParams withCurrencyCode(String value) {
        this.currencyCode = value;
        return this;
    }

    /**
     * Locale used in the GUI towards the consumer.
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Locale used in the GUI towards the consumer.
     */
    public void setLocale(String value) {
        this.locale = value;
    }

    /**
     * Locale used in the GUI towards the consumer.
     */
    public GetPaymentProductsParams withLocale(String value) {
        this.locale = value;
        return this;
    }

    /**
     * Whole amount in cents (not containing any decimals)
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * Whole amount in cents (not containing any decimals)
     */
    public void setAmount(Long value) {
        this.amount = value;
    }

    /**
     * Whole amount in cents (not containing any decimals)
     */
    public GetPaymentProductsParams withAmount(Long value) {
        this.amount = value;
        return this;
    }

    /**
     * This allows you to filter payment products based on their support for recurring payments.
     * <ul>
     *   <li>true - return only payment products that support recurring payments,</li>
     *   <li>false - return all payment products that support one-time transactions. Payment products that support recurring products are usually also part of this list.</li>
     * </ul>
     */
    public Boolean getIsRecurring() {
        return isRecurring;
    }

    /**
     * This allows you to filter payment products based on their support for recurring payments.
     * <ul>
     *   <li>true - return only payment products that support recurring payments,</li>
     *   <li>false - return all payment products that support one-time transactions. Payment products that support recurring products are usually also part of this list.</li>
     * </ul>
     */
    public void setIsRecurring(Boolean value) {
        this.isRecurring = value;
    }

    /**
     * This allows you to filter payment products based on their support for recurring payments.
     * <ul>
     *   <li>true - return only payment products that support recurring payments,</li>
     *   <li>false - return all payment products that support one-time transactions. Payment products that support recurring products are usually also part of this list.</li>
     * </ul>
     */
    public GetPaymentProductsParams withIsRecurring(Boolean value) {
        this.isRecurring = value;
        return this;
    }

    /**
     * Allows you to hide elements from the response, reducing the amount of data that needs to be returned to your client. Possible options are:
     * <ul>
     *   <li>fields - Do not return any data on fields of the payment product</li>
     *   <li>accountsOnFile - Do not return any accounts on file data</li>
     *   <li>translations - Do not return any label texts associated with the payment products</li>
     *   <li>productsWithoutFields - Do not return products that require any additional data to be captured</li>
     *   <li>productsWithoutInstructions - Do not return products that show instructions</li>
     *   <li>productsWithRedirects - Do not return products that require a redirect to a third party. Note that products that involve potential redirects related to 3D Secure authentication are not hidden</li>
     * </ul>
     */
    public List<String> getHide() {
        return hide;
    }

    /**
     * Allows you to hide elements from the response, reducing the amount of data that needs to be returned to your client. Possible options are:
     * <ul>
     *   <li>fields - Do not return any data on fields of the payment product</li>
     *   <li>accountsOnFile - Do not return any accounts on file data</li>
     *   <li>translations - Do not return any label texts associated with the payment products</li>
     *   <li>productsWithoutFields - Do not return products that require any additional data to be captured</li>
     *   <li>productsWithoutInstructions - Do not return products that show instructions</li>
     *   <li>productsWithRedirects - Do not return products that require a redirect to a third party. Note that products that involve potential redirects related to 3D Secure authentication are not hidden</li>
     * </ul>
     */
    public void setHide(List<String> value) {
        this.hide = value;
    }

    /**
     * Allows you to hide elements from the response, reducing the amount of data that needs to be returned to your client. Possible options are:
     * <ul>
     *   <li>fields - Do not return any data on fields of the payment product</li>
     *   <li>accountsOnFile - Do not return any accounts on file data</li>
     *   <li>translations - Do not return any label texts associated with the payment products</li>
     *   <li>productsWithoutFields - Do not return products that require any additional data to be captured</li>
     *   <li>productsWithoutInstructions - Do not return products that show instructions</li>
     *   <li>productsWithRedirects - Do not return products that require a redirect to a third party. Note that products that involve potential redirects related to 3D Secure authentication are not hidden</li>
     * </ul>
     */
    public GetPaymentProductsParams withHide(List<String> value) {
        this.hide = value;
        return this;
    }

    /**
     * Allows you to hide elements from the response, reducing the amount of data that needs to be returned to your client. Possible options are:
     * <ul>
     *   <li>fields - Do not return any data on fields of the payment product</li>
     *   <li>accountsOnFile - Do not return any accounts on file data</li>
     *   <li>translations - Do not return any label texts associated with the payment products</li>
     *   <li>productsWithoutFields - Do not return products that require any additional data to be captured</li>
     *   <li>productsWithoutInstructions - Do not return products that show instructions</li>
     *   <li>productsWithRedirects - Do not return products that require a redirect to a third party. Note that products that involve potential redirects related to 3D Secure authentication are not hidden</li>
     * </ul>
     */
    public void addHide(String value) {
        if (this.hide == null) {
            this.hide = new ArrayList<>();
        }
        this.hide.add(value);
    }

    @Override
    public List<RequestParam> toRequestParameters() {
        List<RequestParam> result = new ArrayList<>();
        if (countryCode != null) {
            result.add(new RequestParam("countryCode", countryCode));
        }
        if (currencyCode != null) {
            result.add(new RequestParam("currencyCode", currencyCode));
        }
        if (locale != null) {
            result.add(new RequestParam("locale", locale));
        }
        if (amount != null) {
            result.add(new RequestParam("amount", amount.toString()));
        }
        if (isRecurring != null) {
            result.add(new RequestParam("isRecurring", isRecurring.toString()));
        }
        if (hide != null) {
            for (String hideElement : hide) {
                if (hideElement != null) {
                    result.add(new RequestParam("hide", hideElement));
                }
            }
        }
        return result;
    }
}
