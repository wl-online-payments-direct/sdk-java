package com.onlinepayments.it.util.merchantBatch;

import java.util.List;

import com.onlinepayments.domain.BatchMetadata;
import com.onlinepayments.domain.CreatePaymentRequest;
import com.onlinepayments.domain.SubmitBatchRequestBody;

public class SubmitBatchRequestBodyBuilder {

    private String merchantBatchReference;
    private String operationType;
    private List<CreatePaymentRequest> createPaymentRequests;
    private int itemCount;

    public SubmitBatchRequestBodyBuilder() {
        this.merchantBatchReference = generateMerchantBatchReference();
    }

    public SubmitBatchRequestBodyBuilder withMerchantBatchReference(String merchantBatchReference) {
        this.merchantBatchReference = merchantBatchReference;
        return this;
    }

    public SubmitBatchRequestBodyBuilder withOperationType(String operationType) {
        this.operationType = operationType;
        return this;
    }

    public SubmitBatchRequestBodyBuilder withItemCount(int itemCount) {
        this.itemCount = itemCount;
        return this;
    }

    public SubmitBatchRequestBodyBuilder withCreatePaymentRequests(List<CreatePaymentRequest> createPaymentRequests) {
        this.createPaymentRequests = createPaymentRequests;
        return this;
    }

    public SubmitBatchRequestBody build() {
        BatchMetadata header = new BatchMetadata()
                .withItemCount(itemCount)
                .withMerchantBatchReference(merchantBatchReference)
                .withOperationType(operationType);

        return new SubmitBatchRequestBody()
            .withHeader(header)
            .withCreatePayments(createPaymentRequests);
    }

    private String generateMerchantBatchReference() {
        return "Ref-" + java.util.UUID.randomUUID();
    }
}
