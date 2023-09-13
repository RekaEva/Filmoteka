package com.example.filmography.feature.moviedetails.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.filmography.di.AppComponent
import com.example.filmography.di.ComponentManager
import com.example.filmography.feature.moviedetails.presentation.compose.MovieDetailsScreen

class MovieDetailsFragment() : Fragment() {

    companion object {
        fun newInstance(): Fragment = MovieDetailsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MovieDetailsScreen()
            }
        }
    }

}

