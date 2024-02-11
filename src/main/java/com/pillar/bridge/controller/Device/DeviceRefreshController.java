package com.pillar.bridge.controller.Device;

import com.pillar.bridge.service.Device.DeviceRefreshService;
import com.pillar.bridge.util.apiUtils.ResponseDto;
import com.pillar.bridge.util.apiUtils.ResponseUtil;
import com.pillar.bridge.util.apiUtils.codeStatus.SuccessResponse;
import com.pillar.bridge.util.apiUtils.codeStatus.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceRefreshController {

    @Autowired
    private DeviceRefreshService deviceRefreshService;

    @PostMapping("/device/refresh")
    public ResponseDto<String> refreshToken(@RequestHeader("RefreshToken") String refreshToken) {
        if (refreshToken != null && !refreshToken.isEmpty()) {
            String newAccessToken = deviceRefreshService.refreshToken(refreshToken);

            if (newAccessToken != null) {
                return ResponseUtil.SUCCESS(SuccessResponse.OK, "토큰이 성공적으로 갱신되었습니다.", newAccessToken);
            } else {
                return ResponseUtil.FAILED(ErrorResponse.UNAUTHORIZED, "Refresh Token이 유효하지 않습니다.", null);
            }
        } else {
            return ResponseUtil.FAILED(ErrorResponse.BAD_REQUEST, "헤더에서 Refresh Token을 찾을 수 없습니다.", null);
        }
    }
}