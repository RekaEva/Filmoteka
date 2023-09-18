package com.example.filmography.feature.startpage.presentation.model

import androidx.lifecycle.ViewModel
import com.example.filmography.di.ComponentManager
import com.example.filmography.navigation.Screens
import javax.inject.Inject


class StartPageViewModel @Inject constructor(
) : ViewModel() {
    fun pressLogin() {
        ComponentManager.appComponent.router().navigateTo(Screens.login())
    }

    fun pressSignUp() {
        ComponentManager.appComponent.router().navigateTo(Screens.signup())
    }

}