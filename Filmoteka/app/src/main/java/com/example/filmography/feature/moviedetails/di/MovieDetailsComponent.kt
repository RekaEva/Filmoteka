package com.example.filmography.feature.moviedetails.di

import com.example.filmography.di.AppApi
import com.example.filmography.feature.moviedetails.presentation.MovieDetailsFragment
import dagger.Component

@MovieDetailsScope
@Component(dependencies = [AppApi::class], modules = [MovieDetailsModule::class])
interface MovieDetailsComponent {

    fun inject(movieDetailsFragment: MovieDetailsFragment)

    @Component.Builder
    interface MovieDetailsComponentBuilder {
        fun appApi(appApi: AppApi): MovieDetailsComponentBuilder

        fun build(): MovieDetailsComponent
    }
}
