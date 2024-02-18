package com.pillar.bridge.service;

import com.pillar.bridge.dto.RequestModel;
import com.pillar.bridge.entitiy.Messages;
import com.pillar.bridge.repository.MessageRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ReplyService {

    @Autowired
    private MessageRepository messagesRepository;

    @Autowired
    private RestTemplate restTemplate;

    public String getLatestMessageText(String dialogueId) {
        return messagesRepository.findByDialogueId(dialogueId).stream()
                .findFirst() // 첫 번째 요소(가장 최근 메시지)를 가져옴
                .map(Messages::getMessage_text)
                .orElse("No message found for the given Dialogue ID");
    }

    public String sendHttpRequest(String dialogueId) {
        String messageText = getLatestMessageText(dialogueId);
        try {
            URL url = new URL("http://203.253.71.189:5000/recomm");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            JSONObject jsonInput = new JSONObject();
            jsonInput.put("place", "cafe");
            jsonInput.put("text", messageText);
            jsonInput.put("lang", "en");

            try(DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.writeBytes(jsonInput.toString());
                wr.flush();
            }

            StringBuilder response = new StringBuilder();
            try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
            }

            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
