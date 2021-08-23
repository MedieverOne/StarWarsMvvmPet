package com.medieverone.data.interactors.local

import com.medieverone.domain.entities.PeopleEntity

interface PeopleLocalInteractor {

    suspend fun getPeoples(): List<PeopleEntity>

    suspend fun addPeoples(peoples: List<PeopleEntity>)

    suspend fun getPeople(id: Int): PeopleEntity

    suspend fun getPeoplesPage(pageSize: Int, pageIndex: Int): List<PeopleEntity>

    suspend fun getPeopleByName(name: String): PeopleEntity

    suspend fun deletePeoples(peoples: List<PeopleEntity>)

    suspend fun deleteAllPeoples()

    suspend fun deletePeople(people: PeopleEntity)

    suspend fun deletePeopleById(id: Int)
}