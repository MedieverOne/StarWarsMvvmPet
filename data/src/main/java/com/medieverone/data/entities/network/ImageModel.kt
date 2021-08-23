package com.medieverone.data.entities.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.medieverone.domain.entities.ImageEntity

data class ImageModel(
    @SerializedName("url")
    @Expose
    val url: String
) {

    fun toDomain(): ImageEntity {
        return ImageEntity(url = url)
    }

    companion object {

        fun fromDomain(imageEntity: ImageEntity): ImageModel {
            return with(imageEntity) {
                ImageModel(url = url)
            }
        }
    }
}