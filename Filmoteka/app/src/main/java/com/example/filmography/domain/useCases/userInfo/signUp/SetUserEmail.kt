package com.example.filmography.domain.useCases.userInfo.signUp

import com.example.filmography.domain.useCases.userInfo.UserInfoRepository
import javax.inject.Inject

class SetUserEmail @Inject constructor(
    private val repository: UserInfoRepository
) {
    fun setUserEmail(email: String) {
        repository.setUserEmail(email)
    }
}