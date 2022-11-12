package com.example.weatherappcompose.service

import com.example.weatherappcompose.BuildConfig
import com.example.weatherappcompose.service.api.WeatherAPI
import com.example.weatherappcompose.service.model.Forecast
import javax.inject.Inject

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
class WeatherRepositoryImpl @Inject constructor(private val weatherService: WeatherAPI) :
    WeatherRepository {
    override suspend fun getForecast(city: String): Forecast? {
        return weatherService.getForecast(city = city, key = BuildConfig.API_KEY)
    }
}