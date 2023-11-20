package com.example.filmography.feature.signup.di

import androidx.lifecycle.ViewModel
import com.example.filmography.di.viewmodel.ViewModelKey
import com.example.filmography.feature.signup.domain.RegisterUserUseCase
import com.example.filmography.feature.signup.domain.RegisterUserUseCaseImpl
import com.example.filmography.feature.signup.presentation.model.SignUpViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface SignUpModule {
    @Binds
    fun bindRegistrUserUseCase(impl: RegisterUserUseCaseImpl): RegisterUserUseCase

    @SignUpScope
    @Binds
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    fun bindSignUpViewModel(impl: SignUpViewModel): ViewModel

}