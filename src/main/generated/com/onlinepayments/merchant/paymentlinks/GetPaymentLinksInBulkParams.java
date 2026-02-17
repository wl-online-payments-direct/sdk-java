/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.paymentlinks;

import java.util.ArrayList;
import java.util.List;

import com.onlinepayments.communication.ParamRequest;
import com.onlinepayments.communication.RequestParam;

/**
 * Query parameters for
 * Get payment links (/v2/{merchantId}/paymentlinks)
 */
public class GetPaymentLinksInBulkParams implements ParamRequest {

    private String operationGroupReference;

    public String getOperationGroupReference() {
        return operationGroupReference;
    }

    public void setOperationGroupReference(String value) {
        this.operationGroupReference = value;
    }

    public GetPaymentLinksInBulkParams withOperationGroupReference(String value) {
        this.operationGroupReference = value;
        return this;
    }

    @Override
    public List<RequestParam> toRequestParameters() {
        List<RequestParam> result = new ArrayList<>();
        if (operationGroupReference != null) {
            result.add(new RequestParam("operationGroupReference", operationGroupReference));
        }
        return result;
    }
}
