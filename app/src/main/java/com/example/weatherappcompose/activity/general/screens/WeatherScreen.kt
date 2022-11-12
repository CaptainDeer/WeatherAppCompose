package com.example.weatherappcompose.activity.general.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.weatherappcompose.activity.general.components.TopAppBarComponent
import com.example.weatherappcompose.activity.general.viewmodels.LookupViewModel
import com.example.weatherappcompose.utils.navigation.Routes
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.coroutineScope

/**
 * Created by Erik Hernandez on 11/12/2022.
 */

@Composable
fun WeatherScreen(viewModel: LookupViewModel = hiltViewModel(), navHostController: NavHostController, navigateBack: () -> Unit){
    Column(verticalArrangement = Arrangement.Top) {
        TopAppBarComponent(navigateBack)
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            WeatherComponents(viewModel, navHostController)
        }
    }
}

@Composable
fun WeatherComponents(viewModel: LookupViewModel = hiltViewModel(), navHostController: NavHostController){
    val list = remember {
        viewModel.forecastList
    }
    LazyColumn{
        items(list){
            Column(modifier = Modifier.clickable {
                viewModel.getForecast()
                println(viewModel.getForecast())
//                navHostController.navigate(Routes.WeatherDetailsScreen.routes)
            }) {
                println(list.size)
                WeatherItem()
            }
        }
    }
}