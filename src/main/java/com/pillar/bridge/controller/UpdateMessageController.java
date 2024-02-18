package com.pillar.bridge.controller;

import com.pillar.bridge.apiUtils.ResponseDto;
import com.pillar.bridge.apiUtils.ResponseUtil;
import com.pillar.bridge.apiUtils.codeStatus.SuccessResponse;
import com.pillar.bridge.dto.UpdateMessage.UpdateRequest;
import com.pillar.bridge.dto.UpdateMessage.UpdateResponse;
import com.pillar.bridge.entitiy.Messages;
import com.pillar.bridge.service.UpdateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dialogues")
public class UpdateMessageController {

    @Autowired
    private UpdateMessageService messageService;

    @PostMapping("/{dialogueId}/messages")
    public ResponseDto<UpdateResponse> createMessage(@PathVariable("dialogueId") String dialogueId, @RequestBody UpdateRequest messageDTO) {
        Messages message = messageService.saveMessage(dialogueId, messageDTO);
        UpdateResponse responseDTO = new UpdateResponse(message.getMessage_Id(), message.getSpeaker(), message.getMessage_text());
        return ResponseUtil.SUCCESS(SuccessResponse.OK, "성공적으로 반영되었습니다", responseDTO);
    }

}
