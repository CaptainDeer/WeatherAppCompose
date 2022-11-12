package com.example.weatherappcompose.activity.general.viewmodels

import androidx.lifecycle.ViewModel
import com.example.weatherappcompose.service.api.IWeatherService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Erik Hernandez on 11/11/2022.
 */

@HiltViewModel
class LookupViewModel @Inject constructor(
    private val weatherService: IWeatherService
): ViewModel(){

}