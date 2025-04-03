/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CurrencyConversionRequest {

    private DccCardSource cardSource;

    private Transaction transaction;

    public DccCardSource getCardSource() {
        return cardSource;
    }

    public void setCardSource(DccCardSource value) {
        this.cardSource = value;
    }

    public CurrencyConversionRequest withCardSource(DccCardSource value) {
        this.cardSource = value;
        return this;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction value) {
        this.transaction = value;
    }

    public CurrencyConversionRequest withTransaction(Transaction value) {
        this.transaction = value;
        return this;
    }
}
