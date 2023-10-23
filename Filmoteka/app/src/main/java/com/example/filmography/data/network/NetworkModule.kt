package com.example.filmography.data.network

import com.example.filmography.data.remoute.MovieInfoApi
import com.example.filmography.data.repository.MovieInfoRepositoryImpl
import com.example.filmography.domain.useCases.movieInfo.MovieInfoRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieInfoApi): MovieInfoRepository {
        return MovieInfoRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        val baseUrl = "https://api.kinopoisk.dev/"
        val gson = GsonBuilder().create()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(Interceptors())
            .build()
    }

    @Provides
    @Singleton
    fun provideInterceptors(): Interceptor {
        return Interceptors()
    }

    @Provides
    @Singleton
    fun provideMovieInfoApi(retrofit: Retrofit): MovieInfoApi {
        return retrofit.create(MovieInfoApi::class.java)
    }

}

