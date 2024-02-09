package com.pillar.bridge.controller.Device;

import com.pillar.bridge.dto.DeviceDto;
import com.pillar.bridge.service.Device.DeviceRegisterService;
import com.pillar.bridge.util.apiUtils.ResponseDto;
import com.pillar.bridge.util.apiUtils.ResponseUtil;
import com.pillar.bridge.util.apiUtils.codeStatus.SuccessResponse;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class DeviceRegisterController {

    @Autowired
    private DeviceRegisterService deviceService;

    @GetMapping("/device/register")
    public ResponseDto<String> registerDevice(HttpServletResponse response) {
        DeviceDto device = deviceService.registerDevice();

        // refresh token 쿠키에 저장
        Cookie refreshTokenCookie = new Cookie("refreshToken", device.getRefreshToken());
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setSecure(true);
        refreshTokenCookie.setMaxAge(150 * 24 * 60 * 60);
        response.addCookie(refreshTokenCookie);

        return ResponseUtil.SUCCESS(SuccessResponse.OK, "토큰이 성공적으로 생성되었습니다", device.getAccessToken());
    }

}