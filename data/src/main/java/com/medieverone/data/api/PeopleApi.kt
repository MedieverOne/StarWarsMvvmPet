package com.medieverone.data.api

import com.medieverone.data.entities.network.BaseListModel
import com.medieverone.data.entities.network.PeopleModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PeopleApi {

    @GET("people/")
    suspend fun getPeoples(@Query("page") page: Int = 1): Response<BaseListModel<PeopleModel>>

    @GET("people/{id}")
    suspend fun getPeople(@Path("id") id: Int): Response<PeopleModel>
}