package com.example.filmography.domain.useCases.userInfo.signUp

import com.example.filmography.domain.useCases.userInfo.UserInfoRepository
import javax.inject.Inject

class SetUserLogin @Inject constructor(
    private val repository: UserInfoRepository
) {
    fun setUserLogin(login: String) {
        repository.setUserLogin(login)
    }
}