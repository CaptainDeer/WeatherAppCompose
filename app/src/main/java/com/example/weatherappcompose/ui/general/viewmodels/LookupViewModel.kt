package com.example.weatherappcompose.ui.general.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.weatherappcompose.domain.WeatherRepository
import com.example.weatherappcompose.domain.model.ForecastModel
import com.example.weatherappcompose.core.utils.navigation.Routes
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

    private val _isLoading = MutableLiveData(false)

    val isLoading: MutableLiveData<Boolean> get() = _isLoading

    private val _weather = MutableLiveData<MutableList<ForecastModel>>()

    val weather: MutableLiveData<MutableList<ForecastModel>> get() = _weather

    private val _city = MutableLiveData("")

    val city: MutableLiveData<String> get() = _city

    private val _weatherDetails = MutableLiveData<ForecastModel>()

    val weatherDetails: MutableLiveData<ForecastModel> get() = _weatherDetails

    fun searchWeather(city: String, navigation: (String) -> Unit) {
        if (_isLoading.value == false) {
            viewModelScope.launch(Dispatchers.IO) {
                _isLoading.postValue(true)
                weatherRepositoryImpl.getForecast(city)
                _weather.postValue(weatherRepositoryImpl.getWeather())
                _isLoading.postValue(false)
            }
            navigation(Routes.WeatherScreen.routes)
        }
    }

    fun delete() {
        viewModelScope.launch(Dispatchers.IO) {
            weatherRepositoryImpl.delete()
        }
    }

    fun weatherDetails(forecastModel: ForecastModel, navigation: (String) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            _weatherDetails.postValue(forecastModel)
        }
        navigation(Routes.WeatherDetailsScreen.routes)
    }

}