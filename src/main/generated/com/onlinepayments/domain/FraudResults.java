/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing the results of the fraud screening
 */
public class FraudResults {

	private String fraudServiceResult = null;

	/**
	 * Resulting advice of the fraud prevention checks. Possible values are:
	 * * accepted - Based on the checks performed the transaction can be accepted
	 * * challenged - Based on the checks performed the transaction should be manually reviewed
	 * * denied - Based on the checks performed the transaction should be rejected
	 * * no-advice - No fraud check was requested/performed
	 * * error - The fraud check resulted an error. Note that the fraud check was thus not performed.
	 */
	public String getFraudServiceResult() {
		return fraudServiceResult;
	}

	/**
	 * Resulting advice of the fraud prevention checks. Possible values are:
	 * * accepted - Based on the checks performed the transaction can be accepted
	 * * challenged - Based on the checks performed the transaction should be manually reviewed
	 * * denied - Based on the checks performed the transaction should be rejected
	 * * no-advice - No fraud check was requested/performed
	 * * error - The fraud check resulted an error. Note that the fraud check was thus not performed.
	 */
	public void setFraudServiceResult(String value) {
		this.fraudServiceResult = value;
	}

	/**
	 * Resulting advice of the fraud prevention checks. Possible values are:
	 * * accepted - Based on the checks performed the transaction can be accepted
	 * * challenged - Based on the checks performed the transaction should be manually reviewed
	 * * denied - Based on the checks performed the transaction should be rejected
	 * * no-advice - No fraud check was requested/performed
	 * * error - The fraud check resulted an error. Note that the fraud check was thus not performed.
	 */
	public FraudResults withFraudServiceResult(String value) {
		this.fraudServiceResult = value;
		return this;
	}
}
