package com.example.weatherappcompose.ui.general.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherappcompose.domain.model.ForecastModel

/**
 * Created by Erik Hernandez on 11/11/2022.
 */
@Composable
fun WeatherItem(forecastModel: ForecastModel) {
    WeatherItemContent(forecastModel)
}
@Composable
fun WeatherItemContent(forecastModel: ForecastModel) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 20.dp)
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start), text = forecastModel.weatherName,
                fontSize = 18.sp
            )
            Text(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.CenterHorizontally), text = "Temp: ${forecastModel.temperature}",
                fontSize = 18.sp
            )
        }
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray, thickness = 2.dp)

    }

}