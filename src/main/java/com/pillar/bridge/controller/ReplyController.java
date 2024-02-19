package com.pillar.bridge.controller;

import com.pillar.bridge.apiUtils.ResponseDto;
import com.pillar.bridge.apiUtils.ResponseUtil;
import com.pillar.bridge.apiUtils.codeStatus.ErrorResponse;
import com.pillar.bridge.apiUtils.codeStatus.SuccessResponse;
import com.pillar.bridge.entitiy.Messages;
import com.pillar.bridge.repository.DeviceRepository;
import com.pillar.bridge.repository.DialogueRepository;
import com.pillar.bridge.repository.MessageRepository;
import com.pillar.bridge.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ReplyController {

    @Autowired
    private ReplyService replyService;
    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private DialogueRepository dialogueRepository;

    @GetMapping("/recommend-replies")
    public ResponseDto<Map<String, Object>> getLatestMessageResponse(@RequestParam("dialogueId") String dialogueId, @RequestHeader("UUID") String uuid) {
        if (deviceRepository.findByUuid(uuid).isEmpty()) {
            return ResponseUtil.FAILED(ErrorResponse.BAD_REQUEST, "UUID가 유효하지 않습니다", null);
        }
        //dialogueID 유효성 검증
        if (dialogueRepository.findById(dialogueId).isEmpty()) {
            return ResponseUtil.FAILED(ErrorResponse.BAD_REQUEST, "dialogueId가 유효하지 않습니다", null);
        }
        Map<String, Object> response = replyService.getLatestMessageResponse(dialogueId);
        return ResponseUtil.SUCCESS(SuccessResponse.OK, "성공적으로 반영되었습니다", response);
    }
}