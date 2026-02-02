/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SessionDetails {

    private String id;

    private String type;

    /**
     * Session identifier from where this payment originates from. Depends on the session type: ex: For PayByLink: id is the corresponding paymentLinkId.
     */
    public String getId() {
        return id;
    }

    /**
     * Session identifier from where this payment originates from. Depends on the session type: ex: For PayByLink: id is the corresponding paymentLinkId.
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Session identifier from where this payment originates from. Depends on the session type: ex: For PayByLink: id is the corresponding paymentLinkId.
     */
    public SessionDetails withId(String value) {
        this.id = value;
        return this;
    }

    /**
     * Session type. This denotes the origin of the session. For example PayByLink, HostedTokenization, etc.
     */
    public String getType() {
        return type;
    }

    /**
     * Session type. This denotes the origin of the session. For example PayByLink, HostedTokenization, etc.
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Session type. This denotes the origin of the session. For example PayByLink, HostedTokenization, etc.
     */
    public SessionDetails withType(String value) {
        this.type = value;
        return this;
    }
}
