package com.pillar.bridge.dto.place.googleApi;

import java.util.List;

public class PlacesRequest {
    private List<String> includedTypes;
    private int maxResultCount;
    private String rankPreference;
    private LocationRestriction locationRestriction;

    public PlacesRequest() {
    }

    public PlacesRequest(List<String> includedTypes, int maxResultCount, String rankPreference, LocationRestriction locationRestriction) {
        this.includedTypes = includedTypes;
        this.maxResultCount = maxResultCount;
        this.rankPreference = rankPreference;
        this.locationRestriction = locationRestriction;
    }

    public List<String> getIncludedTypes() {
        return includedTypes;
    }

    public void setIncludedTypes(List<String> includedTypes) {
        this.includedTypes = includedTypes;
    }

    public int getMaxResultCount() {
        return maxResultCount;
    }

    public void setMaxResultCount(int maxResultCount) {
        this.maxResultCount = maxResultCount;
    }

    public String getRankPreference() {
        return rankPreference;
    }

    public void setRankPreference(String rankPreference) {
        this.rankPreference = rankPreference;
    }

    public LocationRestriction getLocationRestriction() {
        return locationRestriction;
    }

    public void setLocationRestriction(LocationRestriction locationRestriction) {
        this.locationRestriction = locationRestriction;
    }

    // LocationRestriction 내부 클래스
    public static class LocationRestriction {
        private Circle circle;

        public LocationRestriction() {
        }

        public LocationRestriction(Circle circle) {
            this.circle = circle;
        }

        public Circle getCircle() {
            return circle;
        }

        public void setCircle(Circle circle) {
            this.circle = circle;
        }

        // Circle 내부 클래스
        public static class Circle {
            private Center center;
            private double radius;

            public Circle() {
            }

            public Circle(Center center, double radius) {
                this.center = center;
                this.radius = radius;
            }

            public Center getCenter() {
                return center;
            }

            public void setCenter(Center center) {
                this.center = center;
            }

            public double getRadius() {
                return radius;
            }

            public void setRadius(double radius) {
                this.radius = radius;
            }

            // Center 내부 클래스
            public static class Center {
                private double latitude;
                private double longitude;

                public Center() {
                }

                public Center(double latitude, double longitude) {
                    this.latitude = latitude;
                    this.longitude = longitude;
                }

                public double getLatitude() {
                    return latitude;
                }

                public void setLatitude(double latitude) {
                    this.latitude = latitude;
                }

                public double getLongitude() {
                    return longitude;
                }

                public void setLongitude(double longitude) {
                    this.longitude = longitude;
                }
            }
        }
    }
}