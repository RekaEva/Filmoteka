package com.example.filmography.feature.movielist.domain

import com.example.filmography.data.database.movie.Movies
import com.example.filmography.domain.useCases.movieInfo.MovieInfoRepository
import com.example.filmography.feature.movielist.di.MovieListScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@MovieListScope
class GetMovieListUseCaseImpl @Inject constructor(
    private val repository: MovieInfoRepository
) : GetMovieListUseCase {

    override suspend fun getMoviesList(): Movies {
        return withContext(Dispatchers.IO) {
            repository.getMovieList()
        }
    }
}