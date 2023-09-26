package com.example.filmography.feature.signup.domain

import com.example.filmography.domain.useCases.userInfo.UserInfoRepository
import javax.inject.Inject

class RegistrUserUseCaseImpl @Inject constructor(
    private val repository: UserInfoRepository
) : RegistrUserUseCase {
    override suspend fun addUser(login: String, password: String, email: String) {
        repository.addUser(login, password, email)
    }
}
