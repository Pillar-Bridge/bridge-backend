package com.pillar.bridge.dto.googleApi;

import java.util.List;

public class PlacesResponse {
    private List<Place> places;

    // 기본 생성자
    public PlacesResponse() {}

    // 매개변수가 있는 생성자
    public PlacesResponse(List<Place> places) {
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
        private List<String> types;

        // 기본 생성자
        public Place() {}

        // 매개변수가 있는 생성자
        public Place(DisplayName displayName, List<String> types) {
            this.displayName = displayName;
            this.types = types;
        }

        // Getter와 Setter 메소드
        public DisplayName getDisplayName() {
            return displayName;
        }

        public void setDisplayName(DisplayName displayName) {
            this.displayName = displayName;
        }

        public List<String> getTypes() {
            return types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
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
