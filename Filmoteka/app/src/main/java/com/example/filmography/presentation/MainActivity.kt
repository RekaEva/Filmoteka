package com.example.filmography.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.filmography.R
import com.example.filmography.di.ComponentManager

class MainActivity : AppCompatActivity() {

//    @Inject
//    lateinit var userModelFactory: ViewModelFactory
//
//
//    private val loginViewModel by lazy {
//        ViewModelProvider(this, ViewModelFactory)[LoginViewModel::class.java]
//    }

    private val component by lazy {
        ComponentManager.appComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
//        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        loginViewModel.method()
    }
}
