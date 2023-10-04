package com.example.filmography.feature.login.domain

import com.example.filmography.domain.useCases.userInfo.UserInfoRepository
import com.example.filmography.feature.login.di.LoginScope
import javax.inject.Inject

@LoginScope
class LoginUserUseCaseImpl @Inject constructor(
    private val repository: UserInfoRepository
) : LoginUserUseCase {

    override suspend fun loginUser(login: String, password: String): Boolean {
        return repository.loginUser(login, password)
    }
}

