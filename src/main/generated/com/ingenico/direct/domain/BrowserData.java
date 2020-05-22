/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Object containing information regarding the browser of the customer
 */
public class BrowserData {

	private Integer colorDepth = null;

	private Boolean javaEnabled = null;

	private String screenHeight = null;

	private String screenWidth = null;

	/**
	 * ColorDepth in bits. Value is returned from the screen.colorDepth property.
	 * 
	 * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
	 * 
	 * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement. As we currently support version 2.1 it means that this property is required when cardPaymentMethodSpecifInput.threeDSecure.authenticationFlow is set to "browser".
	 */
	public Integer getColorDepth() {
		return colorDepth;
	}

	/**
	 * ColorDepth in bits. Value is returned from the screen.colorDepth property.
	 * 
	 * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
	 * 
	 * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement. As we currently support version 2.1 it means that this property is required when cardPaymentMethodSpecifInput.threeDSecure.authenticationFlow is set to "browser".
	 */
	public void setColorDepth(Integer value) {
		this.colorDepth = value;
	}

	/**
	 * true =Java is enabled in the browser
	 * 
	 * false = Java is not enabled in the browser
	 * 
	 * Value is returned from the navigator.javaEnabled property.
	 * 
	 * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
	 * 
	 * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement. As we currently support version 2.1 it means that this property is required when cardPaymentMethodSpecifInput.threeDSecure.authenticationFlow is set to "browser".
	 */
	public Boolean getJavaEnabled() {
		return javaEnabled;
	}

	/**
	 * true =Java is enabled in the browser
	 * 
	 * false = Java is not enabled in the browser
	 * 
	 * Value is returned from the navigator.javaEnabled property.
	 * 
	 * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
	 * 
	 * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement. As we currently support version 2.1 it means that this property is required when cardPaymentMethodSpecifInput.threeDSecure.authenticationFlow is set to "browser".
	 */
	public void setJavaEnabled(Boolean value) {
		this.javaEnabled = value;
	}

	/**
	 * Height of the screen in pixels. Value is returned from the screen.height property.
	 * 
	 * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
	 * 
	 * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement. As we currently support version 2.1 it means that this property is required when cardPaymentMethodSpecifInput.threeDSecure.authenticationFlow is set to "browser".
	 */
	public String getScreenHeight() {
		return screenHeight;
	}

	/**
	 * Height of the screen in pixels. Value is returned from the screen.height property.
	 * 
	 * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
	 * 
	 * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement. As we currently support version 2.1 it means that this property is required when cardPaymentMethodSpecifInput.threeDSecure.authenticationFlow is set to "browser".
	 */
	public void setScreenHeight(String value) {
		this.screenHeight = value;
	}

	/**
	 * Width of the screen in pixels. Value is returned from the screen.width property.
	 * 
	 * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
	 * 
	 * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement. As we currently support version 2.1 it means that this property is required when cardPaymentMethodSpecifInput.threeDSecure.authenticationFlow is set to "browser".
	 */
	public String getScreenWidth() {
		return screenWidth;
	}

	/**
	 * Width of the screen in pixels. Value is returned from the screen.width property.
	 * 
	 * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
	 * 
	 * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement. As we currently support version 2.1 it means that this property is required when cardPaymentMethodSpecifInput.threeDSecure.authenticationFlow is set to "browser".
	 */
	public void setScreenWidth(String value) {
		this.screenWidth = value;
	}
}
