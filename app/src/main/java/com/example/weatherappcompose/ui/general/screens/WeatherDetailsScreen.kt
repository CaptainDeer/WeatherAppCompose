package com.example.weatherappcompose.ui.general.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherappcompose.ui.general.components.TopAppBarComponent
import com.example.weatherappcompose.ui.general.viewmodels.LookupViewModel
import com.example.weatherappcompose.domain.model.ForecastModel

/**
 * Created by Erik Hernandez on 11/11/2022.
 */
@Composable
fun WeatherDetailsScreen(viewModel: LookupViewModel = hiltViewModel(), navigateBack: () -> Unit) {
    Column(verticalArrangement = Arrangement.Top) {
        TopAppBarComponent(viewModel,navigateBack)
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            WeatherDetailsComponents(viewModel)
        }
    }
}

@Composable
fun WeatherDetailsComponents(viewModel: LookupViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp), horizontalArrangement = Arrangement.Center
        ) {
            viewModel.weatherDetails.value?.let { DegreesComponent(it) }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp), horizontalArrangement = Arrangement.End
        ) {
            viewModel.weatherDetails.value?.let { FeelsLikeComponent(it) }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            viewModel.weatherDetails.value?.let { CloudsComponent(it) }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            viewModel.weatherDetails.value?.let { DetailsComponent(it) }
        }
    }
}

@Composable
fun DegreesComponent(forecastModel: ForecastModel) {
    Text(text = forecastModel.temperature.toString(), fontSize = 80.sp)
}

@Composable
fun FeelsLikeComponent(forecastModel: ForecastModel) {
    Text(text = "Feels like: ${forecastModel.feelsLike}", fontSize = 22.sp)
}

@Composable
fun CloudsComponent(forecastModel: ForecastModel) {
    Text(text = forecastModel.weatherName, fontSize = 35.sp)
}

@Composable
fun DetailsComponent(forecastModel: ForecastModel) {
    Text(text = forecastModel.weatherDescription, fontSize = 18.sp)
}