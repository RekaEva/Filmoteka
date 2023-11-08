package com.example.filmography.feature.moviedetails.presentation.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmography.feature.moviedetails.domain.GetMovieDetailsUseCaseImpl
import com.example.filmography.navigation.Screens
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDetailsViewModel @Inject constructor(
    private val movieDetails: GetMovieDetailsUseCaseImpl,
    private val router: Router,
) : ViewModel() {
    private val _uiState = MutableStateFlow(MovieDetailsUiState())
    val uiState: StateFlow<MovieDetailsUiState> = _uiState.asStateFlow()
    fun loadMovieDetails(movieId: Int) {
        viewModelScope.launch {
            try {
                _uiState.emit(_uiState.value.copy(load = true))
                val details = movieDetails.getMovieDetails(movieId)
                _uiState.update { currentState ->
                    currentState.copy(
                        movieDetails = details,
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

    fun onBackButtonPressed() {
        router.backTo(Screens.movielist())
    }
}