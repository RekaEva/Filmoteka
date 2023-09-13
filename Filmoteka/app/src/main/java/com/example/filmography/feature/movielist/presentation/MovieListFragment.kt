package com.example.filmography.feature.movielist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.filmography.di.ComponentManager
import com.example.filmography.feature.movielist.presentation.compose.MovieListScreen
import com.example.filmography.feature.movielist.presentation.model.MovieListViewModel
import javax.inject.Inject

class MovieListFragment : Fragment() {

    companion object {
        fun newInstance(): Fragment = MovieListFragment()
    }

    @Inject
    lateinit var mlViewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ComponentManager.createMovieListComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MovieListScreen(mlViewModel)
            }
        }
    }
}