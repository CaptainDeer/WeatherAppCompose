package com.example.weatherappcompose.ui.general.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherappcompose.ui.general.viewmodels.LookupViewModel

/**
 * Created by Erik Hernandez on 11/11/2022.
 */
@Composable
internal fun TopAppBarComponent(
    viewModel: LookupViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    TopAppBar {
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
            IconButton(onClick = {
                navigateBack.invoke()
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        }

        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.high,
            LocalTextStyle provides MaterialTheme.typography.h6
        ) {
            Text(
                text = viewModel.city.value.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 20.dp)
            )
        }

    }
}
