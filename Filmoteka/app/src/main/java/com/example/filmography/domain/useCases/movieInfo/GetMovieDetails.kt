package com.example.filmography.domain.useCases.movieInfo

import com.example.filmography.data.database.movie.MovieDetails
import com.example.filmography.domain.useCases.movieInfo.MovieInfoRepository
import javax.inject.Inject

class GetMovieDetails @Inject constructor(
    private val repository: MovieInfoRepository
) {
    operator fun invoke(): List<MovieDetails> {
        return repository.getMovieDetails()
    }
}