/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing the specific input details for subsequent card payments
 */
public class SubsequentCardPaymentMethodSpecificInput {

	private String authorizationMode = null;

	private Integer paymentNumber = null;

	private String schemeReferenceData = null;

	private String subsequentType = null;

	private String token = null;

	private String transactionChannel = null;

	/**
	 * Determines the type of the authorization that will be used. Allowed values: 
	 *   * FINAL_AUTHORIZATION - The payment creation results in an authorization that is ready for capture. Final authorizations can't be reversed and need to be captured for the full amount within 7 days. 
	 *   * PRE_AUTHORIZATION - The payment creation results in a pre-authorization that is ready for capture. Pre-authortizations can be reversed and can be captured within 30 days. The capture amount can be lower than the authorized amount. 
	 *   * SALE - The payment creation results in an authorization that is already captured at the moment of approval. 
	 * 
	 *   Only used with some acquirers, ignored for acquirers that do not support this. In case the acquirer does not allow this to be specified the authorizationMode is 'unspecified', which behaves similar to a final authorization.
	 */
	public String getAuthorizationMode() {
		return authorizationMode;
	}

	/**
	 * Determines the type of the authorization that will be used. Allowed values: 
	 *   * FINAL_AUTHORIZATION - The payment creation results in an authorization that is ready for capture. Final authorizations can't be reversed and need to be captured for the full amount within 7 days. 
	 *   * PRE_AUTHORIZATION - The payment creation results in a pre-authorization that is ready for capture. Pre-authortizations can be reversed and can be captured within 30 days. The capture amount can be lower than the authorized amount. 
	 *   * SALE - The payment creation results in an authorization that is already captured at the moment of approval. 
	 * 
	 *   Only used with some acquirers, ignored for acquirers that do not support this. In case the acquirer does not allow this to be specified the authorizationMode is 'unspecified', which behaves similar to a final authorization.
	 */
	public void setAuthorizationMode(String value) {
		this.authorizationMode = value;
	}

	/**
	 * Determines the type of the authorization that will be used. Allowed values: 
	 *   * FINAL_AUTHORIZATION - The payment creation results in an authorization that is ready for capture. Final authorizations can't be reversed and need to be captured for the full amount within 7 days. 
	 *   * PRE_AUTHORIZATION - The payment creation results in a pre-authorization that is ready for capture. Pre-authortizations can be reversed and can be captured within 30 days. The capture amount can be lower than the authorized amount. 
	 *   * SALE - The payment creation results in an authorization that is already captured at the moment of approval. 
	 * 
	 *   Only used with some acquirers, ignored for acquirers that do not support this. In case the acquirer does not allow this to be specified the authorizationMode is 'unspecified', which behaves similar to a final authorization.
	 */
	public SubsequentCardPaymentMethodSpecificInput withAuthorizationMode(String value) {
		this.authorizationMode = value;
		return this;
	}

	/**
	 * This payment's ordinal number in the sequence of payments. <br> As the payments are numbered from 1 to the totalNumberOfPayments provided at initialization of the sequence in the multiplePaymentInformation container, the allowed values for this field actually depend on whether the initial call to CreatePayment or CreateHostedCheckout led to a payment or not. <br>
	 *   - if the initial call led to a payment, since it is implicitly numbered 1, then the allowed values for this field range from 2 to the totalNumberOfPayments.
	 *   - if the initial call did not lead to a payment (e.g. this was a 0 amount operation for authentication), then the allowed values for this field range from 1 to the totalNumberOfPayments.
	 */
	public Integer getPaymentNumber() {
		return paymentNumber;
	}

	/**
	 * This payment's ordinal number in the sequence of payments. <br> As the payments are numbered from 1 to the totalNumberOfPayments provided at initialization of the sequence in the multiplePaymentInformation container, the allowed values for this field actually depend on whether the initial call to CreatePayment or CreateHostedCheckout led to a payment or not. <br>
	 *   - if the initial call led to a payment, since it is implicitly numbered 1, then the allowed values for this field range from 2 to the totalNumberOfPayments.
	 *   - if the initial call did not lead to a payment (e.g. this was a 0 amount operation for authentication), then the allowed values for this field range from 1 to the totalNumberOfPayments.
	 */
	public void setPaymentNumber(Integer value) {
		this.paymentNumber = value;
	}

	/**
	 * This payment's ordinal number in the sequence of payments. <br> As the payments are numbered from 1 to the totalNumberOfPayments provided at initialization of the sequence in the multiplePaymentInformation container, the allowed values for this field actually depend on whether the initial call to CreatePayment or CreateHostedCheckout led to a payment or not. <br>
	 *   - if the initial call led to a payment, since it is implicitly numbered 1, then the allowed values for this field range from 2 to the totalNumberOfPayments.
	 *   - if the initial call did not lead to a payment (e.g. this was a 0 amount operation for authentication), then the allowed values for this field range from 1 to the totalNumberOfPayments.
	 */
	public SubsequentCardPaymentMethodSpecificInput withPaymentNumber(Integer value) {
		this.paymentNumber = value;
		return this;
	}

	/**
	 * Deprecated: This is the unique Scheme Reference Data from the initial transaction that was performed with a Strong Customer Authentication. In case this value is unknown, a Scheme Reference of an earlier transaction that was part of the same sequence can be used as a fall-back. Still, it is strongly advised to submit this value for any Merchant Initiated Transaction or any recurring transaction (hereby defined as "Subsequent").
	 */
	public String getSchemeReferenceData() {
		return schemeReferenceData;
	}

	/**
	 * Deprecated: This is the unique Scheme Reference Data from the initial transaction that was performed with a Strong Customer Authentication. In case this value is unknown, a Scheme Reference of an earlier transaction that was part of the same sequence can be used as a fall-back. Still, it is strongly advised to submit this value for any Merchant Initiated Transaction or any recurring transaction (hereby defined as "Subsequent").
	 */
	public void setSchemeReferenceData(String value) {
		this.schemeReferenceData = value;
	}

	/**
	 * Deprecated: This is the unique Scheme Reference Data from the initial transaction that was performed with a Strong Customer Authentication. In case this value is unknown, a Scheme Reference of an earlier transaction that was part of the same sequence can be used as a fall-back. Still, it is strongly advised to submit this value for any Merchant Initiated Transaction or any recurring transaction (hereby defined as "Subsequent").
	 */
	public SubsequentCardPaymentMethodSpecificInput withSchemeReferenceData(String value) {
		this.schemeReferenceData = value;
		return this;
	}

	/**
	 * Determines the type of the subsequent that will be used. Allowed values: 
	 *   * Recurring - Transactions processed at fixed, regular intervals not to exceed one year between Transactions, representing an agreement between a cardholder and a merchant to purchase goods or services provided over a period of time. Note that a recurring MIT transaction is initiated by the merchant (payee) not the customer (payer) and so is out of scope of PSD2. Recurring transactions that are in scope of PSD2 (and therefore may benefit from the recurring transaction exemption) are those that are customer (payer) initiates, e.g. standing orders set up from a bank account. 
	 *   * Unscheduled - A transaction using a stored credential for a fixed or variable amount that does not occur on a scheduled or regularly occurring transaction date, where the cardholder has provided consent for the merchant to initiate one or more future transactions which are not initiated by the cardholder. This transaction type is based on an agreement with the cardholder and is not to be confused with cardholder initiated transactions performed with stored credentials (CITs are in scope of PSD2 whereas UCOF transactions are MITs and thus out of scope). 
	 *   * Installment - Installment payments describe a single purchase of goods or services billed to a cardholder in multiple transactions over a period of time agreed by the cardholder and merchant. 
	 *   * NoShow - A No-show is a transaction where the merchant is enabled to charge for services which the cardholder entered into an agreement to purchase but did not meet the terms of the agreement.
	 *   * DelayedCharge - A delayed charge is typically used in hotel, cruise lines and vehicle rental payment scenarios to perform a supplemental account charge after original services are rendered.
	 *   * PartialShipment - I-P e-Commerce scenario whereby credentials have been stored to enable subsequent MITs per shipment. For this type of use case, PartialShipment is expected on both the initial CIT and eventual subsequent MITs to complete the order.
	 *   * Resubmission - This is an event that occurs when the original purchase occurred, but the merchant was not able to get authorization at the time the goods or services were provided. This is only applicable to contactless transit transactions.
	 */
	public String getSubsequentType() {
		return subsequentType;
	}

	/**
	 * Determines the type of the subsequent that will be used. Allowed values: 
	 *   * Recurring - Transactions processed at fixed, regular intervals not to exceed one year between Transactions, representing an agreement between a cardholder and a merchant to purchase goods or services provided over a period of time. Note that a recurring MIT transaction is initiated by the merchant (payee) not the customer (payer) and so is out of scope of PSD2. Recurring transactions that are in scope of PSD2 (and therefore may benefit from the recurring transaction exemption) are those that are customer (payer) initiates, e.g. standing orders set up from a bank account. 
	 *   * Unscheduled - A transaction using a stored credential for a fixed or variable amount that does not occur on a scheduled or regularly occurring transaction date, where the cardholder has provided consent for the merchant to initiate one or more future transactions which are not initiated by the cardholder. This transaction type is based on an agreement with the cardholder and is not to be confused with cardholder initiated transactions performed with stored credentials (CITs are in scope of PSD2 whereas UCOF transactions are MITs and thus out of scope). 
	 *   * Installment - Installment payments describe a single purchase of goods or services billed to a cardholder in multiple transactions over a period of time agreed by the cardholder and merchant. 
	 *   * NoShow - A No-show is a transaction where the merchant is enabled to charge for services which the cardholder entered into an agreement to purchase but did not meet the terms of the agreement.
	 *   * DelayedCharge - A delayed charge is typically used in hotel, cruise lines and vehicle rental payment scenarios to perform a supplemental account charge after original services are rendered.
	 *   * PartialShipment - I-P e-Commerce scenario whereby credentials have been stored to enable subsequent MITs per shipment. For this type of use case, PartialShipment is expected on both the initial CIT and eventual subsequent MITs to complete the order.
	 *   * Resubmission - This is an event that occurs when the original purchase occurred, but the merchant was not able to get authorization at the time the goods or services were provided. This is only applicable to contactless transit transactions.
	 */
	public void setSubsequentType(String value) {
		this.subsequentType = value;
	}

	/**
	 * Determines the type of the subsequent that will be used. Allowed values: 
	 *   * Recurring - Transactions processed at fixed, regular intervals not to exceed one year between Transactions, representing an agreement between a cardholder and a merchant to purchase goods or services provided over a period of time. Note that a recurring MIT transaction is initiated by the merchant (payee) not the customer (payer) and so is out of scope of PSD2. Recurring transactions that are in scope of PSD2 (and therefore may benefit from the recurring transaction exemption) are those that are customer (payer) initiates, e.g. standing orders set up from a bank account. 
	 *   * Unscheduled - A transaction using a stored credential for a fixed or variable amount that does not occur on a scheduled or regularly occurring transaction date, where the cardholder has provided consent for the merchant to initiate one or more future transactions which are not initiated by the cardholder. This transaction type is based on an agreement with the cardholder and is not to be confused with cardholder initiated transactions performed with stored credentials (CITs are in scope of PSD2 whereas UCOF transactions are MITs and thus out of scope). 
	 *   * Installment - Installment payments describe a single purchase of goods or services billed to a cardholder in multiple transactions over a period of time agreed by the cardholder and merchant. 
	 *   * NoShow - A No-show is a transaction where the merchant is enabled to charge for services which the cardholder entered into an agreement to purchase but did not meet the terms of the agreement.
	 *   * DelayedCharge - A delayed charge is typically used in hotel, cruise lines and vehicle rental payment scenarios to perform a supplemental account charge after original services are rendered.
	 *   * PartialShipment - I-P e-Commerce scenario whereby credentials have been stored to enable subsequent MITs per shipment. For this type of use case, PartialShipment is expected on both the initial CIT and eventual subsequent MITs to complete the order.
	 *   * Resubmission - This is an event that occurs when the original purchase occurred, but the merchant was not able to get authorization at the time the goods or services were provided. This is only applicable to contactless transit transactions.
	 */
	public SubsequentCardPaymentMethodSpecificInput withSubsequentType(String value) {
		this.subsequentType = value;
		return this;
	}

	/**
	 * Deprecated: ID of the token to use to create the payment.
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Deprecated: ID of the token to use to create the payment.
	 */
	public void setToken(String value) {
		this.token = value;
	}

	/**
	 * Deprecated: ID of the token to use to create the payment.
	 */
	public SubsequentCardPaymentMethodSpecificInput withToken(String value) {
		this.token = value;
		return this;
	}

	/**
	 * Indicates the channel via which the payment is created. Allowed values:
	 *   * ECOMMERCE - The transaction is a regular E-Commerce transaction.
	 *   * MOTO - The transaction is a Mail Order/Telephone Order.
	 * 
	 *   Defaults to ECOMMERCE.
	 */
	public String getTransactionChannel() {
		return transactionChannel;
	}

	/**
	 * Indicates the channel via which the payment is created. Allowed values:
	 *   * ECOMMERCE - The transaction is a regular E-Commerce transaction.
	 *   * MOTO - The transaction is a Mail Order/Telephone Order.
	 * 
	 *   Defaults to ECOMMERCE.
	 */
	public void setTransactionChannel(String value) {
		this.transactionChannel = value;
	}

	/**
	 * Indicates the channel via which the payment is created. Allowed values:
	 *   * ECOMMERCE - The transaction is a regular E-Commerce transaction.
	 *   * MOTO - The transaction is a Mail Order/Telephone Order.
	 * 
	 *   Defaults to ECOMMERCE.
	 */
	public SubsequentCardPaymentMethodSpecificInput withTransactionChannel(String value) {
		this.transactionChannel = value;
		return this;
	}
}
