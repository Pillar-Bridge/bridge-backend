package com.pillar.bridge.controller;

import com.pillar.bridge.apiUtils.ResponseDto;
import com.pillar.bridge.apiUtils.ResponseUtil;
import com.pillar.bridge.apiUtils.codeStatus.SuccessResponse;
import com.pillar.bridge.dto.FullDialogue.FullDialogueDto;
import com.pillar.bridge.dto.FullDialogue.FullDialogueResponseDto;
import com.pillar.bridge.service.FullDialogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FullDialogueController {

    @Autowired
    private FullDialogueService fullDialogueService;

    @GetMapping("/dialogue/{dialogueId}")
    public ResponseDto<FullDialogueResponseDto> getDialogueDetailsTest(@PathVariable("dialogueId") String dialogueId) {
        FullDialogueResponseDto response = fullDialogueService.getDialogueDetails(dialogueId);
        return ResponseUtil.SUCCESS(SuccessResponse.OK, "success", response);
    }
}