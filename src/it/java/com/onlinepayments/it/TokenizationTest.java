package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
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
import com.onlinepayments.domain.CreateCertificateResponse;
import com.onlinepayments.domain.CreatePaymentRequest;
import com.onlinepayments.domain.CreatePaymentResponse;
import com.onlinepayments.domain.CsrRequest;
import com.onlinepayments.domain.DetokenizationResponse;
import com.onlinepayments.it.util.SdkTestHelper;
import com.onlinepayments.it.util.common.CreatePaymentRequestBuilder;
import com.onlinepayments.it.util.tokenization.CsrRequestBuilder;
import com.onlinepayments.it.util.tokenization.GetCardDataByPaymentsParamsBuilder;
import com.onlinepayments.it.util.tokenization.GetCardDataByTokensParamsBuilder;
import com.onlinepayments.merchant.payments.PaymentsClientInterface;
import com.onlinepayments.merchant.tokenization.GetCardDataByPaymentsParams;
import com.onlinepayments.merchant.tokenization.GetCardDataByTokensParams;
import com.onlinepayments.merchant.tokenization.TokenizationClientInterface;

public class TokenizationTest extends ItTest {

    private ClientInterface client;
    private PaymentsClientInterface paymentsClient;
    private TokenizationClientInterface tokenizationClient;

    private SdkTestHelper sdkTestHelper;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        paymentsClient = client.merchant(getMerchantId()).payments();
        tokenizationClient = client.merchant(getMerchantId()).tokenization();

        sdkTestHelper = getSdkTestHelper(client);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenCreatingCertificate {

        @Nested
        class WithValidInput {

            @Disabled("Test is skipped because the Tokenization endpoint features are not enabled for the test merchant.")
            @Test
            void shouldReturnCertificateResponse() {
                CsrRequest request = new CsrRequestBuilder().build();

                CreateCertificateResponse response = tokenizationClient.createCertificate(request);

                assertNotNull(response);
                assertNotNull(response.getSignedCertificate());
                assertNotNull(response.getCertificateId());
            }

            @Disabled("Test is skipped because the Tokenization endpoint features are not enabled for the test merchant.")
            @Test
            void shouldReturnCertificateResponseWithCallContext() {
                CsrRequest request = new CsrRequestBuilder().build();
                CallContext context = new CallContext().withIdempotenceKey("test-tokenization-" + UUID.randomUUID());

                CreateCertificateResponse response = tokenizationClient.createCertificate(request, context);

                assertNotNull(response);
                assertNotNull(response.getSignedCertificate());
                assertNotNull(response.getCertificateId());
            }
        }

        @Nested
        class WithInvalidInput {

            @Test
            void shouldThrowValidationException() {
                CsrRequest request = new CsrRequestBuilder()
                        .withCsr(null)
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> tokenizationClient.createCertificate(request));
            }
        }
    }

    @Nested
    class WhenGettingCardDataByTokens {

        @Nested
        class WithValidTokens {

            @Disabled("Test is skipped because the Tokenization endpoint features are not enabled for the test merchant.")
            @Test
            void shouldReturnDetokenizedCardData() {
                String tokenId = sdkTestHelper.createValidTokenAndGetId();

                GetCardDataByTokensParams params = new GetCardDataByTokensParamsBuilder()
                        .withTokens(Collections.singletonList(tokenId))
                        .build();

                DetokenizationResponse response = tokenizationClient.getCardDataByTokens(params);

                assertNotNull(response);
                assertNotNull(response.getTokens());
            }
        }

        @Nested
        class WithNonExistentTokens {

            @Disabled("Test is skipped because the Tokenization endpoint features are not enabled for the test merchant.")
            @Test
            void shouldThrowReferenceException() {
                GetCardDataByTokensParams params = new GetCardDataByTokensParamsBuilder()
                        .withTokens(Collections.singletonList("non-existent-token-xyz"))
                        .build();

                assertThrows(
                        ReferenceException.class,
                        () -> tokenizationClient.getCardDataByTokens(params));
            }
        }

        @Nested
        class WithInvalidTokens {

            @Test
            void shouldThrowValidationException() {
                GetCardDataByTokensParams params = new GetCardDataByTokensParamsBuilder()
                        .withTokens(null)
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> tokenizationClient.getCardDataByTokens(params));
            }
        }
    }

    @Nested
    class WhenGettingCardDataByPayments {

        @Nested
        class WithValidPaymentIds {

            @Disabled("Test is skipped because the Tokenization endpoint features are not enabled for the test merchant.")
            @Test
            void shouldReturnDetokenizedCardData() {
                String tokenId = sdkTestHelper.createTokenAndGetId();

                CreatePaymentRequest paymentRequest = new CreatePaymentRequestBuilder().withToken(tokenId).build();

                CreatePaymentResponse paymentResponse = paymentsClient.createPayment(paymentRequest);

                GetCardDataByPaymentsParams params = new GetCardDataByPaymentsParamsBuilder()
                        .withPayments(Collections.singletonList(paymentResponse.getPayment().getId()))
                        .build();

                DetokenizationResponse response = tokenizationClient.getCardDataByPayments(params);

                assertNotNull(response);
                assertNotNull(response.getTokens());
            }
        }

        @Nested
        class WithNonExistentPaymentIds {

            @Disabled("Test is skipped because the Tokenization endpoint features are not enabled for the test merchant.")
            @Test
            void shouldThrowReferenceException() {
                GetCardDataByPaymentsParams params = new GetCardDataByPaymentsParamsBuilder()
                        .withPayments(Collections.singletonList("non-existent-payment"))
                        .build();

                assertThrows(
                        ReferenceException.class,
                        () -> tokenizationClient.getCardDataByPayments(params));
            }
        }

        @Nested
        class WithInvalidPaymentIds {

            @Test
            void shouldThrowValidationException() {
                GetCardDataByPaymentsParams params = new GetCardDataByPaymentsParamsBuilder()
                        .withPayments(null)
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> tokenizationClient.getCardDataByPayments(params));
            }
        }
    }
}
