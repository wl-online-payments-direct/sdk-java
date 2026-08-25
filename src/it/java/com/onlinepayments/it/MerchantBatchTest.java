package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.CallContext;
import com.onlinepayments.ClientInterface;
import com.onlinepayments.ReferenceException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.CreatePaymentRequest;
import com.onlinepayments.domain.GetBatchStatusResponse;
import com.onlinepayments.domain.PaymentsReportResponse;
import com.onlinepayments.domain.SubmitBatchRequestBody;
import com.onlinepayments.domain.SubmitBatchResponse;
import com.onlinepayments.it.util.SdkTestHelper;
import com.onlinepayments.it.util.common.CreatePaymentRequestBuilder;
import com.onlinepayments.it.util.merchantBatch.GetPaymentsReportParamsBuilder;
import com.onlinepayments.it.util.merchantBatch.SubmitBatchRequestBodyBuilder;
import com.onlinepayments.merchant.merchantbatch.GetPaymentsReportParams;
import com.onlinepayments.merchant.merchantbatch.MerchantBatchClientInterface;

public class MerchantBatchTest extends ItTest {

    private static final String NON_EXISTING_MERCHANT_BATCH_REFERENCE = "non-existing-batch-reference";
    private static final String INVALID_MERCHANT_BATCH_REFERENCE = "";
    private static final String INVALID_CURSOR = "invalid-cursor-value";
    private static final String CURSOR_VALUE = "cursor-value";
    private static final int LIMIT_BELOW_MINIMUM = 0;
    private static final int LIMIT_ABOVE_MAXIMUM = 1001;

    private ClientInterface client;
    private MerchantBatchClientInterface merchantBatchClient;

    private SdkTestHelper sdkTestHelper;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        merchantBatchClient = client.merchant(getMerchantId()).merchantBatch();

        sdkTestHelper = getSdkTestHelper(client);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenSubmittingBatches {

        @Nested
        class WithValidInput {

            @Test
            void shouldReturnSubmittedBatch() {
                CreatePaymentRequest createPaymentRequest = new CreatePaymentRequestBuilder().build();
                ArrayList<CreatePaymentRequest> createPaymentRequestArrayList = new ArrayList<>();
                createPaymentRequestArrayList.add(createPaymentRequest);

                SubmitBatchRequestBody request = new SubmitBatchRequestBodyBuilder()
                        .withCreatePaymentRequests(createPaymentRequestArrayList)
                        .withOperationType("CreatePayment")
                        .withItemCount(1)
                        .build();

                String merchantBatchReference = request.getHeader().getMerchantBatchReference();
                SubmitBatchResponse response = merchantBatchClient.submitBatch(request);

                assertNotNull(response);
                assertNotNull(response.getMerchantBatchReference());
                assertEquals(merchantBatchReference, response.getMerchantBatchReference());
                assertNotNull(response.getTotalCount());
                assertEquals(1, response.getTotalCount());
            }

            @Test
            void shouldReturnSubmittedBatchWithCallContext() {
                CreatePaymentRequest createPaymentRequest = new CreatePaymentRequestBuilder().build();
                ArrayList<CreatePaymentRequest> createPaymentRequestArrayList = new ArrayList<>();
                createPaymentRequestArrayList.add(createPaymentRequest);

                SubmitBatchRequestBody request = new SubmitBatchRequestBodyBuilder()
                        .withCreatePaymentRequests(createPaymentRequestArrayList)
                        .withOperationType("CreatePayment")
                        .withItemCount(1)
                        .build();

                String merchantBatchReference = request.getHeader().getMerchantBatchReference();
                CallContext context = new CallContext().withIdempotenceKey("test-merchant-batch-" + UUID.randomUUID());

                SubmitBatchResponse response = merchantBatchClient.submitBatch(request, context);

                assertNotNull(response);
                assertNotNull(response.getMerchantBatchReference());
                assertEquals(merchantBatchReference, response.getMerchantBatchReference());
                assertNotNull(response.getTotalCount());
                assertEquals(1, response.getTotalCount());
            }
        }

        @Nested
        class WithInvalidMerchantBatchReference {

            @Test
            void shouldThrowValidationException() {
                CreatePaymentRequest createPaymentRequest = new CreatePaymentRequestBuilder().build();
                ArrayList<CreatePaymentRequest> createPaymentRequestArrayList = new ArrayList<>();
                createPaymentRequestArrayList.add(createPaymentRequest);

                SubmitBatchRequestBody request = new SubmitBatchRequestBodyBuilder()
                        .withMerchantBatchReference(INVALID_MERCHANT_BATCH_REFERENCE)
                        .withCreatePaymentRequests(createPaymentRequestArrayList)
                        .withOperationType("CreatePayment")
                        .withItemCount(1)
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> merchantBatchClient.submitBatch(request));
            }
        }
    }

    @Nested
    class WhenProcessingBatches {

        @Nested
        class WithExistingMerchantBatchReference {

            @Test
            void shouldProcessBatch() {
                CreatePaymentRequest createPaymentRequest = new CreatePaymentRequestBuilder().build();
                ArrayList<CreatePaymentRequest> createPaymentRequestArrayList = new ArrayList<>();
                createPaymentRequestArrayList.add(createPaymentRequest);

                String merchantBatchReference = sdkTestHelper.submitBatchAndGetReference(
                        createPaymentRequestArrayList,
                        "CreatePayment",
                        1);

                merchantBatchClient.processBatch(merchantBatchReference);

                GetBatchStatusResponse statusResponse = merchantBatchClient
                        .getBatchStatus(merchantBatchReference);
                assertNotNull(statusResponse);
                assertNotNull(statusResponse.getStatus());
            }
        }

        @Nested
        class WithInvalidMerchantBatchReference {

            @Test
            void shouldThrowReferenceException() {
                assertThrows(
                        ReferenceException.class,
                        () -> merchantBatchClient.processBatch(NON_EXISTING_MERCHANT_BATCH_REFERENCE));
            }
        }
    }

    @Nested
    class WhenGettingBatchStatus {

        @Nested
        class WithExistingMerchantBatchReference {

            @Test
            void shouldReturnBatchStatus() {
                CreatePaymentRequest createPaymentRequest = new CreatePaymentRequestBuilder().build();
                ArrayList<CreatePaymentRequest> createPaymentRequestArrayList = new ArrayList<>();
                createPaymentRequestArrayList.add(createPaymentRequest);

                String merchantBatchReference = sdkTestHelper.submitBatchAndGetReference(
                        createPaymentRequestArrayList,
                        "CreatePayment",
                        1);

                GetBatchStatusResponse response = merchantBatchClient.getBatchStatus(merchantBatchReference);

                assertNotNull(response);
                assertNotNull(response.getMerchantBatchReference());
                assertEquals(merchantBatchReference, response.getMerchantBatchReference());

                assertNotNull(response.getItemCount());
                assertEquals(1, response.getItemCount());

                assertNotNull(response.getOperationType());
                assertNotNull(response.getStatus());
            }
        }

        @Nested
        class WithInvalidMerchantBatchReference {

            @Test
            void shouldThrowReferenceException() {
                assertThrows(
                        ReferenceException.class,
                        () -> merchantBatchClient.getBatchStatus(NON_EXISTING_MERCHANT_BATCH_REFERENCE));
            }
        }
    }

    @Nested
    class WhenGettingPaymentsReport {

        @Test
        void shouldVerifyGetPaymentsReportParamsGetters() {
            GetPaymentsReportParams params = new GetPaymentsReportParamsBuilder()
                    .withCursor(CURSOR_VALUE)
                    .withLimit(50)
                    .build();

            assertEquals(CURSOR_VALUE, params.getCursor());
            assertEquals(50, params.getLimit());
        }

        @Test
        void shouldReturnResponseWithDefaultParameters() {
            CreatePaymentRequest createPaymentRequest = new CreatePaymentRequestBuilder().build();
            ArrayList<CreatePaymentRequest> createPaymentRequestArrayList = new ArrayList<>();
            createPaymentRequestArrayList.add(createPaymentRequest);

            String merchantBatchReference = sdkTestHelper.submitAndProcessBatchAndGetReference(
                    createPaymentRequestArrayList,
                    "CreatePayment",
                    1);

            GetPaymentsReportParams params = new GetPaymentsReportParamsBuilder().build();

            PaymentsReportResponse response = merchantBatchClient.getPaymentsReport(merchantBatchReference, params);

            assertNotNull(response);
            assertNotNull(response.getPayments());
            assertNotNull(response.getPagination());
        }

        @Test
        void shouldReturnResponseWithCursorAndLimit() {
            CreatePaymentRequest createPaymentRequest = new CreatePaymentRequestBuilder().build();
            ArrayList<CreatePaymentRequest> createPaymentRequestArrayList = new ArrayList<>();
            createPaymentRequestArrayList.add(createPaymentRequest);

            String merchantBatchReference = sdkTestHelper.submitAndProcessBatchAndGetReference(
                    createPaymentRequestArrayList,
                    "CreatePayment",
                    1);

            GetPaymentsReportParams firstPageParams = new GetPaymentsReportParamsBuilder()
                    .withLimit(1)
                    .build();

            PaymentsReportResponse firstPage = merchantBatchClient
                    .getPaymentsReport(merchantBatchReference, firstPageParams);

            assertNotNull(firstPage);
            assertNotNull(firstPage.getPayments());
            assertNotNull(firstPage.getPagination());

            GetPaymentsReportParams secondPageParams = new GetPaymentsReportParamsBuilder()
                    .withLimit(1)
                    .withCursor(firstPage.getPagination().getNextCursor())
                    .build();

            PaymentsReportResponse secondPage = merchantBatchClient
                    .getPaymentsReport(merchantBatchReference, secondPageParams);

            assertNotNull(secondPage);
            assertNotNull(secondPage.getPayments());
            assertNotNull(secondPage.getPagination());
        }

        @Test
        void shouldReturnResponseWithCallContext() {
            CreatePaymentRequest createPaymentRequest = new CreatePaymentRequestBuilder().build();
            ArrayList<CreatePaymentRequest> createPaymentRequestArrayList = new ArrayList<>();
            createPaymentRequestArrayList.add(createPaymentRequest);

            String merchantBatchReference = sdkTestHelper.submitAndProcessBatchAndGetReference(
                    createPaymentRequestArrayList,
                    "CreatePayment",
                    1);

            GetPaymentsReportParams params = new GetPaymentsReportParamsBuilder().build();
            CallContext context = new CallContext().withIdempotenceKey("test-merchant-batch-" + UUID.randomUUID());

            PaymentsReportResponse response = merchantBatchClient
                    .getPaymentsReport(merchantBatchReference, params, context);

            assertNotNull(response);
            assertNotNull(response.getPayments());
            assertNotNull(response.getPagination());
        }

        @Test
        void shouldThrowReferenceExceptionForNonExistingMerchantBatchReference() {
            GetPaymentsReportParams params = new GetPaymentsReportParamsBuilder().build();

            ReferenceException exception = assertThrows(
                    ReferenceException.class,
                    () -> merchantBatchClient.getPaymentsReport(NON_EXISTING_MERCHANT_BATCH_REFERENCE, params));

            assertEquals(404, exception.getStatusCode());
        }

        @Test
        void shouldThrowValidationExceptionForInvalidCursor() {
            CreatePaymentRequest createPaymentRequest = new CreatePaymentRequestBuilder().build();
            ArrayList<CreatePaymentRequest> createPaymentRequestArrayList = new ArrayList<>();
            createPaymentRequestArrayList.add(createPaymentRequest);

            String merchantBatchReference = sdkTestHelper.submitBatchAndGetReference(
                    createPaymentRequestArrayList,
                    "CreatePayment",
                    1);

            GetPaymentsReportParams params = new GetPaymentsReportParamsBuilder()
                    .withCursor(INVALID_CURSOR)
                    .build();

            ValidationException exception = assertThrows(
                    ValidationException.class,
                    () -> merchantBatchClient.getPaymentsReport(merchantBatchReference, params));

            assertEquals(400, exception.getStatusCode());
        }

        @Test
        void shouldThrowValidationExceptionForLimitBelowMinimum() {
            CreatePaymentRequest createPaymentRequest = new CreatePaymentRequestBuilder().build();
            ArrayList<CreatePaymentRequest> createPaymentRequestArrayList = new ArrayList<>();
            createPaymentRequestArrayList.add(createPaymentRequest);

            String merchantBatchReference = sdkTestHelper.submitBatchAndGetReference(
                    createPaymentRequestArrayList,
                    "CreatePayment",
                    1);

            GetPaymentsReportParams params = new GetPaymentsReportParamsBuilder()
                    .withLimit(LIMIT_BELOW_MINIMUM)
                    .build();

            ValidationException exception = assertThrows(
                    ValidationException.class,
                    () -> merchantBatchClient.getPaymentsReport(merchantBatchReference, params));

            assertEquals(400, exception.getStatusCode());
        }

        @Test
        void shouldThrowValidationExceptionForLimitAboveMaximum() {
            CreatePaymentRequest createPaymentRequest = new CreatePaymentRequestBuilder().build();
            ArrayList<CreatePaymentRequest> createPaymentRequestArrayList = new ArrayList<>();
            createPaymentRequestArrayList.add(createPaymentRequest);

            String merchantBatchReference = sdkTestHelper.submitBatchAndGetReference(
                    createPaymentRequestArrayList,
                    "CreatePayment",
                    1);

            GetPaymentsReportParams params = new GetPaymentsReportParamsBuilder()
                    .withLimit(LIMIT_ABOVE_MAXIMUM)
                    .build();

            ValidationException exception = assertThrows(
                    ValidationException.class,
                    () -> merchantBatchClient.getPaymentsReport(merchantBatchReference, params));

            assertEquals(400, exception.getStatusCode());
        }
    }
}
