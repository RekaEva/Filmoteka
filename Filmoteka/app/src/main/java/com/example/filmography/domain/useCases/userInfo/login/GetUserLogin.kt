package com.example.filmography.domain.usecases.userInfo.login

import com.example.filmography.domain.usecases.userInfo.UserInfoRepository
import javax.inject.Inject

class GetUserLogin @Inject constructor(
    private val repository: UserInfoRepository
) {
    operator fun invoke(): String {
        return repository.getUserLogin()
    }
}