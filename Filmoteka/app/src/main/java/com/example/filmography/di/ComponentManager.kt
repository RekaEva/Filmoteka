package com.example.filmography.di

import android.content.Context
import com.example.filmography.feature.login.di.DaggerLoginComponent
import com.example.filmography.feature.login.di.LoginComponent
import com.example.filmography.feature.moviedetails.di.DaggerMovieDetailsComponent
import com.example.filmography.feature.moviedetails.di.MovieDetailsComponent
import com.example.filmography.feature.movielist.di.DaggerMovieListComponent
import com.example.filmography.feature.movielist.di.MovieListComponent
import com.example.filmography.feature.signup.di.DaggerSignUpComponent
import com.example.filmography.feature.signup.di.SignUpComponent
import com.example.filmography.feature.startpage.di.DaggerStartPageComponent
import com.example.filmography.feature.startpage.di.StartPageComponent


object ComponentManager {
    lateinit var appComponent: AppComponent

    fun init(context: Context) {
        appComponent = createAppComponent(context)
    }

    fun createMainComponent(): MainComponent {
        return DaggerMainComponent.builder().appApi(appComponent).build()
    }

    fun createLoginComponent(): LoginComponent {
        return DaggerLoginComponent.builder().appApi(appComponent).build()
    }

    fun createSignUpComponent(): SignUpComponent {
        return DaggerSignUpComponent.builder().appApi(appComponent).build()
    }

    fun createMovieListComponent(): MovieListComponent {
        return DaggerMovieListComponent.builder().appApi(appComponent).build()
    }

    fun createMovieDetailsComponent(): MovieDetailsComponent {
        return DaggerMovieDetailsComponent.builder().appApi(appComponent).build()
    }

    fun createStartPageComponent(): StartPageComponent {
        return DaggerStartPageComponent.builder().build()
    }


}

fun createAppComponent(context: Context): AppComponent {
    return DaggerAppComponent.builder().context(context).build()
}