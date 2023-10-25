package com.example.filmography.feature.movielist.presentation.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmography.feature.movielist.domain.GetMovieListUseCaseImpl
import com.example.filmography.navigation.Screens
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieListViewModel @Inject constructor(
    private val movieList: GetMovieListUseCaseImpl,
    private val router: Router
) : ViewModel() {

    private val _uiState = MutableStateFlow(MovieListUiState())
    val uiState: StateFlow<MovieListUiState> = _uiState.asStateFlow()

    fun getMovieList() {
        viewModelScope.launch {
            try {
                _uiState.emit(_uiState.value.copy(load = true))
                val list = movieList.getMoviesList()
                _uiState.update { currentState ->
                    currentState.copy(
                        list = list,
                        load = false
                    )
                }
            } catch (errorMessage: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(
                        error = errorMessage,
                        load = false
                    )
                }
            }
        }
    }

    fun showDetailsButton(id: Int) {
        router.navigateTo(Screens.moviedetails(id))
    }

    fun backToLoginScreen() {
        router.newRootScreen(Screens.login())
    }
}
