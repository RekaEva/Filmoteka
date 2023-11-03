package com.example.filmography.data.database.movie

import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("docs")
    val moviesList: List<MovieData>
)