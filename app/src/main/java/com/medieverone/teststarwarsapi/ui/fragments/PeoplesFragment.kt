package com.medieverone.teststarwarsapi.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.medieverone.base_presentation.BaseFragment
import com.medieverone.teststarwarsapi.R
import com.medieverone.teststarwarsapi.databinding.FragmentPeoplesBinding
import com.medieverone.teststarwarsapi.di.components.AppComponent
import com.medieverone.teststarwarsapi.ui.viewmodels.PeoplesViewModel
import com.medieverone.teststarwarsapi.ui.adapters.PeoplesPagingAdapter
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
class PeoplesFragment : BaseFragment<FragmentPeoplesBinding, PeoplesViewModel>() {

    @Inject
    override lateinit var viewModelFactory: ViewModelProvider.Factory
    override lateinit var viewModel: PeoplesViewModel
    override val layoutId = R.layout.fragment_peoples
    var peoplesAdapter = PeoplesPagingAdapter()


    init {
        AppComponent.get().screensComponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    override fun getViewModelClass(): Class<PeoplesViewModel> {
        return PeoplesViewModel::class.java
    }

    override fun setupBinding() {
        with(binding) {
            peopleModel = viewModel
            lifecycleOwner = this@PeoplesFragment
            peoplesRecycler.adapter = peoplesAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.getPeoples().observe(viewLifecycleOwner, { pagedList ->
            peoplesAdapter.submitList(pagedList)
        })
    }
}