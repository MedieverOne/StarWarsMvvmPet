package com.medieverone.teststarwarsapi.di.modules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Module
class CoroutineModule {

    @MainCoroutineScope
    @Provides
    fun provideMainScope(): CoroutineScope {
        return CoroutineScope(Dispatchers.Main)
    }

    @IoCoroutineScope
    @Provides
    fun provideIoScope(): CoroutineScope {
        return CoroutineScope(Dispatchers.IO)
    }

    @DefaultCoroutineScope
    @Provides
    fun provideDefaultScope(): CoroutineScope {
        return CoroutineScope(Dispatchers.Default)
    }
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DefaultCoroutineScope

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoCoroutineScope

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainCoroutineScope