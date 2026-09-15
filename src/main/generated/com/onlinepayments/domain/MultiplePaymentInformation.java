/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class MultiplePaymentInformation {

    private String paymentPattern;

    private Integer totalNumberOfPayments;

    /**
     * Typology of multiple payment. Allowed values:
     * <ul>
     *   <li>PartialShipment - I-P e-Commerce scenario whereby credentials have been stored to enable subsequent MITs per shipment. For this type of use case, PartialShipment is expected on both the initial CIT and eventual subsequent MITs to complete the order.</li>
     *   <li>Recurring - Transactions processed at fixed amount, regular intervals not to exceed one year between Transactions, representing an agreement between a cardholder and a merchant to purchase goods or services provided over a period of time. Note that a recurring MIT transaction is initiated by the merchant (payee) not the customer (payer) and so is out of scope of PSD2. Recurring transactions that are in scope of PSD2 (and therefore may benefit from the recurring transaction exemption) are those that are customer (payer) initiates, e.g. standing orders set up from a bank account.</li>
     *   <li>Unscheduled - A transaction using a stored credential for a variable amount that does not occur on a scheduled or regularly occurring transaction date, where the cardholder has provided consent for the merchant to initiate one or more future transactions which are not initiated by the cardholder. This transaction type is based on an agreement with the cardholder and is not to be confused with cardholder initiated transactions performed with stored credentials (CITs are in scope of PSD2 whereas UCOF transactions are MITs and thus out of scope).</li>
     *   <li>RecurringVariable - Transactions processed at variable amount, regular intervals not to exceed one year between Transactions, representing an agreement between a cardholder and a merchant to purchase goods or services provided over a period of time. Note that a recurring MIT transaction is initiated by the merchant (payee) not the customer (payer) and so is out of scope of PSD2. Recurring transactions that are in scope of PSD2 (and therefore may benefit from the recurring transaction exemption) are those that are customer (payer) initiates, e.g. standing orders set up from a bank account.</li>
     *   <li>UnscheduledFixed - A transaction using a stored credential for a fixed amount that does not occur on a scheduled or regularly occurring transaction date, where the cardholder has provided consent for the merchant to initiate one or more future transactions which are not initiated by the cardholder. This transaction type is based on an agreement with the cardholder and is not to be confused with cardholder initiated transactions performed with stored credentials (CITs are in scope of PSD2 whereas UCOF transactions are MITs and thus out of scope).</li>
     * </ul>
     */
    public String getPaymentPattern() {
        return paymentPattern;
    }

    /**
     * Typology of multiple payment. Allowed values:
     * <ul>
     *   <li>PartialShipment - I-P e-Commerce scenario whereby credentials have been stored to enable subsequent MITs per shipment. For this type of use case, PartialShipment is expected on both the initial CIT and eventual subsequent MITs to complete the order.</li>
     *   <li>Recurring - Transactions processed at fixed amount, regular intervals not to exceed one year between Transactions, representing an agreement between a cardholder and a merchant to purchase goods or services provided over a period of time. Note that a recurring MIT transaction is initiated by the merchant (payee) not the customer (payer) and so is out of scope of PSD2. Recurring transactions that are in scope of PSD2 (and therefore may benefit from the recurring transaction exemption) are those that are customer (payer) initiates, e.g. standing orders set up from a bank account.</li>
     *   <li>Unscheduled - A transaction using a stored credential for a variable amount that does not occur on a scheduled or regularly occurring transaction date, where the cardholder has provided consent for the merchant to initiate one or more future transactions which are not initiated by the cardholder. This transaction type is based on an agreement with the cardholder and is not to be confused with cardholder initiated transactions performed with stored credentials (CITs are in scope of PSD2 whereas UCOF transactions are MITs and thus out of scope).</li>
     *   <li>RecurringVariable - Transactions processed at variable amount, regular intervals not to exceed one year between Transactions, representing an agreement between a cardholder and a merchant to purchase goods or services provided over a period of time. Note that a recurring MIT transaction is initiated by the merchant (payee) not the customer (payer) and so is out of scope of PSD2. Recurring transactions that are in scope of PSD2 (and therefore may benefit from the recurring transaction exemption) are those that are customer (payer) initiates, e.g. standing orders set up from a bank account.</li>
     *   <li>UnscheduledFixed - A transaction using a stored credential for a fixed amount that does not occur on a scheduled or regularly occurring transaction date, where the cardholder has provided consent for the merchant to initiate one or more future transactions which are not initiated by the cardholder. This transaction type is based on an agreement with the cardholder and is not to be confused with cardholder initiated transactions performed with stored credentials (CITs are in scope of PSD2 whereas UCOF transactions are MITs and thus out of scope).</li>
     * </ul>
     */
    public void setPaymentPattern(String value) {
        this.paymentPattern = value;
    }

    /**
     * Typology of multiple payment. Allowed values:
     * <ul>
     *   <li>PartialShipment - I-P e-Commerce scenario whereby credentials have been stored to enable subsequent MITs per shipment. For this type of use case, PartialShipment is expected on both the initial CIT and eventual subsequent MITs to complete the order.</li>
     *   <li>Recurring - Transactions processed at fixed amount, regular intervals not to exceed one year between Transactions, representing an agreement between a cardholder and a merchant to purchase goods or services provided over a period of time. Note that a recurring MIT transaction is initiated by the merchant (payee) not the customer (payer) and so is out of scope of PSD2. Recurring transactions that are in scope of PSD2 (and therefore may benefit from the recurring transaction exemption) are those that are customer (payer) initiates, e.g. standing orders set up from a bank account.</li>
     *   <li>Unscheduled - A transaction using a stored credential for a variable amount that does not occur on a scheduled or regularly occurring transaction date, where the cardholder has provided consent for the merchant to initiate one or more future transactions which are not initiated by the cardholder. This transaction type is based on an agreement with the cardholder and is not to be confused with cardholder initiated transactions performed with stored credentials (CITs are in scope of PSD2 whereas UCOF transactions are MITs and thus out of scope).</li>
     *   <li>RecurringVariable - Transactions processed at variable amount, regular intervals not to exceed one year between Transactions, representing an agreement between a cardholder and a merchant to purchase goods or services provided over a period of time. Note that a recurring MIT transaction is initiated by the merchant (payee) not the customer (payer) and so is out of scope of PSD2. Recurring transactions that are in scope of PSD2 (and therefore may benefit from the recurring transaction exemption) are those that are customer (payer) initiates, e.g. standing orders set up from a bank account.</li>
     *   <li>UnscheduledFixed - A transaction using a stored credential for a fixed amount that does not occur on a scheduled or regularly occurring transaction date, where the cardholder has provided consent for the merchant to initiate one or more future transactions which are not initiated by the cardholder. This transaction type is based on an agreement with the cardholder and is not to be confused with cardholder initiated transactions performed with stored credentials (CITs are in scope of PSD2 whereas UCOF transactions are MITs and thus out of scope).</li>
     * </ul>
     */
    public MultiplePaymentInformation withPaymentPattern(String value) {
        this.paymentPattern = value;
        return this;
    }

    /**
     * Total number of payments. If a payment is implied by this call, it implicitly has ordinal number 1.
     */
    public Integer getTotalNumberOfPayments() {
        return totalNumberOfPayments;
    }

    /**
     * Total number of payments. If a payment is implied by this call, it implicitly has ordinal number 1.
     */
    public void setTotalNumberOfPayments(Integer value) {
        this.totalNumberOfPayments = value;
    }

    /**
     * Total number of payments. If a payment is implied by this call, it implicitly has ordinal number 1.
     */
    public MultiplePaymentInformation withTotalNumberOfPayments(Integer value) {
        this.totalNumberOfPayments = value;
        return this;
    }
}
