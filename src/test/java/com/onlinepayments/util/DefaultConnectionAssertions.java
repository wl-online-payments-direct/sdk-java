package com.onlinepayments.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.SystemDefaultCredentialsProvider;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;

import com.onlinepayments.ProxyConfiguration;
import com.onlinepayments.communication.DefaultConnection;

public final class DefaultConnectionAssertions {

    private DefaultConnectionAssertions() {
    }

    public static void assertConnection(DefaultConnection connection, int connectTimeout, int socketTimeout, int maxConnections, ProxyConfiguration proxyConfiguration) {
        assertRequestConfig(connection, connectTimeout, socketTimeout);
        assertMaxConnections(connection, maxConnections, proxyConfiguration);
        if (proxyConfiguration != null) {
            assertProxy(connection, proxyConfiguration);
        } else {
            assertNoProxy(connection);
        }
    }

    public static void assertRequestConfig(DefaultConnection connection, int connectTimeout, int socketTimeout) {
        RequestConfig requestConfig = ReflectionUtil.getField(connection, "requestConfig", RequestConfig.class);
        assertEquals(connectTimeout, requestConfig.getConnectTimeout());
        assertEquals(socketTimeout, requestConfig.getSocketTimeout());
    }

    @SuppressWarnings("resource")
    public static void assertMaxConnections(DefaultConnection connection, int maxConnections, ProxyConfiguration proxyConfiguration) {
        CloseableHttpClient httpClient = ReflectionUtil.getField(connection, "httpClient", CloseableHttpClient.class);
        PoolingHttpClientConnectionManager connectionManager = ReflectionUtil.getField(httpClient, "connManager", PoolingHttpClientConnectionManager.class);
        assertEquals(maxConnections, connectionManager.getDefaultMaxPerRoute());
        assertTrue(maxConnections <= connectionManager.getMaxTotal());

        HttpHost target = new HttpHost("payment.preprod.online-payments.com", -1, "https");
        HttpHost proxy = proxyConfiguration != null ? new HttpHost(proxyConfiguration.getHost(), proxyConfiguration.getPort(), proxyConfiguration.getScheme()) : null;
        HttpRoute route = proxy != null ? new HttpRoute(target, proxy) : new HttpRoute(target);
        assertEquals(maxConnections, connectionManager.getMaxPerRoute(route));
    }

    @SuppressWarnings("resource")
    public static void assertNoProxy(DefaultConnection connection) {
        CloseableHttpClient httpClient = ReflectionUtil.getField(connection, "httpClient", CloseableHttpClient.class);
        // don't inspect the route planner any further
        ReflectionUtil.getField(httpClient, "routePlanner", SystemDefaultRoutePlanner.class);
        // don't inspect the credentials provider any further
        ReflectionUtil.getField(httpClient, "credentialsProvider", SystemDefaultCredentialsProvider.class);
    }

    @SuppressWarnings("resource")
    public static void assertProxy(DefaultConnection connection, ProxyConfiguration proxyConfiguration) {
        CloseableHttpClient httpClient = ReflectionUtil.getField(connection, "httpClient", CloseableHttpClient.class);
        DefaultProxyRoutePlanner routePlanner = ReflectionUtil.getField(httpClient, "routePlanner", DefaultProxyRoutePlanner.class);
        HttpHost proxy = ReflectionUtil.getField(routePlanner, "proxy", HttpHost.class);
        assertEquals(proxyConfiguration.getScheme(), proxy.getSchemeName());
        assertEquals(proxyConfiguration.getPort(), proxy.getPort());

        BasicCredentialsProvider credentialsProvider = ReflectionUtil.getField(httpClient, "credentialsProvider", BasicCredentialsProvider.class);
        AuthScope authScope = new AuthScope(proxy);
        Credentials credentials = credentialsProvider.getCredentials(authScope);
        if (proxyConfiguration.getUsername() != null) {

            assertTrue(credentials instanceof UsernamePasswordCredentials);
            UsernamePasswordCredentials usernamePasswordCredentials = (UsernamePasswordCredentials) credentials;
            assertEquals(proxyConfiguration.getUsername(), usernamePasswordCredentials.getUserName());
            assertEquals(proxyConfiguration.getPassword(), usernamePasswordCredentials.getPassword());

        } else {
            assertNull(credentials);
        }
    }
}
