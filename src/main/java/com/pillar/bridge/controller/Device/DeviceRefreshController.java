package com.pillar.bridge.controller.Device;

import com.pillar.bridge.service.Device.DeviceRefreshService;
import com.pillar.bridge.util.apiUtils.ResponseDto;
import com.pillar.bridge.util.apiUtils.ResponseUtil;
import com.pillar.bridge.util.apiUtils.codeStatus.SuccessResponse;
import com.pillar.bridge.util.apiUtils.codeStatus.ErrorResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceRefreshController {

    @Autowired
    private DeviceRefreshService deviceRefreshService;

    @GetMapping("/device/refresh")
    public ResponseDto<String> refreshToken(HttpServletRequest request, HttpServletResponse response) {
        String refreshToken = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("refreshToken")) {
                    refreshToken = cookie.getValue();
                    break;
                }
            }
        }

        if (refreshToken != null) {
            String newAccessToken = deviceRefreshService.refreshToken(refreshToken);

            if (newAccessToken != null) {
                return ResponseUtil.SUCCESS(SuccessResponse.OK, "토큰이 성공적으로 갱신되었습니다.", newAccessToken);
            } else {
                return ResponseUtil.FAILED(ErrorResponse.UNAUTHORIZED, "refresh token이 유효하지 않습니다.", null);
            }
        } else {
            return ResponseUtil.FAILED(ErrorResponse.BAD_REQUEST, "쿠키에서 refresh token을 찾을 수 없습니다.", null);
        }
    }
}