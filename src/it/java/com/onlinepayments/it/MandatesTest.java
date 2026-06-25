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
import com.onlinepayments.domain.CreateMandateRequest;
import com.onlinepayments.domain.CreateMandateResponse;
import com.onlinepayments.domain.GetMandateResponse;
import com.onlinepayments.domain.RevokeMandateRequest;
import com.onlinepayments.it.util.SdkTestHelper;
import com.onlinepayments.it.util.mandates.CreateMandateRequestBuilder;
import com.onlinepayments.it.util.mandates.RevokeMandateRequestBuilder;
import com.onlinepayments.merchant.mandates.MandatesClientInterface;

public class MandatesTest extends ItTest {

    private static final String INVALID_IBAN = "INVALID";
    private static final String INVALID_MANDATE_REFERENCE = "INVALID123456";

    private ClientInterface client;
    private MandatesClientInterface mandatesClient;

    private SdkTestHelper sdkTestHelper;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        mandatesClient = client.merchant(getMerchantId()).mandates();

        sdkTestHelper = getSdkTestHelper(client);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenCreatingMandate {

        @Nested
        class WithValidRequest {

            @Test
            void shouldCreateMandateAndReturnUniqueMandateReference() {
                CreateMandateRequest request = new CreateMandateRequestBuilder()
                        .withUniqueMandateReference(UUID.randomUUID().toString().substring(0, 35))
                        .build();

                CreateMandateResponse response = mandatesClient.createMandate(request);

                assertNotNull(response);
                assertNotNull(response.getMandate());
                assertNotNull(response.getMandate().getUniqueMandateReference());
            }

            @Test
            void shouldCreateMandateWithCallContext() {
                CreateMandateRequest request = new CreateMandateRequestBuilder()
                        .withUniqueMandateReference(UUID.randomUUID().toString().substring(0, 35))
                        .build();

                CallContext context = new CallContext().withIdempotenceKey("test-mandates-" + UUID.randomUUID());
                CreateMandateResponse response = mandatesClient.createMandate(request, context);

                assertNotNull(response);
                assertNotNull(response.getMandate());
                assertNotNull(response.getMandate().getUniqueMandateReference());
            }
        }

        @Nested
        class WithInvalidIban {

            @Test
            void shouldThrowValidationException() {
                CreateMandateRequest request = new CreateMandateRequestBuilder()
                        .withCustomerIban(INVALID_IBAN)
                        .withUniqueMandateReference(UUID.randomUUID().toString().substring(0, 35))
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> mandatesClient.createMandate(request));
            }
        }
    }

    @Nested
    class WhenRetrievingMandate {

        @Nested
        class WithValidMandateReference {

            @Test
            void shouldReturnMandateDetails() {
                String mandateReference = sdkTestHelper.createMandateAndGetReference();

                GetMandateResponse response = mandatesClient.getMandate(mandateReference);

                assertNotNull(response);
                assertNotNull(response.getMandate());
                assertNotNull(response.getMandate().getUniqueMandateReference());
            }
        }

        @Nested
        class WithInvalidMandateReference {

            @Test
            void shouldThrowReferenceException() {
                assertThrows(
                        ReferenceException.class,
                        () -> mandatesClient.getMandate(INVALID_MANDATE_REFERENCE));
            }
        }
    }

    @Nested
    class WhenBlockingMandate {

        @Nested
        class WithValidMandateReference {

            @Test
            void shouldBlockMandateAndReturnUniqueMandateReference() {
                String mandateReference = sdkTestHelper.createMandateAndGetReference();

                GetMandateResponse response = mandatesClient.blockMandate(mandateReference);

                assertNotNull(response);
                assertNotNull(response.getMandate());
                assertNotNull(response.getMandate().getUniqueMandateReference());
            }
        }

        @Nested
        class WithAlreadyBlockedMandate {

            @Test
            void shouldThrowValidationException() {
                String mandateReference = sdkTestHelper.createMandateAndGetReference();
                mandatesClient.blockMandate(mandateReference);

                assertThrows(
                        ValidationException.class,
                        () -> mandatesClient.blockMandate(mandateReference));
            }
        }

        @Nested
        class WithRevokedMandate {

            @Test
            void shouldThrowValidationException() {
                String mandateReference = sdkTestHelper.createMandateAndGetReference();
                RevokeMandateRequest revokeRequest = new RevokeMandateRequestBuilder().build();
                mandatesClient.revokeMandate(mandateReference, revokeRequest);

                assertThrows(
                        ValidationException.class,
                        () -> mandatesClient.blockMandate(mandateReference));
            }
        }

        @Nested
        class WithInvalidMandateReference {

            @Test
            void shouldThrowReferenceException() {
                assertThrows(
                        ReferenceException.class,
                        () -> mandatesClient.blockMandate(INVALID_MANDATE_REFERENCE));
            }
        }
    }

    @Nested
    class WhenUnblockingMandate {

        @Nested
        class WithBlockedMandate {

            @Test
            void shouldUnblockMandateAndReturnUniqueMandateReference() {
                String mandateReference = sdkTestHelper.createMandateAndGetReference();
                mandatesClient.blockMandate(mandateReference);

                GetMandateResponse response = mandatesClient.unblockMandate(mandateReference);

                assertNotNull(response);
                assertNotNull(response.getMandate());
                assertNotNull(response.getMandate().getUniqueMandateReference());
            }
        }

        @Nested
        class WithNotBlockedMandate {

            @Test
            void shouldThrowValidationException() {
                String mandateReference = sdkTestHelper.createMandateAndGetReference();

                assertThrows(
                        ValidationException.class,
                        () -> mandatesClient.unblockMandate(mandateReference));
            }
        }

        @Nested
        class WithRevokedMandate {

            @Test
            void shouldThrowValidationException() {
                String mandateReference = sdkTestHelper.createMandateAndGetReference();
                RevokeMandateRequest revokeRequest = new RevokeMandateRequestBuilder().build();
                mandatesClient.revokeMandate(mandateReference, revokeRequest);

                assertThrows(
                        ValidationException.class,
                        () -> mandatesClient.unblockMandate(mandateReference));
            }
        }

        @Nested
        class WithInvalidMandateReference {

            @Test
            void shouldThrowReferenceException() {
                assertThrows(
                        ReferenceException.class,
                        () -> mandatesClient.unblockMandate(INVALID_MANDATE_REFERENCE));
            }
        }
    }

    @Nested
    class WhenRevokingMandate {

        @Nested
        class WithValidMandate {

            @Test
            void shouldRevokeMandateAndReturnUniqueMandateReference() {
                String mandateReference = sdkTestHelper.createMandateAndGetReference();
                RevokeMandateRequest request = new RevokeMandateRequestBuilder().build();

                GetMandateResponse response = mandatesClient.revokeMandate(mandateReference, request);

                assertNotNull(response);
                assertNotNull(response.getMandate());
                assertNotNull(response.getMandate().getUniqueMandateReference());
            }
        }

        @Nested
        class WithBlockedMandate {

            @Test
            void shouldRevokeBlockedMandateAndReturnUniqueMandateReference() {
                String mandateReference = sdkTestHelper.createMandateAndGetReference();
                mandatesClient.blockMandate(mandateReference);
                RevokeMandateRequest request = new RevokeMandateRequestBuilder().build();

                GetMandateResponse response = mandatesClient.revokeMandate(mandateReference, request);

                assertNotNull(response);
                assertNotNull(response.getMandate());
                assertNotNull(response.getMandate().getUniqueMandateReference());
            }
        }

        @Nested
        class WithUnblockedMandate {

            @Test
            void shouldRevokeUnblockedMandateAndReturnUniqueMandateReference() {
                String mandateReference = sdkTestHelper.createMandateAndGetReference();
                mandatesClient.blockMandate(mandateReference);
                mandatesClient.unblockMandate(mandateReference);
                RevokeMandateRequest request = new RevokeMandateRequestBuilder().build();

                GetMandateResponse response = mandatesClient.revokeMandate(mandateReference, request);

                assertNotNull(response);
                assertNotNull(response.getMandate());
                assertNotNull(response.getMandate().getUniqueMandateReference());
            }
        }

        @Nested
        class WithAlreadyRevokedMandate {

            @Test
            void shouldThrowValidationException() {
                String mandateReference = sdkTestHelper.createMandateAndGetReference();
                RevokeMandateRequest revokeRequest = new RevokeMandateRequestBuilder().build();
                mandatesClient.revokeMandate(mandateReference, revokeRequest);

                assertThrows(
                        ValidationException.class,
                        () -> mandatesClient.revokeMandate(mandateReference, revokeRequest));
            }
        }

        @Nested
        class WithInvalidMandateReference {

            @Test
            void shouldThrowValidationException() {
                RevokeMandateRequest request = new RevokeMandateRequestBuilder().build();

                assertThrows(
                        ValidationException.class,
                        () -> mandatesClient.revokeMandate(INVALID_MANDATE_REFERENCE, request));
            }
        }
    }
}
