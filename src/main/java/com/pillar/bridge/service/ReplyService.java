package com.pillar.bridge.service;

import com.pillar.bridge.entitiy.Messages;
import com.pillar.bridge.repository.DialogueRepository;
import com.pillar.bridge.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${ai.server.url}")
    private String baseUrl;

    public Map<String, Object> getLatestMessageResponse(String dialogueId) {
        String latestMessage = messagesRepository.findByTimeASC(dialogueId).stream()
                .findFirst()
                .map(Messages::getMessage_text)
                .orElse("No message found for the given Dialogue ID");


        String place = dialogueRepository.findById(dialogueId)
                .map(Dialogue::getPlace)
                .orElse("null");

        Map<String, String> request = new HashMap<>();
        request.put("place", place);
        request.put("text", latestMessage);
        request.put("lang", "eng");

        String fullUrl = baseUrl + "/recomm";

        ResponseEntity<Map> response = restTemplate.postForEntity(fullUrl, request, Map.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to call external API");
            return errorResponse;
        }
    }
}