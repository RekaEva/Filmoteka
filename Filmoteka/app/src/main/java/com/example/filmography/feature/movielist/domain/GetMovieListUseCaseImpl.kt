package com.example.filmography.feature.movielist.domain

import androidx.paging.PagingData
import com.example.filmography.data.database.movie.MovieData
import com.example.filmography.domain.useCases.movieInfo.MovieInfoRepository
import com.example.filmography.feature.movielist.di.MovieListScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@MovieListScope
class GetMovieListUseCaseImpl @Inject constructor(
    private val repository: MovieInfoRepository
) : GetMovieListUseCase {

    override fun getMovieListPagging(): Flow<PagingData<MovieData>> {
        return repository.getMovieListPagging()
    }
}