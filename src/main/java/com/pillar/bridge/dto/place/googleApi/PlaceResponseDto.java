package com.pillar.bridge.dto.place.googleApi;

import java.util.List;
import java.util.stream.Collectors;

public class PlaceResponseDto {
    private String place_name;
    private String category_group_name;

    public PlaceResponseDto() {}

    public PlaceResponseDto(String place_name, String category_group_name) {
        this.place_name = place_name;
        this.category_group_name = category_group_name;
    }

    // Getter and Setter
    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getCategory_group_name() {
        return category_group_name;
    }

    public void setCategory_group_name(String category_group_name) {
        this.category_group_name = category_group_name;
    }
}
