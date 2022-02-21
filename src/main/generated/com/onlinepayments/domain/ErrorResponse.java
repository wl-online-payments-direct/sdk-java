/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

import java.util.List;

public class ErrorResponse {

	private String errorId = null;

	private List<APIError> errors = null;

	/**
	 * Unique reference, for debugging purposes, of this error response
	 */
	public String getErrorId() {
		return errorId;
	}

	/**
	 * Unique reference, for debugging purposes, of this error response
	 */
	public void setErrorId(String value) {
		this.errorId = value;
	}

	/**
	 * Unique reference, for debugging purposes, of this error response
	 */
	public ErrorResponse withErrorId(String value) {
		this.errorId = value;
		return this;
	}

	/**
	 * List of one or more errors
	 */
	public List<APIError> getErrors() {
		return errors;
	}

	/**
	 * List of one or more errors
	 */
	public void setErrors(List<APIError> value) {
		this.errors = value;
	}

	/**
	 * List of one or more errors
	 */
	public ErrorResponse withErrors(List<APIError> value) {
		this.errors = value;
		return this;
	}
}
