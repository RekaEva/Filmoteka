package com.example.filmography.domain.usecases.movieInfo

import com.example.filmography.data.database.movie.MovieData
import javax.inject.Inject

class GetMovieList @Inject constructor(
    private val repository: MovieInfoRepository
) {
    operator fun invoke(): List<MovieData> {
        return repository.getMovieList()
    }
}