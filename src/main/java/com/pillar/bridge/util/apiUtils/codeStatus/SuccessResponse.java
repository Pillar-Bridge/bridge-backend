package com.pillar.bridge.util.apiUtils.codeStatus;

public enum SuccessResponse {
    OK(200, "OK"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted");
    private final int code;
    private final String message;

    SuccessResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
