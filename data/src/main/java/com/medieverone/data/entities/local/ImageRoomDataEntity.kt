package com.medieverone.data.entities.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.medieverone.domain.entities.ImageEntity

@Entity
data class ImageRoomDataEntity(
    @PrimaryKey
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "url")
    val url: String
) {

    fun toDomain(): ImageEntity {
        return ImageEntity(
            url = url
        )
    }

    companion object {

        fun fromDomain(name: String, imageEntity: ImageEntity): ImageRoomDataEntity {
            with(imageEntity) {
                return ImageRoomDataEntity(
                    name = name,
                    url = url
                )
            }
        }
    }
}