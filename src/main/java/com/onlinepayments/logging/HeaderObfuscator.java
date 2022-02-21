package com.onlinepayments.logging;

import java.util.Map;

final class HeaderObfuscator extends Obfuscator {

	HeaderObfuscator(Map<String, ValueObfuscator> obfuscators) {
		// case insensitive
		super(obfuscators, true);
	}

	static Builder builder() {
		return new Builder();
	}

	static class Builder extends Obfuscator.Builder {

		@Override
		Builder withField(String name) {
			super.withField(name);
			return this;
		}

		@Override
		Builder withSensitiveField(String name) {
			super.withSensitiveField(name);
			return this;
		}

		@Override
		HeaderObfuscator build() {
			return new HeaderObfuscator(getObfuscators());
		}
	}
}
