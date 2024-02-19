package com.pillar.bridge.service.place;

import com.pillar.bridge.dto.PlacesDto;
import com.pillar.bridge.dto.place.googleApi.PlacesRequest;
import com.pillar.bridge.dto.place.googleApi.PlacesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RecommPlaceGoogleService {
    @Value("${google.api.key}")
    private String apiKey;
    private final RestTemplate restTemplate;
    public RecommPlaceGoogleService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PlacesResponse searchNearbyPlaces(PlacesDto simpleRequest) {
        PlacesRequest request = convertToNearbySearchRequest(simpleRequest);

        String url = "https://places.googleapis.com/v1/places:searchNearby";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X-Goog-Api-Key", apiKey);
        headers.add("X-Goog-FieldMask", "places.displayName,places.primaryType");

        HttpEntity<PlacesRequest> entity = new HttpEntity<>(request, headers);
        return restTemplate.postForEntity(url, entity, PlacesResponse.class).getBody();
    }

    private PlacesRequest convertToNearbySearchRequest(PlacesDto placesDto) {
        PlacesRequest.LocationRestriction.Circle.Center center = new PlacesRequest.LocationRestriction.Circle.Center(
                placesDto.getLatitude(), placesDto.getLongitude());
        PlacesRequest.LocationRestriction.Circle circle = new PlacesRequest.LocationRestriction.Circle(center, 500.0);
        PlacesRequest.LocationRestriction locationRestriction = new PlacesRequest.LocationRestriction(circle);

        return new PlacesRequest(List.of("library", "school", "university", "movie_theater", "community_center", "accounting", "bank", "restaurant", "bakery", "cafe", "meal_takeaway", "steak_house", "bar", "local_government_office", "police", "post_office", "hospital", "pharmacy", "doctor", "medical_lab", "dental_clinic", "dentist", "drugstore", "lodging", "hotel", "store","barber_shop", "hair_salon","shopping_mall","store", "supermarket", "airport", "subway_station", "bus_station", "taxi_stand"), 10, "DISTANCE", locationRestriction);
    }
}
