package com.medieverone.teststarwarsapi.usecases

import com.medieverone.data.repositories.PeopleRepository
import com.medieverone.domain.usecase.PeopleUseCase

class PeopleUseCaseImpl(
    val peopleRepository: PeopleRepository
) : PeopleUseCase {

    override suspend fun getPeoples() = peopleRepository.getPeoples()

    override suspend fun getPeoplesPage(page: Int) = peopleRepository.getPeoplesPage(page)

    override suspend fun getPeople(id: Int) = peopleRepository.getPeople(id)

}