/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class AirlinePassenger {

	private String airlineLoyaltyStatus = null;

	private String firstName = null;

	private String passengerType = null;

	private String surname = null;

	private String surnamePrefix = null;

	private String title = null;

	/**
	 * Airline loyalty program level for the passenger on the itinerary.
	 */
	public String getAirlineLoyaltyStatus() {
		return airlineLoyaltyStatus;
	}

	/**
	 * Airline loyalty program level for the passenger on the itinerary.
	 */
	public void setAirlineLoyaltyStatus(String value) {
		this.airlineLoyaltyStatus = value;
	}

	/**
	 * Airline loyalty program level for the passenger on the itinerary.
	 */
	public AirlinePassenger withAirlineLoyaltyStatus(String value) {
		this.airlineLoyaltyStatus = value;
		return this;
	}

	/**
	 * First name of the passenger
	 * This field is used by the following payment products: cards, 840
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * First name of the passenger
	 * This field is used by the following payment products: cards, 840
	 */
	public void setFirstName(String value) {
		this.firstName = value;
	}

	/**
	 * First name of the passenger
	 * This field is used by the following payment products: cards, 840
	 */
	public AirlinePassenger withFirstName(String value) {
		this.firstName = value;
		return this;
	}

	/**
	 * Type of passenger on the itinerary. 
	 */
	public String getPassengerType() {
		return passengerType;
	}

	/**
	 * Type of passenger on the itinerary. 
	 */
	public void setPassengerType(String value) {
		this.passengerType = value;
	}

	/**
	 * Type of passenger on the itinerary. 
	 */
	public AirlinePassenger withPassengerType(String value) {
		this.passengerType = value;
		return this;
	}

	/**
	 * Surname of the passenger
	 * This field is used by the following payment products: cards, 840
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Surname of the passenger
	 * This field is used by the following payment products: cards, 840
	 */
	public void setSurname(String value) {
		this.surname = value;
	}

	/**
	 * Surname of the passenger
	 * This field is used by the following payment products: cards, 840
	 */
	public AirlinePassenger withSurname(String value) {
		this.surname = value;
		return this;
	}

	/**
	 * Surname prefix or middle name of the passenger
	 * This field is used by the following payment products: 840
	 */
	public String getSurnamePrefix() {
		return surnamePrefix;
	}

	/**
	 * Surname prefix or middle name of the passenger
	 * This field is used by the following payment products: 840
	 */
	public void setSurnamePrefix(String value) {
		this.surnamePrefix = value;
	}

	/**
	 * Surname prefix or middle name of the passenger
	 * This field is used by the following payment products: 840
	 */
	public AirlinePassenger withSurnamePrefix(String value) {
		this.surnamePrefix = value;
		return this;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Title of the passenger (this property is used for fraud screening on the payment platform)
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Title of the passenger (this property is used for fraud screening on the payment platform)
	 */
	public void setTitle(String value) {
		this.title = value;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Title of the passenger (this property is used for fraud screening on the payment platform)
	 */
	public AirlinePassenger withTitle(String value) {
		this.title = value;
		return this;
	}
}
