package com.example.filmography.di

import com.example.filmography.di.viewmodel.ViewModelModule
import dagger.Component

@MainScope
@Component(dependencies = [AppApi::class], modules = [ViewModelModule::class])
interface MainComponent