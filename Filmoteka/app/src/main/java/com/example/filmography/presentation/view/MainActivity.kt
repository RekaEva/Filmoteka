package com.example.filmography.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.filmography.R
import com.example.filmography.presentation.viewModel.MovieViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
