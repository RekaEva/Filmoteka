package com.example.filmography.feature.signup.presentation.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmography.feature.signup.domain.RegistrUserUseCaseImpl
import com.example.filmography.navigation.Screens
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val registerUser: RegistrUserUseCaseImpl,
    private val router: Router
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()
    fun register(login: String, password: String, password2: String, email: String) {
        if (password == password2) {
            viewModelScope.launch {
                registerUser.addUser(login, password, email)
            }
            _uiState.update { currentState ->
                currentState.copy(
                    isPasswordsSame = true
                )
            }
            router.newRootScreen(Screens.login())
        } else {
            _uiState.update { currentState ->
                currentState.copy(
                    isPasswordsSame = false
                )
            }
        }
    }
}