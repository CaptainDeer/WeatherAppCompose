package com.example.weatherappcompose.core.di

import android.content.Context
import androidx.room.Room
import com.example.weatherappcompose.BuildConfig
import com.example.weatherappcompose.domain.WeatherDataSource
import com.example.weatherappcompose.data.api.WeatherAPI
import com.example.weatherappcompose.domain.model.WeatherDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttp(): OkHttpClient = OkHttpClient.Builder().apply {
        if (BuildConfig.DEBUG) {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
    }.build()

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder().apply {
        baseUrl(BuildConfig.API_BASE_URL)
        client(okHttpClient)
        addConverterFactory(MoshiConverterFactory.create())
    }.build()


    @Provides
    @Singleton
    fun providesWeatherApi(retrofit: Retrofit): WeatherAPI =
        retrofit.create(WeatherAPI::class.java)

    @Singleton
    @Provides
    fun weatherDataSource(@ApplicationContext context: Context): WeatherDataSource {
        return Room.databaseBuilder(context, WeatherDataSource::class.java, "weather_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun weatherDao(db: WeatherDataSource): WeatherDao = db.weatherDao()
}