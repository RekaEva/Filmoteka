package com.example.filmography.domain.useCases.userInfo

interface UserInfoRepository {
    suspend fun checkUserLogin(login: String): Boolean
    suspend fun addUser(login: String, password: String, email: String)
    suspend fun loginUser(login: String, password: String): Boolean
}
