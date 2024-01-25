package com.pillar.bridge.dto;

import java.util.List;

public class NearbySearchResponse {
    private List<Place> places;

    // 기본 생성자
    public NearbySearchResponse() {}

    // 매개변수가 있는 생성자
    public NearbySearchResponse(List<Place> places) {
        this.places = places;
    }

    // Getter
    public List<Place> getPlaces() {
        return places;
    }

    // Setter
    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public static class Place {
        private DisplayName displayName;

        // 기본 생성자
        public Place() {}

        // 매개변수가 있는 생성자
        public Place(DisplayName displayName) {
            this.displayName = displayName;
        }

        // Getter
        public DisplayName getDisplayName() {
            return displayName;
        }

        // Setter
        public void setDisplayName(DisplayName displayName) {
            this.displayName = displayName;
        }

        public static class DisplayName {
            private String text;
            private String languageCode;

            // 기본 생성자
            public DisplayName() {}

            // 매개변수가 있는 생성자
            public DisplayName(String text, String languageCode) {
                this.text = text;
                this.languageCode = languageCode;
            }

            // Getter
            public String getText() {
                return text;
            }

            // Setter
            public void setText(String text) {
                this.text = text;
            }

            // Getter
            public String getLanguageCode() {
                return languageCode;
            }

            // Setter
            public void setLanguageCode(String languageCode) {
                this.languageCode = languageCode;
            }
        }
    }
}
