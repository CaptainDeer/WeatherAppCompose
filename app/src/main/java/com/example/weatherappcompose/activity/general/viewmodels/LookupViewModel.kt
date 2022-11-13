package com.example.weatherappcompose.activity.general.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.weatherappcompose.service.WeatherRepository
import com.example.weatherappcompose.service.WeatherRepositoryImpl
import com.example.weatherappcompose.service.domain.model.ForecastModel
import com.example.weatherappcompose.service.model.Clouds
import com.example.weatherappcompose.utils.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Erik Hernandez on 11/11/2022.
 */

@HiltViewModel
class LookupViewModel @Inject constructor(
    private val weatherRepositoryImpl: WeatherRepository
) : ViewModel() {

    private val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }

    val isLoading: MutableLiveData<Boolean> get() = _isLoading

    val weather = mutableStateListOf<ForecastModel>()

    fun searchWeather(navHostController: NavHostController){
        if (_isLoading.value == false){
            viewModelScope.launch(Dispatchers.IO) {
                _isLoading.postValue(true)
                weatherRepositoryImpl.getForecast("Tonala")
                weather.clear()
                weather.addAll(weatherRepositoryImpl.getWeather())
                _isLoading.postValue(false)
                println(weather.size)
            }
            navHostController.navigate(Routes.WeatherScreen.routes)
        }
    }

    fun delete(){
        viewModelScope.launch(Dispatchers.IO) {
            weatherRepositoryImpl.delete()
        }
    }

    init {

    }




}