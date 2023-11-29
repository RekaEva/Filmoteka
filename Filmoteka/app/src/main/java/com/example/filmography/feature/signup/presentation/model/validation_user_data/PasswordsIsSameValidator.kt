package com.example.filmography.feature.signup.presentation.model.validation_user_data

import com.example.filmography.R
import javax.inject.Inject

class PasswordsIsSameValidator @Inject constructor(
    private val error: StringResource
) : SignUpValidator {
    override suspend fun validate(
        login: String, password: String, password2: String
    ): String? {
        if (password != password2) {
            return error.getString(R.string.passwords_not_similar)
        }
        return null
    }

}