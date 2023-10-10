package com.example.filmography.data.repository

import com.example.filmography.data.database.movie.MovieDetails
import com.example.filmography.data.database.movie.Movies
import com.example.filmography.data.remoute.MovieInfoApi
import com.example.filmography.domain.useCases.movieInfo.MovieInfoRepository
import javax.inject.Inject


class MovieInfoRepositoryImpl @Inject constructor(
    private val api: MovieInfoApi
) : MovieInfoRepository {

    override suspend fun getMovieList(): Movies {
        return api.getMoviesList()
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetails {
        return api.getMovieDetails(movieId)
    }
}

