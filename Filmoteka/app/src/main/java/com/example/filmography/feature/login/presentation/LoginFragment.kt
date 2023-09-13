package com.example.filmography.feature.login.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.filmography.di.AppComponent
import com.example.filmography.di.ComponentManager
import com.example.filmography.feature.login.presentation.compose.LoginScreen
import com.github.terrakok.cicerone.NavigatorHolder

class LoginFragment : Fragment() {

    companion object {
        fun newInstance(): Fragment = LoginFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        println("Start login Page")
        return ComposeView(requireContext()).apply {
            setContent {
                LoginScreen()
            }
        }
    }
}