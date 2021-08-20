package com.medieverone.teststarwarsapi.di.components

import com.medieverone.teststarwarsapi.MainActivity
import com.medieverone.teststarwarsapi.ui.fragments.PeoplesFragment
import dagger.Subcomponent
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
@Subcomponent
interface ScreensComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: PeoplesFragment)
}