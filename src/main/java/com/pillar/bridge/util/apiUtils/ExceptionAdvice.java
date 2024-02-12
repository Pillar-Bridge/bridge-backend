package com.pillar.bridge.util.apiUtils;

import com.pillar.bridge.util.apiUtils.ResponseDto;
import com.pillar.bridge.util.apiUtils.ResponseUtil;
import com.pillar.bridge.util.apiUtils.codeStatus.ErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseDto<String> handleMessageNotReadableException(HttpMessageNotReadableException ex) {
        if (ex.getMessage() != null && ex.getMessage().contains("Unexpected character")) {
            return ResponseUtil.FAILED(ErrorResponse.BAD_REQUEST, "요청 형식이 잘못되었습니다.", null);
        } else if (ex.getMessage().contains("Required request body is missing")) {
            return ResponseUtil.FAILED(ErrorResponse.BAD_REQUEST, "요청 본문이 누락되었습니다.", null);
        } else {
            return ResponseUtil.FAILED(ErrorResponse.BAD_REQUEST, "요청을 처리할 수 없습니다. 요청 형식을 확인해 주세요.", null);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseDto<String> handleException(Exception ex) {
        return ResponseUtil.FAILED(ErrorResponse.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseDto<String> handleAccessDeniedException(AccessDeniedException ex) {
        return ResponseUtil.FAILED(ErrorResponse.FORBIDDEN, "접근이 거부되었습니다.", null);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseDto<String> handleAuthenticationException(AuthenticationException ex) {
        return ResponseUtil.FAILED(ErrorResponse.UNAUTHORIZED, "인증에 실패하였습니다.", null);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseDto<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseUtil.FAILED(ErrorResponse.NOT_FOUND, "요청한 리소스를 찾을 수 없습니다.", null);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseDto<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return ResponseUtil.FAILED(ErrorResponse.CONFLICT, "데이터 충돌이 발생하였습니다.", null);
    }

}
