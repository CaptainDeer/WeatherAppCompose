package com.example.weatherappcompose.service.api

import com.example.weatherappcompose.service.api.model.Forecast

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
interface IWeatherService {
    suspend fun getForecast(city: String): Forecast?
}