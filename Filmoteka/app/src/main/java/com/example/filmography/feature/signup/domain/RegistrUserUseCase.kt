package com.example.filmography.feature.signup.domain

interface RegistrUserUseCase {
    suspend fun addUser(login: String, password: String, email: String)
}