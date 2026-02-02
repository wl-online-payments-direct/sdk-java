/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.time.LocalDate;

public class RedirectPaymentProduct11SpecificInput {

    private LocalDate firstInstallmentPaymentDate;

    /**
     * The first installment date must be given in the YYYYMMDD format.
     */
    public LocalDate getFirstInstallmentPaymentDate() {
        return firstInstallmentPaymentDate;
    }

    /**
     * The first installment date must be given in the YYYYMMDD format.
     */
    public void setFirstInstallmentPaymentDate(LocalDate value) {
        this.firstInstallmentPaymentDate = value;
    }

    /**
     * The first installment date must be given in the YYYYMMDD format.
     */
    public RedirectPaymentProduct11SpecificInput withFirstInstallmentPaymentDate(LocalDate value) {
        this.firstInstallmentPaymentDate = value;
        return this;
    }
}
