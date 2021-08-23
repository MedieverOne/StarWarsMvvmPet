package com.medieverone.teststarwarsapi.di.modules

import android.content.Context
import com.medieverone.teststarwarsapi.StarWarsApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule {

    @Provides
    @Singleton
    fun provideContext(): Context = StarWarsApp.appContext
}