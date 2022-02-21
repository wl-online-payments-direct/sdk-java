/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing additional input on the order
 */
public class AdditionalOrderInput {

	private AirlineData airlineData = null;

	private LoanRecipient loanRecipient = null;

	private LodgingData lodgingData = null;

	private OrderTypeInformation typeInformation = null;

	/**
	 * Object that holds airline specific data
	 */
	public AirlineData getAirlineData() {
		return airlineData;
	}

	/**
	 * Object that holds airline specific data
	 */
	public void setAirlineData(AirlineData value) {
		this.airlineData = value;
	}

	/**
	 * Object that holds airline specific data
	 */
	public AdditionalOrderInput withAirlineData(AirlineData value) {
		this.airlineData = value;
		return this;
	}

	/**
	 * Object containing specific data regarding the recipient of a loan in the UK
	 */
	public LoanRecipient getLoanRecipient() {
		return loanRecipient;
	}

	/**
	 * Object containing specific data regarding the recipient of a loan in the UK
	 */
	public void setLoanRecipient(LoanRecipient value) {
		this.loanRecipient = value;
	}

	/**
	 * Object containing specific data regarding the recipient of a loan in the UK
	 */
	public AdditionalOrderInput withLoanRecipient(LoanRecipient value) {
		this.loanRecipient = value;
		return this;
	}

	/**
	 * Object that holds lodging specific data
	 */
	public LodgingData getLodgingData() {
		return lodgingData;
	}

	/**
	 * Object that holds lodging specific data
	 */
	public void setLodgingData(LodgingData value) {
		this.lodgingData = value;
	}

	/**
	 * Object that holds lodging specific data
	 */
	public AdditionalOrderInput withLodgingData(LodgingData value) {
		this.lodgingData = value;
		return this;
	}

	/**
	 * Object that holds the purchase and usage type indicators
	 */
	public OrderTypeInformation getTypeInformation() {
		return typeInformation;
	}

	/**
	 * Object that holds the purchase and usage type indicators
	 */
	public void setTypeInformation(OrderTypeInformation value) {
		this.typeInformation = value;
	}

	/**
	 * Object that holds the purchase and usage type indicators
	 */
	public AdditionalOrderInput withTypeInformation(OrderTypeInformation value) {
		this.typeInformation = value;
		return this;
	}
}
