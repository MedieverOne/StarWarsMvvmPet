package com.medieverone.data.api

import com.medieverone.data.entities.network.ImageListModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ImagesApi {

    @GET("ImageSearchAPI")
    suspend fun findImages(
        @Query("q") searchRequest: String,
        @Query("pageNumber") pageNumber: Int = 1,
        @Query("pageSize") pageSize: Int = 10,
        @Query("autoCorrect") autoCorrect: Boolean = true
    ): ImageListModel
}