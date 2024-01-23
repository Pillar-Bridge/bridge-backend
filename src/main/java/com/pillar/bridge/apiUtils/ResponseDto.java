package com.pillar.bridge.apiUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonPropertyOrder({"isSuccess", "code", "message", "created_at", "data"})
public class ResponseDto<T> {
    @JsonProperty("isSuccess")
    private final boolean isSuccess;
    private final int code;
    private final String message;
    private final LocalDateTime created_at;
    private final T data;

    public ResponseDto(boolean isSuccess, int code, String message, T data) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
        this.created_at = LocalDateTime.now();
        this.data = data;
    }
}
