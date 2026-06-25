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
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.APIError;
import com.onlinepayments.domain.CreatePayoutRequest;
import com.onlinepayments.domain.PayoutResponse;
import com.onlinepayments.it.util.SdkTestHelper;
import com.onlinepayments.it.util.payout.CreatePayoutRequestBuilder;
import com.onlinepayments.merchant.payouts.PayoutsClientInterface;

public class PayoutsTest extends ItTest {

    private static final String NON_EXISTING_PAYOUT_ID = "9999999999_0";

    private ClientInterface client;
    private PayoutsClientInterface payoutsClient;

    private SdkTestHelper sdkTestHelper;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        payoutsClient = client.merchant(getMerchantId()).payouts();

        sdkTestHelper = getSdkTestHelper(client);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenCreatingPayouts {

        @Nested
        class WithValidCardInput {

            @Test
            void shouldReturnCreatedPayout() {
                CreatePayoutRequest request = new CreatePayoutRequestBuilder().build();

                PayoutResponse response = payoutsClient.createPayout(request);

                assertNotNull(response);
                assertNotNull(response.getId());
                assertFalse(response.getId().isEmpty());

                assertNotNull(response.getStatus());
                assertNotNull(response.getPayoutOutput());
                assertNotNull(response.getPayoutOutput().getAmountOfMoney());

                assertEquals(
                        request.getAmountOfMoney().getAmount(),
                        response.getPayoutOutput().getAmountOfMoney().getAmount());

                assertEquals(
                        request.getAmountOfMoney().getCurrencyCode(),
                        response.getPayoutOutput().getAmountOfMoney().getCurrencyCode());
            }

            @Test
            void shouldReturnCreatedPayoutWithCallContext() {
                CreatePayoutRequest request = new CreatePayoutRequestBuilder().build();

                CallContext context = new CallContext().withIdempotenceKey("test-payouts-" + UUID.randomUUID());

                PayoutResponse response = payoutsClient.createPayout(request, context);

                assertNotNull(response);
                assertNotNull(response.getId());
                assertFalse(response.getId().isEmpty());

                assertNotNull(response.getStatus());
                assertNotNull(response.getPayoutOutput());
                assertNotNull(response.getPayoutOutput().getAmountOfMoney());

                assertEquals(
                        request.getAmountOfMoney().getAmount(),
                        response.getPayoutOutput().getAmountOfMoney().getAmount());

                assertEquals(
                        request.getAmountOfMoney().getCurrencyCode(),
                        response.getPayoutOutput().getAmountOfMoney().getCurrencyCode());
            }
        }

        @Nested
        class WithInvalidAmount {

            @Test
            void shouldThrowValidationException() {
                CreatePayoutRequest request = new CreatePayoutRequestBuilder()
                        .withAmount(-1000)
                        .withCurrency("EUR")
                        .build();

                ValidationException exception = assertThrows(
                        ValidationException.class,
                        () -> payoutsClient.createPayout(request));

                assertNotNull(exception);
                assertNotNull(exception.getErrors());
                assertFalse(exception.getErrors().isEmpty());
                assertNotNull(exception.getErrorId());

                APIError error = exception.getErrors().get(0);
                assertEquals("INVALID_VALUE", error.getId());
                assertEquals(400, error.getHttpStatusCode());
            }
        }

        @Nested
        class WithInvalidCurrencyCode {

            @Test
            void shouldThrowValidationException() {
                CreatePayoutRequest request = new CreatePayoutRequestBuilder()
                        .withAmount(1000)
                        .withCurrency("INVALID")
                        .build();

                ValidationException exception = assertThrows(
                        ValidationException.class,
                        () -> payoutsClient.createPayout(request));

                assertNotNull(exception);
                assertNotNull(exception.getErrors());
                assertFalse(exception.getErrors().isEmpty());
                assertNotNull(exception.getErrorId());

                APIError error = exception.getErrors().get(0);
                assertEquals("INVALID_VALUE", error.getId());
                assertEquals(400, error.getHttpStatusCode());
            }
        }

        @Nested
        class WithInvalidCardNumber {

            @Test
            void shouldThrowValidationException() {
                CreatePayoutRequest request = new CreatePayoutRequestBuilder()
                        .withCardNumber("123")
                        .build();

                ValidationException exception = assertThrows(
                        ValidationException.class,
                        () -> payoutsClient.createPayout(request));

                assertNotNull(exception);
                assertNotNull(exception.getErrors());
                assertFalse(exception.getErrors().isEmpty());
                assertNotNull(exception.getErrorId());

                APIError error = exception.getErrors().get(0);
                assertEquals("INVALID_VALUE", error.getId());
                assertEquals(400, error.getHttpStatusCode());
            }
        }
    }

    @Nested
    class WhenGettingPayouts {

        @Nested
        class WithExistingPayoutId {

            @Test
            void shouldReturnPayout() {
                String payoutId = sdkTestHelper.createPayoutAndGetId();

                PayoutResponse response = payoutsClient.getPayout(payoutId);

                assertNotNull(response);
                assertNotNull(response.getId());
                assertFalse(response.getId().isEmpty());
                assertEquals(payoutId, response.getId());

                assertNotNull(response.getStatus());
                assertFalse(response.getStatus().isEmpty());
                assertEquals("ACCOUNT_CREDITED", response.getStatus());

                assertNotNull(response.getPayoutOutput());
                assertNotNull(response.getStatusOutput());
                assertEquals("REFUNDED", response.getStatusOutput().getStatusCategory());
                assertEquals(Integer.valueOf(8), response.getStatusOutput().getStatusCode());
            }
        }

        @Nested
        class WithInvalidPayoutId {

            @Test
            void shouldThrowReferenceException() {
                assertThrows(
                        ReferenceException.class,
                        () -> payoutsClient.getPayout(NON_EXISTING_PAYOUT_ID));
            }
        }
    }
}
