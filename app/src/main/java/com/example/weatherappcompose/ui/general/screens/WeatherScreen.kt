package com.example.weatherappcompose.ui.general.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.weatherappcompose.ui.general.components.TopAppBarComponent
import com.example.weatherappcompose.ui.general.viewmodels.LookupViewModel


/**
 * Created by Erik Hernandez on 11/12/2022.
 */

@Composable
fun WeatherScreen(
    viewModel: LookupViewModel = hiltViewModel(),
    navHostController: NavHostController,
    navigateBack: () -> Unit
) {
    Column(verticalArrangement = Arrangement.Top) {
        TopAppBarComponent(viewModel,navigateBack)
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            WeatherComponents(viewModel){
                navHostController.navigate(it)
            }
        }
    }
}

@Composable
fun WeatherComponents(
    viewModel: LookupViewModel = hiltViewModel(),
    navigation : (String) -> Unit
) {
    val list by viewModel.weather.observeAsState()

    LazyColumn {

        list?.let {
            items(it) {
                Column(modifier = Modifier.clickable {

                    viewModel.weatherDetails(it, navigation)
                }) {
                    WeatherItem(it)
                }
            }
        }
    }
}