package com.example.filmography.feature.movielist.domain

import com.example.filmography.data.database.movie.Movies

interface GetMovieListUseCase {
    suspend fun getMoviesList(): Movies
}