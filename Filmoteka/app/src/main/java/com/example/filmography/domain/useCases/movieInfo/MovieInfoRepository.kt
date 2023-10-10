package com.example.filmography.domain.useCases.movieInfo

import com.example.filmography.data.database.movie.MovieDetails
import com.example.filmography.data.database.movie.Movies

interface MovieInfoRepository {
    suspend fun getMovieList(): Movies
    suspend fun getMovieDetails(movieId: Int): MovieDetails
}