package com.pillar.bridge.dto.place.googleApi;

public class PlaceResponse {
    private String place_name;
    private String category_group_name;

    public PlaceResponse() {}

    public PlaceResponse(String place_name, String category_group_name) {
        this.place_name = place_name;
        this.category_group_name = category_group_name;
    }

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
