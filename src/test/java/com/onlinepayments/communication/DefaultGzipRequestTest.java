package com.onlinepayments.communication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.onlinepayments.CallContext;
import com.onlinepayments.Communicator;
import com.onlinepayments.CommunicatorConfiguration;
import com.onlinepayments.Factory;
import com.onlinepayments.authentication.AuthorizationType;
import com.onlinepayments.json.DefaultMarshaller;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

class DefaultGzipRequestTest {

    private MockWebServer server;

    @BeforeEach
    void setUp() throws IOException {
        server = new MockWebServer();
        server.start();
    }

    @AfterEach
    void tearDown() throws IOException {
        server.shutdown();
    }

    private CommunicatorConfiguration configMockServer() throws URISyntaxException {
        CommunicatorConfiguration configuration = new CommunicatorConfiguration();

        configuration.withApiEndpoint(new URI(
                "http",
                null,
                server.getHostName(),
                server.getPort(),
                null,
                null,
                null
        ));

        configuration
            .withAuthorizationType(AuthorizationType.V1HMAC)
            .withApiKeyId("api-key-id")
            .withSecretApiKey("api-key-secret")
            .withIntegrator("integrator")
            .withConnectionRequestTimeout(CommunicatorConfiguration.DEFAULT_CONNECTION_REQUEST_TIMEOUT)
            .withConnectTimeout(5000)
            .withSocketTimeout(5000)
                .withMaxConnections(CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS);

        return configuration;
    }

    @Test
    void sendsGzipCompressedRequestBody() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{\"merchantBatchReference\":\"dummy-ref\",\"totalCount\":2}"));

        CommunicatorConfiguration configuration = configMockServer();

        try (Communicator communicator = Factory.createCommunicator(configuration)) {
            String path = "/gzip";

            Map<String, Object> header = new HashMap<>();
            header.put("itemCount", 2);
            header.put("operationType", "CreatePayment");
            header.put("merchantBatchReference", UUID.randomUUID().toString());

            Map<String, Object> payment1AmountOfMoney = new HashMap<>();
            payment1AmountOfMoney.put("amount", 10000);
            payment1AmountOfMoney.put("currencyCode", "EUR");

            Map<String, Object> payment1Order = new HashMap<>();
            payment1Order.put("amountOfMoney", payment1AmountOfMoney);

            Map<String, Object> payment1 = new HashMap<>();
            payment1.put("order", payment1Order);

            Map<String, Object> payment2AmountOfMoney = new HashMap<>();
            payment2AmountOfMoney.put("amount", 20000);
            payment2AmountOfMoney.put("currencyCode", "EUR");

            Map<String, Object> payment2Order = new HashMap<>();
            payment2Order.put("amountOfMoney", payment2AmountOfMoney);

            Map<String, Object> payment2 = new HashMap<>();
            payment2.put("order", payment2Order);

            List<Map<String, Object>> createPayments = new ArrayList<>();
            createPayments.add(payment1);
            createPayments.add(payment2);

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("header", header);
            requestBody.put("createPayments", createPayments);

            CallContext context = new CallContext();
            context.setGzip(true);

            communicator.post(
                    path,
                    null,
                    null,
                    requestBody,
                    Map.class,
                    context
            );
        }

        RecordedRequest recordedRequest = server.takeRequest();

        assertEquals("/gzip", recordedRequest.getPath());
        assertEquals("POST", recordedRequest.getMethod());
        assertEquals("gzip", recordedRequest.getHeader("Content-Encoding"));

        byte[] gzippedBytes = recordedRequest.getBody().readByteArray();
        String decompressedBody = decompress(gzippedBytes);

        assertNotNull(decompressedBody);

        @SuppressWarnings("unchecked")
        Map<String, Object> parsed = DefaultMarshaller.INSTANCE.unmarshal(
            new ByteArrayInputStream(decompressedBody.getBytes(StandardCharsets.UTF_8)),
                Map.class
        );

        @SuppressWarnings("unchecked")
        Map<String, Object> headerNode = (Map<String, Object>) parsed.get("header");

        assertEquals("CreatePayment", headerNode.get("operationType"));
        assertEquals(2, ((Number) headerNode.get("itemCount")).intValue());
    }

    private static String decompress(byte[] gzippedBytes) throws IOException {
        try (GZIPInputStream gzip = new GZIPInputStream(new ByteArrayInputStream(gzippedBytes));
                InputStreamReader isr = new InputStreamReader(gzip, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr)) {

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            return sb.toString();
        }
    }
}
