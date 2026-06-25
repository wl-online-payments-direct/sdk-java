package com.onlinepayments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.onlinepayments.communication.RequestHeader;

class ApiResourceTest {

    /**
     * Concrete implementation of ApiResource for testing.
     */
    private static class TestApiResource extends ApiResource {

        TestApiResource(ApiResource parent, Map<String, String> pathContext) {
            super(parent, pathContext);
        }

        TestApiResource(Communicator communicator, String clientMetaInfo, Map<String, String> pathContext) {
            super(communicator, clientMetaInfo, pathContext);
        }
    }

    @Nested
    class WhenConstructingWithParent {

        @Test
        void shouldThrowExceptionWhenParentIsNull() {
            assertThrows(IllegalArgumentException.class, () -> new TestApiResource(null, new HashMap<>()));
        }

        @Test
        void shouldCreateInstanceWithParent() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            ApiResource parent = new TestApiResource(mockCommunicator, "meta-info", new HashMap<>());

            ApiResource child = new TestApiResource(parent, new HashMap<>());

            assertNotNull(child);
        }

        @Test
        void shouldInheritCommunicatorFromParent() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            ApiResource parent = new TestApiResource(mockCommunicator, null, new HashMap<>());

            ApiResource child = new TestApiResource(parent, new HashMap<>());

            assertEquals(mockCommunicator, child.communicator);
        }

        @Test
        void shouldInheritClientMetaInfoFromParent() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            String clientMetaInfo = "test-meta-info";
            ApiResource parent = new TestApiResource(mockCommunicator, clientMetaInfo, new HashMap<>());

            ApiResource child = new TestApiResource(parent, new HashMap<>());

            assertEquals(clientMetaInfo, child.clientMetaInfo);
        }

        @Test
        void shouldAcceptNullPathContext() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            ApiResource parent = new TestApiResource(mockCommunicator, null, new HashMap<>());

            ApiResource child = new TestApiResource(parent, null);

            assertNotNull(child);
        }
    }

    @Nested
    class WhenConstructingAsRoot {

        @Test
        void shouldThrowExceptionWhenCommunicatorIsNull() {
            assertThrows(IllegalArgumentException.class, () -> new TestApiResource(null, "meta-info", new HashMap<>()));
        }

        @Test
        void shouldCreateInstanceWithValidCommunicator() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);

            ApiResource resource = new TestApiResource(mockCommunicator, null, new HashMap<>());

            assertNotNull(resource);
        }

        @Test
        void shouldStoreCommunicator() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);

            ApiResource resource = new TestApiResource(mockCommunicator, "meta", new HashMap<>());

            assertEquals(mockCommunicator, resource.communicator);
        }

        @Test
        void shouldStoreClientMetaInfo() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            String clientMetaInfo = "custom-meta-info";

            ApiResource resource = new TestApiResource(mockCommunicator, clientMetaInfo, new HashMap<>());

            assertEquals(clientMetaInfo, resource.clientMetaInfo);
        }

        @Test
        void shouldAcceptNullClientMetaInfo() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);

            ApiResource resource = new TestApiResource(mockCommunicator, null, new HashMap<>());

            assertNull(resource.clientMetaInfo);
        }

        @Test
        void shouldAcceptNullPathContext() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);

            ApiResource resource = new TestApiResource(mockCommunicator, "meta", null);

            assertNotNull(resource);
        }
    }

    @Nested
    class WhenGettingClientHeaders {

        @Test
        void shouldReturnEmptyListWhenClientMetaInfoIsNull() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            ApiResource resource = new TestApiResource(mockCommunicator, null, new HashMap<>());

            List<RequestHeader> headers = resource.getClientHeaders();

            assertEquals(0, headers.size());
        }

        @Test
        void shouldReturnHeaderListWhenClientMetaInfoProvided() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            String clientMetaInfo = "test-meta-info";
            ApiResource resource = new TestApiResource(mockCommunicator, clientMetaInfo, new HashMap<>());

            List<RequestHeader> headers = resource.getClientHeaders();

            assertEquals(1, headers.size());
        }

        @Test
        void shouldHaveCorrectHeaderName() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            ApiResource resource = new TestApiResource(mockCommunicator, "meta", new HashMap<>());

            List<RequestHeader> headers = resource.getClientHeaders();

            assertEquals(1, headers.size());
            assertEquals("X-GCS-ClientMetaInfo", headers.get(0).getName());
        }

        @Test
        void shouldHaveCorrectHeaderValue() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            String clientMetaInfo = "my-custom-meta-info";
            ApiResource resource = new TestApiResource(mockCommunicator, clientMetaInfo, new HashMap<>());

            List<RequestHeader> headers = resource.getClientHeaders();

            assertEquals(clientMetaInfo, headers.get(0).getValue());
        }

        @Test
        void shouldReturnNewListEachTime() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            ApiResource resource = new TestApiResource(mockCommunicator, "meta", new HashMap<>());

            List<RequestHeader> headers1 = resource.getClientHeaders();
            List<RequestHeader> headers2 = resource.getClientHeaders();

            assertNotSame(headers1, headers2);
        }
    }

    @Nested
    class WhenInstantiatingUri {

        @Test
        void shouldReplaceSinglePathPlaceholder() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            Map<String, String> pathContext = new HashMap<>();
            pathContext.put("id", "123");
            ApiResource resource = new TestApiResource(mockCommunicator, null, pathContext);

            String result = resource.instantiateUri("/api/{id}/details", new HashMap<>());

            assertEquals("/api/123/details", result);
        }

        @Test
        void shouldReplaceMultiplePlaceholders() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            Map<String, String> pathContext = new HashMap<>();
            pathContext.put("version", "v1");
            pathContext.put("resource", "payments");
            ApiResource resource = new TestApiResource(mockCommunicator, null, pathContext);

            String result = resource.instantiateUri("/{version}/{resource}", new HashMap<>());

            assertEquals("/v1/payments", result);
        }

        @Test
        void shouldHandleNullPathContext() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            ApiResource resource = new TestApiResource(mockCommunicator, null, null);

            String result = resource.instantiateUri("/api/resource", new HashMap<>());

            assertEquals("/api/resource", result);
        }

        @Test
        void shouldReplaceFromSuppliedContext() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            ApiResource resource = new TestApiResource(mockCommunicator, null, new HashMap<>());

            Map<String, String> context = new HashMap<>();
            context.put("id", "456");
            String result = resource.instantiateUri("/user/{id}/profile", context);

            assertEquals("/user/456/profile", result);
        }

        @Test
        void shouldUseResourcePathContextFirst() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            Map<String, String> pathContext = new HashMap<>();
            pathContext.put("id", "parent-123");
            ApiResource resource = new TestApiResource(mockCommunicator, null, pathContext);

            String result = resource.instantiateUri("/{id}", new HashMap<>());

            assertEquals("/parent-123", result);
        }

        @Test
        void shouldHandleUriWithoutPlaceholders() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            ApiResource resource = new TestApiResource(mockCommunicator, null, new HashMap<>());

            String result = resource.instantiateUri("/api/resource", new HashMap<>());

            assertEquals("/api/resource", result);
        }

        @Test
        void shouldChainParentInstantiation() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            Map<String, String> parentContext = new HashMap<>();
            parentContext.put("tenantId", "tenant-001");
            ApiResource parent = new TestApiResource(mockCommunicator, null, parentContext);

            Map<String, String> childContext = new HashMap<>();
            childContext.put("resourceId", "resource-123");
            ApiResource child = new TestApiResource(parent, childContext);

            String result = child.instantiateUri("/tenants/{tenantId}/resources/{resourceId}", new HashMap<>());

            assertEquals("/tenants/tenant-001/resources/resource-123", result);
        }
    }

    @Nested
    class WhenReplacingPathContext {

        @Test
        void shouldReplaceAllOccurrencesOfPlaceholder() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            Map<String, String> pathContext = new HashMap<>();
            pathContext.put("id", "999");
            ApiResource resource = new TestApiResource(mockCommunicator, null, pathContext);

            String result = resource.instantiateUri("/{id}/nested/{id}/deep", new HashMap<>());

            assertEquals("/999/nested/999/deep", result);
        }

        @Test
        void shouldPreservePlaceholdersNotInContext() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            Map<String, String> pathContext = new HashMap<>();
            pathContext.put("id", "123");
            ApiResource resource = new TestApiResource(mockCommunicator, null, pathContext);

            String result = resource.instantiateUri("/{id}/{unknown}", new HashMap<>());

            assertEquals("/123/{unknown}", result);
        }

        @Test
        void shouldHandleEmptyPathContext() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            ApiResource resource = new TestApiResource(mockCommunicator, null, new HashMap<>());

            String result = resource.instantiateUri("/api/{id}/resource", new HashMap<>());

            assertEquals("/api/{id}/resource", result);
        }

        @Test
        void shouldHandleSpecialCharactersInValues() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            Map<String, String> pathContext = new HashMap<>();
            pathContext.put("id", "abc-123-def");
            ApiResource resource = new TestApiResource(mockCommunicator, null, pathContext);

            String result = resource.instantiateUri("/resource/{id}/detail", new HashMap<>());

            assertEquals("/resource/abc-123-def/detail", result);
        }

        @Test
        void shouldHandleNumericValues() {
            Communicator mockCommunicator = Mockito.mock(Communicator.class);
            Map<String, String> pathContext = new HashMap<>();
            pathContext.put("version", "2");
            pathContext.put("id", "12345");
            ApiResource resource = new TestApiResource(mockCommunicator, null, pathContext);

            String result = resource.instantiateUri("/v{version}/resource/{id}", new HashMap<>());

            assertEquals("/v2/resource/12345", result);
        }
    }
}
