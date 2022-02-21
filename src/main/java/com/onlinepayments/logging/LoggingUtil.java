package com.onlinepayments.logging;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * A utility class to support logging.
 */
public final class LoggingUtil {

	private static final PropertyObfuscator PROPERTY_OBFUSCATOR = PropertyObfuscator.builder()
            // PCI-related fields
			.withField("accountNumber")
			.withField("bin")
			.withField("cardNumber")
			.withField("cvv")
			.withField("expiryDate")
			.withField("iban")
			.withField("reformattedAccountNumber")
	        // GDPR-related fields
	        .withField("additionalInfo")
	        .withField("cardholderName")
	        .withField("dateOfBirth")
	        .withField("emailAddress")
	        .withField("faxNumber")
	        .withField("firstName")
	        .withField("houseNumber")
	        .withField("mobilePhoneNumber")
	        .withField("passengerName")
	        .withField("phoneNumber")
	        .withField("street")
	        .withField("surname")
	        .withField("workPhoneNumber")
	        .withField("zip")
			// key-value pairs can contain any value, like credit card numbers or other private data; mask all values
			.withField("value")
			.withSensitiveField("keyId")
			.withSensitiveField("publicKey")
			.withSensitiveField("secretKey")
			.withSensitiveField("userAuthenticationToken")
            // encrypted customer input is similar to encrypted payload
            .withSensitiveField("encryptedCustomerInput")
			// encrypted payload is a base64 string that contains an encrypted value; to make decrypting even harder, just mask the entire thing
			.withSensitiveField("encryptedPayload")
			// decrypted payload is a simple base64 string that may contain credit card numbers or other private data; just mask the entire thing
			.withSensitiveField("decryptedPayload")
			.build();

	private static final HeaderObfuscator HEADER_OBFUSCATOR = HeaderObfuscator.builder()
			.withSensitiveField("Authorization")
			.withSensitiveField("Proxy-Authenticate")
			.withSensitiveField("Proxy-Authorization")
			.withSensitiveField("WWW-Authenticate")
			.withSensitiveField("X-GCS-Authentication-Token")
			.withSensitiveField("X-GCS-CallerPassword")
			.build();

	private LoggingUtil() {}

	/**
	 * Obfuscates the given body as necessary.
	 */
	public static String obfuscateBody(CharSequence body) {
		return PROPERTY_OBFUSCATOR.obfuscate(body);
	}

	/**
	 * Obfuscates the body from the given stream as necessary.
	 * @param charset The charset to use to read the body input stream.
	 */
	public static String obfuscateBody(InputStream bodyStream, Charset charset) throws IOException {
		return obfuscateBody(new InputStreamReader(bodyStream, charset));
	}

	/**
	 * Obfuscates the body from the given stream as necessary.
	 */
	public static String obfuscateBody(Reader bodyStream) throws IOException {
		StringBuilder body = new StringBuilder();
		char[] buffer = new char[4096];
		int len;
		while ((len = bodyStream.read(buffer)) != -1) {
			body.append(buffer, 0, len);
		}

		return obfuscateBody(body);
	}

	/**
	 * Obfuscates the value for the given header as necessary.
	 */
	public static String obfuscateHeader(String name, String value) {
		return HEADER_OBFUSCATOR.obfuscateValue(name, value);
	}
}
