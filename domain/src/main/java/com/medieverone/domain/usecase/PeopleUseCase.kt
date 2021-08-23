package com.medieverone.domain.usecase

import com.medieverone.domain.entities.PeopleEntity

interface PeopleUseCase {

    suspend fun getPeoples(): List<PeopleEntity>

    suspend fun getPeoplesPage(page: Int): List<PeopleEntity>

    suspend fun getPeople(id: Int): PeopleEntity
}