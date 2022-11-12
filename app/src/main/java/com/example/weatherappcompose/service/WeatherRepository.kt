package com.example.weatherappcompose.service

import com.example.weatherappcompose.service.model.Forecast

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
interface WeatherRepository {
    suspend fun  getForecast(city: String): Forecast?
}