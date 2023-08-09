package com.example.filmography.feature.startpage.di

import com.example.filmography.feature.startpage.presentation.StartPageFragment
import dagger.Component


@StartPageScope
@Component(modules = [StartPageModule::class])
interface StartPageComponent {

    fun inject(startpageFragment: StartPageFragment)

    @Component.Builder
    interface StartPageComponentBuilder {

        fun build(): StartPageComponent
    }

}