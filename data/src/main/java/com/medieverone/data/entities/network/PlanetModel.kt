package com.medieverone.data.entities.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PlanetModel(
    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("climate")
    @Expose
    val climate: String,

    @SerializedName("created")
    @Expose
    val created: String,

    @SerializedName("edited")
    @Expose
    val edited: String,

    @SerializedName("url")
    @Expose
    val url: String
)