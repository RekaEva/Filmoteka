package com.example.filmography.feature.movielist.presentation.model

import com.example.filmography.data.database.movie.Movies

data class MovieListUiState(
    val list: Movies = Movies(emptyList())
)