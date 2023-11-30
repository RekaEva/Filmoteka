package com.example.filmography.feature.signup.presentation.model.validation_user_data

import android.content.Context
import javax.inject.Inject

class StringResourceImpl @Inject constructor(private val context: Context) : StringResource {
    override fun getString(resId: Int): String {
        return context.getString(resId)
    }
}