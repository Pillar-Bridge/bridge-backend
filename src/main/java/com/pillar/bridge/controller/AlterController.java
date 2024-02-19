package com.pillar.bridge.controller;

import com.pillar.bridge.apiUtils.ResponseDto;
import com.pillar.bridge.apiUtils.ResponseUtil;
import com.pillar.bridge.apiUtils.codeStatus.SuccessResponse;
import com.pillar.bridge.dto.alter.AlterResponse;
import com.pillar.bridge.dto.alter.AlterRequest;
import com.pillar.bridge.service.AlterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlterController {
    private final AlterService alterService;

    @Autowired
    public AlterController(AlterService alterService) {
        this.alterService = alterService;
    }

    @PostMapping("/provide-modification-options")
    public ResponseDto<AlterResponse> getOptions(@RequestBody AlterRequest request) {
        return ResponseUtil.SUCCESS(SuccessResponse.OK, "요청에 성공했습니다", alterService.getOptions(request));
    }
}
