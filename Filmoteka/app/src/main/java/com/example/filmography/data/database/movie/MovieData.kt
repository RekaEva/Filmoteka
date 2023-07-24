package com.example.filmography.data.database.movie

data class MovieData(
    val id: String,
    val title: String,
    val releaseYear: String,
    val rating: Double,
    val genre: String,
    val posterUrl: String
)