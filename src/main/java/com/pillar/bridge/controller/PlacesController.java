package com.pillar.bridge.controller;

import com.pillar.bridge.apiUtils.ResponseDto;
import com.pillar.bridge.apiUtils.ResponseUtil;
import com.pillar.bridge.apiUtils.codeStatus.SuccessResponse;
import com.pillar.bridge.dto.PlacesDto;
import com.pillar.bridge.dto.googleApi.PlacesResponse;
import com.pillar.bridge.service.PlacesService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlacesController {

    private final PlacesService placesService;

    public PlacesController(PlacesService placesService) {
        this.placesService = placesService;
    }

    @GetMapping("/places/recommendations/google")
    public ResponseDto<PlacesResponse> searchNearby(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude,
            @RequestParam("radius") int radius) {

        PlacesDto request = new PlacesDto();
        request.setLatitude(latitude);
        request.setLongitude(longitude);

        PlacesResponse response = placesService.searchNearbyPlaces(request);
        return ResponseUtil.SUCCESS(SuccessResponse.OK, "Successfully retrieved data", response);
    }

}
