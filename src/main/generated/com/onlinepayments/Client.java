/*
 * This class was auto-generated.
 */
package com.onlinepayments;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;

import com.onlinepayments.logging.CommunicatorLogger;
import com.onlinepayments.merchant.MerchantClient;

/** {@inheritDoc} */
public class Client extends ApiResource implements ClientInterface {

	public static final String API_VERSION = "v2";

	private static final Charset CHARSET = Charset.forName("UTF-8");

	public Client(Communicator communicator) {
		this(communicator, null);
	}

	private Client(Communicator communicator, String clientMetaInfo) {
		super(communicator, clientMetaInfo, null);
	}

	/** {@inheritDoc} */
	@Override
	public Client withClientMetaInfo(String clientMetaInfo) {

		if (this.clientMetaInfo == null && clientMetaInfo == null) {
			return this;
		} else if (clientMetaInfo == null) {
			return new Client(communicator, null);
		} else {
			// Checking to see if this is valid JSON (no JSON parse exceptions)
			communicator.getMarshaller().unmarshal(clientMetaInfo, Object.class);

			clientMetaInfo = Base64.encodeBase64String(clientMetaInfo.getBytes(CHARSET));

			if (clientMetaInfo.equals(this.clientMetaInfo)) {
				return this;
			} else {
				return new Client(communicator, clientMetaInfo);
			}
		}
	}

	/** {@inheritDoc} */
	@Override
	public void closeIdleConnections(long idleTime, TimeUnit timeUnit) {
		communicator.closeIdleConnections(idleTime, timeUnit);
	}

	/** {@inheritDoc} */
	@Override
	public void closeExpiredConnections() {
		communicator.closeExpiredConnections();
	}

	@Override
	public void enableLogging(CommunicatorLogger communicatorLogger) {
		// delegate to the communicator
		communicator.enableLogging(communicatorLogger);
	}

	@Override
	public void disableLogging() {
		// delegate to the communicator
		communicator.disableLogging();
	}

	/**
	 * Releases any system resources associated with this object.
	 */
	@Override
	public void close() throws IOException {
		communicator.close();
	}

	/** {@inheritDoc} */
	@Override
	public MerchantClient merchant(String merchantId) {
		Map<String, String> subContext = new TreeMap<String, String>();
		subContext.put("merchantId", merchantId);
		return new MerchantClient(this, subContext);
	}
}
