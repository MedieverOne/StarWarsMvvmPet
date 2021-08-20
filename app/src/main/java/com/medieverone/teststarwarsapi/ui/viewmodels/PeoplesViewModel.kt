package com.medieverone.teststarwarsapi.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.medieverone.base_presentation.BaseViewModel
import com.medieverone.domain.entities.PeopleEntity
import com.medieverone.domain.usecase.PeopleUseCase
import com.medieverone.teststarwarsapi.factory.datasource.PeoplesPageKeyedDataSource
import javax.inject.Inject

class PeoplesViewModel @Inject constructor(
    val peopleUseCase: PeopleUseCase,
    val peoplesPageKeyedDataSource: PeoplesPageKeyedDataSource
) : BaseViewModel() {

    private val peoplesData = MutableLiveData<List<PeopleEntity>>()
    lateinit var peoplesLiveData: LiveData<PagedList<PeopleEntity>>


    init {
        val config = PagedList.Config.Builder()
            .setPageSize(10)
            .setEnablePlaceholders(false)
            .build()
        peoplesLiveData = initializedPagedListBuilder(config).build()
    }

    fun getPeoples(): LiveData<PagedList<PeopleEntity>> = peoplesLiveData

    private fun initializedPagedListBuilder(config: PagedList.Config)
            : LivePagedListBuilder<Int, PeopleEntity> {
        val dataSourceFactory = object : DataSource.Factory<Int, PeopleEntity>() {
            override fun create(): DataSource<Int, PeopleEntity> {
                return peoplesPageKeyedDataSource
            }
        }
        return LivePagedListBuilder(dataSourceFactory, config)
    }
}