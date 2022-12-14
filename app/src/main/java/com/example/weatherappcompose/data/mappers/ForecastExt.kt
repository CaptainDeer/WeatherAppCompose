package com.example.weatherappcompose.data.mappers

import com.example.weatherappcompose.domain.model.ForecastModel
import com.example.weatherappcompose.data.model.ForecastList

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
fun ForecastList.toDomain(city: String): ForecastModel = ForecastModel(
    dateTime = dateTime,
    cityName = city,
    temperature = main.temperature,
    feelsLike = main.feelsLike,
    weatherName = weatherList.first().main,
    weatherDescription = weatherList.first().description
)