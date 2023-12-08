package com.example.filmography.feature.signup.domain

import com.example.filmography.domain.useCases.userInfo.UserInfoRepository
import javax.inject.Inject

class RegisterUserUseCaseImpl @Inject constructor(
    private val repository: UserInfoRepository
) : RegisterUserUseCase {
    override suspend fun checkUserLogin(login: String): Boolean {
        return repository.checkUserLogin(login)
    }

    override suspend fun addUser(login: String, password: String, email: String) {
        repository.addUser(login, password, email)
    }
}
