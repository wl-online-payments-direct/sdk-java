package com.onlinepayments.util;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import com.onlinepayments.ResponseHeader;

public class ResponseHeaderMatcher extends TypeSafeDiagnosingMatcher<ResponseHeader> {

	private final String name;
	private final String value;

	public ResponseHeaderMatcher(String name, String value) {
		this.name = name;
		this.value = value;
	}

	@Override
	protected boolean matchesSafely(ResponseHeader item, Description mismatchDescription) {
		return (name == null ? item.getName() == null : name.equals(item.getName()))
				&& (value == null ? item.getValue() == null : value.equals(item.getValue()));
	}

	@Override
	public void describeTo(Description description) {
		description
				.appendText("name is ")
				.appendValue(name)
				.appendText(", value is ")
				.appendValue(value);
	}
}
