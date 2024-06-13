package com.onlinepayments;

import java.util.ArrayList;
import java.util.List;

import com.onlinepayments.domain.ShoppingCartExtension;

/**
 * Builder for a {@link MetaDataProvider} object.
 */
public class MetaDataProviderBuilder {

	final String integrator;

	ShoppingCartExtension shoppingCartExtension;

	final List<RequestHeader> additionalRequestHeaders = new ArrayList<RequestHeader>();

	/**
	 * @param integrator The integrator to use.
	 */
	public MetaDataProviderBuilder(String integrator) {
		this.integrator = integrator;
	}

	/**
	 * Sets the shopping cart extension to use.
	 *
	 * @param shoppingCartExtension Shopping cart extension used added to the instance
	 * @return The instance of the Metadata Provider Builder
	 */
	public MetaDataProviderBuilder withShoppingCartExtension(ShoppingCartExtension shoppingCartExtension) {
		this.shoppingCartExtension = shoppingCartExtension;
		return this;
	}

	/**
	 * Adds additional request header.
	 * The following names are prohibited in these additional request headers, because these will be set automatically
	 * as needed:
	 * <ul>
	 * <li>X-GCS-ServerMetaInfo</li>
	 * <li>X-GCS-ClientMetaInfo</li>
	 * <li>X-GCS-Idempotence-Key</li>
	 * <li>Date</li>
	 * <li>Content-Type</li>
	 * <li>Authorization</li>
	 * </ul>
	 *
	 * @param additionalRequestHeader Additional request header added to the instance
	 * @return The instance of the Metadata Provider Builder
	 */
	public MetaDataProviderBuilder withAdditionalRequestHeader(RequestHeader additionalRequestHeader) {
		MetaDataProvider.validateAdditionalRequestHeader(additionalRequestHeader);
		additionalRequestHeaders.add(additionalRequestHeader);
		return this;
	}

	/**
	 * Creates a fully initialized {@link MetaDataProvider} object.
	 *
	 * @return The instance of the Metadata Provider Builder
	 */
	public MetaDataProvider build() {
		return new MetaDataProvider(this);
	}
}
