/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

import java.util.List;

/**
 * Object containing information for the client on how best to display this field
 */
public class AccountOnFileDisplayHints {

	private List<LabelTemplateElement> labelTemplate = null;

	private String logo = null;

	/**
	 * Array of attribute keys and their mask
	 */
	public List<LabelTemplateElement> getLabelTemplate() {
		return labelTemplate;
	}

	/**
	 * Array of attribute keys and their mask
	 */
	public void setLabelTemplate(List<LabelTemplateElement> value) {
		this.labelTemplate = value;
	}

	/**
	 * Array of attribute keys and their mask
	 */
	public AccountOnFileDisplayHints withLabelTemplate(List<LabelTemplateElement> value) {
		this.labelTemplate = value;
		return this;
	}

	/**
	 * Partial URL that you can reference for the image of this payment product. You can use our server-side resize functionality by appending '?size={{width}}x{{height}}' to the full URL, where width and height are specified in pixels. The resized image will always keep its correct aspect ratio.
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * Partial URL that you can reference for the image of this payment product. You can use our server-side resize functionality by appending '?size={{width}}x{{height}}' to the full URL, where width and height are specified in pixels. The resized image will always keep its correct aspect ratio.
	 */
	public void setLogo(String value) {
		this.logo = value;
	}

	/**
	 * Partial URL that you can reference for the image of this payment product. You can use our server-side resize functionality by appending '?size={{width}}x{{height}}' to the full URL, where width and height are specified in pixels. The resized image will always keep its correct aspect ratio.
	 */
	public AccountOnFileDisplayHints withLogo(String value) {
		this.logo = value;
		return this;
	}
}
