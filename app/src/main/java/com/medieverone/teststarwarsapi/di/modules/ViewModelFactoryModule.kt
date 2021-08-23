package com.medieverone.teststarwarsapi.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.medieverone.teststarwarsapi.factory.ViewModelFactory
import com.medieverone.teststarwarsapi.di.scopes.ViewModelScope
import com.medieverone.teststarwarsapi.ui.viewmodels.PeoplesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {

    @Binds
    @IntoMap
    @ViewModelScope(PeoplesViewModel::class)
    abstract fun bindPeoplesViewModel(peoplesViewModel: PeoplesViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}