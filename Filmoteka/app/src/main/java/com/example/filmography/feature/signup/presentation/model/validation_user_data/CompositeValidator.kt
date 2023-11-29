package com.example.filmography.feature.signup.presentation.model.validation_user_data

class CompositeValidator(
    private val validators: List<SignUpValidator>
) : SignUpValidator {
    override suspend fun validate(
        login: String, password: String, password2: String
    ): String? {
        for (validator in validators) {
            val errorMessage = validator.validate(login, password, password2)
            if (errorMessage != null) {
                return errorMessage
            }
        }
        return null
    }
}