package com.nubisoft.nubiweather.controllers;

import com.nubisoft.nubiweather.models.CurrentWeather;
import com.nubisoft.nubiweather.models.ForecastWeather;
import com.nubisoft.nubiweather.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/realtime-weather")
    public CurrentWeather getRealtimeWeather(@RequestParam String city) {
        return weatherService.getRealtimeWeather(city);
    }

    @GetMapping("/forecast-weather")
    public ForecastWeather getForecastWeather(@RequestParam String city, @RequestParam Integer days) {
        return weatherService.getForecastWeather(city, days);
    }
}
