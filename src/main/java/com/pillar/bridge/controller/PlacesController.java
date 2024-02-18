package com.pillar.bridge.controller;

import com.pillar.bridge.apiUtils.ResponseDto;
import com.pillar.bridge.apiUtils.ResponseUtil;
import com.pillar.bridge.apiUtils.codeStatus.SuccessResponse;
import com.pillar.bridge.dto.NameList;
import com.pillar.bridge.dto.PlacesDto;
import com.pillar.bridge.dto.place.googleApi.PlacesResponse;
import com.pillar.bridge.service.RecommPlaceGoogleService;
import com.pillar.bridge.service.RecommPlaceKaKAoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlacesController {

    private final Logger logger = LoggerFactory.getLogger(PlacesController.class);

    @Autowired
    private RecommPlaceKaKAoService recommendPlaceService;

    @Autowired
    private RecommPlaceGoogleService placesService;

    private static final double LATITUDE_MIN = 33.1;
    private static final double LATITUDE_MAX = 38.0;
    private static final double LONGITUDE_MIN = 124.6;
    private static final double LONGITUDE_MAX = 131.9;

    @GetMapping("/places/recommendations")
    public ResponseDto<?> searchPlaces(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude,
            @RequestParam(value = "radius", defaultValue = "500", required = false) Integer radius) {

        if (isWithinRange(latitude, longitude)) {
            logger.info("한국 내 검색: 위도 [{}], 경도 [{}], 반경 [{}]", latitude, longitude, radius);
            NameList nameList = recommendPlaceService.searchPlaceByKeyword(latitude, longitude, radius);
            return ResponseUtil.SUCCESS(SuccessResponse.OK, "Place search successful", nameList);
        } else {
            logger.info("외국 검색: 위도 [{}], 경도 [{}]", latitude, longitude);
            PlacesDto request = new PlacesDto();
            request.setLatitude(latitude);
            request.setLongitude(longitude);
            PlacesResponse response = placesService.searchNearbyPlaces(request);
            return ResponseUtil.SUCCESS(SuccessResponse.OK, "Place search successful", response);
        }
    }

    private boolean isWithinRange(double latitude, double longitude) {
        return latitude >= LATITUDE_MIN && latitude <= LATITUDE_MAX &&
                longitude >= LONGITUDE_MIN && longitude <= LONGITUDE_MAX;
    }
}
