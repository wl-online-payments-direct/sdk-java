package com.onlinepayments;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.onlinepayments.communication.RequestHeader;

/**
 * Base class of all Online Payments platform API resources.
 */
public abstract class ApiResource {

    private final ApiResource parent;
    protected final Communicator communicator;
    private final Map<String, String> pathContext;
    protected final String clientMetaInfo;

    protected ApiResource(ApiResource parent, Map<String, String> pathContext) {
        if (parent == null) {
            throw new IllegalArgumentException("parent is required");
        }
        this.parent = parent;
        this.communicator = parent.communicator;
        this.pathContext = pathContext;
        this.clientMetaInfo = parent.clientMetaInfo;
    }

    protected ApiResource(Communicator communicator, String clientMetaInfo, Map<String, String> pathContext) {
        if (communicator == null) {
            throw new IllegalArgumentException("communicator is required");
        }
        this.parent = null;
        this.communicator = communicator;
        this.pathContext = pathContext;
        this.clientMetaInfo = clientMetaInfo;
    }

    protected List<RequestHeader> getClientHeaders() {
        List<RequestHeader> clientHeaders = new ArrayList<>();
        if (clientMetaInfo != null) {
            clientHeaders.add(new RequestHeader("X-GCS-ClientMetaInfo", clientMetaInfo));
        }
        return clientHeaders;
    }

    protected String instantiateUri(String uri, Map<String, String> pathContext) {
        uri = replaceAll(uri, pathContext);
        uri = instantiateUri(uri);
        return uri;
    }

    private String instantiateUri(String uri) {
        uri = replaceAll(uri, pathContext);
        if (parent != null) {
            uri = parent.instantiateUri(uri);
        }
        return uri;
    }

    private static String replaceAll(String uri, Map<String, String> pathContext) {
        if (pathContext != null) {
            for (Map.Entry<String, String> entry : pathContext.entrySet()) {
                uri = uri.replace(String.format("{%s}", entry.getKey()), entry.getValue());
            }
        }
        return uri;
    }
}
