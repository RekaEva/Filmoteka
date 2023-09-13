package com.example.filmography.feature.moviedetails.presentation.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.filmography.presentation.ui.headerTextStyle

@Composable
fun MovieDetailsScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "MovieDetailsPage",
            style = headerTextStyle,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
        )
    }
}
