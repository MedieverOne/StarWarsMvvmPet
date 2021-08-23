package com.medieverone.teststarwarsapi.usecases

import com.medieverone.data.repositories.ImagesRepository
import com.medieverone.domain.usecase.ImagesUseCase

class ImagesUseCaseImpl(
    val imagesRepository: ImagesRepository
) : ImagesUseCase {

    override suspend fun findImages(
        searchRequest: String,
        pageNumber: Int,
        pageSize: Int,
        autoCorrect: Boolean
    ) = imagesRepository.findImages(
        searchRequest,
        pageNumber,
        pageSize,
        autoCorrect
    )
}