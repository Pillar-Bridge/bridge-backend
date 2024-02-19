package com.pillar.bridge.service.place;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pillar.bridge.config.Constants;
import com.pillar.bridge.dto.place.kakaoApi.KaKaoResponse;
import com.pillar.bridge.dto.place.kakaoApi.PlaceNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RecommPlaceKaKAoService {
    private static final String AUTHORIZATION = "Authorization";
    private static final String KAKAO_APP_KEY_PREFIX = "KakaoAK ";
    @Autowired
    private RestTemplate restTemplate;

    @Value("${kakao.api.key}")
    private String kakaoApiKey;

    public KaKaoResponse searchPlaceByKeyword(double latitude, double longitude, int radius) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set(AUTHORIZATION, KAKAO_APP_KEY_PREFIX + kakaoApiKey);

            UriComponents uriComponents = UriComponentsBuilder.fromUriString(Constants.KAKAO_SEARCH_API)
                    .path(Constants.KAKAO_SEARCH_PATH)
                    .queryParam("category_group_code", String.join(",", "MT1", "CS2", "OL7", "BK9", "SW8", "CT1", "PO3", "AD5", "FD6", "CE7", "HP8", "PM9"))
                    .queryParam("y", latitude)
                    .queryParam("x", longitude)
                    .queryParam("radius", radius)
                    .queryParam("sort", "distance")
                    .build();

            HttpEntity<?> entity = new HttpEntity<>(headers);
            HttpEntity<String> response = restTemplate.exchange(
                    uriComponents.toUriString(),
                    HttpMethod.GET,
                    entity,
                    String.class);

            ObjectMapper mapper = new ObjectMapper();
            PlaceNameResponse placeNameResponse = mapper.readValue(response.getBody(), PlaceNameResponse.class);

            return new KaKaoResponse(placeNameResponse.getDocuments());

        } catch (Exception e) {
            return null;
        }
    }
}
