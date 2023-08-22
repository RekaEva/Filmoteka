package com.example.filmography.presentation.viewModel

import android.content.Context
import android.widget.Toast


fun registr(login: String, password: String, password2: String, context: Context) {

    if (password == password2) {
        // подтвердить email. обращение через domain  к data слою
    } else {
        Toast.makeText(context, "Введеные пароли не совпадают", Toast.LENGTH_SHORT).show()
    }
}

fun logged(login: String, password: String) {
    // тут логика в случает успешной и неуспешной автоирзации
}