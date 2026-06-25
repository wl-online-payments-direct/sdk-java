package com.onlinepayments.communication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.domain.UploadableFile;

class MultipartFormDataObjectTest {

    @Nested
    @DisplayName("Constructor")
    class WhenConstructing {

        @Test
        void shouldInitializeWithValidBoundaryAndContentType() {
            MultipartFormDataObject object = new MultipartFormDataObject();

            assertNotNull(object.getBoundary());
            assertNotNull(object.getContentType());
            assertTrue(object.getContentType().startsWith("multipart/form-data; boundary="));
            assertTrue(object.getContentType().contains(object.getBoundary()));
        }
    }

    @Nested
    @DisplayName("Getting Properties")
    class WhenGettingProperties {

        @Test
        void shouldReturnBoundaryString() {
            MultipartFormDataObject object = new MultipartFormDataObject();
            String boundary = object.getBoundary();

            assertNotNull(boundary);
            assertFalse(boundary.isEmpty());
        }

        @Test
        void shouldReturnContentTypeWithBoundary() {
            MultipartFormDataObject object = new MultipartFormDataObject();
            String contentType = object.getContentType();

            assertNotNull(contentType);
            assertEquals("multipart/form-data; boundary=" + object.getBoundary(), contentType);
        }

        @Test
        void shouldReturnEmptyValuesMapInitially() {
            MultipartFormDataObject object = new MultipartFormDataObject();
            Map<String, String> values = object.getValues();

            assertNotNull(values);
            assertTrue(values.isEmpty());
        }

        @Test
        void shouldReturnEmptyFilesMapInitially() {
            MultipartFormDataObject object = new MultipartFormDataObject();
            Map<String, UploadableFile> files = object.getFiles();

            assertNotNull(files);
            assertTrue(files.isEmpty());
        }
    }

    @Nested
    @DisplayName("Adding Values")
    class WhenAddingValues {

        @Test
        void shouldAddSingleValue() {
            MultipartFormDataObject object = new MultipartFormDataObject();

            object.addValue("fieldName", "fieldValue");

            assertEquals(1, object.getValues().size());
            assertEquals("fieldValue", object.getValues().get("fieldName"));
        }

        @Test
        void shouldAddMultipleValues() {
            MultipartFormDataObject object = new MultipartFormDataObject();

            object.addValue("field1", "value1");
            object.addValue("field2", "value2");
            object.addValue("field3", "value3");

            assertEquals(3, object.getValues().size());
            assertEquals("value1", object.getValues().get("field1"));
            assertEquals("value2", object.getValues().get("field2"));
            assertEquals("value3", object.getValues().get("field3"));
        }

        @Test
        void shouldThrowExceptionWhenParameterNameIsNull() {
            MultipartFormDataObject object = new MultipartFormDataObject();

            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> object.addValue(null, "value")
            );
            assertEquals("parameterName is required", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenParameterNameIsEmpty() {
            MultipartFormDataObject object = new MultipartFormDataObject();

            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> object.addValue("", "value")
            );
            assertEquals("parameterName is required", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenParameterNameIsWhitespace() {
            MultipartFormDataObject object = new MultipartFormDataObject();

            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> object.addValue("   ", "value")
            );
            assertEquals("parameterName is required", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenValueIsNull() {
            MultipartFormDataObject object = new MultipartFormDataObject();

            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> object.addValue("fieldName", null)
            );
            assertEquals("value is required", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenAddingDuplicateValue() {
            MultipartFormDataObject object = new MultipartFormDataObject();
            object.addValue("fieldName", "value1");

            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> object.addValue("fieldName", "value2")
            );
            assertEquals("duplicate parameterName: fieldName", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Adding Files")
    class WhenAddingFiles {

        @Test
        void shouldAddSingleFile() {
            MultipartFormDataObject object = new MultipartFormDataObject();
            InputStream content = new ByteArrayInputStream("test content".getBytes());
            UploadableFile file = new UploadableFile("test.txt", content, "text/plain");

            object.addFile("fileName", file);

            assertEquals(1, object.getFiles().size());
            assertEquals(file, object.getFiles().get("fileName"));
        }

        @Test
        void shouldAddMultipleFiles() {
            MultipartFormDataObject object = new MultipartFormDataObject();
            InputStream content1 = new ByteArrayInputStream("content1".getBytes());
            InputStream content2 = new ByteArrayInputStream("content2".getBytes());
            InputStream content3 = new ByteArrayInputStream("content3".getBytes());
            UploadableFile file1 = new UploadableFile("file1.txt", content1, "text/plain");
            UploadableFile file2 = new UploadableFile("file2.txt", content2, "text/plain");
            UploadableFile file3 = new UploadableFile("file3.txt", content3, "text/plain");

            object.addFile("file1", file1);
            object.addFile("file2", file2);
            object.addFile("file3", file3);

            assertEquals(3, object.getFiles().size());
            assertEquals(file1, object.getFiles().get("file1"));
            assertEquals(file2, object.getFiles().get("file2"));
            assertEquals(file3, object.getFiles().get("file3"));
        }

        @Test
        void shouldThrowExceptionWhenParameterNameIsNull() {
            MultipartFormDataObject object = new MultipartFormDataObject();
            InputStream content = new ByteArrayInputStream("content".getBytes());
            UploadableFile file = new UploadableFile("test.txt", content, "text/plain");

            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> object.addFile(null, file)
            );
            assertEquals("parameterName is required", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenParameterNameIsEmpty() {
            MultipartFormDataObject object = new MultipartFormDataObject();
            InputStream content = new ByteArrayInputStream("content".getBytes());
            UploadableFile file = new UploadableFile("test.txt", content, "text/plain");

            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> object.addFile("", file)
            );
            assertEquals("parameterName is required", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenParameterNameIsWhitespace() {
            MultipartFormDataObject object = new MultipartFormDataObject();
            InputStream content = new ByteArrayInputStream("content".getBytes());
            UploadableFile file = new UploadableFile("test.txt", content, "text/plain");

            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> object.addFile("   ", file)
            );
            assertEquals("parameterName is required", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenFileIsNull() {
            MultipartFormDataObject object = new MultipartFormDataObject();

            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> object.addFile("fileName", null)
            );
            assertEquals("file is required", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenAddingDuplicateFile() {
            MultipartFormDataObject object = new MultipartFormDataObject();
            InputStream content1 = new ByteArrayInputStream("content1".getBytes());
            InputStream content2 = new ByteArrayInputStream("content2".getBytes());
            UploadableFile file1 = new UploadableFile("file1.txt", content1, "text/plain");
            UploadableFile file2 = new UploadableFile("file2.txt", content2, "text/plain");

            object.addFile("fileName", file1);

            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> object.addFile("fileName", file2)
            );
            assertEquals("duplicate parameterName: fileName", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Mixing Values and Files")
    class WhenMixingValuesAndFiles {

        @Test
        void shouldThrowExceptionWhenAddingValueForExistingFileParameter() {
            MultipartFormDataObject object = new MultipartFormDataObject();
            InputStream content = new ByteArrayInputStream("content".getBytes());
            UploadableFile file = new UploadableFile("test.txt", content, "text/plain");

            object.addFile("paramName", file);

            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> object.addValue("paramName", "value")
            );
            assertEquals("duplicate parameterName: paramName", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenAddingFileForExistingValueParameter() {
            MultipartFormDataObject object = new MultipartFormDataObject();
            object.addValue("paramName", "value");

            InputStream content = new ByteArrayInputStream("content".getBytes());
            UploadableFile file = new UploadableFile("test.txt", content, "text/plain");

            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> object.addFile("paramName", file)
            );
            assertEquals("duplicate parameterName: paramName", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Unmodifiable Map Behavior")
    class WhenAccessingMaps {

        @Test
            void shouldReturnUnmodifiableValuesMap() {
            MultipartFormDataObject object = new MultipartFormDataObject();
            object.addValue("key", "value");

            Map<String, String> values = object.getValues();

            assertThrows(
                    UnsupportedOperationException.class,
                    () -> values.put("newKey", "newValue")
            );
        }

        @Test
        void shouldReturnUnmodifiableFilesMap() {
            MultipartFormDataObject object = new MultipartFormDataObject();
            InputStream content = new ByteArrayInputStream("content".getBytes());
            UploadableFile file = new UploadableFile("test.txt", content, "text/plain");
            object.addFile("key", file);

            Map<String, UploadableFile> files = object.getFiles();

            assertThrows(
                    UnsupportedOperationException.class,
                    () -> files.put("newKey", file)
            );
        }
    }
}
