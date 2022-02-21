/*
 * This class was auto-generated.
 */
package com.onlinepayments;

import java.io.Closeable;
import java.util.concurrent.TimeUnit;

import com.onlinepayments.logging.LoggingCapable;
import com.onlinepayments.merchant.MerchantClientInterface;

/**
 * Payment platform client.
 * <p>
 * This client and all its child clients are bound to one specific value for the <i>X-GCS-ClientMetaInfo</i> header.
 * To get a new client with a different header value, use {@link #withClientMetaInfo(String)}.
 * <p>
 * Thread-safe.
 */
public interface ClientInterface extends Closeable, LoggingCapable {

	/**
	 * Returns a new {@link Client} which uses the passed meta data for the
	 * <i>X-GCS-ClientMetaInfo</i> header.
	 *
	 * @param clientMetaInfo
	 *            JSON string containing the meta data for the client
	 * @throws MarshallerSyntaxException
	 *            if the given clientMetaInfo is not a valid JSON string
	 */
	Client withClientMetaInfo(String clientMetaInfo);

	/**
	 * Utility method that delegates the call to this client's communicator.
	 * @see Communicator#closeIdleConnections(long, TimeUnit)
	 * @see PooledConnection#closeIdleConnections(long, TimeUnit)
	 */
	void closeIdleConnections(long idleTime, TimeUnit timeUnit);

	/**
	 * Utility method that delegates the call to this client's communicator.
	 * @see Communicator#closeExpiredConnections()
	 * @see PooledConnection#closeExpiredConnections()
	 */
	void closeExpiredConnections();

	/**
	 * Resource /v2/{merchantId}
	 *
	 */
	MerchantClientInterface merchant(String merchantId);
}
