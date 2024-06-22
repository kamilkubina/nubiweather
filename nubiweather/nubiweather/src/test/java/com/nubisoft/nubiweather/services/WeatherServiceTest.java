package com.nubisoft.nubiweather.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WeatherServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetRealtimeWeather_StandardResponse() throws Exception{
        mockMvc.perform(get("/realtime-weather?city=Gliwice"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetRealtimeWeather_NoParameter() throws Exception{
        mockMvc.perform(get("/realtime-weather"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Parameter not found: city"));
    }

    @Test
    void testGetForecastWeather_StandardResponse() throws Exception{
        mockMvc.perform(get("/forecast-weather?city=Gliwice&days=2"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetForecastWeather_WrongParameter() throws Exception{
        mockMvc.perform(get("/forecast-weather?city=Gliwice&days=a"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid data type for parameter: days"));
    }

    @Test
    void testGetForecastWeather_NoParameter() throws Exception{
        mockMvc.perform(get("/forecast-weather?city=Gliwice"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Parameter not found: days"));
    }
}