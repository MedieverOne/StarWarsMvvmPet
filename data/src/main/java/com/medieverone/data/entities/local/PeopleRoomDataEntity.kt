package com.medieverone.data.entities.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.medieverone.domain.entities.PeopleEntity

@Entity
data class PeopleRoomDataEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "birth_year") val birthYear: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "height") val height: String,
    @ColumnInfo(name = "home_world_url") val homeWorldUrl: String,
    @ColumnInfo(name = "created") val created: String,
    @ColumnInfo(name = "edited") val edited: String,
    @ColumnInfo(name = "url") val url: String
) {

    fun toDomain(): PeopleEntity {
        return PeopleEntity(
            id = id,
            name = name,
            birthYear = birthYear,
            gender = gender,
            height = height,
            homeWorldUrl = homeWorldUrl,
            created = created,
            edited = edited,
            url = url
        )
    }

    companion object {

        fun fromDomain(peopleEntity: PeopleEntity): PeopleRoomDataEntity {
            with(peopleEntity) {
                return PeopleRoomDataEntity(
                    id = id,
                    name = name,
                    birthYear = birthYear,
                    gender = gender,
                    height = height,
                    homeWorldUrl = homeWorldUrl,
                    created = created,
                    edited = edited,
                    url = url
                )
            }
        }
    }
}