/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class MandateRedirectData {

    private String RETURNMAC;

    private String redirectURL;

    /**
     * A Message Authentication Code (MAC) is used to authenticate the redirection back to merchant after the payment.
     */
    public String getRETURNMAC() {
        return RETURNMAC;
    }

    /**
     * A Message Authentication Code (MAC) is used to authenticate the redirection back to merchant after the payment.
     */
    public void setRETURNMAC(String value) {
        this.RETURNMAC = value;
    }

    /**
     * A Message Authentication Code (MAC) is used to authenticate the redirection back to merchant after the payment.
     */
    public MandateRedirectData withRETURNMAC(String value) {
        this.RETURNMAC = value;
        return this;
    }

    /**
     * The URL that the customer should be redirected to. Be sure to redirect using the GET method.
     */
    public String getRedirectURL() {
        return redirectURL;
    }

    /**
     * The URL that the customer should be redirected to. Be sure to redirect using the GET method.
     */
    public void setRedirectURL(String value) {
        this.redirectURL = value;
    }

    /**
     * The URL that the customer should be redirected to. Be sure to redirect using the GET method.
     */
    public MandateRedirectData withRedirectURL(String value) {
        this.redirectURL = value;
        return this;
    }
}
