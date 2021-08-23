package com.medieverone.teststarwarsapi.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
class OkHttpClientModule {

    @Provides
    @Singleton
    @StarWarsOkHttpClient
    fun provideStarWarsOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    @ImagesOkHttpClient
    fun provideImagesOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(Interceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .addHeader("x-rapidapi-host", "contextualwebsearch-websearch-v1.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", "2296c7243cmsh7668e67c32c7a29p14eeb9jsncd0612885ec6")
                    .build()
                chain.proceed(request)
            })
            .build()
    }
}

@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Qualifier
annotation class ImagesOkHttpClient

@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Qualifier
annotation class StarWarsOkHttpClient