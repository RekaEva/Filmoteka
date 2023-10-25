package com.example.filmography.feature.moviedetails.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.filmography.di.ComponentManager
import com.example.filmography.feature.moviedetails.presentation.compose.MovieDetailsScreen
import com.example.filmography.feature.moviedetails.presentation.model.MovieDetailsViewModel
import javax.inject.Inject

class MovieDetailsFragment : Fragment() {

    companion object {
        fun newInstance(movieId: Int): Fragment {
            val arg = Bundle()
            arg.putInt("movieId", movieId)
            val fragment = MovieDetailsFragment()
            fragment.arguments = arg
            return fragment
        }
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
        val movieId = arguments?.getInt("movieId") ?: 0
        return ComposeView(requireContext()).apply {
            setContent {
                MovieDetailsScreen(mdViewModel, movieId)
            }
        }
    }
}