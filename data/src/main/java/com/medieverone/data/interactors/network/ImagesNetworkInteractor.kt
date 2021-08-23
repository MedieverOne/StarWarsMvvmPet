package com.medieverone.data.interactors.network

import com.medieverone.data.entities.network.ImageModel

interface ImagesNetworkInteractor {

    suspend fun findImages(
        searchRequest: String,
        pageNumber: Int = 1,
        pageSize: Int = 10,
        autoCorrect: Boolean = true
    ): List<ImageModel>
}