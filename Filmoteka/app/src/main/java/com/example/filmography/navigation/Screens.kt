package com.example.filmography.navigation

import com.example.filmography.feature.login.presentation.LoginFragment
import com.example.filmography.feature.moviedetails.presentation.MovieDetailsFragment
import com.example.filmography.feature.movielist.presentation.MovieListFragment
import com.example.filmography.feature.signup.presentation.SignUpFragment
import com.example.filmography.feature.startpage.presentation.StartPageFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun startpage() = FragmentScreen { StartPageFragment.newInstance() }
    fun login() = FragmentScreen { LoginFragment.newInstance() }
    fun signup() = FragmentScreen { SignUpFragment.newInstance() }
    fun movielist() = FragmentScreen { MovieListFragment.newInstance() }
    fun moviedetails(id: Int) = FragmentScreen { MovieDetailsFragment.newInstance(id) }
}
