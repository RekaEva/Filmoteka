package com.example.filmography.data.remote

import com.example.filmography.data.network.MovieApi
import javax.inject.Inject

class MovieRemouteSource @Inject constructor(
    private val api: MovieApi
)