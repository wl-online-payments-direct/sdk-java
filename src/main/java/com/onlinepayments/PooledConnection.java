package com.onlinepayments;

import java.util.concurrent.TimeUnit;

/**
 * Represents a pooled connection to the Online Payments platform server.
 * Instead of setting up a new HTTP connection for each request, this connection uses a pool of HTTP connections.
 * Thread-safe.
 */
public interface PooledConnection extends Connection {

	/**
	 * Closes all HTTP connections that have been idle for the specified time.
	 * This should also include all expired HTTP connections.
	 * @see #closeExpiredConnections()
	 *
	 * @param idleTime Idle time after which the HTTP connection will be closed
	 * @param timeUnit Time unit of the idle time
	 */
	void closeIdleConnections(long idleTime, TimeUnit timeUnit);

	/**
	 * Closes all expired HTTP connections.
	 */
	void closeExpiredConnections();
}
