package com.example.filmography.domain.useCases.movieInfo

import com.example.filmography.data.database.movie.MovieData
import com.example.filmography.data.database.movie.MovieDetails

interface MovieInfoRepository {
    fun getMovieList(): List<MovieData>
    fun getMovieDetails(): List<MovieDetails>
}