/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Information about the acquirer selection
 */
public class AcquirerSelectionInformation {

	private Integer fallbackLevel = null;

	private String result = null;

	private String ruleName = null;

	/**
	 * Specifies whether a fallback occurred from the primary choice of the acquirer selection service.
	 */
	public Integer getFallbackLevel() {
		return fallbackLevel;
	}

	/**
	 * Specifies whether a fallback occurred from the primary choice of the acquirer selection service.
	 */
	public void setFallbackLevel(Integer value) {
		this.fallbackLevel = value;
	}

	/**
	 * Specifies whether a fallback occurred from the primary choice of the acquirer selection service.
	 */
	public AcquirerSelectionInformation withFallbackLevel(Integer value) {
		this.fallbackLevel = value;
		return this;
	}

	/**
	 * Result of the acquirer selection operation
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Result of the acquirer selection operation
	 */
	public void setResult(String value) {
		this.result = value;
	}

	/**
	 * Result of the acquirer selection operation
	 */
	public AcquirerSelectionInformation withResult(String value) {
		this.result = value;
		return this;
	}

	/**
	 * Name of the rule used to select the acquirer
	 */
	public String getRuleName() {
		return ruleName;
	}

	/**
	 * Name of the rule used to select the acquirer
	 */
	public void setRuleName(String value) {
		this.ruleName = value;
	}

	/**
	 * Name of the rule used to select the acquirer
	 */
	public AcquirerSelectionInformation withRuleName(String value) {
		this.ruleName = value;
		return this;
	}
}
