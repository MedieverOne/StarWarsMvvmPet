package com.medieverone.teststarwarsapi.di.modules

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
    fun providePeopleApi(retrofit: Retrofit): PeopleApi = retrofit.create(PeopleApi::class.java)
}