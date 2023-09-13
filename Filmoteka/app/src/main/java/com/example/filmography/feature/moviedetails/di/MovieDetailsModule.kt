package com.example.filmography.feature.moviedetails.di

import androidx.lifecycle.ViewModel
import com.example.filmography.data.repository.MovieInfoRepositoryImpl
import com.example.filmography.di.viewmodel.ViewModelKey
import com.example.filmography.domain.useCases.movieInfo.MovieInfoRepository
import com.example.filmography.feature.moviedetails.presentation.model.MovieDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MovieDetailsModule {
    @Binds
    fun bindMovieInfoRepository(impl: MovieInfoRepositoryImpl): MovieInfoRepository

    @MovieDetailsScope
    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailsViewModel::class)
    fun bindMovieDetailsViewModel(impl: MovieDetailsViewModel): ViewModel

}
