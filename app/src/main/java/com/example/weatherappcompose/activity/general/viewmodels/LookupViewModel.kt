package com.example.weatherappcompose.activity.general.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappcompose.service.WeatherRepository
import com.example.weatherappcompose.service.WeatherRepositoryImpl
import com.example.weatherappcompose.service.model.Clouds
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Erik Hernandez on 11/11/2022.
 */

@HiltViewModel
class LookupViewModel @Inject constructor(
    private val weatherRepositoryImpl: WeatherRepository
) : ViewModel() {

    fun getForecast(){
        viewModelScope.launch {
            val forecast = weatherRepositoryImpl.getForecast("Tonala")
        }
    }

    var forecastList = mutableStateListOf<Clouds>()
    init {
        val cloudsList = listOf(Clouds(99), Clouds(55), Clouds(20), Clouds(1))
        forecastList.addAll(cloudsList)
    }


}
