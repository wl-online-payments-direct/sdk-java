package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.CallContext;
import com.onlinepayments.ClientInterface;
import com.onlinepayments.ReferenceException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.GetPaymentProductsResponse;
import com.onlinepayments.domain.PaymentProduct;
import com.onlinepayments.domain.PaymentProductNetworksResponse;
import com.onlinepayments.domain.PaymentProductSessionRequest;
import com.onlinepayments.domain.ProductDirectory;
import com.onlinepayments.it.util.products.GetPaymentProductNetworksParamsBuilder;
import com.onlinepayments.it.util.products.GetPaymentProductParamsBuilder;
import com.onlinepayments.it.util.products.GetPaymentProductsParamsBuilder;
import com.onlinepayments.it.util.products.GetProductDirectoryParamsBuilder;
import com.onlinepayments.it.util.products.PaymentProductSessionRequestBuilder;
import com.onlinepayments.merchant.products.GetPaymentProductNetworksParams;
import com.onlinepayments.merchant.products.GetPaymentProductParams;
import com.onlinepayments.merchant.products.GetPaymentProductsParams;
import com.onlinepayments.merchant.products.GetProductDirectoryParams;
import com.onlinepayments.merchant.products.ProductsClientInterface;

public class ProductsTest extends ItTest {

    private static final String COUNTRY_CODE = "NL";
    private static final String CURRENCY_CODE = "EUR";
    private static final int VALID_PAYMENT_PRODUCT_ID = 1;
    private static final int VALID_PAYMENT_PRODUCT_NETWORKS_ID = 302;
    private static final int VALID_PAYMENT_PRODUCT_DIRECTORY_ID = 809;
    private static final int INVALID_PAYMENT_PRODUCT_ID = -1;

    private ClientInterface client;
    private ProductsClientInterface productsClient;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        productsClient = client.merchant(getMerchantId()).products();
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenGettingPaymentProducts {

        @Nested
        class WithValidRequest {

            @Test
            void shouldReturnPaymentProducts() {
                GetPaymentProductsParams params = new GetPaymentProductsParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .build();

                GetPaymentProductsResponse response = productsClient.getPaymentProducts(params);

                assertNotNull(response);
                assertNotNull(response.getPaymentProducts());
                assertFalse(response.getPaymentProducts().isEmpty());
                assertNotNull(response.getPaymentProducts().get(0));
                assertTrue(response.getPaymentProducts().get(0).getId() > 0);
            }

            @Test
            void shouldReturnPaymentProductsWithCallContext() {
                GetPaymentProductsParams params = new GetPaymentProductsParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .build();

                CallContext context = new CallContext().withIdempotenceKey("test-products-" + UUID.randomUUID());

                GetPaymentProductsResponse response = productsClient.getPaymentProducts(params, context);

                assertNotNull(response);
                assertNotNull(response.getPaymentProducts());
                assertFalse(response.getPaymentProducts().isEmpty());
                assertNotNull(response.getPaymentProducts().get(0));
                assertTrue(response.getPaymentProducts().get(0).getId() > 0);
            }
        }

        @Nested
        class WithOptionalParameters {

            @Test
            void shouldReturnPaymentProductsWithLocale() {
                GetPaymentProductsParams params = new GetPaymentProductsParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withLocale("en_US")
                        .build();

                GetPaymentProductsResponse response = productsClient.getPaymentProducts(params);

                assertNotNull(response);
                assertNotNull(response.getPaymentProducts());
                assertFalse(response.getPaymentProducts().isEmpty());
                assertNotNull(response.getPaymentProducts().get(0));
                assertTrue(response.getPaymentProducts().get(0).getId() > 0);
            }

            @Test
            void shouldReturnPaymentProductsWithAmount() {
                GetPaymentProductsParams params = new GetPaymentProductsParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withAmount(1000L)
                        .build();

                GetPaymentProductsResponse response = productsClient.getPaymentProducts(params);

                assertNotNull(response);
                assertNotNull(response.getPaymentProducts());
                assertFalse(response.getPaymentProducts().isEmpty());
                assertNotNull(response.getPaymentProducts().get(0));
                assertTrue(response.getPaymentProducts().get(0).getId() > 0);
            }

            @Test
            void shouldReturnPaymentProductsWithIsRecurring() {
                GetPaymentProductsParams params = new GetPaymentProductsParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withIsRecurring(true)
                        .build();

                GetPaymentProductsResponse response = productsClient.getPaymentProducts(params);

                assertNotNull(response);
                assertNotNull(response.getPaymentProducts());
                assertFalse(response.getPaymentProducts().isEmpty());
                assertNotNull(response.getPaymentProducts().get(0));
                assertTrue(response.getPaymentProducts().get(0).getId() > 0);
            }

            @Test
            void shouldReturnPaymentProductsWithAddHide() {
                List<String> addHideList = new ArrayList<>();
                addHideList.add("fields");
                addHideList.add("accountsOnFile");

                GetPaymentProductsParams params = new GetPaymentProductsParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withAddHideList(addHideList)
                        .build();

                GetPaymentProductsResponse response = productsClient.getPaymentProducts(params);

                assertNotNull(response);
                assertNotNull(response.getPaymentProducts());
                assertNotNull(params.getHide());
                assertEquals(2, params.getHide().size());
                assertTrue(params.getHide().contains("fields"));
                assertTrue(params.getHide().contains("accountsOnFile"));
            }

            @Test
            void shouldReturnPaymentProductsWithHideList() {
                List<String> hideFields = new ArrayList<>();
                hideFields.add("fields");
                hideFields.add("translations");

                GetPaymentProductsParams params = new GetPaymentProductsParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withHideList(hideFields)
                        .build();

                GetPaymentProductsResponse response = productsClient.getPaymentProducts(params);

                assertNotNull(response);
                assertNotNull(response.getPaymentProducts());
                assertEquals(hideFields, params.getHide());
            }

            @Test
            void shouldVerifyGetPaymentProductsParamsGetters() {
                GetPaymentProductsParams params = new GetPaymentProductsParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withLocale("en_US")
                        .withAmount(1000L)
                        .withIsRecurring(true)
                        .build();

                assertEquals(COUNTRY_CODE, params.getCountryCode());
                assertEquals(CURRENCY_CODE, params.getCurrencyCode());
                assertEquals("en_US", params.getLocale());
                assertEquals(1000L, params.getAmount());
                assertTrue(params.getIsRecurring());
            }

            @Test
            void shouldReturnPaymentProductsWithOperationType() {
                GetPaymentProductsParams params = new GetPaymentProductsParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withOperationType("Authorization")
                        .build();

                GetPaymentProductsResponse response = productsClient.getPaymentProducts(params);

                assertNotNull(response);
                assertNotNull(response.getPaymentProducts());
                assertFalse(response.getPaymentProducts().isEmpty());
                assertEquals("Authorization", params.getOperationType());
            }
        }

        @Nested
        class WithMissingCountryCode {

            @Test
            void shouldThrowValidationException() {
                GetPaymentProductsParams params = new GetPaymentProductsParamsBuilder()
                        .withCurrencyCode(CURRENCY_CODE)
                        .build();

                ValidationException exception = assertThrows(
                        ValidationException.class,
                        () -> productsClient.getPaymentProducts(params));

                assertEquals(400, exception.getStatusCode());
            }
        }
    }

    @Nested
    class WhenGettingPaymentProduct {

        @Nested
        class WithValidPaymentProductId {

            @Test
            void shouldReturnPaymentProduct() {
                GetPaymentProductParams params = new GetPaymentProductParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .build();

                PaymentProduct response = productsClient.getPaymentProduct(VALID_PAYMENT_PRODUCT_ID, params);

                assertNotNull(response);
                assertEquals(VALID_PAYMENT_PRODUCT_ID, response.getId());
            }

            @Test
            void shouldReturnPaymentProductWithLocale() {
                GetPaymentProductParams params = new GetPaymentProductParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withLocale("nl_NL")
                        .build();

                PaymentProduct response = productsClient.getPaymentProduct(VALID_PAYMENT_PRODUCT_ID, params);

                assertNotNull(response);
                assertEquals(VALID_PAYMENT_PRODUCT_ID, response.getId());
            }

            @Test
            void shouldReturnPaymentProductWithAmount() {
                GetPaymentProductParams params = new GetPaymentProductParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withAmount(2500L)
                        .build();

                PaymentProduct response = productsClient.getPaymentProduct(VALID_PAYMENT_PRODUCT_ID, params);

                assertNotNull(response);
                assertEquals(VALID_PAYMENT_PRODUCT_ID, response.getId());
            }

            @Test
            void shouldReturnPaymentProductWithIsRecurring() {
                GetPaymentProductParams params = new GetPaymentProductParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withIsRecurring(false)
                        .build();

                PaymentProduct response = productsClient.getPaymentProduct(VALID_PAYMENT_PRODUCT_ID, params);

                assertNotNull(response);
                assertEquals(VALID_PAYMENT_PRODUCT_ID, response.getId());
            }

            @Test
            void shouldReturnPaymentProductWithAddHide() {
                List<String> addHideList = new ArrayList<>();
                addHideList.add("accountsOnFile");

                GetPaymentProductParams params = new GetPaymentProductParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withAddHideList(addHideList)
                        .build();

                PaymentProduct response = productsClient.getPaymentProduct(VALID_PAYMENT_PRODUCT_ID, params);

                assertNotNull(response);
                assertEquals(VALID_PAYMENT_PRODUCT_ID, response.getId());
                assertNotNull(params.getHide());
                assertEquals(1, params.getHide().size());
                assertTrue(params.getHide().contains("accountsOnFile"));
            }

            @Test
            void shouldReturnPaymentProductWithHideList() {
                List<String> hideFields = new ArrayList<>();
                hideFields.add("fields");

                GetPaymentProductParams params = new GetPaymentProductParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withHideList(hideFields)
                        .build();

                PaymentProduct response = productsClient.getPaymentProduct(VALID_PAYMENT_PRODUCT_ID, params);

                assertNotNull(response);
                assertEquals(VALID_PAYMENT_PRODUCT_ID, response.getId());
                assertEquals(hideFields, params.getHide());
            }

            @Test
            void shouldVerifyGetPaymentProductParamsGetters() {
                GetPaymentProductParams params = new GetPaymentProductParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withLocale("nl_NL")
                        .withAmount(2500L)
                        .withIsRecurring(false)
                        .build();

                assertEquals(COUNTRY_CODE, params.getCountryCode());
                assertEquals(CURRENCY_CODE, params.getCurrencyCode());
                assertEquals("nl_NL", params.getLocale());
                assertEquals(2500L, params.getAmount());
                assertFalse(params.getIsRecurring());
            }

            @Test
            void shouldReturnPaymentProductWithOperationType() {
                GetPaymentProductParams params = new GetPaymentProductParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withOperationType("Authorization")
                        .build();

                PaymentProduct response = productsClient.getPaymentProduct(VALID_PAYMENT_PRODUCT_ID, params);

                assertNotNull(response);
                assertEquals(VALID_PAYMENT_PRODUCT_ID, response.getId());
                assertEquals("Authorization", params.getOperationType());
            }
        }

        @Nested
        class WithInvalidPaymentProductId {

            @Test
            void shouldThrowReferenceException() {
                GetPaymentProductParams params = new GetPaymentProductParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .build();

                ReferenceException exception = assertThrows(
                        ReferenceException.class,
                        () -> productsClient.getPaymentProduct(INVALID_PAYMENT_PRODUCT_ID, params));

                assertEquals(404, exception.getStatusCode());
            }
        }
    }

    @Nested
    class WhenGettingPaymentProductNetworks {

        @Nested
        class WithValidPaymentProductId {

            @Test
            void shouldReturnPaymentProductNetworks() {
                GetPaymentProductNetworksParams params = new GetPaymentProductNetworksParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .builder();

                PaymentProductNetworksResponse response = productsClient
                        .getPaymentProductNetworks(VALID_PAYMENT_PRODUCT_NETWORKS_ID, params);

                assertNotNull(response);
                assertNotNull(response.getNetworks());
                assertFalse(response.getNetworks().isEmpty());
                assertNotNull(response.getNetworks().get(0));
            }

            @Test
            void shouldReturnPaymentProductNetworksWithAmount() {
                GetPaymentProductNetworksParams params = new GetPaymentProductNetworksParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withAmount(3000L)
                        .builder();

                PaymentProductNetworksResponse response = productsClient
                        .getPaymentProductNetworks(VALID_PAYMENT_PRODUCT_NETWORKS_ID, params);

                assertNotNull(response);
                assertNotNull(response.getNetworks());
            }

            @Test
            void shouldReturnPaymentProductNetworksWithIsRecurring() {
                GetPaymentProductNetworksParams params = new GetPaymentProductNetworksParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withIsRecurring(true)
                        .builder();

                PaymentProductNetworksResponse response = productsClient
                        .getPaymentProductNetworks(VALID_PAYMENT_PRODUCT_NETWORKS_ID, params);

                assertNotNull(response);
                assertNotNull(response.getNetworks());
            }

            @Test
            void shouldVerifyGetPaymentProductNetworksParamsGetters() {
                GetPaymentProductNetworksParams params = new GetPaymentProductNetworksParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withAmount(3000L)
                        .withIsRecurring(true)
                        .builder();

                assertEquals(COUNTRY_CODE, params.getCountryCode());
                assertEquals(CURRENCY_CODE, params.getCurrencyCode());
                assertEquals(3000L, params.getAmount());
                assertTrue(params.getIsRecurring());
            }
        }

        @Nested
        class WithInvalidPaymentProductId {

            @Test
            void shouldThrowReferenceException() {
                GetPaymentProductNetworksParams params = new GetPaymentProductNetworksParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .builder();

                ReferenceException exception = assertThrows(
                        ReferenceException.class,
                        () -> productsClient.getPaymentProductNetworks(INVALID_PAYMENT_PRODUCT_ID, params));

                assertEquals(404, exception.getStatusCode());
            }
        }
    }

    @Nested
    class WhenGettingProductDirectory {

        @Nested
        class WithValidPaymentProductId {

            @Disabled("Test is skipped because no payment method supports directory fot the test merchant.")
            @Test
            void shouldReturnProductDirectory() {
                GetProductDirectoryParams params = new GetProductDirectoryParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .build();

                ProductDirectory response = productsClient.getProductDirectory(VALID_PAYMENT_PRODUCT_DIRECTORY_ID, params);

                assertNotNull(response);
                assertNotNull(response.getEntries());
                assertFalse(response.getEntries().isEmpty());
                assertNotNull(response.getEntries().get(0));
            }
        }

        @Nested
        class WithInvalidPaymentProductId {

            @Test
            void shouldThrowReferenceException() {
                GetProductDirectoryParams params = new GetProductDirectoryParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .build();

                ReferenceException exception = assertThrows(
                        ReferenceException.class,
                        () -> productsClient.getProductDirectory(INVALID_PAYMENT_PRODUCT_ID, params));

                assertEquals(404, exception.getStatusCode());
            }
        }

        @Nested
        class WithParameterValidation {

            @Test
            void shouldVerifyGetProductDirectoryParamsGetters() {
                GetProductDirectoryParams params = new GetProductDirectoryParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .build();

                assertEquals(COUNTRY_CODE, params.getCountryCode());
                assertEquals(CURRENCY_CODE, params.getCurrencyCode());
            }
        }
    }

    @Nested
    class WhenCreatingPaymentProductSession {

        @Nested
        class WithInvalidPaymentProductId {

            @Test
            void shouldThrowValidationException() {
                PaymentProductSessionRequest request = new PaymentProductSessionRequestBuilder().build();

                ValidationException exception = assertThrows(
                        ValidationException.class,
                        () -> productsClient.createPaymentProductSession(INVALID_PAYMENT_PRODUCT_ID, request));

                assertEquals(400, exception.getStatusCode());
            }
        }
    }
}
