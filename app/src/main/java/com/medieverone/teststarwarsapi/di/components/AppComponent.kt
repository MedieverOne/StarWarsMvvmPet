package com.medieverone.teststarwarsapi.di.components

import com.medieverone.teststarwarsapi.di.modules.*
import dagger.Component
import dagger.internal.Preconditions
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Singleton

@Component(
    modules = [
        ContextModule::class,
        UseCaseModule::class,
        InteractorModule::class,
        RetrofitModule::class,
        ApiModule::class,
        RepositoryModule::class,
        ViewModelFactoryModule::class,
        DataSourceModule::class,
        CoroutineModule::class,
        RoomModule::class,
        OkHttpClientModule::class
    ]
)
@Singleton
abstract class AppComponent {

    @DelicateCoroutinesApi
    abstract fun screensComponent(): ScreensComponent

    companion object {

        @Volatile
        private var instance: AppComponent? = null

        fun get(): AppComponent {
            return Preconditions.checkNotNull(
                instance,
                "AppComponent is not initialized"
            )!!
        }

        fun init(component: AppComponent) {
            require(instance == null) {
                "AppComponent is initialized"
            }
            instance = component
        }
    }
}