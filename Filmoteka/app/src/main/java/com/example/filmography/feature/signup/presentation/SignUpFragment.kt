package com.example.filmography.feature.signup.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.filmography.feature.login.presentation.LoginFragment
import com.example.filmography.feature.signup.presentation.compose.SignUpScreen

class SignUpFragment : Fragment() {

    companion object {
        fun newInstance(): Fragment = SignUpFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                SignUpScreen()
            }
        }
    }
}