package com.example.filmography.di

import androidx.lifecycle.ViewModelProvider
import com.example.filmography.di.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface AppModule {
    @Binds
    @Singleton
    fun bindViewModelFactory(impl: ViewModelFactory): ViewModelProvider.Factory
}
