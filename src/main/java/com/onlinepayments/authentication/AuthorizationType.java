package com.onlinepayments.authentication;

public enum AuthorizationType {

    V1HMAC("v1HMAC");

    private final String signatureString;

    AuthorizationType(String signatureString) {
        this.signatureString = signatureString;
    }

    String getSignatureString() {
        return signatureString;
    }

    public static AuthorizationType fromString(String name) {
        if (name == null) {
            throw new NullPointerException("AuthorizationType is null");
        }
        for (AuthorizationType type : values()) {
            if (type.getSignatureString().equalsIgnoreCase(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant 'AuthorizationType." + name + "'");
    }
}
