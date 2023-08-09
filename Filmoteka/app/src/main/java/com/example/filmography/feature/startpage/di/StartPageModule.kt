package com.example.filmography.feature.startpage.di

import androidx.lifecycle.ViewModel
import com.example.filmography.di.viewmodel.ViewModelKey
import com.example.filmography.feature.startpage.presentation.model.StartPageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface StartPageModule {

    @StartPageScope
    @Binds
    @IntoMap
    @ViewModelKey(StartPageViewModel::class)
    fun bindStartPageViewModel(impl: StartPageViewModel): ViewModel
}