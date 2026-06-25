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
import com.onlinepayments.PlatformException;
import com.onlinepayments.ReferenceException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.CompletePaymentRequest;
import com.onlinepayments.it.util.SdkTestHelper;
import com.onlinepayments.it.util.complete.CompletePaymentRequestBuilder;
import com.onlinepayments.merchant.complete.CompleteClientInterface;

public class CompleteTest extends ItTest {

    private static final String NON_EXISTING_PAYMENT_ID = "9999999999_0";

    private ClientInterface client;
    private CompleteClientInterface completeClient;

    private SdkTestHelper sdkTestHelper;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        completeClient = client.merchant(getMerchantId()).complete();

        sdkTestHelper = getSdkTestHelper(client);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenCompletingPayment {

        @Nested
        class WithValidPaymentId {

            @Test
            void shouldThrowPlatformExceptionSinceRedirectPaymentFlow() {
                String paymentId = sdkTestHelper.createPayPalPaymentAndGetId();
                CompletePaymentRequest request = new CompletePaymentRequestBuilder().build();

                PlatformException exception = assertThrows(
                        PlatformException.class,
                        () -> completeClient.completePayment(paymentId, request)
                );

                assertNotNull(exception.getErrors());
                assertNotNull(exception.getErrors().get(0).getHttpStatusCode());
                assertEquals(500, exception.getErrors().get(0).getHttpStatusCode());

                assertNotNull(exception.getErrors().get(0).getCategory());
                assertEquals("DIRECT_PLATFORM_ERROR", exception.getErrors().get(0).getCategory());
            }

            @Test
            void shouldThrowPlatformExceptionSinceRedirectPaymentFlowWithCallContext() {
                String paymentId = sdkTestHelper.createPayPalPaymentAndGetId();
                CompletePaymentRequest request = new CompletePaymentRequestBuilder().build();
                CallContext context = new CallContext().withIdempotenceKey("test-complete-" + UUID.randomUUID());

                PlatformException exception = assertThrows(
                        PlatformException.class,
                        () -> completeClient.completePayment(paymentId, request, context)
                );

                assertNotNull(exception.getErrors());
                assertNotNull(exception.getErrors().get(0).getHttpStatusCode());
                assertEquals(500, exception.getErrors().get(0).getHttpStatusCode());

                assertNotNull(exception.getErrors().get(0).getCategory());
                assertEquals("DIRECT_PLATFORM_ERROR", exception.getErrors().get(0).getCategory());
            }
        }

        @Nested
        class WithInvalidPaymentId {

            @Test
            void shouldThrowReferenceException() {
                CompletePaymentRequest request = new CompletePaymentRequestBuilder().build();

                assertThrows(
                        ReferenceException.class,
                        () -> completeClient.completePayment(NON_EXISTING_PAYMENT_ID, request));
            }
        }

        @Nested
        class WithInvalidInput {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper.createPayPalPaymentAndGetId();
                CompletePaymentRequest request = new CompletePaymentRequestBuilder()
                        .withOrder(null)
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> completeClient.completePayment(paymentId, request));
            }
        }
    }
}
