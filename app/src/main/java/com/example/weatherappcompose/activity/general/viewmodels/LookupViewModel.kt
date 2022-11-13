package com.example.weatherappcompose.activity.general.viewmodels

import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.weatherappcompose.service.WeatherRepository
import com.example.weatherappcompose.service.domain.model.ForecastModel
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

    private val _weather : MutableLiveData<MutableList<ForecastModel>> by lazy {
        MutableLiveData<MutableList<ForecastModel>>()
    }
    val weather: MutableLiveData<MutableList<ForecastModel>> get() = _weather

    private val _city : MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }
    val city: MutableLiveData<String> get() = _city

    private val _weatherDetails: MutableLiveData<ForecastModel> by lazy {
        MutableLiveData<ForecastModel>()
    }
    val weatherDetails: MutableLiveData<ForecastModel> get() = _weatherDetails

    fun searchWeather(city: String, navHostController: NavHostController){
        if (_isLoading.value == false){
            viewModelScope.launch(Dispatchers.IO) {
                _isLoading.postValue(true)
                weatherRepositoryImpl.getForecast(city)
                _weather.postValue(weatherRepositoryImpl.getWeather())
                println("Hay ${_weather.value?.size} en total de items")
                _isLoading.postValue(false)
            }
            navHostController.navigate(Routes.WeatherScreen.routes)
        }
    }

    fun delete(){
        viewModelScope.launch(Dispatchers.IO) {
            weatherRepositoryImpl.delete()
        }
    }

    fun weatherDetails(forecastModel: ForecastModel, navHostController: NavHostController){
        viewModelScope.launch(Dispatchers.IO) {
            _weatherDetails.postValue(forecastModel)
        }
        navHostController.navigate(Routes.WeatherDetailsScreen.routes)
    }

}