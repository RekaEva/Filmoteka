package com.example.filmography.domain.useCases.userInfo

interface UserInfoRepository {
    fun getUserLogin(): String
    fun getUserPassword(): String
    fun setUserEmail(email: String)
    fun setUserLogin(login: String)
    fun setUserPassword(password: String)

}
