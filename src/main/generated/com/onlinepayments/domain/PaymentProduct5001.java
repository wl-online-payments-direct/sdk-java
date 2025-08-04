/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProduct5001 {

    private String message;

    private String pollingUrl;

    /**
     * A text string intended to be displayed to the consumer
     */
    public String getMessage() {
        return message;
    }

    /**
     * A text string intended to be displayed to the consumer
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * A text string intended to be displayed to the consumer
     */
    public PaymentProduct5001 withMessage(String value) {
        this.message = value;
        return this;
    }

    /**
     * A URL that must be polled using JavaScript; it responds with either true or false to say if transaction is still pending or not. As long as the response status is 'true', the message should be shown and polling should continue. Once the status changes to 'false', you should verify the payment outcome and redirect the customer to your status page accordingly. Remember, a pending status 'false' indicates that the Bizum process has concluded, but it does not necessarily confirm a successful payment. And if you end the polling after a few minutes without receiving the status 'false', it means that the transaction can't be ended as accepted or refused yet. NB - If you try to call the polling endpoint with invalid data, you will receive an http 204.
     */
    public String getPollingUrl() {
        return pollingUrl;
    }

    /**
     * A URL that must be polled using JavaScript; it responds with either true or false to say if transaction is still pending or not. As long as the response status is 'true', the message should be shown and polling should continue. Once the status changes to 'false', you should verify the payment outcome and redirect the customer to your status page accordingly. Remember, a pending status 'false' indicates that the Bizum process has concluded, but it does not necessarily confirm a successful payment. And if you end the polling after a few minutes without receiving the status 'false', it means that the transaction can't be ended as accepted or refused yet. NB - If you try to call the polling endpoint with invalid data, you will receive an http 204.
     */
    public void setPollingUrl(String value) {
        this.pollingUrl = value;
    }

    /**
     * A URL that must be polled using JavaScript; it responds with either true or false to say if transaction is still pending or not. As long as the response status is 'true', the message should be shown and polling should continue. Once the status changes to 'false', you should verify the payment outcome and redirect the customer to your status page accordingly. Remember, a pending status 'false' indicates that the Bizum process has concluded, but it does not necessarily confirm a successful payment. And if you end the polling after a few minutes without receiving the status 'false', it means that the transaction can't be ended as accepted or refused yet. NB - If you try to call the polling endpoint with invalid data, you will receive an http 204.
     */
    public PaymentProduct5001 withPollingUrl(String value) {
        this.pollingUrl = value;
        return this;
    }
}
