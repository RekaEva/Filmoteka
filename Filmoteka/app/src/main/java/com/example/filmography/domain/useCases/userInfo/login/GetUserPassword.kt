package com.example.filmography.domain.usecases.userInfo.login

import com.example.filmography.domain.usecases.userInfo.UserInfoRepository
import javax.inject.Inject

class GetUserPassword @Inject constructor(
    private val repository: UserInfoRepository
) {
    operator fun invoke(): String {
        return repository.getUserPassword()
    }
}