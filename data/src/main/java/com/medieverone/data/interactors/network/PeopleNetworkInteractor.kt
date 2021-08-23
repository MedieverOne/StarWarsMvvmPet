package com.medieverone.data.interactors.network

import com.medieverone.data.entities.network.BaseListModel
import com.medieverone.data.entities.network.PeopleModel
import retrofit2.Response

interface PeopleNetworkInteractor {

    suspend fun getPeoples(): Response<BaseListModel<PeopleModel>>

    suspend fun getPeoplesPage(page: Int): Response<BaseListModel<PeopleModel>>

    suspend fun getPeople(id: Int): Response<PeopleModel>
}