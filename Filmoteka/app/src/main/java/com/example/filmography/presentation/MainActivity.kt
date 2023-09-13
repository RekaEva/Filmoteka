package com.example.filmography.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.filmography.R
import com.example.filmography.di.AppComponent
import com.example.filmography.di.ComponentManager.appComponent
import com.example.filmography.navigation.Screens
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {

//    @Inject
//    lateinit var userModelFactory: ViewModelFactory
//
//
//    private val loginViewModel by lazy {
//        ViewModelProvider(this, userModelFactory )[LoginViewModel::class.java]
//    }

    private val component: AppComponent by lazy {
        appComponent
    }
    private val navigatorHolder: NavigatorHolder by lazy {
        component.navigationHolder()
    }

    private val navigator = AppNavigator(this, R.id.container)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        component.router().newRootScreen(Screens.startpage())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}