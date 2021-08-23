package com.medieverone.data.entities.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BaseListModel<ItemType> (
    @SerializedName("count")
    @Expose
    val count: Int,
    @SerializedName("next")
    @Expose
    val nextUrl: String?,
    @SerializedName("previous")
    @Expose
    val previousUrl: String?,
    @SerializedName("results")
    @Expose
    val results: List<ItemType>,
    @SerializedName("detail")
    @Expose
    val detail: String? = null
    )