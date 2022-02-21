package com.onlinepayments.logging;

public class ValueObfuscator {

    public static final ValueObfuscator INSTANCE = new ValueObfuscator();

    protected ValueObfuscator() { }

    /**
     * @return "*" followed by the length of the given value, or null/empty if the value is null/empty, eg. "abc" returns "*3".
     */
    String obfuscateValue(String value) {
        return value == null || value.isEmpty()
                ? value
                : "*" + value.length();
    }
}
