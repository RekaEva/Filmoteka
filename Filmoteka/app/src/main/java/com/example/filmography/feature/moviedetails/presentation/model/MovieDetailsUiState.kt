package com.example.filmography.feature.moviedetails.presentation.model

import com.example.filmography.data.database.movie.MovieDetails

data class MovieDetailsUiState(
    val movieDetails: MovieDetails? = null,
    val error: Exception? = null,
    val load: Boolean = false
)