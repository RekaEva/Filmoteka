package com.example.filmography.domain.usecases.movieInfo

import com.example.filmography.data.database.movie.MovieDetails
import javax.inject.Inject

class GetMovieDetails @Inject constructor(
    private val repository: MovieInfoRepository
) {
    operator fun invoke(): List<MovieDetails> {
        return repository.getMovieDetails()
    }
}