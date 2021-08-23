package com.medieverone.data.repositories

import android.util.Log
import com.medieverone.data.interactors.local.PeopleLocalInteractor
import com.medieverone.data.interactors.network.PeopleNetworkInteractor
import com.medieverone.domain.entities.PeopleEntity
import com.medieverone.domain.usecase.PeopleUseCase
import java.lang.Exception

class PeopleRepository(
    val peopleNetworkInteractor: PeopleNetworkInteractor,
    val peopleLocalInteractor: PeopleLocalInteractor
) : PeopleUseCase {

    override suspend fun getPeoples(): List<PeopleEntity> {
        return try {
            val networkResponse = peopleNetworkInteractor.getPeoples()
            when {
                networkResponse.isSuccessful -> {
                    val response = networkResponse.body()!!.results.map { it.toDomain() }
                    peopleLocalInteractor.addPeoples(response)
                    response
                }
                networkResponse.body()!!.detail == "Not found" -> {
                    emptyList()
                }
                else -> {
                    peopleLocalInteractor.getPeoples()
                }
            }
        } catch (exception: Exception) {
            Log.e(TAG, "fail to fetch data")
            peopleLocalInteractor.getPeoples()
        }
    }

    override suspend fun getPeoplesPage(pageSize: Int, pageIndex: Int): List<PeopleEntity> {
        return try {
            val networkResponse = peopleNetworkInteractor.getPeoplesPage(pageIndex)
            when {
                networkResponse.isSuccessful -> {
                    if (pageIndex > (networkResponse.body()!!.count/pageSize)) {
                        emptyList()
                    } else {
                        peopleLocalInteractor.addPeoples(networkResponse.body()!!.results.map { it.toDomain() })
                        networkResponse.body()!!.results.map { it.toDomain() }
                    }
                }
                else -> {
                    peopleLocalInteractor.getPeoplesPage(pageSize, pageIndex)
                }
            }
        } catch (exception: Exception) {
            Log.e(TAG, "fail to fetch data")
            peopleLocalInteractor.getPeoplesPage(pageSize, pageIndex)
        }
    }

    override suspend fun getPeople(id: Int): PeopleEntity {
        return peopleNetworkInteractor.getPeople(id).body()!!.toDomain()
    }

    companion object {

        private const val TAG = "PeopleRepository"
    }

}