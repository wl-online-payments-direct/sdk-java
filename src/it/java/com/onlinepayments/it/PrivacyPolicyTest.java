package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.CallContext;
import com.onlinepayments.ClientInterface;
import com.onlinepayments.domain.GetPrivacyPolicyResponse;
import com.onlinepayments.it.util.privacyPolicy.GetPrivacyPolicyParamsBuilder;
import com.onlinepayments.merchant.privacypolicy.GetPrivacyPolicyParams;
import com.onlinepayments.merchant.privacypolicy.PrivacyPolicyClientInterface;

public class PrivacyPolicyTest extends ItTest {

    private ClientInterface client;
    private PrivacyPolicyClientInterface privacyPolicyClient;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        privacyPolicyClient = client.merchant(getMerchantId()).privacyPolicy();
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenGettingPrivacyPolicy {

        @Nested
        class WithValidInput {

            @Test
            void shouldReturnGetPrivacyPolicyResponse() {
                GetPrivacyPolicyParams params = new GetPrivacyPolicyParamsBuilder().build();

                GetPrivacyPolicyResponse response = privacyPolicyClient.getPrivacyPolicy(params);

                assertNotNull(response);
                assertNotNull(response.getHtmlContent());
            }

            @Test
            void shouldReturnGetPrivacyPolicyResponseWithCallContext() {
                GetPrivacyPolicyParams params = new GetPrivacyPolicyParamsBuilder().build();
                CallContext context = new CallContext().withIdempotenceKey("test-privacy-policy-" + UUID.randomUUID());

                GetPrivacyPolicyResponse response = privacyPolicyClient.getPrivacyPolicy(params, context);

                assertNotNull(response);
                assertNotNull(response.getHtmlContent());
            }

            @Test
            void shouldReturnPrivacyPolicyForSpecificPaymentProduct() {
                GetPrivacyPolicyParams params = new GetPrivacyPolicyParamsBuilder()
                        .withVisaProduct()
                        .build();

                GetPrivacyPolicyResponse response = privacyPolicyClient.getPrivacyPolicy(params);

                assertNotNull(response);
                assertNotNull(response.getHtmlContent());
                assertEquals(1, params.getPaymentProductId());
            }
        }

        @Nested
        class WithDifferentLocales {

            @Test
            void shouldReturnPrivacyPolicyForEnglishLocale() {
                GetPrivacyPolicyParams params = new GetPrivacyPolicyParamsBuilder()
                        .withEnglishLocale()
                        .build();

                GetPrivacyPolicyResponse response = privacyPolicyClient.getPrivacyPolicy(params);

                assertNotNull(response);
                assertNotNull(response.getHtmlContent());
                assertEquals("en_US", params.getLocale());
            }

            @Test
            void shouldReturnPrivacyPolicyForDutchLocale() {
                GetPrivacyPolicyParams params = new GetPrivacyPolicyParamsBuilder()
                        .withDutchLocale()
                        .build();

                GetPrivacyPolicyResponse response = privacyPolicyClient.getPrivacyPolicy(params);

                assertNotNull(response);
                assertNotNull(response.getHtmlContent());
                assertEquals("nl_NL", params.getLocale());
            }

            @Test
            void shouldReturnPrivacyPolicyForFrenchLocale() {
                GetPrivacyPolicyParams params = new GetPrivacyPolicyParamsBuilder()
                        .withFrenchLocale()
                        .build();

                GetPrivacyPolicyResponse response = privacyPolicyClient.getPrivacyPolicy(params);

                assertNotNull(response);
                assertNotNull(response.getHtmlContent());
                assertEquals("fr_FR", params.getLocale());
            }

            @Test
            void shouldReturnPrivacyPolicyForGermanLocale() {
                GetPrivacyPolicyParams params = new GetPrivacyPolicyParamsBuilder()
                        .withGermanLocale()
                        .build();

                GetPrivacyPolicyResponse response = privacyPolicyClient.getPrivacyPolicy(params);

                assertNotNull(response);
                assertNotNull(response.getHtmlContent());
                assertEquals("de_DE", params.getLocale());
            }
        }

        @Nested
        class WithDifferentPaymentProducts {

            @Test
            void shouldReturnPrivacyPolicyForVisa() {
                GetPrivacyPolicyParams params = new GetPrivacyPolicyParamsBuilder()
                        .withVisaProduct()
                        .build();

                GetPrivacyPolicyResponse response = privacyPolicyClient.getPrivacyPolicy(params);

                assertNotNull(response);
                assertNotNull(response.getHtmlContent());
                assertEquals(1, params.getPaymentProductId());
            }

            @Test
            void shouldReturnPrivacyPolicyForAmericanExpress() {
                GetPrivacyPolicyParams params = new GetPrivacyPolicyParamsBuilder()
                        .withAmericanExpressProduct()
                        .build();

                GetPrivacyPolicyResponse response = privacyPolicyClient.getPrivacyPolicy(params);

                assertNotNull(response);
                assertNotNull(response.getHtmlContent());
                assertEquals(2, params.getPaymentProductId());
            }

            @Test
            void shouldReturnPrivacyPolicyForMasterCard() {
                GetPrivacyPolicyParams params = new GetPrivacyPolicyParamsBuilder()
                        .withMasterCardProduct()
                        .build();

                GetPrivacyPolicyResponse response = privacyPolicyClient.getPrivacyPolicy(params);

                assertNotNull(response);
                assertNotNull(response.getHtmlContent());
                assertEquals(3, params.getPaymentProductId());
            }
        }

        @Nested
        class WithCombinedParameters {

            @Test
            void shouldReturnPrivacyPolicyForSpecificProductAndLocale() {
                GetPrivacyPolicyParams params = new GetPrivacyPolicyParamsBuilder()
                        .withVisaProduct()
                        .withFrenchLocale()
                        .build();

                GetPrivacyPolicyResponse response = privacyPolicyClient.getPrivacyPolicy(params);

                assertNotNull(response);
                assertNotNull(response.getHtmlContent());
                assertEquals(1, params.getPaymentProductId());
                assertEquals("fr_FR", params.getLocale());
            }

            @Test
            void shouldReturnPrivacyPolicyForAmexInGerman() {
                GetPrivacyPolicyParams params = new GetPrivacyPolicyParamsBuilder()
                        .withAmericanExpressProduct()
                        .withGermanLocale()
                        .build();

                GetPrivacyPolicyResponse response = privacyPolicyClient.getPrivacyPolicy(params);

                assertNotNull(response);
                assertNotNull(response.getHtmlContent());
                assertEquals(2, params.getPaymentProductId());
                assertEquals("de_DE", params.getLocale());
            }
        }
    }
}
