package com.example.filmography.feature.signup.presentation.model.validation_user_data

import com.example.filmography.R
import com.example.filmography.feature.signup.domain.RegisterUserUseCaseImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DuplicateLogin @Inject constructor(
    private val error: StringResource,
    private val registerUser: RegisterUserUseCaseImpl
) : SignUpValidator {
    override suspend fun validate(login: String, password: String, password2: String): String? {
        val isLoginUnique = withContext(Dispatchers.IO) {
            registerUser.checkUserLogin(login)
        }
        if (!isLoginUnique) {
            return error.getString(R.string.login_already_exist)
        }
        return null
    }
}