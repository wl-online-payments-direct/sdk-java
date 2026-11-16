package examples;

import com.onlinepayments.domain.BrowserData;
import com.onlinepayments.domain.CustomerDevice;

public final class CustomerDeviceBuilder {

    private CustomerDeviceBuilder() {
    }

    // [START customer-device]
    // 3-D Secure needs details about the customer's browser. Collect the browser values with
    // JavaScript on the checkout page and read the rest from the HTTP request.
    public static CustomerDevice build(String acceptHeader, String userAgent, String ipAddress, BrowserInfo browser) {
        return new CustomerDevice()
                .withAcceptHeader(acceptHeader)
                .withUserAgent(userAgent)
                .withIpAddress(ipAddress)
                .withLocale(browser.getLocale())
                .withTimezoneOffsetUtcMinutes(String.valueOf(browser.getTimezoneOffsetUtcMinutes()))
                .withBrowserData(new BrowserData()
                        .withColorDepth(browser.getColorDepth())
                        .withJavaEnabled(browser.isJavaEnabled())
                        .withJavaScriptEnabled(true)
                        .withScreenHeight(String.valueOf(browser.getScreenHeight()))
                        .withScreenWidth(String.valueOf(browser.getScreenWidth())));
    }
    // [END customer-device]
}
