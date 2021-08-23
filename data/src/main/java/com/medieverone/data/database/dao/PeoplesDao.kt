package com.medieverone.data.database.dao

import androidx.room.*
import com.medieverone.data.entities.local.PeopleRoomDataEntity

@Dao
interface PeoplesDao {

    @Query("SELECT * FROM peopleroomdataentity")
    suspend fun getAll(): List<PeopleRoomDataEntity>

    @Query("SELECT * FROM peopleroomdataentity WHERE id LIKE :id ")
    suspend fun getPeople(id: Int): PeopleRoomDataEntity

    @Query("SELECT * FROM peopleroomdataentity LIMIT :pageSize OFFSET :pageIndex")
    suspend fun getPeoplesPage(pageSize: Int, pageIndex: Int): List<PeopleRoomDataEntity>

    @Query("SELECT * FROM peopleroomdataentity WHERE name LIKE :name")
    suspend fun findByName(name: String): PeopleRoomDataEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(peoples: List<PeopleRoomDataEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg peoples: PeopleRoomDataEntity)

    @Query("DELETE from peopleroomdataentity")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(people: PeopleRoomDataEntity)

    @Delete
    suspend fun deleteList(peoples: List<PeopleRoomDataEntity>)

    @Delete
    suspend fun deletePeoples(vararg peoples: PeopleRoomDataEntity)

    @Query("DELETE from peopleroomdataentity WHERE id LIKE :id")
    suspend fun deletePeopleById(id: Int)
}