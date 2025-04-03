/*
 * This file was automatically generated.
 */

package com.onlinepayments;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import com.onlinepayments.logging.BodyObfuscator;
import com.onlinepayments.logging.CommunicatorLogger;
import com.onlinepayments.logging.HeaderObfuscator;
import com.onlinepayments.merchant.MerchantClient;

/** {@inheritDoc} */
public class Client extends ApiResource implements ClientInterface {

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    public Client(Communicator communicator) {
        this(communicator, null);
    }

    private Client(Communicator communicator, String clientMetaInfo) {
        super(communicator, clientMetaInfo, null);
    }

    /** {@inheritDoc} */
    @Override
    public ClientInterface withClientMetaInfo(String clientMetaInfo) {
        if (this.clientMetaInfo == null && clientMetaInfo == null) {
            return this;
        }
        if (clientMetaInfo == null) {
            return new Client(communicator, null);
        }
        // Checking to see if this is valid JSON (no JSON parse exceptions)
        communicator.getMarshaller().unmarshal(clientMetaInfo, Object.class);

        clientMetaInfo = Base64.getEncoder().encodeToString(clientMetaInfo.getBytes(CHARSET));

        return clientMetaInfo.equals(this.clientMetaInfo) ? this : new Client(communicator, clientMetaInfo);
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
    public void setBodyObfuscator(BodyObfuscator bodyObfuscator) {
        // delegate to the communicator
        communicator.setBodyObfuscator(bodyObfuscator);
    }

    @Override
    public void setHeaderObfuscator(HeaderObfuscator headerObfuscator) {
        // delegate to the communicator
        communicator.setHeaderObfuscator(headerObfuscator);
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
        Map<String, String> subContext = new TreeMap<>();
        subContext.put("merchantId", merchantId);
        return new MerchantClient(this, subContext);
    }
}
