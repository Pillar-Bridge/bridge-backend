package com.pillar.bridge.dto.place.googleApi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlacesResponse {
    private List<Place> places;
    public PlacesResponse() {}
    public PlacesResponse(List<Place> places) {
        this.places = places;
    }
    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public static class Place {
        private DisplayName displayName;


        private String primaryType;

        public Place() {}

        public Place(DisplayName displayName, String primaryType) {
            this.displayName = displayName;
            this.primaryType = primaryType;
        }

        public DisplayName getDisplayName() {
            return displayName;
        }

        public void setDisplayName(DisplayName displayName) {
            this.displayName = displayName;
        }

        public String getPrimaryType() {
            return primaryType;
        }

        public void setPrimaryType(String primaryType) {
            this.primaryType = primaryType;
        }

        public static class DisplayName {

            private String text;

            private String languageCode;

            public DisplayName() {}

            public DisplayName(String text, String languageCode) {
                this.text = text;
                this.languageCode = languageCode;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getLanguageCode() {
                return languageCode;
            }

            public void setLanguageCode(String languageCode) {
                this.languageCode = languageCode;
            }
        }

    }
}
