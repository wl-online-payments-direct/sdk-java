package com.onlinepayments.communication;

import java.util.Collection;

public interface MetadataProvider {
    Collection<RequestHeader> getServerMetadataHeaders();
}
