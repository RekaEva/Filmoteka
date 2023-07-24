package com.example.filmography.feature.movielist.di

import com.example.filmography.di.AppApi
import com.example.filmography.feature.movielist.presentation.MovieListFragment
import dagger.Component


@MovieListScope
@Component(dependencies = [AppApi::class], modules = [MovieListModule::class])
interface MovieListComponent {

    fun inject(movieListFragment: MovieListFragment)

    @Component.Builder
    interface MovieListComponentBuilder {
        fun appApi(appApi: AppApi): MovieListComponentBuilder

        fun build(): MovieListComponent
    }
}