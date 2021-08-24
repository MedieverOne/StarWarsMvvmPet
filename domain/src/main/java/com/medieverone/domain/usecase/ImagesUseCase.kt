package com.medieverone.domain.usecase

import com.medieverone.domain.entities.ImageEntity

interface ImagesUseCase {

    suspend fun findImages(
        searchRequest: String,
        pageNumber: Int = 1,
        pageSize: Int = 10,
        autoCorrect: Boolean = true
    ): List<ImageEntity>

    suspend fun getImageByPersonName(
        name: String
    ): ImageEntity?
}