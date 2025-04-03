/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class BrowserData {

    private Integer colorDepth;

    private Boolean javaEnabled;

    private Boolean javaScriptEnabled;

    private String screenHeight;

    private String screenWidth;

    /**
     * ColorDepth in bits. Value is returned from the screen.colorDepth property.
     * <p>
     * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
     * <p>
     * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement.
     */
    public Integer getColorDepth() {
        return colorDepth;
    }

    /**
     * ColorDepth in bits. Value is returned from the screen.colorDepth property.
     * <p>
     * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
     * <p>
     * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement.
     */
    public void setColorDepth(Integer value) {
        this.colorDepth = value;
    }

    /**
     * ColorDepth in bits. Value is returned from the screen.colorDepth property.
     * <p>
     * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
     * <p>
     * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement.
     */
    public BrowserData withColorDepth(Integer value) {
        this.colorDepth = value;
        return this;
    }

    /**
     * true =Java is enabled in the browser
     * <p>
     * false = Java is not enabled in the browser
     * <p>
     * Value is returned from the navigator.javaEnabled property.
     * <p>
     * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
     * <p>
     * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement.
     */
    public Boolean getJavaEnabled() {
        return javaEnabled;
    }

    /**
     * true =Java is enabled in the browser
     * <p>
     * false = Java is not enabled in the browser
     * <p>
     * Value is returned from the navigator.javaEnabled property.
     * <p>
     * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
     * <p>
     * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement.
     */
    public void setJavaEnabled(Boolean value) {
        this.javaEnabled = value;
    }

    /**
     * true =Java is enabled in the browser
     * <p>
     * false = Java is not enabled in the browser
     * <p>
     * Value is returned from the navigator.javaEnabled property.
     * <p>
     * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
     * <p>
     * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement.
     */
    public BrowserData withJavaEnabled(Boolean value) {
        this.javaEnabled = value;
        return this;
    }

    /**
     * <ul>
     *   <li>true = JavaScript is enabled in the browser.</li>
     *   <li>false = JavaScript is not enabled in the browser. In this case the following parameters are not mandatory anymore: colorDepth, javaEnabled, screenHeight, screenWidth, timezoneOffsetUtcMinutes.</li>
     * </ul>
     */
    public Boolean getJavaScriptEnabled() {
        return javaScriptEnabled;
    }

    /**
     * <ul>
     *   <li>true = JavaScript is enabled in the browser.</li>
     *   <li>false = JavaScript is not enabled in the browser. In this case the following parameters are not mandatory anymore: colorDepth, javaEnabled, screenHeight, screenWidth, timezoneOffsetUtcMinutes.</li>
     * </ul>
     */
    public void setJavaScriptEnabled(Boolean value) {
        this.javaScriptEnabled = value;
    }

    /**
     * <ul>
     *   <li>true = JavaScript is enabled in the browser.</li>
     *   <li>false = JavaScript is not enabled in the browser. In this case the following parameters are not mandatory anymore: colorDepth, javaEnabled, screenHeight, screenWidth, timezoneOffsetUtcMinutes.</li>
     * </ul>
     */
    public BrowserData withJavaScriptEnabled(Boolean value) {
        this.javaScriptEnabled = value;
        return this;
    }

    /**
     * Height of the screen in pixels. Value is returned from the screen.height property.
     * <p>
     * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
     * <p>
     * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement.
     */
    public String getScreenHeight() {
        return screenHeight;
    }

    /**
     * Height of the screen in pixels. Value is returned from the screen.height property.
     * <p>
     * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
     * <p>
     * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement.
     */
    public void setScreenHeight(String value) {
        this.screenHeight = value;
    }

    /**
     * Height of the screen in pixels. Value is returned from the screen.height property.
     * <p>
     * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
     * <p>
     * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement.
     */
    public BrowserData withScreenHeight(String value) {
        this.screenHeight = value;
        return this;
    }

    /**
     * Width of the screen in pixels. Value is returned from the screen.width property.
     * <p>
     * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
     * <p>
     * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement.
     */
    public String getScreenWidth() {
        return screenWidth;
    }

    /**
     * Width of the screen in pixels. Value is returned from the screen.width property.
     * <p>
     * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
     * <p>
     * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement.
     */
    public void setScreenWidth(String value) {
        this.screenWidth = value;
    }

    /**
     * Width of the screen in pixels. Value is returned from the screen.width property.
     * <p>
     * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
     * <p>
     * Note: This data can only be collected if JavaScript is enabled in the browser. This means that 3-D Secure version 2.1 requires the use of JavaScript to enabled. In the upcoming version 2.2 of the specification this is no longer a requirement.
     */
    public BrowserData withScreenWidth(String value) {
        this.screenWidth = value;
        return this;
    }
}
