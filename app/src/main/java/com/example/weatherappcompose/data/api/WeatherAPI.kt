package com.example.weatherappcompose.data.api

import com.example.weatherappcompose.data.model.Forecast
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
interface WeatherAPI {
    @GET("forecast")
    suspend fun getForecast(
        @Query("q") city: String, @Query("appid") key: String,
        @Query("units") units: String = "metric",
    ): Forecast?
}