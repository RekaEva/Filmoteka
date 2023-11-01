package com.example.filmography.feature.movielist.domain

import androidx.paging.PagingData
import com.example.filmography.data.database.movie.MovieData
import kotlinx.coroutines.flow.Flow

interface GetMovieListUseCase {
    fun getMovieListPagging() : Flow<PagingData<MovieData>>
}