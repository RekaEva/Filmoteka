package com.example.filmography.data.database.movie

import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("docs")
    val moviesList: List<MovieData>,
    @SerializedName("page")
    val page: Int = 1,
    @SerializedName("pageSize")
    val pageSize: Int = 10,
    @SerializedName("total")
    val total: Int = 1
)