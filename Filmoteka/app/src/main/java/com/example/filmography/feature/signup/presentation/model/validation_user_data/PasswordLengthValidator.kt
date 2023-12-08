package com.example.filmography.feature.signup.presentation.model.validation_user_data

import com.example.filmography.R
import javax.inject.Inject

class PasswordLengthValidator @Inject constructor(
    private val error: StringResource
) : SignUpValidator {
    override suspend fun validate(
        login: String, password: String, password2: String
    ): String? {
        if (password.length < 4) {
            return error.getString(R.string.password_len_incorrect)
        }
        return null
    }
}