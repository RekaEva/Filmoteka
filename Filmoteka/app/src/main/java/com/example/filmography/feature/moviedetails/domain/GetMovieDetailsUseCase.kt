package com.example.filmography.feature.moviedetails.domain

import com.example.filmography.data.database.movie.MovieDetails

interface GetMovieDetailsUseCase {

    suspend fun getMovieDetails(movieId: Int): MovieDetails
}