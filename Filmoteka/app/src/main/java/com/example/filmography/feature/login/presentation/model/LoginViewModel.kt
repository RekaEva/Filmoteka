package com.example.filmography.feature.login.presentation.model

import androidx.lifecycle.ViewModel
import com.example.filmography.domain.usecases.userInfo.login.GetUserLogin
import com.example.filmography.domain.usecases.userInfo.login.GetUserPassword
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val userLogin: GetUserLogin,
    private val userPassword: GetUserPassword
) : ViewModel() {

    fun getUserLogin(): String {
        return userLogin()
    }

    fun getUserPassword(): String {
        return userPassword()
    }

}

fun login(login: String, password: String): Boolean {
    // тут проверка на правильность введеных данных
    return login == "test" && password == "123"


}