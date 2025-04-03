package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

import com.onlinepayments.ClientInterface;
import com.onlinepayments.domain.GetPaymentProductsResponse;
import com.onlinepayments.merchant.products.GetPaymentProductsParams;

public class PaymentProductsTest extends ItTest {

    /**
     * Smoke test for products service.
     */
    @Test
    public void test() throws URISyntaxException, IOException {

        GetPaymentProductsParams params = new GetPaymentProductsParams()
                .withCountryCode("NL")
                .withCurrencyCode("EUR");

        try (ClientInterface client = getClient()) {
            GetPaymentProductsResponse response = client.merchant(getMerchantId()).products().getPaymentProducts(params);
            assertFalse(response.getPaymentProducts().isEmpty());
        }
    }
}
