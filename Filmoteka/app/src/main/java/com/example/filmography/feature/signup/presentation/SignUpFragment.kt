package com.example.filmography.feature.signup.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.filmography.di.AppComponent
import com.example.filmography.di.ComponentManager
import com.example.filmography.feature.login.presentation.model.LoginViewModel
import com.example.filmography.feature.signup.presentation.compose.SignUpScreen
import com.example.filmography.feature.signup.presentation.model.SignUpViewModel
import javax.inject.Inject

class SignUpFragment() : Fragment() {

    companion object {
        fun newInstance(): Fragment = SignUpFragment()
    }

//    @Inject
//    lateinit var signUpViewModel: SignUpViewModel
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        ComponentManager.createSignUpComponent().inject(this)
//    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                SignUpScreen()
//                SignUpScreen(signUpViewModel)
            }
        }
    }
}