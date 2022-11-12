package com.example.weatherappcompose.core.di


import com.example.weatherappcompose.service.WeatherRepository
import com.example.weatherappcompose.service.WeatherRepositoryImpl
import com.example.weatherappcompose.service.api.WeatherAPI
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
    fun providesRepository(weatherApi: WeatherAPI): WeatherRepository =
        WeatherRepositoryImpl(weatherApi)
}