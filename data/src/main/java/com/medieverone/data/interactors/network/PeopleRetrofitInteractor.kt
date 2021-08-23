package com.medieverone.data.interactors.network

import com.medieverone.data.api.PeopleApi

class PeopleRetrofitInteractor(
    private val peopleApi: PeopleApi
) : PeopleNetworkInteractor {

    override suspend fun getPeoples() =
        peopleApi.getPeoples()

    override suspend fun getPeoplesPage(page: Int) =
        peopleApi.getPeoples(page)

    override suspend fun getPeople(id: Int) = peopleApi.getPeople(id)
}