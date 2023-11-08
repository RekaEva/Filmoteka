package com.example.filmography.feature.movielist.presentation.model

import androidx.lifecycle.ViewModel
import com.example.filmography.feature.movielist.domain.GetMovieListUseCaseImpl
import com.example.filmography.navigation.Screens
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class MovieListViewModel @Inject constructor(
    private val movieList: GetMovieListUseCaseImpl,
    private val router: Router
) : ViewModel() {

    fun getMovieListPaging() = movieList.getMovieListPagging()


    fun showDetailsButton(id: Int) {
        router.navigateTo(Screens.moviedetails(id))
    }

    fun backToLoginScreen() {
        router.newRootScreen(Screens.login())
    }
}
