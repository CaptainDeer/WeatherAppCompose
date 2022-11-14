package com.example.weatherappcompose.data.model

import com.squareup.moshi.Json

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
data class Clouds(
    @field:Json(name = "all") val all: Int,
)