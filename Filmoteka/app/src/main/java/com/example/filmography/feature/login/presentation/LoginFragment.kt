package com.example.filmography.feature.login.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.filmography.feature.login.presentation.compose.LoginScreen

class LoginFragment(private val component: AppComponent) : Fragment() {

    companion object {
        fun newInstance(): Fragment = LoginFragment(ComponentManager.appComponent)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                LoginScreen(component)
            }
        }
    }
}