package com.example.filmography.data.network

import android.content.Context
import com.example.filmography.data.cache.CacheInterceptor
import com.example.filmography.data.remoute.MovieInfoApi
import com.example.filmography.data.repository.MovieInfoRepositoryImpl
import com.example.filmography.domain.useCases.movieInfo.MovieInfoRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
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
    fun provideOkHttpClient(context: Context): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val cache = createCache(context)
        return OkHttpClient.Builder()
            .addNetworkInterceptor(CacheInterceptor())
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(ApiKeyInterceptor())
            .cache(cache)
            .build()
    }

    private fun createCache(context: Context): Cache {
        val cacheSize = 10 * 1024 * 1024
        val cacheDir = File(context.cacheDir, "http-cache")
        return Cache(cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideMovieInfoApi(retrofit: Retrofit): MovieInfoApi {
        return retrofit.create(MovieInfoApi::class.java)
    }

}