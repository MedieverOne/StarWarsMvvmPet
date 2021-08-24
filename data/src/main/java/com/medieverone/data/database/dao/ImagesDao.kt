package com.medieverone.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.medieverone.data.entities.local.ImageRoomDataEntity

@Dao
interface ImagesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveImage(image: ImageRoomDataEntity)

    @Query("SELECT * FROM imageroomdataentity WHERE name LIKE :name")
    suspend fun getImage(name: String): ImageRoomDataEntity

    @Query("SELECT * FROM imageroomdataentity")
    suspend fun getImages(): List<ImageRoomDataEntity>
}