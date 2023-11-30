package com.example.filmography.feature.signup.presentation.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmography.feature.signup.domain.RegisterUserUseCaseImpl
import com.example.filmography.feature.signup.presentation.model.validation_user_data.CompositeValidator
import com.example.filmography.feature.signup.presentation.model.validation_user_data.DuplicateLogin
import com.example.filmography.feature.signup.presentation.model.validation_user_data.LoginLengthValidator
import com.example.filmography.feature.signup.presentation.model.validation_user_data.PasswordLengthValidator
import com.example.filmography.feature.signup.presentation.model.validation_user_data.PasswordsIsSameValidator
import com.example.filmography.feature.signup.presentation.model.validation_user_data.StringResource
import com.example.filmography.navigation.Screens
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val registerUser: RegisterUserUseCaseImpl,
    private val router: Router,
    private val stringResource: StringResource
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()
    fun register(login: String, password: String, password2: String, email: String) {
        viewModelScope.launch {
            val isLoginValid = LoginLengthValidator(stringResource)
            val isPasswordValid = PasswordLengthValidator(stringResource)
            val isPasswordsSame = PasswordsIsSameValidator(stringResource)
            val isLoginUnique = DuplicateLogin(stringResource, registerUser)
            val validators = CompositeValidator(
                mutableListOf(isLoginValid, isPasswordValid, isPasswordsSame, isLoginUnique)
            )
            val isError = validators.validate(login, password, password2)
            if (isError == null) {
                registerUser.addUser(login, password, email)
                router.newRootScreen(Screens.login())
            } else {
                _uiState.update { it.copy(errorText = isError) }
            }
        }
    }
}