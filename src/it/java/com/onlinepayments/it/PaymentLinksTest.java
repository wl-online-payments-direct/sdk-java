package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.CallContext;
import com.onlinepayments.ClientInterface;
import com.onlinepayments.ReferenceException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.CreatePaymentLinkRequest;
import com.onlinepayments.domain.PaymentLinkResponse;
import com.onlinepayments.it.util.SdkTestHelper;
import com.onlinepayments.it.util.paymentLink.CreatePaymentLinkRequestBuilder;
import com.onlinepayments.merchant.paymentlinks.PaymentLinksClientInterface;

public class PaymentLinksTest extends ItTest {

    private static final String UNKNOWN_PAYMENT_LINK_ID = "00000000-0000-0000-0000-000000000000";
    private static final String INVALID_PAYMENT_LINK_ID = "invalid-id";

    private ClientInterface client;
    private PaymentLinksClientInterface paymentLinksClient;

    private SdkTestHelper sdkTestHelper;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        paymentLinksClient = client.merchant(getMerchantId()).paymentLinks();

        sdkTestHelper = getSdkTestHelper(client);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenCreatingPaymentLinks {

        @Nested
        class WithValidInput {

            @Test
            void shouldReturnCreatedPaymentLink() {
                CreatePaymentLinkRequest request = new CreatePaymentLinkRequestBuilder().build();

                PaymentLinkResponse response = paymentLinksClient.createPaymentLink(request);

                assertNotNull(response);
                assertNotNull(response.getPaymentLinkId());
                assertNotNull(response.getStatus());
                assertNotNull(response.getRedirectionUrl());
            }

            @Test
            void shouldReturnCreatedPaymentLinkWithCallContext() {
                CreatePaymentLinkRequest request = new CreatePaymentLinkRequestBuilder().build();

                CallContext context = new CallContext().withIdempotenceKey("test-payment-links-" + UUID.randomUUID());

                PaymentLinkResponse response = paymentLinksClient.createPaymentLink(request, context);

                assertNotNull(response);
                assertNotNull(response.getPaymentLinkId());
                assertNotNull(response.getStatus());
                assertNotNull(response.getRedirectionUrl());
            }

            @Test
            void shouldReturnQrCodeBase64() {
                CreatePaymentLinkRequest request = new CreatePaymentLinkRequestBuilder()
                        .withDisplayQRCode(true)
                        .build();

                PaymentLinkResponse response = paymentLinksClient.createPaymentLink(request);

                assertNotNull(response);
                assertNotNull(response.getPaymentLinkId());
                assertNotNull(response.getQrCodeBase64());
            }

            @Test
            void shouldReturnReusableLinkFlagSetToTrue() {
                CreatePaymentLinkRequest request = new CreatePaymentLinkRequestBuilder()
                        .withReusableLink(true)
                        .build();

                PaymentLinkResponse response = paymentLinksClient.createPaymentLink(request);

                assertNotNull(response);
                assertNotNull(response.getPaymentLinkId());
                assertEquals(Boolean.TRUE, response.getIsReusableLink());
            }
        }

        @Nested
        class WithInvalidAmount {

            @Test
            void shouldThrowValidationException() {
                CreatePaymentLinkRequest request = new CreatePaymentLinkRequestBuilder()
                        .withAmount(-1000L)
                        .withCurrency("EUR")
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> paymentLinksClient.createPaymentLink(request));
            }
        }

        @Nested
        class WithInvalidExpirationDate {

            @Test
            void shouldThrowValidationExceptionWhenExpirationDateIsInThePast() {
                CreatePaymentLinkRequest request = new CreatePaymentLinkRequestBuilder()
                        .withExpirationDate(ZonedDateTime.now(ZoneOffset.UTC).minusDays(1))
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> paymentLinksClient.createPaymentLink(request));
            }
        }
    }

    @Nested
    class WhenGettingPaymentLinks {

        @Nested
        class WithExistingPaymentLinkId {

            @Test
            void shouldReturnPaymentLink() {
                String paymentLinkId = sdkTestHelper.createPaymentLinkAndGetId();

                PaymentLinkResponse response = paymentLinksClient.getPaymentLinkById(paymentLinkId);

                assertNotNull(response);
                assertNotNull(response.getPaymentLinkId());
                assertEquals(paymentLinkId, response.getPaymentLinkId());
                assertNotNull(response.getStatus());
            }
        }

        @Nested
        class WithInvalidPaymentLinkId {

            @Test
            void shouldThrowReferenceExceptionWhenPaymentLinkIdDoesNotExist() {
                assertThrows(
                        ReferenceException.class,
                        () -> paymentLinksClient.getPaymentLinkById(UNKNOWN_PAYMENT_LINK_ID));
            }

            @Test
            void shouldThrowValidationExceptionWhenPaymentLinkIdFormatIsInvalid() {
                assertThrows(
                        ValidationException.class,
                        () -> paymentLinksClient.getPaymentLinkById(INVALID_PAYMENT_LINK_ID));
            }
        }
    }

    @Nested
    class WhenCancellingPaymentLinks {

        @Nested
        class WithValidPaymentLinkId {

            @Test
            void shouldCancelPaymentLink() {
                String paymentLinkId = sdkTestHelper.createPaymentLinkAndGetId();

                paymentLinksClient.cancelPaymentLinkById(paymentLinkId);

                PaymentLinkResponse response = paymentLinksClient.getPaymentLinkById(paymentLinkId);

                assertNotNull(response);
                assertEquals(paymentLinkId, response.getPaymentLinkId());
                assertNotNull(response.getPaymentLinkEvents());
                assertEquals("CANCELLED", response.getPaymentLinkEvents().get(1).getType());
            }
        }

        @Nested
        class WithInvalidPaymentLinkId {

            @Test
            void shouldThrowReferenceExceptionWhenPaymentLinkIdDoesNotExist() {
                assertThrows(
                        ReferenceException.class,
                        () -> paymentLinksClient.cancelPaymentLinkById(UNKNOWN_PAYMENT_LINK_ID));
            }

            @Test
            void shouldThrowValidationExceptionWhenPaymentLinkIdFormatIsInvalid() {
                assertThrows(
                        ValidationException.class,
                        () -> paymentLinksClient.cancelPaymentLinkById(INVALID_PAYMENT_LINK_ID));
            }
        }

        @Nested
        class AfterPreviousCancel {

            @Test
            void shouldThrowReferenceExceptionOrValidationException() {
                String paymentLinkId = sdkTestHelper.createPaymentLinkAndGetId();

                paymentLinksClient.cancelPaymentLinkById(paymentLinkId);

                assertThrows(
                        ReferenceException.class,
                        () -> paymentLinksClient.cancelPaymentLinkById(paymentLinkId));
            }
        }
    }
}
