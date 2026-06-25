package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.CallContext;
import com.onlinepayments.ClientInterface;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.CalculateSurchargeRequest;
import com.onlinepayments.domain.CalculateSurchargeResponse;
import com.onlinepayments.domain.CurrencyConversionRequest;
import com.onlinepayments.domain.CurrencyConversionResponse;
import com.onlinepayments.domain.GetIINDetailsRequest;
import com.onlinepayments.domain.GetIINDetailsResponse;
import com.onlinepayments.domain.TestConnection;
import com.onlinepayments.it.util.services.CalculateSurchargeRequestBuilder;
import com.onlinepayments.it.util.services.CurrencyConversionRequestBuilder;
import com.onlinepayments.it.util.services.GetIINDetailsRequestBuilder;
import com.onlinepayments.merchant.services.ServicesClientInterface;

public class ServicesTest extends ItTest {

    private static final String INVALID_BIN = "123";

    private ClientInterface client;
    private ServicesClientInterface servicesClient;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        servicesClient = client.merchant(getMerchantId()).services();
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenTestingConnection {

        @Nested
        class WithValidRequest {

            @Test
            void shouldReturnTestConnection() {
                TestConnection response = servicesClient.testConnection();

                assertNotNull(response);
                assertNotNull(response.getResult());
            }

            @Test
            void shouldReturnTestConnectionWithCallContext() {
                CallContext context = new CallContext().withIdempotenceKey("test-services-" + UUID.randomUUID());
                TestConnection response = servicesClient.testConnection(context);

                assertNotNull(response);
                assertNotNull(response.getResult());
            }
        }
    }

    @Nested
    class WhenGettingIINDetails {

        @Nested
        class WithValidCardNumber {

            @Test
            void shouldReturnIINDetails() {
                GetIINDetailsRequest request = new GetIINDetailsRequestBuilder()
                        .build();

                GetIINDetailsResponse response = servicesClient.getIINDetails(request);

                assertNotNull(response);
                assertNotNull(response.getCardType());
                assertNotNull(response.getPaymentProductId());
                assertNotNull(response.getCardScheme());
            }
        }

        @Nested
        class WithInvalidCardNumber {

            @Test
            void shouldThrowValidationException() {
                GetIINDetailsRequest request = new GetIINDetailsRequestBuilder()
                        .withBin(INVALID_BIN)
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> servicesClient.getIINDetails(request));
            }
        }
    }

    @Nested
    class WhenGettingDccRateInquiry {

        @Nested
        class WithValidRequest {

            @Test
            @Disabled("Test is skipped because the Currency Conversion feature is not enabled for the test merchant.")
            void shouldReturnCurrencyConversionResponse() {
                CurrencyConversionRequest request = new CurrencyConversionRequestBuilder()
                        .withCardNumber("4012000033330026")
                        .build();

                CurrencyConversionResponse response = servicesClient.getDccRateInquiry(request);

                assertNotNull(response);
                assertNotNull(response.getResult());
            }
        }

        @Nested
        class WithMissingCardSourceAndTransaction {

            @Test
            void shouldThrowValidationException() {
                CurrencyConversionRequest request = new CurrencyConversionRequestBuilder()
                        .withAmount(1000L)
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> servicesClient.getDccRateInquiry(request));
            }
        }

        @Nested
        class WithInvalidAmount {

            @Test
            void shouldThrowValidationException() {
                CurrencyConversionRequest request = new CurrencyConversionRequestBuilder()
                        .withAmount(-1000L)
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> servicesClient.getDccRateInquiry(request));
            }
        }
    }

    @Nested
    class WhenCalculatingSurcharge {

        @Nested
        class WithValidRequest {

            @Test
            @Disabled("Test is skipped because the Surcharge Calculation feature is not enabled for the test merchant.")
            void shouldReturnSurchargeCalculationResponse() {
                CalculateSurchargeRequest request = new CalculateSurchargeRequestBuilder()
                        .withCardNumber("5425233430109903")
                        .build();

                CalculateSurchargeResponse response = servicesClient.surchargeCalculation(request);

                assertNotNull(response);
                assertNotNull(response.getSurcharges());
            }
        }

        @Nested
        class WithMissingCardSource {

            @Test
            void shouldThrowValidationException() {
                CalculateSurchargeRequest request = new CalculateSurchargeRequestBuilder()
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> servicesClient.surchargeCalculation(request));
            }
        }

        @Nested
        class WithInvalidAmount {

            @Test
            void shouldThrowValidationException() {
                CalculateSurchargeRequest request = new CalculateSurchargeRequestBuilder()
                        .withAmount(-1000L)
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> servicesClient.surchargeCalculation(request));
            }
        }
    }
}
