package com.onlinepayments.communication;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import com.onlinepayments.domain.ShoppingCartExtension;
import com.onlinepayments.json.DefaultMarshaller;

/**
 * Provides meta info about the server. Thread-safe.
 */
public class DefaultMetadataProvider implements MetadataProvider {

    private static final String SDK_VERSION = "6.1.0";

    private static final String SERVER_META_INFO_HEADER = "X-GCS-ServerMetaInfo";
    static final Set<String> PROHIBITED_HEADERS;

    static {
        Set<String> prohibitedHeaders = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        prohibitedHeaders.add(SERVER_META_INFO_HEADER);
        prohibitedHeaders.add("X-GCS-Idempotence-Key");
        prohibitedHeaders.add("Date");
        prohibitedHeaders.add("Content-Type");
        prohibitedHeaders.add("Authorization");

        PROHIBITED_HEADERS = Collections.unmodifiableSet(prohibitedHeaders);
    }

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    static final class ServerMetaInfo {
        String platformIdentifier;
        String sdkIdentifier;
        String sdkCreator;
        String integrator;
        ShoppingCartExtension shoppingCartExtension;
    }

    private final Collection<RequestHeader> metadataHeaders;

    public DefaultMetadataProvider(String integrator) {
        this(
                integrator,
                null,
                Collections.emptyList()
        );
    }

    protected DefaultMetadataProvider(MetadataProviderBuilder builder) {
        this(
                builder.integrator,
                builder.shoppingCartExtension,
                builder.additionalRequestHeaders
        );
    }

    private DefaultMetadataProvider(String integrator,
                                    ShoppingCartExtension shoppingCartExtension,
                                    Collection<RequestHeader> additionalRequestHeaders) {

        if (integrator == null || integrator.trim().isEmpty()) {
            throw new IllegalArgumentException("integrator is required");
        }

        validateAdditionalRequestHeaders(additionalRequestHeaders);

        ServerMetaInfo serverMetaInfo = new ServerMetaInfo();
        serverMetaInfo.platformIdentifier = getPlatformIdentifier();
        serverMetaInfo.sdkIdentifier = getSdkIdentifier();
        serverMetaInfo.sdkCreator = "OnlinePayments";
        serverMetaInfo.integrator = integrator;
        serverMetaInfo.shoppingCartExtension = shoppingCartExtension;

        String serverMetaInfoString = DefaultMarshaller.INSTANCE.marshal(serverMetaInfo);
        RequestHeader serverMetaInfoHeader = new RequestHeader(SERVER_META_INFO_HEADER,
                Base64.getEncoder().encodeToString(serverMetaInfoString.getBytes(CHARSET)));

        if (additionalRequestHeaders == null || additionalRequestHeaders.isEmpty()) {
            metadataHeaders = Collections.singleton(serverMetaInfoHeader);
        } else {
            List<RequestHeader> requestHeaders = new ArrayList<>(additionalRequestHeaders.size() + 1);
            requestHeaders.add(serverMetaInfoHeader);
            requestHeaders.addAll(additionalRequestHeaders);
            metadataHeaders = Collections.unmodifiableList(requestHeaders);
        }
    }

    static void validateAdditionalRequestHeaders(Collection<RequestHeader> additionalRequestHeaders) {
        if (additionalRequestHeaders != null) {
            for (RequestHeader additionalRequestHeader : additionalRequestHeaders) {
                validateAdditionalRequestHeader(additionalRequestHeader);
            }
        }
    }

    static void validateAdditionalRequestHeader(RequestHeader additionalRequestHeader) {
        if (PROHIBITED_HEADERS.contains(additionalRequestHeader.getName())) {
            throw new IllegalArgumentException("request header not allowed: " + additionalRequestHeader);
        }
    }

    /**
     * @return The server related headers containing the metadata to be associated with the request (if any).
     * This will always contain at least an automatically generated header {@code X-GCS-ServerMetaInfo}.
     */
    public final Collection<RequestHeader> getServerMetadataHeaders() {
        return metadataHeaders;
    }

    protected final String getPlatformIdentifier() {
        Properties properties = System.getProperties();
        StringBuilder sb = new StringBuilder();
        sb.append(properties.get("os.name"));
        sb.append("/");
        sb.append(properties.get("os.version"));
        sb.append(" ");
        sb.append("Java");
        sb.append("/");
        sb.append(properties.get("java.vm.specification.version"));
        sb.append(" ");
        sb.append("(");
        sb.append(properties.get("java.vm.vendor"));
        sb.append("; ");
        sb.append(properties.get("java.vm.name"));
        sb.append("; ");
        sb.append(properties.get("java.version"));
        sb.append(")");
        return sb.toString();
    }

    protected final String getSdkIdentifier() {
        return "JavaServerSDK/v" + SDK_VERSION;
    }
}
