package com.example.filmography.data.repository

import com.example.filmography.data.database.movie.MovieData
import com.example.filmography.data.database.movie.MovieDetails
import com.example.filmography.domain.useCases.movieInfo.MovieInfoRepository
import javax.inject.Inject

class MovieInfoRepositoryImpl @Inject constructor() : MovieInfoRepository {
    override fun getMovieList(): List<MovieData> {
        TODO("Not yet implemented")
    }

    override fun getMovieDetails(): List<MovieDetails> {
        TODO("Not yet implemented")
    }
}
