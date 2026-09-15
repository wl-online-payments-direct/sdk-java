/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.time.ZonedDateTime;

public class Acceptance {

    private String acceptanceSystemApplicationId;

    private ZonedDateTime authorizationDate;

    private String authorizationMessageReference;

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

    /**
     * Identifier shared with the acquirer during the authorization process. For example, this reference data could be sent by the acquirer in the authorization response, then sent (unchanged) in a subsequent authorization reversal message, to the extent that the acquirer is able to match a reversal message to the associated response message.
     */
    public String getAuthorizationMessageReference() {
        return authorizationMessageReference;
    }

    /**
     * Identifier shared with the acquirer during the authorization process. For example, this reference data could be sent by the acquirer in the authorization response, then sent (unchanged) in a subsequent authorization reversal message, to the extent that the acquirer is able to match a reversal message to the associated response message.
     */
    public void setAuthorizationMessageReference(String value) {
        this.authorizationMessageReference = value;
    }

    /**
     * Identifier shared with the acquirer during the authorization process. For example, this reference data could be sent by the acquirer in the authorization response, then sent (unchanged) in a subsequent authorization reversal message, to the extent that the acquirer is able to match a reversal message to the associated response message.
     */
    public Acceptance withAuthorizationMessageReference(String value) {
        this.authorizationMessageReference = value;
        return this;
    }
}
