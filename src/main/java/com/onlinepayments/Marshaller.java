package com.onlinepayments;

import java.io.InputStream;

/**
 * Used to marshal and unmarshal Online Payments platform request and response objects to and from JSON. Thread-safe.
 */
public interface Marshaller {

	/**
	 * Marshal a request object to a JSON string.
	 *
	 * @param requestObject The request object used for marshalling to JSON string
	 * @return A JSON string of the marshalled request object
	 */
	String marshal(Object requestObject);

	/**
	 * Unmarshal a JSON string to a response object.
	 *
	 * @param responseJson Response JSON string used for unmarshalling to an object of type T
	 * @param type The response object type.
	 * @return An instance of object of type T
	 * @param <T> The type of the response object
	 * @throws MarshallerSyntaxException if the JSON is not a valid representation for an object of the given type
	 */
	<T> T unmarshal(String responseJson, Class<T> type);

	/**
	 * Unmarshal a JSON stream to a response object.
	 *
	 * @param responseJson Response JSON string used for unmarshalling to an object of type T
	 * @param type The response object type.
	 * @return An instance of object of type T
	 * @param <T> The type of the response object
	 * @throws MarshallerSyntaxException if the JSON is not a valid representation for an object of the given type
	 */
	<T> T unmarshal(InputStream responseJson, Class<T> type);
}
