package com.example.filmography.feature.movielist.presentation.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.filmography.di.AppComponent
import com.example.filmography.di.ComponentManager
import com.example.filmography.feature.movielist.presentation.model.MovieListViewModel
import com.example.filmography.navigation.Screens
import com.example.filmography.presentation.ui.headerTextStyle

@Composable
//fun MovieListScreen(mlViewModel: MovieListViewModel)
fun MovieListScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "MovieListPage",
            style = headerTextStyle,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
        )
        OutlinedButton(
            onClick = {
                ComponentManager.appComponent.router().navigateTo(Screens.moviedetails())
//                mlViewModel.showDetailsButton()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
        )
        {
            Text(
                text = "Show details",
                textAlign = TextAlign.Center
            )
        }
    }
}
