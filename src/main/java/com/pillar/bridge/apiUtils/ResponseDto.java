package com.pillar.bridge.apiUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonPropertyOrder({"isSuccess", "code", "message", "createdAt", "data"})
public class ResponseDto<T> {
    @JsonProperty("isSuccess")
    private final boolean isSuccess;
    private final int code;
    private final String message;
    private final LocalDateTime createdAt;
    private final T data;

    // 생성자
    public ResponseDto(boolean isSuccess, int code, String message, T data) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
        this.createdAt = LocalDateTime.now();
        this.data = data;
    }
}
