package com.example.filmography.feature.movielist.presentation.compose

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.filmography.feature.movielist.presentation.model.MovieListViewModel

@Composable
fun MovieListScreen(
    mlViewModel: MovieListViewModel,
) {
    val uiState by mlViewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        mlViewModel.getMovieList()
    }
    if (uiState.list.moviesList.isNotEmpty()) {
        LazyColumn {
            items(uiState.list.moviesList) { movie ->
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .clickable {
                            Log.d("MovieID", movie.id.toString())
                            mlViewModel.showDetailsButton(movie.id)
                        },
                    shape = MaterialTheme.shapes.medium,
                    elevation = 5.dp,
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        AsyncImage(
                            model = movie.poster.previewUrl,
                            contentDescription = null,
                            modifier = Modifier
                                .size(130.dp)
                                .padding(8.dp),
                            contentScale = ContentScale.Fit,
                        )
                        Column(Modifier.padding(8.dp)) {
                            if (movie.name != null) {
                                Text(
                                    text = movie.name,
                                    style = MaterialTheme.typography.h6,
                                    modifier = Modifier
                                        .padding(bottom = 8.dp)
                                        .fillMaxWidth(),
                                    color = MaterialTheme.colors.onSurface,
                                )
                            }
                            CustomText(text = movie.year.toString())
                            if (movie.shortDescription != null) {
                                CustomText(text = movie.shortDescription)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CustomText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.body2,
        modifier = Modifier.padding(bottom = 4.dp)
    )
}