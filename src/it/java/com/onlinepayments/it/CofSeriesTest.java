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
import com.onlinepayments.domain.ImportCofSeriesRequest;
import com.onlinepayments.domain.ImportCofSeriesResponse;
import com.onlinepayments.it.util.SdkTestHelper;
import com.onlinepayments.it.util.cofSeries.ImportCofSeriesRequestBuilder;
import com.onlinepayments.merchant.cofseries.CofSeriesClientInterface;

public class CofSeriesTest extends ItTest {

    private ClientInterface client;
    private CofSeriesClientInterface cofSeriesClient;

    private SdkTestHelper sdkTestHelper;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        cofSeriesClient = client.merchant(getMerchantId()).cofSeries();

        sdkTestHelper = getSdkTestHelper(client);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenImportingCofSeries {

        @Nested
        class WithValidInput {

            @Disabled("Test is skipped because the Import COF Series feature is not enabled for the test merchant.")
            @Test
            void shouldReturnImportCofSeriesResponse() {
                ImportCofSeriesRequest request = new ImportCofSeriesRequestBuilder().build();

                ImportCofSeriesResponse response = cofSeriesClient.importCofSeries(request);

                assertNotNull(response);
                assertNotNull(response.getPaymentId());
            }

            @Disabled("Test is skipped because the Import COF Series feature is not enabled for the test merchant.")
            @Test
            void shouldReturnImportCofSeriesResponseWithCallContext() {
                ImportCofSeriesRequest request = new ImportCofSeriesRequestBuilder().build();
                CallContext context = new CallContext().withIdempotenceKey("test-cof-series-" + UUID.randomUUID());

                ImportCofSeriesResponse response = cofSeriesClient.importCofSeries(request, context);

                assertNotNull(response);
                assertNotNull(response.getPaymentId());
            }
        }

        @Nested
        class WithValidTokenId {

            @Disabled("Test is skipped because the Import COF Series feature is not enabled for the test merchant.")
            @Test
            void shouldReturnImportCofSeriesResponse() {
                String tokenId = sdkTestHelper.createTokenAndGetId();
                ImportCofSeriesRequest request = new ImportCofSeriesRequestBuilder()
                        .withTokenId(tokenId)
                        .build();

                ImportCofSeriesResponse response = cofSeriesClient.importCofSeries(request);

                assertNotNull(response);
                assertNotNull(response.getPaymentId());
            }
        }

        @Nested
        class WithInvalidInput {

            @Test
            void shouldThrowValidationException() {
                ImportCofSeriesRequest request = new ImportCofSeriesRequestBuilder()
                        .withSchemeReferenceData(null)
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> cofSeriesClient.importCofSeries(request));
            }
        }

        @Nested
        class WithTransactionLinkIdentifier {

            @Disabled("Test is skipped because the Import COF Series feature is not enabled for the test merchant.")
            @Test
            void shouldReturnImportCofSeriesResponseWithTransactionLinkIdentifier() {
                String paymentId = sdkTestHelper.createPaymentAndGetId();
                ImportCofSeriesRequest request = new ImportCofSeriesRequestBuilder()
                        .withTransactionLinkIdentifier(paymentId)
                        .build();

                ImportCofSeriesResponse response = cofSeriesClient.importCofSeries(request);

                assertNotNull(response);
                assertNotNull(response.getPaymentId());
            }
        }
    }
}
