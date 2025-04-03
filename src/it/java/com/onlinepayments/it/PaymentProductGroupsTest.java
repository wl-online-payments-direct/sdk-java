package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

import com.onlinepayments.ClientInterface;
import com.onlinepayments.domain.PaymentProductGroup;
import com.onlinepayments.merchant.productgroups.GetProductGroupParams;

public class PaymentProductGroupsTest extends ItTest {

    /**
     * Smoke test for product groups service.
     */
    @Test
    public void test() throws URISyntaxException, IOException {

        GetProductGroupParams params = new GetProductGroupParams()
                .withCountryCode("NL")
                .withCurrencyCode("EUR");

        try (ClientInterface client = getClient()) {
            PaymentProductGroup response = client.merchant(getMerchantId()).productGroups().getProductGroup("cards", params);

            assertNotNull(response);
            assertNotNull(response.getId());
            assertEquals("cards", response.getId().toLowerCase());
        }
    }
}
