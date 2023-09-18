package com.example.filmography.feature.login.di

import com.example.filmography.di.AppApi
import com.example.filmography.feature.login.presentation.LoginFragment
import com.example.filmography.feature.login.presentation.model.LoginViewModel
import dagger.Component

@LoginScope
@Component(dependencies = [AppApi::class], modules = [LoginModule::class])
interface LoginComponent {

    fun inject(loginFragment: LoginFragment)

    @Component.Builder
    interface LoginComponentBuilder {

        fun appApi(appApi: AppApi): LoginComponentBuilder
        fun build(): LoginComponent
    }
}

