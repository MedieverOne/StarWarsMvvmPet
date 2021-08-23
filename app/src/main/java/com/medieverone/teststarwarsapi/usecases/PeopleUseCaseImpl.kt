package com.medieverone.teststarwarsapi.usecases

import com.medieverone.data.repositories.PeopleRepository
import com.medieverone.domain.usecase.PeopleUseCase

class PeopleUseCaseImpl(
    val peopleRepository: PeopleRepository
) : PeopleUseCase {

    override suspend fun getPeoples() = peopleRepository.getPeoples()

    override suspend fun getPeoplesPage(pageSize: Int, pageIndex: Int) = peopleRepository.getPeoplesPage(pageSize, pageIndex)

    override suspend fun getPeople(id: Int) = peopleRepository.getPeople(id)

}