package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.onlinepayments.Communicator;
import com.onlinepayments.CommunicatorConfiguration;
import com.onlinepayments.Factory;
import com.onlinepayments.communication.MultipartFormDataObject;
import com.onlinepayments.communication.MultipartFormDataRequest;
import com.onlinepayments.domain.UploadableFile;
import com.onlinepayments.json.DefaultMarshaller;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

class MultipartFormDataTest extends ItTest {

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
        CommunicatorConfiguration configuration = getCommunicatorConfiguration();
        configuration.setApiEndpoint(new URI("http", null, server.getHostName(), server.getPort(), null, null, null));

        return configuration;
    }

    @Test
    void testPostMultipartFormDataObjectWithResponse() throws URISyntaxException, IOException, InterruptedException {

        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{\"files\": {\"file\": \"file content\"}, \"form\": {\"value\": \"Hello World\"}}"));

        CommunicatorConfiguration configuration = configMockServer();

        try (Communicator communicator = Factory.createCommunicator(configuration);
                InputStream content = getClass().getResourceAsStream("/itconfiguration.properties")) {

            MultipartFormDataObject multipart = new MultipartFormDataObject();
            multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
            multipart.addValue("value", "Hello World");

            @SuppressWarnings("unchecked")
            Map<String, Object> response = communicator.post("/post", null, null, multipart, Map.class, null);

            @SuppressWarnings("unchecked")
            Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
            assertEquals("file content", files.get("file"));

            @SuppressWarnings("unchecked")
            Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
            assertEquals("Hello World", form.get("value"));
        }

        RecordedRequest request = server.takeRequest();
        assertEquals("/post", request.getPath());
        assertEquals("POST", request.getMethod());
    }

    @Test
    void testPostMultipartFormDataRequestWithResponse() throws Exception {

        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{\"files\": {\"file\": \"file content\"}, \"form\": {\"value\": \"Hello World\"}}")
                .addHeader("Content-Type", "application/json"));

        CommunicatorConfiguration configuration = configMockServer();

        try (Communicator communicator = Factory.createCommunicator(configuration);
                InputStream content = getClass().getResourceAsStream("/itconfiguration.properties")) {

            MultipartFormDataObject multipart = new MultipartFormDataObject();
            multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
            multipart.addValue("value", "Hello World");
            MultipartFormDataRequest request = () -> multipart;

            @SuppressWarnings("unchecked")
            Map<String, Object> response = communicator.post("/post", null, null, request, Map.class, null);

            @SuppressWarnings("unchecked")
            Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
            assertEquals(1, files.size());
            String file = assertInstanceOf(String.class, files.get("file"));
            assertEquals("file content", file); // matches mock response

            @SuppressWarnings("unchecked")
            Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
            assertEquals(1, form.size());
            String value = assertInstanceOf(String.class, form.get("value"));
            assertEquals("Hello World", value);
        }

        RecordedRequest recordedRequest = server.takeRequest();
        assertEquals("/post", recordedRequest.getPath());
        assertEquals("POST", recordedRequest.getMethod());
    }

    @Test
    void testPostMultipartFormDataObjectWithBodyHandler() throws Exception {

        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{\"files\": {\"file\": \"file content\"}, \"form\": {\"value\": \"Hello World\"}}")
                .addHeader("Content-Type", "application/json"));

        CommunicatorConfiguration configuration = configMockServer();

        try (Communicator communicator = Factory.createCommunicator(configuration);
                InputStream content = getClass().getResourceAsStream("/itconfiguration.properties")) {

            MultipartFormDataObject multipart = new MultipartFormDataObject();
            multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
            multipart.addValue("value", "Hello World");

            communicator.post("/post", null, null, multipart, (bodyStream, headers) -> {
                @SuppressWarnings("unchecked")
                Map<String, Object> response = DefaultMarshaller.INSTANCE.unmarshal(bodyStream, Map.class);

                @SuppressWarnings("unchecked")
                Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
                assertEquals(1, files.size());
                String file = assertInstanceOf(String.class, files.get("file"));
                assertEquals("file content", file); // updated to match mock response

                @SuppressWarnings("unchecked")
                Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
                assertEquals(1, form.size());
                String value = assertInstanceOf(String.class, form.get("value"));
                assertEquals("Hello World", value);
            }, null);
        }

        RecordedRequest recordedRequest = server.takeRequest();
        assertEquals("/post", recordedRequest.getPath());
        assertEquals("POST", recordedRequest.getMethod());
    }

    @Test
    void testPostMultipartFormDataRequestWithBodyHandler() throws Exception {

        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{\"files\": {\"file\": \"file content\"}, \"form\": {\"value\": \"Hello World\"}}")
                .addHeader("Content-Type", "application/json"));

        CommunicatorConfiguration configuration = configMockServer();

        try (Communicator communicator = Factory.createCommunicator(configuration);
                InputStream content = getClass().getResourceAsStream("/itconfiguration.properties")) {

            MultipartFormDataObject multipart = new MultipartFormDataObject();
            multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
            multipart.addValue("value", "Hello World");
            MultipartFormDataRequest request = () -> multipart;

            communicator.post("/post", null, null, request, (bodyStream, headers) -> {
                @SuppressWarnings("unchecked")
                Map<String, Object> response = DefaultMarshaller.INSTANCE.unmarshal(bodyStream, Map.class);

                @SuppressWarnings("unchecked")
                Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
                assertEquals(1, files.size());
                String file = assertInstanceOf(String.class, files.get("file"));
                assertEquals("file content", file); // matches mock response

                @SuppressWarnings("unchecked")
                Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
                assertEquals(1, form.size());
                String value = assertInstanceOf(String.class, form.get("value"));
                assertEquals("Hello World", value);
            }, null);
        }

        RecordedRequest recordedRequest = server.takeRequest();
        assertEquals("/post", recordedRequest.getPath());
        assertEquals("POST", recordedRequest.getMethod());
    }

    @Test
    void testPutMultipartFormDataObjectWithResponse() throws Exception {

        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{\"files\": {\"file\": \"file content\"}, \"form\": {\"value\": \"Hello World\"}}")
                .addHeader("Content-Type", "application/json"));

        CommunicatorConfiguration configuration = configMockServer();

        try (Communicator communicator = Factory.createCommunicator(configuration);
                InputStream content = getClass().getResourceAsStream("/itconfiguration.properties")) {

            MultipartFormDataObject multipart = new MultipartFormDataObject();
            multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
            multipart.addValue("value", "Hello World");

            @SuppressWarnings("unchecked")
            Map<String, Object> response = communicator.put("/put", null, null, multipart, Map.class, null);

            @SuppressWarnings("unchecked")
            Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
            assertEquals(1, files.size());
            String file = assertInstanceOf(String.class, files.get("file"));
            assertEquals("file content", file); // matches mock response

            @SuppressWarnings("unchecked")
            Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
            assertEquals(1, form.size());
            String value = assertInstanceOf(String.class, form.get("value"));
            assertEquals("Hello World", value);
        }

        RecordedRequest recordedRequest = server.takeRequest();
        assertEquals("/put", recordedRequest.getPath());
        assertEquals("PUT", recordedRequest.getMethod());
    }

    @Test
    void testPutMultipartFormDataRequestWithResponse() throws Exception {

        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{\"files\": {\"file\": \"file content\"}, \"form\": {\"value\": \"Hello World\"}}")
                .addHeader("Content-Type", "application/json"));

        CommunicatorConfiguration configuration = configMockServer();

        try (Communicator communicator = Factory.createCommunicator(configuration);
                InputStream content = getClass().getResourceAsStream("/itconfiguration.properties")) {

            MultipartFormDataObject multipart = new MultipartFormDataObject();
            multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
            multipart.addValue("value", "Hello World");
            MultipartFormDataRequest request = () -> multipart;

            @SuppressWarnings("unchecked")
            Map<String, Object> response = communicator.put("/put", null, null, request, Map.class, null);

            @SuppressWarnings("unchecked")
            Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
            assertEquals(1, files.size());
            String file = assertInstanceOf(String.class, files.get("file"));
            assertEquals("file content", file); // matches mock response

            @SuppressWarnings("unchecked")
            Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
            assertEquals(1, form.size());
            String value = assertInstanceOf(String.class, form.get("value"));
            assertEquals("Hello World", value);
        }

        RecordedRequest recordedRequest = server.takeRequest();
        assertEquals("/put", recordedRequest.getPath());
        assertEquals("PUT", recordedRequest.getMethod());
    }

    @Test
    void testPutMultipartFormDataObjectWithBodyHandler() throws Exception {

        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{\"files\": {\"file\": \"file content\"}, \"form\": {\"value\": \"Hello World\"}}")
                .addHeader("Content-Type", "application/json"));

        CommunicatorConfiguration configuration = configMockServer();

        try (Communicator communicator = Factory.createCommunicator(configuration);
                InputStream content = getClass().getResourceAsStream("/itconfiguration.properties")) {

            MultipartFormDataObject multipart = new MultipartFormDataObject();
            multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
            multipart.addValue("value", "Hello World");

            communicator.put("/put", null, null, multipart, (bodyStream, headers) -> {
                @SuppressWarnings("unchecked")
                Map<String, Object> response = DefaultMarshaller.INSTANCE.unmarshal(bodyStream, Map.class);

                @SuppressWarnings("unchecked")
                Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
                assertEquals(1, files.size());
                String file = assertInstanceOf(String.class, files.get("file"));
                assertEquals("file content", file); // matches mock response

                @SuppressWarnings("unchecked")
                Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
                assertEquals(1, form.size());
                String value = assertInstanceOf(String.class, form.get("value"));
                assertEquals("Hello World", value);
            }, null);
        }

        RecordedRequest recordedRequest = server.takeRequest();
        assertEquals("/put", recordedRequest.getPath());
        assertEquals("PUT", recordedRequest.getMethod());
    }

    @Test
    void testPutMultipartFormDataRequestWithBodyHandler() throws Exception {

        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{\"files\": {\"file\": \"file content\"}, \"form\": {\"value\": \"Hello World\"}}")
                .addHeader("Content-Type", "application/json"));

        CommunicatorConfiguration configuration = configMockServer();

        try (Communicator communicator = Factory.createCommunicator(configuration);
                InputStream content = getClass().getResourceAsStream("/itconfiguration.properties")) {

            MultipartFormDataObject multipart = new MultipartFormDataObject();
            multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
            multipart.addValue("value", "Hello World");
            MultipartFormDataRequest request = () -> multipart;

            communicator.put("/put", null, null, request, (bodyStream, headers) -> {
                @SuppressWarnings("unchecked")
                Map<String, Object> response = DefaultMarshaller.INSTANCE.unmarshal(bodyStream, Map.class);

                @SuppressWarnings("unchecked")
                Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
                assertEquals(1, files.size());
                String file = assertInstanceOf(String.class, files.get("file"));
                assertEquals("file content", file); // matches mock response

                @SuppressWarnings("unchecked")
                Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
                assertEquals(1, form.size());
                String value = assertInstanceOf(String.class, form.get("value"));
                assertEquals("Hello World", value);
            }, null);
        }

        RecordedRequest recordedRequest = server.takeRequest();
        assertEquals("/put", recordedRequest.getPath());
        assertEquals("PUT", recordedRequest.getMethod());
    }
}
