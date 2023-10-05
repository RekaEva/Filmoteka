package com.example.filmography.feature.login.domain

interface LoginUserUseCase {
    suspend fun loginUser(login: String, password: String): Boolean
}