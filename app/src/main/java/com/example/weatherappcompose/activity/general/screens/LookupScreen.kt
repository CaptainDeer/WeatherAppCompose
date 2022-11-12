package com.example.weatherappcompose.activity.general.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * Created by Erik Hernandez on 11/11/2022.
 */

@Composable
fun LookupScreen(
    navigateToWeatherDetailsScreen: () -> Unit
) {
    LookupComponents(navigateToWeatherDetailsScreen)
}

@Composable
private fun LookupComponents(navigateToWeatherDetailsScreen: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchComponent()
        SearchButtonComponent(navigateToWeatherDetailsScreen)
    }
}

@Composable
private fun SearchComponent() {
    var state by remember { mutableStateOf("") }
    TextField(
        value = state,
        onValueChange = { state = it },
        modifier = Modifier.padding(horizontal = 50.dp),
        placeholder = {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "City name",
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        }, colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Black,
            unfocusedIndicatorColor = Color.Black,
            disabledIndicatorColor = Color.Black
        )
    )
}

@Composable
private fun SearchButtonComponent(navigateToWeatherDetailsScreen: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 100.dp, vertical = 25.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
            hoveredElevation = 0.dp,
            focusedElevation = 0.dp
        ),
        onClick = {
            navigateToWeatherDetailsScreen()
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent, contentColor = Color.Black,
            disabledBackgroundColor = Color.Transparent,
            disabledContentColor = Color.Transparent
        ),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Text(text = "Lookup", fontSize = 18.sp)
    }
}
