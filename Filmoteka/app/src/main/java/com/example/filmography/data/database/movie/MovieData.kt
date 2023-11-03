package com.example.filmography.data.database.movie

import com.google.gson.annotations.SerializedName

data class MovieData(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("year")
    val year: Int,
    @SerializedName("poster")
    val poster: Poster,
    @SerializedName("shortDescription")
    val shortDescription: String?
)

data class Poster(
    @SerializedName("url")
    val url: String,
    @SerializedName("previewUrl")
    val previewUrl: String
)