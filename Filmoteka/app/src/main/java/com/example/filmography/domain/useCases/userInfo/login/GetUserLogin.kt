package com.example.filmography.domain.useCases.userInfo.login

import com.example.filmography.domain.useCases.userInfo.UserInfoRepository
import javax.inject.Inject

class GetUserLogin @Inject constructor(
    private val repository: UserInfoRepository
) {
    operator fun invoke(): String {
        return repository.getUserLogin()
    }
}