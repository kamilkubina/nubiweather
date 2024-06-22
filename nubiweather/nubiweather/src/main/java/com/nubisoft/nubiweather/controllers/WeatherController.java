package com.nubisoft.nubiweather.controllers;

import com.nubisoft.nubiweather.models.CurrentWeather;
import com.nubisoft.nubiweather.models.ForecastWeather;
import com.nubisoft.nubiweather.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/currentWeather")
    public List<CurrentWeather> getCurrentWeatherList() {
        return weatherService.getCurrentWeatherList();
    }

    @GetMapping("/currentWeather/{id}")
    public CurrentWeather getCurrentWeatherById(@PathVariable("id") int id) {
        return weatherService.getCurrentWeatherById(id);
    }

    @PostMapping("/currentWeather")
    public CurrentWeather createCurrentWeather(@RequestBody CurrentWeather currentWeather) {
        return weatherService.createCurrentWeather(currentWeather);
    }

    @DeleteMapping("/currentWeather/{id}")
    public void deleteCurrentWeather(@PathVariable("id") int id) {
        weatherService.deleteCurrentWeather(id);
    }

    @PatchMapping("currentWeather/{id}")
    public void updateCurrentWeather(@PathVariable int id, @RequestBody CurrentWeather currentWeather) {
        weatherService.updateCurrentWeather(id, currentWeather);
    }
}
