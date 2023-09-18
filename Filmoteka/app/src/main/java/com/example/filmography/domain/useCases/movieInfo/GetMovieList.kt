package com.example.filmography.domain.useCases.movieInfo

import com.example.filmography.data.database.movie.MovieData
import com.example.filmography.domain.useCases.movieInfo.MovieInfoRepository
import javax.inject.Inject

class GetMovieList @Inject constructor(
    private val repository: MovieInfoRepository
) {
    operator fun invoke(): List<MovieData> {
        return repository.getMovieList()
    }
}