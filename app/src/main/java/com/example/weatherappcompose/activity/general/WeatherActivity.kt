package com.example.weatherappcompose.activity.general

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherappcompose.activity.general.screens.*
import com.example.weatherappcompose.activity.general.theme.WeatherAppComposeTheme
import com.example.weatherappcompose.utils.navigation.Routes

class WeatherActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeatherAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navHostController = rememberNavController()
                    NavHost(
                        navController = navHostController,
                        startDestination = Routes.LookupScreen.routes
                    ) {
                        composable(route = Routes.LookupScreen.routes) {
                            LookupScreen() {
                                navHostController.navigate(Routes.WeatherScreen.routes)
                            }
                        }
                        composable(route = Routes.WeatherDetailsScreen.routes) {
                            WeatherDetailsScreen() {
                                navHostController.navigate(Routes.WeatherScreen.routes) {
                                    popUpTo(Routes.LookupScreen.routes)
                                    launchSingleTop = true
                                }
                            }
                        }
                        composable(route = Routes.WeatherScreen.routes) {
                            WeatherScreen(navHostController) {
                                navHostController.navigate(Routes.LookupScreen.routes) {
                                    popUpTo(Routes.LookupScreen.routes)
                                    launchSingleTop = true
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
