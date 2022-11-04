/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

import java.util.List;

/**
 * Object that holds airline specific data
 */
public class AirlineData {

	private String agentNumericCode = null;

	private String code = null;

	private String flightDate = null;

	private String flightIndicator = null;

	private List<AirlineFlightLeg> flightLegs = null;

	private String invoiceNumber = null;

	private Boolean isETicket = null;

	private Boolean isRestrictedTicket = null;

	private Boolean isThirdParty = null;

	private String issueDate = null;

	private String merchantCustomerId = null;

	private String name = null;

	private String passengerName = null;

	private List<AirlinePassenger> passengers = null;

	private String placeOfIssue = null;

	private String pnr = null;

	private String pointOfSale = null;

	private String posCityCode = null;

	private String ticketCurrency = null;

	private String ticketDeliveryMethod = null;

	private String ticketNumber = null;

	private Integer totalFare = null;

	private Integer totalFee = null;

	private Integer totalTaxes = null;

	private String travelAgencyName = null;

	/**
	 * Numeric code identifying the agent
	 * This field is used by the following payment products: 840
	 */
	public String getAgentNumericCode() {
		return agentNumericCode;
	}

	/**
	 * Numeric code identifying the agent
	 * This field is used by the following payment products: 840
	 */
	public void setAgentNumericCode(String value) {
		this.agentNumericCode = value;
	}

	/**
	 * Numeric code identifying the agent
	 * This field is used by the following payment products: 840
	 */
	public AirlineData withAgentNumericCode(String value) {
		this.agentNumericCode = value;
		return this;
	}

	/**
	 * Airline numeric code
	 * This field is used by the following payment products: 840
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Airline numeric code
	 * This field is used by the following payment products: 840
	 */
	public void setCode(String value) {
		this.code = value;
	}

	/**
	 * Airline numeric code
	 * This field is used by the following payment products: 840
	 */
	public AirlineData withCode(String value) {
		this.code = value;
		return this;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Date of the Flight
	 * Format: YYYYMMDD
	 */
	public String getFlightDate() {
		return flightDate;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Date of the Flight
	 * Format: YYYYMMDD
	 */
	public void setFlightDate(String value) {
		this.flightDate = value;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Date of the Flight
	 * Format: YYYYMMDD
	 */
	public AirlineData withFlightDate(String value) {
		this.flightDate = value;
		return this;
	}

	/**
	 * Indicator representing the type of flight on the itinerary.
	 */
	public String getFlightIndicator() {
		return flightIndicator;
	}

	/**
	 * Indicator representing the type of flight on the itinerary.
	 */
	public void setFlightIndicator(String value) {
		this.flightIndicator = value;
	}

	/**
	 * Indicator representing the type of flight on the itinerary.
	 */
	public AirlineData withFlightIndicator(String value) {
		this.flightIndicator = value;
		return this;
	}

	/**
	 * Object that holds the data on the individual legs of the flight ticket
	 */
	public List<AirlineFlightLeg> getFlightLegs() {
		return flightLegs;
	}

	/**
	 * Object that holds the data on the individual legs of the flight ticket
	 */
	public void setFlightLegs(List<AirlineFlightLeg> value) {
		this.flightLegs = value;
	}

	/**
	 * Object that holds the data on the individual legs of the flight ticket
	 */
	public AirlineData withFlightLegs(List<AirlineFlightLeg> value) {
		this.flightLegs = value;
		return this;
	}

	/**
	 * Airline tracing number
	 * This field is used by the following payment products: cards
	 */
	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	/**
	 * Airline tracing number
	 * This field is used by the following payment products: cards
	 */
	public void setInvoiceNumber(String value) {
		this.invoiceNumber = value;
	}

	/**
	 * Airline tracing number
	 * This field is used by the following payment products: cards
	 */
	public AirlineData withInvoiceNumber(String value) {
		this.invoiceNumber = value;
		return this;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 *  * true = The ticket is an E-Ticket
	 *  * false = the ticket is not an E-Ticket'
	 */
	public Boolean getIsETicket() {
		return isETicket;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 *  * true = The ticket is an E-Ticket
	 *  * false = the ticket is not an E-Ticket'
	 */
	public void setIsETicket(Boolean value) {
		this.isETicket = value;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 *  * true = The ticket is an E-Ticket
	 *  * false = the ticket is not an E-Ticket'
	 */
	public AirlineData withIsETicket(Boolean value) {
		this.isETicket = value;
		return this;
	}

	/**
	 * Indicates if the ticket is refundable or not.
	 *  * true - Restricted, the ticket is non-refundable
	 *  * false - No restrictions, the ticket is (partially) refundable
	 * This field is used by the following payment products: 840
	 */
	public Boolean getIsRestrictedTicket() {
		return isRestrictedTicket;
	}

	/**
	 * Indicates if the ticket is refundable or not.
	 *  * true - Restricted, the ticket is non-refundable
	 *  * false - No restrictions, the ticket is (partially) refundable
	 * This field is used by the following payment products: 840
	 */
	public void setIsRestrictedTicket(Boolean value) {
		this.isRestrictedTicket = value;
	}

	/**
	 * Indicates if the ticket is refundable or not.
	 *  * true - Restricted, the ticket is non-refundable
	 *  * false - No restrictions, the ticket is (partially) refundable
	 * This field is used by the following payment products: 840
	 */
	public AirlineData withIsRestrictedTicket(Boolean value) {
		this.isRestrictedTicket = value;
		return this;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 *  * true - The payer is the ticket holder
	 *  * false - The payer is not the ticket holder
	 */
	public Boolean getIsThirdParty() {
		return isThirdParty;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 *  * true - The payer is the ticket holder
	 *  * false - The payer is not the ticket holder
	 */
	public void setIsThirdParty(Boolean value) {
		this.isThirdParty = value;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 *  * true - The payer is the ticket holder
	 *  * false - The payer is not the ticket holder
	 */
	public AirlineData withIsThirdParty(Boolean value) {
		this.isThirdParty = value;
		return this;
	}

	/**
	 * This is the date of issue recorded in the airline system In a case of multiple issuances of the same ticket to a cardholder, you should use the last ticket date.
	 * Format: YYYYMMDD
	 * This field is used by the following payment products: cards, 840
	 */
	public String getIssueDate() {
		return issueDate;
	}

	/**
	 * This is the date of issue recorded in the airline system In a case of multiple issuances of the same ticket to a cardholder, you should use the last ticket date.
	 * Format: YYYYMMDD
	 * This field is used by the following payment products: cards, 840
	 */
	public void setIssueDate(String value) {
		this.issueDate = value;
	}

	/**
	 * This is the date of issue recorded in the airline system In a case of multiple issuances of the same ticket to a cardholder, you should use the last ticket date.
	 * Format: YYYYMMDD
	 * This field is used by the following payment products: cards, 840
	 */
	public AirlineData withIssueDate(String value) {
		this.issueDate = value;
		return this;
	}

	/**
	 * Your ID of the customer in the context of the airline data
	 * This field is used by the following payment products: 840
	 */
	public String getMerchantCustomerId() {
		return merchantCustomerId;
	}

	/**
	 * Your ID of the customer in the context of the airline data
	 * This field is used by the following payment products: 840
	 */
	public void setMerchantCustomerId(String value) {
		this.merchantCustomerId = value;
	}

	/**
	 * Your ID of the customer in the context of the airline data
	 * This field is used by the following payment products: 840
	 */
	public AirlineData withMerchantCustomerId(String value) {
		this.merchantCustomerId = value;
		return this;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Name of the airline
	 */
	public String getName() {
		return name;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Name of the airline
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Name of the airline
	 */
	public AirlineData withName(String value) {
		this.name = value;
		return this;
	}

	/**
	 * Deprecated: Use passengers instead
	 * Name of passenger
	 */
	public String getPassengerName() {
		return passengerName;
	}

	/**
	 * Deprecated: Use passengers instead
	 * Name of passenger
	 */
	public void setPassengerName(String value) {
		this.passengerName = value;
	}

	/**
	 * Deprecated: Use passengers instead
	 * Name of passenger
	 */
	public AirlineData withPassengerName(String value) {
		this.passengerName = value;
		return this;
	}

	/**
	 * Object that holds the data on the individual passengers
	 * This field is used by the following payment products: cards, 840
	 */
	public List<AirlinePassenger> getPassengers() {
		return passengers;
	}

	/**
	 * Object that holds the data on the individual passengers
	 * This field is used by the following payment products: cards, 840
	 */
	public void setPassengers(List<AirlinePassenger> value) {
		this.passengers = value;
	}

	/**
	 * Object that holds the data on the individual passengers
	 * This field is used by the following payment products: cards, 840
	 */
	public AirlineData withPassengers(List<AirlinePassenger> value) {
		this.passengers = value;
		return this;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Place of issue
	 * For sales in the US the last two characters (pos 14-15) must be the US state code.
	 */
	public String getPlaceOfIssue() {
		return placeOfIssue;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Place of issue
	 * For sales in the US the last two characters (pos 14-15) must be the US state code.
	 */
	public void setPlaceOfIssue(String value) {
		this.placeOfIssue = value;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Place of issue
	 * For sales in the US the last two characters (pos 14-15) must be the US state code.
	 */
	public AirlineData withPlaceOfIssue(String value) {
		this.placeOfIssue = value;
		return this;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Passenger name record
	 */
	public String getPnr() {
		return pnr;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Passenger name record
	 */
	public void setPnr(String value) {
		this.pnr = value;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Passenger name record
	 */
	public AirlineData withPnr(String value) {
		this.pnr = value;
		return this;
	}

	/**
	 * IATA point of sale name
	 * This field is used by the following payment products: 840
	 */
	public String getPointOfSale() {
		return pointOfSale;
	}

	/**
	 * IATA point of sale name
	 * This field is used by the following payment products: 840
	 */
	public void setPointOfSale(String value) {
		this.pointOfSale = value;
	}

	/**
	 * IATA point of sale name
	 * This field is used by the following payment products: 840
	 */
	public AirlineData withPointOfSale(String value) {
		this.pointOfSale = value;
		return this;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * City code of the point of sale
	 */
	public String getPosCityCode() {
		return posCityCode;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * City code of the point of sale
	 */
	public void setPosCityCode(String value) {
		this.posCityCode = value;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * City code of the point of sale
	 */
	public AirlineData withPosCityCode(String value) {
		this.posCityCode = value;
		return this;
	}

	/**
	 * Three-letter ISO currency code representing the currency in which ticket purchase amount is expressed.
	 */
	public String getTicketCurrency() {
		return ticketCurrency;
	}

	/**
	 * Three-letter ISO currency code representing the currency in which ticket purchase amount is expressed.
	 */
	public void setTicketCurrency(String value) {
		this.ticketCurrency = value;
	}

	/**
	 * Three-letter ISO currency code representing the currency in which ticket purchase amount is expressed.
	 */
	public AirlineData withTicketCurrency(String value) {
		this.ticketCurrency = value;
		return this;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Delivery method of the ticket
	 */
	public String getTicketDeliveryMethod() {
		return ticketDeliveryMethod;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Delivery method of the ticket
	 */
	public void setTicketDeliveryMethod(String value) {
		this.ticketDeliveryMethod = value;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Delivery method of the ticket
	 */
	public AirlineData withTicketDeliveryMethod(String value) {
		this.ticketDeliveryMethod = value;
		return this;
	}

	/**
	 * The ticket or document number contains:
	 *  * Airline code: 3-digit airline code number
	 *  * Form code: A maximum of 3 digits indicating the type of document, the source of issue and the number of coupons it contains
	 *  * Serial number: A maximum of 8 digits allocated on a sequential basis, provided that the total number of digits allocated to the form code and serial number shall not exceed ten
	 *  * TICKETNUMBER can be replaced with PNR if the ticket number is unavailable
	 * This field is used by the following payment products: cards, 840
	 */
	public String getTicketNumber() {
		return ticketNumber;
	}

	/**
	 * The ticket or document number contains:
	 *  * Airline code: 3-digit airline code number
	 *  * Form code: A maximum of 3 digits indicating the type of document, the source of issue and the number of coupons it contains
	 *  * Serial number: A maximum of 8 digits allocated on a sequential basis, provided that the total number of digits allocated to the form code and serial number shall not exceed ten
	 *  * TICKETNUMBER can be replaced with PNR if the ticket number is unavailable
	 * This field is used by the following payment products: cards, 840
	 */
	public void setTicketNumber(String value) {
		this.ticketNumber = value;
	}

	/**
	 * The ticket or document number contains:
	 *  * Airline code: 3-digit airline code number
	 *  * Form code: A maximum of 3 digits indicating the type of document, the source of issue and the number of coupons it contains
	 *  * Serial number: A maximum of 8 digits allocated on a sequential basis, provided that the total number of digits allocated to the form code and serial number shall not exceed ten
	 *  * TICKETNUMBER can be replaced with PNR if the ticket number is unavailable
	 * This field is used by the following payment products: cards, 840
	 */
	public AirlineData withTicketNumber(String value) {
		this.ticketNumber = value;
		return this;
	}

	/**
	 * Total fare for all legs on the ticket, excluding taxes and fees. If multiple tickets are purchased, this is the total fare for all tickets
	 * This field is used by the following payment products: 840
	 */
	public Integer getTotalFare() {
		return totalFare;
	}

	/**
	 * Total fare for all legs on the ticket, excluding taxes and fees. If multiple tickets are purchased, this is the total fare for all tickets
	 * This field is used by the following payment products: 840
	 */
	public void setTotalFare(Integer value) {
		this.totalFare = value;
	}

	/**
	 * Total fare for all legs on the ticket, excluding taxes and fees. If multiple tickets are purchased, this is the total fare for all tickets
	 * This field is used by the following payment products: 840
	 */
	public AirlineData withTotalFare(Integer value) {
		this.totalFare = value;
		return this;
	}

	/**
	 * Total fee for all legs on the ticket. If multiple tickets are purchased, this is the total fee for all tickets
	 * This field is used by the following payment products: 840
	 */
	public Integer getTotalFee() {
		return totalFee;
	}

	/**
	 * Total fee for all legs on the ticket. If multiple tickets are purchased, this is the total fee for all tickets
	 * This field is used by the following payment products: 840
	 */
	public void setTotalFee(Integer value) {
		this.totalFee = value;
	}

	/**
	 * Total fee for all legs on the ticket. If multiple tickets are purchased, this is the total fee for all tickets
	 * This field is used by the following payment products: 840
	 */
	public AirlineData withTotalFee(Integer value) {
		this.totalFee = value;
		return this;
	}

	/**
	 * Total taxes for all legs on the ticket. If multiple tickets are purchased, this is the total taxes for all tickets
	 * This field is used by the following payment products: 840
	 */
	public Integer getTotalTaxes() {
		return totalTaxes;
	}

	/**
	 * Total taxes for all legs on the ticket. If multiple tickets are purchased, this is the total taxes for all tickets
	 * This field is used by the following payment products: 840
	 */
	public void setTotalTaxes(Integer value) {
		this.totalTaxes = value;
	}

	/**
	 * Total taxes for all legs on the ticket. If multiple tickets are purchased, this is the total taxes for all tickets
	 * This field is used by the following payment products: 840
	 */
	public AirlineData withTotalTaxes(Integer value) {
		this.totalTaxes = value;
		return this;
	}

	/**
	 * Name of the travel agency issuing the ticket. For direct airline integration, leave this property blank
	 * This field is used by the following payment products: 840
	 */
	public String getTravelAgencyName() {
		return travelAgencyName;
	}

	/**
	 * Name of the travel agency issuing the ticket. For direct airline integration, leave this property blank
	 * This field is used by the following payment products: 840
	 */
	public void setTravelAgencyName(String value) {
		this.travelAgencyName = value;
	}

	/**
	 * Name of the travel agency issuing the ticket. For direct airline integration, leave this property blank
	 * This field is used by the following payment products: 840
	 */
	public AirlineData withTravelAgencyName(String value) {
		this.travelAgencyName = value;
		return this;
	}
}
