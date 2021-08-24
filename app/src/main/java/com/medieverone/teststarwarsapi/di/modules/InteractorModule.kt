package com.medieverone.teststarwarsapi.di.modules

import com.medieverone.data.api.ImagesApi
import com.medieverone.data.api.PeopleApi
import com.medieverone.data.database.ImagesDatabase
import com.medieverone.data.database.StarWarsDatabase
import com.medieverone.data.interactors.local.ImagesLocalInteractor
import com.medieverone.data.interactors.local.PeopleLocalInteractor
import com.medieverone.data.interactors.local.images.ImagesRoomInteractor
import com.medieverone.data.interactors.local.peoples.PeopleRoomInteractor
import com.medieverone.data.interactors.network.ImagesNetworkInteractor
import com.medieverone.data.interactors.network.images.ImagesRetrofitInteractor
import com.medieverone.data.interactors.network.PeopleNetworkInteractor
import com.medieverone.data.interactors.network.peoples.PeopleRetrofitInteractor
import dagger.Module
import dagger.Provides

@Module(includes = [
    ApiModule::class,
    RoomModule::class
])
class InteractorModule {

    @Provides
    fun providePeopleNetworkInteractor(
        peopleApi: PeopleApi
    ): PeopleNetworkInteractor {
        return PeopleRetrofitInteractor(peopleApi)
    }

    @Provides
    fun providePeopleLocalInteractor(
        @StarWarsDatabaseAnnotation database: StarWarsDatabase
    ): PeopleLocalInteractor {
        return PeopleRoomInteractor(database)
    }

    @Provides
    fun provideImagesNetworkInteractor(
        imagesApi: ImagesApi
    ): ImagesNetworkInteractor {
        return ImagesRetrofitInteractor(imagesApi)
    }

    @Provides
    fun provideImagesLocalInteractor(
        @ImagesDatabaseAnnotation database: ImagesDatabase
    ): ImagesLocalInteractor {
        return ImagesRoomInteractor(database)
    }
}