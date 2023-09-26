package com.example.filmography.feature.login.di

import androidx.lifecycle.ViewModel
import com.example.filmography.di.viewmodel.ViewModelKey
import com.example.filmography.feature.login.domain.LoginUserUseCase
import com.example.filmography.feature.login.domain.LoginUserUseCaseImpl
import com.example.filmography.feature.login.presentation.model.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface LoginModule {

    @Binds
    fun bindLoginUserUseCase(impl: LoginUserUseCaseImpl): LoginUserUseCase

    @LoginScope
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun bindLoginViewModel(impl: LoginViewModel): ViewModel

}