package com.example.filmography.feature.movielist.presentation.model

import androidx.lifecycle.ViewModel
import com.example.filmography.data.database.movie.MovieData
import com.example.filmography.di.ComponentManager
import com.example.filmography.domain.useCases.movieInfo.GetMovieList
import com.example.filmography.navigation.Screens
import javax.inject.Inject

class MovieListViewModel @Inject constructor(
    private val movieList: GetMovieList
) : ViewModel() {
    fun getMovieList(): List<MovieData> {
        return movieList()
    }

    fun showDetailsButton() {
        ComponentManager.appComponent.router().navigateTo(Screens.moviedetails())
    }
}