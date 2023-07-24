package com.example.filmography.data.database.movie

data class MovieDetails(
    val id: String,
    val title: String,
    val releaseDate: String,
    val rating: Double,
    val posterUrl: String,
    val genre: String,
    val director: String,
    val cast: List<String>,
    val summary: String
)