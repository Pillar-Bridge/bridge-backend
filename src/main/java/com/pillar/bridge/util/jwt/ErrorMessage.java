package com.pillar.bridge.util.jwt;

public enum ErrorMessage {
    UNKNOWN_ERROR(500, "알 수 없는 오류가 발생했습니다"),
    WRONG_TYPE_TOKEN(400, "토큰 형식이 일치하지 않습니다"),
    EXPIRED_TOKEN(401, "토큰이 만료되었습니다"),
    UNSUPPORTED_TOKEN(400, "지원되지 않는 토큰입니다"),
    ACCESS_DENIED(403, "토큰이 누락되었습니다");

    private final int code;
    private final String msg;

    ErrorMessage(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

