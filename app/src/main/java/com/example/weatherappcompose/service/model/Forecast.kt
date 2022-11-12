package com.example.weatherappcompose.service.model

import com.squareup.moshi.Json

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
data class Forecast(
    @field:Json(name = "cod") val cod: String,
    @field:Json(name = "message") val message: Int,
    @field:Json(name = "cnt") val cnt: Int,
    @field:Json(name = "list") val forecastList: List<ForecastList>,
    @field:Json(name = "city") val city: City,
)