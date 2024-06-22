package com.nubisoft.nubiweather.repositories;

import com.nubisoft.nubiweather.models.CurrentWeather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentWeatherRepository extends CrudRepository<CurrentWeather, Long> {
    CurrentWeather findById(int id);
}
