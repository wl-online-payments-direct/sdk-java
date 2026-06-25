package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
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

public class MultipartFormDataTest extends ItTest {

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

    @Nested
    class WhenPostingMultipartFormData {

        @Nested
        class WithMultipartFormDataObject {

            @Nested
            class WithSingleFileAndValue {

                @Test
                void shouldPostWithResponse() throws Exception {
                    server.enqueue(new MockResponse()
                            .setResponseCode(200)
                            .setBody("{\"files\": {\"file\": \"file content\"}, \"form\": {\"value\": \"Hello World\"}}"));

                    CommunicatorConfiguration configuration = configMockServer();

                    try (Communicator communicator = Factory.createCommunicator(configuration);
                            InputStream content = createTestFileStream("file content")) {

                        MultipartFormDataObject multipart = new MultipartFormDataObject();
                        multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
                        multipart.addValue("value", "Hello World");

                        @SuppressWarnings("unchecked")
                        Map<String, Object> response = communicator.post("/post", null, null, multipart, Map.class, null);

                        assertNotNull(response);
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
                void shouldPostWithBodyHandler() throws Exception {
                    server.enqueue(new MockResponse()
                            .setResponseCode(200)
                            .setBody("{\"files\": {\"file\": \"file content\"}, \"form\": {\"value\": \"Hello World\"}}")
                            .addHeader("Content-Type", "application/json"));

                    CommunicatorConfiguration configuration = configMockServer();

                    try (Communicator communicator = Factory.createCommunicator(configuration);
                            InputStream content = createTestFileStream("file content")) {

                        MultipartFormDataObject multipart = new MultipartFormDataObject();
                        multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
                        multipart.addValue("value", "Hello World");

                        communicator.post("/post", null, null, multipart, (bodyStream, headers) -> {
                            @SuppressWarnings("unchecked")
                            Map<String, Object> response = DefaultMarshaller.INSTANCE.unmarshal(bodyStream, Map.class);

                            assertNotNull(response);
                            @SuppressWarnings("unchecked")
                            Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
                            assertEquals(1, files.size());
                            assertEquals("file content", files.get("file"));

                            @SuppressWarnings("unchecked")
                            Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
                            assertEquals(1, form.size());
                            assertEquals("Hello World", form.get("value"));
                        }, null);
                    }

                    RecordedRequest recordedRequest = server.takeRequest();
                    assertEquals("/post", recordedRequest.getPath());
                    assertEquals("POST", recordedRequest.getMethod());
                }
            }

            @Nested
            class WithMultipleFiles {

                @Test
                void shouldPostTwoFiles() throws Exception {
                    server.enqueue(new MockResponse()
                            .setResponseCode(200)
                            .setBody("{\"files\": {\"firstFile\": \"firstContent\", \"secondFile\": \"secondContent\"}}"));

                    CommunicatorConfiguration configuration = configMockServer();

                    try (Communicator communicator = Factory.createCommunicator(configuration);
                             InputStream firstContent = createTestFileStream("firstContent");
                             InputStream secondContent = createTestFileStream("secondContent")) {

                        MultipartFormDataObject multipart = new MultipartFormDataObject();
                        multipart.addFile("firstFile", new UploadableFile("first.txt", firstContent, "text/plain"));
                        multipart.addFile("secondFile", new UploadableFile("second.txt", secondContent, "text/plain"));

                        @SuppressWarnings("unchecked")
                        Map<String, Object> response = communicator.post("/post", null, null, multipart, Map.class, null);

                        assertNotNull(response);
                        @SuppressWarnings("unchecked")
                        Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
                        assertEquals(2, files.size());
                        assertEquals("firstContent", files.get("firstFile"));
                        assertEquals("secondContent", files.get("secondFile"));
                    }

                    RecordedRequest request = server.takeRequest();
                    assertEquals("POST", request.getMethod());
                }

                @Test
                void shouldPostThreeFilesWithDifferentTypes() throws Exception {
                    server.enqueue(new MockResponse()
                            .setResponseCode(200)
                            .setBody("{\"files\": {\"textFile\": \"text\", \"jsonFile\": \"json\", \"xmlFile\": \"xml\"}}"));

                    CommunicatorConfiguration configuration = configMockServer();

                    try (Communicator communicator = Factory.createCommunicator(configuration);
                             InputStream textContent = createTestFileStream("text");
                             InputStream jsonContent = createTestFileStream("json");
                             InputStream xmlContent = createTestFileStream("xml")) {

                        MultipartFormDataObject multipart = new MultipartFormDataObject();
                        multipart.addFile("textFile", new UploadableFile("file.txt", textContent, "text/plain"));
                        multipart.addFile("jsonFile", new UploadableFile("file.json", jsonContent, "application/json"));
                        multipart.addFile("xmlFile", new UploadableFile("file.xml", xmlContent, "application/xml"));

                        @SuppressWarnings("unchecked")
                        Map<String, Object> response = communicator.post("/post", null, null, multipart, Map.class, null);

                        assertNotNull(response);
                        @SuppressWarnings("unchecked")
                        Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
                        assertEquals(3, files.size());
                    }
                }
            }

            @Nested
            class WithMultipleValues {

                @Test
                void shouldPostTwoValues() throws Exception {
                    server.enqueue(new MockResponse()
                            .setResponseCode(200)
                            .setBody("{\"form\": {\"firstKey\": \"firstValue\", \"secondKey\": \"secondValue\"}}"));

                    CommunicatorConfiguration configuration = configMockServer();

                    try (Communicator communicator = Factory.createCommunicator(configuration)) {

                        MultipartFormDataObject multipart = new MultipartFormDataObject();
                        multipart.addValue("firstKey", "firstValue");
                        multipart.addValue("secondKey", "secondValue");

                        @SuppressWarnings("unchecked")
                        Map<String, Object> response = communicator.post("/post", null, null, multipart, Map.class, null);

                        assertNotNull(response);
                        @SuppressWarnings("unchecked")
                        Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
                        assertEquals(2, form.size());
                        assertEquals("firstValue", form.get("firstKey"));
                        assertEquals("secondValue", form.get("secondKey"));
                    }
                }

                @Test
                void shouldPostThreeValues() throws Exception {
                    server.enqueue(new MockResponse()
                            .setResponseCode(200)
                            .setBody("{\"form\": {\"name\": \"John\", \"age\": \"30\", \"city\": \"NYC\"}}"));

                    CommunicatorConfiguration configuration = configMockServer();

                    try (Communicator communicator = Factory.createCommunicator(configuration)) {

                        MultipartFormDataObject multipart = new MultipartFormDataObject();
                        multipart.addValue("name", "John");
                        multipart.addValue("age", "30");
                        multipart.addValue("city", "NYC");

                        @SuppressWarnings("unchecked")
                        Map<String, Object> response = communicator.post("/post", null, null, multipart, Map.class, null);

                        assertNotNull(response);
                        @SuppressWarnings("unchecked")
                        Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
                        assertEquals(3, form.size());
                    }
                }
            }

            @Nested
            class WithFilesOnly {

                @Test
                void shouldPostSingleFileWithoutValues() throws Exception {
                    server.enqueue(new MockResponse()
                            .setResponseCode(200)
                            .setBody("{\"files\": {\"document\": \"doc content\"}}"));

                    CommunicatorConfiguration configuration = configMockServer();

                    try (Communicator communicator = Factory.createCommunicator(configuration);
                            InputStream content = createTestFileStream("doc content")) {

                        MultipartFormDataObject multipart = new MultipartFormDataObject();
                        multipart.addFile("document", new UploadableFile("doc.pdf", content, "application/pdf"));

                        @SuppressWarnings("unchecked")
                        Map<String, Object> response = communicator.post("/post", null, null, multipart, Map.class, null);

                        assertNotNull(response);
                        @SuppressWarnings("unchecked")
                        Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
                        assertEquals("doc content", files.get("document"));
                    }
                }
            }

            @Nested
            class WithValuesOnly {

                @Test
                void shouldPostSingleValueWithoutFiles() throws Exception {
                    server.enqueue(new MockResponse()
                            .setResponseCode(200)
                            .setBody("{\"form\": {\"message\": \"Hello\"}}"));

                    CommunicatorConfiguration configuration = configMockServer();

                    try (Communicator communicator = Factory.createCommunicator(configuration)) {

                        MultipartFormDataObject multipart = new MultipartFormDataObject();
                        multipart.addValue("message", "Hello");

                        @SuppressWarnings("unchecked")
                        Map<String, Object> response = communicator.post("/post", null, null, multipart, Map.class, null);

                        assertNotNull(response);
                        @SuppressWarnings("unchecked")
                        Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
                        assertEquals("Hello", form.get("message"));
                    }
                }
            }

            @Nested
            class WithDifferentContentTypes {

                @Test
                void shouldPostPdfFile() throws Exception {
                    server.enqueue(new MockResponse()
                            .setResponseCode(200)
                            .setBody("{\"files\": {\"pdf\": \"pdf content\"}}"));

                    CommunicatorConfiguration configuration = configMockServer();

                    try (Communicator communicator = Factory.createCommunicator(configuration);
                            InputStream content = createTestFileStream("pdf content")) {

                        MultipartFormDataObject multipart = new MultipartFormDataObject();
                        multipart.addFile("pdf", new UploadableFile("document.pdf", content, "application/pdf"));

                        @SuppressWarnings("unchecked")
                        Map<String, Object> response = communicator.post("/post", null, null, multipart, Map.class, null);

                        assertNotNull(response);
                    }
                }

                @Test
                void shouldPostImageFile() throws Exception {
                    server.enqueue(new MockResponse()
                            .setResponseCode(200)
                            .setBody("{\"files\": {\"image\": \"image content\"}}"));

                    CommunicatorConfiguration configuration = configMockServer();

                    try (Communicator communicator = Factory.createCommunicator(configuration);
                            InputStream content = createTestFileStream("image content")) {

                        MultipartFormDataObject multipart = new MultipartFormDataObject();
                        multipart.addFile("image", new UploadableFile("photo.jpg", content, "image/jpeg"));

                        @SuppressWarnings("unchecked")
                        Map<String, Object> response = communicator.post("/post", null, null, multipart, Map.class, null);

                        assertNotNull(response);
                    }
                }

                @Test
                void shouldPostJsonFile() throws Exception {
                    server.enqueue(new MockResponse()
                            .setResponseCode(200)
                            .setBody("{\"files\": {\"data\": \"json content\"}}"));

                    CommunicatorConfiguration configuration = configMockServer();

                    try (Communicator communicator = Factory.createCommunicator(configuration);
                            InputStream content = createTestFileStream("json content")) {

                        MultipartFormDataObject multipart = new MultipartFormDataObject();
                        multipart.addFile("data", new UploadableFile("data.json", content, "application/json"));

                        @SuppressWarnings("unchecked")
                        Map<String, Object> response = communicator.post("/post", null, null, multipart, Map.class, null);

                        assertNotNull(response);
                    }
                }
            }

            @Nested
            class WithContentLength {

                @Test
                void shouldPostFileWithKnownLength() throws Exception {
                    server.enqueue(new MockResponse()
                            .setResponseCode(200)
                            .setBody("{\"files\": {\"file\": \"content\"}}"));

                    CommunicatorConfiguration configuration = configMockServer();

                    try (Communicator communicator = Factory.createCommunicator(configuration);
                            InputStream content = createTestFileStream("content")) {

                        MultipartFormDataObject multipart = new MultipartFormDataObject();
                        multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain", 7));

                        @SuppressWarnings("unchecked")
                        Map<String, Object> response = communicator.post("/post", null, null, multipart, Map.class, null);

                        assertNotNull(response);
                    }
                }

                @Test
                void shouldPostFileWithUnknownLength() throws Exception {
                    server.enqueue(new MockResponse()
                            .setResponseCode(200)
                            .setBody("{\"files\": {\"file\": \"content\"}}"));

                    CommunicatorConfiguration configuration = configMockServer();

                    try (Communicator communicator = Factory.createCommunicator(configuration);
                            InputStream content = createTestFileStream("content")) {

                        MultipartFormDataObject multipart = new MultipartFormDataObject();
                        multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));

                        @SuppressWarnings("unchecked")
                        Map<String, Object> response = communicator.post("/post", null, null, multipart, Map.class, null);

                        assertNotNull(response);
                    }
                }
            }
        }

        @Nested
        class WithMultipartFormDataRequest {

            @Test
            void shouldPostWithResponse() throws Exception {
                server.enqueue(new MockResponse()
                        .setResponseCode(200)
                        .setBody("{\"files\": {\"file\": \"file content\"}, \"form\": {\"value\": \"Hello World\"}}")
                        .addHeader("Content-Type", "application/json"));

                CommunicatorConfiguration configuration = configMockServer();

                try (Communicator communicator = Factory.createCommunicator(configuration);
                        InputStream content = createTestFileStream("file content")) {

                    MultipartFormDataObject multipart = new MultipartFormDataObject();
                    multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
                    multipart.addValue("value", "Hello World");
                    MultipartFormDataRequest request = () -> multipart;

                    @SuppressWarnings("unchecked")
                    Map<String, Object> response = communicator.post("/post", null, null, request, Map.class, null);

                    assertNotNull(response);
                    @SuppressWarnings("unchecked")
                    Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
                    assertEquals(1, files.size());
                    assertEquals("file content", files.get("file"));

                    @SuppressWarnings("unchecked")
                    Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
                    assertEquals(1, form.size());
                    assertEquals("Hello World", form.get("value"));
                }

                RecordedRequest recordedRequest = server.takeRequest();
                assertEquals("/post", recordedRequest.getPath());
                assertEquals("POST", recordedRequest.getMethod());
            }

            @Test
            void shouldPostWithBodyHandler() throws Exception {
                server.enqueue(new MockResponse()
                        .setResponseCode(200)
                        .setBody("{\"files\": {\"file\": \"file content\"}, \"form\": {\"value\": \"Hello World\"}}")
                        .addHeader("Content-Type", "application/json"));

                CommunicatorConfiguration configuration = configMockServer();

                try (Communicator communicator = Factory.createCommunicator(configuration);
                        InputStream content = createTestFileStream("file content")) {

                    MultipartFormDataObject multipart = new MultipartFormDataObject();
                    multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
                    multipart.addValue("value", "Hello World");
                    MultipartFormDataRequest request = () -> multipart;

                    communicator.post("/post", null, null, request, (bodyStream, headers) -> {
                        @SuppressWarnings("unchecked")
                        Map<String, Object> response = DefaultMarshaller.INSTANCE.unmarshal(bodyStream, Map.class);

                        assertNotNull(response);
                        @SuppressWarnings("unchecked")
                        Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
                        assertEquals(1, files.size());
                        assertEquals("file content", files.get("file"));

                        @SuppressWarnings("unchecked")
                        Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
                        assertEquals(1, form.size());
                        assertEquals("Hello World", form.get("value"));
                    }, null);
                }

                RecordedRequest recordedRequest = server.takeRequest();
                assertEquals("/post", recordedRequest.getPath());
                assertEquals("POST", recordedRequest.getMethod());
            }
        }
    }

    @Nested
    class WhenPuttingMultipartFormData {

        @Nested
        class WithMultipartFormDataObject {

            @Test
            void shouldPutWithResponse() throws Exception {
                server.enqueue(new MockResponse()
                        .setResponseCode(200)
                        .setBody("{\"files\": {\"file\": \"file content\"}, \"form\": {\"value\": \"Hello World\"}}")
                        .addHeader("Content-Type", "application/json"));

                CommunicatorConfiguration configuration = configMockServer();

                try (Communicator communicator = Factory.createCommunicator(configuration);
                        InputStream content = createTestFileStream("file content")) {

                    MultipartFormDataObject multipart = new MultipartFormDataObject();
                    multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
                    multipart.addValue("value", "Hello World");

                    @SuppressWarnings("unchecked")
                    Map<String, Object> response = communicator.put("/put", null, null, multipart, Map.class, null);

                    assertNotNull(response);
                    @SuppressWarnings("unchecked")
                    Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
                    assertEquals(1, files.size());
                    assertEquals("file content", files.get("file"));

                    @SuppressWarnings("unchecked")
                    Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
                    assertEquals(1, form.size());
                    assertEquals("Hello World", form.get("value"));
                }

                RecordedRequest recordedRequest = server.takeRequest();
                assertEquals("/put", recordedRequest.getPath());
                assertEquals("PUT", recordedRequest.getMethod());
            }

            @Test
            void shouldPutWithBodyHandler() throws Exception {
                server.enqueue(new MockResponse()
                        .setResponseCode(200)
                        .setBody("{\"files\": {\"file\": \"file content\"}, \"form\": {\"value\": \"Hello World\"}}")
                        .addHeader("Content-Type", "application/json"));

                CommunicatorConfiguration configuration = configMockServer();

                try (Communicator communicator = Factory.createCommunicator(configuration);
                        InputStream content = createTestFileStream("file content")) {

                    MultipartFormDataObject multipart = new MultipartFormDataObject();
                    multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
                    multipart.addValue("value", "Hello World");

                    communicator.put("/put", null, null, multipart, (bodyStream, headers) -> {
                        @SuppressWarnings("unchecked")
                        Map<String, Object> response = DefaultMarshaller.INSTANCE.unmarshal(bodyStream, Map.class);

                        assertNotNull(response);
                        @SuppressWarnings("unchecked")
                        Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
                        assertEquals(1, files.size());
                        assertEquals("file content", files.get("file"));

                        @SuppressWarnings("unchecked")
                        Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
                        assertEquals(1, form.size());
                        assertEquals("Hello World", form.get("value"));
                    }, null);
                }

                RecordedRequest recordedRequest = server.takeRequest();
                assertEquals("/put", recordedRequest.getPath());
                assertEquals("PUT", recordedRequest.getMethod());
            }
        }

        @Nested
        class WithMultipartFormDataRequest {

            @Test
            void shouldPutWithResponse() throws Exception {
                server.enqueue(new MockResponse()
                        .setResponseCode(200)
                        .setBody("{\"files\": {\"file\": \"file content\"}, \"form\": {\"value\": \"Hello World\"}}")
                        .addHeader("Content-Type", "application/json"));

                CommunicatorConfiguration configuration = configMockServer();

                try (Communicator communicator = Factory.createCommunicator(configuration);
                        InputStream content = createTestFileStream("file content")) {

                    MultipartFormDataObject multipart = new MultipartFormDataObject();
                    multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
                    multipart.addValue("value", "Hello World");
                    MultipartFormDataRequest request = () -> multipart;

                    @SuppressWarnings("unchecked")
                    Map<String, Object> response = communicator.put("/put", null, null, request, Map.class, null);

                    assertNotNull(response);
                    @SuppressWarnings("unchecked")
                    Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
                    assertEquals(1, files.size());
                    assertEquals("file content", files.get("file"));

                    @SuppressWarnings("unchecked")
                    Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
                    assertEquals(1, form.size());
                    assertEquals("Hello World", form.get("value"));
                }

                RecordedRequest recordedRequest = server.takeRequest();
                assertEquals("/put", recordedRequest.getPath());
                assertEquals("PUT", recordedRequest.getMethod());
            }

            @Test
            void shouldPutWithBodyHandler() throws Exception {
                server.enqueue(new MockResponse()
                        .setResponseCode(200)
                        .setBody("{\"files\": {\"file\": \"file content\"}, \"form\": {\"value\": \"Hello World\"}}")
                        .addHeader("Content-Type", "application/json"));

                CommunicatorConfiguration configuration = configMockServer();

                try (Communicator communicator = Factory.createCommunicator(configuration);
                        InputStream content = createTestFileStream("file content")) {

                    MultipartFormDataObject multipart = new MultipartFormDataObject();
                    multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
                    multipart.addValue("value", "Hello World");
                    MultipartFormDataRequest request = () -> multipart;

                    communicator.put("/put", null, null, request, (bodyStream, headers) -> {
                        @SuppressWarnings("unchecked")
                        Map<String, Object> response = DefaultMarshaller.INSTANCE.unmarshal(bodyStream, Map.class);

                        assertNotNull(response);
                        @SuppressWarnings("unchecked")
                        Map<String, Object> files = assertInstanceOf(Map.class, response.get("files"));
                        assertEquals(1, files.size());
                        assertEquals("file content", files.get("file"));

                        @SuppressWarnings("unchecked")
                        Map<String, Object> form = assertInstanceOf(Map.class, response.get("form"));
                        assertEquals(1, form.size());
                        assertEquals("Hello World", form.get("value"));
                    }, null);
                }

                RecordedRequest recordedRequest = server.takeRequest();
                assertEquals("/put", recordedRequest.getPath());
                assertEquals("PUT", recordedRequest.getMethod());
            }
        }
    }

    @Nested
    class WhenAddingFiles {

        @Nested
        class WithValidFile {

            @Test
            void shouldAddFileWithKnownLength() {
                MultipartFormDataObject multipart = new MultipartFormDataObject();
                InputStream content = createTestFileStream("content");
                UploadableFile file = new UploadableFile("file.txt", content, "text/plain", 7);

                multipart.addFile("document", file);

                assertEquals(1, multipart.getFiles().size());
                assertTrue(multipart.getFiles().containsKey("document"));
                assertEquals(file, multipart.getFiles().get("document"));
            }

            @Test
            void shouldAddFileWithUnknownLength() {
                MultipartFormDataObject multipart = new MultipartFormDataObject();
                InputStream content = createTestFileStream("content");
                UploadableFile file = new UploadableFile("file.txt", content, "text/plain");

                multipart.addFile("document", file);

                assertEquals(1, multipart.getFiles().size());
                assertEquals(-1, multipart.getFiles().get("document").getContentLength());
            }
        }

        @Nested
        class WithInvalidFile {

            @Test
            void shouldThrowExceptionForNullFile() {
                MultipartFormDataObject multipart = new MultipartFormDataObject();

                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> multipart.addFile("file", null));

                assertEquals("file is required", exception.getMessage());
            }

            @Test
            void shouldThrowExceptionForNullParameterName() {
                MultipartFormDataObject multipart = new MultipartFormDataObject();
                InputStream content = createTestFileStream("content");
                UploadableFile file = new UploadableFile("file.txt", content, "text/plain");

                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> multipart.addFile(null, file));

                assertEquals("parameterName is required", exception.getMessage());
            }

            @Test
            void shouldThrowExceptionForEmptyParameterName() {
                MultipartFormDataObject multipart = new MultipartFormDataObject();
                InputStream content = createTestFileStream("content");
                UploadableFile file = new UploadableFile("file.txt", content, "text/plain");

                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> multipart.addFile("", file));

                assertEquals("parameterName is required", exception.getMessage());
            }

            @Test
            void shouldThrowExceptionForDuplicateParameterNameWithFile() {
                MultipartFormDataObject multipart = new MultipartFormDataObject();
                InputStream firstContent = createTestFileStream("firstContent");
                InputStream secondContent = createTestFileStream("secondContent");
                UploadableFile firstFile = new UploadableFile("first.txt", firstContent, "text/plain");
                UploadableFile secondFile = new UploadableFile("second.txt", secondContent, "text/plain");

                multipart.addFile("document", firstFile);

                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> multipart.addFile("document", secondFile));

                assertEquals("duplicate parameterName: document", exception.getMessage());
            }

            @Test
            void shouldThrowExceptionForDuplicateParameterNameWithValue() {
                MultipartFormDataObject multipart = new MultipartFormDataObject();
                InputStream content = createTestFileStream("content");
                UploadableFile file = new UploadableFile("file.txt", content, "text/plain");

                multipart.addValue("field", "value");

                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> multipart.addFile("field", file));

                assertEquals("duplicate parameterName: field", exception.getMessage());
            }
        }
    }

    @Nested
    class WhenAddingValues {

        @Nested
        class WithValidValue {

            @Test
            void shouldAddSingleValue() {
                MultipartFormDataObject multipart = new MultipartFormDataObject();

                multipart.addValue("key", "value");

                assertEquals(1, multipart.getValues().size());
                assertTrue(multipart.getValues().containsKey("key"));
                assertEquals("value", multipart.getValues().get("key"));
            }

            @Test
            void shouldAddMultipleValues() {
                MultipartFormDataObject multipart = new MultipartFormDataObject();

                multipart.addValue("firstKey", "firstValue");
                multipart.addValue("secondKey", "secondValue");
                multipart.addValue("thirdKey", "thirdValue");

                assertEquals(3, multipart.getValues().size());
                assertEquals("firstValue", multipart.getValues().get("firstKey"));
                assertEquals("secondValue", multipart.getValues().get("secondKey"));
                assertEquals("thirdValue", multipart.getValues().get("thirdKey"));
            }
        }

        @Nested
        class WithInvalidValue {

            @Test
            void shouldThrowExceptionForNullValue() {
                MultipartFormDataObject multipart = new MultipartFormDataObject();

                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> multipart.addValue("key", null));

                assertEquals("value is required", exception.getMessage());
            }

            @Test
            void shouldThrowExceptionForNullParameterName() {
                MultipartFormDataObject multipart = new MultipartFormDataObject();

                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> multipart.addValue(null, "value"));

                assertEquals("parameterName is required", exception.getMessage());
            }

            @Test
            void shouldThrowExceptionForEmptyParameterName() {
                MultipartFormDataObject multipart = new MultipartFormDataObject();

                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> multipart.addValue("", "value"));

                assertEquals("parameterName is required", exception.getMessage());
            }

            @Test
            void shouldThrowExceptionForDuplicateParameterNameWithValue() {
                MultipartFormDataObject multipart = new MultipartFormDataObject();

                multipart.addValue("key", "value1");

                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> multipart.addValue("key", "value2"));

                assertEquals("duplicate parameterName: key", exception.getMessage());
            }

            @Test
            void shouldThrowExceptionForDuplicateParameterNameWithFile() {
                MultipartFormDataObject multipart = new MultipartFormDataObject();
                InputStream content = createTestFileStream("content");
                UploadableFile file = new UploadableFile("file.txt", content, "text/plain");

                multipart.addFile("field", file);

                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> multipart.addValue("field", "value"));

                assertEquals("duplicate parameterName: field", exception.getMessage());
            }
        }
    }

    @Nested
    class WhenVerifyingBoundaryAndContentType {

        @Test
        void shouldGenerateUniqueBoundary() {
            MultipartFormDataObject multipart1 = new MultipartFormDataObject();
            MultipartFormDataObject multipart2 = new MultipartFormDataObject();

            String boundary1 = multipart1.getBoundary();
            String boundary2 = multipart2.getBoundary();

            assertNotNull(boundary1);
            assertNotNull(boundary2);
            assertNotEquals(boundary1, boundary2, "Boundaries should be unique");
        }

        @Test
        void shouldIncludeBoundaryInContentType() {
            MultipartFormDataObject multipart = new MultipartFormDataObject();

            String contentType = multipart.getContentType();
            String boundary = multipart.getBoundary();

            assertTrue(contentType.contains(boundary));
            assertTrue(contentType.startsWith("multipart/form-data; boundary="));
        }

        @Test
        void shouldReturnCorrectMultipartContentType() {
            MultipartFormDataObject multipart = new MultipartFormDataObject();

            String contentType = multipart.getContentType();

            assertTrue(contentType.startsWith("multipart/form-data"));
            assertTrue(contentType.contains("boundary="));
        }
    }

    @Nested
    class WhenCreatingUploadableFile {

        @Nested
        class WithValidInput {

            @Test
            void shouldCreateFileWithKnownLength() {
                InputStream content = createTestFileStream("test content");

                UploadableFile file = new UploadableFile("test.txt", content, "text/plain", 12);

                assertEquals("test.txt", file.getFileName());
                assertEquals("text/plain", file.getContentType());
                assertEquals(12, file.getContentLength());
                assertNotNull(file.getContent());
            }

            @Test
            void shouldCreateFileWithUnknownLength() {
                InputStream content = createTestFileStream("test content");

                UploadableFile file = new UploadableFile("test.txt", content, "text/plain");

                assertEquals("test.txt", file.getFileName());
                assertEquals("text/plain", file.getContentType());
                assertEquals(-1, file.getContentLength());
                assertNotNull(file.getContent());
            }

            @Test
            void shouldNormalizeNegativeLengthToMinusOne() {
                InputStream content = createTestFileStream("content");

                UploadableFile file = new UploadableFile("file.txt", content, "text/plain", -100);

                assertEquals(-1, file.getContentLength());
            }
        }

        @Nested
        class WithInvalidInput {

            @Test
            void shouldThrowExceptionForNullFileName() {
                InputStream content = createTestFileStream("content");

                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new UploadableFile(null, content, "text/plain"));

                assertEquals("fileName is required", exception.getMessage());
            }

            @Test
            void shouldThrowExceptionForEmptyFileName() {
                InputStream content = createTestFileStream("content");

                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new UploadableFile("", content, "text/plain"));

                assertEquals("fileName is required", exception.getMessage());
            }

            @Test
            void shouldThrowExceptionForNullContent() {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new UploadableFile("file.txt", null, "text/plain"));

                assertEquals("content is required", exception.getMessage());
            }

            @Test
            void shouldThrowExceptionForNullContentType() {
                InputStream content = createTestFileStream("content");

                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new UploadableFile("file.txt", content, null));

                assertEquals("contentType is required", exception.getMessage());
            }

            @Test
            void shouldThrowExceptionForEmptyContentType() {
                InputStream content = createTestFileStream("content");

                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> new UploadableFile("file.txt", content, ""));

                assertEquals("contentType is required", exception.getMessage());
            }
        }
    }

    private CommunicatorConfiguration configMockServer() throws URISyntaxException {
        CommunicatorConfiguration configuration = getCommunicatorConfiguration();
        configuration.setApiEndpoint(new URI("http", null, server.getHostName(), server.getPort(), null, null, null));

        return configuration;
    }

    private InputStream createTestFileStream(String content) {
        return new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
    }
}
