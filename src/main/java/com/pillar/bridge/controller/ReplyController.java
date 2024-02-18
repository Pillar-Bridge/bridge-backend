package com.pillar.bridge.controller;

import com.pillar.bridge.entitiy.Messages;
import com.pillar.bridge.repository.MessageRepository;
import com.pillar.bridge.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @GetMapping("/recommend-replies")
    public String getLatestMessageText(@RequestParam("dialogueId") String dialogueId) {
        return replyService.getLatestMessageText(dialogueId);
    }
}