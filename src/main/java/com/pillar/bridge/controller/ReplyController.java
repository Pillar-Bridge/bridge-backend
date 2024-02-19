package com.pillar.bridge.controller;

import com.pillar.bridge.apiUtils.ResponseDto;
import com.pillar.bridge.apiUtils.ResponseUtil;
import com.pillar.bridge.apiUtils.codeStatus.SuccessResponse;
import com.pillar.bridge.entitiy.Messages;
import com.pillar.bridge.repository.MessageRepository;
import com.pillar.bridge.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @GetMapping("/recommend-replies")
    public ResponseDto<Map<String, Object>> getLatestMessageResponse(@RequestParam("dialogueId") String dialogueId) {
        Map<String, Object> response = replyService.getLatestMessageResponse(dialogueId);

        return ResponseUtil.SUCCESS(SuccessResponse.OK, "성공적으로 반영되었습니다", response);
    }
}