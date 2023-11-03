package com.example.filmography.data.database.movie

import androidx.compose.foundation.layout.*
import com.google.gson.annotations.SerializedName

data class MovieDetails(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("year")
    val year: Int?,
    @SerializedName("poster")
    val poster: Poster?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("slogan")
    val slogan: String?,
    @SerializedName("movieLength")
    val movieLength: String?,
    @SerializedName("ageRating")
    val ageRating: Int?
)
