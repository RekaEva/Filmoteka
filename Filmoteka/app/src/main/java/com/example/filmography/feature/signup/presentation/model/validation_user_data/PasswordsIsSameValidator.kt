package com.example.filmography.feature.signup.presentation.model.validation_user_data

class PasswordsIsSameValidator : SignUpValidator {
    override fun validate(login: String, password: String, password2: String): ValidationError? {
        if (password != password2) {
            return ValidationError.PASSWORDS_NOT_MATCH
        }
        return null
    }

}