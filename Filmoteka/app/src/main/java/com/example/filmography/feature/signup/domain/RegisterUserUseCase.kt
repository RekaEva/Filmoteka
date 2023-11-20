package com.example.filmography.feature.signup.domain

interface RegisterUserUseCase {
    suspend fun checkUserLogin(login: String): Boolean
    suspend fun addUser(login: String, password: String, email: String)
}