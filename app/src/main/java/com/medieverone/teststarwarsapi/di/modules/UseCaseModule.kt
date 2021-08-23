package com.medieverone.teststarwarsapi.di.modules

import com.medieverone.data.repositories.PeopleRepository
import com.medieverone.domain.usecase.PeopleUseCase
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
}