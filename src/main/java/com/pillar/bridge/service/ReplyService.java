package com.pillar.bridge.service;

import com.pillar.bridge.entitiy.Messages;
import com.pillar.bridge.repository.DialogueRepository;
import com.pillar.bridge.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;
import com.pillar.bridge.entitiy.Dialogue;

@Service
public class ReplyService {

    @Autowired
    private MessageRepository messagesRepository;

    @Autowired
    private DialogueRepository dialogueRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Map<String, Object> getLatestMessageResponse(String dialogueId) {
        // DB에서 대화 ID에 해당하는 가장 최근 메시지를 가져옴
        String latestMessage = messagesRepository.findByDialogueId(dialogueId).stream()
                .findFirst()
                .map(Messages::getMessage_text)
                .orElse("No message found for the given Dialogue ID");


        String place = dialogueRepository.findById(dialogueId)
                .map(Dialogue::getPlace)
                .orElse("null");

        // 외부 API 호출을 위한 request 객체 생성
        Map<String, String> request = new HashMap<>();
        request.put("place", place);
        request.put("text", latestMessage);
        request.put("lang", "eng");

        // 외부 API 호출
        ResponseEntity<Map> response = restTemplate.postForEntity("http://203.253.71.189:5000/recomm", request, Map.class);

        // API 응답 처리
        if (response.getStatusCode() == HttpStatus.OK) {
            // 외부 API로부터 받은 응답 전체를 반환
            return response.getBody();
        } else {
            // API 호출 실패 시, 적절한 처리 또는 예외 처리
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to call external API");
            return errorResponse;
        }
    }
}