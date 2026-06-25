package com.onlinepayments.it;

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
import com.onlinepayments.domain.SubsequentPaymentRequest;
import com.onlinepayments.domain.SubsequentPaymentResponse;
import com.onlinepayments.it.util.SdkTestHelper;
import com.onlinepayments.it.util.subsequent.SubsequentPaymentRequestBuilder;
import com.onlinepayments.merchant.subsequent.SubsequentClientInterface;

public class SubsequentsTest extends ItTest {

    private static final String NON_EXISTING_PAYMENT_ID = "9999999999";

    private ClientInterface client;
    private SubsequentClientInterface subsequentClient;

    private SdkTestHelper sdkTestHelper;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        subsequentClient = client.merchant(getMerchantId()).subsequent();

        sdkTestHelper = getSdkTestHelper(client);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenCreatingSubsequentPayment {

        @Nested
        class WithValidInput {

            @Test
            void shouldReturnPaymentId() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();
                SubsequentPaymentRequest request = new SubsequentPaymentRequestBuilder().build();

                SubsequentPaymentResponse response = subsequentClient.subsequentPayment(paymentId, request);

                assertNotNull(response);
                assertNotNull(response.getPayment());
                assertNotNull(response.getPayment().getId());
                assertNotNull(response.getPayment().getStatus());
            }

            @Test
            void shouldReturnPaymentIdWithCallContext() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();
                SubsequentPaymentRequest request = new SubsequentPaymentRequestBuilder().build();
                CallContext context = new CallContext().withIdempotenceKey("test-subsequent-" + UUID.randomUUID());

                SubsequentPaymentResponse response = subsequentClient.subsequentPayment(paymentId, request, context);

                assertNotNull(response);
                assertNotNull(response.getPayment());
                assertNotNull(response.getPayment().getId());
                assertNotNull(response.getPayment().getStatus());
            }
        }

        @Nested
        class WithInvalidAmount {

            @Test
            void shouldThrowValidationException() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();
                SubsequentPaymentRequest request = new SubsequentPaymentRequestBuilder()
                        .withAmount(-1000L)
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> subsequentClient.subsequentPayment(paymentId, request));
            }
        }

        @Nested
        class WithInvalidPaymentId {

            @Test
            void shouldThrowReferenceException() {
                SubsequentPaymentRequest request = new SubsequentPaymentRequestBuilder().build();

                assertThrows(
                        ReferenceException.class,
                        () -> subsequentClient.subsequentPayment(NON_EXISTING_PAYMENT_ID, request));
            }
        }
    }
}
