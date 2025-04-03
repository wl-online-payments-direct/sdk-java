package com.onlinepayments.communication;

/**
 * Indicates an exception regarding the communication with the Online Payments platform such as a connection exception.
 */
@SuppressWarnings("serial")
public class CommunicationException extends RuntimeException {

    public CommunicationException(Exception e) {
        super(e);
    }
}
