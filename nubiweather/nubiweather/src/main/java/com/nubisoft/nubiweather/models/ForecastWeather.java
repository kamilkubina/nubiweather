package com.nubisoft.nubiweather.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ForecastWeather {
    @JsonProperty("location")
    private Location location;

    @JsonProperty("forecast")
    private Forecast forecast;

    public static class Location {
        @JsonProperty("name")
        private String name;
    }

    public static class Forecast {
        @JsonProperty("forecastday")
        private List<ForecastDay> forecastDays;
    }

    public static class ForecastDay {
        @JsonProperty("date")
        private String date;

        @JsonProperty("day")
        private Day day;
    }

    public static class Day {
        @JsonProperty("avgtemp_c")
        private Double avgTempC;

        @JsonProperty("condition")
        private Condition condition;

        public static class Condition {
            @JsonProperty("text")
            private String text;
        }
    }
}
