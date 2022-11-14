package com.example.weatherappcompose.data.model

import com.squareup.moshi.Json

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
data class City(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "coord") val coord: Coord,
    @field:Json(name = "country") val country: String,
    @field:Json(name = "population") val population: Int,
    @field:Json(name = "timezone") val timeZone: Int,
    @field:Json(name = "sunrise") val sunrise: Int,
    @field:Json(name = "sunset") val sunset: Int,
)