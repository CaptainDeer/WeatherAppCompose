package com.example.weatherappcompose.core.di


import com.example.weatherappcompose.domain.WeatherRepository
import com.example.weatherappcompose.data.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun weatherRepository(repo: WeatherRepositoryImpl): WeatherRepository
}