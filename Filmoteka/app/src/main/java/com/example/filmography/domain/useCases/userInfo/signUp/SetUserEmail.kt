package com.example.filmography.domain.usecases.userInfo.signUp

import com.example.filmography.domain.usecases.userInfo.UserInfoRepository
import javax.inject.Inject

class SetUserEmail @Inject constructor(
    private val repository: UserInfoRepository
) {
    fun setUserEmail(email: String) {
        repository.setUserEmail(email)
    }
}