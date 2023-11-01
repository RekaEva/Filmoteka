package com.example.filmography.data.remoute

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.filmography.data.database.movie.MovieData

class MoviesPaggingSource (
    private val loader: MovieInfoApi
): PagingSource<Int, MovieData>(){
    override fun getRefreshKey(state: PagingState<Int, MovieData>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieData> {
        val page = params.key ?: 1
        return try {
            val response = loader.getMovieListPagging(page = page)

            val nextKey = when {
            (params.loadSize * (page + 1)) < response.total -> page + 1
            else -> null
        }
            val prevKey = if (page == 0) null else page - 1
            Log.d("checkData", "page: $page, nextKey: $nextKey, prevKew: $prevKey",)
            LoadResult.Page(
                data = response.moviesList,
                nextKey = nextKey,
                prevKey = prevKey
            )
        }catch (e : Exception){
            LoadResult.Error(e)
        }
    }
}
