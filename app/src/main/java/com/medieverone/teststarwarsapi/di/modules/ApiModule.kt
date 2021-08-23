package com.medieverone.teststarwarsapi.di.modules

import com.medieverone.data.api.ImagesApi
import com.medieverone.data.api.PeopleApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [
    RetrofitModule::class
])
class ApiModule {

    @Provides
    @Singleton
    fun providePeopleApi(@StarWarsRetrofitApi retrofit: Retrofit): PeopleApi = retrofit.create(PeopleApi::class.java)

    @Provides
    @Singleton
    fun provideImagesApi(@ImageRetrofitApi retrofit: Retrofit): ImagesApi = retrofit.create(ImagesApi::class.java)
}