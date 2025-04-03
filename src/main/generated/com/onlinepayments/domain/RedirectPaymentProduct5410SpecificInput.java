/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.time.LocalDate;

public class RedirectPaymentProduct5410SpecificInput {

    private LocalDate secondInstallmentPaymentDate;

    /**
     * The date of the second installment (YYYYMMDD)
     */
    public LocalDate getSecondInstallmentPaymentDate() {
        return secondInstallmentPaymentDate;
    }

    /**
     * The date of the second installment (YYYYMMDD)
     */
    public void setSecondInstallmentPaymentDate(LocalDate value) {
        this.secondInstallmentPaymentDate = value;
    }

    /**
     * The date of the second installment (YYYYMMDD)
     */
    public RedirectPaymentProduct5410SpecificInput withSecondInstallmentPaymentDate(LocalDate value) {
        this.secondInstallmentPaymentDate = value;
        return this;
    }
}
