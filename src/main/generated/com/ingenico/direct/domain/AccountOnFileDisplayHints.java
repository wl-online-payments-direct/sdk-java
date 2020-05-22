/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

import java.util.List;

public class AccountOnFileDisplayHints {

	private List<LabelTemplateElement> labelTemplate = null;

	private String logo = null;

	public List<LabelTemplateElement> getLabelTemplate() {
		return labelTemplate;
	}

	public void setLabelTemplate(List<LabelTemplateElement> value) {
		this.labelTemplate = value;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String value) {
		this.logo = value;
	}
}
