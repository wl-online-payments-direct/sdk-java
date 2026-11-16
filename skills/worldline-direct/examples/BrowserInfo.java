package examples;

/**
 * Browser values collected with JavaScript on the checkout page.
 */
public class BrowserInfo {

    private int colorDepth;
    private boolean javaEnabled;
    private int screenHeight;
    private int screenWidth;
    private int timezoneOffsetUtcMinutes;
    private String locale;

    public int getColorDepth() {
        return colorDepth;
    }

    public void setColorDepth(int colorDepth) {
        this.colorDepth = colorDepth;
    }

    public boolean isJavaEnabled() {
        return javaEnabled;
    }

    public void setJavaEnabled(boolean javaEnabled) {
        this.javaEnabled = javaEnabled;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getTimezoneOffsetUtcMinutes() {
        return timezoneOffsetUtcMinutes;
    }

    public void setTimezoneOffsetUtcMinutes(int timezoneOffsetUtcMinutes) {
        this.timezoneOffsetUtcMinutes = timezoneOffsetUtcMinutes;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
