package com.example.weatherappcompose.domain

import com.example.weatherappcompose.domain.model.ForecastModel
import com.example.weatherappcompose.data.model.Forecast

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
interface WeatherRepository {
    suspend fun  getForecast(city: String): Forecast?
    suspend fun getWeather():MutableList<ForecastModel>
    suspend fun delete()
}