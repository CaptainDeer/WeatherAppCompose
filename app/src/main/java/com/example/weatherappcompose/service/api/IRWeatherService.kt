package com.example.weatherappcompose.service.api

import com.example.weatherappcompose.service.api.model.Forecast
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
interface IRWeatherService {
    @GET("forecast")
    suspend fun getForecast(
        @Query("q") city: String, @Query("appid") key: String,
        @Query("units") units: String = "metric",
    ): Forecast?
}