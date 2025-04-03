package com.onlinepayments.communication;

/**
 * Represents a multipart/form-data request.
 */
public interface MultipartFormDataRequest {

    MultipartFormDataObject toMultipartFormDataObject();
}
