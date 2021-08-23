package com.medieverone.teststarwarsapi.di.modules

import com.medieverone.data.interactors.local.PeopleLocalInteractor
import com.medieverone.data.interactors.network.ImagesNetworkInteractor
import com.medieverone.data.interactors.network.PeopleNetworkInteractor
import com.medieverone.data.repositories.ImagesRepository
import com.medieverone.data.repositories.PeopleRepository
import dagger.Module
import dagger.Provides

@Module(
    includes = [InteractorModule::class]
)
class RepositoryModule {

    @Provides
    fun providePeopleRepository(
        peopleNetworkInteractor: PeopleNetworkInteractor,
        peopleLocalInteractor: PeopleLocalInteractor
    ): PeopleRepository {
        return PeopleRepository(peopleNetworkInteractor, peopleLocalInteractor)
    }

    @Provides
    fun provideImagesRepository(
        imagesNetworkInteractor: ImagesNetworkInteractor
    ): ImagesRepository {
        return ImagesRepository(imagesNetworkInteractor)
    }
}