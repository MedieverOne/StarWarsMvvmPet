package com.medieverone.teststarwarsapi.di.modules

import com.medieverone.data.repositories.ImagesRepository
import com.medieverone.data.repositories.PeopleRepository
import com.medieverone.domain.usecase.ImagesUseCase
import com.medieverone.domain.usecase.PeopleUseCase
import com.medieverone.teststarwarsapi.usecases.ImagesUseCaseImpl
import com.medieverone.teststarwarsapi.usecases.PeopleUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun providePeopleUseCase(
        peopleRepository: PeopleRepository
    ): PeopleUseCase {
        return PeopleUseCaseImpl(peopleRepository)
    }

    @Provides
    fun provideImagesUseCase(
        imagesRepository: ImagesRepository
    ): ImagesUseCase {
        return ImagesUseCaseImpl(imagesRepository)
    }
}