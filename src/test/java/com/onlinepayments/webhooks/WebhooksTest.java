package com.onlinepayments.webhooks;

import org.junit.Assert;
import org.junit.Test;

import com.onlinepayments.Marshaller;
import com.onlinepayments.defaultimpl.DefaultMarshaller;
import com.onlinepayments.util.ReflectionUtil;

public class WebhooksTest {

	@Test
	public void testCreateHelper() {
		WebhooksHelper helper = Webhooks.createHelper(InMemorySecretKeyStore.INSTANCE);

		Assert.assertSame(DefaultMarshaller.INSTANCE, ReflectionUtil.getField(helper, "marshaller", Marshaller.class));
		Assert.assertSame(InMemorySecretKeyStore.INSTANCE, ReflectionUtil.getField(helper, "secretKeyStore", SecretKeyStore.class));
	}
}
