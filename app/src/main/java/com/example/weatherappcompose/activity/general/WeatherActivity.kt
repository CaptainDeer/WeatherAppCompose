package com.example.weatherappcompose.activity.general

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherappcompose.activity.general.screens.*
import com.example.weatherappcompose.activity.general.theme.WeatherAppComposeTheme
import com.example.weatherappcompose.activity.general.viewmodels.LookupViewModel
import com.example.weatherappcompose.utils.navigation.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherActivity : ComponentActivity() {

    lateinit var viewModel: LookupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[LookupViewModel::class.java]

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
                            WeatherScreen(viewModel,navHostController) {
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
