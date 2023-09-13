package com.example.filmography.feature.login.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.filmography.di.ComponentManager
import com.example.filmography.feature.login.presentation.compose.LoginScreen
import com.example.filmography.feature.login.presentation.model.LoginViewModel
import javax.inject.Inject

class LoginFragment : Fragment() {

    companion object {
        fun newInstance(): Fragment = LoginFragment()
    }

    @Inject
    lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ComponentManager.createLoginComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                LoginScreen(loginViewModel)
            }
        }
    }
}