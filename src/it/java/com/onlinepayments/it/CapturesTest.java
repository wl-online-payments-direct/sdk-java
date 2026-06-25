package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import com.onlinepayments.domain.CapturesResponse;
import com.onlinepayments.it.util.SdkTestHelper;
import com.onlinepayments.it.util.payments.CapturePaymentRequestBuilder;
import com.onlinepayments.merchant.captures.CapturesClientInterface;
import com.onlinepayments.merchant.payments.PaymentsClientInterface;

public class CapturesTest extends ItTest {

    private static final String NON_EXISTING_PAYMENT_ID = "9999999999_0";

    private ClientInterface client;
    private PaymentsClientInterface paymentsClient;
    private CapturesClientInterface capturesClient;

    private SdkTestHelper sdkTestHelper;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        paymentsClient = client.merchant(getMerchantId()).payments();
        capturesClient = client.merchant(getMerchantId()).captures();

        sdkTestHelper = getSdkTestHelper(client);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenGettingCaptures {

        @Nested
        class WithExistingPaymentId {

            @Test
            void shouldReturnCaptures() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();
                paymentsClient.capturePayment(paymentId, new CapturePaymentRequestBuilder().build());

                CapturesResponse response = capturesClient.getCaptures(paymentId);

                assertNotNull(response);
                assertNotNull(response.getCaptures());
                assertFalse(response.getCaptures().isEmpty());
                assertNotNull(response.getCaptures().get(0));
                assertNotNull(response.getCaptures().get(0).getId());
                assertNotNull(response.getCaptures().get(0).getStatus());
            }

            @Test
            void shouldReturnCapturesWithCallContext() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();
                paymentsClient.capturePayment(paymentId, new CapturePaymentRequestBuilder().build());

                CallContext context = new CallContext().withIdempotenceKey("test-captures-" + UUID.randomUUID());
                CapturesResponse response = capturesClient.getCaptures(paymentId, context);

                assertNotNull(response);
                assertNotNull(response.getCaptures());
                assertFalse(response.getCaptures().isEmpty());
                assertNotNull(response.getCaptures().get(0));
                assertNotNull(response.getCaptures().get(0).getId());
                assertNotNull(response.getCaptures().get(0).getStatus());
            }

            @Test
            void shouldReturnCaptureDetails() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();
                paymentsClient.capturePayment(paymentId, new CapturePaymentRequestBuilder().build());

                CapturesResponse response = capturesClient.getCaptures(paymentId);

                assertNotNull(response);
                assertNotNull(response.getCaptures());
                assertFalse(response.getCaptures().isEmpty());

                assertNotNull(response.getCaptures().get(0).getId());
                assertNotNull(response.getCaptures().get(0).getStatus());
                assertNotNull(response.getCaptures().get(0).getCaptureOutput());
                assertNotNull(response.getCaptures().get(0).getStatusOutput());
            }

            @Test
            void shouldReturnMultipleCapturesIfExists() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();
                paymentsClient.capturePayment(paymentId, new CapturePaymentRequestBuilder().build());

                CapturesResponse response = capturesClient.getCaptures(paymentId);

                assertNotNull(response);
                assertNotNull(response.getCaptures());
                assertFalse(response.getCaptures().isEmpty());

                for (int i = 0; i < response.getCaptures().size(); i++) {
                    assertNotNull(response.getCaptures().get(i).getId());
                    assertNotNull(response.getCaptures().get(i).getStatus());
                }
            }
        }

        @Nested
        class WithInvalidPaymentId {

            @Test
            void shouldThrowReferenceException() {
                ReferenceException exception = assertThrows(
                        ReferenceException.class,
                        () -> capturesClient.getCaptures(NON_EXISTING_PAYMENT_ID)
                );

                assertEquals(404, exception.getStatusCode());
            }
        }
    }
}
