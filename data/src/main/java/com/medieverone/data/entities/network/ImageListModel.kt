package com.medieverone.data.entities.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageListModel(
    @SerializedName("_type")
    @Expose
    val type: String,
    @SerializedName("totalCount")
    @Expose
    val totalCount: Int,
    @SerializedName("value")
    @Expose
    val value: List<ImageModel>
)