package com.example.filmography.feature.moviedetails.presentation.model

import androidx.lifecycle.ViewModel
import com.example.filmography.data.database.movie.MovieData
import com.example.filmography.data.database.movie.MovieDetails
import com.example.filmography.domain.usecases.movieInfo.GetMovieDetails
import javax.inject.Inject

class MovieDetailsViewModel @Inject constructor(
    private val movieDetails: GetMovieDetails
) : ViewModel() {
    fun getMovieDetails(): List<MovieDetails> {
        return movieDetails()
    }
}