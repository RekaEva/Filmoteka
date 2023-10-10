package com.example.filmography.feature.moviedetails.domain

import com.example.filmography.data.database.movie.MovieDetails
import com.example.filmography.domain.useCases.movieInfo.MovieInfoRepository
import com.example.filmography.feature.moviedetails.di.MovieDetailsScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@MovieDetailsScope
class GetMovieDetailsUseCaseImpl @Inject constructor(
    private val repository: MovieInfoRepository,
) : GetMovieDetailsUseCase {

    override suspend fun getMovieDetails(movieId: Int): MovieDetails {
        return withContext(Dispatchers.IO) {
            repository.getMovieDetails(movieId)
        }
    }
}