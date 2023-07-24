package com.example.filmography.domain.usecases.userInfo.signUp

import com.example.filmography.domain.usecases.userInfo.UserInfoRepository
import javax.inject.Inject

class SetUserPassword @Inject constructor(
    private val repository: UserInfoRepository
) {
    fun setUserPassword(password: String) {
        repository.setUserPassword(password)
    }
}
