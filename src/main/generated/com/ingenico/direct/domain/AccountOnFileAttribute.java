/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * Array containing the details of the stored token
 */
public class AccountOnFileAttribute {

	private String key = null;

	private String mustWriteReason = null;

	private String status = null;

	private String value = null;

	/**
	 * Name of the key or property
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Name of the key or property
	 */
	public void setKey(String value) {
		this.key = value;
	}

	/**
	 * The reason why the status is MUST_WRITE. Currently only "IN_THE_PAST" is possible as value (for expiry date), but this can be extended with new values in the future.
	 */
	public String getMustWriteReason() {
		return mustWriteReason;
	}

	/**
	 * The reason why the status is MUST_WRITE. Currently only "IN_THE_PAST" is possible as value (for expiry date), but this can be extended with new values in the future.
	 */
	public void setMustWriteReason(String value) {
		this.mustWriteReason = value;
	}

	/**
	 * Possible values:
	 * * READ_ONLY - attribute cannot be updated and should be presented in that way to the user
	 * * CAN_WRITE - attribute can be updated and should be presented as an editable field, for example an expiration date that will expire very soon
	 * * MUST_WRITE - attribute should be updated and must be presented as an editable field, for example an expiration date that has already expired
	 * Any updated values that are entered for CAN_WRITE or MUST_WRITE will be used to update the values stored in the token.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Possible values:
	 * * READ_ONLY - attribute cannot be updated and should be presented in that way to the user
	 * * CAN_WRITE - attribute can be updated and should be presented as an editable field, for example an expiration date that will expire very soon
	 * * MUST_WRITE - attribute should be updated and must be presented as an editable field, for example an expiration date that has already expired
	 * Any updated values that are entered for CAN_WRITE or MUST_WRITE will be used to update the values stored in the token.
	 */
	public void setStatus(String value) {
		this.status = value;
	}

	/**
	 * Value of the key or property
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Value of the key or property
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
