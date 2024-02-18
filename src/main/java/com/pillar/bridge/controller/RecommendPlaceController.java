package com.pillar.bridge.controller;

import com.pillar.bridge.apiUtils.ResponseDto;
import com.pillar.bridge.apiUtils.ResponseUtil;
import com.pillar.bridge.apiUtils.codeStatus.SuccessResponse;
import com.pillar.bridge.dto.NameList;
import com.pillar.bridge.service.RecommendPlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class RecommendPlaceController {

    private final Logger logger = LoggerFactory.getLogger(RecommendPlaceController.class);

    @Autowired
    RecommendPlaceService recommendPlaceService;

    @GetMapping("/places/recommendations")
    public ResponseDto<NameList> searchPlaceByKeywordGet(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude,
            @RequestParam(value = "radius", defaultValue = "500") int radius) {

        logger.info("위도 [{}], 경도 [{}], radius [{}]", latitude, longitude, radius);

        NameList nameList = recommendPlaceService.searchPlaceByKeyword(latitude, longitude, radius);
        return ResponseUtil.SUCCESS(SuccessResponse.OK, "Place search successful", nameList);
    }
}


