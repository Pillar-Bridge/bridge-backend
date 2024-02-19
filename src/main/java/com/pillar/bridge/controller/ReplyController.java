package com.pillar.bridge.controller;

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
    public ResponseEntity<Map<String, Object>> getLatestMessageResponse(@RequestParam("dialogueId") String dialogueId) {
        Map<String, Object> response = replyService.getLatestMessageResponse(dialogueId);

        if(response.containsKey("error")) {
            // API 호출에 실패한 경우, 적절한 HTTP 상태 코드와 함께 에러 메시지 반환
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            // 성공적인 응답 처리
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}