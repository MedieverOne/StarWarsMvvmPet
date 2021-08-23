package com.medieverone.data.repositories

import com.medieverone.data.interactors.network.ImagesNetworkInteractor
import com.medieverone.domain.usecase.ImagesUseCase

class ImagesRepository(
    val imagesNetworkInteractor: ImagesNetworkInteractor
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
}