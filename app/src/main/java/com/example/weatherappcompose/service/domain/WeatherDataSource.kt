package com.example.weatherappcompose.service.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weatherappcompose.service.domain.model.ForecastModel
import com.example.weatherappcompose.service.domain.model.WeatherDao

/**
 * Created by Erik Hernandez on 11/13/2022.
 */
@Database(entities = [ForecastModel::class], version = 1)
abstract class WeatherDataSource : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao
}