package com.example.filmography.feature.moviedetails.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.filmography.di.ComponentManager
import com.example.filmography.di.ComponentManager.appComponent
import com.example.filmography.di.viewmodel.ViewModelFactory
import com.example.filmography.di.viewmodel.ViewModelModule
import com.example.filmography.feature.moviedetails.di.DaggerMovieDetailsComponent
import com.example.filmography.feature.moviedetails.presentation.compose.MovieDetailsScreen
import com.example.filmography.feature.moviedetails.presentation.model.MovieDetailsViewModel
import javax.inject.Inject

class MovieDetailsFragment() : Fragment() {

    companion object {
        fun newInstance(): Fragment = MovieDetailsFragment()
    }

    @Inject
    lateinit var mdViewModel: MovieDetailsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ComponentManager.createMovieDetailsComponent().inject(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MovieDetailsScreen(mdViewModel)
            }
        }
    }
}




