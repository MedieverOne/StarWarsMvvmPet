package com.medieverone.data.interactors.local

import com.medieverone.domain.entities.ImageEntity

interface ImagesLocalInteractor {

    suspend fun saveImage(name: String, image: ImageEntity)

    suspend fun getImage(name: String): ImageEntity

    suspend fun getImages(): List<ImageEntity>
}