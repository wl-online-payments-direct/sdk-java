package com.onlinepayments.json;

import java.io.InputStream;

/**
 * Used to marshal and unmarshal Online Payments platform request and response objects to and from JSON. Thread-safe.
 */
public interface Marshaller {

    /**
     * Marshal a request object to a JSON string.
     */
    String marshal(Object requestObject);

    /**
     * Unmarshal a JSON string to a response object.
     *
     * @param type The response object type.
     * @throws MarshallerSyntaxException if the JSON is not a valid representation for an object of the given type
     */
    <T> T unmarshal(String responseJson, Class<T> type);

    /**
     * Unmarshal a JSON stream to a response object.
     *
     * @param type The response object type.
     * @throws MarshallerSyntaxException if the JSON is not a valid representation for an object of the given type
     */
    <T> T unmarshal(InputStream responseJson, Class<T> type);
}
