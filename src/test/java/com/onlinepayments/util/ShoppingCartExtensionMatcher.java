package com.onlinepayments.util;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import com.onlinepayments.domain.ShoppingCartExtension;

public class ShoppingCartExtensionMatcher extends TypeSafeDiagnosingMatcher<ShoppingCartExtension> {

	private final String creator;
	private final String name;
	private final String version;
	private final String extensionId;

	public ShoppingCartExtensionMatcher(ShoppingCartExtension shoppingCartExtension) {
		this.creator = shoppingCartExtension.getCreator();
		this.name = shoppingCartExtension.getName();
		this.version = shoppingCartExtension.getVersion();
		this.extensionId = shoppingCartExtension.getExtensionId();
	}

	@Override
	protected boolean matchesSafely(ShoppingCartExtension item, Description mismatchDescription) {
		return (creator == null ? item.getCreator() == null : creator.equals(item.getCreator()))
				&& (name == null ? item.getName() == null : name.equals(item.getName()))
				&& (version == null ? item.getVersion() == null : version.equals(item.getVersion()))
				&& (extensionId == null ? item.getExtensionId() == null : extensionId.equals(item.getExtensionId()));
	}

	@Override
	public void describeTo(Description description) {
		description
				.appendText("creator is ")
				.appendValue(creator)
				.appendText(", name is ")
				.appendValue(name)
				.appendText(", version is ")
				.appendValue(version)
				.appendText(", extensionId is ")
				.appendValue(extensionId);
	}
}
