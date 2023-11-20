package com.example.filmography.feature.signup.presentation.model.validation_user_data

class CompositeValidator(private val validators: List<SignUpValidator>) : SignUpValidator {
    override fun validate(login: String, password: String, password2: String): ValidationError? {
        for (validator in validators) {
            val errorType = validator.validate(login, password, password2)
            if (errorType != null) {
                return errorType
            }
        }
        return null
    }
}

