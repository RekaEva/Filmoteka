package com.example.filmography.domain.useCases.movieInfo

import androidx.paging.PagingData
import com.example.filmography.data.database.movie.MovieData
import com.example.filmography.data.database.movie.MovieDetails
import kotlinx.coroutines.flow.Flow

interface MovieInfoRepository {
    fun getMovieListPagging() : Flow<PagingData<MovieData>>
    suspend fun getMovieDetails(movieId: Int): MovieDetails
}