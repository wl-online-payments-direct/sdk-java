package com.onlinepayments;

/**
 * Represents a multipart/form-data request.
 */
public interface MultipartFormDataRequest {

    MultipartFormDataObject toMultipartFormDataObject();
}
