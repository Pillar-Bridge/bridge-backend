package com.pillar.bridge.util.jwt;

public class CustomJwtValidationException extends RuntimeException {
    public CustomJwtValidationException(String message) {
        super(message);
    }
}
