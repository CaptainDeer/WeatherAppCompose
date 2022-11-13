package com.example.weatherappcompose.service

import androidx.lifecycle.LiveData
import com.example.weatherappcompose.BuildConfig
import com.example.weatherappcompose.service.api.WeatherAPI
import com.example.weatherappcompose.service.domain.mappers.toDomain
import com.example.weatherappcompose.service.domain.model.ForecastModel
import com.example.weatherappcompose.service.domain.model.WeatherDao
import com.example.weatherappcompose.service.model.Forecast
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
class WeatherRepositoryImpl @Inject constructor(
    private val weatherService: WeatherAPI,
    private val weatherDao: WeatherDao
) :
    WeatherRepository {
    override suspend fun getForecast(city: String): Forecast? {
        val forecast = weatherService.getForecast(city = city, key = BuildConfig.API_KEY)
        forecast?.forecastList?.map { it.toDomain("Tonala") }?.forEach{
            weatherDao.insert(it)
        }
        return forecast
    }

    override suspend fun getWeather(): MutableList<ForecastModel> = weatherDao.getAll()
    override suspend fun delete() {
        weatherDao.delete("Tonala")
    }
}