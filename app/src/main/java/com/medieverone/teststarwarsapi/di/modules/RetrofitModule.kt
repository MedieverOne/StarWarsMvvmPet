package com.medieverone.teststarwarsapi.di.modules

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier


@Module(includes = [
    OkHttpClientModule::class
])
class RetrofitModule {

    @Provides
    @Singleton
    @StarWarsRetrofitApi
    fun provideStarWarsRetrofit(@StarWarsOkHttpClient okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_SW_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    @ImageRetrofitApi
    fun provideImagesRetrofit(@ImagesOkHttpClient okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_PICTURES_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()
    }

    companion object {

        const val BASE_SW_URL = "https://swapi.dev/api/"
        const val BASE_PICTURES_URL = "https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/Search/"
    }
}

@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Qualifier
annotation class ImageRetrofitApi

@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Qualifier
annotation class StarWarsRetrofitApi