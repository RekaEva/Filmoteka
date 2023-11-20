package com.example.filmography.feature.signup.presentation.model.validation_user_data

class LoginLengthValidator : SignUpValidator {
    override fun validate(login: String, password: String, password2: String): ValidationError? {
        if (login.length < 2) {
            return ValidationError.LOGIN_LENGTH
        }
        return null
    }
}