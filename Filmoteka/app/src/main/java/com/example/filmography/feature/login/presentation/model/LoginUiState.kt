package com.example.filmography.feature.login.presentation.model

data class LoginUiState(
    val login: String = "",
    val password: String = "",
    val isDataCorrect: Boolean = true
)