package com.medieverone.teststarwarsapi.di.modules

import com.medieverone.data.api.ImagesApi
import com.medieverone.data.api.PeopleApi
import com.medieverone.data.database.StarWarsDatabase
import com.medieverone.data.interactors.local.PeopleLocalInteractor
import com.medieverone.data.interactors.local.PeopleRoomInteractor
import com.medieverone.data.interactors.network.ImagesNetworkInteractor
import com.medieverone.data.interactors.network.ImagesRetrofitInteractor
import com.medieverone.data.interactors.network.PeopleNetworkInteractor
import com.medieverone.data.interactors.network.PeopleRetrofitInteractor
import dagger.Module
import dagger.Provides

@Module(includes = [
    ApiModule::class,
    RoomModule::class
])
class InteractorModule {

    @Provides
    fun providePeopleNetworkInteractor(peopleApi: PeopleApi): PeopleNetworkInteractor {
        return PeopleRetrofitInteractor(peopleApi)
    }

    @Provides
    fun providePeopleLocalInteractor(database: StarWarsDatabase): PeopleLocalInteractor {
        return PeopleRoomInteractor(database)
    }

    @Provides
    fun provideImagesNetworkInteractor(imagesApi: ImagesApi): ImagesNetworkInteractor {
        return ImagesRetrofitInteractor(imagesApi)
    }
}