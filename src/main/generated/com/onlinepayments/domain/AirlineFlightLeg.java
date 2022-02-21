/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

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
	 * Reservation Booking Designator
	 * This field is used by the following payment products: cards
	 */
	public AirlineFlightLeg withAirlineClass(String value) {
		this.airlineClass = value;
		return this;
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
	 * Arrival airport/city code
	 * This field is used by the following payment products: 840
	 */
	public AirlineFlightLeg withArrivalAirport(String value) {
		this.arrivalAirport = value;
		return this;
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
	 * The arrival time in the local time zone
	 * Format: HH:MM
	 * This field is used by the following payment products: 840
	 */
	public AirlineFlightLeg withArrivalTime(String value) {
		this.arrivalTime = value;
		return this;
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
	 * IATA carrier code
	 * This field is used by the following payment products: cards, 840
	 */
	public AirlineFlightLeg withCarrierCode(String value) {
		this.carrierCode = value;
		return this;
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
	 * Identifying number of a ticket issued to a passenger in conjunction with this ticket and that constitutes a single contract of carriage
	 * This field is used by the following payment products: 840
	 */
	public AirlineFlightLeg withConjunctionTicket(String value) {
		this.conjunctionTicket = value;
		return this;
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
	 * The coupon number associated with this leg of the trip. A ticket can contain several legs of travel, and each leg of travel requires a separate coupon
	 * This field is used by the following payment products: 840
	 */
	public AirlineFlightLeg withCouponNumber(String value) {
		this.couponNumber = value;
		return this;
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
	 * Date of the leg
	 * Format: YYYYMMDD
	 * This field is used by the following payment products: cards, 840
	 */
	public AirlineFlightLeg withDate(String value) {
		this.date = value;
		return this;
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
	 * The departure time in the local time at the departure airport
	 * Format: HH:MM
	 * This field is used by the following payment products: 840
	 */
	public AirlineFlightLeg withDepartureTime(String value) {
		this.departureTime = value;
		return this;
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
	 * An endorsement can be an agency-added notation or a mandatory government required notation, such as value-added tax. A restriction is a limitation based on the type of fare, such as a ticket with a 3-day minimum stay
	 * This field is used by the following payment products: 840
	 */
	public AirlineFlightLeg withEndorsementOrRestriction(String value) {
		this.endorsementOrRestriction = value;
		return this;
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
	 * New ticket number that is issued when a ticket is exchanged
	 * This field is used by the following payment products: 840
	 */
	public AirlineFlightLeg withExchangeTicket(String value) {
		this.exchangeTicket = value;
		return this;
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
	 * Deprecated: Use legFare instead.
	 * Fare of this leg
	 */
	public AirlineFlightLeg withFare(String value) {
		this.fare = value;
		return this;
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
	 * Fare Basis/Ticket Designator
	 * This field is used by the following payment products: 840
	 */
	public AirlineFlightLeg withFareBasis(String value) {
		this.fareBasis = value;
		return this;
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
	 * Fee for this leg of the trip
	 * This field is used by the following payment products: 840
	 */
	public AirlineFlightLeg withFee(Integer value) {
		this.fee = value;
		return this;
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
	 * The flight number assigned by the airline carrier with no leading spaces
	 * Should be a numeric string
	 * This field is used by the following payment products: cards, 840
	 */
	public AirlineFlightLeg withFlightNumber(String value) {
		this.flightNumber = value;
		return this;
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
	 * Fee for this leg of the trip
	 * This field is used by the following payment products: 840
	 */
	public AirlineFlightLeg withLegFare(Integer value) {
		this.legFare = value;
		return this;
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
	 * Deprecated: This field is not used by any payment product
	 * Sequence number of the flight leg
	 */
	public AirlineFlightLeg withNumber(Integer value) {
		this.number = value;
		return this;
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
	 * Origin airport/city code
	 * This field is used by the following payment products: cards, 840
	 */
	public AirlineFlightLeg withOriginAirport(String value) {
		this.originAirport = value;
		return this;
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
	 * PassengerClass if this leg
	 * This field is used by the following payment products: 840
	 */
	public AirlineFlightLeg withPassengerClass(String value) {
		this.passengerClass = value;
		return this;
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
	 * Possible values are:
	 *  * permitted = Stopover permitted
	 *  * non-permitted = Stopover not permitted
	 * This field is used by the following payment products: cards, 840
	 */
	public AirlineFlightLeg withStopoverCode(String value) {
		this.stopoverCode = value;
		return this;
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

	/**
	 * Taxes for this leg of the trip
	 * This field is used by the following payment products: 840
	 */
	public AirlineFlightLeg withTaxes(Integer value) {
		this.taxes = value;
		return this;
	}
}
