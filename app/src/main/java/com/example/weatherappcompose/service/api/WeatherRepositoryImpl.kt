package com.example.weatherappcompose.service.api

import com.example.weatherappcompose.BuildConfig
import com.example.weatherappcompose.service.api.model.Forecast

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
class WeatherRepositoryImpl(private val weatherService: IRWeatherService) : IWeatherService {
    override suspend fun getForecast(city: String): Forecast? {
        return weatherService.getForecast(city = city, key = BuildConfig.API_KEY)
    }
}