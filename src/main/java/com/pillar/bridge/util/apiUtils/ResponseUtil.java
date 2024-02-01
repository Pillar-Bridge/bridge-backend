package com.pillar.bridge.util.apiUtils;

import com.pillar.bridge.util.apiUtils.codeStatus.ErrorResponse;
import com.pillar.bridge.util.apiUtils.codeStatus.SuccessResponse;

public class ResponseUtil {

    public static <T> ResponseDto<T> SUCCESS(SuccessResponse success, String message, T data) {
        return new ResponseDto<>(true, success.getCode(), message, data);
    }

    public static <T> ResponseDto<T> FAILED(ErrorResponse error, T data) {
        return new ResponseDto<>(false, error.getCode(), error.getMessage(), data);
    }

}
