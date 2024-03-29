package com.pillar.bridge.apiUtils.codeStatus;

public enum ErrorResponse {
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    NOT_FOUND(404, "Not Found"),
    CONFLICT(409, "Conflict"),
    FORBIDDEN(403, "Forbidden"),
    INTERNAL_SERVER_ERROR( 500, "Internal Server Error");

    private final int code;
    private final String message;

    ErrorResponse(int code, String message) {
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

