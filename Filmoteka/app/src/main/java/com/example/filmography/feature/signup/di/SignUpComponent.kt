package com.example.filmography.feature.signup.di

import com.example.filmography.di.AppApi
import com.example.filmography.di.viewmodel.ViewModelModule
import com.example.filmography.feature.signup.presentation.SignUpFragment
import dagger.Component

@SignUpScope
@Component(
    dependencies = [AppApi::class],
    modules = [SignUpModule::class, ViewModelModule::class]
)
interface SignUpComponent {

    fun inject(signUpFragment: SignUpFragment)

    @Component.Builder
    interface SignUpComponentBuilder {

        fun appApi(appApi: AppApi): SignUpComponentBuilder

        fun build(): SignUpComponent
    }
}