package com.medieverone.data.interactors.local.images

import com.medieverone.data.database.ImagesDatabase
import com.medieverone.data.entities.local.ImageRoomDataEntity
import com.medieverone.data.interactors.local.ImagesLocalInteractor
import com.medieverone.domain.entities.ImageEntity

class ImagesRoomInteractor(
    val database: ImagesDatabase
): ImagesLocalInteractor {

    val db get() = database.imagesDao()

    override suspend fun saveImage(name: String, image: ImageEntity) =
        db.saveImage(ImageRoomDataEntity.fromDomain(name = name, imageEntity = image))

    override suspend fun getImage(name: String) =
        db.getImage(name).toDomain()

    override suspend fun getImages() =
        db.getImages().map {
            it.toDomain()
        }
}