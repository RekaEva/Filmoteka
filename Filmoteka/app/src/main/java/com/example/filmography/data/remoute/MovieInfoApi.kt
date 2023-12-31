package com.example.filmography.data.remoute

import com.example.filmography.data.database.movie.MovieDetails
import com.example.filmography.data.database.movie.Movies
import retrofit2.http.*

interface MovieInfoApi {

    @GET("v1.3/movie")
    suspend fun getMovieListPagging(
        @Query("page") page: Int,
        @Query("year") year: Int = 2023
    ): Movies

    @GET("v1.3/movie/{id}")
    suspend fun getMovieDetails(@Path("id") id: Int): MovieDetails

}
