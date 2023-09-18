package com.example.filmography.feature.moviedetails.presentation.model

import androidx.lifecycle.ViewModel
import com.example.filmography.data.database.movie.MovieDetails
import com.example.filmography.di.ComponentManager
import com.example.filmography.domain.useCases.movieInfo.GetMovieDetails
import com.example.filmography.navigation.Screens
import javax.inject.Inject

class MovieDetailsViewModel @Inject constructor(
    private val movieDetails: GetMovieDetails
) : ViewModel() {
    fun getMovieDetails(): List<MovieDetails> {
        return movieDetails()
    }

    fun onBackButtonPressed() {
        ComponentManager.appComponent.router().backTo(Screens.movielist())
    }
}


