package com.nubisoft.nubiweather.services;

import com.nubisoft.nubiweather.models.CurrentWeather;
import com.nubisoft.nubiweather.models.ForecastWeather;
import com.nubisoft.nubiweather.repositories.CurrentWeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private static final String WEATHER_API_KEY = "7e4875499b614b6189a161653242206";
    private final RestTemplate restTemplate;
    private final CurrentWeatherRepository currentWeatherRepository;

    public CurrentWeather getRealtimeWeather(String city) {
        String url = "http://api.weatherapi.com/v1/current.json?key=" + WEATHER_API_KEY + "&q=" + city;
        return restTemplate.getForObject(url, CurrentWeather.class);
    }

    public ForecastWeather getForecastWeather(String city, Integer days) {
        String url = "http://api.weatherapi.com/v1/forecast.json?key=" + WEATHER_API_KEY + "&q=" + city + "&days=" + days;
        return restTemplate.getForObject(url, ForecastWeather.class);
    }

    public List<CurrentWeather> getCurrentWeatherList() {
        return (List<CurrentWeather>) currentWeatherRepository.findAll();
    }

    public CurrentWeather getCurrentWeatherById(int id) {
        return currentWeatherRepository.findById(id);
    }

    public CurrentWeather createCurrentWeather(CurrentWeather currentWeather) {
        return currentWeatherRepository.save(currentWeather);
    }

    public void deleteCurrentWeather(int id) {
        CurrentWeather currentWeather = currentWeatherRepository.findById(id);
        currentWeatherRepository.delete(currentWeather);
    }

    public void updateCurrentWeather(int id, CurrentWeather updatedCurrentWeather) {
        CurrentWeather currentWeather = currentWeatherRepository.findById(id);
        currentWeather.setCurrent(updatedCurrentWeather.getCurrent());
        currentWeather.setLocation(updatedCurrentWeather.getLocation());
        currentWeatherRepository.save(currentWeather);
    }
}
