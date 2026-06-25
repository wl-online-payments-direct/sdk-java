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
import com.onlinepayments.domain.RefundsResponse;
import com.onlinepayments.it.util.SdkTestHelper;
import com.onlinepayments.it.util.payments.CapturePaymentRequestBuilder;
import com.onlinepayments.it.util.payments.RefundRequestBuilder;
import com.onlinepayments.merchant.payments.PaymentsClientInterface;
import com.onlinepayments.merchant.refunds.RefundsClientInterface;

public class RefundsTest extends ItTest {

    private static final String NON_EXISTING_PAYMENT_ID = "9999999999_0";

    private ClientInterface client;
    private PaymentsClientInterface paymentsClient;
    private RefundsClientInterface refundsClient;

    private SdkTestHelper sdkTestHelper;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        paymentsClient = client.merchant(getMerchantId()).payments();
        refundsClient = client.merchant(getMerchantId()).refunds();

        sdkTestHelper = getSdkTestHelper(client);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenGettingRefunds {

        @Nested
        class WithExistingPaymentId {

            @Test
            void shouldReturnRefunds() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();
                paymentsClient.capturePayment(paymentId, new CapturePaymentRequestBuilder().build());

                paymentsClient.refundPayment(paymentId, new RefundRequestBuilder().build());

                RefundsResponse response = refundsClient.getRefunds(paymentId);

                assertNotNull(response);
                assertNotNull(response.getRefunds());
                assertFalse(response.getRefunds().isEmpty());
                assertNotNull(response.getRefunds().get(0));
                assertNotNull(response.getRefunds().get(0).getId());
                assertNotNull(response.getRefunds().get(0).getStatus());
            }

            @Test
            void shouldReturnRefundsWithCallContext() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();
                paymentsClient.capturePayment(paymentId, new CapturePaymentRequestBuilder().build());

                paymentsClient.refundPayment(paymentId, new RefundRequestBuilder().build());

                CallContext context = new CallContext().withIdempotenceKey("test-refunds-" + UUID.randomUUID());
                RefundsResponse response = refundsClient.getRefunds(paymentId, context);

                assertNotNull(response);
                assertNotNull(response.getRefunds());
                assertFalse(response.getRefunds().isEmpty());
                assertNotNull(response.getRefunds().get(0));
                assertNotNull(response.getRefunds().get(0).getId());
                assertNotNull(response.getRefunds().get(0).getStatus());
            }

            @Test
            void shouldReturnRefundDetails() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();
                paymentsClient.capturePayment(paymentId, new CapturePaymentRequestBuilder().build());

                paymentsClient.refundPayment(paymentId, new RefundRequestBuilder().build());

                RefundsResponse response = refundsClient.getRefunds(paymentId);

                assertNotNull(response);
                assertNotNull(response.getRefunds());
                assertFalse(response.getRefunds().isEmpty());

                assertNotNull(response.getRefunds().get(0).getId());
                assertNotNull(response.getRefunds().get(0).getStatus());
                assertNotNull(response.getRefunds().get(0).getRefundOutput());
                assertNotNull(response.getRefunds().get(0).getStatusOutput());
            }

            @Test
            void shouldReturnMultipleRefundsIfExists() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();
                paymentsClient.capturePayment(paymentId, new CapturePaymentRequestBuilder().build());

                paymentsClient.refundPayment(paymentId, new RefundRequestBuilder().build());

                RefundsResponse response = refundsClient.getRefunds(paymentId);

                assertNotNull(response);
                assertNotNull(response.getRefunds());
                assertFalse(response.getRefunds().isEmpty());

                for (int i = 0; i < response.getRefunds().size(); i++) {
                    assertNotNull(response.getRefunds().get(i).getId());
                    assertNotNull(response.getRefunds().get(i).getStatus());
                }
            }
        }

        @Nested
        class WithInvalidPaymentId {

            @Test
            void shouldThrowReferenceException() {
                ReferenceException exception = assertThrows(
                        ReferenceException.class,
                        () -> refundsClient.getRefunds(NON_EXISTING_PAYMENT_ID)
                );

                assertEquals(404, exception.getStatusCode());
            }
        }
    }
}
