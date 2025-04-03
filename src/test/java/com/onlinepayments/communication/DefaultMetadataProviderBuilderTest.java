package com.onlinepayments.communication;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.onlinepayments.util.RequestHeaderMatcher;

class DefaultMetadataProviderBuilderTest {

    @Nested
    @TestInstance(Lifecycle.PER_CLASS)
    class WithAdditionalRequestHeader {

        @ParameterizedTest
        @MethodSource("prohibitedHeaders")
        void testWithProhibitedHeader(String headerName) {
            RequestHeader additionalRequestHeader = new RequestHeader(headerName, UUID.randomUUID().toString());

            MetadataProviderBuilder builder = new MetadataProviderBuilder("OnlinePayments");

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> builder.withAdditionalRequestHeader(additionalRequestHeader));

            assertThat(exception.getMessage(), containsString(headerName));
        }

        @ParameterizedTest
        @MethodSource("nonProhibitedHeaders")
        void testWithNonProhibitedHeader(String headerName) {
            RequestHeader additionalRequestHeader = new RequestHeader(headerName, UUID.randomUUID().toString());

            MetadataProviderBuilder builder = new MetadataProviderBuilder("OnlinePayments");

            MetadataProvider metadataProvider = builder.withAdditionalRequestHeader(additionalRequestHeader).build();
            Collection<RequestHeader> requestHeaders = metadataProvider.getServerMetadataHeaders();
            assertEquals(2, requestHeaders.size());

            Iterator<RequestHeader> requestHeaderIterator = requestHeaders.iterator();
            RequestHeader requestHeader = requestHeaderIterator.next();
            assertEquals("X-GCS-ServerMetaInfo", requestHeader.getName());

            requestHeader = requestHeaderIterator.next();
            assertThat(requestHeader, new RequestHeaderMatcher(additionalRequestHeader));
        }

        Collection<String> prohibitedHeaders() {
            return DefaultMetadataProvider.PROHIBITED_HEADERS;
        }

        Collection<String> nonProhibitedHeaders() {
            return Arrays.asList("Dummy", "Accept", "If-None-Match", "If-Modified-Since");
        }
    }
}
