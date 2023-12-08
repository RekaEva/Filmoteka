package com.example.filmography.di

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ComponentManager.init(this)
    }
}

