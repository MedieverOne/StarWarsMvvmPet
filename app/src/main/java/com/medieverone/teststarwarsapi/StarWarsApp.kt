package com.medieverone.teststarwarsapi

import android.app.Application
import android.content.Context
import com.medieverone.teststarwarsapi.di.components.AppComponent
import com.medieverone.teststarwarsapi.di.components.DaggerAppComponent

class StarWarsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        AppComponent.init(
            DaggerAppComponent.builder()
                .build()
        )
    }

    companion object {
        @Volatile
        lateinit var appContext: Context
            private set
    }
}