package com.example.weatherappcompose.activity.general.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Erik Hernandez on 11/11/2022.
 */
@Composable
fun WeatherItem() {
    WeatherItemContent()
}
@Preview
@Composable
fun WeatherItemContent() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 20.dp)
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start), text = "Forecast",
                fontSize = 18.sp
            )
            Text(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.CenterHorizontally), text = "Temp:",
                fontSize = 18.sp
            )
        }
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray, thickness = 2.dp)

    }

}