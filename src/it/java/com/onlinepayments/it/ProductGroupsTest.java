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
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.CallContext;
import com.onlinepayments.ClientInterface;
import com.onlinepayments.ReferenceException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.GetPaymentProductGroupsResponse;
import com.onlinepayments.domain.PaymentProductGroup;
import com.onlinepayments.it.util.productGroups.GetProductGroupParamsBuilder;
import com.onlinepayments.it.util.productGroups.GetProductGroupsParamsBuilder;
import com.onlinepayments.merchant.productgroups.GetProductGroupParams;
import com.onlinepayments.merchant.productgroups.GetProductGroupsParams;
import com.onlinepayments.merchant.productgroups.ProductGroupsClientInterface;

public class ProductGroupsTest extends ItTest {

    private static final String COUNTRY_CODE = "NL";
    private static final String CURRENCY_CODE = "EUR";
    private static final String VALID_PAYMENT_PRODUCT_GROUP_ID = "cards";
    private static final String INVALID_PAYMENT_PRODUCT_GROUP_ID = "invalid-group-id";

    private ClientInterface client;
    private ProductGroupsClientInterface productGroupsClient;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        productGroupsClient = client.merchant(getMerchantId()).productGroups();
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenGettingProductGroups {

        @Nested
        class WithValidRequest {

            @Test
            void shouldReturnProductGroups() {
                GetProductGroupsParams params = new GetProductGroupsParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .build();

                GetPaymentProductGroupsResponse response = productGroupsClient.getProductGroups(params);

                assertNotNull(response);
                assertNotNull(response.getPaymentProductGroups());
                assertFalse(response.getPaymentProductGroups().isEmpty());
                assertNotNull(response.getPaymentProductGroups().get(0));
            }

            @Test
            void shouldReturnProductGroupsWithCallContext() {
                GetProductGroupsParams params = new GetProductGroupsParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .build();

                CallContext context = new CallContext().withIdempotenceKey("test-product-groups-" + UUID.randomUUID());

                GetPaymentProductGroupsResponse response = productGroupsClient.getProductGroups(params, context);

                assertNotNull(response);
                assertNotNull(response.getPaymentProductGroups());
                assertFalse(response.getPaymentProductGroups().isEmpty());
                assertNotNull(response.getPaymentProductGroups().get(0));
            }
        }

        @Nested
        class WithOptionalParameters {

            @Test
            void shouldReturnProductGroupsWithAmount() {
                GetProductGroupsParams params = new GetProductGroupsParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withAmount(1000L)
                        .build();

                GetPaymentProductGroupsResponse response = productGroupsClient.getProductGroups(params);

                assertNotNull(response);
                assertNotNull(response.getPaymentProductGroups());
            }

            @Test
            void shouldReturnProductGroupsWithIsRecurring() {
                GetProductGroupsParams params = new GetProductGroupsParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withIsRecurring(true)
                        .build();

                GetPaymentProductGroupsResponse response = productGroupsClient.getProductGroups(params);

                assertNotNull(response);
                assertNotNull(response.getPaymentProductGroups());
            }

            @Test
            void shouldReturnProductGroupsWithAddHide() {
                List<String> addHideList = new ArrayList<>();
                addHideList.add("fields");
                addHideList.add("accountsOnFile");

                GetProductGroupsParams params = new GetProductGroupsParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withAddHideList(addHideList)
                        .build();

                GetPaymentProductGroupsResponse response = productGroupsClient.getProductGroups(params);

                assertNotNull(response);
                assertNotNull(response.getPaymentProductGroups());
                assertNotNull(params.getHide());
                assertEquals(2, params.getHide().size());
                assertTrue(params.getHide().contains("fields"));
                assertTrue(params.getHide().contains("accountsOnFile"));
            }

            @Test
            void shouldReturnProductGroupsWithHideList() {
                List<String> hideFields = new ArrayList<>();
                hideFields.add("fields");
                hideFields.add("translations");

                GetProductGroupsParams params = new GetProductGroupsParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withHideList(hideFields)
                        .build();

                GetPaymentProductGroupsResponse response = productGroupsClient.getProductGroups(params);

                assertNotNull(response);
                assertNotNull(response.getPaymentProductGroups());
                assertEquals(hideFields, params.getHide());
            }

            @Test
            void shouldSkipNullHideElementInGetProductGroupsParams() {
                List<String> addHideList = new ArrayList<>();
                addHideList.add("fields");
                addHideList.add(null);

                GetProductGroupsParams params = new GetProductGroupsParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withAddHideList(addHideList)
                        .build();

                GetPaymentProductGroupsResponse response = productGroupsClient.getProductGroups(params);

                assertNotNull(response);
                assertNotNull(response.getPaymentProductGroups());
                assertEquals(2, params.getHide().size());
                assertTrue(params.getHide().contains(null));
            }

            @Test
            void shouldVerifyGetProductGroupsParamsGetters() {
                GetProductGroupsParams params = new GetProductGroupsParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withAmount(1000L)
                        .withIsRecurring(true)
                        .build();

                assertEquals(COUNTRY_CODE, params.getCountryCode());
                assertEquals(CURRENCY_CODE, params.getCurrencyCode());
                assertEquals(1000L, params.getAmount());
                assertTrue(params.getIsRecurring());
            }
        }

        @Nested
        class WithMissingCountryCode {

            @Test
            void shouldThrowValidationException() {
                GetProductGroupsParams params = new GetProductGroupsParamsBuilder()
                        .withCurrencyCode(CURRENCY_CODE)
                        .build();

                ValidationException exception = assertThrows(
                        ValidationException.class,
                        () -> productGroupsClient.getProductGroups(params));

                assertEquals(400, exception.getStatusCode());
            }
        }
    }

    @Nested
    class WhenGettingProductGroup {

        @Nested
        class WithValidPaymentProductGroupId {

            @Test
            void shouldReturnProductGroup() {
                GetProductGroupParams params = new GetProductGroupParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .build();

                PaymentProductGroup response = productGroupsClient.getProductGroup(VALID_PAYMENT_PRODUCT_GROUP_ID, params);

                assertNotNull(response);
                assertNotNull(response.getId());
                assertEquals(VALID_PAYMENT_PRODUCT_GROUP_ID, response.getId().toLowerCase());
            }

            @Test
            void shouldReturnProductGroupWithAmount() {
                GetProductGroupParams params = new GetProductGroupParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withAmount(2500L)
                        .build();

                PaymentProductGroup response = productGroupsClient.getProductGroup(VALID_PAYMENT_PRODUCT_GROUP_ID, params);

                assertNotNull(response);
                assertNotNull(response.getId());
                assertEquals(VALID_PAYMENT_PRODUCT_GROUP_ID, response.getId().toLowerCase());
            }

            @Test
            void shouldReturnProductGroupWithIsRecurring() {
                GetProductGroupParams params = new GetProductGroupParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withIsRecurring(true)
                        .build();

                PaymentProductGroup response = productGroupsClient.getProductGroup(VALID_PAYMENT_PRODUCT_GROUP_ID, params);

                assertNotNull(response);
                assertNotNull(response.getId());
                assertEquals(VALID_PAYMENT_PRODUCT_GROUP_ID, response.getId().toLowerCase());
            }

            @Test
            void shouldReturnProductGroupWithAddHide() {
                List<String> addHideList = new ArrayList<>();
                addHideList.add("accountsOnFile");

                GetProductGroupParams params = new GetProductGroupParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withAddHideList(addHideList)
                        .build();

                PaymentProductGroup response = productGroupsClient.getProductGroup(VALID_PAYMENT_PRODUCT_GROUP_ID, params);

                assertNotNull(response);
                assertNotNull(response.getId());
                assertEquals(VALID_PAYMENT_PRODUCT_GROUP_ID, response.getId().toLowerCase());
                assertNotNull(params.getHide());
                assertEquals(1, params.getHide().size());
                assertTrue(params.getHide().contains("accountsOnFile"));
            }

            @Test
            void shouldReturnProductGroupWithHideList() {
                List<String> hideFields = new ArrayList<>();
                hideFields.add("fields");

                GetProductGroupParams params = new GetProductGroupParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withHideList(hideFields)
                        .build();

                PaymentProductGroup response = productGroupsClient.getProductGroup(VALID_PAYMENT_PRODUCT_GROUP_ID, params);

                assertNotNull(response);
                assertNotNull(response.getId());
                assertEquals(VALID_PAYMENT_PRODUCT_GROUP_ID, response.getId().toLowerCase());
                assertEquals(hideFields, params.getHide());
            }

            @Test
            void shouldSkipNullHideElementInGetProductGroupParams() {
                List<String> addHideList = new ArrayList<>();
                addHideList.add("accountsOnFile");
                addHideList.add(null);

                GetProductGroupParams params = new GetProductGroupParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withAddHideList(addHideList)
                        .build();

                PaymentProductGroup response = productGroupsClient.getProductGroup(VALID_PAYMENT_PRODUCT_GROUP_ID, params);

                assertNotNull(response);
                assertNotNull(response.getId());
                assertEquals(VALID_PAYMENT_PRODUCT_GROUP_ID, response.getId().toLowerCase());
                assertEquals(2, params.getHide().size());
                assertTrue(params.getHide().contains(null));
            }

            @Test
            void shouldVerifyGetProductGroupParamsGetters() {
                GetProductGroupParams params = new GetProductGroupParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .withAmount(2500L)
                        .withIsRecurring(false)
                        .build();

                assertEquals(COUNTRY_CODE, params.getCountryCode());
                assertEquals(CURRENCY_CODE, params.getCurrencyCode());
                assertEquals(2500L, params.getAmount());
                assertFalse(params.getIsRecurring());
            }
        }

        @Nested
        class WithInvalidPaymentProductGroupId {

            @Test
            void shouldThrowReferenceException() {
                GetProductGroupParams params = new GetProductGroupParamsBuilder()
                        .withCountryCode(COUNTRY_CODE)
                        .withCurrencyCode(CURRENCY_CODE)
                        .build();

                ReferenceException exception = assertThrows(
                        ReferenceException.class,
                        () -> productGroupsClient.getProductGroup(INVALID_PAYMENT_PRODUCT_GROUP_ID, params));

                assertEquals(404, exception.getStatusCode());
            }
        }
    }
}
