/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * Object that holds the data on the individual legs of the ticket
 */
public class AirlineFlightLeg {

	private String airlineClass = null;

	private String arrivalAirport = null;

	private String arrivalTime = null;

	private String carrierCode = null;

	private String conjunctionTicket = null;

	private String couponNumber = null;

	private String date = null;

	private String departureTime = null;

	private String endorsementOrRestriction = null;

	private String exchangeTicket = null;

	private String fare = null;

	private String fareBasis = null;

	private Integer fee = null;

	private String flightNumber = null;

	private Integer legFare = null;

	private Integer number = null;

	private String originAirport = null;

	private String passengerClass = null;

	private String stopoverCode = null;

	private Integer taxes = null;

	/**
	 * Reservation Booking Designator
	 * This field is used by the following payment products: cards
	 */
	public String getAirlineClass() {
		return airlineClass;
	}

	/**
	 * Reservation Booking Designator
	 * This field is used by the following payment products: cards
	 */
	public void setAirlineClass(String value) {
		this.airlineClass = value;
	}

	/**
	 * Arrival airport/city code
	 * This field is used by the following payment products: 840
	 */
	public String getArrivalAirport() {
		return arrivalAirport;
	}

	/**
	 * Arrival airport/city code
	 * This field is used by the following payment products: 840
	 */
	public void setArrivalAirport(String value) {
		this.arrivalAirport = value;
	}

	/**
	 * The arrival time in the local time zone
	 * Format: HH:MM
	 * This field is used by the following payment products: 840
	 */
	public String getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * The arrival time in the local time zone
	 * Format: HH:MM
	 * This field is used by the following payment products: 840
	 */
	public void setArrivalTime(String value) {
		this.arrivalTime = value;
	}

	/**
	 * IATA carrier code
	 * This field is used by the following payment products: cards, 840
	 */
	public String getCarrierCode() {
		return carrierCode;
	}

	/**
	 * IATA carrier code
	 * This field is used by the following payment products: cards, 840
	 */
	public void setCarrierCode(String value) {
		this.carrierCode = value;
	}

	/**
	 * Identifying number of a ticket issued to a passenger in conjunction with this ticket and that constitutes a single contract of carriage
	 * This field is used by the following payment products: 840
	 */
	public String getConjunctionTicket() {
		return conjunctionTicket;
	}

	/**
	 * Identifying number of a ticket issued to a passenger in conjunction with this ticket and that constitutes a single contract of carriage
	 * This field is used by the following payment products: 840
	 */
	public void setConjunctionTicket(String value) {
		this.conjunctionTicket = value;
	}

	/**
	 * The coupon number associated with this leg of the trip. A ticket can contain several legs of travel, and each leg of travel requires a separate coupon
	 * This field is used by the following payment products: 840
	 */
	public String getCouponNumber() {
		return couponNumber;
	}

	/**
	 * The coupon number associated with this leg of the trip. A ticket can contain several legs of travel, and each leg of travel requires a separate coupon
	 * This field is used by the following payment products: 840
	 */
	public void setCouponNumber(String value) {
		this.couponNumber = value;
	}

	/**
	 * Date of the leg
	 * Format: YYYYMMDD
	 * This field is used by the following payment products: cards, 840
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Date of the leg
	 * Format: YYYYMMDD
	 * This field is used by the following payment products: cards, 840
	 */
	public void setDate(String value) {
		this.date = value;
	}

	/**
	 * The departure time in the local time at the departure airport
	 * Format: HH:MM
	 * This field is used by the following payment products: 840
	 */
	public String getDepartureTime() {
		return departureTime;
	}

	/**
	 * The departure time in the local time at the departure airport
	 * Format: HH:MM
	 * This field is used by the following payment products: 840
	 */
	public void setDepartureTime(String value) {
		this.departureTime = value;
	}

	/**
	 * An endorsement can be an agency-added notation or a mandatory government required notation, such as value-added tax. A restriction is a limitation based on the type of fare, such as a ticket with a 3-day minimum stay
	 * This field is used by the following payment products: 840
	 */
	public String getEndorsementOrRestriction() {
		return endorsementOrRestriction;
	}

	/**
	 * An endorsement can be an agency-added notation or a mandatory government required notation, such as value-added tax. A restriction is a limitation based on the type of fare, such as a ticket with a 3-day minimum stay
	 * This field is used by the following payment products: 840
	 */
	public void setEndorsementOrRestriction(String value) {
		this.endorsementOrRestriction = value;
	}

	/**
	 * New ticket number that is issued when a ticket is exchanged
	 * This field is used by the following payment products: 840
	 */
	public String getExchangeTicket() {
		return exchangeTicket;
	}

	/**
	 * New ticket number that is issued when a ticket is exchanged
	 * This field is used by the following payment products: 840
	 */
	public void setExchangeTicket(String value) {
		this.exchangeTicket = value;
	}

	/**
	 * Deprecated: Use legFare instead.
	 * Fare of this leg
	 */
	public String getFare() {
		return fare;
	}

	/**
	 * Deprecated: Use legFare instead.
	 * Fare of this leg
	 */
	public void setFare(String value) {
		this.fare = value;
	}

	/**
	 * Fare Basis/Ticket Designator
	 * This field is used by the following payment products: 840
	 */
	public String getFareBasis() {
		return fareBasis;
	}

	/**
	 * Fare Basis/Ticket Designator
	 * This field is used by the following payment products: 840
	 */
	public void setFareBasis(String value) {
		this.fareBasis = value;
	}

	/**
	 * Fee for this leg of the trip
	 * This field is used by the following payment products: 840
	 */
	public Integer getFee() {
		return fee;
	}

	/**
	 * Fee for this leg of the trip
	 * This field is used by the following payment products: 840
	 */
	public void setFee(Integer value) {
		this.fee = value;
	}

	/**
	 * The flight number assigned by the airline carrier with no leading spaces
	 * Should be a numeric string
	 * This field is used by the following payment products: cards, 840
	 */
	public String getFlightNumber() {
		return flightNumber;
	}

	/**
	 * The flight number assigned by the airline carrier with no leading spaces
	 * Should be a numeric string
	 * This field is used by the following payment products: cards, 840
	 */
	public void setFlightNumber(String value) {
		this.flightNumber = value;
	}

	/**
	 * Fee for this leg of the trip
	 * This field is used by the following payment products: 840
	 */
	public Integer getLegFare() {
		return legFare;
	}

	/**
	 * Fee for this leg of the trip
	 * This field is used by the following payment products: 840
	 */
	public void setLegFare(Integer value) {
		this.legFare = value;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Sequence number of the flight leg
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Sequence number of the flight leg
	 */
	public void setNumber(Integer value) {
		this.number = value;
	}

	/**
	 * Origin airport/city code
	 * This field is used by the following payment products: cards, 840
	 */
	public String getOriginAirport() {
		return originAirport;
	}

	/**
	 * Origin airport/city code
	 * This field is used by the following payment products: cards, 840
	 */
	public void setOriginAirport(String value) {
		this.originAirport = value;
	}

	/**
	 * PassengerClass if this leg
	 * This field is used by the following payment products: 840
	 */
	public String getPassengerClass() {
		return passengerClass;
	}

	/**
	 * PassengerClass if this leg
	 * This field is used by the following payment products: 840
	 */
	public void setPassengerClass(String value) {
		this.passengerClass = value;
	}

	/**
	 * Possible values are:
	 *  * permitted = Stopover permitted
	 *  * non-permitted = Stopover not permitted
	 * This field is used by the following payment products: cards, 840
	 */
	public String getStopoverCode() {
		return stopoverCode;
	}

	/**
	 * Possible values are:
	 *  * permitted = Stopover permitted
	 *  * non-permitted = Stopover not permitted
	 * This field is used by the following payment products: cards, 840
	 */
	public void setStopoverCode(String value) {
		this.stopoverCode = value;
	}

	/**
	 * Taxes for this leg of the trip
	 * This field is used by the following payment products: 840
	 */
	public Integer getTaxes() {
		return taxes;
	}

	/**
	 * Taxes for this leg of the trip
	 * This field is used by the following payment products: 840
	 */
	public void setTaxes(Integer value) {
		this.taxes = value;
	}
}
