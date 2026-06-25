package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.SendTestRequest;
import com.onlinepayments.domain.ValidateCredentialsRequest;
import com.onlinepayments.domain.ValidateCredentialsResponse;
import com.onlinepayments.it.util.webhooks.SendTestRequestBuilder;
import com.onlinepayments.it.util.webhooks.ValidateCredentialsRequestBuilder;
import com.onlinepayments.merchant.webhooks.WebhooksClientInterface;

public class WebhooksTest extends ItTest {

    private static final String VALID_WEBHOOK_KEY = "test-key";
    private static final String VALID_WEBHOOK_SECRET = "test-secret";
    private static final String INVALID_WEBHOOK_URL = "invalid-url";
    private static final String VALID_WEBHOOK_URL = "https://example.com/webhook";

    private ClientInterface client;
    private WebhooksClientInterface webhooksClient;

    @BeforeEach
    void setUp() throws URISyntaxException {
        client = getClient();
        webhooksClient = client.merchant(getMerchantId()).webhooks();
    }

    @AfterEach
    void tearDown() throws IOException {
        if (client != null) {
            client.close();
        }
    }

    @Nested
    class WhenValidatingWebhookCredentials {

        @Nested
        class WithCredentials {

            @Test
            void shouldReturnResult() {
                ValidateCredentialsRequest request = new ValidateCredentialsRequestBuilder()
                        .withKey(VALID_WEBHOOK_KEY)
                        .withSecret(VALID_WEBHOOK_SECRET)
                        .build();

                ValidateCredentialsResponse response = webhooksClient.validateWebhookCredentials(request);

                assertNotNull(response);
                assertNotNull(response.getResult());
            }

            @Test
            void shouldReturnResultWithCallContext() {
                ValidateCredentialsRequest request = new ValidateCredentialsRequestBuilder()
                        .withKey(VALID_WEBHOOK_KEY)
                        .withSecret(VALID_WEBHOOK_SECRET)
                        .build();

                CallContext context = new CallContext().withIdempotenceKey("test-webhooks-" + UUID.randomUUID());
                ValidateCredentialsResponse response = webhooksClient.validateWebhookCredentials(request, context);

                assertNotNull(response);
                assertNotNull(response.getResult());
            }

            @Test
            void shouldReturnInvalidResultWithIncorrectSecret() {
                ValidateCredentialsRequest request = new ValidateCredentialsRequestBuilder()
                        .withKey(VALID_WEBHOOK_KEY)
                        .withSecret("incorrect-secret")
                        .build();

                ValidateCredentialsResponse response = webhooksClient.validateWebhookCredentials(request);

                assertNotNull(response);
                assertNotNull(response.getResult());
                assertEquals("Invalid", response.getResult());
            }
        }
    }

    @Nested
    class WhenSendingTestWebhook {

        @Nested
        class WithoutWebhookConfiguration {

            @Test
            void shouldThrowValidationException() {
                SendTestRequest request = new SendTestRequestBuilder()
                        .withUrl(VALID_WEBHOOK_URL)
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> webhooksClient.sendTestWebhook(request));
            }

            @Test
            void shouldThrowValidationExceptionWithoutUrl() {
                SendTestRequest request = new SendTestRequestBuilder().build();

                assertThrows(
                        ValidationException.class,
                        () -> webhooksClient.sendTestWebhook(request));
            }
        }

        @Nested
        class WithInvalidUrl {

            @Test
            void shouldThrowValidationException() {
                SendTestRequest request = new SendTestRequestBuilder()
                        .withUrl(INVALID_WEBHOOK_URL)
                        .build();

                assertThrows(
                        ValidationException.class,
                        () -> webhooksClient.sendTestWebhook(request));
            }
        }
    }
}
