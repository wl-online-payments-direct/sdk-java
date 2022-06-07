/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Contains detailed information on one single error.
 */
public class APIError {

	private String category = null;

	private String code = null;

	private String errorCode = null;

	private Integer httpStatusCode = null;

	private String id = null;

	private String message = null;

	private String propertyName = null;

	/**
	 * Category the error belongs to. The category should give an indication of the type of error you are dealing with. Possible values:
	 * * DIRECT_PLATFORM_ERROR - indicating that a functional error has occurred in the platform.
	 * * PAYMENT_PLATFORM_ERROR - indicating that a functional error has occurred in the payment platform.
	 * * IO_ERROR - indicating that a technical error has occurred within the payment platform or between the payment platform and third party systems.
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Category the error belongs to. The category should give an indication of the type of error you are dealing with. Possible values:
	 * * DIRECT_PLATFORM_ERROR - indicating that a functional error has occurred in the platform.
	 * * PAYMENT_PLATFORM_ERROR - indicating that a functional error has occurred in the payment platform.
	 * * IO_ERROR - indicating that a technical error has occurred within the payment platform or between the payment platform and third party systems.
	 */
	public void setCategory(String value) {
		this.category = value;
	}

	/**
	 * Category the error belongs to. The category should give an indication of the type of error you are dealing with. Possible values:
	 * * DIRECT_PLATFORM_ERROR - indicating that a functional error has occurred in the platform.
	 * * PAYMENT_PLATFORM_ERROR - indicating that a functional error has occurred in the payment platform.
	 * * IO_ERROR - indicating that a technical error has occurred within the payment platform or between the payment platform and third party systems.
	 */
	public APIError withCategory(String value) {
		this.category = value;
		return this;
	}

	/**
	 * Deprecated: Use errorCode instead.
	 * Error code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Deprecated: Use errorCode instead.
	 * Error code
	 */
	public void setCode(String value) {
		this.code = value;
	}

	/**
	 * Deprecated: Use errorCode instead.
	 * Error code
	 */
	public APIError withCode(String value) {
		this.code = value;
		return this;
	}

	/**
	 * Error code
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Error code
	 */
	public void setErrorCode(String value) {
		this.errorCode = value;
	}

	/**
	 * Error code
	 */
	public APIError withErrorCode(String value) {
		this.errorCode = value;
		return this;
	}

	/**
	 * HTTP status code for this error that can be used to determine the type of error
	 */
	public Integer getHttpStatusCode() {
		return httpStatusCode;
	}

	/**
	 * HTTP status code for this error that can be used to determine the type of error
	 */
	public void setHttpStatusCode(Integer value) {
		this.httpStatusCode = value;
	}

	/**
	 * HTTP status code for this error that can be used to determine the type of error
	 */
	public APIError withHttpStatusCode(Integer value) {
		this.httpStatusCode = value;
		return this;
	}

	/**
	 * ID of the error. This is a short human-readable message that briefly describes the error.
	 */
	public String getId() {
		return id;
	}

	/**
	 * ID of the error. This is a short human-readable message that briefly describes the error.
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * ID of the error. This is a short human-readable message that briefly describes the error.
	 */
	public APIError withId(String value) {
		this.id = value;
		return this;
	}

	/**
	 * Human-readable error message that is not meant to be relayed to customer as it might tip off people who are trying to commit fraud
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Human-readable error message that is not meant to be relayed to customer as it might tip off people who are trying to commit fraud
	 */
	public void setMessage(String value) {
		this.message = value;
	}

	/**
	 * Human-readable error message that is not meant to be relayed to customer as it might tip off people who are trying to commit fraud
	 */
	public APIError withMessage(String value) {
		this.message = value;
		return this;
	}

	/**
	 * Returned only if the error relates to a value that was missing or incorrect.
	 * 
	 * Contains a location path to the value as a JSonata query.
	 * 
	 * Some common examples:
	 * * a.b selects the value of property b of root property a,
	 * * a[1] selects the first element of the array in root property a,
	 * * a[b='some value'] selects all elements of the array in root property a that have a property b with value 'some value'.
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * Returned only if the error relates to a value that was missing or incorrect.
	 * 
	 * Contains a location path to the value as a JSonata query.
	 * 
	 * Some common examples:
	 * * a.b selects the value of property b of root property a,
	 * * a[1] selects the first element of the array in root property a,
	 * * a[b='some value'] selects all elements of the array in root property a that have a property b with value 'some value'.
	 */
	public void setPropertyName(String value) {
		this.propertyName = value;
	}

	/**
	 * Returned only if the error relates to a value that was missing or incorrect.
	 * 
	 * Contains a location path to the value as a JSonata query.
	 * 
	 * Some common examples:
	 * * a.b selects the value of property b of root property a,
	 * * a[1] selects the first element of the array in root property a,
	 * * a[b='some value'] selects all elements of the array in root property a that have a property b with value 'some value'.
	 */
	public APIError withPropertyName(String value) {
		this.propertyName = value;
		return this;
	}
}
