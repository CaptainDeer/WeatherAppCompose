package com.example.weatherappcompose.activity.general.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.weatherappcompose.activity.general.components.TopAppBarComponent
import com.example.weatherappcompose.utils.navigation.Routes

/**
 * Created by Erik Hernandez on 11/12/2022.
 */

@Composable
fun WeatherScreen(navHostController: NavHostController, navigateBack: () -> Unit){
    Column(verticalArrangement = Arrangement.Top) {
        TopAppBarComponent(navigateBack)
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            WeatherComponents(navHostController)
        }
    }
}

@Composable
fun WeatherComponents(navHostController: NavHostController){
    val items = listOf("a","b","c","dario","ffff","eeeeee","","","","","","","","","","","","","","","","","","","")

    LazyColumn{
        this.items(items = items){
            Column(modifier = Modifier.clickable {
                navHostController.navigate(Routes.WeatherDetailsScreen.routes)
            }) {
                WeatherItem()
            }
        }
    }
}