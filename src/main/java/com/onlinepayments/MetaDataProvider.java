package com.onlinepayments;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import com.onlinepayments.defaultimpl.DefaultMarshaller;
import com.onlinepayments.domain.ShoppingCartExtension;
import org.apache.commons.codec.binary.Base64;

/**
 * Provides meta info about the server. Thread-safe.
 */
public class MetaDataProvider {

	private static final String SDK_VERSION = "4.15.0";
	protected static final String SDK_IDENTIFIER = "OnlinePaymentsJavaServerSDK/v" + SDK_VERSION;
	protected static final String PLATFORM_IDENTIFIER;
	static {
		Properties properties = System.getProperties();
		PLATFORM_IDENTIFIER = properties.get("os.name") + "/" + properties.get("os.version") + " "
				+ "Java" + "/" + properties.get("java.vm.specification.version") + " "
				+ "(" + properties.get("java.vm.vendor") + "; " + properties.get("java.vm.name") + "; " + properties.get("java.version") + ")";
	}

	private static final String SERVER_META_INFO_HEADER = "X-GCS-ServerMetaInfo";
	static final Set<String> PROHIBITED_HEADERS;
	static {
		Set<String> prohibitedHeaders = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		prohibitedHeaders.add(SERVER_META_INFO_HEADER);
		prohibitedHeaders.add("X-GCS-Idempotence-Key");
		prohibitedHeaders.add("Date");
		prohibitedHeaders.add("Content-Type");
		prohibitedHeaders.add("Authorization");

		PROHIBITED_HEADERS = Collections.unmodifiableSet(prohibitedHeaders);
	}

	private static final Charset CHARSET = Charset.forName("UTF-8");

	static final class ServerMetaInfo {
		String platformIdentifier;
		String sdkIdentifier;
		String sdkCreator;
		String integrator;
		ShoppingCartExtension shoppingCartExtension;
	}

	private final Collection<RequestHeader> metaDataHeaders;

	public MetaDataProvider(String integrator) {
		this(
				integrator,
				null,
				Collections.<RequestHeader>emptyList()
		);
	}

	protected MetaDataProvider(MetaDataProviderBuilder builder) {
		this(
				builder.integrator,
				builder.shoppingCartExtension,
				builder.additionalRequestHeaders
		);
	}

	private MetaDataProvider(String integrator,
			ShoppingCartExtension shoppingCartExtension,
			Collection<RequestHeader> additionalRequestHeaders) {

		validateAdditionalRequestHeaders(additionalRequestHeaders);

		ServerMetaInfo serverMetaInfo = new ServerMetaInfo();
		serverMetaInfo.platformIdentifier = PLATFORM_IDENTIFIER;
		serverMetaInfo.sdkIdentifier = SDK_IDENTIFIER;
		serverMetaInfo.sdkCreator = "OnlinePayments";
		serverMetaInfo.integrator = integrator;
		serverMetaInfo.shoppingCartExtension = shoppingCartExtension;

		String serverMetaInfoString = DefaultMarshaller.INSTANCE.marshal(serverMetaInfo);
		RequestHeader serverMetaInfoHeader = new RequestHeader(SERVER_META_INFO_HEADER, Base64.encodeBase64String(serverMetaInfoString.getBytes(CHARSET)));

		if (additionalRequestHeaders == null || additionalRequestHeaders.isEmpty()) {
			metaDataHeaders = Collections.singleton(serverMetaInfoHeader);
		} else {
			List<RequestHeader> requestHeaders = new ArrayList<RequestHeader>(additionalRequestHeaders.size() + 1);
			requestHeaders.add(serverMetaInfoHeader);
			requestHeaders.addAll(additionalRequestHeaders);
			metaDataHeaders = Collections.unmodifiableList(requestHeaders);
		}
	}

	static void validateAdditionalRequestHeaders(Collection<RequestHeader> additionalRequestHeaders) {
		if (additionalRequestHeaders != null) {
			for (RequestHeader additionalRequestHeader : additionalRequestHeaders) {
				validateAdditionalRequestHeader(additionalRequestHeader);
			}
		}
	}

	static void validateAdditionalRequestHeader(RequestHeader additionalRequestHeader) {
		if (PROHIBITED_HEADERS.contains(additionalRequestHeader.getName())) {
			throw new IllegalArgumentException("request header not allowed: " + additionalRequestHeader);
		}
	}

	/**
	 * @return The server related headers containing the META data to be associated with the request (if any).
	 *         This will always contain at least an automatically generated header {@code X-GCS-ServerMetaInfo}.
	 */
	public final Collection<RequestHeader> getServerMetaDataHeaders() {
		return metaDataHeaders;
	}
}
