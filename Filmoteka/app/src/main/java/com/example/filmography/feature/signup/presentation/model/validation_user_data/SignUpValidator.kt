package com.example.filmography.feature.signup.presentation.model.validation_user_data

interface SignUpValidator {
    fun validate(login: String, password: String, password2: String): ValidationError?
}

enum class ValidationError {
    LOGIN_LENGTH,
    PASSWORD_LENGTH,
    PASSWORDS_NOT_MATCH
}