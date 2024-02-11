package com.pillar.bridge.controller.Device;

import com.pillar.bridge.dto.RegisterResponse;
import com.pillar.bridge.service.Device.DeviceRegisterService;
import com.pillar.bridge.util.apiUtils.ResponseDto;
import com.pillar.bridge.util.apiUtils.ResponseUtil;
import com.pillar.bridge.util.apiUtils.codeStatus.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class DeviceRegisterController {

    @Autowired
    private DeviceRegisterService deviceService;

    @GetMapping("/device/register")
    public ResponseDto<RegisterResponse> registerDevice(HttpServletResponse response) {
        RegisterResponse device = deviceService.registerDevice();

        return ResponseUtil.SUCCESS(SuccessResponse.OK, "토큰이 성공적으로 생성되었습니다", device);
    }

}