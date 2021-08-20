package com.medieverone.teststarwarsapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.medieverone.domain.entities.PeopleEntity
import com.medieverone.teststarwarsapi.BR
import com.medieverone.teststarwarsapi.databinding.ItemPeopleBinding

class PeoplesPagingAdapter
    : PagedListAdapter<PeopleEntity, PeoplesPagingAdapter.PeoplesPagingViewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeoplesPagingViewHolder {
        val itemBinding = ItemPeopleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeoplesPagingViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PeoplesPagingViewHolder, position: Int) {
        val item = getItem(position)
        holder.dataBinding.setVariable(BR.people, item)
    }


    inner class PeoplesPagingViewHolder(private val binding: ItemPeopleBinding) : RecyclerView.ViewHolder(binding.root) {
        var dataBinding = binding
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PeopleEntity>() {
            // The ID property identifies when items are the same.
            override fun areItemsTheSame(oldItem: PeopleEntity, newItem: PeopleEntity) =
                oldItem.id == newItem.id

            // If you use the "==" operator, make sure that the object implements
            // .equals(). Alternatively, write custom data comparison logic here.
            override fun areContentsTheSame(
                oldItem: PeopleEntity, newItem: PeopleEntity) = oldItem == newItem
        }
    }
}