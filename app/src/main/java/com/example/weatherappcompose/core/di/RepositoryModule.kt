package com.example.weatherappcompose.core.di

import com.example.weatherappcompose.service.api.IRWeatherService
import com.example.weatherappcompose.service.api.IWeatherService
import com.example.weatherappcompose.service.api.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesRandomRepository(weatherApi: IRWeatherService): IWeatherService =
        WeatherRepositoryImpl(weatherApi)
}