/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class DpaTransactionOptions {

    private ThreeDsInputData threeDsInputData;

    /**
     * Merchant’s 3DS input data. Conditionality: Must be supplied if 3DS is to be performed by SRC System.
     */
    public ThreeDsInputData getThreeDsInputData() {
        return threeDsInputData;
    }

    /**
     * Merchant’s 3DS input data. Conditionality: Must be supplied if 3DS is to be performed by SRC System.
     */
    public void setThreeDsInputData(ThreeDsInputData value) {
        this.threeDsInputData = value;
    }

    /**
     * Merchant’s 3DS input data. Conditionality: Must be supplied if 3DS is to be performed by SRC System.
     */
    public DpaTransactionOptions withThreeDsInputData(ThreeDsInputData value) {
        this.threeDsInputData = value;
        return this;
    }
}
