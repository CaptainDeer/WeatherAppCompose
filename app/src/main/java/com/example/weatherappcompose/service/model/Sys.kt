package com.example.weatherappcompose.service.model

import com.squareup.moshi.Json

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
data class Sys(
    @field:Json(name = "pod") val pod: String,
)