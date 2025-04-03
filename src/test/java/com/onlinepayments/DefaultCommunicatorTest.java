package com.onlinepayments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.authentication.Authenticator;
import com.onlinepayments.communication.Connection;
import com.onlinepayments.communication.MetadataProvider;
import com.onlinepayments.communication.RequestParam;
import com.onlinepayments.json.Marshaller;

class DefaultCommunicatorTest {

    private static final URI BASE_URI = URI.create("https://payment.preprod.online-payments.com");

    // TODO: replace v1/merchant/20000/convertamount with a path as necessary

    private Connection connection;
    private Authenticator authenticator;
    private MetadataProvider metadataProvider;
    private Marshaller marshaller;

    @BeforeEach
    void initMocks() {
        connection = mock(Connection.class);
        authenticator = mock(Authenticator.class);
        metadataProvider = mock(MetadataProvider.class);
        marshaller = mock(Marshaller.class);
    }

    @Nested
    class ToAbsoluteURI {

        @Test
        void testWithoutRequestParams() {
            @SuppressWarnings("resource")
            DefaultCommunicator communicator = new DefaultCommunicator(BASE_URI, connection, authenticator, metadataProvider, marshaller);

            URI uri = communicator.toAbsoluteURI("v1/merchant/20000/convertamount", Collections.emptyList());
            assertEquals(URI.create("https://payment.preprod.online-payments.com/v1/merchant/20000/convertamount"), uri);

            uri = communicator.toAbsoluteURI("/v1/merchant/20000/convertamount", Collections.emptyList());
            assertEquals(URI.create("https://payment.preprod.online-payments.com/v1/merchant/20000/convertamount"), uri);
        }

        @Test
        void testWithRequestParams() {
            List<RequestParam> requestParams = Arrays.asList(
                    new RequestParam("amount", "123"),
                    new RequestParam("source", "USD"),
                    new RequestParam("target", "EUR"),
                    new RequestParam("dummy", "é&%=")
            );

            @SuppressWarnings("resource")
            DefaultCommunicator communicator = new DefaultCommunicator(BASE_URI, connection, authenticator, metadataProvider, marshaller);

            URI uri = communicator.toAbsoluteURI("v1/merchant/20000/convertamount", requestParams);
            assertEquals(URI.create("https://payment.preprod.online-payments.com/v1/merchant/20000/convertamount?amount=123&source=USD&target=EUR&dummy=%C3%A9%26%25%3D"), uri);

            uri = communicator.toAbsoluteURI("/v1/merchant/20000/convertamount", requestParams);
            assertEquals(URI.create("https://payment.preprod.online-payments.com/v1/merchant/20000/convertamount?amount=123&source=USD&target=EUR&dummy=%C3%A9%26%25%3D"), uri);
        }
    }
}
