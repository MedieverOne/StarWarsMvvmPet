package com.medieverone.data.interactors.local

import com.medieverone.data.database.StarWarsDatabase
import com.medieverone.data.entities.local.PeopleRoomDataEntity
import com.medieverone.domain.entities.PeopleEntity

class PeopleRoomInteractor(
    val database: StarWarsDatabase
) : PeopleLocalInteractor {

    private val db get() = database.peoplesDao()

    override suspend fun getPeoples() =
        db.getAll().map {
            it.toDomain()
        }

    override suspend fun getPeoplesPage(pageSize: Int, pageIndex: Int) =
        db.getPeoplesPage(pageSize = pageSize, pageIndex = pageIndex).map {
            it.toDomain()
        }

    override suspend fun addPeoples(peoples: List<PeopleEntity>) =
        db.insertList(peoples.map {
            PeopleRoomDataEntity.fromDomain(it)
        })

    override suspend fun getPeople(id: Int) =
        db.getPeople(id)
            .toDomain()

    override suspend fun getPeopleByName(name: String) =
        db.findByName(name)
            .toDomain()

    override suspend fun deletePeoples(peoples: List<PeopleEntity>) =
        db.deleteList(peoples.map {
            PeopleRoomDataEntity.fromDomain(it)
        })

    override suspend fun deleteAllPeoples() =
        db.deleteAll()

    override suspend fun deletePeople(people: PeopleEntity) =
        db.delete(people = PeopleRoomDataEntity.fromDomain(people))

    override suspend fun deletePeopleById(id: Int) =
        db.deletePeopleById(id = id)
}