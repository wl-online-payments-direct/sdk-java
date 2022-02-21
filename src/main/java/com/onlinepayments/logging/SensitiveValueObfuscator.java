package com.onlinepayments.logging;

/**
 * This class provides obfuscation for data where an
 * indication of the length of the value isn't wanted.
 */
class SensitiveValueObfuscator extends ValueObfuscator {

	public static final SensitiveValueObfuscator INSTANCE = new SensitiveValueObfuscator();
	private static final String OBFUSCATED_SENSITIVE_VALUE = "***";

	private SensitiveValueObfuscator() { }

	/**
	 * @return an arbitrary number of '*', or null/empty if the value is null/empty.
	 */
	@Override
	String obfuscateValue(String value) {
		if (value == null || value.isEmpty()) {
			return value;
		}
		return OBFUSCATED_SENSITIVE_VALUE;
	}
}
