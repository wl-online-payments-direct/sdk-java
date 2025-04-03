package com.onlinepayments.authentication;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.onlinepayments.CommunicatorConfiguration;
import com.onlinepayments.communication.RequestHeader;

/**
 * V1HMAC {@link Authenticator} implementation.
 */
public class V1HmacAuthenticator implements Authenticator {

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    private static final String HMAC_ALGORITHM = "HmacSHA256";
    private static final Pattern CANONICALIZE_HEADER_REGEXP = Pattern.compile("\r?\n[\\s&&[^\r\n]]*");

    private static final Comparator<RequestHeader> REQUEST_HEADER_COMPARATOR = Comparator.comparing(RequestHeader::getName);

    private final AuthorizationType authorizationType;

    private final String apiKeyId;

    private final String secretApiKey;

    /**
    * Constructs a new V1HmacAuthenticator instance using the provided CommunicatorConfiguration.
    *
    * @param communicatorConfiguration The configuration object containing the API key, and API key secret,
    *                                  connect timeout, and socket timeout. None of these can be {@code null} or empty, and
    *                                  the timeout values must be positive.
    * @throws IllegalArgumentException If the API key, and API key secret from the communicator configuration
    *                                  is {@code null} or empty, or if the connect timeout or socket timeout is non-positive.
    */
    public V1HmacAuthenticator(CommunicatorConfiguration communicatorConfiguration) {
        this(communicatorConfiguration.getApiKeyId(), communicatorConfiguration.getSecretApiKey(), communicatorConfiguration.getAuthorizationType());
    }

    /**
     * @param apiKeyId
     *            An identifier for the secret API key. This identifier is
     *            visible in the HTTP request and is also used to identify
     *            the correct account.
     * @param secretApiKey
     *            A shared secret. An {@code apiKeyId} and {@code secretApiKey}
     *            always go hand-in-hand, the difference is that {@code secretApiKey}
     *            is never visible in the HTTP request. This secret is used as input
     *            for the HMAC algorithm.
     */
    public V1HmacAuthenticator(String apiKeyId, String secretApiKey) {
        this(apiKeyId, secretApiKey, AuthorizationType.V1HMAC);
    }

    /**
     * @param authorizationType
     *            Based on this value both the Online Payments platform and the merchant know
     *            which security implementation is used. A version number is
     *            used for backward compatibility in the future.
     * @param apiKeyId
     *            An identifier for the secret API key. This identifier is
     *            visible in the HTTP request and is also used to identify
     *            the correct account.
     * @param secretApiKey
     *            A shared secret. An {@code apiKeyId} and {@code secretApiKey}
     *            always go hand-in-hand, the difference is that {@code secretApiKey}
     *            is never visible in the HTTP request. This secret is used as input
     *            for the HMAC algorithm.
     */
    public V1HmacAuthenticator(String apiKeyId, String secretApiKey, AuthorizationType authorizationType) {
        if (secretApiKey == null || secretApiKey.trim().isEmpty()) {
            throw new IllegalArgumentException("secretApiKey is required");
        }
        if (apiKeyId == null || apiKeyId.trim().isEmpty()) {
            throw new IllegalArgumentException("apiKeyId is required");
        }
        this.authorizationType = authorizationType == null ? AuthorizationType.V1HMAC : authorizationType;
        this.apiKeyId = apiKeyId;
        this.secretApiKey = secretApiKey;
    }

    @Override
    public String getAuthorization(String httpMethod, URI resourceUri, List<RequestHeader> httpHeaders) {

        if (httpMethod == null || httpMethod.trim().isEmpty()) {
            throw new IllegalArgumentException("httpMethod is required");
        }
        if (resourceUri == null) {
            throw new IllegalArgumentException("resourceUri is required");
        }

        String dataToSign = toDataToSign(httpMethod, resourceUri, httpHeaders);
        return "GCS " + authorizationType.getSignatureString() + ":" + apiKeyId + ":" + createAuthenticationSignature(dataToSign);
    }

    String toDataToSign(String httpMethod, URI resourceUri, List<RequestHeader> httpHeaders) {

        String contentType = null;
        String date = null;
        String canonicalizedResource = toCanonicalizedResource(resourceUri);

        List<RequestHeader> xgcsHttpHeaders = new ArrayList<>();

        if (httpHeaders != null) {

            for (RequestHeader httpHeader : httpHeaders) {
                if ("Content-Type".equalsIgnoreCase(httpHeader.getName())) {
                    contentType = httpHeader.getValue();
                } else if ("Date".equalsIgnoreCase(httpHeader.getName())) {
                    date = httpHeader.getValue();
                } else {
                    String name = toCanonicalizeHeaderName(httpHeader.getName());
                    if (name.startsWith("x-gcs")) {
                        String value =  toCanonicalizeHeaderValue(httpHeader.getValue());
                        RequestHeader xgcsHttpHeader = new RequestHeader(name, value);
                        xgcsHttpHeaders.add(xgcsHttpHeader);
                    }
                }
            }
        }

        xgcsHttpHeaders.sort(REQUEST_HEADER_COMPARATOR);

        StringBuilder sb = new StringBuilder(100);
        sb.append(httpMethod.toUpperCase()).append('\n');
        if (contentType != null) {
            sb.append(contentType).append('\n');
        } else {
            sb.append('\n');
        }
        sb.append(date).append('\n');
        for (RequestHeader xgcsHttpHeader : xgcsHttpHeaders) {
            sb.append(xgcsHttpHeader.getName()).append(':').append(xgcsHttpHeader.getValue()).append('\n');
        }
        sb.append(canonicalizedResource).append('\n');

        return sb.toString();
    }

    /**
     * Returns the encoded URI path without the HTTP method and including all
     * decoded query parameters.
     */
    private String toCanonicalizedResource(URI resourceUri) {
        String rawPath = resourceUri.getRawPath();
        if (resourceUri.getQuery() == null) {
            return rawPath;
        }

        return rawPath + '?' + resourceUri.getQuery();
    }

    private String toCanonicalizeHeaderName(String originalName) {
        return originalName == null ? null : originalName.toLowerCase(Locale.ENGLISH);
    }

    String toCanonicalizeHeaderValue(String originalValue) {

        if (originalValue == null) {
            return "";
        }

        return CANONICALIZE_HEADER_REGEXP.matcher(originalValue).replaceAll(" ").trim();
    }

    /*
     * For now V1HMAC is the only supported AuthorizationType so always use the same logic.
     */
    String createAuthenticationSignature(String dataToSign) {

        try {
            Mac sha256Hmac = Mac.getInstance(HMAC_ALGORITHM);
            SecretKeySpec secretKey = new SecretKeySpec(secretApiKey.getBytes(CHARSET), HMAC_ALGORITHM);
            sha256Hmac.init(secretKey);

            byte[] unencodedResult = sha256Hmac.doFinal(dataToSign.getBytes(CHARSET));
            return Base64.encodeBase64String(unencodedResult);

        } catch (NoSuchAlgorithmException e) {
            // should not happen, this hardcoded MAC is included by default
            throw new RuntimeException("No such HMAC algorithm " + HMAC_ALGORITHM, e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException("Invalid HMAC key", e);
        }
    }
}
