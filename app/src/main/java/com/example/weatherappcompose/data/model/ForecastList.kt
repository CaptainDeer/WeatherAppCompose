package com.example.weatherappcompose.data.model

import com.squareup.moshi.Json

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
data class ForecastList(
    @field:Json(name = "dt") val dateTime: Int,
    @field:Json(name = "main") val main: Main,
    @field:Json(name = "weather") val weatherList: List<Weather>,
    @field:Json(name = "clouds") val clouds: Clouds,
    @field:Json(name = "wind") val wind: Wind,
    @field:Json(name = "visibility") val visibility: Int,
    @field:Json(name = "pop") val pop: Double,
    @field:Json(name = "sys") val sys: Sys,
    @field:Json(name = "dt_txt") val dateText: String,
)