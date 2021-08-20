package com.medieverone.teststarwarsapi.di.modules

import com.medieverone.data.interactors.network.PeopleNetworkInteractor
import com.medieverone.data.repositories.PeopleRepository
import dagger.Module
import dagger.Provides

@Module(
    includes = [InteractorModule::class]
)
class RepositoryModule {

    @Provides
    fun providePeopleRepository(peopleNetworkInteractor: PeopleNetworkInteractor): PeopleRepository {
        return PeopleRepository(peopleNetworkInteractor)
    }
}