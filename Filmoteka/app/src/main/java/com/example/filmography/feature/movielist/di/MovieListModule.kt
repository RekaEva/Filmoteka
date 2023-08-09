package com.example.filmography.feature.movielist.di

import androidx.lifecycle.ViewModel
import com.example.filmography.data.repository.MovieInfoRepositoryImpl
import com.example.filmography.di.viewmodel.ViewModelKey
import com.example.filmography.domain.usecases.movieInfo.MovieInfoRepository
import com.example.filmography.feature.movielist.presentation.model.MovieListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MovieListModule {
    @Binds
    fun bindMovieInfoRepository(impl: MovieInfoRepositoryImpl): MovieInfoRepository

    @MovieListScope
    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    fun bindMovieListViewModel(impl: MovieListViewModel): ViewModel

}
