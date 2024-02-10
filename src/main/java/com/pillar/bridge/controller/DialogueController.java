package com.pillar.bridge.controller;

import com.pillar.bridge.dto.dialogue.DialogueResponse;
import com.pillar.bridge.entitiy.Dialogue;
import com.pillar.bridge.util.apiUtils.codeStatus.ErrorResponse;
import com.pillar.bridge.dto.dialogue.DialogueRequest;
import com.pillar.bridge.service.DialogueService;
import com.pillar.bridge.util.apiUtils.ResponseDto;
import com.pillar.bridge.util.apiUtils.ResponseUtil;
import com.pillar.bridge.util.apiUtils.codeStatus.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


@RestController
@RequestMapping("/dialogues")
public class DialogueController {
    @Autowired
    private DialogueService dialogueService;

    @PostMapping
    public ResponseDto<DialogueResponse> createDialogue(@RequestBody DialogueRequest dialogueDto) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String uuid = (String) authentication.getPrincipal();

            Dialogue dialogue = dialogueService.createDialogue(dialogueDto.getPlace(), uuid);
            DialogueResponse response = new DialogueResponse(dialogue.getId());

            return ResponseUtil.SUCCESS(SuccessResponse.OK, "성공적으로 반영되었습니다", response);
        } catch (AuthenticationException e) {
            return ResponseUtil.FAILED(ErrorResponse.UNAUTHORIZED, "인증 실패", null);
        } catch (AccessDeniedException e) {
            return ResponseUtil.FAILED(ErrorResponse.FORBIDDEN, "권한 부족", null);
        } catch (DataIntegrityViolationException e) {
            return ResponseUtil.FAILED(ErrorResponse.CONFLICT, "데이터 충돌", null);
        } catch (Exception e) {
            return ResponseUtil.FAILED(ErrorResponse.INTERNAL_SERVER_ERROR, "internal server error", null);
        }
    }
}


