package com.example.weatherappcompose.service.api.model

import com.squareup.moshi.Json

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
data class Coord(
    @field:Json(name = "lat") val lat: Double,
    @field:Json(name = "lon") val lon: Double,
)
