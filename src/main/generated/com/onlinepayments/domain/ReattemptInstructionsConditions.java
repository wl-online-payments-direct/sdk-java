/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class ReattemptInstructionsConditions {

    private Integer maxAttempts;

    private Integer maxDelay;

    /**
     * Max number of reattempts permitted.
     */
    public Integer getMaxAttempts() {
        return maxAttempts;
    }

    /**
     * Max number of reattempts permitted.
     */
    public void setMaxAttempts(Integer value) {
        this.maxAttempts = value;
    }

    /**
     * Max number of reattempts permitted.
     */
    public ReattemptInstructionsConditions withMaxAttempts(Integer value) {
        this.maxAttempts = value;
        return this;
    }

    /**
     * Max hours during which reattempt can be made.
     */
    public Integer getMaxDelay() {
        return maxDelay;
    }

    /**
     * Max hours during which reattempt can be made.
     */
    public void setMaxDelay(Integer value) {
        this.maxDelay = value;
    }

    /**
     * Max hours during which reattempt can be made.
     */
    public ReattemptInstructionsConditions withMaxDelay(Integer value) {
        this.maxDelay = value;
        return this;
    }
}
