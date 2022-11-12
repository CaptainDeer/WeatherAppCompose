package com.example.weatherappcompose.activity.general.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherappcompose.activity.general.components.TopAppBarComponent

/**
 * Created by Erik Hernandez on 11/11/2022.
 */
@Composable
fun WeatherDetailsScreen(navigateBack: () -> Unit) {
    Column(verticalArrangement = Arrangement.Top) {
        TopAppBarComponent(navigateBack)
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            WeatherDetailsComponents()
        }
    }
}

@Composable
fun WeatherDetailsComponents() {
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
            DegreesComponent()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp), horizontalArrangement = Arrangement.End
        ) {
            FeelsLikeComponent()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            CloudsComponent()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            DetailsComponent()
        }
    }
}

@Composable
fun DegreesComponent() {
    Text(text = "100", fontSize = 80.sp)
}

@Composable
fun FeelsLikeComponent() {
    Text(text = "Feels like: 76", fontSize = 22.sp)
}

@Composable
fun CloudsComponent() {
    Text(text = "Clouds = Muchas", fontSize = 35.sp)
}

@Composable
fun DetailsComponent() {
    Text(text = "Details of the weather today in the request", fontSize = 18.sp)
}