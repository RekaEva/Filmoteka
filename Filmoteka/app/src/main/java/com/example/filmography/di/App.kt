package com.example.filmography.di

import android.app.Application
import com.example.filmography.room.AppDatabase

class App : Application() {

    private lateinit var database: AppDatabase
    override fun onCreate() {
        super.onCreate()
        ComponentManager.init(this)
    }
}

