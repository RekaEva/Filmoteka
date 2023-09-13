package com.example.filmography.feature.startpage.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.filmography.di.ComponentManager
import com.example.filmography.feature.startpage.presentation.compose.StartPage
import com.example.filmography.feature.startpage.presentation.model.StartPageViewModel
import javax.inject.Inject


class StartPageFragment : Fragment() {

    companion object {
        fun newInstance(): Fragment = StartPageFragment()
    }

    @Inject
    lateinit var startPageViewModel: StartPageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ComponentManager.createStartPageComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                StartPage(startPageViewModel)
            }
        }
    }
}