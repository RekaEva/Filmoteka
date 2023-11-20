package com.example.filmography.feature.signup.presentation.model.validation_user_data

class PasswordLengthValidator : SignUpValidator {
    override fun validate(login: String, password: String, password2: String): ValidationError? {
        if (password.length < 4) {
            return ValidationError.PASSWORD_LENGTH
        }
        return null
    }
}