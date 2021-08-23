package com.medieverone.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.medieverone.data.database.dao.PeoplesDao
import com.medieverone.data.entities.local.PeopleRoomDataEntity

@Database(entities = [
    PeopleRoomDataEntity::class
], version = 1)
abstract class StarWarsDatabase : RoomDatabase() {

    abstract fun peoplesDao(): PeoplesDao
}