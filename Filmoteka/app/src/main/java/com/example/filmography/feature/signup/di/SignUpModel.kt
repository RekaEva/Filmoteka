package com.example.filmography.feature.signup.di

import androidx.lifecycle.ViewModel
import com.example.filmography.di.viewmodel.ViewModelKey
import com.example.filmography.feature.signup.domain.RegistrUserUseCase
import com.example.filmography.feature.signup.domain.RegistrUserUseCaseImpl
import com.example.filmography.feature.signup.presentation.model.SignUpViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface SignUpModule {
    @Binds
    fun bindRegistrUserUseCase(impl: RegistrUserUseCaseImpl): RegistrUserUseCase

    @SignUpScope
    @Binds
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    fun bindSignUpViewModel(impl: SignUpViewModel): ViewModel

}