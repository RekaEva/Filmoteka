package com.example.filmography.feature.signup.presentation.model

data class SignUpUiState(
    val emailIsCheck: Boolean = true,
    val isPasswordsSame: Boolean = true,
    val isLoginUnique: Boolean = true
)