package com.example.filmography.feature.startpage.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.filmography.di.AppComponent
import com.example.filmography.di.ComponentManager
import com.example.filmography.feature.startpage.presentation.compose.StartPage


class StartPageFragment(private val component: AppComponent) : Fragment() {

    companion object {
        fun newInstance(): Fragment = StartPageFragment(ComponentManager.appComponent)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                StartPage(component)
            }
        }
    }
}