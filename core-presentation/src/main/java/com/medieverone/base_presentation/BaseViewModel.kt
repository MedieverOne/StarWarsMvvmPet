package com.medieverone.base_presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

abstract class BaseViewModel: ViewModel() {

    protected var job: Job? = null

    override fun onCleared() {
        super.onCleared()

        if (job != null) {
            job = null
        }
    }
}