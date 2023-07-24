package com.example.filmography.feature.movielist.presentation.model

import androidx.lifecycle.ViewModel
import com.example.filmography.data.database.movie.MovieData
import com.example.filmography.data.remote.MovieRemouteSource
import com.example.filmography.domain.usecases.movieInfo.GetMovieList
import javax.inject.Inject

class MovieListViewModel @Inject constructor(
    private val movieList: GetMovieList
) : ViewModel() {
    fun getMovieList(): List<MovieData> {
        return movieList()
    }
}