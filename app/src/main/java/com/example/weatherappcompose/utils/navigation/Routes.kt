package com.example.weatherappcompose.utils.navigation

/**
 * Created by Erik Hernandez on 11/11/2022.
 */
sealed class Routes(val routes: String) {
    object LookupScreen: Routes("lookupScreen")
    object WeatherScreen: Routes("weatherScreen")
    object WeatherDetailsScreen: Routes("weatherDetailsScreen")
}