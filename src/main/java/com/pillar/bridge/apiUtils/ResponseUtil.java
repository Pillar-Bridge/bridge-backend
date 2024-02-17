package com.pillar.bridge.apiUtils;

import com.pillar.bridge.apiUtils.codeStatus.ErrorResponse;
import com.pillar.bridge.apiUtils.codeStatus.SuccessResponse;

public class ResponseUtil {

    public static <T> ResponseDto<T> SUCCESS(SuccessResponse success, String message, T data) {
        return new ResponseDto<>(true, success.getCode(), message, data);
    }

    public static <T> ResponseDto<T> FAILED(ErrorResponse error, String message, T data) {
        return new ResponseDto<>(false, error.getCode(), message, data);
    }

}
