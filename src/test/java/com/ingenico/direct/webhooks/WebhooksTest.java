package com.ingenico.direct.webhooks;

import org.junit.Assert;
import org.junit.Test;

import com.ingenico.direct.Marshaller;
import com.ingenico.direct.defaultimpl.DefaultMarshaller;
import com.ingenico.direct.util.ReflectionUtil;

public class WebhooksTest {

	@Test
	public void testCreateHelper() {
		WebhooksHelper helper = Webhooks.createHelper(InMemorySecretKeyStore.INSTANCE);

		Assert.assertSame(DefaultMarshaller.INSTANCE, ReflectionUtil.getField(helper, "marshaller", Marshaller.class));
		Assert.assertSame(InMemorySecretKeyStore.INSTANCE, ReflectionUtil.getField(helper, "secretKeyStore", SecretKeyStore.class));
	}
}
