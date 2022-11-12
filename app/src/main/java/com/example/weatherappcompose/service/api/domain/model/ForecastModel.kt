package com.example.weatherappcompose.service.api.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
@Parcelize
data class ForecastModel(
    val dateTime: Int = 0,
    val cityName: String = "",
    val temperature: Double = 0.0,
    val feelsLike: Double = 0.0,
    val weatherName: String = "",
    val weatherDescription: String = "",
    ) : Parcelable {
}