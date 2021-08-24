package com.medieverone.data.repositories

import com.medieverone.data.interactors.local.ImagesLocalInteractor
import com.medieverone.data.interactors.network.ImagesNetworkInteractor
import com.medieverone.domain.entities.ImageEntity
import com.medieverone.domain.usecase.ImagesUseCase
import java.lang.Exception

class ImagesRepository(
    val imagesNetworkInteractor: ImagesNetworkInteractor,
    val imagesLocalInteractor: ImagesLocalInteractor
): ImagesUseCase {

    override suspend fun findImages(
        searchRequest: String,
        pageNumber: Int,
        pageSize: Int,
        autoCorrect: Boolean
    ) = imagesNetworkInteractor.findImages(
        searchRequest = searchRequest,
        pageNumber = pageNumber,
        pageSize = pageSize,
        autoCorrect = autoCorrect
    ).map {
        it.toDomain()
    }

    override suspend fun getImageByPersonName(name: String): ImageEntity? {
        return try {
            imagesLocalInteractor.getImage(name)
        } catch (e: Exception) {
            e.printStackTrace()
            val images = imagesNetworkInteractor.findImages(name)
            if (images.isNotEmpty()) {
                images[0].toDomain()
            } else {
                null
            }
        }
    }
}