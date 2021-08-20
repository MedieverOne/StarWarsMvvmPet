package com.medieverone.teststarwarsapi.di.modules

import com.medieverone.domain.usecase.PeopleUseCase
import com.medieverone.teststarwarsapi.factory.datasource.PeoplesPageKeyedDataSource
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope

@Module(includes = [CoroutineModule::class])
class DataSourceModule {

    @Provides
    fun providePeopleKeyedDataSource(
        @MainCoroutineScope coroutineScope: CoroutineScope,
        peoplesStorage: PeopleUseCase
    ): PeoplesPageKeyedDataSource {
        return PeoplesPageKeyedDataSource(
            coroutineScope, peoplesStorage
        )
    }
}