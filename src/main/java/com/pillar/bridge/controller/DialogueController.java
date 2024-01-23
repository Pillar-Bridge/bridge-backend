package com.pillar.bridge.controller;

import com.pillar.bridge.apiUtils.codeStatus.ErrorResponse;
import com.pillar.bridge.dto.DialogueDto;
import com.pillar.bridge.service.DialogueService;
import com.pillar.bridge.apiUtils.ResponseDto;
import com.pillar.bridge.apiUtils.ResponseUtil;
import com.pillar.bridge.apiUtils.codeStatus.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dialogues")
public class DialogueController {
    @Autowired
    private DialogueService dialogueService;

    @PostMapping
    public ResponseEntity<ResponseDto<String>> createDialogue(@RequestBody DialogueDto dialogueDto) {
        try {
            dialogueService.createDialogue(dialogueDto.getPlace());
            return ResponseEntity.ok(ResponseUtil.SUCCESS(SuccessResponse.OK, "Dialogue created successfully", "OK"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(ResponseUtil.FAILED(ErrorResponse.INTERNAL_SERVER_ERROR, e.getMessage()));
        }
    }
}
