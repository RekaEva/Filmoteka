package com.example.filmography.di

import android.content.Context
import com.example.filmography.navigation.NavigationModule
import com.example.filmography.presentation.MainActivity
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

interface AppApi {

    fun context(): Context

    fun navigationHolder(): NavigatorHolder
    fun router(): Router
}

@Singleton
@Component(modules = [AppModule::class, NavigationModule::class])
interface AppComponent : AppApi {
    fun inject(activity: MainActivity)

    @Component.Builder
    interface AppComponentBuilder {
        @BindsInstance
        fun context(context: Context): AppComponentBuilder
        fun build(): AppComponent
    }
}