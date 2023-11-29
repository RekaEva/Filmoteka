package com.example.filmography.feature.signup.presentation.model.validation_user_data

interface SignUpValidator {
    suspend fun validate(login: String, password: String, password2: String): String?
}
