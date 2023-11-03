package com.example.filmography.feature.movielist.di

import androidx.lifecycle.ViewModel
import com.example.filmography.di.viewmodel.ViewModelKey
import com.example.filmography.feature.movielist.domain.GetMovieListUseCase
import com.example.filmography.feature.movielist.domain.GetMovieListUseCaseImpl
import com.example.filmography.feature.movielist.presentation.model.MovieListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MovieListModule {
    @Binds
    fun bindGetMovieListUseCase(impl: GetMovieListUseCaseImpl): GetMovieListUseCase

    @MovieListScope
    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    fun bindMovieListViewModel(impl: MovieListViewModel): ViewModel
}