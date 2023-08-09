package com.example.filmography.di

import android.content.Context
import com.example.filmography.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

interface AppApi {

    fun context(): Context
}

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : AppApi {
    fun inject(activity: MainActivity)

    @Component.Builder
    interface AppComponentBuilder {
        @BindsInstance
        fun context(context: Context): AppComponentBuilder
        fun build(): AppComponent
    }
}