/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class ReattemptInstructions {

    private ReattemptInstructionsConditions conditions;

    private Integer frozenPeriod;

    private String indicator;

    /**
     * Additional conditions to be met for reattempt. If the data is not provided by the acquirer, these fields are omitted from the response.
     */
    public ReattemptInstructionsConditions getConditions() {
        return conditions;
    }

    /**
     * Additional conditions to be met for reattempt. If the data is not provided by the acquirer, these fields are omitted from the response.
     */
    public void setConditions(ReattemptInstructionsConditions value) {
        this.conditions = value;
    }

    /**
     * Additional conditions to be met for reattempt. If the data is not provided by the acquirer, these fields are omitted from the response.
     */
    public ReattemptInstructions withConditions(ReattemptInstructionsConditions value) {
        this.conditions = value;
        return this;
    }

    /**
     * Hours to wait before next reattempt.
     */
    public Integer getFrozenPeriod() {
        return frozenPeriod;
    }

    /**
     * Hours to wait before next reattempt.
     */
    public void setFrozenPeriod(Integer value) {
        this.frozenPeriod = value;
    }

    /**
     * Hours to wait before next reattempt.
     */
    public ReattemptInstructions withFrozenPeriod(Integer value) {
        this.frozenPeriod = value;
        return this;
    }

    /**
     * High-level use case.
     * {@code frozenPeriod} and {@code conditions}, when provided, only apply if indicator is one of:
     * <ul>
     *   <li>{@code retryLater}: retry with no change;</li>
     *   <li>{@code updateBeforeRetry}: retry requires data updates;
     * Otherwise:</li>
     *   <li>{@code neverRetry}: the current payment authorization cannot be retried;</li>
     *   <li>{@code dontStorePanCredentials}: no retry and no subsequent payment attempt or payment series using this PAN from credentials on file;</li>
     * </ul>
     */
    public String getIndicator() {
        return indicator;
    }

    /**
     * High-level use case.
     * {@code frozenPeriod} and {@code conditions}, when provided, only apply if indicator is one of:
     * <ul>
     *   <li>{@code retryLater}: retry with no change;</li>
     *   <li>{@code updateBeforeRetry}: retry requires data updates;
     * Otherwise:</li>
     *   <li>{@code neverRetry}: the current payment authorization cannot be retried;</li>
     *   <li>{@code dontStorePanCredentials}: no retry and no subsequent payment attempt or payment series using this PAN from credentials on file;</li>
     * </ul>
     */
    public void setIndicator(String value) {
        this.indicator = value;
    }

    /**
     * High-level use case.
     * {@code frozenPeriod} and {@code conditions}, when provided, only apply if indicator is one of:
     * <ul>
     *   <li>{@code retryLater}: retry with no change;</li>
     *   <li>{@code updateBeforeRetry}: retry requires data updates;
     * Otherwise:</li>
     *   <li>{@code neverRetry}: the current payment authorization cannot be retried;</li>
     *   <li>{@code dontStorePanCredentials}: no retry and no subsequent payment attempt or payment series using this PAN from credentials on file;</li>
     * </ul>
     */
    public ReattemptInstructions withIndicator(String value) {
        this.indicator = value;
        return this;
    }
}
