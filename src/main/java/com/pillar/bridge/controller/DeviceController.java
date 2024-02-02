package com.pillar.bridge.controller;

import com.pillar.bridge.dto.DeviceDto;
import com.pillar.bridge.service.DeviceService;
import com.pillar.bridge.util.apiUtils.ResponseDto;
import com.pillar.bridge.util.apiUtils.ResponseUtil;
import com.pillar.bridge.util.apiUtils.codeStatus.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/register")
    public ResponseDto<DeviceDto> registerDevice() {
        DeviceDto device = deviceService.registerDevice();
        return ResponseUtil.SUCCESS(SuccessResponse.OK, "토큰 생성 완료", device);
    }
}
