package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.onlinepayments.ReferenceException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.AddAuthorizationDetailsResponse;
import com.onlinepayments.domain.CapturePaymentRequest;
import com.onlinepayments.domain.CaptureResponse;
import com.onlinepayments.domain.IncrementAuthorizationRequest;
import com.onlinepayments.domain.IncrementAuthorizationResponse;
import com.onlinepayments.domain.PaymentResponse;
import com.onlinepayments.domain.UpdateAuthorizationAdditionalDataRequest;
import com.onlinepayments.it.util.SdkTestHelper;
import com.onlinepayments.it.util.payments.CancelPaymentRequestBuilder;
import com.onlinepayments.it.util.payments.CapturePaymentRequestBuilder;
import com.onlinepayments.it.util.preAuthorization.IncrementAuthorizationRequestBuilder;
import com.onlinepayments.it.util.preAuthorization.UpdateAuthorizationAdditionalDataRequestBuilder;
import com.onlinepayments.merchant.payments.PaymentsClientInterface;
import com.onlinepayments.merchant.preauthorization.PreAuthorizationClientInterface;

public class PreAuthorizationTest extends ItTest {

    private static final String NON_EXISTING_PAYMENT_ID = "9999999999_0";
    private static final String CURRENCY_CODE = "EUR";
    private static final long PAYMENT_AMOUNT = 1000L;
    private static final long INCREMENTED_AMOUNT = 1500L;

    private ClientInterface client;
    private PaymentsClientInterface paymentsClient;
    private PreAuthorizationClientInterface preAuthorizationClient;

    private SdkTestHelper sdkTestHelper;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        paymentsClient = client.merchant(getMerchantId()).payments();
        preAuthorizationClient = client.merchant(getMerchantId()).preAuthorization();

        sdkTestHelper = getSdkTestHelper(client);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenIncrementingAuthorization {

        @Nested
        class WithPreAuthorizedPayment {

            @Test
            void shouldReturnIncrementedPayment() {
                String paymentId = sdkTestHelper
                        .createPreAuthorizedMastercardPaymentAndGetId(PAYMENT_AMOUNT, CURRENCY_CODE);
                IncrementAuthorizationRequest request = new IncrementAuthorizationRequestBuilder()
                        .withAmount(INCREMENTED_AMOUNT)
                        .build();

                IncrementAuthorizationResponse response = preAuthorizationClient
                        .incrementAuthorization(paymentId, request);

                assertNotNull(response);
                assertNotNull(response.getPayment());
                assertNotNull(response.getPayment().getId());
                assertEquals("PENDING_CAPTURE", response.getPayment().getStatus());

                PaymentResponse payment = paymentsClient.getPayment(paymentId);

                assertNotNull(payment);
                assertEquals("PENDING_CAPTURE", payment.getStatus());
                assertNotNull(payment.getPaymentOutput());
                assertNotNull(payment.getPaymentOutput().getAmountOfMoney());
                assertEquals(INCREMENTED_AMOUNT, payment.getPaymentOutput().getAmountOfMoney().getAmount());
            }

            @Test
            void shouldReturnIncrementedPaymentWithCallContext() {
                String paymentId = sdkTestHelper
                        .createPreAuthorizedMastercardPaymentAndGetId(PAYMENT_AMOUNT, CURRENCY_CODE);
                IncrementAuthorizationRequest request = new IncrementAuthorizationRequestBuilder()
                        .withAmount(INCREMENTED_AMOUNT)
                        .build();
                CallContext context = new CallContext()
                        .withIdempotenceKey("test-increment-authorization-" + UUID.randomUUID());

                IncrementAuthorizationResponse response = preAuthorizationClient
                        .incrementAuthorization(paymentId, request, context);

                assertNotNull(response);
                assertNotNull(response.getPayment());
                assertNotNull(response.getPayment().getId());
                assertEquals("PENDING_CAPTURE", response.getPayment().getStatus());

                PaymentResponse payment = paymentsClient.getPayment(paymentId);

                assertNotNull(payment);
                assertEquals("PENDING_CAPTURE", payment.getStatus());
                assertNotNull(payment.getPaymentOutput());
                assertNotNull(payment.getPaymentOutput().getAmountOfMoney());
                assertEquals(INCREMENTED_AMOUNT, payment.getPaymentOutput().getAmountOfMoney().getAmount());
            }

            @Test
            void shouldReturnCumulativeAmountAfterTwoIncrements() {
                String paymentId = sdkTestHelper
                        .createPreAuthorizedMastercardPaymentAndGetId(PAYMENT_AMOUNT, CURRENCY_CODE);

                IncrementAuthorizationResponse firstResponse = preAuthorizationClient.incrementAuthorization(
                        paymentId,
                        new IncrementAuthorizationRequestBuilder().withAmount(1300L).build());

                assertNotNull(firstResponse);
                assertNotNull(firstResponse.getPayment());

                IncrementAuthorizationResponse secondResponse = preAuthorizationClient.incrementAuthorization(
                        paymentId,
                        new IncrementAuthorizationRequestBuilder().withAmount(INCREMENTED_AMOUNT).build());

                assertNotNull(secondResponse);
                assertNotNull(secondResponse.getPayment());

                PaymentResponse payment = paymentsClient.getPayment(paymentId);

                assertNotNull(payment);
                assertEquals("PENDING_CAPTURE", payment.getStatus());
                assertNotNull(payment.getPaymentOutput());
                assertNotNull(payment.getPaymentOutput().getAmountOfMoney());
                assertEquals(INCREMENTED_AMOUNT, payment.getPaymentOutput().getAmountOfMoney().getAmount());
            }

            @Test
            void shouldCaptureIncrementedAmount() {
                String paymentId = sdkTestHelper
                        .createPreAuthorizedMastercardPaymentAndGetId(PAYMENT_AMOUNT, CURRENCY_CODE);

                preAuthorizationClient.incrementAuthorization(
                        paymentId,
                        new IncrementAuthorizationRequestBuilder().withAmount(INCREMENTED_AMOUNT).build());

                CapturePaymentRequest captureRequest = new CapturePaymentRequestBuilder()
                        .withAmount(INCREMENTED_AMOUNT)
                        .withIsFinal(true)
                        .build();

                CaptureResponse response = paymentsClient.capturePayment(paymentId, captureRequest);

                assertNotNull(response);
                assertNotNull(response.getId());
                assertEquals("CAPTURE_REQUESTED", response.getStatus());
            }
        }

        @Nested
        class WithInvalidPaymentId {

            @Test
            void shouldThrowReferenceException() {
                IncrementAuthorizationRequest request = new IncrementAuthorizationRequestBuilder().build();

                assertThrows(
                        ReferenceException.class,
                        () -> preAuthorizationClient.incrementAuthorization(NON_EXISTING_PAYMENT_ID, request));
            }
        }

        @Nested
        class WithoutAmountOfMoney {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper
                        .createPreAuthorizedMastercardPaymentAndGetId(PAYMENT_AMOUNT, CURRENCY_CODE);

                assertThrows(
                        ValidationException.class,
                        () -> preAuthorizationClient.incrementAuthorization(
                            paymentId,
                            new IncrementAuthorizationRequest()));
            }
        }

        @Nested
        class WithZeroAmount {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper
                        .createPreAuthorizedMastercardPaymentAndGetId(PAYMENT_AMOUNT, CURRENCY_CODE);
                IncrementAuthorizationRequest request = new IncrementAuthorizationRequestBuilder()
                        .withAmount(0L)
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> preAuthorizationClient.incrementAuthorization(paymentId, request));
            }
        }

        @Nested
        class WithDifferentCurrency {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper
                        .createPreAuthorizedMastercardPaymentAndGetId(PAYMENT_AMOUNT, CURRENCY_CODE);
                IncrementAuthorizationRequest request = new IncrementAuthorizationRequestBuilder()
                        .withCurrency("USD")
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> preAuthorizationClient.incrementAuthorization(paymentId, request));
            }
        }

        @Nested
        class WithFinalAuthorizationPayment {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper.createMastercardPaymentAndGetId(PAYMENT_AMOUNT, CURRENCY_CODE);
                IncrementAuthorizationRequest request = new IncrementAuthorizationRequestBuilder().build();

                assertThrows(
                        ValidationException.class,
                        () -> preAuthorizationClient.incrementAuthorization(paymentId, request));
            }
        }

        @Nested
        class AfterCapture {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper
                        .createPreAuthorizedMastercardPaymentAndGetId(PAYMENT_AMOUNT, CURRENCY_CODE);

                paymentsClient.capturePayment(paymentId, new CapturePaymentRequestBuilder().build());

                assertThrows(
                        ValidationException.class,
                        () -> preAuthorizationClient.incrementAuthorization(
                            paymentId,
                            new IncrementAuthorizationRequestBuilder().build()));
            }
        }

        @Nested
        class AfterCancel {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper
                        .createPreAuthorizedMastercardPaymentAndGetId(PAYMENT_AMOUNT, CURRENCY_CODE);

                paymentsClient.cancelPayment(paymentId, new CancelPaymentRequestBuilder().build());

                assertThrows(
                        ValidationException.class,
                        () -> preAuthorizationClient.incrementAuthorization(
                            paymentId,
                            new IncrementAuthorizationRequestBuilder().build()));
            }
        }
    }

    @Nested
    class WhenAddingAuthorizationDetails {

        @Nested
        class WithPreAuthorizedPayment {

            @Test
            void shouldReturnPaymentWithFullCarRentalData() {
                String paymentId = sdkTestHelper.createPreAuthorizedPaymentAndGetId(PAYMENT_AMOUNT, CURRENCY_CODE);
                UpdateAuthorizationAdditionalDataRequest request = new UpdateAuthorizationAdditionalDataRequestBuilder()
                        .build();

                AddAuthorizationDetailsResponse response = preAuthorizationClient
                        .addAuthorizationDetails(paymentId, request);

                assertNotNull(response);
                assertNotNull(response.getPayment());
                assertNotNull(response.getPayment().getId());
                assertEquals("PENDING_CAPTURE", response.getPayment().getStatus());
            }

            @Test
            void shouldReturnPaymentWithMinimalCarRentalData() {
                String paymentId = sdkTestHelper.createPreAuthorizedPaymentAndGetId(PAYMENT_AMOUNT, CURRENCY_CODE);
                UpdateAuthorizationAdditionalDataRequest request = new UpdateAuthorizationAdditionalDataRequestBuilder()
                        .withMinimalCarRentalData()
                        .build();

                AddAuthorizationDetailsResponse response = preAuthorizationClient
                        .addAuthorizationDetails(paymentId, request);

                assertNotNull(response);
                assertNotNull(response.getPayment());
                assertNotNull(response.getPayment().getId());
                assertEquals("PENDING_CAPTURE", response.getPayment().getStatus());
            }

            @Test
            void shouldReturnPaymentWithCallContext() {
                String paymentId = sdkTestHelper.createPreAuthorizedPaymentAndGetId(PAYMENT_AMOUNT, CURRENCY_CODE);
                UpdateAuthorizationAdditionalDataRequest request = new UpdateAuthorizationAdditionalDataRequestBuilder()
                        .build();
                CallContext context = new CallContext()
                        .withIdempotenceKey("test-authorization-details-" + UUID.randomUUID());

                AddAuthorizationDetailsResponse response = preAuthorizationClient
                        .addAuthorizationDetails(paymentId, request, context);

                assertNotNull(response);
                assertNotNull(response.getPayment());
                assertNotNull(response.getPayment().getId());
                assertEquals("PENDING_CAPTURE", response.getPayment().getStatus());
            }

            @Test
            void shouldCapturePaymentAfterAddingDetails() {
                String paymentId = sdkTestHelper.createPreAuthorizedPaymentAndGetId(PAYMENT_AMOUNT, CURRENCY_CODE);

                preAuthorizationClient.addAuthorizationDetails(
                        paymentId,
                        new UpdateAuthorizationAdditionalDataRequestBuilder().build());

                CaptureResponse response = paymentsClient
                        .capturePayment(paymentId, new CapturePaymentRequestBuilder().build());

                assertNotNull(response);
                assertNotNull(response.getId());
                assertEquals("CAPTURE_REQUESTED", response.getStatus());
            }
        }

        @Nested
        class WithInvalidPaymentId {

            @Test
            void shouldThrowReferenceException() {
                UpdateAuthorizationAdditionalDataRequest request = new UpdateAuthorizationAdditionalDataRequestBuilder()
                        .build();

                assertThrows(
                        ReferenceException.class,
                        () -> preAuthorizationClient.addAuthorizationDetails(NON_EXISTING_PAYMENT_ID, request));
            }
        }

        @Nested
        class WithoutCarRentalData {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper.createPreAuthorizedPaymentAndGetId(PAYMENT_AMOUNT, CURRENCY_CODE);

                assertThrows(
                        ValidationException.class,
                        () -> preAuthorizationClient.addAuthorizationDetails(
                            paymentId,
                            new UpdateAuthorizationAdditionalDataRequest()));
            }
        }

        @Nested
        class WithInvalidCarRentalData {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper.createPreAuthorizedPaymentAndGetId(PAYMENT_AMOUNT, CURRENCY_CODE);
                UpdateAuthorizationAdditionalDataRequest request = new UpdateAuthorizationAdditionalDataRequestBuilder()
                        .withChargesCategory("invalid")
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> preAuthorizationClient.addAuthorizationDetails(paymentId, request));
            }
        }

        @Nested
        class AfterCapture {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper.createPreAuthorizedPaymentAndGetId(PAYMENT_AMOUNT, CURRENCY_CODE);

                paymentsClient.capturePayment(paymentId, new CapturePaymentRequestBuilder().build());

                assertThrows(
                        ValidationException.class,
                        () -> preAuthorizationClient.addAuthorizationDetails(
                            paymentId,
                            new UpdateAuthorizationAdditionalDataRequestBuilder().build()));
            }
        }

        @Nested
        class AfterCancel {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper.createPreAuthorizedPaymentAndGetId(PAYMENT_AMOUNT, CURRENCY_CODE);

                paymentsClient.cancelPayment(paymentId, new CancelPaymentRequestBuilder().build());

                assertThrows(
                        ValidationException.class,
                        () -> preAuthorizationClient.addAuthorizationDetails(
                            paymentId,
                            new UpdateAuthorizationAdditionalDataRequestBuilder().build()));
            }
        }
    }
}
