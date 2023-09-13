package com.example.filmography.feature.login.presentation.model

import androidx.lifecycle.ViewModel
import com.example.filmography.di.ComponentManager
import com.example.filmography.domain.useCases.userInfo.login.GetUserLogin
import com.example.filmography.domain.useCases.userInfo.login.GetUserPassword
import com.example.filmography.navigation.Screens
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val userLogin: GetUserLogin,
    private val userPassword: GetUserPassword
) : ViewModel() {

    fun getUserLogin(): String {
        println("6969696")
        return userLogin()
    }

    fun getUserPassword(): String {
        return userPassword()
    }

    fun logInButton() {
        ComponentManager.appComponent.router().newRootScreen(Screens.movielist())
    }
}

fun login(login: String, password: String): Boolean {
    // тут проверка на правильность введеных данных

    return true
//    return login == "test" && password == "123"


}