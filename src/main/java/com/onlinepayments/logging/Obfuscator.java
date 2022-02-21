package com.onlinepayments.logging;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Obfuscator {

	private final Map<String, ValueObfuscator> obfuscators;

	Obfuscator(Map<String, ValueObfuscator> obfuscators, boolean caseInsensitive) {
		this.obfuscators = copy(obfuscators, caseInsensitive);
	}

	private Map<String, ValueObfuscator> copy(Map<String, ValueObfuscator> obfuscators, boolean caseInsensitive) {
		Map<String, ValueObfuscator> copy;
		if (caseInsensitive) {
			copy = new TreeMap<String, ValueObfuscator>(String.CASE_INSENSITIVE_ORDER);
			copy.putAll(obfuscators);
		} else {
			copy = new LinkedHashMap<String, ValueObfuscator>(obfuscators);
		}
		return Collections.unmodifiableMap(copy);
	}

	String obfuscateValue(String key, String value) {
		ValueObfuscator obfuscator = obfuscators.get(key);
		return obfuscator != null ? obfuscator.obfuscateValue(value) : value;
	}

	abstract static class Builder {
		private final Map<String, ValueObfuscator> obfuscators = new LinkedHashMap<String, ValueObfuscator>();

		Builder() {}

		Builder withField(String key) {
			obfuscators.put(key, ValueObfuscator.INSTANCE);
			return this;
		}

		Builder withSensitiveField(String key) {
			obfuscators.put(key, SensitiveValueObfuscator.INSTANCE);
			return this;
		}

		Map<String, ValueObfuscator> getObfuscators() {
			return obfuscators;
		}

		abstract Obfuscator build();
	}
}
