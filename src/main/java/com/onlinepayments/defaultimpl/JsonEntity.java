package com.onlinepayments.defaultimpl;

import java.nio.charset.Charset;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 * A sub class of {@link StringEntity} that keeps its original string.
 */
class JsonEntity extends StringEntity {

	private final String string;

	public JsonEntity(String string, Charset charset) {
		super(string, ContentType.create(ContentType.APPLICATION_JSON.getMimeType(), charset));
		this.string = string;
	}

	public String getString() {
		return string;
	}
}
