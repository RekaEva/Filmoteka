package com.example.filmography.feature.login.presentation.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmography.feature.login.domain.LoginUserUseCaseImpl
import com.example.filmography.navigation.Screens
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val logindb: LoginUserUseCaseImpl,
    private val router: Router
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun login(login: String, password: String) {
        viewModelScope.launch {
            val checkUser = logindb.loginUser(login, password)
            if (checkUser) {
                _uiState.update { currentState ->
                    currentState.copy(
                        isDataCorrect = true
                    )
                }
                router.newRootScreen(Screens.movielist())
            } else {
                _uiState.update { currentState ->
                    currentState.copy(
                        isDataCorrect = false
                    )
                }
            }
        }
    }
}

