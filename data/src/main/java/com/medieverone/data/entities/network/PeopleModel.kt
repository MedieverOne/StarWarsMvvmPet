package com.medieverone.data.entities.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.medieverone.domain.entities.PeopleEntity

data class PeopleModel(

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("birth_year")
    @Expose
    val birthYear: String,

    @SerializedName("gender")
    @Expose
    val gender: String,

    @SerializedName("height")
    @Expose
    val height: String,

    @SerializedName("home_world")
    @Expose
    val homeWorldUrl: String?,

    @SerializedName("created")
    @Expose
    val created: String,

    @SerializedName("edited")
    @Expose
    val edited: String,

    @SerializedName("url")
    @Expose
    val url: String
) {

    fun toDomain(): PeopleEntity {
        return PeopleEntity(
            name = name,
            birthYear = birthYear,
            gender = gender,
            height = height,
            homeWorldUrl = homeWorldUrl ?: "",
            created = created,
            edited = edited,
            url = url,
            id = url.substringBeforeLast('/').substringAfterLast('/').toInt()
        )
    }

    companion object {

        fun fromDomain(peopleEntity: PeopleEntity): PeopleModel {
            with(peopleEntity) {
                return PeopleModel(
                    name = name,
                    birthYear = birthYear,
                    gender = gender,
                    height = height,
                    homeWorldUrl = homeWorldUrl,
                    created = created,
                    edited = edited,
                    url = url,
                )
            }
        }
    }

}