package com.example.filmography.feature.signup.presentation.model

data class SignUpUiState(
    var isLoginUnique: Boolean = true,
    var isLoginValid: Boolean = true,
    var isPasswordValid: Boolean = true,
    var isPasswordsSame: Boolean = true
)