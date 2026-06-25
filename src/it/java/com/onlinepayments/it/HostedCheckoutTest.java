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
import com.onlinepayments.domain.CreateHostedCheckoutRequest;
import com.onlinepayments.domain.CreateHostedCheckoutResponse;
import com.onlinepayments.domain.GetHostedCheckoutResponse;
import com.onlinepayments.it.util.hostedCheckout.CreateHostedCheckoutRequestBuilder;
import com.onlinepayments.merchant.hostedcheckout.HostedCheckoutClientInterface;

public class HostedCheckoutTest extends ItTest {

    private static final String INVALID_HOSTED_CHECKOUT_ID = "9999999999";

    private ClientInterface client;
    private HostedCheckoutClientInterface hostedCheckoutClient;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        hostedCheckoutClient = client.merchant(getMerchantId()).hostedCheckout();
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenCreatingHostedCheckout {

        @Nested
        class WithCardPayment {

            @Test
            void shouldReturnHostedCheckoutWithCard() {
                CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                        .withFirstName("John")
                        .withSurname("Doe")
                        .build();

                CreateHostedCheckoutResponse response = hostedCheckoutClient
                        .createHostedCheckout(request);

                assertNotNull(response);
                assertNotNull(response.getHostedCheckoutId());
                assertNotNull(response.getRedirectUrl());
                assertFalse(response.getRedirectUrl().isEmpty());
            }

            @Test
            void shouldReturnHostedCheckoutWithCardAndCustomerDetails() {
                CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                        .withAmount(5000L)
                        .withCurrency("EUR")
                        .withCountryCode("DE")
                        .withLocale("en_GB")
                        .withFirstName("Jane")
                        .withSurname("Smith")
                        .withEmailAddress("jane@example.com")
                        .withPhoneNumber("+441234567890")
                        .build();

                CreateHostedCheckoutResponse response = hostedCheckoutClient
                        .createHostedCheckout(request);

                assertNotNull(response);
                assertNotNull(response.getHostedCheckoutId());
                assertNotNull(response.getRedirectUrl());
                assertFalse(response.getRedirectUrl().isEmpty());
            }

            @Test
            void shouldReturnHostedCheckoutWithCardAndFilters() {
                CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                        .withFirstName("Bob")
                        .withSurname("Johnson")
                        .withAmount(2500L)
                        .withCurrency("EUR")
                        .withCountryCode("DE")
                        .withLocale("de_DE")
                        .build();

                CreateHostedCheckoutResponse response = hostedCheckoutClient
                        .createHostedCheckout(request);

                assertNotNull(response);
                assertNotNull(response.getHostedCheckoutId());
                assertNotNull(response.getRedirectUrl());
                assertFalse(response.getRedirectUrl().isEmpty());
            }

            @Test
            void shouldReturnHostedCheckoutWithSessionTimeout() {
                CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                        .withSessionTimeout(300)
                        .withFirstName("Alex")
                        .withSurname("Williams")
                        .build();

                CreateHostedCheckoutResponse response = hostedCheckoutClient
                        .createHostedCheckout(request);

                assertNotNull(response);
                assertNotNull(response.getHostedCheckoutId());
                assertNotNull(response.getRedirectUrl());
                assertFalse(response.getRedirectUrl().isEmpty());
            }

            @Test
            void shouldReturnHostedCheckoutWithDifferentLocales() {
                String[] locales = { "en_US", "de_DE", "fr_FR", "es_ES", "it_IT", "nl_NL" };

                for (String locale : locales) {
                    CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                            .withLocale(locale)
                            .withFirstName("Test")
                            .withSurname("User")
                            .build();

                    CreateHostedCheckoutResponse response = hostedCheckoutClient
                            .createHostedCheckout(request);

                    assertNotNull(response);
                    assertNotNull(response.getHostedCheckoutId());
                    assertNotNull(response.getRedirectUrl());
                    assertFalse(response.getRedirectUrl().isEmpty());
                }
            }

            @Test
            void shouldReturnHostedCheckoutWithCustomAmount() {
                CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                        .withAmount(9999L)
                        .withCurrency("EUR")
                        .withFirstName("Rich")
                        .withSurname("Customer")
                        .build();

                CreateHostedCheckoutResponse response = hostedCheckoutClient
                        .createHostedCheckout(request);

                assertNotNull(response);
                assertNotNull(response.getHostedCheckoutId());
                assertNotNull(response.getRedirectUrl());
                assertFalse(response.getRedirectUrl().isEmpty());
            }

            @Test
            void shouldReturnHostedCheckoutWithBillingAddress() {
                CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                        .withFirstName("John")
                        .withSurname("Resident")
                        .withCountryCode("US")
                        .withCity("San Francisco")
                        .withStreet("Main Street")
                        .withHouseNumber("123")
                        .withState("CA")
                        .withZip("94102")
                        .build();

                CreateHostedCheckoutResponse response = hostedCheckoutClient
                        .createHostedCheckout(request);

                assertNotNull(response);
                assertNotNull(response.getHostedCheckoutId());
                assertNotNull(response.getRedirectUrl());
                assertFalse(response.getRedirectUrl().isEmpty());
            }

            @Test
            void shouldReturnHostedCheckoutWithClickToPay() {
                CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                        .withCardClickToPay(true)
                        .withFirstName("ClickToPay")
                        .withSurname("Customer")
                        .build();

                CreateHostedCheckoutResponse response = hostedCheckoutClient
                        .createHostedCheckout(request);

                assertNotNull(response);
                assertNotNull(response.getHostedCheckoutId());
                assertNotNull(response.getRedirectUrl());
                assertFalse(response.getRedirectUrl().isEmpty());
            }

            @Test
            void shouldReturnHostedCheckoutWithGroupCards() {
                CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                        .withCardGroupCards(true)
                        .withFirstName("GroupCards")
                        .withSurname("Customer")
                        .build();

                CreateHostedCheckoutResponse response = hostedCheckoutClient
                        .createHostedCheckout(request);

                assertNotNull(response);
                assertNotNull(response.getHostedCheckoutId());
                assertNotNull(response.getRedirectUrl());
                assertFalse(response.getRedirectUrl().isEmpty());
            }

            @Test
            void shouldReturnHostedCheckoutWithCallContext() {
                CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                        .withFirstName("CallContext")
                        .withSurname("Test")
                        .build();

                CallContext context = new CallContext().withIdempotenceKey("test-hosted-checkout-" + UUID.randomUUID());
                CreateHostedCheckoutResponse response = hostedCheckoutClient
                        .createHostedCheckout(request, context);

                assertNotNull(response);
                assertNotNull(response.getHostedCheckoutId());
                assertNotNull(response.getRedirectUrl());
                assertFalse(response.getRedirectUrl().isEmpty());
            }
        }
    }

    @Nested
    class WhenRetrievingHostedCheckout {

        @Test
        void shouldRetrieveHostedCheckoutStatus() {
            CreateHostedCheckoutRequest createRequest = new CreateHostedCheckoutRequestBuilder()
                    .withFirstName("Status")
                    .withSurname("Check")
                    .build();

            CreateHostedCheckoutResponse createResponse = hostedCheckoutClient
                    .createHostedCheckout(createRequest);

            String hostedCheckoutId = createResponse.getHostedCheckoutId();
            assertNotNull(hostedCheckoutId);

            GetHostedCheckoutResponse getResponse = hostedCheckoutClient
                    .getHostedCheckout(hostedCheckoutId);

            assertNotNull(getResponse);
            assertNotNull(getResponse.getStatus());
        }

        @Test
        void shouldRetrieveCreatedHostedCheckout() {
            CreateHostedCheckoutRequest createRequest = new CreateHostedCheckoutRequestBuilder()
                    .withAmount(7500L)
                    .withCurrency("EUR")
                    .withCountryCode("DE")
                    .withLocale("en_GB")
                    .withFirstName("Retrieve")
                    .withSurname("Payment")
                    .build();

            CreateHostedCheckoutResponse createResponse = hostedCheckoutClient
                    .createHostedCheckout(createRequest);

            String hostedCheckoutId = createResponse.getHostedCheckoutId();
            assertNotNull(hostedCheckoutId);

            GetHostedCheckoutResponse getResponse = hostedCheckoutClient
                    .getHostedCheckout(hostedCheckoutId);

            assertNotNull(getResponse);
            assertNotNull(getResponse.getCreatedPaymentOutput());
        }

        @Nested
        class WithInvalidHostedCheckoutId {

            @Test
            void shouldThrowReferenceExceptionNotFound() {
                ReferenceException exception = assertThrows(
                        ReferenceException.class,
                        () -> hostedCheckoutClient.getHostedCheckout(INVALID_HOSTED_CHECKOUT_ID)
                );

                assertEquals(404, exception.getStatusCode());
            }
        }
    }

    @Nested
    class WhenUsingShowResultPage {

        @Test
        void shouldCreateHostedCheckoutWithResultPageHidden() {
            CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                    .withShowResultPage(false)
                    .withFirstName("Silent")
                    .withSurname("Payment")
                    .build();

            CreateHostedCheckoutResponse response = hostedCheckoutClient
                    .createHostedCheckout(request);

            assertNotNull(response);
            assertNotNull(response.getHostedCheckoutId());
            assertNotNull(response.getRedirectUrl());
            assertFalse(response.getRedirectUrl().isEmpty());
        }

        @Test
        void shouldCreateHostedCheckoutWithResultPageShown() {
            CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                    .withShowResultPage(true)
                    .withFirstName("Visible")
                    .withSurname("Result")
                    .build();

            CreateHostedCheckoutResponse response = hostedCheckoutClient
                    .createHostedCheckout(request);

            assertNotNull(response);
            assertNotNull(response.getHostedCheckoutId());
            assertNotNull(response.getRedirectUrl());
            assertFalse(response.getRedirectUrl().isEmpty());
        }
    }

    @Nested
    class WhenUsingRecurringPayments {

        @Test
        void shouldCreateRecurringHostedCheckout() {
            CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                    .withIsRecurring(true)
                    .withFirstName("Recurring")
                    .withSurname("Customer")
                    .build();

            CreateHostedCheckoutResponse response = hostedCheckoutClient
                    .createHostedCheckout(request);

            assertNotNull(response);
            assertNotNull(response.getHostedCheckoutId());
            assertNotNull(response.getRedirectUrl());
            assertFalse(response.getRedirectUrl().isEmpty());
        }

        @Test
        void shouldCreateOneOffHostedCheckout() {
            CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                    .withIsRecurring(false)
                    .withFirstName("OneOff")
                    .withSurname("Payment")
                    .build();

            CreateHostedCheckoutResponse response = hostedCheckoutClient
                    .createHostedCheckout(request);

            assertNotNull(response);
            assertNotNull(response.getHostedCheckoutId());
            assertNotNull(response.getRedirectUrl());
            assertFalse(response.getRedirectUrl().isEmpty());
        }
    }

    @Nested
    class WhenUsingTokenization {

        @Test
        void shouldCreateHostedCheckoutWithNewUnscheduledCardOnFile() {
            CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                    .withIsNewUnscheduledCardOnFileSeries(true)
                    .withFirstName("Card")
                    .withSurname("OnFile")
                    .build();

            CreateHostedCheckoutResponse response = hostedCheckoutClient
                    .createHostedCheckout(request);

            assertNotNull(response);
            assertNotNull(response.getHostedCheckoutId());
            assertNotNull(response.getRedirectUrl());
            assertFalse(response.getRedirectUrl().isEmpty());
        }

        @Test
        void shouldCreateHostedCheckoutWithoutTokenization() {
            CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                    .withIsNewUnscheduledCardOnFileSeries(false)
                    .withFirstName("No")
                    .withSurname("Token")
                    .build();

            CreateHostedCheckoutResponse response = hostedCheckoutClient
                    .createHostedCheckout(request);

            assertNotNull(response);
            assertNotNull(response.getHostedCheckoutId());
            assertNotNull(response.getRedirectUrl());
            assertFalse(response.getRedirectUrl().isEmpty());
        }
    }

    @Nested
    class WhenCreatingMultipleCheckouts {

        @Test
        void shouldCreateMultipleHostedCheckouts() {
            for (int i = 0; i < 3; i++) {
                CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                        .withFirstName("Batch")
                        .withSurname("Customer" + i)
                        .build();

                CreateHostedCheckoutResponse response = hostedCheckoutClient
                        .createHostedCheckout(request);

                assertNotNull(response);
                assertNotNull(response.getHostedCheckoutId());
                assertNotNull(response.getRedirectUrl());
                assertFalse(response.getRedirectUrl().isEmpty());
            }
        }

        @Test
        void shouldCreateCheckoutsWithDifferentAmounts() {
            long[] amounts = { 1000L, 2500L, 5000L, 10000L };

            for (long amount : amounts) {
                CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                        .withAmount(amount)
                        .withCurrency("EUR")
                        .withFirstName("Amount")
                        .withSurname("Test")
                        .build();

                CreateHostedCheckoutResponse response = hostedCheckoutClient
                        .createHostedCheckout(request);

                assertNotNull(response);
                assertNotNull(response.getHostedCheckoutId());
                assertNotNull(response.getRedirectUrl());
                assertFalse(response.getRedirectUrl().isEmpty());
            }
        }

        @Test
        void shouldCreateCheckoutsWithDifferentCurrencies() {
            String[] currencies = { "EUR", "GBP", "USD", "CHF", "SEK" };

            for (String currency : currencies) {
                CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequestBuilder()
                        .withAmount(2000L)
                        .withCurrency(currency)
                        .withFirstName("Currency")
                        .withSurname("Test")
                        .build();

                CreateHostedCheckoutResponse response = hostedCheckoutClient
                        .createHostedCheckout(request);

                assertNotNull(response);
                assertNotNull(response.getHostedCheckoutId());
                assertNotNull(response.getRedirectUrl());
                assertFalse(response.getRedirectUrl().isEmpty());
            }
        }
    }
}
