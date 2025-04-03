package com.onlinepayments.communication;

import java.util.List;

/**
 * Represents a set of request parameters.
 */
public interface ParamRequest {

    List<RequestParam> toRequestParameters();
}
