package com.medieverone.teststarwarsapi

import com.medieverone.base_presentation.BaseViewModel
import com.medieverone.data.database.StarWarsDatabase
import kotlinx.coroutines.*
import javax.inject.Inject

@DelicateCoroutinesApi
class MainViewModel @Inject constructor(
    val starWarsDatabase: StarWarsDatabase
) : BaseViewModel() {

    fun onRefreshData() {
        job = GlobalScope.launch(Dispatchers.IO) {
            starWarsDatabase.peoplesDao().deleteAll()
        }
    }
}