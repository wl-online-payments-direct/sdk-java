/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class CaptureResponse {

	private CaptureOutput captureOutput = null;

	private String id = null;

	private String status = null;

	private CaptureStatusOutput statusOutput = null;

	/**
	 * Object containing capture details
	 */
	public CaptureOutput getCaptureOutput() {
		return captureOutput;
	}

	/**
	 * Object containing capture details
	 */
	public void setCaptureOutput(CaptureOutput value) {
		this.captureOutput = value;
	}

	/**
	 * Object containing capture details
	 */
	public CaptureResponse withCaptureOutput(CaptureOutput value) {
		this.captureOutput = value;
		return this;
	}

	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

	public CaptureResponse withId(String value) {
		this.id = value;
		return this;
	}

	/**
	 * Current high-level status of the payment in a human-readable form.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Current high-level status of the payment in a human-readable form.
	 */
	public void setStatus(String value) {
		this.status = value;
	}

	/**
	 * Current high-level status of the payment in a human-readable form.
	 */
	public CaptureResponse withStatus(String value) {
		this.status = value;
		return this;
	}

	/**
	 * This object has the numeric representation of the current capture status, timestamp of last status change and performable action on the current payment resource. In case of failed payments and negative scenarios, detailed error information is listed.
	 */
	public CaptureStatusOutput getStatusOutput() {
		return statusOutput;
	}

	/**
	 * This object has the numeric representation of the current capture status, timestamp of last status change and performable action on the current payment resource. In case of failed payments and negative scenarios, detailed error information is listed.
	 */
	public void setStatusOutput(CaptureStatusOutput value) {
		this.statusOutput = value;
	}

	/**
	 * This object has the numeric representation of the current capture status, timestamp of last status change and performable action on the current payment resource. In case of failed payments and negative scenarios, detailed error information is listed.
	 */
	public CaptureResponse withStatusOutput(CaptureStatusOutput value) {
		this.statusOutput = value;
		return this;
	}
}
