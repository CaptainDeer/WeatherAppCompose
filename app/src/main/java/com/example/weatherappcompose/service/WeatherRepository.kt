package com.example.weatherappcompose.service

import com.example.weatherappcompose.service.domain.model.ForecastModel
import com.example.weatherappcompose.service.model.Forecast

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
interface WeatherRepository {
    suspend fun  getForecast(city: String): Forecast?
    suspend fun getWeather():MutableList<ForecastModel>
    suspend fun delete()
}