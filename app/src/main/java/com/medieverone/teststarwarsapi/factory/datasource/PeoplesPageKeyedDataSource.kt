package com.medieverone.teststarwarsapi.factory.datasource

import androidx.paging.PageKeyedDataSource
import com.medieverone.domain.entities.PeopleEntity
import com.medieverone.domain.usecase.PeopleUseCase
import com.medieverone.teststarwarsapi.ui.viewmodels.PeoplesViewModel.Companion.PEOPLES_PAGE_SIZE
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

class PeoplesPageKeyedDataSource @Inject constructor(
    val coroutineScope: CoroutineScope,
    val peopleStorage: PeopleUseCase
) : PageKeyedDataSource<Int, PeopleEntity>() {


    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, PeopleEntity>
    ) {
        coroutineScope.launch {
            callback.onResult(peopleStorage.getPeoplesPage(PEOPLES_PAGE_SIZE, 1), null, 2)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, PeopleEntity>) {
        coroutineScope.launch {
            val afterPageKey = params.key.plus(1)
            callback.onResult(peopleStorage.getPeoplesPage(PEOPLES_PAGE_SIZE, params.key), afterPageKey)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, PeopleEntity>) {
        coroutineScope.launch {

            callback.onResult(peopleStorage.getPeoplesPage(PEOPLES_PAGE_SIZE, params.key), params.key.plus(1))
        }
    }

    override fun invalidate() {
        super.invalidate()
        coroutineScope.cancel()
    }

}