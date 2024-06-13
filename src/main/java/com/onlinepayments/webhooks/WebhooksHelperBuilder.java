package com.onlinepayments.webhooks;

import com.onlinepayments.Marshaller;

/**
 * Builder for a {@link WebhooksHelper} object.
 */
public class WebhooksHelperBuilder {

	private Marshaller marshaller;

	private SecretKeyStore secretKeyStore;

	/**
	 * Sets the {@link Marshaller} to use.
	 *
	 * @param marshaller The marshaller to be used
	 * @return The instance of the WebhooksHelperBuilder
	 */
	public WebhooksHelperBuilder withMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
		return this;
	}

	/**
	 * Sets the {@link SecretKeyStore} to use.
	 *
	 * @param secretKeyStore The keystore to be used
	 * @return The instance of the WebhooksHelperBuilder
	 */
	public WebhooksHelperBuilder withSecretKeyStore(SecretKeyStore secretKeyStore) {
		this.secretKeyStore = secretKeyStore;
		return this;
	}

	/**
	 * Creates a fully initialized {@link WebhooksHelper} object.
	 *
	 * @return A new instance of {@link WebhooksHelper}
	 * @throws IllegalArgumentException if not all required components are set
	 */
	public WebhooksHelper build() {
		return new WebhooksHelper(
				marshaller,
				secretKeyStore
		);
	}
}
