package com.medieverone.data.interactors.network

import com.medieverone.data.api.ImagesApi

class ImagesRetrofitInteractor(
    val imagesApi: ImagesApi
): ImagesNetworkInteractor {

    override suspend fun findImages(
        searchRequest: String,
        pageNumber: Int,
        pageSize: Int,
        autoCorrect: Boolean
    ) = imagesApi.findImages(
        searchRequest = searchRequest,
        pageNumber = pageNumber,
        pageSize = pageSize,
        autoCorrect = autoCorrect
    ).value
}