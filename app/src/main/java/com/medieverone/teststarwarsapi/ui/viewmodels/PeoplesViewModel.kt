package com.medieverone.teststarwarsapi.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.medieverone.base_presentation.BaseViewModel
import com.medieverone.domain.entities.ImageEntity
import com.medieverone.domain.entities.PeopleEntity
import com.medieverone.domain.usecase.ImagesUseCase
import com.medieverone.domain.usecase.PeopleUseCase
import com.medieverone.teststarwarsapi.factory.datasource.PeoplesPageKeyedDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class PeoplesViewModel @Inject constructor(
    val peopleUseCase: PeopleUseCase,
    val peoplesPageKeyedDataSource: PeoplesPageKeyedDataSource,
    val imagesUseCase: ImagesUseCase
) : BaseViewModel() {

    private val peoplesData = MutableLiveData<List<PeopleEntity>>()
    lateinit var peoplesLiveData: LiveData<PagedList<PeopleEntity>>


    init {
        val config = PagedList.Config.Builder()
            .setPageSize(PEOPLES_PAGE_SIZE)
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

    @DelicateCoroutinesApi
    fun getImages() {
        job = GlobalScope.launch(Dispatchers.IO) {
            val result = imagesUseCase.findImages("Luke Skywalker")
            result.forEach {
                Log.d("HALO", "url: ${it.url}")
            }
        }
    }

    companion object {

        const val PEOPLES_PAGE_SIZE = 10
    }
}