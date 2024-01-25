package com.pillar.bridge.controller;

import com.pillar.bridge.dto.PlacesDto;
import com.pillar.bridge.dto.googleApi.PlacesResponse;
import com.pillar.bridge.service.PlacesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlacesController {

    private final PlacesService placesService;

    public PlacesController(PlacesService placesService) {
        this.placesService = placesService;
    }

    @PostMapping("/places/google")
    public PlacesResponse searchNearby(@RequestBody PlacesDto request) {
        return placesService.searchNearbyPlaces(request);
    }
}
