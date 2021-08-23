package com.medieverone.data.repositories

import android.util.Log
import com.medieverone.data.interactors.network.PeopleNetworkInteractor
import com.medieverone.domain.entities.PeopleEntity
import com.medieverone.domain.usecase.PeopleUseCase
import java.lang.Exception

class PeopleRepository(
    val peopleNetworkInteractor: PeopleNetworkInteractor
) : PeopleUseCase {

    override suspend fun getPeoples(): List<PeopleEntity> {
        return try {
            val networkResponse = peopleNetworkInteractor.getPeoples()
            when {
                networkResponse.isSuccessful -> {
                    networkResponse.body()!!.results.map { it.toDomain() }
                }
                else -> emptyList()
            }
        } catch (exception: Exception) {
            Log.e(TAG, "fail to fetch data")
            emptyList()
        }
    }

    override suspend fun getPeoplesPage(page: Int): List<PeopleEntity> {
        return try {
            val networkResponse = peopleNetworkInteractor.getPeoplesPage(page)
            when {
                networkResponse.isSuccessful -> {
                    networkResponse.body()!!.results.map { it.toDomain() }
                }
                else -> emptyList()
            }
        } catch (exception: Exception) {
            Log.e(TAG, "fail to fetch data")
            emptyList()
        }
    }

    override suspend fun getPeople(id: Int): PeopleEntity {
        return peopleNetworkInteractor.getPeople(id).body()!!.toDomain()
    }

    companion object {

        private const val TAG = "PeopleRepository"
    }

}