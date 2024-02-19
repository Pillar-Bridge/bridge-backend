package com.pillar.bridge.controller;

import com.pillar.bridge.apiUtils.ResponseDto;
import com.pillar.bridge.apiUtils.ResponseUtil;
import com.pillar.bridge.apiUtils.codeStatus.ErrorResponse;
import com.pillar.bridge.apiUtils.codeStatus.SuccessResponse;
import com.pillar.bridge.dto.alter.AlterResponse;
import com.pillar.bridge.dto.alter.AlterRequest;
import com.pillar.bridge.repository.DeviceRepository;
import com.pillar.bridge.service.AlterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlterController {
    private final AlterService alterService;
    private final DeviceRepository deviceRepository;

    @Autowired
    public AlterController(AlterService alterService, DeviceRepository deviceRepository) {
        this.alterService = alterService;
        this.deviceRepository = deviceRepository;
    }

    @PostMapping("/provide-modification-options")
    public ResponseDto<AlterResponse> getOptions(@RequestBody AlterRequest request, @RequestHeader("UUID") String uuid) {
        if (deviceRepository.findByUuid(uuid).isEmpty()) {
            return ResponseUtil.FAILED(ErrorResponse.BAD_REQUEST, "UUID가 유효하지 않습니다", null);
        }
        return ResponseUtil.SUCCESS(SuccessResponse.OK, "요청에 성공했습니다", alterService.getOptions(request));
    }
}
