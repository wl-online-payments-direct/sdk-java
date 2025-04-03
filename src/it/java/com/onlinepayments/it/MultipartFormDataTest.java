package com.onlinepayments.it;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.onlinepayments.Communicator;
import com.onlinepayments.CommunicatorConfiguration;
import com.onlinepayments.Factory;
import com.onlinepayments.communication.MultipartFormDataObject;
import com.onlinepayments.communication.MultipartFormDataRequest;
import com.onlinepayments.domain.UploadableFile;
import com.onlinepayments.json.DefaultMarshaller;

class MultipartFormDataTest extends ItTest {

    private static final String HTTPBIN_URL = System.getProperty("httpbin.url", "http://httpbin.org");

    @Test
    void testPostMultipartFormDataObjectWithResponse() throws URISyntaxException, IOException {
        CommunicatorConfiguration configuration = getCommunicatorConfiguration();
        configuration.setApiEndpoint(URI.create(HTTPBIN_URL));

        try (Communicator communicator = Factory.createCommunicator(configuration);
                InputStream content = getClass().getResourceAsStream("/itconfiguration.properties")) {

            MultipartFormDataObject multipart = new MultipartFormDataObject();
            multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
            multipart.addValue("value", "Hello World");

            @SuppressWarnings("unchecked")
            Map<String, Object> response = communicator.post("/post", null, null, multipart, Map.class, null);

            @SuppressWarnings("unchecked")
            Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
            assertEquals(1, files.size());
            String file = assertInstanceOf(String.class, files.get("file"));
            assertThat(file, containsString("\nonlinePayments.api.endpoint.host"));

            @SuppressWarnings("unchecked")
            Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
            assertEquals(1, form.size());
            String value = assertInstanceOf(String.class, form.get("value"));
            assertEquals("Hello World", value);
        }
    }

    @Test
    void testPostMultipartFormDataRequestWithResponse() throws URISyntaxException, IOException {
        CommunicatorConfiguration configuration = getCommunicatorConfiguration();
        configuration.setApiEndpoint(URI.create(HTTPBIN_URL));

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
            assertThat(file, containsString("\nonlinePayments.api.endpoint.host"));

            @SuppressWarnings("unchecked")
            Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
            assertEquals(1, form.size());
            String value = assertInstanceOf(String.class, form.get("value"));
            assertEquals("Hello World", value);
        }
    }

    @Test
    void testPostMultipartFormDataObjectWithBodyHandler() throws URISyntaxException, IOException {
        CommunicatorConfiguration configuration = getCommunicatorConfiguration();
        configuration.setApiEndpoint(URI.create(HTTPBIN_URL));

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
                assertThat(file, containsString("\nonlinePayments.api.endpoint.host"));

                @SuppressWarnings("unchecked")
                Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
                assertEquals(1, form.size());
                String value = assertInstanceOf(String.class, form.get("value"));
                assertEquals("Hello World", value);
            }, null);
        }
    }

    @Test
    void testPostMultipartFormDataRequestWithBodyHandler() throws URISyntaxException, IOException {

        CommunicatorConfiguration configuration = getCommunicatorConfiguration();
        configuration.setApiEndpoint(URI.create(HTTPBIN_URL));

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
                assertThat(file, containsString("\nonlinePayments.api.endpoint.host"));

                @SuppressWarnings("unchecked")
                Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
                assertEquals(1, form.size());
                String value = assertInstanceOf(String.class, form.get("value"));
                assertEquals("Hello World", value);
            }, null);
        }
    }

    @Test
    void testPutMultipartFormDataObjectWithResponse() throws URISyntaxException, IOException {

        CommunicatorConfiguration configuration = getCommunicatorConfiguration();
        configuration.setApiEndpoint(URI.create(HTTPBIN_URL));

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
            assertThat(file, containsString("\nonlinePayments.api.endpoint.host"));

            @SuppressWarnings("unchecked")
            Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
            assertEquals(1, form.size());
            String value = assertInstanceOf(String.class, form.get("value"));
            assertEquals("Hello World", value);
        }
    }

    @Test
    void testPutMultipartFormDataRequestWithResponse() throws URISyntaxException, IOException {

        CommunicatorConfiguration configuration = getCommunicatorConfiguration();
        configuration.setApiEndpoint(URI.create(HTTPBIN_URL));

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
            assertThat(file, containsString("\nonlinePayments.api.endpoint.host"));

            @SuppressWarnings("unchecked")
            Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
            assertEquals(1, form.size());
            String value = assertInstanceOf(String.class, form.get("value"));
            assertEquals("Hello World", value);
        }
    }

    @Test
    void testPutMultipartFormDataObjectWithBodyHandler() throws URISyntaxException, IOException {

        CommunicatorConfiguration configuration = getCommunicatorConfiguration();
        configuration.setApiEndpoint(URI.create(HTTPBIN_URL));

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
                assertThat(file, containsString("\nonlinePayments.api.endpoint.host"));

                @SuppressWarnings("unchecked")
                Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
                assertEquals(1, form.size());
                String value = assertInstanceOf(String.class, form.get("value"));
                assertEquals("Hello World", value);
            }, null);
        }
    }

    @Test
    void testPutMultipartFormDataRequestWithBodyHandler() throws URISyntaxException, IOException {

        CommunicatorConfiguration configuration = getCommunicatorConfiguration();
        configuration.setApiEndpoint(URI.create(HTTPBIN_URL));

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
                assertThat(file, containsString("\nonlinePayments.api.endpoint.host"));

                @SuppressWarnings("unchecked")
                Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
                assertEquals(1, form.size());
                String value = assertInstanceOf(String.class, form.get("value"));
                assertEquals("Hello World", value);
            }, null);
        }
    }
}
