package com.example.filmography.feature.signup.presentation.model

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.filmography.domain.usecases.userInfo.signUp.SetUserEmail
import com.example.filmography.domain.usecases.userInfo.signUp.SetUserLogin
import com.example.filmography.domain.usecases.userInfo.signUp.SetUserPassword
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val userEmail: SetUserEmail,
    private val userLogin: SetUserLogin,
    private val userPassword: SetUserPassword
) : ViewModel() {

    fun setUserEmail(email: String) {
        userEmail.setUserEmail(email)
    }

    fun setUserLogin(login: String) {
        userLogin.setUserLogin(login)
    }

    fun setUserPassword(password: String) {
        userPassword.setUserPassword(password)
    }
}

fun register(login: String, password: String, password2: String, context: Context) {

    if (password == password2) {
        // подтвердить email. обращение через domain  к data слою
    } else {
        Toast.makeText(context, "Введеные пароли не совпадают", Toast.LENGTH_SHORT).show()
    }
}