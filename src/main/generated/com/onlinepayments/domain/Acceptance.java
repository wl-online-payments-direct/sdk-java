/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.time.ZonedDateTime;

public class Acceptance {

    private String acceptanceSystemApplicationId;

    private ZonedDateTime authorizationDate;

    /**
     * Worldline application identifier used to transmit the authorization request. This data is transmitted as provided in the authorization request and in the response. It is named ITP (Terminal Application Identification at the Point of Acceptance) in the CB2A protocol.
     */
    public String getAcceptanceSystemApplicationId() {
        return acceptanceSystemApplicationId;
    }

    /**
     * Worldline application identifier used to transmit the authorization request. This data is transmitted as provided in the authorization request and in the response. It is named ITP (Terminal Application Identification at the Point of Acceptance) in the CB2A protocol.
     */
    public void setAcceptanceSystemApplicationId(String value) {
        this.acceptanceSystemApplicationId = value;
    }

    /**
     * Worldline application identifier used to transmit the authorization request. This data is transmitted as provided in the authorization request and in the response. It is named ITP (Terminal Application Identification at the Point of Acceptance) in the CB2A protocol.
     */
    public Acceptance withAcceptanceSystemApplicationId(String value) {
        this.acceptanceSystemApplicationId = value;
        return this;
    }

    /**
     * It is the authorization processing date and time of the transaction.
     */
    public ZonedDateTime getAuthorizationDate() {
        return authorizationDate;
    }

    /**
     * It is the authorization processing date and time of the transaction.
     */
    public void setAuthorizationDate(ZonedDateTime value) {
        this.authorizationDate = value;
    }

    /**
     * It is the authorization processing date and time of the transaction.
     */
    public Acceptance withAuthorizationDate(ZonedDateTime value) {
        this.authorizationDate = value;
        return this;
    }
}
