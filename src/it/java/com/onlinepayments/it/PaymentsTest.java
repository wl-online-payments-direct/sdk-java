package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.CallContext;
import com.onlinepayments.ClientInterface;
import com.onlinepayments.DeclinedPaymentException;
import com.onlinepayments.ReferenceException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.CancelPaymentRequest;
import com.onlinepayments.domain.CancelPaymentResponse;
import com.onlinepayments.domain.CapturePaymentRequest;
import com.onlinepayments.domain.CaptureResponse;
import com.onlinepayments.domain.CreatePaymentRequest;
import com.onlinepayments.domain.CreatePaymentResponse;
import com.onlinepayments.domain.PaymentDetailsResponse;
import com.onlinepayments.domain.PaymentResponse;
import com.onlinepayments.domain.RefundRequest;
import com.onlinepayments.domain.RefundResponse;
import com.onlinepayments.it.util.SdkTestHelper;
import com.onlinepayments.it.util.common.CreatePaymentRequestBuilder;
import com.onlinepayments.it.util.payments.CancelPaymentRequestBuilder;
import com.onlinepayments.it.util.payments.CapturePaymentRequestBuilder;
import com.onlinepayments.it.util.payments.RefundRequestBuilder;
import com.onlinepayments.merchant.payments.PaymentsClientInterface;

public class PaymentsTest extends ItTest {

    private static final String NON_EXISTING_PAYMENT_ID = "9999999999_0";
    private static final String CURRENCY_CODE = "EUR";

    private ClientInterface client;
    private PaymentsClientInterface paymentsClient;

    private SdkTestHelper sdkTestHelper;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        paymentsClient = client.merchant(getMerchantId()).payments();

        sdkTestHelper = getSdkTestHelper(client);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenCreatingPayments {

        @Nested
        class WithValidInput {

            @Test
            void shouldReturnCreatedPayment() {
                CreatePaymentRequest request = new CreatePaymentRequestBuilder().build();

                CreatePaymentResponse response = paymentsClient
                        .createPayment(request);

                assertNotNull(response);
                assertNotNull(response.getPayment());
                assertNotNull(response.getPayment().getId());
                assertNotNull(response.getPayment().getStatus());
            }

            @Test
            void shouldReturnCreatedPaymentWithCallContext() {
                CreatePaymentRequest request = new CreatePaymentRequestBuilder().build();
                CallContext context = new CallContext().withIdempotenceKey("test-payments-" + UUID.randomUUID());

                CreatePaymentResponse response = paymentsClient.createPayment(request, context);

                assertNotNull(response);
                assertNotNull(response.getPayment());
                assertNotNull(response.getPayment().getId());
                assertNotNull(response.getPayment().getStatus());
            }
        }

        @Nested
        class WithInvalidCardNumber {

            @Test
            void shouldThrowValidationException() {
                CreatePaymentRequest request = new CreatePaymentRequestBuilder()
                        .withCardNumber("123")
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> paymentsClient
                            .createPayment(request));
            }
        }

        @Nested
        class WithUnsupportedCardNumber {

            @Test
            void shouldThrowDeclinedPaymentException() {
                CreatePaymentRequest request = new CreatePaymentRequestBuilder()
                        .withCardNumber("4321456998744563")
                        .build();

                assertThrows(
                        DeclinedPaymentException.class,
                        () -> paymentsClient
                            .createPayment(request));
            }
        }

        @Nested
        class WithAutoCapture {

            @Test
            void shouldReturnCreatedPaymentWithAutoCapture() {
                CreatePaymentRequest request = new CreatePaymentRequestBuilder()
                        .withAutoCapture(true)
                        .build();

                CreatePaymentResponse response = paymentsClient.createPayment(request);

                assertNotNull(response);
                assertNotNull(response.getPayment());
                assertNotNull(response.getPayment().getId());
            }
        }
    }

    @Nested
    class WhenGettingPayments {

        @Nested
        class WithExistingPaymentId {

            @Test
            void shouldReturnPayment() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();

                PaymentResponse response = paymentsClient
                        .getPayment(paymentId);

                assertNotNull(response);
                assertNotNull(response.getId());
                assertEquals(paymentId, response.getId());
                assertNotNull(response.getStatus());
            }

            @Test
            void shouldReturnPaymentDetails() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();

                PaymentDetailsResponse response = paymentsClient
                        .getPaymentDetails(paymentId);

                assertNotNull(response);
                assertNotNull(response.getId());
                assertNotNull(response.getPaymentOutput());
                assertNotNull(response.getStatus());
            }
        }

        @Nested
        class WithInvalidPaymentId {

            @Test
            void shouldThrowReferenceExceptionWhenGettingPayment() {
                assertThrows(
                        ReferenceException.class,
                        () -> paymentsClient
                            .getPayment(NON_EXISTING_PAYMENT_ID));
            }

            @Test
            void shouldThrowReferenceExceptionWhenGettingPaymentDetails() {
                assertThrows(
                        ReferenceException.class,
                        () -> paymentsClient.getPaymentDetails(NON_EXISTING_PAYMENT_ID));
            }
        }
    }

    @Nested
    class WhenCancellingPayments {

        @Nested
        class WithValidRequest {

            @Test
            void shouldReturnCancelledPayment() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();

                CancelPaymentRequest cancelRequest = new CancelPaymentRequestBuilder().build();

                CancelPaymentResponse cancelResponse = paymentsClient
                        .cancelPayment(paymentId, cancelRequest);

                assertNotNull(cancelResponse);
                assertNotNull(cancelResponse.getPayment());
                assertNotNull(cancelResponse.getPayment().getId());
                assertNotNull(cancelResponse.getPayment().getStatus());
            }
        }

        @Nested
        class WithPartialAmount {

            @Test
            void shouldReturnCancelledPayment() {
                String paymentId = sdkTestHelper.createPaymentAndGetId(800L, "EUR");

                CancelPaymentRequest request = new CancelPaymentRequestBuilder()
                        .withAmount(300L)
                        .withCurrency(CURRENCY_CODE)
                        .withIsFinal(false)
                        .build();

                CancelPaymentResponse response = paymentsClient
                        .cancelPayment(paymentId, request);

                assertNotNull(response);
                assertNotNull(response.getPayment().getId());
                assertNotNull(response.getPayment());
                assertNotNull(response.getPayment().getStatus());
            }

            @Test
            void shouldReturnCancelledPaymentTwiceWhenRemainingAmountIsValid() {
                String paymentId = sdkTestHelper.createPaymentAndGetId(800L, "EUR");

                CancelPaymentRequest firstCancelRequest = new CancelPaymentRequestBuilder()
                        .withAmount(300L)
                        .withCurrency(CURRENCY_CODE)
                        .withIsFinal(false)
                        .build();

                CancelPaymentResponse firstCancelResponse = paymentsClient
                        .cancelPayment(paymentId, firstCancelRequest);

                assertNotNull(firstCancelResponse);
                assertNotNull(firstCancelResponse.getPayment());
                assertNotNull(firstCancelResponse.getPayment().getId());

                CancelPaymentRequest secondCancelRequest = new CancelPaymentRequestBuilder()
                        .withAmount(500L)
                        .withCurrency(CURRENCY_CODE)
                        .withIsFinal(true)
                        .build();

                CancelPaymentResponse secondCancelResponse = paymentsClient
                        .cancelPayment(paymentId, secondCancelRequest);

                assertNotNull(secondCancelResponse);
                assertNotNull(secondCancelResponse.getPayment());
                assertNotNull(secondCancelResponse.getPayment().getId());
            }

            @Test
            void shouldThrowValidationExceptionWhenSecondAmountExceedsRemainingAmount() {
                String paymentId = sdkTestHelper.createPaymentAndGetId(800L, "EUR");

                CancelPaymentRequest firstCancelRequest = new CancelPaymentRequestBuilder()
                        .withAmount(300L)
                        .withCurrency(CURRENCY_CODE)
                        .withIsFinal(false)
                        .build();

                paymentsClient
                        .cancelPayment(paymentId, firstCancelRequest);

                CancelPaymentRequest secondCancelRequest = new CancelPaymentRequestBuilder()
                        .withAmount(600L)
                        .withCurrency(CURRENCY_CODE)
                        .withIsFinal(false)
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> paymentsClient
                            .cancelPayment(paymentId, secondCancelRequest));
            }
        }

        @Nested
        class WithInvalidPaymentId {

            @Test
            void shouldThrowReferenceException() {
                CancelPaymentRequest request = new CancelPaymentRequestBuilder().build();

                assertThrows(
                        ReferenceException.class,
                        () -> paymentsClient
                            .cancelPayment(NON_EXISTING_PAYMENT_ID, request));
            }
        }

        @Nested
        class AfterCapture {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();

                paymentsClient
                        .capturePayment(paymentId, new CapturePaymentRequestBuilder().build());

                assertThrows(
                        ValidationException.class,
                        () -> paymentsClient
                            .cancelPayment(paymentId, new CancelPaymentRequestBuilder().build()));
            }

            @Test
            void shouldThrowValidationExceptionWhenPartialAmountExceedsRemainingUncapturedAmount() {
                String paymentId = sdkTestHelper.createPaymentAndGetId(800L, "EUR");

                CapturePaymentRequest captureRequest = new CapturePaymentRequestBuilder()
                        .withAmount(600L)
                        .withIsFinal(false)
                        .build();

                paymentsClient
                        .capturePayment(paymentId, captureRequest);

                CancelPaymentRequest cancelRequest = new CancelPaymentRequestBuilder()
                        .withAmount(400L)
                        .withCurrency(CURRENCY_CODE)
                        .withIsFinal(false)
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> paymentsClient
                            .cancelPayment(paymentId, cancelRequest));
            }
        }

        @Nested
        class AfterRefund {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();

                paymentsClient
                        .capturePayment(paymentId, new CapturePaymentRequestBuilder().build());
                RefundRequest refundRequest = new RefundRequestBuilder().build();

                paymentsClient
                        .refundPayment(paymentId, refundRequest);

                assertThrows(
                        ValidationException.class,
                        () -> paymentsClient
                            .cancelPayment(paymentId, new CancelPaymentRequestBuilder().build()));
            }
        }

        @Nested
        class AfterPreviousCancel {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();

                paymentsClient
                        .cancelPayment(paymentId, new CancelPaymentRequestBuilder().build());

                assertThrows(
                        ValidationException.class,
                        () -> paymentsClient
                            .cancelPayment(paymentId, new CancelPaymentRequestBuilder().build()));
            }
        }
    }

    @Nested
    class WhenCapturingPayments {

        @Nested
        class WithValidRequest {

            @Test
            void shouldReturnCapturedPayment() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();

                CapturePaymentRequest captureRequest = new CapturePaymentRequestBuilder().build();

                CaptureResponse response = paymentsClient
                        .capturePayment(paymentId, captureRequest);

                assertNotNull(response);
                assertNotNull(response.getId());
                assertNotNull(response.getStatus());
            }
        }

        @Nested
        class WithPartialAmount {

            @Test
            void shouldReturnCapturedPayment() {
                String paymentId = sdkTestHelper.createPaymentAndGetId(800L, "EUR");

                CapturePaymentRequest captureRequest = new CapturePaymentRequestBuilder()
                        .withAmount(300L)
                        .withIsFinal(false)
                        .build();

                CaptureResponse response = paymentsClient
                        .capturePayment(paymentId, captureRequest);

                assertNotNull(response);
                assertNotNull(response.getId());
                assertNotNull(response.getStatus());
            }

            @Test
            void shouldReturnCapturedPaymentWhenCapturingRemainingAmount() {
                String paymentId = sdkTestHelper.createPaymentAndGetId(800L, "EUR");

                CapturePaymentRequest firstCaptureRequest = new CapturePaymentRequestBuilder()
                        .withAmount(300L)
                        .withIsFinal(false)
                        .build();

                CaptureResponse firstCaptureResponse = paymentsClient
                        .capturePayment(paymentId, firstCaptureRequest);

                assertNotNull(firstCaptureResponse);
                assertNotNull(firstCaptureResponse.getId());

                CapturePaymentRequest secondCaptureRequest = new CapturePaymentRequestBuilder()
                        .withAmount(500L)
                        .withIsFinal(true)
                        .build();

                CaptureResponse secondCaptureResponse = paymentsClient
                        .capturePayment(paymentId, secondCaptureRequest);

                assertNotNull(secondCaptureResponse);
                assertNotNull(secondCaptureResponse.getId());
            }

            @Test
            void shouldThrowValidationExceptionWhenSecondAmountExceedsRemainingAmount() {
                String paymentId = sdkTestHelper.createPaymentAndGetId(800L, "EUR");

                CapturePaymentRequest firstCaptureRequest = new CapturePaymentRequestBuilder()
                        .withAmount(300L)
                        .withIsFinal(false)
                        .build();

                paymentsClient
                        .capturePayment(paymentId, firstCaptureRequest);

                CapturePaymentRequest secondCaptureRequest = new CapturePaymentRequestBuilder()
                        .withAmount(600L)
                        .withIsFinal(false)
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> paymentsClient
                            .capturePayment(paymentId, secondCaptureRequest));
            }
        }

        @Nested
        class AfterPartialCancel {

            @Test
            void shouldReturnCapturedPayment() {
                String paymentId = sdkTestHelper.createPaymentAndGetId(800L, "EUR");

                paymentsClient
                        .cancelPayment(paymentId,
                            new CancelPaymentRequestBuilder()
                                .withAmount(600L)
                                .withCurrency(CURRENCY_CODE)
                                .withIsFinal(false)
                                .build());

                CapturePaymentRequest captureRequest = new CapturePaymentRequestBuilder()
                        .withAmount(200L)
                        .withIsFinal(true)
                        .build();

                CaptureResponse response = paymentsClient
                        .capturePayment(paymentId, captureRequest);

                assertNotNull(response);
                assertNotNull(response.getId());
                assertNotNull(response.getStatus());
            }
        }

        @Nested
        class WithInvalidPaymentId {

            @Test
            void shouldThrowReferenceException() {
                assertThrows(
                        ReferenceException.class,
                        () -> paymentsClient
                            .capturePayment(NON_EXISTING_PAYMENT_ID, new CapturePaymentRequestBuilder().build()));
            }
        }

        @Nested
        class AfterPreviousCapture {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();

                paymentsClient
                        .capturePayment(paymentId, new CapturePaymentRequestBuilder().build());

                assertThrows(
                        ValidationException.class,
                        () -> paymentsClient
                            .capturePayment(paymentId, new CapturePaymentRequestBuilder().build()));
            }
        }

        @Nested
        class AfterCancel {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();

                paymentsClient
                        .cancelPayment(paymentId, new CancelPaymentRequestBuilder().build());

                assertThrows(
                        ValidationException.class,
                        () -> paymentsClient
                            .capturePayment(paymentId, new CapturePaymentRequestBuilder().build()));
            }
        }

        @Nested
        class AfterRefund {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();

                paymentsClient
                        .capturePayment(paymentId, new CapturePaymentRequestBuilder().build());
                RefundRequest refundRequest = new RefundRequestBuilder().build();

                paymentsClient
                        .refundPayment(paymentId, refundRequest);

                assertThrows(
                        ValidationException.class,
                        () -> paymentsClient
                            .capturePayment(paymentId, new CapturePaymentRequestBuilder().build()));
            }
        }
    }

    @Nested
    class WhenRefundingPayments {

        @Nested
        class WithValidRequest {

            @Test
            void shouldReturnRefundedPayment() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();

                paymentsClient
                        .capturePayment(paymentId, new CapturePaymentRequestBuilder().build());
                RefundRequest refundRequest = new RefundRequestBuilder().build();

                RefundResponse response = paymentsClient
                        .refundPayment(paymentId, refundRequest);

                assertNotNull(response);
                assertNotNull(response.getId());
                assertNotNull(response.getStatus());
            }
        }

        @Nested
        class WithPartialAmounts {

            @Test
            void shouldReturnRefundedPayment() {
                String paymentId = sdkTestHelper.createPaymentAndGetId(1500L, "EUR");

                paymentsClient
                        .capturePayment(paymentId, new CapturePaymentRequestBuilder().build());
                RefundRequest firstRefundRequest = new RefundRequestBuilder()
                        .withAmount(300L)
                        .withCurrency(CURRENCY_CODE)
                        .withIsFinal(false)
                        .build();

                paymentsClient
                        .refundPayment(paymentId, firstRefundRequest);
                RefundRequest secondRefundRequest = new RefundRequestBuilder()
                        .withAmount(400L)
                        .withCurrency(CURRENCY_CODE)
                        .withIsFinal(false)
                        .build();

                RefundResponse response = paymentsClient
                        .refundPayment(paymentId, secondRefundRequest);

                assertNotNull(response);
                assertNotNull(response.getId());
                assertNotEquals("REJECTED", response.getStatus());
            }

            @Test
            void shouldReturnActionNotAllowedWhenTotalRefundedAmountExceedsCapturedAmount() {
                String paymentId = sdkTestHelper.createPaymentAndGetId(800L, "EUR");

                CapturePaymentRequest captureRequest = new CapturePaymentRequestBuilder()
                        .withAmount(400L)
                        .withIsFinal(true)
                        .build();

                paymentsClient
                        .capturePayment(paymentId, captureRequest);

                RefundRequest refundRequest = new RefundRequestBuilder()
                        .withAmount(600L)
                        .withCurrency(CURRENCY_CODE)
                        .build();

                ValidationException exception = assertThrows(
                        ValidationException.class,
                        () -> paymentsClient
                            .refundPayment(paymentId, refundRequest));

                assertEquals("ACTION_NOT_ALLOWED_ON_TRANSACTION", exception.getErrors().get(0).getMessage());
            }

            @Test
            void shouldReturnActionNotAllowedWhenSingleRefundExceedsCapturedAmount() {
                String paymentId = sdkTestHelper.createPaymentAndGetId(800L, "EUR");

                CapturePaymentRequest captureRequest = new CapturePaymentRequestBuilder()
                        .withAmount(300L)
                        .withIsFinal(true)
                        .build();

                paymentsClient.capturePayment(paymentId, captureRequest);

                RefundRequest refundRequest = new RefundRequestBuilder()
                        .withAmount(600L)
                        .withCurrency(CURRENCY_CODE)
                        .build();

                ValidationException exception = assertThrows(
                        ValidationException.class,
                        () -> paymentsClient
                            .refundPayment(paymentId, refundRequest));

                assertEquals("ACTION_NOT_ALLOWED_ON_TRANSACTION", exception.getErrors().get(0).getMessage());
            }
        }

        @Nested
        class WithInvalidPaymentId {

            @Test
            void shouldThrowReferenceException() {
                assertThrows(
                        ReferenceException.class,
                        () -> paymentsClient
                            .refundPayment(NON_EXISTING_PAYMENT_ID, new RefundRequestBuilder().build()));
            }
        }

        @Nested
        class WithoutCapture {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();

                assertThrows(
                        ValidationException.class,
                        () -> paymentsClient
                            .refundPayment(paymentId, new RefundRequestBuilder().build()));
            }
        }

        @Nested
        class AfterCancel {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();

                paymentsClient
                        .cancelPayment(paymentId, new CancelPaymentRequestBuilder().build());

                assertThrows(
                        ValidationException.class,
                        () -> paymentsClient
                            .refundPayment(paymentId, new RefundRequestBuilder().build()));
            }
        }

        @Nested
        class AfterPreviousRefund {

            @Test
            void shouldReturnActionNotAllowedWhenTryingToRefundAlreadyRefundedPayment() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();

                paymentsClient
                    .capturePayment(paymentId, new CapturePaymentRequestBuilder().build());

                RefundRequest request = new RefundRequestBuilder().build();

                RefundResponse firstRefundResponse = paymentsClient
                        .refundPayment(paymentId, request);

                assertNotNull(firstRefundResponse);
                assertEquals("REFUND_REQUESTED", firstRefundResponse.getStatus());

                ValidationException exception = assertThrows(
                        ValidationException.class,
                        () -> paymentsClient
                            .refundPayment(paymentId, request));

                assertEquals("ACTION_NOT_ALLOWED_ON_TRANSACTION", exception.getErrors().get(0).getMessage());
            }
        }
    }
}
