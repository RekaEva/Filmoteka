package com.example.filmography.feature.moviedetails.di

import androidx.lifecycle.ViewModel
import com.example.filmography.di.viewmodel.ViewModelKey
import com.example.filmography.feature.moviedetails.domain.GetMovieDetailsUseCase
import com.example.filmography.feature.moviedetails.domain.GetMovieDetailsUseCaseImpl
import com.example.filmography.feature.moviedetails.presentation.model.MovieDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MovieDetailsModule {
    @Binds
    fun bindGetMovieDetailsUseCase(impl: GetMovieDetailsUseCaseImpl): GetMovieDetailsUseCase

    @MovieDetailsScope
    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailsViewModel::class)
    fun bindMovieDetailsViewModel(impl: MovieDetailsViewModel): ViewModel

}
