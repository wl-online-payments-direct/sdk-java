package com.onlinepayments.merchant.products;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import com.onlinepayments.RequestParam;
import com.onlinepayments.util.RequestParamMatcher;

public class DirectoryParamsTest {

	@Test
	public void testToRequestParameters() {
		GetProductDirectoryParams params = new GetProductDirectoryParams();
		List<Matcher<? super RequestParam>> matchers = new ArrayList<Matcher<? super RequestParam>>();

		MatcherAssert.assertThat(params.toRequestParameters(), Matchers.containsInAnyOrder(matchers));

		params.setCountryCode("NL");
		matchers.add(new RequestParamMatcher("countryCode", "NL"));
		MatcherAssert.assertThat(params.toRequestParameters(), Matchers.containsInAnyOrder(matchers));

		params.setCurrencyCode("EUR");
		matchers.add(new RequestParamMatcher("currencyCode", "EUR"));
		MatcherAssert.assertThat(params.toRequestParameters(), Matchers.containsInAnyOrder(matchers));

		params.setCountryCode(null);
		matchers.remove(0);
		MatcherAssert.assertThat(params.toRequestParameters(), Matchers.containsInAnyOrder(matchers));
	}
}
