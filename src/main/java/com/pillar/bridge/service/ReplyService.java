package com.pillar.bridge.service;

import com.pillar.bridge.entitiy.Messages;
import com.pillar.bridge.repository.DialogueRepository;
import com.pillar.bridge.repository.MessageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pillar.bridge.entitiy.Dialogue;

@Service
public class ReplyService {

    @Autowired
    private MessageRepository messagesRepository;
    @Autowired
    private DialogueRepository dialogueRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${ai.server.url}")
    private String baseUrl;

    public Map<String, Object> getLatestMessageResponse(String dialogueId) {
        List<String> messages = messagesRepository.findByTimeDESC(dialogueId).stream()
                .limit(2)
                .map(Messages::getMessage_text)
                .collect(Collectors.toList());

        Collections.reverse(messages);

        String latestMessages;
        if (messages.isEmpty()) {
            latestMessages = "No messages found for the given Dialogue ID";
        } else if (messages.size() == 1) {
            latestMessages = messages.get(0);
        } else {
            latestMessages = String.join("/", messages);
        }


        String place = dialogueRepository.findById(dialogueId)
                .map(Dialogue::getPlace)
                .orElse("null");

        Map<String, String> request = new HashMap<>();
        request.put("place", place);
        request.put("text", latestMessages);
        request.put("lang", "eng");

        String fullUrl = baseUrl + "/recomm";

        ResponseEntity<Map> response = restTemplate.postForEntity(fullUrl, request, Map.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            Map<String, Object> responseBody = response.getBody();
            String situation = (String) responseBody.get("situation"); // situation 값을 추출

            Dialogue dialogue = dialogueRepository.findById(dialogueId)
                    .orElseThrow(() -> new EntityNotFoundException("Dialogue not found with id: " + dialogueId));
            dialogue.setSituation(situation); // situation 값을 Dialogue 엔티티에 설정
            dialogueRepository.save(dialogue); // 변경사항을 데이터베이스에 저장

            return responseBody;
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to call external API");
            return errorResponse;
        }
    }
}