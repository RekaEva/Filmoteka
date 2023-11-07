package com.example.filmography.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.filmography.data.database.movie.MovieData
import com.example.filmography.data.database.movie.MovieDetails
import com.example.filmography.data.remoute.MovieInfoApi
import com.example.filmography.data.remoute.MoviesPaggingSource
import com.example.filmography.domain.useCases.movieInfo.MovieInfoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class MovieInfoRepositoryImpl @Inject constructor(
    private val api: MovieInfoApi
) : MovieInfoRepository {

    override fun getMovieListPagging(): Flow<PagingData<MovieData>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { MoviesPaggingSource(loader = api) }
        ).flow
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetails {
        return api.getMovieDetails(movieId)
    }
}