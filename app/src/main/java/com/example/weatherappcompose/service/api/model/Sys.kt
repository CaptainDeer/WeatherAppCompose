package com.example.weatherappcompose.service.api.model

import com.squareup.moshi.Json

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
data class Sys(
    @field:Json(name = "pod") val pod: String,
)